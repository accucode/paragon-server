package com.kodemore.servlet;

import com.kodemore.collection.KmMap;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.utility.Kmu;

public class ScPageSession
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,Object> _globalValues;
    private KmMap<String,Object> _sessionValues;
    private KmMap<String,Object> _localValues;

    //##################################################
    //# constructor
    //##################################################

    public ScPageSession()
    {
        this(null, null);
    }

    public ScPageSession(String globalValues, String sessionValues)
    {
        _globalValues = new KmMap<>();
        _sessionValues = new KmMap<>();
        _localValues = new KmMap<>();

        installGlobalValues(globalValues);
        installSessionValues(sessionValues);
    }

    //##################################################
    //# session values
    //##################################################

    public KmMap<String,Object> getGlobalValues()
    {
        return _globalValues;
    }

    public void setGlobalValues(KmMap<String,Object> e)
    {
        _globalValues = e;
    }

    //==================================================
    //= global values :: string
    //==================================================

    public String formatGlobalValues()
    {
        return ScEncoder.staticEncode(_globalValues);
    }

    public void installGlobalValues(String s)
    {
        _globalValues = parseGlobalValues(s);
    }

    private KmMap<String,Object> parseGlobalValues(String s)
    {
        if ( Kmu.isEmpty(s) )
            return new KmMap<>();

        @SuppressWarnings("unchecked")
        KmMap<String,Object> map = (KmMap<String,Object>)ScDecoder.staticDecode(s);

        return map;
    }

    //##################################################
    //# session values
    //##################################################

    public KmMap<String,Object> getSessionValues()
    {
        return _sessionValues;
    }

    public void setSessionValue(KmMap<String,Object> e)
    {
        _sessionValues = e;
    }

    //==================================================
    //= session values :: string
    //==================================================

    public String formatSessionValues()
    {
        return ScEncoder.staticEncode(_sessionValues);
    }

    public void installSessionValues(String s)
    {
        _sessionValues = parseSessionValues(s);
        _localValues = _sessionValues.getShallowCopy();
    }

    private KmMap<String,Object> parseSessionValues(String s)
    {
        if ( Kmu.isEmpty(s) )
            return new KmMap<>();

        @SuppressWarnings("unchecked")
        KmMap<String,Object> map = (KmMap<String,Object>)ScDecoder.staticDecode(s);

        for ( String key : map.keySet() )
            if ( key.startsWith(ScConstantsIF.TRANSIENT_KEY_PREFIX) )
                map.remove(key);

        return map;
    }

    //##################################################
    //# values :: global
    //##################################################

    @SuppressWarnings("unchecked")
    public <T> T getGlobalValueFor(String key, T defaultValue)
    {
        if ( _globalValues.containsKey(key) )
            return (T)_globalValues.get(key);

        return defaultValue;
    }

    public <T> void setGlobalValueFor(String key, T value)
    {
        _globalValues.put(key, value);
    }

    public void removeGlobalKey(String key)
    {
        _globalValues.remove(key);
    }

    //==================================================
    //= values :: local
    //==================================================

    @SuppressWarnings("unchecked")
    public <T> T getValueFor(String key, T defaultValue)
    {
        if ( _localValues.containsKey(key) )
            return (T)_localValues.get(key);

        return defaultValue;
    }

    public <T> void setValueFor(String key, T value)
    {
        _localValues.put(key, value);
    }

    public void removeKey(String key)
    {
        _localValues.remove(key);
    }

    public void clearAll()
    {
        _localValues.clear();
    }

    //==================================================
    //= values :: session
    //==================================================

    public void saveKey(String key)
    {
        if ( _localValues.containsKey(key) )
            _sessionValues.put(key, _localValues.get(key));
        else
            _sessionValues.remove(key);
    }

    //##################################################
    //# debug
    //##################################################

    /**
     * Just a hack for debugging.
     */
    public void printDebug(String key)
    {
        Object local = _localValues.get(key);
        Object session = _sessionValues.get(key);

        System.out.println("ScPageSession.debugKey");
        System.out.println("    key:     " + key);
        System.out.println("    local:   " + local);
        System.out.println("    session: " + session);
    }

}
