package com.kodemore.types;

import com.kodemore.utility.Kmu;

/**
 * I define a key-value pair.
 */
public class KmTuple<K, V>
{
    //##################################################
    //# static
    //##################################################

    public static <K, V> KmTuple<K,V> create(K key, V value)
    {
        KmTuple<K,V> e;
        e = new KmTuple<>();
        e.setKey(key);
        e.setValue(value);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    private K _key;
    private V _value;

    //##################################################
    //# constructor
    //##################################################

    public KmTuple()
    {
        // none
    }

    //##################################################
    //# key
    //##################################################

    public K getKey()
    {
        return _key;
    }

    public void setKey(K e)
    {
        _key = e;
    }

    public boolean hasKey(K e)
    {
        return Kmu.isEqual(getKey(), e);
    }

    public Comparable<?> getComparableKey()
    {
        K key = getKey();
        return key instanceof Comparable
            ? (Comparable<?>)key
            : key + "";
    }

    //##################################################
    //# value
    //##################################################

    public V getValue()
    {
        return _value;
    }

    public void setValue(V e)
    {
        _value = e;
    }

    public boolean hasValue(V e)
    {
        return Kmu.isEqual(getValue(), e);
    }

    public Comparable<?> getComparableValue()
    {
        V value = getValue();
        return value instanceof Comparable
            ? (Comparable<?>)value
            : value + "";
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("%s => %s", getKey(), getValue());
    }
}
