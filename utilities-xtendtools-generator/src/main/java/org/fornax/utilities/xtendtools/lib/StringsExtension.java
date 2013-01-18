/**
 * Copyright 2010 The Xtend Tools Team and contributors.
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
package org.fornax.utilities.xtendtools.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;

/**
 * This class provides the implementations for the Java extensions defined in strings.ext.
 * 
 * @author Ingo Feltes
 */
public final class StringsExtension {
    
    private StringsExtension() {
    }
    
    /**
     * Parses the given string using the given regular expression pattern and
     * returns the contents of the matched capturing groups or <tt>null</tt> if
     * the string did not match the pattern.
     */
    public static List<String> parse(final String str, final String pattern) {
        if (str == null) {
            throw new NullArgumentException("str");
        }
        if (pattern == null) {
            throw new NullArgumentException("pattern");
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        if (m.matches()) {
            List<String> result = new ArrayList<String>();
            for (int i = 1; i <= m.groupCount(); i++) {
                result.add(m.group(i));
            }
            return result;
        }
        return null;
    }

    /**
     * Delegate for StringUtils.repeat.
     * 
     * @see StringUtils#repeat(String, int)
     */
    public static String repeat(final String str, final Integer repeat) {
        return StringUtils.repeat(str, repeat != null ? repeat.intValue() : 0);
    }
    
    /**
     * Delegate for StringUtils.repeat.
     * 
     * @see StringUtils#repeat(String, String, int)
     */
    public static String repeat(final String str, final String separator, final Integer repeat) {
        return StringUtils.repeat(str, separator, repeat != null ? repeat.intValue() : 0);
    }
    
    /**
     * Delegate for StringUtils.splitByWholeSeparatorPreserveAllTokens.
     * 
     * @see StringUtils#splitByWholeSeparatorPreserveAllTokens(String, String)
     */
    public static List<String> splitByWholeSeparatorPreserveAllTokens(final String str, final String separator) {
        return Arrays.asList(StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator));
    }
    
    /**
     * Delegate for StringUtils.substring.
     * 
     * @see StringUtils#substring(String, int)
     */
    public static String substring(final String str, final Integer start) {
        return StringUtils.substring(str, start);
    }

    /**
     * Delegate for StringUtils.substring.
     * 
     * @see StringUtils#substring(String, int, int)
     */
    public static String substring(final String str, final Integer start, final Integer end) {
        return StringUtils.substring(str, start, end);
    }

}
