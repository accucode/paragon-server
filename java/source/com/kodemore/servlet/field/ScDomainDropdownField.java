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

import java.util.List;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmKeyFinderIF;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmRequiredValidator;
import com.kodemore.validator.KmValidator;

public class ScDomainDropdownField<T, K>
    extends ScField<T>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalAdaptor _optionKeyAdaptor;
    private ScLocalAdaptor _optionLabelAdaptor;

    private ScLocalString _nullPrefix;

    private ScLocal<K> _valueKey;

    private ScLocalBoolean _readOnly;
    private ScLocalBoolean _disabled;

    private KmValidator<T> _validator;

    /**
     * Used to find the list of options to be displayed.
     * The list is not cached; it is refetched during preRender.
     * Clients should set either the filter or filterFactory; NOT both.
     *
     * @see #_filterFactory
     */
    private KmFilterIF<T> _filter;

    /**
     * Used to specify a dynamic filter.
     * This could be configured to incorporate the current time, or the currently
     * selected user, or other factors that may be different eacy time we fill
     * the options.
     * Clients should set either the filter or filterFactory; NOT both.
     * @see #_filter
     */
    private KmFilterFactoryIF<T> _filterFactory;

    /**
     * Find a model by its key.  This lookup is independent of
     * the filter.  In practice, the value returned should be
     * a value from the filter, but this is not guaranteed or validated.
     */
    private KmKeyFinderIF<T,K> _finder;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _valueKey = new ScLocal<>();
        _validator = null;

        _optionKeyAdaptor = new ScLocalAdaptor();
        _optionLabelAdaptor = new ScLocalAdaptor();

        _readOnly = new ScLocalBoolean(false);
        _disabled = new ScLocalBoolean(false);

        _nullPrefix = new ScLocalString();
    }

    //##################################################
    //# filter
    //##################################################

    public KmFilterIF<T> getFilter()
    {
        return _filter;
    }

    public void setFilter(KmFilterIF<T> e)
    {
        _filter = e;
        _filterFactory = null;
    }

    public KmFilterFactoryIF<T> getFilterFactory()
    {
        return _filterFactory;
    }

    public void setFilterFactory(KmFilterFactoryIF<T> e)
    {
        _filter = null;
        _filterFactory = e;
    }

    private KmList<T> getOptions()
    {
        if ( _filter != null )
            return _filter.findAll();

        if ( _filterFactory != null )
            return _filterFactory.createFilter().findAll();

        return new KmList<>();
    }

    //##################################################
    //# finder
    //##################################################

    public KmKeyFinderIF<T,K> getFinder()
    {
        return _finder;
    }

    public void setFinder(KmKeyFinderIF<T,K> e)
    {
        _finder = e;
    }

    private T findValue(K key)
    {
        if ( _finder == null )
            return null;

        return _finder.find(key);
    }

    //##################################################
    //# EncodedValueIF
    //##################################################

    @Override
    public Object getEncodedValue()
    {
        return getKeyFor(getValue());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setEncodedValue(Object e)
    {
        K key = (K)e;
        setValue(findValue(key));
    }

    //##################################################
    //# validator
    //##################################################

    public KmValidator<T> getValidator()
    {
        return _validator;
    }

    public void setValidator(KmValidator<T> e)
    {
        _validator = e;
    }

    public boolean hasValidator()
    {
        return _validator != null;
    }

    @Override
    public void setRequired()
    {
        if ( hasValidator() )
            getValidator().setRequired();
        else
            setValidator(new KmRequiredValidator<T>());
    }

    public void setOptional()
    {
        if ( hasValidator() )
            getValidator().setOptional();
    }

    //##################################################
    //# session
    //##################################################

    @Override
    public void saveFieldValues()
    {
        super.saveFieldValues();
    }

    @Override
    public void resetFieldValues()
    {
        super.resetFieldValues();
        resetValue();
    }

    protected String getDefaultFocusKey()
    {
        return getKey();
    }

    //##################################################
    //# prefixes
    //##################################################

    public void setNullPrefix()
    {
        setNullPrefix("");
    }

    public void setNullNonePrefix()
    {
        setNullPrefix("<none>");
    }

    public void setNullDefaultPrefix()
    {
        setNullPrefix("<default>");
    }

    public void setNullAnyPrefix()
    {
        setNullPrefix("<any>");
    }

    public void setNullSelectPrefix()
    {
        setNullPrefix("<select>");
    }

    public void setNullPrefix(String label)
    {
        _nullPrefix.setValue(label);
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);
        if ( hasKeyParameter(data) )
        {
            K key = decodeKeyParameterSafe(data);
            _valueKey.setValue(key);
        }
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        if ( _readOnly.getValue() )
            renderReadOnlyControl(out);
        else
            renderEditableControl(out);
    }

    private void renderReadOnlyControl(KmHtmlBuilder out)
    {
        T e = getValue();
        if ( e == null )
            return;

        ScText text;
        text = new ScText();
        text.setValue(getLabelFor(e));
        text.renderOn(out);
    }

    public void renderEditableControl(KmHtmlBuilder out)
    {
        out.open("select");
        out.printAttribute("id", getHtmlId());
        if ( isDisabled() )
            out.printAttribute("disabled");
        else
            out.printAttribute("name", getHtmlName());
        out.printAttribute("size", 1);
        out.printAttribute(formatCss());
        out.close();

        renderNullPrefix(out);
        renderOptions(out, getOptions());

        out.end("select");
    }

    private void renderNullPrefix(KmHtmlBuilder out)
    {
        if ( _nullPrefix.isNotNull() )
            renderOption(out, null, null, _nullPrefix.getValue());
    }

    private void renderOptions(KmHtmlBuilder out, List<T> v)
    {
        if ( v != null )
            for ( T e : v )
                renderOption(out, e);
    }

    private void renderOption(KmHtmlBuilder out, T value)
    {
        K key = getKeyFor(value);
        String label = getLabelFor(value);
        renderOption(out, value, key, label);
    }

    private void renderOption(KmHtmlBuilder out, T value, K key, String label)
    {
        String encodedKey = encode(key);
        boolean isSelected = Kmu.isEqual(getValue(), value);

        out.open("option");
        out.printAttribute("value", encodedKey);

        if ( isSelected )
            out.printAttribute("selected");

        out.close();
        out.print(label);
        out.end("option");
    }

    private KmCssDefaultBuilder formatCss()
    {
        return newCssBuilder().dropdown();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public boolean validateQuietly()
    {
        boolean ok = super.validateQuietly();

        if ( _validator == null )
            return ok;

        KmList<KmErrorIF> errors = new KmList<>();
        _validator.validateOnly(getValue(), errors);

        if ( errors.isEmpty() )
            return ok;

        setErrors(errors);
        return false;
    }

    //##################################################
    //# keys
    //##################################################

    @SuppressWarnings("unchecked")
    public KmAdaptorIF<T,K> getOptionKeyAdaptor()
    {
        return _optionKeyAdaptor.getValue();
    }

    public void setOptionKeyAdaptor(KmAdaptorIF<T,K> e)
    {
        _optionKeyAdaptor.setValue(e);
    }

    public void setOptionKeyAdaptor(KmMetaAttribute<T,K> attr)
    {
        setOptionKeyAdaptor(attr.getAdaptor());
    }

    private K getKeyFor(T value)
    {
        if ( value == null )
            return null;

        return getOptionKeyAdaptor().getValue(value);
    }

    //##################################################
    //# labels
    //##################################################

    @SuppressWarnings("unchecked")
    public KmAdaptorIF<T,String> getOptionLabelAdaptor()
    {
        return _optionLabelAdaptor.getValue();
    }

    public void setOptionLabelAdaptor(KmAdaptorIF<T,String> e)
    {
        _optionLabelAdaptor.setValue(e);
    }

    public void setOptionLabelAdaptor(KmMetaAttribute<T,String> attr)
    {
        setOptionLabelAdaptor(attr.getAdaptor());
    }

    private String getLabelFor(T value)
    {
        return getOptionLabelAdaptor().getValue(value);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public T getValue()
    {
        if ( _valueKey.isNull() )
            return null;

        K key = _valueKey.getValue();
        return findValue(key);
    }

    @Override
    public void setValue(T e)
    {
        _valueKey.setValue(getKeyFor(e));
    }

    @Override
    public void resetValue()
    {
        _valueKey.resetValue();
    }

    public boolean hasValue(T e)
    {
        return Kmu.isEqual(getValue(), e);
    }

    private K getValueKey()
    {
        return _valueKey.getValue();
    }

    //##################################################
    //# read only
    //##################################################

    public void setReadOnly(boolean b)
    {
        if ( b )
            setReadOnly();
        else
            setEditable();
    }

    public void setReadOnly()
    {
        _readOnly.setTrue();
    }

    public void setEditable()
    {
        _readOnly.setFalse();
    }

    public boolean isReadOnly()
    {
        return _readOnly.isTrue();
    }

    //##################################################
    //# enabled
    //##################################################

    public void enable()
    {
        _disabled.setFalse();
    }

    public void disable()
    {
        _disabled.setTrue();
    }

    public boolean isDisabled()
    {
        return _disabled.isTrue();
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isReadOnly() && !isDisabled();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        ajax().setValue(encode(getValueKey()));
    }
}
