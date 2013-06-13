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
public class KmJsonObject
    implements KmJsonObjectIF
{
    //##################################################
    //# variables
    //##################################################

    private JSONObject _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmJsonObject()
    {
        _inner = new JSONObject();
    }

    public KmJsonObject(JSONObject e)
    {
        _inner = e;
    }

    //##################################################
    //# basics
    //##################################################

    public String getString(String key)
    {
        return (String)_get(key);
    }

    public void setString(String key, CharSequence value)
    {
        if ( value == null )
            _set(key, null);
        else
            _set(key, value.toString());
    }

    public Boolean getBoolean(String key)
    {
        return (Boolean)_get(key);
    }

    public void setBoolean(String key, Boolean value)
    {
        _set(key, value);
    }

    public Integer getInteger(String key)
    {
        return Kmu.toInteger(_get(key));
    }

    public void setInteger(String key, Integer value)
    {
        _set(key, value);
    }

    public Long getLong(String key)
    {
        return (Long)_get(key);
    }

    public void setLong(String key, Long value)
    {
        _set(key, value);
    }

    public Double getDouble(String key)
    {
        return (Double)_get(key);
    }

    public void setDouble(String key, Double value)
    {
        _set(key, value);
    }

    public void setNull(String key)
    {
        _set(key, null);
    }

    //##################################################
    //# object
    //##################################################

    public KmJsonObject getObject(String key)
    {
        JSONObject e = (JSONObject)_get(key);

        return e == null
            ? null
            : new KmJsonObject(e);
    }

    public void setObject(String key, KmJsonObject value)
    {
        if ( value == null )
            _set(key, null);
        else
            _set(key, value.getInner());
    }

    public KmJsonObject setObject(String key)
    {
        KmJsonObject e = new KmJsonObject();
        setObject(key, e);
        return e;
    }

    //##################################################
    //# list
    //##################################################

    public KmJsonList getList(String key)
    {
        JSONArray e = (JSONArray)_get(key);

        return e == null
            ? null
            : new KmJsonList(e);
    }

    public void setList(String key, KmJsonList value)
    {
        if ( value == null )
            _set(key, null);
        else
            _set(key, value.getInner());
    }

    public KmJsonList setList(String key)
    {
        KmJsonList v = new KmJsonList();
        setList(key, v);
        return v;
    }

    //##################################################
    //# value
    //##################################################

    public Object getValue(String key)
    {
        return _get(key);
    }

    //##################################################
    //# misc 
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

    public int size()
    {
        return getInner().size();
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    //##################################################
    //# support
    //##################################################

    public JSONObject getInner()
    {
        return _inner;
    }

    private Object _get(String key)
    {
        return hasKey(key)
            ? getInner().get(key)
            : null;
    }

    @SuppressWarnings("unchecked")
    private void _set(String key, Object value)
    {
        getInner().put(key, value);
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
