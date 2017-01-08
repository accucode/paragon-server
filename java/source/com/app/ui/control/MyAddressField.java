package com.app.ui.control;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalBoolean;

import com.app.model.address.MyAddressIF;
import com.app.model.address.MyAddressVo;

public class MyAddressField
    extends ScDivWrapper
    implements ScFieldIF<MyAddressIF>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalBoolean      _readonly;

    private ScTextField         _attentionField;
    private ScTextField         _phoneField;
    private ScTextField         _street1Field;
    private ScTextField         _street2Field;
    private ScTextField         _cityField;
    private ScTextField         _regionField;
    private ScTextField         _postalCodeField;
    private ScTextField         _countryField;

    /**
     * The list of fields used in the address.
     */
    private KmList<ScTextField> _fields;

    /**
     * If true (the default), the value is encoded into an html data- attribute
     * and the browser utilizes client-side utilizes to warn the user before
     * ajax actions if the value has changed.
     *
     * Change tracking should be set during initial page initialization, and should
     * NOT be modified while processing a page.
     */
    private boolean             _changeTracking;

    /**
     * If set the applyFromModel and applyToModel will use this adaptor
     * to get/set the address.
     */
    private ScLocalAdaptor      _valueAdaptor;

    //##################################################
    //# constructor
    //##################################################

    public MyAddressField()
    {
        _readonly = new ScLocalBoolean();

        _changeTracking = true;
        _valueAdaptor = new ScLocalAdaptor();

        installFields();
        installLayout();
    }

    //##################################################
    //# install
    //##################################################

    private void installFields()
    {
        _attentionField = createAttentionField();
        _street1Field = createStreet1Field();
        _street2Field = createStreet2Field();
        _cityField = createCityField();
        _regionField = createRegionField();
        _postalCodeField = createPostalCodeField();
        _countryField = createCountryField();
        _phoneField = createPhoneField();

        _fields = new KmList<>();
        _fields.add(_attentionField);
        _fields.add(_street1Field);
        _fields.add(_street2Field);
        _fields.add(_cityField);
        _fields.add(_regionField);
        _fields.add(_postalCodeField);
        _fields.add(_countryField);
        _fields.add(_phoneField);
    }

    private void installLayout()
    {
        ScFieldTable fields;
        fields = getInner().addFieldTable();
        fields.css().widthFull();

        fields.add(_attentionField);
        fields.add(_street1Field);
        fields.add(_street2Field);
        fields.add(_cityField);
        fields.add(_regionField);
        fields.add(_postalCodeField);
        fields.add(_countryField);
        fields.add(_phoneField);
    }

    //==================================================
    //= install :: create fields
    //==================================================

    private ScTextField createAttentionField()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Attention");
        field.setWidthFull();
        field.setHelp("The name of the person this is addressed to.  Example: John Doe");
        return field;
    }

    private ScTextField createPhoneField()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Phone");
        field.setWidthFull();
        field.setHelp("The Phone number.  Example: 303-123-4567");
        return field;
    }

    private ScTextField createStreet1Field()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Street 1");
        field.setWidthFull();
        field.setHelp("House number and street name.  Example: 1234 N Main Street");
        return field;
    }

    private ScTextField createStreet2Field()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Street 2");
        field.setWidthFull();
        field.setHelp("Apartment or suite number.  Example: Suite 200");
        return field;
    }

    private ScTextField createCityField()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("City");
        field.setWidthFull();
        field.setHelp("Example: Denver");
        return field;
    }

    private ScTextField createRegionField()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Region");
        field.setWidthFull();
        field.setHelp("For US addresses, this is the state. Example: Colorado");
        return field;
    }

    private ScTextField createPostalCodeField()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Postal Code");
        field.setWidthFull();
        field.setHelp("For US addresses, this is ZIP code.  Example: 80111");
        return field;
    }

    private ScTextField createCountryField()
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Country");
        field.setWidthFull();
        field.setHelp("Example: USA");
        return field;
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

    public void clearValueAdaptor()
    {
        _valueAdaptor.clearValue();
    }

    public boolean hasValueAdaptor()
    {
        return _valueAdaptor.hasValue();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAddressIF getValue()
    {
        MyAddressVo value;
        value = new MyAddressVo();
        value.setAttention(_attentionField.getValue());
        value.setStreet1(_street1Field.getValue());
        value.setStreet2(_street2Field.getValue());
        value.setCity(_cityField.getValue());
        value.setRegion(_regionField.getValue());
        value.setPostalCode(_postalCodeField.getValue());
        value.setCountry(_countryField.getValue());
        value.setPhone(_phoneField.getValue());
        return value;
    }

    @Override
    public void setValue(MyAddressIF value)
    {
        _attentionField.setValue(value.getAttention());
        _street1Field.setValue(value.getStreet1());
        _street2Field.setValue(value.getStreet2());
        _cityField.setValue(value.getCity());
        _regionField.setValue(value.getRegion());
        _postalCodeField.setValue(value.getPostalCode());
        _countryField.setValue(value.getCountry());
        _phoneField.setValue(value.getPhone());
    }

    @Override
    public void saveValue()
    {
        _fields.forEach(e -> e.saveValue());
    }

    @Override
    public void resetValue()
    {
        _fields.forEach(e -> e.resetValue());
    }

    public void clearValue()
    {
        _fields.forEach(e -> e.clearValue());
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public boolean isRequired()
    {
        return false;
    }

    //==================================================
    //= value :: encodable
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
    //# downcast
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model, boolean skipFields)
    {
        if ( !hasValueAdaptor() )
            return true;

        @SuppressWarnings("unchecked")
        MyAddressIF value = (MyAddressIF)getValueAdaptor().getValue(model);
        setValue(value);
        return true;

    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyToModel_here(Object model)
    {
        if ( hasValueAdaptor() )
            getValueAdaptor().setValue(model, getValue());

        return true;
    }

    //##################################################
    //# enabled
    //##################################################

    public void setReadonly()
    {
        setReadonly(true);
    }

    public void setReadonly(boolean e)
    {
        _readonly.setValue(e);
        _fields.forEach(x -> x.setReadOnly(e));
    }

    public void enable()
    {
        setReadonly(false);
    }

    public void readonly()
    {
        setReadonly(true);
    }

    public boolean isReadonly()
    {
        return _readonly.isTrue();
    }

    public boolean isEditable()
    {
        return !isReadonly();
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
        _fields.forEach(x -> x.setChangeTracking(e));
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(MyAddressIF e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(MyAddressIF e, boolean updateOldValue)
    {
        setValue(e);
        ajaxUpdateFieldValues(updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        // none
    }
}
