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

package com.kodemore.exception;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmDatabaseLockError;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.utility.KmGeneralError;
import com.kodemore.utility.Kmu;

/**
 * I am used to politely abort the current thread, notifing
 * the caller that a problem was discovered and should be
 * displayed to the user.
 *
 * Application exceptions are only used for problems that we
 * expect to occur in the normal course of operations.  For
 * example, an invalid password, a missing value, or a field
 * that is too long.
 *
 * "Unhandled exceptions" like null pointer exceptions should
 * NOT be wrapped as application exceptions.
 */
public class KmApplicationException
    extends RuntimeException
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmErrorIF> _errors = new KmList<>();

    //##################################################
    //# constructors
    //##################################################

    public KmApplicationException()
    {
        super();
    }

    public KmApplicationException(KmErrorIF error)
    {
        addError(error);
    }

    public KmApplicationException(KmList<KmErrorIF> errors)
    {
        setErrors(errors);
    }

    public KmApplicationException(CharSequence msg, Object... args)
    {
        addError(msg, args);
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
        return formatMultiLineMessage();
    }

    public boolean hasMessage()
    {
        return Kmu.hasValue(getMessage());
    }

    /**
     * Return the list of <String> error messages, the toDisplayString of each error.
     */
    public KmList<String> getErrorMessages()
    {
        KmList<String> v = new KmList<>();

        for ( KmErrorIF e : _errors )
            v.add(e.formatMessage());

        return v;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasErrorCode(String code)
    {
        for ( KmErrorIF e : _errors )
            if ( e.hasCode(code) )
                return true;

        return false;
    }

    //##################################################
    //# display
    //##################################################

    public String formatMultiLineMessage()
    {
        return formatErrors("\r\n");
    }

    public String formatSingleLineMessage()
    {
        return formatErrors(";");
    }

    private String formatErrors(String separator)
    {
        StringBuilder out = new StringBuilder();

        for ( KmErrorIF e : _errors )
        {
            out.append(e.formatMessage());
            out.append(separator);
        }

        return out.toString().trim();
    }

    //##################################################
    //# collection manipulation
    //##################################################

    public void addError(KmErrorIF e)
    {
        _errors.add(e);
    }

    public void addError(CharSequence msg, Object... args)
    {
        addError(new KmGeneralError(msg, args));
    }

    //##################################################
    //# convenience
    //##################################################

    public boolean isOk()
    {
        return _errors.isEmpty();
    }

    public boolean hasErrors()
    {
        return !isOk();
    }

    public void check()
    {
        if ( hasErrors() )
            throw this;
    }

    public boolean hasSingleDatabaseLockError()
    {
        if ( getErrors().size() != 1 )
            return false;

        KmErrorIF e = getErrors().getFirst();
        return e instanceof KmDatabaseLockError;
    }

}
