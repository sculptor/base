/*
 * Copyright 2007 The Fornax Project Team, including the original 
 * author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.cartridges.sculptor.wizard.richclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.fornax.cartridges.sculptor.wizard.Activator;
import org.fornax.cartridges.sculptor.wizard.PluginLog;
import org.fornax.cartridges.sculptor.wizard.PomParser;
import org.fornax.cartridges.sculptor.wizard.util.EclipseHelper;
import org.fornax.cartridges.sculptor.wizard.util.ResourceHelper;

public class RichClientProjectWizard extends Wizard implements INewWizard {
    private RichClientProjectWizardPage page;
    private ISelection selection;

    public RichClientProjectWizard() {
        setNeedsProgressMonitor(true);
    }

    @Override
    public void addPages() {
        page = new RichClientProjectWizardPage(selection);
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        final ProjectInfo pi = page.getProjectInfo();
        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(pi, monitor);
                } finally {
                    monitor.done();
                }
            }
        };
        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), "Error", realException.getMessage());
            return false;
        }
        return true;
    }

    void doFinish(final ProjectInfo pi, IProgressMonitor monitor) {
        new UIJob("Creating rich client projects...") {
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                try {
                    new ProjectCreator(pi).run(monitor);
                } catch (InvocationTargetException e) {
                    PluginLog.logError(e);
                } catch (InterruptedException e) {
                    PluginLog.logError(e);
                }
                return Status.OK_STATUS;
            }

        }.schedule();

    }

    public class ProjectCreator extends WorkspaceModifyOperation {
        ProjectInfo pi;
        private final String templateRoot;

        public ProjectCreator(ProjectInfo pi) {
            this.pi = pi;
            templateRoot = "/" + getClass().getPackage().getName().replace('.', '/') + "/";
        }

        @Override
        protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
                InterruptedException {
            try {
                monitor.beginTask("Creating project " + pi.getProjectName(), 2);

                IProject project = createProject(monitor);
                if (project == null) {
                    return;
                }

                PomParser bizPom = parseBizPom();
                createWorkflow(project, monitor);
                IFile fileToOpen = createGuidesign(project, monitor);
                createGeneratorProperties(project, monitor, bizPom);
                createSpecialCasesXpt(project, monitor);
                createSpecialCasesExt(project, monitor);
                createBuildProperties(project, monitor, bizPom);
                createPom(project, monitor, bizPom);
                createManifest(project, monitor, bizPom);
                createSpringHandlers(project, monitor);
                createSpringSchemas(project, monitor);

                createIcons(project, monitor);

                openFile(monitor, fileToOpen);
                monitor.worked(1);

            } catch (final RuntimeException e) {
                PluginLog.logError(e);
                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        String message = "Problem when creating rich client project: " + e.getMessage();
                        IStatus status = PluginLog.createStatus(IStatus.ERROR, IStatus.CANCEL, e.getMessage(), e);
                        ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Rich client project wizard",
                                message, status);
                    }
                });
            }

        }

        private void openFile(IProgressMonitor monitor, IFile fileToOpen) {
            monitor.setTaskName("Opening file for editing...");
            BasicNewResourceWizard.selectAndReveal(fileToOpen, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
            EclipseHelper.openFileToEdit(getShell(), fileToOpen);
        }

        private IProject createProject(IProgressMonitor monitor) {
            Set<String> refs = new HashSet<String>();
            refs.add("org.eclipse.ui");
            refs.add("org.eclipse.core.runtime");
            refs.add("org.eclipse.core.resources");
            refs.add("org.eclipse.ui.ide");
            refs.add("org.eclipse.jdt.core");

            IProject project = EclipseHelper.createRichClientProject(pi.getProjectId(),
                    Collections.<IProject> emptyList(), refs, monitor, getShell());
            monitor.worked(1);
            return project;
        }

        private void createIcons(IProject project, IProgressMonitor monitor) {
            IFolder iconsFolder = (IFolder) project.findMember("icons");

            List<String> icons = new ArrayList<String>();
            icons.add("clear.gif");
            icons.add("collapse_all.gif");
            icons.add("refresh.gif");
            icons.add("list_view.png");
            icons.add("main_view.png");
            icons.add("product.gif");
            icons.add("table_choose_col.gif");
            icons.add("table_copy.gif");
            icons.add("table_optimize.gif");
            icons.add("table_search.gif");
            icons.add("window_icon.png");
            icons.add("module_folder.png");
            icons.add("domain_object_folder.png");
            icons.add("domain_object.png");
            icons.add("error_node.png");

            for (String each : icons) {
                EclipseHelper.createFile(each, iconsFolder, getIconEntry("icons/richclient/" + each), monitor);
            }

            EclipseHelper.createFile("splash.bmp", project, getIconEntry("icons/richclient/splash.bmp"), monitor);
        }

        private URL getIconEntry(String icon) {
            URL entry = Activator.getDefault().getBundle().getEntry(icon);
            if (entry == null) {
                throw new MissingResourceException("Missing icon: " + icon, icon, "");
            }
            return entry;
        }

        private IFile createWorkflow(IProject project, IProgressMonitor monitor) {
            IFolder generatorFolder = (IFolder) project.findMember("src/main/resources/generator");
            String wf = ResourceHelper.content(templateRoot + "GuiWorkflow.mwe2");
            return EclipseHelper.createFile("GuiWorkflow.mwe2", generatorFolder, wf, monitor);
        }

        private IFile createGuidesign(IProject project, IProgressMonitor monitor) {
            IFolder resourceFolder = (IFolder) project.findMember("src/main/resources");
            String modelTemplate = ResourceHelper.content(templateRoot + "model.guidesign");
            String path = "platform:/resource/" + pi.getBusinessProjectId() + "/src/main/resources/model.btdesign";
            String model = String.format(modelTemplate, path, pi.getProjectName().replace(" ", ""),
                    resolveBusinessAppName());
            return EclipseHelper.createFile("model.guidesign", resourceFolder, model, monitor);
        }

        private IFile createGeneratorProperties(IProject project, IProgressMonitor monitor, PomParser bizPom) {
            IFolder generatorFolder = (IFolder) project.findMember("src/main/resources/generator");
            String genPropsTemplate = ResourceHelper.content(templateRoot + "sculptor-gui-generator.properties");
            String bizClientJar = "lib/" + bizPom.getArtifactId() + "-client.jar";
            String genProps = String.format(genPropsTemplate, bizClientJar, bizPom.getArtifactId() + "-ear");
            return EclipseHelper.createFile("sculptor-gui-generator.properties", generatorFolder, genProps, monitor);
        }

        private IFile createSpecialCasesXpt(IProject project, IProgressMonitor monitor) {
            String specialCases = ResourceHelper.content(templateRoot + "RichClientSpecialCases.xpt");
            IFolder generatorFolder = (IFolder) project.findMember("src/main/resources/generator");
            return EclipseHelper.createFile("RichClientSpecialCases.xpt", generatorFolder, specialCases, monitor);
        }

        private IFile createSpecialCasesExt(IProject project, IProgressMonitor monitor) {
            String specialCases = ResourceHelper.content(templateRoot + "RichClientSpecialCases.ext");
            IFolder generatorFolder = (IFolder) project.findMember("src/main/resources/generator");
            return EclipseHelper.createFile("RichClientSpecialCases.ext", generatorFolder, specialCases, monitor);
        }

        private IFile createBuildProperties(IProject project, IProgressMonitor monitor, PomParser bizPom) {
            String buildPropsTemplate = ResourceHelper.content(templateRoot + "build.properties");
            String bizClientJar = "lib/" + bizPom.getArtifactId() + "-client.jar";
            String buildProps = String.format(buildPropsTemplate, bizClientJar);
            return EclipseHelper.createFile("build.properties", project, buildProps, monitor);
        }

        private IFile createPom(IProject project, IProgressMonitor monitor, PomParser bizPom) throws CoreException {
            String pomTemplate = ResourceHelper.content(templateRoot + "pom.xml");
            String pom = String.format(pomTemplate, bizPom.getGroupId(), bizPom.getParentArtifactId(),
                    bizPom.getVersion(), pi.getProjectId(), bizPom.getArtifactId());
            return EclipseHelper.createFile("pom.xml", project, pom, monitor);
        }

        private PomParser parseBizPom() throws CoreException {

            PomParser bizPom = new PomParser(parseFileContent("pom.xml"));
            return bizPom;
        }

        private String resolveBusinessAppName() {
            String name = "replaceMeWithBusinessProjectApplicationName";

            try {
                String modelDesignContent = parseFileContent("src/main/resources/model.btdesign");
                name = modelDesignContent.substring(modelDesignContent.indexOf("Application ") + 12,
                        modelDesignContent.indexOf("{")).trim();
            } catch (Exception e) {
                // TODO : some logging or feedback to user...?
                System.out.println(e.getMessage());
            }
            return name;
        }

        private String parseFileContent(String fileName) throws CoreException {
            // TODO we should use the project path instead of its name, but
            // don't know how to do that
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IProject bizProj = workspace.getRoot().getProject(pi.getBusinessProjectId());
            IFile bizFile = bizProj.getFile(fileName);
            if (!bizFile.exists()) {
                throw new RuntimeException("Missing " + fileName + " in business tier project: " + bizFile);
            }
            BufferedReader bizReader;
            try {
                bizReader = new BufferedReader(new InputStreamReader(bizFile.getContents(), bizFile.getCharset()));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            return ResourceHelper.content(bizReader);

        }

        private IFile createManifest(IProject project, IProgressMonitor monitor, PomParser bizPom) {
            String manifestTemplate = ResourceHelper.content(templateRoot + "MANIFEST.MF");
            String bizClientJar = "lib/" + bizPom.getArtifactId() + "-client.jar";
            String manifest = String.format(manifestTemplate, pi.getProjectName(), pi.getProjectId(), bizClientJar);
            IFolder metaInf = project.getFolder("META-INF");
            return EclipseHelper.createFile("MANIFEST.MF", metaInf, manifest, monitor);
        }

        private IFile createSpringHandlers(IProject project, IProgressMonitor monitor) {
            IFolder metaInf = project.getFolder("META-INF");
            String springHandlers = ResourceHelper.content(templateRoot + "spring.handlers");
            return EclipseHelper.createFile("spring.handlers", metaInf, springHandlers, monitor);
        }

        private IFile createSpringSchemas(IProject project, IProgressMonitor monitor) {
            IFolder metaInf = project.getFolder("META-INF");
            String springSchemas = ResourceHelper.content(templateRoot + "spring.schemas");
            return EclipseHelper.createFile("spring.schemas", metaInf, springSchemas, monitor);
        }
    }

    /**
     * We will accept the selection in the workbench to see if we can initialize
     * from it.
     * 
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }
}