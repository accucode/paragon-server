package com.kodemore.servlet.encoder.coder;

import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

public class ScCoderRegistry
{
    //##################################################
    //# static
    //##################################################

    public static final ScCoderRegistry instance = new ScCoderRegistry();

    //##################################################
    //# variables
    //##################################################

    private KmMap<String,ScCoderIF>     _coders;

    //##################################################
    //# constructor
    //##################################################

    private ScCoderRegistry()
    {
        _coders = new KmMap<>();
        registerDefaultCoders();
    }

    //##################################################
    //# public
    //##################################################

    public KmMap<String,ScCoderIF> getCoders()
    {
        return _coders;
    }

    public void registerCoder(ScCoderIF c)
    {
        String key = c.getKey();
        if ( key == null )
            Kmu.fatal("Coder key is null.");

        ScCoderIF e = findKey(key);
        if ( e != null )
            Kmu.fatal("Duplicate coder (%s), %s, %s.", key, c, e);

        _coders.put(key, c);
    }

    public ScCoderIF findKey(String key)
    {
        return _coders.get(key);
    }

    public ScCoderIF getCoderFor(Object e)
    {
        for ( ScCoderIF c : _coders.values() )
            if ( c.matches(e) )
                return c;
        return null;
    }

    //##################################################
    //# private
    //##################################################

    private void registerDefaultCoders()
    {
        registerCoder(new ScNullCoder());

        registerCoder(new ScStringCoder());
        registerCoder(new ScIntegerCoder());
        registerCoder(new ScLongCoder());
        registerCoder(new ScDoubleCoder());
        registerCoder(new ScBooleanCoder());

        registerCoder(new ScDateCoder());
        registerCoder(new ScTimestampCoder());
        registerCoder(new ScQuantityCoder());
        registerCoder(new ScActionCoder());
        registerCoder(new ScHtmlColorCoder());

        registerCoder(new ScListCoder());
        registerCoder(new ScMapCoder());
    }

}
