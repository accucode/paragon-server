package com.kodemore.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Used to track the existence of multi-key values.
 * Null values are supported for both keys, and the value.
 */
public class KmTwoKeyMap<K1, K2, V>
{
    //##################################################
    //# variables
    //##################################################

    private Map<K1,Map<K2,V>> _values;

    //##################################################
    //# constructor
    //##################################################

    public KmTwoKeyMap()
    {
        _values = new HashMap<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public V get(K1 key1, K2 key2)
    {
        Map<K2,V> map = _values.get(key1);

        if ( map == null )
            return null;

        return map.get(key2);
    }

    public V put(K1 key1, K2 key2, V value)
    {
        Map<K2,V> map = _values.get(key1);

        if ( map == null )
        {
            map = new HashMap<>();
            _values.put(key1, map);
        }

        return map.put(key2, value);
    }

    public boolean contains(K1 key1)
    {
        Map<K2,V> map = _values.get(key1);

        return map != null && !map.isEmpty();
    }

    public boolean contains(K1 key1, K2 key2)
    {
        Map<K2,V> map = _values.get(key1);

        return map != null && map.containsKey(key2);
    }

    public void remove(K1 key1)
    {
        _values.remove(key1);
    }

    public V remove(K1 key1, K2 key2)
    {
        Map<K2,V> map = _values.get(key1);

        if ( map == null )
            return null;

        return map.remove(key2);
    }

    public int size()
    {
        int n = 0;

        for ( Map<K2,V> map : _values.values() )
            n += map.size();

        return n;
    }

    public void clear()
    {
        _values.clear();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmList<K1> getKeyList1()
    {
        Set<K1> set = _values.keySet();

        KmList<K1> v;
        v = new KmList<>();
        v.addAll(set);
        return v;
    }

    public KmList<K2> getKeyList2For(K1 key1)
    {
        Map<K2,V> map = _values.get(key1);

        if ( map == null )
            return new KmList<>();

        KmList<K2> v;
        v = new KmList<>();
        v.addAll(map.keySet());
        return v;
    }
}
