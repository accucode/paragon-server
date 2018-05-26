/*
  Copyright (c) 2005-2018 www.kodemore.com

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

import java.nio.charset.Charset;

import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScContentType;
import com.kodemore.servlet.ScServletData;

/**
 * I define results for http requests.  This provides a simple mechanism
 * for separating the intended results from the call stack that creates
 * them.
 */
public abstract class ScAbstractResult
    implements ScResultIF, ScConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private ScContentType _contentType;
    private Charset       _charset;
    private boolean       _httpNoCache;
    private String        _attachmentName;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractResult()
    {
        _charset = ScConstantsIF.WEB_CHARSET;
    }

    //##################################################
    //# content type
    //##################################################

    public ScContentType getContentType()
    {
        return _contentType;
    }

    public void setContentType(ScContentType e)
    {
        _contentType = e;
    }

    public boolean hasContentType()
    {
        return _contentType != null;
    }

    //##################################################
    //# charset
    //##################################################

    public Charset getCharset()
    {
        return _charset;
    }

    public void setCharset(Charset e)
    {
        _charset = e;
    }

    public boolean hasCharset()
    {
        return _charset != null;
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
    //# attachment
    //##################################################

    public String getAttachmentName()
    {
        return _attachmentName;
    }

    public void setAttachmentName(String name)
    {
        _attachmentName = name;
        setContentType(ScContentType.Octet);
    }

    public boolean isAttachment()
    {
        return _attachmentName != null;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public final void applyTo(ScServletData data)
    {
        applyHeadersTo(data);
        applyContentTo(data);
    }

    private void applyHeadersTo(ScServletData data)
    {
        data.setFrameOptionsSameOrigin();

        if ( hasContentType() )
            data.setContentType(getContentType());

        if ( hasCharset() )
            data.setCharset(getCharset());

        if ( getHttpNoCache() )
            data.setNoCacheHeaders();
    }

    protected abstract void applyContentTo(ScServletData data);

}
