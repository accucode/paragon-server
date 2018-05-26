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

package com.kodemore.servlet.utility;

import java.math.BigDecimal;

import com.kodemore.log.KmLog;
import com.kodemore.string.KmStringTokenizer;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateFormatter;
import com.kodemore.time.KmDateParser;
import com.kodemore.time.KmDateRange;
import com.kodemore.time.KmDuration;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeFormatter;
import com.kodemore.time.KmTimeParser;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampFormatter;
import com.kodemore.time.KmTimestampParser;
import com.kodemore.time.KmUnitDuration;
import com.kodemore.time.KmWeekDay;
import com.kodemore.types.KmCost;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.types.KmKilogram;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;
import com.kodemore.types.KmRate;
import com.kodemore.types.KmWeight;
import com.kodemore.types.KmWeightUnit;
import com.kodemore.utility.Kmu;

/**
 * I am used to format objects.  The resulting strings
 * should be suitable for display to the end user.
 *
 * An instance of KmServletData is provided to allow
 * for context sensitive formatting.  The servlet data
 * may be null (e.g.: if formatting is performed without
 * a http request.
 *
 * Everyone that needs to format objects should call
 * this instance.  It is assumed that the application
 * may install an alternate instance when the application
 * starts.
 *
 * Every supported type has both a 'format' and a 'parse'
 * method.  Although the 'parse' method may support multiple
 * formats, it *must* support the value created by the
 * corresponding 'format' method.
 */
public class ScFormatter
{
    //##################################################
    //# instance
    //##################################################

    private static ScFormatter _instance;

    public static ScFormatter getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    public static void install()
    {
        setInstance(new ScFormatter());
    }

    public static void setInstance(ScFormatter e)
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = e;
    }

    //##################################################
    //# constructor
    //##################################################

    protected ScFormatter()
    {
        // protected
    }

    //##################################################
    //# string
    //##################################################

    public String formatString(String e)
    {
        if ( e == null )
            return formatNull();

        return e;
    }

    public String formatCharSequence(CharSequence e)
    {
        if ( e == null )
            return formatNull();

        return formatString(e.toString());
    }

    //##################################################
    //# integer
    //##################################################

    public String formatInteger(Integer e)
    {
        if ( e == null )
            return formatNull();

        return Kmu.formatInteger(e);
    }

    public Integer parseInteger(String s)
    {
        s = Kmu.stripCharacters(s, ',');
        return Kmu.parseInteger(s);
    }

    public String getIntegerSample()
    {
        return "123";
    }

    //##################################################
    //# long
    //##################################################

    public String formatLong(Long e)
    {
        if ( e == null )
            return formatNull();

        return Kmu.formatInteger(e);
    }

    public Long parseLong(String s)
    {
        s = Kmu.stripCharacters(s, ',');
        return Kmu.parseLong(s);
    }

    public String getLongSample()
    {
        return "123";
    }

    //##################################################
    //# double
    //##################################################

    public String formatDouble(Double e)
    {
        if ( e == null )
            return formatNull();

        if ( e.isNaN() )
            return formatNull();

        if ( e.isInfinite() )
            return formatNull();

        String s;
        s = Kmu.formatDouble(e, 5);
        s = Kmu.stripTrailingCharacters(s, '0');
        s = Kmu.stripTrailingCharacters(s, '.');
        return s;
    }

    public Double parseDouble(String s)
    {
        s = Kmu.stripCharacters(s, ',');
        return Kmu.parseDouble(s);
    }

    public String getDoubleSample()
    {
        return "123.45";
    }

    //##################################################
    //# money
    //##################################################

    public String formatMoney(KmMoney e)
    {
        if ( e == null )
            return formatNull();

        return e.format();
    }

    public KmMoney parseMoney(String s)
    {
        s = Kmu.stripCharacters(s, '$');
        BigDecimal d = Kmu.parseBigDecimal(s);

        return d == null
            ? null
            : new KmMoney(d);
    }

    public String getMoneySample()
    {
        return "123.45";
    }

    //##################################################
    //# color
    //##################################################

    public String formatHtmlColor(KmHtmlColor e)
    {
        if ( e == null )
            return formatNull();

        return e.getHexValue();
    }

    public KmHtmlColor parseHtmlColor(String s)
    {
        return KmHtmlColor.create(s);
    }

    public String getHtmlColorSample()
    {
        return "#BBAADD";
    }

    //##################################################
    //# boolean
    //##################################################

    public String formatBoolean(Boolean e)
    {
        if ( e == null )
            return formatNull();

        if ( e )
            return "Yes";
        return "No";
    }

    public Boolean parseBoolean(String s)
    {
        return Kmu.parseBoolean(s);
    }

    public String getBooleanSample()
    {
        return "Yes | No";
    }

    //##################################################
    //# day frequency
    //##################################################

    public String formatDayFrequency(KmDayFrequency e)
    {
        if ( e == null )
            return formatNull();

        return e.getWeekDays().collect(x -> x.getLabel()).join();
    }

    public KmDayFrequency parseDayFrequency(String s)
    {
        KmStringTokenizer t;
        t = new KmStringTokenizer();
        t.addCommaDelimiter();
        t.addSemicolonDelimiter();
        t.addWhitespaceDelimiters();
        t.setIgnoreEmptyValues();
        t.setTrimValues();

        KmDayFrequency f = KmDayFrequency.EMPTY;

        for ( String token : t.split(s) )
        {
            KmWeekDay day = KmWeekDay.fromToken(token);
            if ( day != null )
                f.addDay(day);
        }

        return f;
    }

    public String getDayFrequencySample()
    {
        return "Monday, Tuesday";
    }

    //##################################################
    //# date
    //##################################################

    public String formatDate(KmDate e)
    {
        if ( e == null )
            return formatNull();

        return new KmDateFormatter().format(e);
    }

    public KmDate parseDate(String s)
    {
        return KmDateParser.parseDate(s);
    }

    public String getDateSample()
    {
        return "12/31/2000";
    }

    //##################################################
    //# date interva;
    //##################################################

    public String formatDateInterval(KmDateRange e)
    {
        if ( e == null )
            return formatNull();

        return e.toString();
    }

    //##################################################
    //# time
    //##################################################

    public String formatTime(KmTime e)
    {
        if ( e == null )
            return formatNull();

        return new KmTimeFormatter("{H}:{MM} {am/pm}").format(e);
    }

    public KmTime parseTime(String s)
    {
        return KmTimeParser.parseTime(s);
    }

    public String getTimeSample()
    {
        return "12:34:56 pm";
    }

    //##################################################
    //# timestamp
    //##################################################

    public String formatTimestamp(KmTimestamp e)
    {
        if ( e == null )
            return formatNull();

        return new KmTimestampFormatter().format(e);
    }

    public KmTimestamp parseTimestamp(String s)
    {
        return KmTimestampParser.parseTimestamp(s);
    }

    public String getTimestampSample()
    {
        return "12/31/2000 12:34:56 pm";
    }

    //##################################################
    //# duration
    //##################################################

    public String formatDuration(KmDuration e)
    {
        if ( e == null )
            return formatNull();

        return e.format();
    }

    public KmDuration parseDuration(String s)
    {
        return KmDuration.fromString(s);
    }

    public String getDurationSample()
    {
        return "5 days 12:31:00";
    }

    //##################################################
    //# unit duration
    //##################################################

    public String formatUnitDuration(KmUnitDuration e)
    {
        if ( e == null )
            return formatNull();

        return e.format();
    }

    public KmDuration parseUnitDuration(String s)
    {
        return KmDuration.fromString(s);
    }

    public String getUnitDurationSample()
    {
        return "6 Hours";
    }

    //##################################################
    //# weight
    //##################################################

    public String formatWeight(KmWeight e)
    {
        if ( e == null )
            return formatNull();

        return formatWeight(e, null);
    }

    public String formatWeight(KmWeight e, KmWeightUnit u)
    {
        if ( e == null )
            return formatNull();

        if ( u == null )
            u = e.getUnit();

        double d = u.toLocal(e);
        return Kmu.formatDouble(d, 3);
    }

    public KmWeight parseWeight(String s, KmWeightUnit u)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        Double d = Kmu.parseDouble(s);
        if ( d == null )
            return null;

        return new KmWeight(d, u);
    }

    public String getWeightSample()
    {
        return "12.34";
    }

    //##################################################
    //# kilogram
    //##################################################

    public String formatKilogram(KmKilogram e)
    {
        if ( e == null )
            return formatNull();

        return e.format();
    }

    public KmKilogram parseKilogram(String s)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        Double d = Kmu.parseDouble(s);
        if ( d == null )
            return null;

        return new KmKilogram(d);
    }

    public String getKilogramSample()
    {
        return "12.34";
    }

    //##################################################
    //# quantity
    //##################################################

    public String formatQuantity(KmQuantity e)
    {
        if ( e == null )
            return formatNull();

        return e.format();
    }

    public KmQuantity parseQuantity(String s)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        s = Kmu.stripCharacters(s, ',');
        return Kmu.parseQuantity(s);
    }

    public String getQuantitySample()
    {
        return "12.34, must be < 10,000,000";
    }

    //##################################################
    //# rate
    //##################################################

    public String formatRate(KmRate e)
    {
        if ( e == null )
            return formatNull();

        return e.format();
    }

    public KmRate parseRate(String s)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        Double d = Kmu.parseDouble(s);
        if ( d == null )
            return null;

        return new KmRate(d);
    }

    public String getRateSample()
    {
        return "12.3456";
    }

    //##################################################
    //# cost
    //##################################################

    public String formatCost(KmCost e)
    {
        if ( e == null )
            return formatNull();

        return e.format();
    }

    public KmCost parseCost(String s)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        s = s.trim();
        s = Kmu.removePrefix(s, "$");
        s = Kmu.stripCharacters(s, ',');
        Double d = Kmu.parseDouble(s);

        if ( d == null )
            return null;

        return new KmCost(d);
    }

    public String getCostSample()
    {
        return "12.34";
    }

    //##################################################
    //# object
    //##################################################

    public String formatAny(Object e)
    {
        if ( e == null )
            return "";

        if ( e instanceof String )
            return formatString((String)e);

        if ( e instanceof Boolean )
            return formatBoolean((Boolean)e);

        if ( e instanceof Integer )
            return formatInteger((Integer)e);

        if ( e instanceof Long )
            return formatLong((Long)e);

        if ( e instanceof Double )
            return formatDouble((Double)e);

        if ( e instanceof KmDate )
            return formatDate((KmDate)e);

        if ( e instanceof KmDateRange )
            return formatDateInterval((KmDateRange)e);

        if ( e instanceof KmDayFrequency )
            return formatDayFrequency((KmDayFrequency)e);

        if ( e instanceof KmTime )
            return formatTime((KmTime)e);

        if ( e instanceof KmTimestamp )
            return formatTimestamp((KmTimestamp)e);

        if ( e instanceof KmDuration )
            return formatDuration((KmDuration)e);

        if ( e instanceof KmUnitDuration )
            return formatUnitDuration((KmUnitDuration)e);

        if ( e instanceof KmWeight )
            return formatWeight((KmWeight)e);

        if ( e instanceof KmKilogram )
            return formatKilogram((KmKilogram)e);

        if ( e instanceof KmQuantity )
            return formatQuantity((KmQuantity)e);

        if ( e instanceof KmRate )
            return formatRate((KmRate)e);

        if ( e instanceof KmCost )
            return formatCost((KmCost)e);

        if ( e instanceof KmMoney )
            return formatMoney((KmMoney)e);

        if ( e instanceof KmHtmlColor )
            return formatHtmlColor((KmHtmlColor)e);

        if ( e instanceof CharSequence )
            return formatCharSequence((CharSequence)e);

        KmLog.warnTrace("Unsupported format: " + e.getClass().getName());
        return "";
    }

    //##################################################
    //# percent
    //##################################################

    public String formatPercent(Double e)
    {
        return formatPercent(e, 1);
    }

    public String formatPercent(Double e, int places)
    {
        if ( e == null )
            return formatNull();

        double p = e * 100;
        return Kmu.format("%." + places + "f%%", p);
    }

    //##################################################
    //# support
    //##################################################

    public String formatNull()
    {
        return "";
    }

}
