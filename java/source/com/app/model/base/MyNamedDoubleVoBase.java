//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.utility.Kmu;

import com.app.model.MyNamedDoubleVo;
import com.app.model.MyNamedDoubleVoTools;
import com.app.model.MyNamedDoubleVoValidator;
import com.app.model.core.MyAbstractValueDomain;
import com.app.model.core.MyDomainIF;
import com.app.model.meta.MyMetaNamedDoubleVo;

@SuppressWarnings("all")
public abstract class MyNamedDoubleVoBase
    extends MyAbstractValueDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaNamedDoubleVo      Meta      = MyMetaNamedDoubleVo.instance;
    public static final MyNamedDoubleVoTools     Tools     = MyNamedDoubleVoTools.instance;
    public static final MyNamedDoubleVoValidator Validator = MyNamedDoubleVoValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String                               name;
    private Double                               value;

    //##################################################
    //# constructor
    //##################################################

    public MyNamedDoubleVoBase()
    {
        super();
    }

    //##################################################
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        e = Validator.getNameValidator().convertOnly(e);
        name = e;
    }

    public void clearName()
    {
        setName(null);
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqualIgnoreCase(getName(), e);
    }

    public void truncateName()
    {
        truncateName(false);
    }

    public void truncateName(boolean ellipses)
    {
        name = Kmu.truncate(name, 100, ellipses);
    }

    //##################################################
    //# field (value)
    //##################################################

    public Double getValue()
    {
        return value;
    }

    public void setValue(Double e)
    {
        e = Validator.getValueValidator().convertOnly(e);
        value = e;
    }

    public void clearValue()
    {
        setValue(null);
    }

    public boolean hasValue()
    {
        return getValue() != null;
    }

    public boolean hasValue(Double e)
    {
        return Kmu.isEqual(getValue(), e);
    }

    //##################################################
    //# field (displayString)
    //##################################################

    public abstract String getDisplayString();

    public boolean hasDisplayString()
    {
        return Kmu.hasValue(getDisplayString());
    }

    public boolean hasDisplayString(String e)
    {
        return Kmu.isEqualIgnoreCase(getDisplayString(), e);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyNamedDoubleVo)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyNamedDoubleVo)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyNamedDoubleVo)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyNamedDoubleVo getCopy()
    {
        return (MyNamedDoubleVo)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        name = null;
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyNamedDoubleVo getBasicCopy()
    {
        MyNamedDoubleVo e;
        e = new MyNamedDoubleVo();
        e.setValue(getValue());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyNamedDoubleVoBase) )
            return false;

        MyNamedDoubleVoBase e = (MyNamedDoubleVoBase)o;
        return Kmu.isEqual(getName(), e.getName());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getName());
    }

    public boolean isSame(MyNamedDoubleVo e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) )
            return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyNamedDoubleVo e)
    {
        if ( !Kmu.isEqual(getValue(), e.getValue()) )
            return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) )
            return false;
        return true;
    }

    public boolean isDifferent(MyNamedDoubleVo e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyNamedDoubleVo e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("MyNamedDoubleVo");
        out.append("(");
        out.append("Name=");
        out.append(name);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Name = " + name);
        System.out.println("    Value = " + value);
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getMetaName()
    {
        return Meta.getName();
    }

}
