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

package com.kodemore.utility;

import com.kodemore.exception.error.KmError;

/**
 * I am used to wrap exceptions so that they may be passed as unchecked
 * exceptions while still preserving the state of the original exception.
 */
public class KmGeneralError
    extends KmError
{
    //##################################################
    //# constructor
    //##################################################

    public KmGeneralError(CharSequence msg, Object... args)
    {
        setMessage(msg, args);
    }

    //##################################################
    //# variables
    //##################################################

    private String _message;

    //##################################################
    //# accessing
    //##################################################

    public String getMessage()
    {
        return _message;
    }

    public void setMessage(CharSequence msg, Object... args)
    {
        _message = Kmu.format(msg, args);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public void formatProblem(StringBuilder out)
    {
        out.append(_message);
    }
}
