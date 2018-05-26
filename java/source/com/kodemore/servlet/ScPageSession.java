package com.kodemore.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.utility.ScControlKeys;
import com.kodemore.utility.Kmu;

public class ScPageSession
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<Integer,Object> _sessionValues;
    private KmMap<Integer,Object> _localValues;

    //##################################################
    //# constructor
    //##################################################

    public ScPageSession()
    {
        this(null);
    }

    public ScPageSession(String sessionValues)
    {
        _sessionValues = new KmMap<>();
        _localValues = new KmMap<>();

        installSessionValues(sessionValues);
    }

    //##################################################
    //# session values
    //##################################################

    public KmMap<Integer,Object> getSessionValues()
    {
        return _sessionValues;
    }

    public void setSessionValue(KmMap<Integer,Object> e)
    {
        _sessionValues = e;
    }

    void resetSessionValues()
    {
        _sessionValues.clear();
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

    private KmMap<Integer,Object> parseSessionValues(String source)
    {
        if ( Kmu.isEmpty(source) )
            return new KmMap<>();

        @SuppressWarnings("unchecked")
        KmMap<Integer,Object> map = (KmMap<Integer,Object>)ScDecoder.staticDecode(source);

        for ( Integer key : map.keySet() )
            if ( ScControlKeys.isTransientKey(key) )
                map.remove(key);

        return map;
    }

    //==================================================
    //= values :: local
    //==================================================

    @SuppressWarnings("unchecked")
    public <T> T getValueFor(Integer key, T defaultValue)
    {
        return (T)_localValues.getOrDefault(key, defaultValue);
    }

    public <T> void setValueFor(Integer key, T value)
    {
        _localValues.put(key, value);
    }

    public void removeKey(Integer key)
    {
        _localValues.remove(key);
    }

    private void resetLocalValues()
    {
        _localValues.clear();
    }

    //==================================================
    //= values :: session
    //==================================================

    public void saveKey(Integer key)
    {
        if ( _localValues.containsKey(key) )
            _sessionValues.put(key, _localValues.get(key));
        else
            _sessionValues.remove(key);
    }

    //##################################################
    //# global keys
    //##################################################

    private static final KmList<Integer> _globalKeys = new KmList<>();

    public static void addGlobalKey(int key)
    {
        _globalKeys.add(key);
    }

    public static boolean hasGlobalKey(int key)
    {
        return _globalKeys.contains(key);
    }

    //##################################################
    //# clear
    //##################################################

    /**
     * Resets the transient values as well as the normal page session.
     * Does NOT reset the global session values.
     */
    public void reset()
    {
        KmMap<Integer,Object> globalSessionValues = new KmMap<>();
        KmMap<Integer,Object> globalLocalValues = new KmMap<>();

        for ( Integer key : _globalKeys )
        {
            globalSessionValues.put(key, _sessionValues.get(key));
            globalLocalValues.put(key, _localValues.get(key));
        }

        _reset();

        _sessionValues.putAll(globalSessionValues);
        _localValues.putAll(globalLocalValues);
    }

    /**
     * Reset everything, including the global values.
     */
    public void resetAll()
    {
        _reset();
    }

    private void _reset()
    {
        resetLocalValues();
        resetSessionValues();
    }
}
