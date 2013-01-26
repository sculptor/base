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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

/**
 * This class provides the implementations for the Java extensions defined in utils.ext.
 * 
 * @author Ingo Feltes
 */
public final class UtilsExtension {
    
    private static final String DATEFORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ssz";

    private static final String TIMEZONE_UTC = "UTC";
    private static final String TIMEZONE_Z = "Z";
    
    private UtilsExtension() {
    }

    /**
     * Returns a new type 4 (pseudo randomly generated) UUID.
     * 
     * @see UUID#randomUUID()
     */
    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * Returns the current time stamp in ISO 8601 format and Z (Zulu) time zone.
     */
    public static String getTimeStamp() {
        final Calendar c = new GregorianCalendar(TimeZone.getTimeZone(TIMEZONE_UTC));
        final DateFormat df = new SimpleDateFormat(DATEFORMAT_ISO8601);
        df.setCalendar(c);
        return StringUtils.replace(df.format(c.getTime()), TIMEZONE_UTC, TIMEZONE_Z);
    }
    
    /**
     * Returns the current time stamp.
     */
    public static String getTimeStamp(final String pattern) {
        final Calendar c = new GregorianCalendar();
        final DateFormat df = new SimpleDateFormat(pattern, Locale.US);
        df.setCalendar(c);
        return df.format(c.getTime());
    }
    
    public static String getUserName() {
        return SystemUtils.USER_NAME;
    }
    
}
