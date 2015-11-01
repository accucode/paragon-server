/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.time;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.kodemore.log.KmLog;

public class KmTimeZoneUtility
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The list of known zones.
     */
    private static Map<String,ZoneId> ZONES;

    static
    {
        ZONES = new HashMap<>();

        Set<String> ids = ZoneId.getAvailableZoneIds();
        for ( String id : ids )
            ZONES.put(id, ZoneId.of(id));
    }

    //##################################################
    //# accessing
    //##################################################

    /**
     * Return a well known zone, or null if the id is unknown.
     */
    public static ZoneId getZone(String id)
    {
        return ZONES.get(id);
    }

    /**
     * Return a non-null zone.
     * If the id is unknown, log a warning and return UTC.
     */
    public static ZoneId getZoneOrUtc(String id)
    {
        if ( id == null )
            return KmTimeConstantsIF.UTC_ZONE;

        ZoneId e = getZone(id);
        if ( e != null )
            return e;

        KmLog.warnTrace("Unknown time zone id (%s)", id);
        return KmTimeConstantsIF.UTC_ZONE;
    }
}
