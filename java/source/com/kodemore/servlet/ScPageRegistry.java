package com.kodemore.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

public abstract class ScPageRegistry
{
    //##################################################
    //# static
    //##################################################

    private static ScPageRegistry _instance;

    protected static synchronized void install(ScPageRegistry e)
    {
        if ( _instance != null )
            Kmu.fatal("Already installed.");

        _instance = e;
    }

    public static ScPageRegistry getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private KmMap<String,ScPage> _pages;

    //##################################################
    //# constructor
    //##################################################

    protected ScPageRegistry()
    {
        _pages = new KmMap<String,ScPage>();
        registerPages();
        installPages();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScPage findKey(String key)
    {
        ScPage e = _pages.get(key);
        if ( e != null )
            return e;

        String msg = Kmu.format("Invalid page key(%s).", key);

        KmLog.warn(msg);
        throw new ScSessionTimeoutException(msg);
    }

    public ScPage findNavigationHash(String hash)
    {
        KmList<ScPage> v = getPages();

        for ( ScPage e : v )
            if ( e.hasNavigationHash(hash) )
                return e;

        return null;
    }

    public boolean hasKey(String key)
    {
        return _pages.containsKey(key);
    }

    public KmList<String> getPageKeys()
    {
        return _pages.getKeys();
    }

    public KmList<ScPage> getPages()
    {
        return _pages.getValues();
    }

    public void add(ScPage e)
    {
        String key = e.getKey();

        if ( key == null )
            Kmu.fatal("Attempt to register null page key.");

        if ( _pages.containsKey(key) )
            Kmu.fatal("Attempt to register duplicate page key (%s)", key);

        _pages.put(key, e);
    }

    //##################################################
    //# init
    //##################################################

    protected void registerPages()
    {
        // subclass override
    }

    private void installPages()
    {
        KmList<ScPage> v = _pages.getValues();
        for ( ScPage e : v )
            e.install();
    }

}
