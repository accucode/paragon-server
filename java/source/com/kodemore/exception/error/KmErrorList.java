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

package com.kodemore.exception.error;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.utility.KmGeneralError;
import com.kodemore.validator.KmValidator;

public class KmErrorList
    implements Iterable<KmErrorIF>
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmErrorIF> _errors;

    //##################################################
    //# constructor
    //##################################################

    public KmErrorList()
    {
        _errors = new KmList<>();
    }

    //##################################################
    //# errors
    //##################################################

    public KmList<KmErrorIF> getErrors()
    {
        return _errors;
    }

    @Override
    public Iterator<KmErrorIF> iterator()
    {
        return getErrors().iterator();
    }

    public KmErrorIF getFirstSafe()
    {
        return getErrors().getFirstSafe();
    }

    public boolean isEmpty()
    {
        return getErrors().isEmpty();
    }

    public boolean isOk()
    {
        return !hasErrors();
    }

    public boolean hasErrors()
    {
        return _errors.isNotEmpty();
    }

    public String getFirstProblem()
    {
        return hasErrors()
            ? getFirstSafe().formatProblem()
            : null;
    }

    //##################################################
    //# messages
    //##################################################

    public KmList<String> getMessages()
    {
        return _errors.collect(e -> e.formatMessage());
    }

    public String formatMessages()
    {
        return isOk()
            ? null
            : _errors.joinLines(e -> e.formatMessage());
    }

    public String formatFirstMessage()
    {
        return hasErrors()
            ? getErrors().getFirst().formatMessage()
            : null;
    }

    //##################################################
    //# problems
    //##################################################

    public KmList<String> getProblems()
    {
        return _errors.collect(e -> e.formatProblem());
    }

    public String formatProblems()
    {
        return isOk()
            ? null
            : _errors.joinLines(e -> e.formatProblem());
    }

    public String formatFirstProblem()
    {
        return hasErrors()
            ? getErrors().getFirst().formatProblem()
            : null;
    }

    //##################################################
    //# add
    //##################################################

    public void add(KmErrorIF e)
    {
        _errors.add(e);
    }

    public void addFieldError(String model, String field, String problem)
    {
        KmValidationError e = new KmValidationError(model, field, problem);
        add(e);
    }

    public void addFieldError(KmValidator<?> val, String problem)
    {
        addFieldError(val.getModelName(), val.getFieldName(), problem);
    }

    public void addRequiredField(KmValidator<?> val)
    {
        addRequiredField(val.getModelName(), val.getFieldName());
    }

    public void addRequiredField(String model, String field)
    {
        addFieldError(model, field, "is required");
    }

    public void addMinimumValue(KmValidator<?> val, String min)
    {
        addFieldError(val, "minimum value is " + min);
    }

    public void addMaximumValue(KmValidator<?> val, String max)
    {
        addFieldError(val, "maximum value is " + max);
    }

    public void addGeneralError(String msg, Object... args)
    {
        add(new KmGeneralError(msg, args));
    }

    //##################################################
    //# check
    //##################################################

    public void check()
    {
        if ( hasErrors() )
            throw new KmApplicationException(this);
    }

}
