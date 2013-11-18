package com.kodemore.json;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * Wraps the json-simple library.
 * http://code.google.com/p/json-simple/
 * Apache License 2.0
 */
public class KmJsonArray
    implements KmJsonObjectIF, Iterable<Object>
{
    //##################################################
    //# variables
    //##################################################

    private JSONArray _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmJsonArray()
    {
        _inner = new JSONArray();
    }

    public KmJsonArray(JSONArray e)
    {
        _inner = e;
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
    //# objects
    //##################################################

    public Object getObjectAt(int index)
    {
        Object e = getInner().get(index);

        if ( e instanceof JSONArray )
            return new KmJsonArray((JSONArray)e);

        if ( e instanceof JSONObject )
            return new KmJsonMap((JSONObject)e);

        return e;
    }

    @SuppressWarnings("unchecked")
    public void setObjectAt(int index, Object e)
    {
        if ( e instanceof KmJsonArray )
            e = ((KmJsonArray)e).getInner();

        if ( e instanceof KmJsonMap )
            e = ((KmJsonMap)e).getInner();

        getInner().set(index, e);
    }

    @SuppressWarnings("unchecked")
    public void addObject(Object e)
    {
        if ( e instanceof KmJsonArray )
            e = ((KmJsonArray)e).getInner();

        if ( e instanceof KmJsonMap )
            e = ((KmJsonMap)e).getInner();

        getInner().add(e);
    }

    public KmList<Object> toObjectList()
    {
        KmList<Object> v = new KmList<Object>();

        int n = size();
        for ( int i = 0; i < n; i++ )
            v.add(getObjectAt(i));

        return v;
    }

    @Override
    public Iterator<Object> iterator()
    {
        return toObjectList().iterator();
    }

    //##################################################
    //# nulls
    //##################################################

    public boolean isNullAt(int index)
    {
        return getObjectAt(index) == null;
    }

    public void setNullAt(int index)
    {
        setObjectAt(index, null);
    }

    public void addNull()
    {
        addObject(null);
    }

    //##################################################
    //# string
    //##################################################

    public String getStringAt(int index)
    {
        return (String)getObjectAt(index);
    }

    public void setStringAt(int index, String value)
    {
        setObjectAt(index, value);
    }

    public void addString(String value)
    {
        addObject(value);
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
        return (Boolean)getObjectAt(index);
    }

    public void setBooleanAt(int index, Boolean value)
    {
        setObjectAt(index, value);
    }

    public void addBoolean(Boolean value)
    {
        addObject(value);
    }

    //##################################################
    //# integer
    //##################################################

    public Integer getIntegerAt(int index)
    {
        return Kmu.toInteger(getLongAt(index));
    }

    public void setIntegerAt(int index, Integer value)
    {
        setLongAt(index, Kmu.toLong(value));
    }

    public void addInteger(Integer value)
    {
        addLong(Kmu.toLong(value));
    }

    //##################################################
    //# longs
    //##################################################

    public Long getLongAt(int index)
    {
        return (Long)getObjectAt(index);
    }

    public void setLongAt(int index, Long value)
    {
        setObjectAt(index, value);
    }

    public void addLong(Long value)
    {
        addObject(value);
    }

    //##################################################
    //# doubles
    //##################################################

    public Double getDoubleAt(int index)
    {
        return (Double)getObjectAt(index);
    }

    public void setDoubleAt(int index, Double value)
    {
        setObjectAt(index, value);
    }

    public void addDouble(Double value)
    {
        addObject(value);
    }

    //##################################################
    //# map
    //##################################################

    public KmJsonMap getMapAt(int index)
    {
        return (KmJsonMap)getObjectAt(index);
    }

    public void setMapAt(int index, KmJsonMap value)
    {
        setObjectAt(index, value);
    }

    public KmJsonMap addMap()
    {
        KmJsonMap e = new KmJsonMap();
        addMap(e);
        return e;
    }

    public void addMap(KmJsonMap value)
    {
        addObject(value);
    }

    public KmJsonMap getFirstMap()
    {
        return getMapAt(0);
    }

    public KmList<KmJsonMap> getAllAsMaps()
    {
        KmList<KmJsonMap> v = new KmList<KmJsonMap>();

        for ( Object e : toObjectList() )
            v.add((KmJsonMap)e);

        return v;
    }

    //##################################################
    //# array
    //##################################################

    public KmJsonArray getArrayAt(int index)
    {
        return (KmJsonArray)getObjectAt(index);
    }

    public void setArrayAt(int index, KmJsonArray value)
    {
        setObjectAt(index, value);
    }

    public KmJsonArray addArray()
    {
        KmJsonArray e = new KmJsonArray();
        addArray(e);
        return e;
    }

    public void addArray(KmJsonArray value)
    {
        addObject(value);
    }

    //##################################################
    //# support
    //##################################################

    public JSONArray getInner()
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
