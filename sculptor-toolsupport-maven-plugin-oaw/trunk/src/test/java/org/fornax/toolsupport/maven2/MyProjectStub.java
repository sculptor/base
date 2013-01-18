package org.fornax.toolsupport.maven2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.maven.model.Build;
import org.apache.maven.model.Model;
import org.apache.maven.model.Resource;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.testing.stubs.MavenProjectStub;
import org.codehaus.plexus.util.ReaderFactory;

@SuppressWarnings("rawtypes")
public class MyProjectStub extends MavenProjectStub {

	/**
	 * Default constructor
	 */
	public MyProjectStub(File pom) {
		MavenXpp3Reader pomReader = new MavenXpp3Reader();
		Model model;

		File basedir = pom.getParentFile();
		setBasedir(basedir);
		try {
			model = pomReader.read(ReaderFactory.newXmlReader(pom));
			setModel(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		setGroupId(model.getGroupId());
		setArtifactId(model.getArtifactId());
		setVersion(model.getVersion());
		setName(model.getName());
		setUrl(model.getUrl());
		setPackaging(model.getPackaging());

		Build build = model.getBuild();
		build.setFinalName(model.getArtifactId());
		build.setDirectory(basedir + "/target");
		build.setSourceDirectory(basedir + "/src/main/java");
		build.setOutputDirectory(basedir + "/target/classes");
		build.setTestSourceDirectory(basedir + "/src/test/java");
		build.setTestOutputDirectory(basedir + "/target/test-classes");


		List<Resource> resources = new ArrayList<Resource>();
		Resource resource = new Resource();
		resource.setDirectory(basedir + "/src/main/resources");
		resources.add(resource);
		build.setResources(resources);

		List<Resource> testResources = new ArrayList<Resource>();
		Resource testResource = new Resource();
		testResource.setDirectory(basedir + "/src/test/resources");
		testResources.add(testResource);
		build.setTestResources(testResources);

		setBuild(build);

		List<String> compileSourceRoots = new ArrayList<String>();
		compileSourceRoots.add(basedir + "/src/main/java");
		setCompileSourceRoots(compileSourceRoots);

		List<String> testCompileSourceRoots = new ArrayList<String>();
		testCompileSourceRoots.add(basedir + "/src/test/java");
		setTestCompileSourceRoots(testCompileSourceRoots);

	}

	@Override
	public List getResources() {
		return getBuild().getResources();
	}

	@Override
	public List getDependencies() {
		return getModel().getDependencies();
	}

	@Override
	public Set getPluginArtifacts() {
		return Collections.emptySet();
	}

	@Override
	public List getTestResources() {
		return getBuild().getTestResources();
	}
}
