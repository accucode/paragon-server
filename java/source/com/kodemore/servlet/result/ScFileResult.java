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

package com.kodemore.servlet.result;

import java.io.File;

import com.kodemore.servlet.ScServletData;

public class ScFileResult
    extends ScAbstractResult
{
    //##################################################
    //# variables
    //##################################################

    private String _fileName;

    /**
     * Set during applyTo.
     */
    private int    _length;

    //##################################################
    //# accessing
    //##################################################

    public String getFileName()
    {
        return _fileName;
    }

    public void setFileName(String e)
    {
        _fileName = e;
    }

    @Override
    public int getLength()
    {
        return _length;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyTo(ScServletData data)
    {
        data.setContentType(getContentType());

        File file = new File(_fileName);
        if ( isAttachment() )
            data.writeAttachmentFile(getAttachmentName(), file);
        else
            data.writeFile(file);
    }

}
