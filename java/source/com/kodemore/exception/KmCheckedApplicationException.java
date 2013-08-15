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

package com.kodemore.exception;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.utility.Kmu;

public class KmCheckedApplicationException
    extends Exception
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmErrorIF> _errors = new KmList<KmErrorIF>();

    //##################################################
    //# constructors
    //##################################################

    public KmCheckedApplicationException(KmList<KmErrorIF> errors)
    {
        setErrors(errors);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<KmErrorIF> getErrors()
    {
        return _errors;
    }

    public void setErrors(KmList<KmErrorIF> e)
    {
        _errors = e;
    }

    @Override
    public String getMessage()
    {
        return toDisplayString();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasError(String code)
    {
        for ( KmErrorIF e : _errors )
            if ( Kmu.isEqual(e.getCode(), code) )
                return true;
        return false;
    }

    //##################################################
    //# display
    //##################################################

    public String toDisplayString()
    {
        StringBuilder sb = new StringBuilder();
        for ( KmErrorIF e : _errors )
        {
            sb.append(e.formatMessage());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    //##################################################
    //# collection manipulation
    //##################################################

    public void addError(KmErrorIF e)
    {
        _errors.add(e);
    }
}
