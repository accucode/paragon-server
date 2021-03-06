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

import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

import com.kodemore.utility.Kmu;

public class KmTimestampUtility
{
    //##################################################
    //# conversions (null safe)
    //##################################################

    public static KmTimestamp toUtc(KmTimestamp local)
    {
        return toUtc(local, _localZone());
    }

    public static KmTimestamp toUtc(KmTimestamp local, KmTimeZone localZone)
    {
        return local == null
            ? null
            : local.toUtc(localZone);
    }

    public static KmTimestamp toLocal(KmTimestamp utc)
    {
        return toLocal(utc, _localZone());
    }

    public static KmTimestamp toLocal(KmTimestamp utc, KmTimeZone localZone)
    {
        return utc == null
            ? null
            : utc.toLocal(localZone);
    }

    //##################################################
    //# parts (null safe)
    //##################################################

    public static KmDate getDate(KmTimestamp e)
    {
        return e == null
            ? null
            : e.getDate();
    }

    public static KmTime getTime(KmTimestamp e)
    {
        return e == null
            ? null
            : e.getTime();
    }

    //##################################################
    //# min/max (null safe)
    //##################################################

    public static KmTimestamp minimumNotNull(KmTimestamp ts1, KmTimestamp ts2)
    {
        if ( ts1 == null )
            return ts2;

        if ( ts2 == null )
            return ts1;

        return ts1.toEpochMs() < ts2.toEpochMs()
            ? ts1
            : ts2;
    }

    public static KmTimestamp maximumNotNull(KmTimestamp ts1, KmTimestamp ts2)
    {
        if ( ts1 == null )
            return ts2;

        if ( ts2 == null )
            return ts1;

        return ts1.toEpochMs() < ts2.toEpochMs()
            ? ts2
            : ts1;
    }

    //##################################################
    //# format
    //##################################################

    /**
     * Format the timestamp using the formats defined in
     * KmDateUtility.format() and KmTimeUtility.format().
     */
    public static String format(KmTimestamp ts, String format)
    {
        if ( ts == null )
            return "";

        String s = format;
        s = KmDateUtility.format(ts.getDate(), s);
        s = KmTimeUtility.format(ts.getTime(), s);
        return s;
    }

    public static String format_m_dd_yy_h_mm_am(KmTimestamp ts)
    {
        if ( ts == null )
            return "";

        return KmDateUtility.format_m_dd_yy(ts.getDate())
            + " "
            + KmTimeUtility.format_h_mm_am(ts.getTime());
    }

    public static String format_m_dd_yy_h_mm_ss_am(KmTimestamp ts)
    {
        if ( ts == null )
            return "";

        return KmDateUtility.format_m_dd_yy(ts.getDate())
            + " "
            + KmTimeUtility.format_h_mm_ss_am(ts.getTime());
    }

    public static String format_mm_dd_yy_hh_mm_ss_am(KmTimestamp ts)
    {
        if ( ts == null )
            return "";

        return KmDateUtility.format_mm_dd_yy(ts.getDate())
            + " "
            + KmTimeUtility.format_hh_mm_ss_am(ts.getTime());
    }

    public static String formatXsdUtc(KmTimestamp ts)
    {
        return format(ts, "{yyyy}-{mm}-{dd}T{HH24}:{MM}:{SS}Z");
    }

    public static String format_mm_dd_yyyy_HH24_MM(KmTimestamp ts)
    {
        return format(ts, "{mm}/{dd}/{yyyy} {HH24}:{MM}");
    }

    public static String format_mm_dd_yyyy_HH24_MM_SS(KmTimestamp ts)
    {
        return format(ts, "{mm}/{dd}/{yyyy} {HH24}:{MM}:{SS}");
    }

    public static String formatLocalMessage(KmTimestamp utc)
    {
        return formatLocalMessage(utc, _localZone());
    }

    public static String formatLocalMessage(KmTimestamp utc, KmTimeZone localZone)
    {
        if ( utc == null )
            return "";

        KmTimestamp local = toLocal(utc, localZone);
        String s = KmTimestampUtility.format_m_dd_yy_h_mm_am(local);

        if ( localZone != null )
            s += Kmu.format(" (%s)", localZone.getName());

        return s;
    }

    public static String formatCode(ZoneId e)
    {
        return e.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }

    //##################################################
    //# bridge
    //##################################################

    private static KmTimeZone _localZone()
    {
        return KmTimeZoneBridge.getInstance().getLocalZone();
    }
}
