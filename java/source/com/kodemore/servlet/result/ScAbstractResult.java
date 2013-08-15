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

import com.kodemore.servlet.ScConstantsIF;

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

    private String _contentType;
    private String _attachmentName;

    //##################################################
    //# content type
    //##################################################

    public void setContentTypeText()
    {
        setContentType(CONTENT_TYPE_TEXT);
    }

    public void setContentTypeCss()
    {
        setContentType(CONTENT_TYPE_CSS);
    }

    public void setContentTypeHtml()
    {
        setContentType(CONTENT_TYPE_HTML);
    }

    public void setContentTypeXml()
    {
        setContentType(CONTENT_TYPE_XML);
    }

    public void setContentTypeOctet()
    {
        setContentType(CONTENT_TYPE_OCTET);
    }

    public void setContentTypeJson()
    {
        setContentType(CONTENT_TYPE_JSON);
    }

    private void setContentType(String e)
    {
        _contentType = e;
    }

    public String getContentType()
    {
        return _contentType;
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
        setContentTypeOctet();
    }

    public boolean isAttachment()
    {
        return _attachmentName != null;
    }
}
