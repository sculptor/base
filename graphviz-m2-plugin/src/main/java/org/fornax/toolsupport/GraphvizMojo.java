/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.toolsupport;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

/**
 * Generates images from graphviz dot files
 * 
 * @goal run
 * @phase generate-resources
 * @author Patrik Nordwall
 */
public class GraphvizMojo extends AbstractMojo {

    /**
     * Dirs to look for dot files in.
     * <p>
     * "${basedir}/src/generated/resources"
     * 
     * @parameter expression="${dotDirs}" default-value=
     *            "src/generated/resources"
     */
    protected String dotDirs;

    /**
     * dot command to execute to generate. Don't include file names, they are
     * handled by the mojo. http://www.graphviz.org/doc/info/command.html
     * <p>
     * "dot -Tpng"
     * 
     * @parameter expression="${dotCmd}" default-value= "dot -Tpng"
     */
    protected String dotCmd;

    /**
     * The Maven project this plugin runs in.
     * 
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     * 
     * Sets the maven project.
     * 
     * 
     * 
     * @param project
     *            the maven project where this plugin runs in.
     */
    public void setProject(MavenProject project) {
        this.project = project;
    }

    /**
     * Returns the maven project.
     * 
     * @return The maven project where this plugin runs in.
     */
    public MavenProject getProject() {
        return project;
    }

    public void execute() throws MojoExecutionException {
        String[] dirs = dotDirs.split(",");
        for (String dirName : dirs) {
            generate(dirName);
        }

    }

    private void generate(String dirName) {
        File dir = new File(dirName.trim());
        if (!dir.exists()) {
            return;
        }
        if (!dir.isDirectory()) {
            return;
        }
        File[] dotFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".dot");
            }
        });
        for (File each : dotFiles) {
            generate(each);
        }
    }

    private void generate(File dotFile) {
        String cmd = dotCmd + " -O " + dotFile.getAbsolutePath();
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            if (cmd.startsWith("dot")) {
                // try once more with typical installation path of dot
                String cmd2 = "/usr/local/bin/" + cmd;
                try {
                    Runtime.getRuntime().exec(cmd2);
                    return;
                } catch (IOException e2) {
                }
            }
            getLog().error(
                    "Problem rendering image for " + dotFile.getName() + " using '" + cmd + "' Error: "
                            + e.getMessage());
            // don't fail
        }
    }
}
