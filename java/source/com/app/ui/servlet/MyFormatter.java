package com.app.ui.servlet;

import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateParser;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmWeight;
import com.kodemore.types.KmWeightUnit;
import com.kodemore.utility.Kmu;

import com.app.ui.core.MyServletData;

public class MyFormatter
    extends ScFormatter
{
    //##################################################
    //# static
    //##################################################

    public static MyFormatter getInstance()
    {
        return (MyFormatter)ScFormatter.getInstance();
    }

    public static void install()
    {
        setInstance(new MyFormatter());
    }

    //##################################################
    //# variables
    //##################################################

    private KmDateParser _dateParser;

    //##################################################
    //# constructor
    //##################################################

    private MyFormatter()
    {
        _dateParser = new KmDateParser();
        _dateParser.setOneNumberMode(_dateParser.ONE_NUMBER_MODE_NONE);
        _dateParser.setTwoNumberMode(_dateParser.TWO_NUMBER_MODE_MONTH_DAY_CLOSEST_YEAR);
        _dateParser.setThreeNumberMode(_dateParser.THREE_NUMBER_MODE_MONTH_DAY_YEAR);
    }

    //##################################################
    //# weight
    //##################################################

    @Override
    public String formatWeight(KmWeight e)
    {
        if ( e == null )
            return formatNull();

        MyServletData data = getData();
        if ( data == null )
            return e.formatKilograms();

        KmWeightUnit u = getPreferredWeightUnit();
        return e.format(u);
    }

    public KmWeight parseWeight(String s)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        Double d = Kmu.parseDouble(s);
        if ( d == null )
            return null;

        MyServletData data = getData();
        if ( data == null )
            return KmWeight.createKilograms(d);

        KmWeightUnit u = getPreferredWeightUnit();
        return new KmWeight(d, u);
    }

    //##################################################
    //# date
    //##################################################

    @Override
    public KmDate parseDate(String s)
    {
        return _dateParser.parse(s);
    }

    //##################################################
    //# timestamp
    //##################################################

    @Override
    public String formatTimestamp(KmTimestamp ts)
    {
        if ( ts == null )
            return "";

        String f = "{m}/{dd}/{yy} {H}:{MM} {am/pm}";
        return ts.format(f);
    }

    @Override
    public KmTimestamp parseTimestamp(String s)
    {
        return super.parseTimestamp(s);
    }

    //##################################################
    //# support
    //##################################################

    private MyServletData getData()
    {
        return (MyServletData)ScServletData.getLocal();
    }

    private KmWeightUnit getPreferredWeightUnit()
    {
        return null;
    }
}
