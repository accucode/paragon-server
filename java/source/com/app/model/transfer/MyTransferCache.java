package com.app.model.transfer;

import com.kodemore.collection.KmMap;

/**
 * I am used to cache the domain models being transferred,
 * and to provide convenient access to the 'from => to' mapping
 * throughout the transfer.
 */
public class MyTransferCache<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Find the new (to) values based on the old (from) value.
     * from => to.
     */
    private KmMap<T,T> _map;

    //##################################################
    //# constructor
    //##################################################

    public MyTransferCache()
    {
        _map = new KmMap<>();
    }

    //##################################################
    //# map
    //##################################################

    public void map(T from, T to)
    {
        _map.put(from, to);
    }

    public T find(T from)
    {
        return _map.get(from);
    }
}
