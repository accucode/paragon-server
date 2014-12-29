package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringAssociation;
import com.kodemore.utility.Kmu;

public class KmgCssComposite
{
    //##################################################
    //# variables
    //##################################################

    private String         _prefix;
    private KmList<String> _parts;
    private KmList<String> _flavors;

    //##################################################
    //# constructor
    //##################################################

    public KmgCssComposite()
    {
        _parts = new KmList<>();
        _flavors = new KmList<>();
    }

    //##################################################
    //# prefix
    //##################################################

    public String getPrefix()
    {
        return _prefix;
    }

    public void setPrefix(String e)
    {
        _prefix = e;
    }

    public boolean hasPrefix(String e)
    {
        return Kmu.isEqual(getPrefix(), e);
    }

    public KmStringAssociation getPrefixConstant()
    {
        String key = Kmu.format("%s_prefix", getPrefix());
        String value = getPrefix();

        return new KmStringAssociation(key, value);
    }

    //##################################################
    //# parts
    //##################################################

    public KmList<String> getParts()
    {
        return _parts;
    }

    public void addPart(String e)
    {
        _parts.addDistinct(e);
    }

    public KmList<KmStringAssociation> getPartConstants()
    {
        KmList<KmStringAssociation> v = new KmList<>();

        for ( String part : getParts() )
        {
            String key = Kmu.format("%s_part_%s", getPrefix(), part);
            String value = part;

            KmStringAssociation e = new KmStringAssociation(key, value);
            v.add(e);
        }

        return v;
    }

    //##################################################
    //# flavors
    //##################################################

    public KmList<String> getFlavors()
    {
        return _flavors;
    }

    public void addFlavor(String e)
    {
        _flavors.addDistinct(e);
    }

    public KmList<KmStringAssociation> getFlavorConstants()
    {
        KmList<KmStringAssociation> v = new KmList<>();

        for ( String e : getFlavors() )
        {
            String key = Kmu.format("%s_flavor_%s", getPrefix(), e);

            String value = e;
            if ( value == null )
                value = "";

            KmStringAssociation a = new KmStringAssociation(key, value);

            v.add(a);
        }

        return v;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("cssComposite(%s)", getPrefix());
    }
}
