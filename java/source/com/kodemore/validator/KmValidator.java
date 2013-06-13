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

package com.kodemore.validator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.exception.error.KmRequiredValidationError;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmCopyIF;
import com.kodemore.utility.Kmu;

public abstract class KmValidator<T>
    implements KmConstantsIF, Cloneable
{
    //##################################################
    //# variables
    //##################################################

    private String  _model;
    private String  _field;
    private boolean _required;

    //##################################################
    //# accessing
    //##################################################

    public String getModel()
    {
        return _model;
    }

    public void setModel(String e)
    {
        _model = e;
    }

    public String getField()
    {
        return _field;
    }

    public void setField(String e)
    {
        _field = e;
    }

    public boolean isRequired()
    {
        return _required;
    }

    public boolean isOptional()
    {
        return !isRequired();
    }

    public void setRequired(boolean e)
    {
        _required = e;
    }

    public void setRequired()
    {
        setRequired(true);
    }

    public void setOptional()
    {
        setRequired(false);
    }

    //##################################################
    //# public
    //##################################################

    public T convertOnly(T e)
    {
        return e;
    }

    public void validateOnly(T e)
    {
        KmList<KmErrorIF> v = new KmList<KmErrorIF>();
        validateOnly(e, v);
        check(v);
    }

    public KmErrorIF getValidationError(T e)
    {
        KmList<KmErrorIF> errors = new KmList<KmErrorIF>();
        validateOnly(e, errors);
        return errors.getFirstSafe();
    }

    public void validateOnly(T e, KmList<KmErrorIF> errors)
    {
        if ( e == null )
        {
            if ( _required )
                errors.add(new KmRequiredValidationError(getModel(), getField()));
            return;
        }
        validateModel(e, errors);
    }

    public void validate(T e)
    {
        e = convertOnly(e);
        validateOnly(e);
    }

    public void validate(T e, KmList<KmErrorIF> errors)
    {
        e = convertOnly(e);
        validateOnly(e, errors);
    }

    public String formatErrorsFor(T e)
    {
        KmList<KmErrorIF> errors = new KmList<KmErrorIF>();

        validate(e, errors);

        if ( errors.isEmpty() )
            return null;

        KmStringBuilder out;
        out = new KmStringBuilder();

        for ( KmErrorIF error : errors )
            out.println(error.formatProblem());

        return out.toString();
    }

    //##################################################
    //# validate
    //##################################################

    public abstract void validateModel(T e, KmList<KmErrorIF> v);

    //##################################################
    //# copy
    //##################################################

    /**
     * This method should be overridden by subclasses, but only
     * to specialize the return type.
     */
    public KmValidator<T> getCopy()
    {
        KmValidator<T> e = getShallowCopy();
        e.postCopy();
        return e;
    }

    @SuppressWarnings("unchecked")
    public KmValidator<T> getShallowCopy()
    {
        try
        {
            return (KmValidator<T>)clone();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * This method is responsible for any changes that need to be
     * made after the shallow copy, in order to guarantee a copy
     * that is independent of the original.  Typically, copies
     * of mutable instance variables will be made here.  All
     * subclasses should call super.postCopy().
     */
    public void postCopy()
    {
        // subclass
    }

    /**
     * Copy an instance of KmCopyIF, checking for null.
     */
    public <X extends KmCopyIF> X copy(X e)
    {
        return Kmu.copy(e);
    }

    //##################################################
    //# support
    //##################################################

    private void check(KmList<KmErrorIF> errors)
    {
        if ( errors.isNotEmpty() )
            throw new KmApplicationException(errors);
    }

}
