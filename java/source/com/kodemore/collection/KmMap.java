/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.collection;

import java.util.HashMap;
import java.util.Map;

import com.kodemore.utility.KmAssociation;
import com.kodemore.utility.Kmu;

/**
 * I subclass HashMap in order to provide various convenience methods.
 */
public class KmMap<K, V>
    extends HashMap<K,V>
{
    //##################################################
    //# constructor
    //##################################################

    public KmMap()
    {
        super();
    }

    public KmMap(int initialCapacity, float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<K> getKeys()
    {
        KmList<K> v = new KmList<>();
        v.addAll(keySet());
        return v;
    }

    public KmList<K> getSortedKeys()
    {
        KmList<K> v;
        v = getKeys();
        v.sort();
        return v;
    }

    public KmList<V> getValues()
    {
        KmList<V> v;
        v = new KmList<>();
        v.addAll(values());
        return v;
    }

    public KmList<K> getKeysFor(V value)
    {
        KmList<K> keys = new KmList<>();

        for ( K key : getKeys() )
            if ( Kmu.isEqual(get(key), value) )
                keys.add(key);

        return keys;
    }

    public K getFirstKeyFor(V value)
    {
        return getKeysFor(value).getFirstSafe();
    }

    public void putIfMissing(K key, V value)
    {
        if ( !containsKey(key) )
            put(key, value);
    }

    public V getAny()
    {
        if ( isEmpty() )
            return null;

        return get(keySet().iterator().next());
    }

    public KmMap<K,V> getShallowCopy()
    {
        KmMap<K,V> m = new KmMap<>();

        for ( Entry<K,V> e : entrySet() )
            m.put(e.getKey(), e.getValue());

        return m;
    }

    public KmList<KmAssociation<K,V>> getAssociations()
    {
        KmList<KmAssociation<K,V>> v = new KmList<>();

        for ( Map.Entry<K,V> e : entrySet() )
            v.add(new KmAssociation<>(e.getKey(), e.getValue()));

        return v;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    //##################################################
    //# display
    //##################################################

    public void print()
    {
        int pad = getMaximumKeyLength();
        for ( K k : getSortedKeys() )
        {
            String key = Kmu.rightPad(formatKey(k), pad);
            String value = formatValue(get(k));
            System.out.printf("%s = %s%n", key, value);
        }
    }

    public int getMaximumKeyLength()
    {
        int n = 0;

        for ( K k : getKeys() )
            n = Math.max(n, formatKey(k).length());

        return n;
    }

    public String formatKey(K e)
    {
        return e + "";
    }

    public String formatValue(V e)
    {
        return e + "";
    }

}
