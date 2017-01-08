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

package com.kodemore.servlet.encoder;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.servlet.encoder.coder.ScCoderIF;
import com.kodemore.servlet.encoder.coder.ScCoderRegistry;
import com.kodemore.time.KmDate;
import com.kodemore.types.KmQuantity;
import com.kodemore.utility.Kmu;

public class ScDecoder
    implements ScEncoderConstantsIF
{
    //##################################################
    //# static
    //##################################################

    public static Object staticDecode(String s)
    {
        ScDecoder p;
        p = new ScDecoder();
        p.decode(s);

        if ( p.isEmpty() )
            return null;

        return p.get();
    }

    public static KmList<Object> staticDecode(KmList<String> sv)
    {
        KmList<Object> v = new KmList<>();
        for ( String s : sv )
            v.add(staticDecode(s));
        return v;
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<Object> _values;

    private KmList<String> _tokens;
    private int            _tokenIndex;
    private int            _index;

    //##################################################
    //# constructor
    //##################################################

    public ScDecoder()
    {
        //
    }

    public ScDecoder(String s)
    {
        decode(s);
    }

    //##################################################
    //# public
    //##################################################

    public void decode(String s)
    {
        _values = new KmList<>();

        if ( s == null )
            return;

        s = s.trim();
        if ( Kmu.isEmpty(s) )
            return;

        _tokens = Kmu.tokenize(s, COMMA);
        _tokenIndex = 0;

        int n = _tokens.size();
        while ( _tokenIndex < n )
            _values.add(nextValue());
        _index = 0;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<?> getValues()
    {
        return _values;
    }

    public int getSize()
    {
        return _values.size();
    }

    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    //##################################################
    //# convenience
    //##################################################

    public Object get(int i)
    {
        return _values.get(i);
    }

    public boolean isNull(int i)
    {
        return get(i) == null;
    }

    public String getString(int i)
    {
        return (String)get(i);
    }

    public Integer getInteger(int i)
    {
        return (Integer)get(i);
    }

    public Double getDouble(int i)
    {
        return (Double)get(i);
    }

    public KmDate getDate(int i)
    {
        return (KmDate)get(i);
    }

    public KmQuantity getQuantity(int i)
    {
        return (KmQuantity)get(i);
    }

    public Boolean getBoolean(int i)
    {
        return (Boolean)get(i);
    }

    public KmList<?> getList(int i)
    {
        return (KmList<?>)get(i);
    }

    public KmMap<?,?> getMap(int i)
    {
        return (KmMap<?,?>)get(i);
    }

    //##################################################
    //# convenience (auto increment)
    //##################################################

    public boolean isNull()
    {
        // does not increment
        return isNull(_index);
    }

    public void skip()
    {
        _index++;
    }

    public Object get()
    {
        return get(_index++);
    }

    public String getString()
    {
        return getString(_index++);
    }

    @SuppressWarnings("unchecked")
    public String[] getStringArray()
    {
        KmList<String> v = (KmList<String>)getList();

        if ( v == null )
            return null;

        return v.toArray(new String[v.size()]);
    }

    public Integer getInteger()
    {
        return getInteger(_index++);
    }

    public Double getDouble()
    {
        return getDouble(_index++);
    }

    public KmDate getDate()
    {
        return getDate(_index++);
    }

    public KmQuantity getQuantity()
    {
        return getQuantity(_index++);
    }

    public Boolean getBoolean()
    {
        return getBoolean(_index++);
    }

    public KmList<?> getList()
    {
        return getList(_index++);
    }

    public KmMap<?,?> getMap()
    {
        return getMap(_index++);
    }

    //##################################################
    //# private
    //##################################################

    public Object nextValue()
    {
        String c = _tokens.get(_tokenIndex++);
        String s = _tokens.get(_tokenIndex++);
        s = descape(s);

        ScCoderIF coder = getRegistry().findKey(c);
        if ( coder == null )
            throw Kmu.newFatal("Cannot find decoder for: (%s)", c);

        return coder.decode(this, s);
    }

    private ScCoderRegistry getRegistry()
    {
        return ScCoderRegistry.instance;
    }

    private String descape(String s)
    {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( c != SLASH )
            {
                sb.append(c);
                continue;
            }
            String sHex = s.substring(i + 1, i + 3);
            byte bHex = Kmu.parseHexByte(sHex);
            sb.append((char)bHex);
            i += 2;
        }
        return sb.toString();
    }
}
