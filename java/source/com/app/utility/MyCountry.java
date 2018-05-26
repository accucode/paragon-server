package com.app.utility;

import com.kodemore.collection.KmList;
import com.kodemore.csv.KmCsvReader;
import com.kodemore.servlet.ScCharsets;
import com.kodemore.utility.Kmu;

public class MyCountry
{
    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        KmList<MyCountry> v = MyCountry.getList();
        v.printLines();
    }

    //##################################################
    //# static
    //##################################################

    private static final KmList<MyCountry> _list;

    static
    {
        String csv = Kmu.readResourceString(MyCountry.class, "countries.txt");

        KmCsvReader reader;
        reader = new KmCsvReader();
        reader.setSource(csv);

        KmList<MyCountry> v = new KmList<>();
        while ( true )
        {
            boolean more = reader.nextRecord();
            if ( !more )
                break;

            String name = reader.getString();

            if ( Kmu.isEmpty(name) )
                continue;

            if ( name.startsWith("#") )
                continue;

            if ( !ScCharsets.isSingleLinePrintable(name) )
                continue;

            String iso = reader.getString();

            MyCountry e;
            e = new MyCountry();
            e.setName(name);
            e.setIsoCode(iso);
            v.add(e);
        }
        _list = v;
    }

    public static KmList<MyCountry> getList()
    {
        return _list;
    }

    //##################################################
    //# variables
    //##################################################

    private String _name;
    private String _isoCode;

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    //##################################################
    //# iso code
    //##################################################

    public String getIsoCode()
    {
        return _isoCode;
    }

    public void setIsoCode(String e)
    {
        _isoCode = e;
    }

    public boolean hasIsoCode(String e)
    {
        return Kmu.isEqual(_isoCode, e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("%s %s", getIsoCode(), getName());
    }

}
