package com.kodemore.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

public abstract class ScActivityRegistry
{
    //##################################################
    //# static
    //##################################################

    private static ScActivityRegistry _instance;

    protected static synchronized void install(ScActivityRegistry e)
    {
        if ( _instance != null )
            Kmu.fatal("Already installed.");

        _instance = e;
    }

    public static ScActivityRegistry getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private KmMap<String,ScActivity> _activities;

    //##################################################
    //# constructor
    //##################################################

    protected ScActivityRegistry()
    {
        _activities = new KmMap<String,ScActivity>();
        registerActivities();
        installActivities();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScActivity findKey(String key)
    {
        ScActivity e = _activities.get(key);
        if ( e != null )
            return e;

        String msg = Kmu.format("Invalid page key(%s).", key);

        KmLog.warn(msg);
        throw new ScSessionTimeoutException(msg);
    }

    public ScActivity findNavigationHash(String hash)
    {
        KmList<ScActivity> v = getActivities();

        for ( ScActivity e : v )
            if ( e.hasNavigationHash(hash) )
                return e;

        return null;
    }

    public boolean hasKey(String key)
    {
        return _activities.containsKey(key);
    }

    public KmList<String> getActivityKeys()
    {
        return _activities.getKeys();
    }

    public KmList<ScActivity> getActivities()
    {
        return _activities.getValues();
    }

    public void add(ScActivity e)
    {
        String key = e.getKey();

        if ( key == null )
            Kmu.fatal("Attempt to register null page key.");

        if ( _activities.containsKey(key) )
            Kmu.fatal("Attempt to register duplicate page key (%s)", key);

        _activities.put(key, e);
    }

    //##################################################
    //# init
    //##################################################

    protected void registerActivities()
    {
        // subclass override
    }

    private void installActivities()
    {
        KmList<ScActivity> v = _activities.getValues();
        for ( ScActivity e : v )
            e.install();
    }

}
