/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.servlet.result;

import com.kodemore.servlet.ScServletData;

public class ScSimpleResult
    extends ScAbstractResult
{
    //##################################################
    //# variables
    //##################################################

    private byte[]  _value;
    private boolean _httpNoCache;

    //##################################################
    //# value
    //##################################################

    public byte[] getValue()
    {
        return _value;
    }

    public void setValue(byte[] e)
    {
        _value = e;
    }

    public void setValue(String e)
    {
        _value = e.getBytes();
    }

    //##################################################
    //# http no cache
    //##################################################

    public boolean getHttpNoCache()
    {
        return _httpNoCache;
    }

    public void setHttpNoCache(boolean e)
    {
        _httpNoCache = e;
    }

    public void setHttpNoCache()
    {
        setHttpNoCache(true);
    }

    //##################################################
    //# misc
    //##################################################

    @Override
    public int getLength()
    {
        return _value.length;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyTo(ScServletData data)
    {
        data.setContentType(getContentType());

        if ( getHttpNoCache() )
            data.setNoCacheHeaders();

        byte[] value = getValue();

        if ( isAttachment() )
        {
            data.writeAttachment(getAttachmentName(), value);
            data.logResults("[attachment]");
        }
        else
        {
            data.writeBytes(value);
            data.logResults(new String(value));
        }
    }

}
