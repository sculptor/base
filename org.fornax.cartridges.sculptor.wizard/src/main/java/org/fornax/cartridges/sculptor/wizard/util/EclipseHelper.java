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
package org.fornax.cartridges.sculptor.wizard.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.fornax.cartridges.sculptor.wizard.PluginLog;

public class EclipseHelper {

    public static IProject createRichClientProject(final String projectName,
            final List<IProject> referencedProjects,
            final Set<String> requiredBundles,
            final IProgressMonitor progressMonitor, final Shell theShell) {
        IProject project = null;
        try {
            progressMonitor.beginTask("", 10);
            progressMonitor.subTask("Creating project " + projectName);
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            project = workspace.getRoot().getProject(projectName);

            // Clean up any old project information.
            if (project.exists()) {
                final boolean[] result = new boolean[1];
                PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
                    public void run() {
                        result[0] = MessageDialog
                                .openQuestion(
                                        theShell,
                                        "Existing project " + projectName + "?",
                                        "Do you want to overwrite the project '"
                                                + projectName
                                                + "' \nNote that everything inside the project '"
                                                + projectName
                                                + "' will be deleted if you confirm this dialog.");
                    }
                });
                if (result[0]) {
                    project.delete(true, true, new SubProgressMonitor(
                            progressMonitor, 1));
                } else {
                    return null;
                }
            }

            IJavaProject javaProject = JavaCore.create(project);
            IProjectDescription projectDescription = ResourcesPlugin
                    .getWorkspace().newProjectDescription(projectName);
            projectDescription.setLocation(null);
            project.create(projectDescription, new SubProgressMonitor(
                    progressMonitor, 1));
            List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
            if (referencedProjects.size() != 0) {
                projectDescription.setReferencedProjects(referencedProjects
                        .toArray(new IProject[referencedProjects.size()]));
                for (IProject referencedProject : referencedProjects) {
                    IClasspathEntry referencedProjectClasspathEntry = JavaCore
                            .newProjectEntry(referencedProject.getFullPath());
                    classpathEntries.add(referencedProjectClasspathEntry);
                }
            }

            projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID,
                    "org.eclipse.pde.PluginNature" });

            ICommand java = projectDescription.newCommand();
            java.setBuilderName(JavaCore.BUILDER_ID);

            ICommand manifest = projectDescription.newCommand();
            manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

            ICommand schema = projectDescription.newCommand();
            schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

            projectDescription.setBuildSpec(new ICommand[] { java, manifest,
                    schema });

            project.open(new SubProgressMonitor(progressMonitor, 1));
            project.setDescription(projectDescription, new SubProgressMonitor(
                    progressMonitor, 1));

            addSrcFolders(progressMonitor, project, classpathEntries);

            classpathEntries.add(JavaCore.newContainerEntry(new Path(
                    "org.eclipse.jdt.launching.JRE_CONTAINER")));
            classpathEntries.add(JavaCore.newContainerEntry(new Path(
                    "org.eclipse.pde.core.requiredPlugins")));

            javaProject.setRawClasspath(classpathEntries
                    .toArray(new IClasspathEntry[classpathEntries.size()]),
                    new SubProgressMonitor(progressMonitor, 1));

            javaProject.setOutputLocation(new Path("/" + projectName
                    + "/target/classes"), new SubProgressMonitor(
                    progressMonitor, 1));
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            progressMonitor.done();
        }

        return project;
    }

    private static void addSrcFolders(final IProgressMonitor progressMonitor,
            IProject project, List<IClasspathEntry> classpathEntries)
            throws CoreException {
        List<String> srcFolders = new ArrayList<String>();
        Set<String> srcClasspath = new HashSet<String>();
        srcFolders.add("src");
        srcFolders.add("src/main");
        srcFolders.add("src/main/java");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));
        srcFolders.add("src/main/resources");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));
        srcFolders.add("src/main/resources/generator");
        srcFolders.add("icons");
        srcFolders.add("src/generated");
        srcFolders.add("src/generated/java");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));
        srcFolders.add("src/generated/resources");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));
        srcFolders.add("src/test");
        srcFolders.add("src/test/java");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));
        srcFolders.add("src/test/resources");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));
        srcFolders.add("src/test/generated");
        srcFolders.add("src/test/generated/java");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));
        srcFolders.add("src/test/generated/resources");
        srcClasspath.add(srcFolders.get(srcFolders.size() - 1));

        for (String src : srcFolders) {
            IFolder srcContainer = project.getFolder(src);
            if (!srcContainer.exists()) {
                srcContainer.create(false, true, new SubProgressMonitor(
                        progressMonitor, 1));
            }
            if (srcClasspath.contains(src)) {
                IClasspathEntry srcClasspathEntry = JavaCore
                        .newSourceEntry(srcContainer.getFullPath());
                classpathEntries.add(0, srcClasspathEntry);
            }
        }
    }

    public static IFile createFile(String name, IContainer container,
            String content, IProgressMonitor progressMonitor) {
        IFile file = container.getFile(new Path(name));
        assertExist(file.getParent());
        try {
            InputStream stream = new ByteArrayInputStream(content.getBytes(file
                    .getCharset()));
            if (file.exists()) {
                file.setContents(stream, true, true, progressMonitor);
            } else {
                file.create(stream, true, progressMonitor);
            }
            stream.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        progressMonitor.worked(1);

        return file;
    }

    /**
     * @param name
     *            of the destination file
     * @param container
     *            directory containing the the destination file
     * @param contentUrl
     *            Url pointing to the src of the content
     * @param progressMonitor
     *            used to interact with and show the user the current operation
     *            status
     * @return
     */
    public static IFile createFile(String name, IContainer container,
            URL contentUrl, IProgressMonitor progressMonitor) {

        IFile file = container.getFile(new Path(name));
        InputStream inputStream = null;
        try {
            inputStream = contentUrl.openStream();
            if (file.exists()) {
                file.setContents(inputStream, true, true, progressMonitor);
            } else {
                file.create(inputStream, true, progressMonitor);
            }
            inputStream.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    PluginLog.logError(e);
                }
            }
        }
        progressMonitor.worked(1);

        return file;
    }

    private static void assertExist(IContainer c) {
        if (!c.exists()) {
            if (!c.getParent().exists()) {
                assertExist(c.getParent());
            }
            if (c instanceof IFolder) {
                try {
                    ((IFolder) c)
                            .create(false, true, new NullProgressMonitor());
                } catch (CoreException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }

        }

    }

    public static void openFileToEdit(Shell s, final IFile file) {
        s.getDisplay().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench()
                        .getActiveWorkbenchWindow().getActivePage();
                try {
                    IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        });
    }
}
