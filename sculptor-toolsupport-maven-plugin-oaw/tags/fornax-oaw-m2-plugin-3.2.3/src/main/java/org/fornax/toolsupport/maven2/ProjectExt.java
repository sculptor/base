package org.fornax.toolsupport.maven2;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;
import org.codehaus.classworlds.ClassRealm;

/**
 * Ant's {@link AntClassLoader} is incredible inperformant in non-forked mode.
 * We need to load classes directly from the plugin's ClassRealm.
 * @author Karsten Thoms
 *
 */
public class ProjectExt extends Project {
	private AntClassLoaderExt classloader;
	private ClassRealm realm;
	private boolean forked;
	public ProjectExt (ClassRealm realm) {
		this.realm = realm;
	}
	@Override
	public AntClassLoader createClassLoader(ClassLoader parent, Path path) {
		classloader = new AntClassLoaderExt(parent, this, path);
		return classloader;
	}
	@Override
	public AntClassLoader createClassLoader(Path path) {
		classloader = new AntClassLoaderExt(getClass().getClassLoader(), this, path);
		return classloader;
	}

	public void setFork (boolean fork) {
		this.forked = fork;
	}

	private class AntClassLoaderExt extends AntClassLoader {

		public AntClassLoaderExt(ClassLoader parent, Project project, Path classpath) {
			super(parent, project, classpath);
		}

		@SuppressWarnings("rawtypes")
		@Override
		protected synchronized Class loadClass(String classname, boolean resolve) throws ClassNotFoundException {
	        // 'sync' is needed - otherwise 2 threads can load the same class
	        // twice, resulting in LinkageError: duplicated class definition.
	        // findLoadedClass avoids that, but without sync it won't work.

	        Class theClass = findLoadedClass(classname);
	        if (theClass != null) {
	            return theClass;
	        }

	        if (!forked) { // KTH changed
	            try {
	                theClass = realm.loadClass(classname);
	                log("Class " + classname + " loaded from class realm "
	                    , Project.MSG_DEBUG);
	            } catch (ClassNotFoundException cnfe) {
	                theClass = findClass(classname);
	            }
	        } else {
	        	theClass = super.loadClass(classname, resolve);
	        }

	        return theClass;
		}
	}
};

