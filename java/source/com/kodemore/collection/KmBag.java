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

import java.util.Collection;

/**
 * I am like a set except that I count how many times each singleton was added.
 */
public class KmBag<E>
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<E,Integer> _map = new KmMap<E,Integer>();

    //##################################################
    //# accessing
    //##################################################

    public KmList<E> getKeys()
    {
        return _map.getKeys();
    }

    public Integer getCount(E e)
    {
        Integer i = _map.get(e);
        return i == null
            ? 0
            : i;
    }

    public Integer getTotalCount()
    {
        int n = 0;
        for ( E e : getKeys() )
            n += getCount(e);
        return n;
    }

    public int size()
    {
        return _map.size();
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
    //# add
    //##################################################

    public void add(E e)
    {
        _add(e);
    }

    public void add(E e, int n)
    {
        _add(e, n);
    }

    public void addAll(Collection<? extends E> v)
    {
        for ( E e : v )
            add(e);
    }

    public void addNonNull(E e)
    {
        if ( e != null )
            add(e);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean containsAll(KmBag<E> b)
    {
        for ( E e : b.getKeys() )
            if ( getCount(e) < b.getCount(e) )
                return false;
        return true;
    }

    public boolean isSame(KmBag<E> b)
    {
        if ( size() != b.size() )
            return false;

        for ( E e : getKeys() )
            if ( !getCount(e).equals(b.getCount(e)) )
                return false;

        return true;
    }

    //##################################################
    //# convenience
    //##################################################

    public E getMinimum()
    {
        return getKeys().getMinimum();
    }

    public E getMaximum()
    {
        return getKeys().getMaximum();
    }

    //##################################################
    //# private
    //##################################################

    public void _add(E e)
    {
        _add(e, 1);
    }

    public void _add(E e, int n)
    {
        Integer nn = _map.get(e);
        if ( nn != null )
            n += nn;
        _map.put(e, n);
    }

}
