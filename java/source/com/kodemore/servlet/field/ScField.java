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

package com.kodemore.servlet.field;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.control.ScAjaxValueIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.Kmu;

public abstract class ScField<T>
    extends ScControl
    implements ScHtmlIdIF, ScEncodedValueIF, ScAjaxValueIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The html id for the outermost html container associated
     * with this field.  Most fields are just a simple <input>
     * and the htmlId is used for the input tag itself.  However,
     * some fields may be composed of multiple html elements in
     * which case the html id is associated with some wrapper that
     * encloses the field's other elements.
     */
    private ScLocalString     _htmlId;

    /**
     * The value used for the html element's name.
     * Access to form parameters must use the name, not the id.
     *
     * The name is defaulted to the htmlId, but in some cases
     * the name requires different behavior; e.g., multiple radio
     * buttons form a group based on the use of a common name.
     * Names are only required to be unique within a given form.
     */
    private ScLocalString     _htmlName;

    /**
     * I adapt a domain model to this field.  The value adapter is not required,
     * but when set, it allows multiple fields to be set from a single model at once.
     * In practice, adapters work best when all of the fields in a given containers
     * (e.g.: a form or group) are associated with the same model.
     */
    private ScLocalAdaptor    _valueAdaptor;

    /**
     * The meta attribute associated with the valueAdapter.
     * This can be used to subsequently find a specific field within the control hierarchy.
     */
    @SuppressWarnings("rawtypes")
    private KmMetaAttribute   _valueMetaAttribute;

    /**
     * The list of errors currently associated with this field.
     */
    private ScLocalStringList _errors;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _htmlId = new ScLocalString(getKey());
        _htmlName = new ScLocalString(getHtmlId());

        _valueAdaptor = new ScLocalAdaptor();
        _errors = new ScLocalStringList();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    @Override
    public String getJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    public String getJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(this, getRootScript());
    }

    //##################################################
    //# html name
    //##################################################

    public String getHtmlName()
    {
        return _htmlName.getValue();
    }

    public void setHtmlName(String e)
    {
        _htmlName.setValue(e);
    }

    //##################################################
    //# value
    //##################################################

    public abstract T getValue();

    public abstract void setValue(T value);

    public abstract void resetValue();

    public boolean hasValue()
    {
        return getValue() != null;
    }

    public boolean hasNullValue()
    {
        return getValue() == null;
    }

    public Object getModelValue()
    {
        return getValue();
    }

    //##################################################
    //# ObjectValueIF
    //##################################################

    public Object getObjectValue()
    {
        return getValue();
    }

    @SuppressWarnings("unchecked")
    public void setObjectValue(Object e)
    {
        setValue((T)e);
    }

    //##################################################
    //# EncodedValueIF
    //##################################################

    @Override
    public Object getEncodedValue()
    {
        return getValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setEncodedValue(Object e)
    {
        setValue((T)e);
    }

    //##################################################
    //# value adaptor
    //##################################################

    @SuppressWarnings("rawtypes")
    public KmAdaptorIF getValueAdaptor()
    {
        return _valueAdaptor.getValue();
    }

    @SuppressWarnings("rawtypes")
    public void setValueAdaptor(KmAdaptorIF e)
    {
        _valueAdaptor.setValue(e);
    }

    @SuppressWarnings("rawtypes")
    public void setValueAdaptor(KmMetaAttribute e)
    {
        setValueMetaAttribute(e);
        setValueAdaptor(e.getAdaptor());
    }

    public void clearValueAdaptor()
    {
        _valueAdaptor.setNull();
    }

    public boolean hasValueAdaptor()
    {
        return _valueAdaptor.hasValue();
    }

    //##################################################
    //# value meta attribute
    //##################################################

    @SuppressWarnings("rawtypes")
    public KmMetaAttribute getValueMetaAttribute()
    {
        return _valueMetaAttribute;
    }

    @SuppressWarnings("rawtypes")
    public void setValueMetaAttribute(KmMetaAttribute e)
    {
        _valueMetaAttribute = e;
    }

    public boolean hasValueMetaAttribute()
    {
        return getValueMetaAttribute() != null;
    }

    @SuppressWarnings("rawtypes")
    public boolean hasValueMetaAttribute(KmMetaAttribute e)
    {
        return getValueMetaAttribute() == e;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public ScField<T> findFieldFor(KmMetaAttribute e)
    {
        if ( hasValueMetaAttribute(e) )
            return this;

        return null;
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
    public void applyFromModel(Object model, boolean skipFields)
    {
        super.applyFromModel(model, skipFields);

        if ( skipFields && isEditable() )
            return;

        if ( _valueAdaptor.hasValue() )
        {
            T value = (T)_valueAdaptor.getValue().getValue(model);
            setValue(value);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void applyToModel(Object model)
    {
        super.applyToModel(model);
        if ( _valueAdaptor.hasValue() )
        {
            T value = getValue();
            _valueAdaptor.getValue().setValue(model, value);
        }
    }

    //##################################################
    //# print
    //##################################################

    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute("name", getHtmlName());
    }

    //##################################################
    //# errors
    //##################################################

    public KmList<String> getErrors()
    {
        return _errors.getValue();
    }

    @Override
    public boolean hasErrors()
    {
        return _errors.isNotEmpty() || super.hasErrors();
    }

    /**
     * Add an error message to this field, but do NOT throw an exception.
     * The client can later check for, and display the error messages with checkErrors.
     *
     * @see #checkErrors
     */
    public void addError(String format, Object... args)
    {
        String s = Kmu.format(format, args);
        _errors.add(s);
    }

    public void clearErrors()
    {
        _errors.resetValue();
    }

    public void setErrors(KmList<KmErrorIF> v)
    {
        clearErrors();
        addErrors(v);
    }

    public void setError(String msg, Object... args)
    {
        clearErrors();
        addError(msg, args);
    }

    public void addErrors(KmList<KmErrorIF> v)
    {
        for ( KmErrorIF e : v )
            addError(e);
    }

    public void addError(KmErrorIF e)
    {
        addError(e.formatProblem());
    }

    @Override
    public void collectErrorsOn(KmList<String> v)
    {
        super.collectErrorsOn(v);

        v.addAll(_errors.getValue());
    }

    //##################################################
    //# optional
    //##################################################

    /**
     * Set the field to be required.
     * By default, do nothing; some subclasses may override.
     */
    public void setRequired()
    {
        // noop
    }

    //##################################################
    //# post scripts
    //##################################################

    @Override
    public ScHtmlIdAjax getPostDomScript()
    {
        return (ScHtmlIdAjax)super.getPostDomScript();
    }

    @Override
    public ScHtmlIdAjax getPostRenderScript()
    {
        return (ScHtmlIdAjax)super.getPostRenderScript();
    }

    @Override
    protected ScHtmlIdAjax createPostScript()
    {
        return new ScHtmlIdAjax(this);
    }

}
