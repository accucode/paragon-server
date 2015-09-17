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

package com.kodemore.servlet.variable;

import java.util.Iterator;
import java.util.List;

import com.kodemore.collection.KmList;

/**
 * I am used to store a list of values.  The elements must
 * be compatible with ScEncoder if you want to persist
 * state to the page session.
 *
 * Note that the value defaults to an EMPTY list and should
 * never be null.
 *
 * Also, getValue() returns a shallow copy to avoid inadvertent
 * mutations.
 */
public class ScLocalList<T>
    extends ScSimpleLocal<KmList<T>>
    implements Iterable<T>
{
    //##################################################
    //# constructor
    //##################################################

    public ScLocalList()
    {
        super(new KmList<T>());
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public KmList<T> getValue()
    {
        return _getValue().getShallowCopy();
    }

    @Override
    public void setValue(KmList<T> v)
    {
        _setValue(v.getShallowCopy());
    }

    //##################################################
    //# accessing (mutating)
    //##################################################

    public void add(T e)
    {
        KmList<T> copy;
        copy = getValue();
        copy.add(e);

        _setValue(copy);
    }

    public void addAll(List<T> v)
    {
        KmList<T> copy;
        copy = getValue();
        copy.addAll(v);

        _setValue(copy);
    }

    public void remove(T e)
    {
        KmList<T> copy;
        copy = getValue();
        copy.remove(e);

        _setValue(copy);
    }

    public void removeLast()
    {
        KmList<T> copy;
        copy = getValue();
        copy.removeLast();

        _setValue(copy);
    }

    public void removeLastSafe()
    {
        KmList<T> copy;
        copy = getValue();
        copy.removeLastSafe();

        _setValue(copy);
    }

    public void clear()
    {
        KmList<T> copy;
        copy = getValue();
        copy.clear();

        _setValue(copy);
    }

    @Override
    public void clearValue()
    {
        clear();
    }

    //##################################################
    //# accessing (non-mutating)
    //##################################################

    public boolean isEmpty()
    {
        return _getValue().isEmpty();
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    public T getValueAt(int i)
    {
        return _getValue().get(i);
    }

    public T getFirst()
    {
        return _getValue().getFirst();
    }

    public T getLast()
    {
        return _getValue().getLast();
    }

    public T getLastSafe()
    {
        return _getValue().getLastSafe();
    }

    public int size()
    {
        return _getValue().size();
    }

    public boolean contains(T e)
    {
        return _getValue().contains(e);
    }

    @Override
    public Iterator<T> iterator()
    {
        return _getValue().iterator();
    }

    public boolean isLast(T e)
    {
        return _getValue().isLast(e);
    }

    //##################################################
    //# support
    //##################################################

    public KmList<T> _getValue()
    {
        return super.getValue();
    }

    public void _setValue(KmList<T> v)
    {
        super.setValue(v);
    }
}
