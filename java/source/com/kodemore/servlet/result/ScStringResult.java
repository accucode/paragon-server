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

import com.kodemore.servlet.ScServletData;
import com.kodemore.utility.Kmu;

public class ScStringResult
    extends ScAbstractResult
{
    //##################################################
    //# variables
    //##################################################

    private String _value;

    //##################################################
    //# value
    //##################################################

    public String getValue()
    {
        return _value;
    }

    public void setValue(CharSequence e)
    {
        _value = e.toString();
    }

    //##################################################
    //# misc
    //##################################################

    @Override
    public int getLength()
    {
        return _value.length();
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyContentTo(ScServletData data)
    {
        String value = getValue();

        if ( isAttachment() )
        {
            byte[] bytes = toCharsetBytes(value);
            data.writeAttachment(getAttachmentName(), bytes);
            data.logResults("[attachment]");
        }
        else
        {
            data.writeString(value);
            data.logResults(value);
        }
    }

    private byte[] toCharsetBytes(String value)
    {
        try
        {
            return getCharset().encode(value).array();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
