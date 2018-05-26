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

package com.kodemore.validator;

import com.kodemore.exception.error.KmErrorList;
import com.kodemore.utility.KmCopyIF;
import com.kodemore.utility.Kmu;

public abstract class KmValidator<T>
    implements Cloneable
{
    //##################################################
    //# variables
    //##################################################

    private String  _modelName;
    private String  _fieldName;
    private boolean _required;

    //##################################################
    //# accessing
    //##################################################

    public String getModelName()
    {
        return _modelName;
    }

    public void setModelName(String e)
    {
        _modelName = e;
    }

    public String getFieldName()
    {
        return _fieldName;
    }

    public void setFieldName(String e)
    {
        _fieldName = e;
    }

    //==================================================
    //= accessing :: required
    //==================================================

    public void setRequired(boolean e)
    {
        _required = e;
    }

    public void setRequired()
    {
        setRequired(true);
    }

    public boolean isRequired()
    {
        return _required;
    }

    public void setOptional()
    {
        setRequired(false);
    }

    public boolean isOptional()
    {
        return !isRequired();
    }

    //##################################################
    //# public
    //##################################################

    public void validateAndCheck(T value)
    {
        value = convert(value);
        KmErrorList errors = getValidationErrors(value);
        errors.check();
    }

    public T convert(T e)
    {
        return e;
    }

    public KmErrorList getValidationErrors(T value)
    {
        KmErrorList errors = new KmErrorList();
        validateOn(value, errors);
        return errors;
    }

    public void validateOn(T e, KmErrorList errors)
    {
        if ( e == null )
        {
            if ( _required )
                errors.addRequiredField(getModelName(), getFieldName());
            return;
        }
        validateValueOn(e, errors);
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract void validateValueOn(T e, KmErrorList errors);

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
}
