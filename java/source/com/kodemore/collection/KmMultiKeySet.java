package com.kodemore.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to track the existence of multi-key values.
 */
@SuppressWarnings(
{
    "unchecked", "rawtypes"
})
public class KmMultiKeySet
{
    //##################################################
    //# variables
    //##################################################

    private Map _values;

    //##################################################
    //# constructor
    //##################################################

    public KmMultiKeySet()
    {
        _values = new HashMap();
    }

    //##################################################
    //# add
    //##################################################

    public void add(Object k1)
    {
        getSafe(_values, k1);
    }

    public void add(Object k1, Object k2)
    {
        getSafe(getSafe(_values, k1), k2);
    }

    public void add(Object k1, Object k2, Object k3)
    {
        getSafe(getSafe(getSafe(_values, k1), k2), k3);
    }

    public void add(Object k1, Object k2, Object k3, Object k4)
    {
        getSafe(getSafe(getSafe(getSafe(_values, k1), k2), k3), k4);
    }

    //##################################################
    //# contains
    //##################################################

    public boolean contains(Object k1)
    {
        return _values.containsKey(k1);
    }

    public boolean contains(Object k1, Object k2)
    {
        Map m = _values;

        m = (Map)m.get(k1);
        if ( m == null )
            return false;

        return m.containsKey(k2);
    }

    public boolean contains(Object k1, Object k2, Object k3)
    {
        Map m = _values;

        m = (Map)m.get(k1);
        if ( m == null )
            return false;

        m = (Map)m.get(k2);
        if ( m == null )
            return false;

        return m.containsKey(k3);
    }

    public boolean contains(Object k1, Object k2, Object k3, Object k4)
    {
        Map m = _values;

        m = (Map)m.get(k1);
        if ( m == null )
            return false;

        m = (Map)m.get(k2);
        if ( m == null )
            return false;

        m = (Map)m.get(k3);
        if ( m == null )
            return false;

        return m.containsKey(k4);
    }

    //##################################################
    //# support
    //##################################################

    private Map getSafe(Map values, Object key)
    {
        Map m = (Map)values.get(key);
        if ( m == null )
        {
            m = new HashMap();
            values.put(key, m);
        }
        return m;
    }

}
