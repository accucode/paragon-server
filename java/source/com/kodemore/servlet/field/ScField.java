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

package com.kodemore.servlet.field;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.exception.error.KmErrorList;
import com.kodemore.meta.KmMetaAssociation;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScUtility;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmValidator;

public abstract class ScField<T>
    extends ScControl
    implements ScFieldIF<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * I adapt a domain model to this field.  The value adapter is not required,
     * but when set, it allows multiple fields to be set from a single model at once.
     * In practice, adapters work best when all of the fields in a given container
     * (e.g.: a form or group) are associated with the same model.
     */
    private ScLocalAdaptor _valueAdaptor;

    /**
     * A type specific validator.
     */
    private ScLocal<KmValidator<T>> _validator;

    /**
     * If true (by default), the original value is included in the html data- attribute
     * and the client-side browser uses javascript to track if changes are made.
     */
    private boolean _changeTracking;

    /**
     * The list of errors currently associated with this field.
     */
    private ScLocalStringList _errors;

    private ScLocalBoolean _visible;

    //##################################################
    //# constructor
    //##################################################

    public ScField()
    {
        _valueAdaptor = new ScLocalAdaptor();
        _validator = new ScLocal<>();
        _errors = new ScLocalStringList();
        _changeTracking = true;
        _visible = new ScLocalBoolean(true);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public abstract T getValue();

    @Override
    public abstract void setValue(T value);

    public final void clearValue()
    {
        setValue(null);
    }

    /**
     * Used for RARE circumstances where it is not feasible to
     * type the parameter. This uses an unsafe/unchecked cast.
     */
    @SuppressWarnings("unchecked")
    public void setValueUntyped(Object e)
    {
        setValue((T)e);
    }

    //==================================================
    //= value :: save/reset
    //==================================================

    @Override
    public abstract void saveValue();

    @Override
    public abstract void resetValue();

    //##################################################
    //# meta
    //##################################################

    public void setMeta(KmMetaAssociation<?,T> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);
        setRequired(x.isRequired());
    }

    public void setMeta(KmMetaProperty<?,T> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);
        setValidator(x);
    }

    //##################################################
    //# EncodedValueIF
    //##################################################

    @Override
    public Object getEncodableValue()
    {
        return getValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setEncodableValue(Object e)
    {
        setValue((T)e);
    }

    //##################################################
    //# value adaptor
    //##################################################

    @SuppressWarnings("unchecked")
    public final KmAdaptorIF<?,T> getValueAdaptor()
    {
        return _valueAdaptor.getValue();
    }

    public final void setValueAdaptor(KmAdaptorIF<?,T> e)
    {
        _valueAdaptor.setValue(e);
    }

    public final void clearValueAdaptor()
    {
        _valueAdaptor.clearValue();
    }

    public final boolean hasValueAdaptor()
    {
        return _valueAdaptor.hasValue();
    }

    //##################################################
    //# validator
    //##################################################

    public final KmValidator<T> getValidator()
    {
        return _validator.getValue();
    }

    public final void setValidator(KmValidator<T> e)
    {
        _validator.setValue(e);
    }

    public final void setValidator(KmMetaProperty<?,T> p)
    {
        setValidator(p.getValidator());
    }

    public final void clearValidator()
    {
        _validator.clearValue();
    }

    public final boolean hasValidator()
    {
        return _validator.hasValue();
    }

    public final void setRequired(boolean e)
    {
        if ( e )
            setRequired();
        else
            setOptional();
    }

    public final void setRequired()
    {
        KmValidator<T> e = ScUtility.toRequiredValidator(getValidator());
        setValidator(e);
    }

    public final void setOptional()
    {
        KmValidator<T> e = ScUtility.toOptionalValidator(getValidator());
        setValidator(e);
    }

    @Override
    public final boolean isRequired()
    {
        return hasValidator() && getValidator().isRequired();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        if ( hasErrors() )
            return;

        validateParse();
        if ( hasErrors() )
            return;

        validateValidator();
    }

    /**
     * Validate if the value can be parsed.  This allows text oriented
     * fields to validate the parsing of text-to-value BEFORE the
     * subsequent value is validated.
     *
     * Does nothing by default.
     * Most classes do not need to override this.
     */
    protected void validateParse()
    {
        // none
    }

    protected void validateValidator()
    {
        if ( !hasValidator() )
            return;

        KmErrorList errors = getValidator().getValidationErrors(getValue());
        setErrors(errors);
    }

    //##################################################
    //# change tracking
    //##################################################

    @Override
    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        _setChangeTracking(e);
    }

    /**
     * This sets the change tracking without warning if called after install and
     * should not be used under normal circumstances.  This may be useful when
     * generating transient fields.
     */
    public void _setChangeTracking(boolean e)
    {
        _changeTracking = e;
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# editable
    //##################################################

    public abstract boolean isEditable();

    //##################################################
    //# model
    //##################################################

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyFromModel_here(Object model)
    {
        super.applyFromModel_here(model);

        if ( _valueAdaptor.hasValue() )
        {
            T value = (T)_valueAdaptor.getValue().getValue(model);
            setValue(value);
        }

        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyToModel_here(Object model)
    {
        if ( _valueAdaptor.hasValue() )
        {
            T value = getValue();
            _valueAdaptor.getValue().setValue(model, value);
        }
        return true;
    }

    //##################################################
    //# errors
    //##################################################

    public final KmList<String> getErrors()
    {
        return _errors.getValue();
    }

    @Override
    public final boolean hasErrors()
    {
        return _errors.isNotEmpty() || super.hasErrors();
    }

    /**
     * Add an error message to this field, but do NOT throw an exception.
     * The client can later check for, and display the error messages with checkErrors.
     *
     * @see #checkErrors
     */
    public final void addError(String format, Object... args)
    {
        String s = Kmu.format(format, args);
        _errors.add(s);
    }

    public final void clearErrors()
    {
        _errors.resetValue();
    }

    public final void setErrors(KmErrorList errors)
    {
        clearErrors();
        addErrors(errors);
    }

    public final void setError(String msg, Object... args)
    {
        clearErrors();
        addError(msg, args);
    }

    public final void addErrors(KmErrorList errors)
    {
        for ( KmErrorIF e : errors )
            addError(e);
    }

    public final void addError(KmErrorIF e)
    {
        addError(e.formatProblem());
    }

    @Override
    public final void collectErrorsOn(KmList<String> v)
    {
        super.collectErrorsOn(v);

        v.addAll(_errors.getValue());
    }

    public final void addErrorAndCheck(String msg, Object... args)
    {
        addError(msg, args);
        checkErrors();
    }

    //##################################################
    //# post scripts
    //##################################################

    @Override
    public final ScHtmlIdAjax getPostDomScript()
    {
        return (ScHtmlIdAjax)super.getPostDomScript();
    }

    @Override
    public final ScHtmlIdAjax getPostRenderScript()
    {
        return (ScHtmlIdAjax)super.getPostRenderScript();
    }

    @Override
    protected final ScHtmlIdAjax createPostScript()
    {
        return ScHtmlIdAjax.createDetached(this);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public final void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        ajaxSetFieldValue(getValue(), updateOldValue);
    }

    //##################################################
    //# visibility
    //##################################################

    @Override
    public final void setVisible(boolean e)
    {
        _visible.setValue(e);
    }

    @Override
    public final boolean isVisible()
    {
        return _visible.isTrue();
    }

}
