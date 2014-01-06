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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * I subclass ArrayList in order to provide various convenience methods.
 */
public class KmCompositeIterator<T>
    implements Iterator<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmList<Iterator<? extends T>> _iterators;
    private int                           _index;
    private int                           _previousIndex;

    //##################################################
    //# constructor
    //##################################################

    public KmCompositeIterator()
    {
        _iterators = new KmList<Iterator<? extends T>>();
    }

    //##################################################
    //# accessing
    //##################################################

    public <E extends T> void add(E e)
    {
        KmList<T> v = new KmList<T>();
        v.add(e);
        addAll(v);
    }

    public void addNonNull(T e)
    {
        if ( e != null )
            add(e);
    }

    public <E extends T> void addAll(Collection<E> e)
    {
        if ( e == null )
            return;
        addAll(e.iterator());
    }

    public <E extends T> void addAll(Iterator<E> e)
    {
        if ( e == null )
            return;
        _iterators.add(e);
    }

    //##################################################
    //# iterator
    //##################################################

    @Override
    public boolean hasNext()
    {
        while ( true )
        {
            if ( _index >= _iterators.size() )
                return false;

            if ( _iterators.get(_index).hasNext() )
                return true;

            _index++;
        }
    }

    @Override
    public T next()
    {
        while ( true )
        {
            if ( _index >= _iterators.size() )
                throw new NoSuchElementException();

            Iterator<? extends T> i = _iterators.get(_index);
            if ( i.hasNext() )
            {
                _previousIndex = _index;
                return i.next();
            }

            _index++;
        }
    }

    @Override
    public void remove()
    {
        _iterators.get(_previousIndex).remove();
    }

}
