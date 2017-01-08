/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.utility;

import java.util.Collection;

import com.kodemore.collection.KmMap;

/**
 * I am used to collect the results of the KmParameterParser.
 */
public class KmParameter
{
    //##################################################
    //# variables
    //##################################################

    private String  _key;
    private String  _value;
    private boolean _keyQuoted;
    private boolean _valueQuoted;

    //##################################################
    //# constructor
    //##################################################

    public KmParameter()
    {
        this(null, null);
    }

    public KmParameter(String key, String value)
    {
        _key = key;
        _value = value;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public void setKey(String e)
    {
        _key = e;
    }

    public boolean hasKey()
    {
        return Kmu.hasValue(_key);
    }

    public boolean hasKey(String s)
    {
        return Kmu.isEqual(_key, s);
    }

    public boolean getKeyQuoted()
    {
        return _keyQuoted;
    }

    public void setKeyQuoted(boolean e)
    {
        _keyQuoted = e;
    }

    public String getValue()
    {
        return _value;
    }

    public void setValue(String e)
    {
        _value = e;
    }

    public boolean hasValue()
    {
        return Kmu.hasValue(_value);
    }

    public boolean hasValue(String s)
    {
        return Kmu.isEqual(_value, s);
    }

    public boolean getValueQuoted()
    {
        return _valueQuoted;
    }

    public void setValueQuoted(boolean e)
    {
        _valueQuoted = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public Integer getIntegerValue()
    {
        return Kmu.parseInteger(_value);
    }

    public Double getDoubleValue()
    {
        return Kmu.parseDouble(_value);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return hasKey()
            ? _key + "=" + _value
            : _value;
    }

    //##################################################
    //# static convenience
    //##################################################

    public static KmMap<String,KmParameter> toKeyMap(Collection<KmParameter> v)
    {
        KmMap<String,KmParameter> m = new KmMap<>();
        for ( KmParameter e : v )
        {
            String k = e.getKey();
            if ( m.containsKey(k) )
                throw Kmu.newFatal(
                    "Cannot convert to map, found two parameters with the same key(%s).",
                    k);

            m.put(k, e);
        }
        return m;
    }
}
