package org.fornax.cartridges.sculptor.wizard;

import static org.junit.Assert.*;

import org.fornax.cartridges.sculptor.wizard.util.ResourceHelper;
import org.junit.Before;
import org.junit.Test;

public class PomParserTest {
    private PomParser parser;
    
    @Before
    public void setUp() {
        parser = new PomParser(ResourceHelper.content("/test-pom.xml"));
    }
    
    @Test
    public void artifactId() throws Exception {
        assertEquals("sculptor-helloworld", parser.getArtifactId());
    }
    
    @Test
    public void groupId() throws Exception {
        assertEquals("org.fornax.cartridges", parser.getGroupId());
    }
    
    @Test
    public void parentArtifactId() throws Exception {
        assertEquals("sculptor-helloworld-parent", parser.getParentArtifactId());
    }
    
    @Test
    public void version() throws Exception {
        assertEquals("1.5.0", parser.getVersion());
    }

}
