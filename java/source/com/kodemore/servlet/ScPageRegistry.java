package com.kodemore.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
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
            throw Kmu.newFatal("Already installed.");

        _instance = e;
    }

    public static ScPageRegistry getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

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
        _pages = new KmMap<>();
        registerPages();
        installPages();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScPage findKey(String key)
    {
        return _pages.get(key);
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
            throw Kmu.newFatal("Attempt to register null page key.");

        if ( _pages.containsKey(key) )
            throw Kmu.newFatal("Attempt to register duplicate page key (%s)", key);

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
        KmList<ScPage> v;
        v = _pages.getValues();
        v.sortOn(ScPage::getSimpleClassName);

        for ( ScPage e : v )
            e.install();
    }

}
