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
        postInstall();
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

    protected void add(ScPage e)
    {
        String key = e.getKey();

        if ( key == null )
            throw Kmu.newFatal("Attempt to register null page key.");

        if ( _pages.containsKey(key) )
            throw Kmu.newFatal("Attempt to register duplicate page key (%s)", key);

        _pages.put(key, e);
    }

    //==================================================
    //= accessing :: pages
    //==================================================

    /**
     * Returns the list of all registered pages.
     */
    public KmList<ScPage> getPages()
    {
        return _pages.getValues();
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
        for ( ScPage e : getSortedPages() )
            e.install();
    }

    private void postInstall()
    {
        for ( ScPage e : getSortedPages() )
            postInstall(e);
    }

    private void postInstall(ScPage e)
    {
        try
        {
            e.postInstall();
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex, "Cannot postInstall %s.", e.getClass().getSimpleName());
        }
    }

    //##################################################
    //# support
    //##################################################

    private KmList<ScPage> getSortedPages()
    {
        KmList<ScPage> v;
        v = _pages.getValues();
        v.sortOn(e -> e.getClass().getSimpleName());
        return v;
    }
}
