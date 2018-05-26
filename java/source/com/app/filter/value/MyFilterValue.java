package com.app.filter.value;

import com.kodemore.utility.KmEnumIF;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

public abstract class MyFilterValue<T>
{
    //##################################################
    //# variables
    //##################################################

    private String  _attributeCode;
    private String  _value;
    private boolean _used;

    //##################################################
    //# constructor
    //##################################################

    public MyFilterValue(KmEnumIF attr)
    {
        _attributeCode = attr.getCode();
        _value = null;
        _used = false;
    }

    //##################################################
    //# attribute code
    //##################################################

    public String getAttributeCode()
    {
        return _attributeCode;
    }

    public boolean hasAttributeCode(String e)
    {
        return _attributeCode.equals(e);
    }

    //##################################################
    //# value
    //##################################################

    public abstract T getValue();

    public abstract void setValue(T e);

    public boolean hasValue()
    {
        return getValue() != null;
    }

    //##################################################
    //# string value
    //##################################################

    public final String getStringValue()
    {
        return _value;
    }

    public final void setStringValue(String value)
    {
        _value = value;
        _used = true;
    }

    //##################################################
    //# used
    //##################################################

    public boolean isUsed()
    {
        return _used;
    }

    public void reset()
    {
        _value = null;
        _used = false;
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
