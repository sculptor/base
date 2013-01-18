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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

/**
 * Checksum generator and validator. Based on Hiram Chirino servicemix ChecksumValidator.
 *
 * @requiresDependencyResolution
 * @goal run
 * @phase clean
 * @author Pavel Tavoda
 */
public class ChecksumValidatorMojo extends AbstractMojo {

	private static final String BEFORE_GENERATE = "before-generate";
	private static final String AFTER_GENERATE = "after-generate";

	static char hexTable[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * Dirs which are checked.
	 *
	 * "${basedir}/src/main/java,${basedir}/src/main/resources,${basedir}/src/test/java,${basedir}/src/test/resources"
	 *
	 * @parameter expression="${checksumDirs}" default-value="src/main/java,src/main/resources,src/test/java,src/test/resources"
	 */
	protected String checksumDirs;

	/**
	 * The file that holds checksums.
	 *
	 * @parameter default-value=".checksum.txt"
	 */
	protected String checksumFile;

	/**
	 * The file that holds checksum exceptions.
	 *
	 * @parameter expression="${ignoreChecksumFile}" default-value=".ignore-checksum.txt"
	 */
	protected String ignoreChecksumFile;

	/**
	 * The checksum algorithm used to in the checksums.
	 *
	 * @parameter default-value="SHA-1"
	 */
	private String checksumAlgorithm;

	/**
	 * Should we generate the checksum file instead of validating against it?
	 *
	 * @parameter expression="${action}" default-value="clean"
	 */
	protected String action;

	/**
     * Ignore directories. Comma separated.
     *
     * @parameter expression="${ignoreDirectories}" default-value=".svn"
     */
    protected String ignoreDirectories;

    private Set<String> ignoreDirectoriesSet;

	/**
     * The Maven project this plugin runs in.
     *
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;


    /**

     * Sets the maven project.

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
        initIgnoreDirectoriesSet();

		if (action.equals(AFTER_GENERATE)) {
			getLog().info("ChecksumValidator: GENERATE CHECKSUMS");
			generate();
		} else if (action.equals(BEFORE_GENERATE)) {
			getLog().info("ChecksumValidator: BEFORE GENERATION");
			beforeGenerate();
		} else {
			getLog().info("ChecksumValidator: CLEANUP");
			FileStoreUtils.storeIgnoreFile(clean(), project.getBasedir(), ignoreChecksumFile);
		}
	}

    private void initIgnoreDirectoriesSet() {
        ignoreDirectoriesSet = new HashSet<String>();
        if (ignoreDirectories == null) {
            return;
        }
        ignoreDirectoriesSet.addAll(Arrays.asList(ignoreDirectories.split(",")));
        getLog().info("Ignoring directories: " + ignoreDirectoriesSet);
    }

	public ArrayList<String> clean() throws MojoExecutionException {
		HashMap<String, String> checksums = FileStoreUtils.loadChecksums(project.getBasedir(), checksumFile, getLog());
		ArrayList<String> ignoreFiles = FileStoreUtils.loadIgnoreFile(project.getBasedir(), ignoreChecksumFile, getLog());

		for (Iterator<String> keyIterator=checksums.keySet().iterator(); keyIterator.hasNext();) {
			String file=keyIterator.next();
			boolean ignore=false;
			for (int i = 0; i < ignoreFiles.size(); i++) {
				if (!ignoreFiles.get(i).startsWith("#")
						&& ignoreFiles.get(i).length() > 5
						&& file.startsWith(ignoreFiles.get(i))) {
					ignore=true;
					break;
				}
			}

			if (!ignore) {
				String checksum=checksums.get(file);
				File investigateFile=new File(project.getBasedir(), file);
				if (investigateFile.canRead()) {
					String realChecksum = checksum(investigateFile);
					if (checksum.equals(realChecksum)) {
						getLog().info("Removing untouched file "+file);
						try {
							investigateFile.delete();
							FileStoreUtils.removeEmptyDirs(investigateFile);
						} catch (Throwable th) {
						}
					} else {
						ignoreFiles.add(file);
					}
				}
			}
		}

		return ignoreFiles;
	}

	private void beforeGenerate() throws MojoExecutionException {
		ArrayList<String> ignoreFiles=clean();

		if (FileStoreUtils.isBeforeInstallFlag()) {
			getLog().info("!!! CLEANING AFTER UNSUCCESSFULL GENERATE !!!");
			String[] checkDirs=checksumDirs.split("[,;:]");
			for (int i=0; i < checkDirs.length; i++) {
				recursiveDelete(new File(project.getBasedir(), checkDirs[i]), ignoreFiles);
			}
		} else {
			String[] checkDirs=checksumDirs.split("[,;:]");
			for (int i=0; i < checkDirs.length; i++) {
				addRecursiveIgnoreFiles(new File(project.getBasedir(), checkDirs[i]), ignoreFiles);
			}
			FileStoreUtils.storeIgnoreFile(ignoreFiles, project.getBasedir(), ignoreChecksumFile);
			FileStoreUtils.setBeforeInstallFlag();

			// delete content of checksum file
			FileStoreUtils.storeChecksums(new HashMap<String, String>(), project.getBasedir(), checksumFile);
		}
	}

	private void recursiveDelete(File file, ArrayList<String> ignoreFiles) throws MojoExecutionException {
		if (file.isDirectory()) {
		    if (ignoreDirectoriesSet.contains(file.getName())) {
                return;
            }
			File[] listFiles = file.listFiles();
			for (int i=0; i < listFiles.length; i++) {
				recursiveDelete(listFiles[i], ignoreFiles);
				FileStoreUtils.removeEmptyDirs(file.getParentFile());
			}
		} else if (file.isFile()) {
			boolean ignore=false;
			for (int i=0; i < ignoreFiles.size(); i++) {
				if (!ignoreFiles.get(i).startsWith("#")
						&& ignoreFiles.get(i).length() > 5
						&& getRelativePath(file).startsWith(ignoreFiles.get(i))) {
					ignore=true;
					break;
				}
			}
			if (!ignore) {
				if (!file.delete()) {
					throw new MojoExecutionException("Can't delete file: "+getRelativePath(file));
				}
			}
		} else if (file.exists()) {
			throw new MojoExecutionException("Can't recognize file: "+getRelativePath(file));
		}
	}

	private void addRecursiveIgnoreFiles(File file, ArrayList<String> ignoreFiles) throws MojoExecutionException {
		if (file.isDirectory()) {
		    if (ignoreDirectoriesSet.contains(file.getName())) {
                return;
            }
			File[] listFiles = file.listFiles();
			for (int i=0; i < listFiles.length; i++) {
				addRecursiveIgnoreFiles(listFiles[i], ignoreFiles);
			}
		} else if (file.isFile()) {
			boolean ignore=false;
			String path=getRelativePath(file);
			for (int i=0; i < ignoreFiles.size(); i++) {
				if (!ignoreFiles.get(i).startsWith("#")
						&& ignoreFiles.get(i).length() > 5
						&& path.startsWith(ignoreFiles.get(i))) {
					ignore=true;
					break;
				}
			}
			if (!ignore) {
				ignoreFiles.add(path);
			}
		} else if (file.exists()) {
			throw new MojoExecutionException("Can't recognize file: "+getRelativePath(file));
		}
	}

	private void generate() throws MojoExecutionException {
		HashMap<String, String> checksums = new HashMap<String, String>();
		ArrayList<String> ignoreFiles = FileStoreUtils.loadIgnoreFile(project.getBasedir(), ignoreChecksumFile, getLog());

		String[] checkDirs=checksumDirs.split("[,;:]");
		for (int i=0; i < checkDirs.length; i++) {
			makeRecursiveChecksums(new File(project.getBasedir(), checkDirs[i]), checksums, ignoreFiles);
		}
		FileStoreUtils.storeChecksums(checksums, project.getBasedir(), checksumFile);
		FileStoreUtils.deleteBeforeInstall();
	}

	private void makeRecursiveChecksums(File dir, HashMap<String, String> checksums, ArrayList<String> ignoreFiles) throws MojoExecutionException {
		if (dir.isDirectory()) {
		    if (ignoreDirectoriesSet.contains(dir.getName())) {
                return;
            }
			File[] listFiles = dir.listFiles();
			for (int i=0; i < listFiles.length; i++) {
				makeRecursiveChecksums(listFiles[i], checksums, ignoreFiles);
			}
		} else if (dir.isFile()) {
			String path = getRelativePath(dir);
			boolean ignore=false;
			for (int i=0; i < ignoreFiles.size(); i++) {
				if (!ignoreFiles.get(i).startsWith("#")
						&& ignoreFiles.get(i).length() > 5
						&& path.startsWith(ignoreFiles.get(i))) {
					ignore=true;
					break;
				}
			}
			if (ignore) {
				checksums.remove(path);
			} else {
				String realChecksum=checksum(dir);
				String oldChecksum=checksums.get(dir);
				// Never overwrite checksum - clean task with aggresive option care about it
				// and have to be started ALWAYS before generation
				if (oldChecksum==null) {
					checksums.put(path, realChecksum);
				}
			}
		} else {
			throw new MojoExecutionException("Can't checksum file: "+getRelativePath(dir));
		}
	}

	protected String checksum(File file) throws MojoExecutionException {
		try {
			MessageDigest md = MessageDigest.getInstance(checksumAlgorithm);
			FileInputStream is = null;
			try {
				is = new FileInputStream(file);
				byte buffer[] = new byte[1024 * 4];
				int c;
				while ((c = is.read(buffer)) >= 0) {
					md.update(buffer, 0, c);
				}
				byte[] digest = md.digest();

				return digestToString(digest);
			} catch (IOException e) {
				throw new MojoExecutionException("Could not read files in: " + checksumDirs);
			} finally {
				try {
					is.close();
				} catch (Throwable e) {
				}
			}

		} catch (NoSuchAlgorithmException e) {
			throw new MojoExecutionException("Invalid checksum algorithm: "
					+ checksumAlgorithm, e);
		}
	}

	private String getRelativePath(File file) {
		String path = file.getAbsolutePath();
		String prefix = project.getBasedir().getAbsolutePath();
		if (path.startsWith(prefix)) {
			path=path.substring(prefix.length()+1);
		}

		return path;
	}

	private String digestToString(byte[] digest) {
		StringBuilder rc = new StringBuilder(digest.length*2);
		for (int i = 0; i < digest.length; i++) {
			rc.append( hexTable[ ((digest[i]>>4) & 0x0F) ] ) ;
			rc.append( hexTable[ (digest[i] & 0x0F) ] ) ;
		}
		return rc.toString();
	}
}


/* ############################################################################################
 * File storing and loading
 * ############################################################################################ */
class FileStoreUtils {
	private static final String BEFORE_INSTALL=".beforeInstallFlag";
	private static final String NEW_FILE_EXT=".new";

	public static void setBeforeInstallFlag() throws MojoExecutionException {
		File beforeInstallFile=new File(BEFORE_INSTALL);
		try {
			if (!beforeInstallFile.exists()) {
				if (!beforeInstallFile.createNewFile()) {
					throw new MojoExecutionException("Can't create file '"+BEFORE_INSTALL+"'");
				}
			}
		} catch (IOException ioe) {
			throw new MojoExecutionException("Can't create file '"+BEFORE_INSTALL+"': "+ioe.getMessage());
		}
	}

	public static boolean isBeforeInstallFlag() throws MojoExecutionException {
		File beforeInstallFile=new File(BEFORE_INSTALL);

		return beforeInstallFile.exists();
	}

	public static void deleteBeforeInstall() throws MojoExecutionException {
		File beforeInstallFile=new File(BEFORE_INSTALL);

		if (beforeInstallFile.exists()) {
			if (!beforeInstallFile.delete()) {
				throw new MojoExecutionException("Can't delete file '"+BEFORE_INSTALL+"'");
			}
		}
	}

	/**
	 * Remove empty directories
	 *
	 * @param dir
	 */
	public static void removeEmptyDirs(File dir) {
		if (dir != null) {
			if (!dir.isDirectory()) {
				dir=dir.getParentFile();
			}

			if (dir.isDirectory()) {
				File[] listFiles = dir.listFiles();
				if (listFiles.length == 0) {
					dir.delete();
					removeEmptyDirs(dir.getParentFile());
				}
			}
		}
	}

	/**
	 * Load checksum from file specified as checksumFile.
	 *
	 * @return checksum HashMap
	 * @throws MojoExecutionException
	 */
	public static HashMap<String, String> loadChecksums(File dir, String checksumFile, Log log) throws MojoExecutionException {
		HashMap<String, String> checkMap = new HashMap<String, String>();

		File chksumFile=beforeRead(dir, checksumFile);
		if( !chksumFile.canRead() ) {
			log.info("Could not read checksum file: "+chksumFile.getPath());
			return checkMap;
		}

		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(chksumFile));
			String line;
			while ((line = reader.readLine()) != null) {
				if( !line.startsWith("#") ) {
					String[] splitLine = line.split(":");
					if (splitLine.length == 2) {
						checkMap.put(splitLine[1], splitLine[0]);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			log.info("Could not load checksum file: "+chksumFile.getPath());
		} finally {
			try {
				reader.close();
			} catch (Throwable e) {
			}
		}

		return checkMap;
	}

	/**
	 * Store checksum to file specified as checksumFile.
	 *
	 * @param checksum HashMap
	 * @throws MojoExecutionException
	 */
	public static void storeChecksums(HashMap<String, String> checksum, File dir, String checksumFile) throws MojoExecutionException {
		PrintWriter writer=null;
		String outputFileName=dir+"/"+checksumFile+NEW_FILE_EXT;
		try {
			writer=new PrintWriter(outputFileName);

			writer.println("# Check sum file");
			writer.println("# Entries are in the following format: checksum:file\n");

			for (Iterator<String> iterator = checksum.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				String value = checksum.get(key);
				if( value != null && value.length() != 0 ) {
					writer.println(value+":"+key);
				}
			}
		} catch (Throwable e) {
			throw new MojoExecutionException("Could not write checksum file: "+outputFileName);
		} finally {
			try {
				writer.close();
			} catch (Throwable ignore) {
			}
		}

		afterWrite(dir, checksumFile);
	}

	/**
	 * Load ignored files from file specified as ignoreChecksumFile.
	 *
	 * @return checksum HashMap
	 * @throws MojoExecutionException
	 */
	public static ArrayList<String> loadIgnoreFile(File dir, String ignoreChecksumFile, Log log) throws MojoExecutionException {
		ArrayList<String> ignoreArray = new ArrayList<String>();

		File ignChksumFile=beforeRead(dir, ignoreChecksumFile);
		if( !ignChksumFile.canRead() ) {
			log.info("Could not read ignore file: "+ignChksumFile.getPath());
			return ignoreArray;
		}

		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(ignChksumFile));
			String line;
			while ((line = reader.readLine()) != null) {
				if( !line.startsWith("#") && line.length() > 5) {
					ignoreArray.add(line);
				}
			}
		} catch (IOException e) {
			log.info("Could not load ignore file: "+ignChksumFile.getPath());
		} finally {
			try {
				reader.close();
			} catch (Throwable e) {
			}
		}

		return ignoreArray;
	}

	/**
	 * Store ignored files to file specified as ignoreChecksumFile.
	 *
	 * @param ignoreFiles
	 * @throws MojoExecutionException
	 */
	public static void storeIgnoreFile(ArrayList<String> ignoreFiles, File dir, String ignoreChecksumFile) throws MojoExecutionException {
		File newIgnoreFile=new File(dir, ignoreChecksumFile+NEW_FILE_EXT);
		PrintWriter writer=null;
		try {
			writer=new PrintWriter(newIgnoreFile);
			writer.println("#\n# Ignore file, holdind file names which can't be removed anymore\n#\n");

			for (Iterator<String> iterator = ignoreFiles.iterator(); iterator.hasNext();) {
				writer.println(iterator.next());
			}
		} catch (IOException e) {
			throw new MojoExecutionException("storeIgnoreFile: Could not write new ignore file: "+newIgnoreFile.getPath());
		} finally {
			try {
				writer.close();
			} catch (Throwable e) {
			}
		}

		afterWrite(dir, ignoreChecksumFile);
	}

	private static File beforeRead(File dir, String fileName) throws MojoExecutionException {
		File newFile=new File(dir, fileName+NEW_FILE_EXT);
		File currFile=new File(dir, fileName);

		try {
			if (currFile.exists() && newFile.exists()) {
				if (!newFile.delete()) {
					throw new MojoExecutionException("Can't delete file '"+newFile.getPath()+"'");
				}
			} else if (!currFile.exists() && newFile.exists()) {
				if (!newFile.renameTo(currFile)) {
					throw new MojoExecutionException("Can't make backup copy of '"+newFile.getPath()+"'");
				}
			} else if (!currFile.exists()) {
				// We have to ensure that file exist
				if (!currFile.createNewFile()) {
					throw new MojoExecutionException("Can't create '"+currFile.getPath()+"'");
				}
			}
		} catch (MojoExecutionException mojoEx) {
			// Re-throw exception
			throw mojoEx;
		} catch (Throwable th) {
			throw new MojoExecutionException("Handling backup files of '"+newFile.getPath()+"' raises: "+th.getMessage());
		}
		return currFile;
	}

	private static void afterWrite(File dir, String fileName) throws MojoExecutionException {
		File newFile=new File(dir, fileName+NEW_FILE_EXT);
		File curFile=new File(dir, fileName);

		try {
			if (newFile.exists() && curFile.exists()) {
				if (!curFile.delete()) {
					throw new MojoExecutionException("Could not delete backup file '"+curFile.getPath()+"'");
				}
				if (!newFile.renameTo(curFile)) {
					throw new MojoExecutionException("Could not rename '"+newFile.getPath()+"' to '"+curFile.getPath()+"'");
				}
			} else {
				throw new MojoExecutionException("No backup file'"+curFile.getPath()+"'");
			}
		} catch (MojoExecutionException mojoEx) {
			// Re-throw exception
			throw mojoEx;
		} catch (Throwable th) {
			throw new MojoExecutionException("Secure rename error: "+th.getMessage());
		}
	}
}
