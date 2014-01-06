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

import com.kodemore.utility.Kmu;

public class KmSparseArray<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmList<Element> _data;
    private T               _defaultValue;

    //##################################################
    //# constructors
    //##################################################

    public KmSparseArray()
    {
        _data = new KmList<Element>();
        _defaultValue = null;
    }

    //##################################################
    //# default
    //##################################################

    public T getDefaultValue()
    {
        return _defaultValue;
    }

    public void setDefaultValue(T e)
    {
        _defaultValue = e;
    }

    private boolean isDefault(T e)
    {
        return Kmu.isEqual(_defaultValue, e);
    }

    //##################################################
    //# value
    //##################################################

    public T getValueAt(int i)
    {
        return getValueAt(i, _defaultValue);
    }

    public T getValueAt(int i, T def)
    {
        Element e = findIndex(i);
        if ( e == null )
            return def;

        return e.value;
    }

    public void setValueAt(int i, T value)
    {
        Element e = findIndex(i);
        if ( e == null )
        {
            if ( isDefault(value) )
                return;

            e = new Element();
            e.index = i;
            e.value = value;
            _data.add(e);
            return;
        }

        if ( isDefault(value) )
            _data.remove(e);

        e.value = value;
    }

    public void removeValueAt(int i)
    {
        Element e = findIndex(i);
        if ( e != null )
            _data.remove(e);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasValueAt(int i)
    {
        return getValueAt(i) != null;
    }

    //##################################################
    //# supprort
    //##################################################

    private Element findIndex(int index)
    {
        for ( Element e : _data )
            if ( e.index == index )
                return e;

        return null;
    }

    //##################################################
    //# element class
    //##################################################

    private class Element
    {
        int index;
        T   value;
    }

}
