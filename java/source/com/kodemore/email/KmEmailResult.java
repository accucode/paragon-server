/*
  Copyright (c) 2005-2014 www.kodemore.com

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

public class KmEmailResult
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The email's key.
     */
    private Object  _emailKey;

    /**
     * Was the email sent successfully.
     */
    private boolean _ok;

    /**
     * The error message, if not ok.
     */
    private String  _errorMessage;

    //##################################################
    //# key
    //##################################################

    public Object getEmailKey()
    {
        return _emailKey;
    }

    public void setEmailKey(Object e)
    {
        _emailKey = e;
    }

    //##################################################
    //# ok
    //##################################################

    public boolean isOk()
    {
        return _ok;
    }

    public boolean isError()
    {
        return !isOk();
    }

    public void setOk()
    {
        _ok = true;
        _errorMessage = null;
    }

    //##################################################
    //# message
    //##################################################

    public String getErrorMessage()
    {
        return _errorMessage;
    }

    public void setErrorMessage(String e)
    {
        _errorMessage = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public void setError(Exception ex)
    {
        setError(ex.getMessage());
    }

    public void setError(String msg)
    {
        _ok = false;
        _errorMessage = msg;
    }
}
