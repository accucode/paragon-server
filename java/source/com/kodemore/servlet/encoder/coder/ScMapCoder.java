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

package com.kodemore.servlet.encoder.coder;

import java.util.Map;
import java.util.Set;

import com.kodemore.collection.KmMap;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.utility.Kmu;

public class ScMapCoder
    extends ScAbstractCoder
{
    @Override
    public String getKey()
    {
        return CODER_MAP;
    }

    @Override
    public boolean matches(Object e)
    {
        return e instanceof Map<?,?>;
    }

    @Override
    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    public void encode(ScEncoder encoder, Object o)
    {
        Map map = (Map)o;
        Set<Map.Entry> entrySet = map.entrySet();

        encoder._printInteger(map.size());
        for ( Map.Entry me : entrySet )
        {
            encoder.encode(me.getKey());
            encoder.encode(me.getValue());
        }
    }

    @Override
    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    public Object decode(ScDecoder decoder, String s)
    {
        int n = Kmu.parseInteger(s);
        KmMap map = new KmMap();
        for ( int i = 0; i < n; i++ )
        {
            Object key = decoder.nextValue();
            Object value = decoder.nextValue();
            map.put(key, value);
        }
        return map;
    }

}
