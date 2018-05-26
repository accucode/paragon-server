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

    private ScLocalBoolean _readonly;

    private ScTextField _usAttentionField;
    private ScTextField _usStreet1Field;
    private ScTextField _usStreet2Field;
    private ScTextField _usCityField;
    private ScTextField _usRegionField;
    private ScTextField _usPostalCodeField;
    private ScTextField _usCountryField;
    private ScTextField _usPhoneField;

    /**
     * If set the applyFromModel and applyToModel will use this adaptor
     * to get/set the address.
     */
    private ScLocalAdaptor _valueAdaptor;

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

    public MyAddressField()
    {
        _readonly = new ScLocalBoolean();
        _valueAdaptor = new ScLocalAdaptor();
        _changeTracking = true;

        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScFieldTable fields;
        fields = getInner().addFieldTable();
        fields.add(createAttentionField());
        fields.add(createStreet1Field());
        fields.add(createStreet2Field());
        fields.add(createCityField());
        fields.add(createRegionField());
        fields.add(createPostalCodeField());
        fields.add(createCountryField());
        fields.add(createPhoneField());
    }

    private KmList<ScTextField> getFields()
    {
        KmList<ScTextField> v;
        v = new KmList<>();
        v.add(_usAttentionField);
        v.add(_usStreet1Field);
        v.add(_usStreet2Field);
        v.add(_usCityField);
        v.add(_usRegionField);
        v.add(_usPostalCodeField);
        v.add(_usCountryField);
        v.add(_usPhoneField);
        return v;
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScTextField createAttentionField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Attention");
        e.setHelp("The name of the person this is addressed to.  Example: John Doe");
        e.layoutInline(200);
        _usAttentionField = e;
        return e;
    }

    private ScTextField createStreet1Field()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Street 1");
        e.setHelp("House number and street name. Example: 1234 N Main Street");
        e.layoutInline(300);
        _usStreet1Field = e;
        return e;
    }

    private ScTextField createStreet2Field()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Street 2");
        e.setHelp("Apartment or suite number. Example: Suite 200");
        e.layoutInline(300);
        _usStreet2Field = e;
        return e;
    }

    private ScTextField createCityField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("City");
        e.setHelp("Example: Denver");
        e.layoutInline(200);
        _usCityField = e;
        return e;
    }

    private ScTextField createRegionField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("State");
        e.setHelp("For US addresses, this is the state. Example: Colorado");
        e.layoutInline(100);
        _usRegionField = e;
        return e;
    }

    private ScTextField createPostalCodeField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Zip Code");
        e.setHelp("For US addresses, this is ZIP code.  Example: 80111");
        e.layoutInline(100);
        _usPostalCodeField = e;
        return e;
    }

    private ScTextField createCountryField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Country");
        e.setHelp("Example: USA");
        e.layoutInline(200);
        _usCountryField = e;
        return e;
    }

    private ScTextField createPhoneField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Phone");
        e.setHelp("The Phone number.  Example: 303-123-4567");
        e.layoutInline(200);
        _usPhoneField = e;
        return e;
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
        MyAddressVo e;
        e = new MyAddressVo();
        e.setAttention(_usAttentionField.getValue());
        e.setStreet1(_usStreet1Field.getValue());
        e.setStreet2(_usStreet2Field.getValue());
        e.setCity(_usCityField.getValue());
        e.setRegion(_usRegionField.getValue());
        e.setPostalCode(_usPostalCodeField.getValue());
        e.setCountry(_usCountryField.getValue());
        e.setPhone(_usPhoneField.getValue());
        return e;
    }

    @Override
    public void setValue(MyAddressIF e)
    {
        if ( e == null )
        {
            clearValue();
            return;
        }

        _usAttentionField.setValue(e.getAttention());
        _usStreet1Field.setValue(e.getStreet1());
        _usStreet2Field.setValue(e.getStreet2());
        _usCityField.setValue(e.getCity());
        _usRegionField.setValue(e.getRegion());
        _usPostalCodeField.setValue(e.getPostalCode());
        _usCountryField.setValue(e.getCountry());
        _usPhoneField.setValue(e.getPhone());
    }

    @Override
    public void saveValue()
    {
        for ( ScTextField e : getFields() )
            e.saveValue();
    }

    @Override
    public void resetValue()
    {
        for ( ScTextField e : getFields() )
            e.resetValue();
    }

    public void clearValue()
    {
        for ( ScTextField e : getFields() )
            e.clearValue();
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
    protected boolean applyFromModel_here(Object model)
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

    public void setReadonly(boolean b)
    {
        _readonly.setValue(b);

        for ( ScTextField e : getFields() )
            e.setReadOnly(b);
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
        getFields().forEach(x -> x.setChangeTracking(e));
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
