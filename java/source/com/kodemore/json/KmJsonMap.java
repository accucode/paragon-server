package com.kodemore.json;

import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * Wraps the json-simple library.
 * http://code.google.com/p/json-simple/
 * Apache License 2.0
 */
public class KmJsonMap
    implements KmJsonObjectIF
{
    //##################################################
    //# variables
    //##################################################

    private JSONObject _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmJsonMap()
    {
        _inner = new JSONObject();
    }

    public KmJsonMap(JSONObject e)
    {
        _inner = e;
    }

    //##################################################
    //# basics
    //##################################################

    public String getString(String key)
    {
        return (String)getObject(key);
    }

    public void setString(String key, String value)
    {
        setObject(key, value);
    }

    public Boolean getBoolean(String key)
    {
        return (Boolean)getObject(key);
    }

    public void setBoolean(String key, Boolean value)
    {
        setObject(key, value);
    }

    public Long getLong(String key)
    {
        return (Long)getObject(key);
    }

    public void setLong(String key, Long value)
    {
        setObject(key, value);
    }

    public Double getDouble(String key)
    {
        return (Double)getObject(key);
    }

    public void setDouble(String key, Double value)
    {
        setObject(key, value);
    }

    public void setNull(String key)
    {
        setObject(key, null);
    }

    //##################################################
    //# basics :: convenience
    //##################################################

    /**
     * cast integer values to longs.
     */
    public Integer getInteger(String key)
    {
        return Kmu.toInteger(getObject(key));
    }

    public void setInteger(String key, Integer value)
    {
        setObject(key, Kmu.toLong(value));
    }

    //##################################################
    //# map
    //##################################################

    public KmJsonMap getMap(String key)
    {
        return (KmJsonMap)getObject(key);
    }

    public void setMap(String key, KmJsonMap value)
    {
        setObject(key, value);
    }

    public KmJsonMap setMap(String key)
    {
        KmJsonMap e = new KmJsonMap();
        setMap(key, e);
        return e;
    }

    //##################################################
    //# array
    //##################################################

    public KmJsonArray getArray(String key)
    {
        return (KmJsonArray)getObject(key);
    }

    public void setArray(String key, KmJsonArray value)
    {
        setObject(key, value);
    }

    public KmJsonArray setArray(String key)
    {
        KmJsonArray v = new KmJsonArray();
        setArray(key, v);
        return v;
    }

    //##################################################
    //# value
    //##################################################

    public Object getObject(String key)
    {
        if ( !hasKey(key) )
            return null;

        Object e = getInner().get(key);

        if ( e instanceof JSONArray )
            return new KmJsonArray((JSONArray)e);

        if ( e instanceof JSONObject )
            return new KmJsonMap((JSONObject)e);

        return e;
    }

    @SuppressWarnings("unchecked")
    public void setObject(String key, Object e)
    {
        if ( e instanceof KmJsonArray )
            e = ((KmJsonArray)e).getInner();

        if ( e instanceof KmJsonMap )
            e = ((KmJsonMap)e).getInner();

        getInner().put(key, e);
    }

    //##################################################
    //# size
    //##################################################

    @Override
    public int size()
    {
        return getInner().size();
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    //##################################################
    //# keys
    //##################################################

    public KmList<String> getKeys()
    {
        KmList<String> v;
        v = new KmList<String>();

        Set<?> keys = getInner().keySet();
        for ( Object key : keys )
            v.add((String)key);

        return v;
    }

    public KmList<String> getSortedKeys()
    {
        KmList<String> v;
        v = getKeys();
        v.sort();
        return v;
    }

    public boolean hasKey(String key)
    {
        return getInner().containsKey(key);
    }

    public void removeKey(String key)
    {
        getInner().remove(key);
    }

    public void clear()
    {
        getInner().clear();
    }

    //##################################################
    //# support
    //##################################################

    public JSONObject getInner()
    {
        return _inner;
    }

    //##################################################
    //# display
    //##################################################

    /**
     * By contract, the toString returns the json format.
     */
    @Override
    public final String toString()
    {
        return formatJson();
    }

    @Override
    public String formatJson()
    {
        return getInner().toJSONString();
    }

    @Override
    public String prettyPrint()
    {
        return KmJsonPrettyPrinter.format(this);
    }

    //##################################################
    //# char sequence
    //##################################################

    @Override
    public int length()
    {
        return toString().length();
    }

    @Override
    public char charAt(int index)
    {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return toString().subSequence(start, end);
    }
}
