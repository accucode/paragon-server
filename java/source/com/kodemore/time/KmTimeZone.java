/*
  Copyright (c) 2005-2018 www.kodemore.com

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

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * I provide a simple wrapper for the ZoneID class.
 * This provides a less confusing naming convention,
 * and a number of convenience methods.
 */
public class KmTimeZone
{
    //##################################################
    //# static :: all zones
    //##################################################

    /**
     * The list of well known zones.
     */
    private static final KmMap<String,KmTimeZone> _zones;

    /**
     * We use a static block to initialize the map upon class load.
     */
    static
    {
        KmMap<String,KmTimeZone> m = new KmMap<>();

        Set<String> ids = ZoneId.getAvailableZoneIds();
        for ( String id : ids )
            m.put(id, _createZone(ZoneId.of(id)));

        _zones = m;
    }

    public static KmList<KmTimeZone> getAllZones()
    {
        KmList<KmTimeZone> v;
        v = _zones.getValues();
        v.sortOn(e -> e.getName());
        return v;
    }

    //##################################################
    //# static :: instance creation
    //##################################################

    /**
     * Clients should generally NOT create new zones.
     * Instead, use findId to find the preregistered
     * immutable singletons.
     */
    public static final KmTimeZone _createZone(ZoneId id)
    {
        return new KmTimeZone(id);
    }

    //##################################################
    //# static :: find
    //##################################################

    public static final KmTimeZone findCode(String e)
    {
        return findId(e, false);
    }

    private static final KmTimeZone findId(String id, boolean warnIfMissing)
    {
        KmTimeZone e = _zones.get(id);
        if ( e != null )
            return e;

        if ( warnIfMissing )
            KmLog.warnTrace("Unknown Time Zone %s.", id);

        return null;
    }

    //##################################################
    //# static :: convenience
    //##################################################

    public static String getCodeFor(KmTimeZone e)
    {
        return e == null
            ? null
            : e.getCode();
    }

    //##################################################
    //# static :: common
    //##################################################

    public static final KmTimeZone UTC = findId("UTC", true);

    /*
    public static final KmTimeZone LOS_ANGELES = findId("America/Los_Angeles", true);
    public static final KmTimeZone PHOENIX     = findId("America/Phoenix", true);
    public static final KmTimeZone DENVER      = findId("America/Denver", true);
    public static final KmTimeZone LOUISVILLE  = findId("America/Louisville", true);
    public static final KmTimeZone NEW_YORK    = findId("America/New_York", true);
    */

    public static final KmTimeZone Pacific  = findId("US/Pacific", true);
    public static final KmTimeZone Mountain = findId("US/Mountain", true);
    public static final KmTimeZone Arizona  = findId("US/Arizona", true);
    public static final KmTimeZone Central  = findId("US/Central", true);
    public static final KmTimeZone Eastern  = findId("US/Eastern", true);
    public static final KmTimeZone Alaska   = findId("US/Alaska", true);
    public static final KmTimeZone Hawaii   = findId("US/Hawaii", true);

    public static final KmList<KmTimeZone> getCommonZones()
    {
        return KmList.createWith(UTC, Pacific, Mountain, Arizona, Central, Eastern, Alaska, Hawaii);
    }

    //##################################################
    //# static :: system default
    //##################################################

    /**
     * A default timezone for use in situations where a time zone is required
     * but we have no other way to determine one from the local context.
     *
     * In most cases, the default should be determined from the project,
     * depot, or tenant, all of which have a default time zone.
     */
    public static final KmTimeZone SYSTEM_DEFAULT = Mountain;

    //##################################################
    //# variables
    //##################################################

    private ZoneId _id;

    //##################################################
    //# constructor
    //##################################################

    private KmTimeZone(ZoneId id)
    {
        _id = id;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getCode()
    {
        return _id.getId();
    }

    public ZoneId getZoneId()
    {
        return _id;
    }

    /**
     * Return a useful display name, suitable for end users.
     *
     * Note that NONE of the formats returned by getDisplayString
     * are distinct enough to use in most situations. For example,
     * getDisplayString doesn't distinguish between Mountain and Phoenix.
     */
    public String getName()
    {
        return getCode();
    }

    //##################################################
    //# offset
    //##################################################

    /**
     * Return this zone's offset from UTC.
     * The offset is based on the current clock time.
     */
    public int getOffsetSeconds()
    {
        Instant instant = KmClock.getUtcTimestamp().toInstant();
        ZoneOffset offset = getZoneId().getRules().getOffset(instant);
        return offset.getTotalSeconds();
    }

    /**
     * Return this zone's offset from UTC.
     * The offset is based on the current clock time.
     */
    public int getOffsetMs()
    {
        return getOffsetSeconds() * 1000;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("TimeZone (%s)", getCode());
    }
}
