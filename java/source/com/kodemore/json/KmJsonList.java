package com.kodemore.json;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kodemore.collection.KmList;

/**
 * Wraps the json-simple library.
 * http://code.google.com/p/json-simple/
 * Apache License 2.0
 */
public class KmJsonList
    implements KmJsonObjectIF, Iterable<Object>
{
    //##################################################
    //# variables
    //##################################################

    private JSONArray _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmJsonList()
    {
        _inner = new JSONArray();
    }

    public KmJsonList(JSONArray e)
    {
        _inner = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public int size()
    {
        return getInner().size();
    }

    @Override
    public Iterator<Object> iterator()
    {
        return toObjectList().iterator();
    }

    public KmList<Object> toObjectList()
    {
        KmList<Object> v = new KmList<Object>();

        int n = size();
        for ( int i = 0; i < n; i++ )
            v.add(_getObjectAt(i));

        return v;
    }

    //##################################################
    //# nulls
    //##################################################

    public boolean isNullAt(int index)
    {
        return _getObjectAt(index) == null;
    }

    public void setNullAt(int index)
    {
        _setObjectAt(index, null);
    }

    public void addNull()
    {
        _addObject(null);
    }

    //##################################################
    //# string
    //##################################################

    public String getStringAt(int index)
    {
        return (String)_getObjectAt(index);
    }

    public void setStringAt(int index, String value)
    {
        _setObjectAt(index, value);
    }

    public void addString(String value)
    {
        _addObject(value);
    }

    public void addStrings(String... arr)
    {
        for ( String e : arr )
            addString(e);
    }

    public void addStrings(List<String> v)
    {
        if ( v == null )
            return;

        for ( String e : v )
            addString(e);
    }

    public KmList<String> toStringList()
    {
        KmList<String> v = new KmList<String>();

        for ( Object e : this )
            v.add((String)e);

        return v;
    }

    //##################################################
    //# boolean
    //##################################################

    public Boolean getBooleanAt(int index)
    {
        return (Boolean)_getObjectAt(index);
    }

    public void setBooleanAt(int index, Boolean value)
    {
        _setObjectAt(index, value);
    }

    public void addBoolean(Boolean value)
    {
        _addObject(value);
    }

    //##################################################
    //# integer
    //##################################################

    public Integer getIntegerAt(int index)
    {
        return (Integer)_getObjectAt(index);
    }

    public void setIntegerAt(int index, Integer value)
    {
        _setObjectAt(index, value);
    }

    public void addInteger(Integer value)
    {
        _addObject(value);
    }

    //##################################################
    //# longs
    //##################################################

    public Long getLongAt(int index)
    {
        return (Long)_getObjectAt(index);
    }

    public void setLongAt(int index, Long value)
    {
        _setObjectAt(index, value);
    }

    public void addLong(Long value)
    {
        _addObject(value);
    }

    //##################################################
    //# doubles
    //##################################################

    public Double getDoubleAt(int index)
    {
        return (Double)_getObjectAt(index);
    }

    public void setDoubleAt(int index, Double value)
    {
        _setObjectAt(index, value);
    }

    public void addDouble(Double value)
    {
        _addObject(value);
    }

    //##################################################
    //# object
    //##################################################

    public KmJsonObject getObjectAt(int index)
    {
        JSONObject e = (JSONObject)_getObjectAt(index);

        return e == null
            ? null
            : new KmJsonObject(e);
    }

    public void setObjectAt(int index, KmJsonObject value)
    {
        JSONObject inner = value == null
            ? null
            : value.getInner();

        _setObjectAt(index, inner);
    }

    public void addObject(KmJsonObject value)
    {
        JSONObject inner = value == null
            ? null
            : value.getInner();

        _addObject(inner);
    }

    public KmJsonObject addObject()
    {
        KmJsonObject e = new KmJsonObject();
        addObject(e);
        return e;
    }

    //##################################################
    //# list
    //##################################################

    public KmJsonList getList(int index)
    {
        JSONArray e = (JSONArray)_getObjectAt(index);

        return e == null
            ? null
            : new KmJsonList(e);
    }

    public void setList(int index, KmJsonList value)
    {
        if ( value == null )
            _setObjectAt(index, null);
        else
            _setObjectAt(index, value.getInner());
    }

    public void addList(KmJsonList value)
    {
        if ( value == null )
            _addObject(null);
        else
            _addObject(value.getInner());
    }

    //##################################################
    //# support
    //##################################################

    public JSONArray getInner()
    {
        return _inner;
    }

    private Object _getObjectAt(int index)
    {
        return getInner().get(index);
    }

    @SuppressWarnings("unchecked")
    private void _setObjectAt(int index, Object value)
    {
        getInner().set(index, value);
    }

    @SuppressWarnings("unchecked")
    private void _addObject(Object value)
    {
        getInner().add(value);
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
