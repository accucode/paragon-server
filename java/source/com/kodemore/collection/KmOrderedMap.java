/*
  Copyright (c) 2005-2018 www.kodemore.com

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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.kodemore.types.KmTuple;

public class KmOrderedMap<K, V>
    extends LinkedHashMap<K,V>
{
    //##################################################
    //# accessing
    //##################################################

    public KmList<K> getKeys()
    {
        KmList<K> v;
        v = new KmList<>();
        v.addAll(keySet());
        return v;
    }

    public KmList<V> getValues()
    {
        KmList<V> v;
        v = new KmList<>();
        v.addAll(values());
        return v;
    }

    public KmList<KmTuple<K,V>> getTuples()
    {
        KmList<KmTuple<K,V>> v = new KmList<>();

        for ( Map.Entry<K,V> e : entrySet() )
            v.add(KmTuple.create(e.getKey(), e.getValue()));

        return v;
    }

    public void replaceAll(List<KmTuple<K,V>> v)
    {
        clear();

        for ( KmTuple<K,V> e : v )
            put(e.getKey(), e.getValue());
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnKeys()
    {
        KmList<KmTuple<K,V>> v;
        v = getTuples();
        v.sortOn(KmTuple::getComparableKey);

        replaceAll(v);
    }

    public void sortOnValues()
    {
        KmList<KmTuple<K,V>> v;
        v = getTuples();
        v.sortOn(KmTuple::getComparableValue);

        replaceAll(v);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }
}
