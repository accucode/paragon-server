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

package com.kodemore.edi;

import static com.kodemore.edi.KmEdiConstantsIF.EMPTY_STRING_ARRAY;
import static com.kodemore.edi.KmEdiConstantsIF.EMPTY_VALUE;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmEdiElement
{
    //##################################################
    //# variables
    //##################################################

    private String[] _values;

    //##################################################
    //# constructor
    //##################################################

    public KmEdiElement()
    {
        _values = EMPTY_STRING_ARRAY;
    }

    public KmEdiElement(KmList<String> v)
    {
        int n = v.size();
        _values = new String[n];
        for ( int i = 0; i < n; i++ )
            _values[i] = v.get(i);
    }

    //##################################################
    //# value (first)
    //##################################################

    public String getValue()
    {
        return getValue(0);
    }

    public void setValue(String s)
    {
        if ( _values.length != 1 )
            _values = new String[1];
        _values[0] = s;
    }

    public boolean hasValue()
    {
        return Kmu.hasValue(getValue());
    }

    public boolean hasValue(String s)
    {
        return Kmu.isEqual(getValue(), s);
    }

    //##################################################
    //# value (by index)
    //##################################################

    public String getValue(int i)
    {
        return i < _values.length
            ? _values[i]
            : EMPTY_VALUE;
    }

    public void setValue(int i, String s)
    {
        if ( s == null )
            s = EMPTY_VALUE;
        ensureIndex(i);
        _values[i] = s;
    }

    public boolean hasValue(int index)
    {
        return Kmu.hasValue(getValue(index));
    }

    public String[] getValues()
    {
        return _values;
    }

    public int getValueCount()
    {
        return _values.length;
    }

    //##################################################
    //# private
    //##################################################

    public void ensureIndex(int index)
    {
        if ( _values.length > index )
            return;
        String[] arr = new String[index + 1];
        for ( int i = 0; i < _values.length; i++ )
            arr[i] = _values[i];
        for ( int i = _values.length; i < index + 1; i++ )
            arr[i] = EMPTY_VALUE;
        _values = arr;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isEmpty()
    {
        return _values.length == 0;
    }

    public boolean isSimple()
    {
        return _values.length == 1;
    }

    public boolean isComposite()
    {
        return _values.length > 1;
    }

}
