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

import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.utility.Kmu;

public class ScListCoder
    extends ScAbstractCoder
{
    @Override
    public String getKey()
    {
        return CODER_LIST;
    }

    @Override
    public boolean matches(Object e)
    {
        return e instanceof List<?>;
    }

    @Override
    public void encode(ScEncoder encoder, Object o)
    {
        KmList<?> v = (KmList<?>)o;
        encoder._printInteger(v.size());
        for ( Object e : v )
            encoder.encode(e);
    }

    @Override
    public Object decode(ScDecoder decoder, String s)
    {
        int n = Kmu.parseInteger(s);
        KmList<Object> v = new KmList<>(n);
        for ( int i = 0; i < n; i++ )
            v.add(decoder.nextValue());
        return v;
    }

}
