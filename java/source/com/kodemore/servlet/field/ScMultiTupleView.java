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

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.types.KmStringTuple;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmStringValidator;

/**
 * I manage and edit a list of tuples.  Each tuple will have it's own text field and
 * unique keys.  The text fields labels and unique keys are set up by adding options.
 */
public class ScMultiTupleView
    extends ScDivWrapper
    implements ScFieldIF<KmList<KmStringTuple>>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The value is a list of tuples.
     *
     * The tuple's key must match the value of one of the options.
     * The tuple's value is the text displayed in the field.
     */
    private ScLocalList<KmStringTuple> _value;

    /**
     * The list of options.  These determine the text fields to be displayed;
     * each option will render a separate text field.
     *
     * The option's value is used for the field's html id.
     *      It must be unique, and corresponds to the _value's tuple key.
     *
     * The option's text is used for the field's label.
     *      This is not required to be unique, and may be null.
     */
    private ScLocalOptionList<String> _options;

    /**
     * The transient container that holds all of the dynamically generated
     * attribute fields.
     */
    private ScTransientContainer _container;

    /**
     * The list of transient text fields.
     * This is always left empty when the view is initially installed.
     * It is temporarily populated in conjunction with the transient container
     * to provide convenience access to the list of transient fields.
     */
    private ScLocalList<ScTextField> _fields;

    /**
     * If set this validator is applied to ALL of the attributes.
     */
    private ScLocal<KmStringValidator> _validator;

    /**
     * If true, the checkbox button is disabled.
     * Bear in mind that disabled fields are NOT submitted with the form.
     * False by default.
     */
    private ScLocalBoolean _readOnly;

    /**
     * If true (the default), the value is encoded into an html data- attribute
     * and the browser utilizes client-side utilizes to warn the user before
     * ajax actions if the value has changed.
     *
     * Change tracking should be set during initial page initialization, and should
     * NOT be modified while processing a page.
     */
    private boolean _changeTracking;

    //##################################################
    //# constructor
    //##################################################

    public ScMultiTupleView()
    {
        _value = new ScLocalList<>();

        _options = new ScLocalOptionList<>();
        _options.setAutoSave();

        _container = getInner().addTransientContainer();
        _fields = new ScLocalList<>();

        _validator = new ScLocal<>();
        _readOnly = new ScLocalBoolean(false);
        _changeTracking = true;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmList<KmStringTuple> getValue()
    {
        return _value.getValue();
    }

    @Override
    public void setValue(KmList<KmStringTuple> v)
    {
        _value.setValue(v);
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        KmList<ScTextField> v = getFields();
        for ( ScTextField field : v )
            field.saveValue();
    }

    @Override
    public void resetValue()
    {
        KmList<ScTextField> v = getFields();
        for ( ScTextField field : v )
            field.resetValue();
    }

    //==================================================
    //= value :: encode
    //==================================================

    @Override
    public Object getEncodableValue()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setEncodableValue(Object e)
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# options
    //##################################################

    public KmList<ScOption<String>> getOptions()
    {
        return _options.getValue();
    }

    public void setOptions(KmList<ScOption<String>> v)
    {
        _options.setValue(v);

        _container.clear();
        _fields.clear();
    }

    public void clearOptions()
    {
        _options.clearValue();
    }

    //##################################################
    //# validator
    //##################################################

    public KmStringValidator getValidator()
    {
        return _validator.getValue();
    }

    public void setValidator(KmStringValidator e)
    {
        _validator.setValue(e);
    }

    public boolean hasValidator()
    {
        return _validator.hasValue();
    }

    //##################################################
    //# disabled
    //##################################################

    public void setReadOnly(boolean b)
    {
        _readOnly.setValue(b);
    }

    public boolean isReadOnly()
    {
        return _readOnly.getValue();
    }

    public void setReadOnly()
    {
        setReadOnly(true);
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
        warnIfInstalled();
        _changeTracking = e;
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# editable
    //##################################################

    public boolean isEditable()
    {
        return !isReadOnly();
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        if ( isReadOnly() )
            return;

        KmList<String> htmlIds = data.getParameterKeysStartingWith(getHtmlId());

        for ( String htmlId : htmlIds )
        {
            String value = data.getParameter(htmlId);
            String key = getKeyFromHtmlId(htmlId);

            ScTextField field;
            field = getTextFieldForKey(key);
            field.setValue(value);
        }

        setValue(getValueFromFields());
    }

    private KmList<KmStringTuple> getValueFromFields()
    {
        KmList<KmStringTuple> v = new KmList<>();
        for ( ScOption<String> o : getOptions() )
        {
            String key = o.getValue();
            ScTextField field = getTextFieldForKey(key);
            String value = field.getValue();

            KmStringTuple vo;
            vo = new KmStringTuple();
            vo.setKey(key);
            vo.setValue(value);

            v.add(vo);
        }
        return v;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        // non-standard; fail early if developer accidentally adds duplicate keys.
        validateOptions();

        lazyInstallFields();
    }

    //##################################################
    //# add TRANSIENT fields
    //#
    //# These fields are NOT added during install.
    //# Instead, they are added during preRender and handle.
    //# These are added to the TRANSIENT container and
    //# are discarded when the http request is done.
    //##################################################

    private KmList<ScTextField> getFields()
    {
        lazyInstallFields();
        return _fields.getValue();
    }

    private void lazyInstallFields()
    {
        if ( !_container.isEmpty() )
            return;

        _container.clear();
        _fields.clear();

        ScFieldTable fields;
        fields = _container.addFullWidthFieldTable();
        fields.css().widthFull();

        for ( ScOption<String> opt : getOptions() )
            if ( isReadOnly() )
                lazyInstallFieldText(fields, opt);
            else
                lazyInstallTextField(fields, opt);
    }

    private void lazyInstallFieldText(ScFieldTable fields, ScOption<String> opt)
    {
        String key = opt.getValue();
        String label = opt.getText();

        ScFieldText f;
        f = new ScFieldText();
        f.setLabel(label);
        f.setValue(getValueForKey(key));

        fields.add(f);
    }

    private void lazyInstallTextField(ScFieldTable fields, ScOption<String> opt)
    {
        String key = opt.getValue();
        String label = opt.getText();

        ScTextField f;
        f = new ScTextField();
        f.setHtmlId(getHtmlIdFromKey(key));
        f.setLabel(label);
        f._setChangeTracking(getChangeTracking());
        f.setValue(getValueForKey(key));
        f.setValidator(getValidator());
        f.setWidthFull();

        fields.add(f);
        _fields.add(f);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(KmList<KmStringTuple> tuples)
    {
        ajaxSetFieldValue(tuples, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(KmList<KmStringTuple> tuples, boolean updateOldValue)
    {
        if ( isReadOnly() )
            return;

        for ( ScOption<String> opt : getOptions() )
        {
            String key = opt.getValue();
            ScTextField field = getTextFieldForKey(key);
            KmStringTuple tuple = tuples.selectFirst(e -> e.hasKey(key));

            if ( tuple == null )
                field.ajaxClearFieldValue(updateOldValue);
            else
                field.ajaxSetFieldValue(tuple.getValue(), updateOldValue);
        }
    }

    @Override
    public void ajaxClearFieldValue()
    {
        ajaxClearFieldValue(getChangeTracking());
    }

    @Override
    public void ajaxClearFieldValue(boolean updateOldValue)
    {
        for ( ScTextField e : getFields() )
            e.ajaxClearFieldValue(updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        // none
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public boolean isRequired()
    {
        return false;
    }

    //##################################################
    //# support
    //##################################################

    private void validateOptions()
    {
        KmList<String> values = getOptions().collect(e -> e.getValue());
        if ( values.containsDuplicate() )
            throw Kmu.newError("Option must be unique.");
    }

    private ScTextField getTextFieldForKey(String key)
    {
        String htmlId = getHtmlIdFromKey(key);
        return getFields().selectFirst(e -> e.hasHtmlId(htmlId));
    }

    private String getValueForKey(String key)
    {
        KmStringTuple attr = getValue().selectFirst(e -> e.hasKey(key));
        return attr == null
            ? null
            : attr.getValue();
    }

    //==================================================
    //= support :: html id
    //==================================================

    private String getHtmlIdFromKey(String key)
    {
        return Kmu.format("%s%s", getHtmlIdPrefix(), key);
    }

    private String getKeyFromHtmlId(String htmlId)
    {
        String s;
        s = htmlId;
        s = Kmu.removePrefix(s, getHtmlIdPrefix());
        s = Kmu.removeSuffix(s, ScTextField.INPUT_SUFFIX);
        return s;
    }

    private String getHtmlIdPrefix()
    {
        return getHtmlId() + "-";
    }

}
