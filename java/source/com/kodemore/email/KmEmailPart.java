/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.email;

public class KmEmailPart
    implements KmEmailPartIF
{
    //##################################################
    //# variables
    //##################################################

    private KmEmailPartType _type;
    private String          _attachmentName;
    private byte[]          _data;

    //##################################################
    //# constructor
    //##################################################

    public KmEmailPart()
    {
        // none
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public KmEmailPartType getType()
    {
        return _type;
    }

    public void setType(KmEmailPartType type)
    {
        _type = type;
    }

    @Override
    public String getAttachmentName()
    {
        return _attachmentName;
    }

    public void setAttachmentName(String attachmentName)
    {
        _attachmentName = attachmentName;
    }

    @Override
    public byte[] getData()
    {
        return _data;
    }

    public void setData(byte[] data)
    {
        _data = data;
    }

    //##################################################
    //# convenience
    //##################################################

    public void setText(String e)
    {
        setType(KmEmailPartType.Text);
        setData(e.getBytes());
    }

    public void setText(byte[] arr)
    {
        setText(new String(arr));
    }

    public void setHtml(String e)
    {
        setType(KmEmailPartType.Html);
        setData(e.getBytes());
    }

    public void setHtml(byte[] arr)
    {
        setHtml(new String(arr));
    }

    public void setAttachment(String name, String data)
    {
        setAttachment(name, data.getBytes());
    }

    public void setAttachment(String name, byte[] data)
    {
        setType(KmEmailPartType.Attachment);
        setAttachmentName(name);
        setData(data);
    }

}
