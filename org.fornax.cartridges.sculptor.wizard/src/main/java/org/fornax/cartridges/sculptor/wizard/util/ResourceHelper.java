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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.MissingResourceException;

/**
 * Helper to read content from file in classpath.
 * Default charset is ISO-8859-1, but it can be specified to be something else.
 *
 */
public class ResourceHelper {
    
    private static final String DEFAULT_CHARSET = "ISO-8859-1";

    public ResourceHelper() {
    }
    
    /**
     * 
     * @param path path to resource in classpath
     * @return reader to the resource in classpath
     */
    public static BufferedReader reader(String path) {
        return reader(path, DEFAULT_CHARSET);
    }
    
    public static BufferedReader reader(String path, String charset) {
        try {
            if (path.startsWith("file:/")) {
                // remove "file:/" from path
                File file = new File(path.substring(6));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file), charset));
                return reader;
            } else {
                URL sourceUrl = ResourceHelper.class.getResource(path);
                if (sourceUrl == null) {
                    throw new MissingResourceException(path + " not found in classpath", path, "");
                }
                InputStream sourceInput = sourceUrl.openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(sourceInput, charset));
                return reader;
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
    }
    
    
    
    public static String content(String path) {
        return content(path, DEFAULT_CHARSET);
    }
    
    public static String content(String path, String charset) {
        return content(reader(path, charset));
    }
    
    public static String content(BufferedReader reader) {
        try {
            StringBuffer content = new StringBuffer();
            String line = reader.readLine();
            while (line != null) {
                content.append(line).append("\n");
                line = reader.readLine();
            }
            return content.toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignore) {
                }
            }
        }
    }
    

}