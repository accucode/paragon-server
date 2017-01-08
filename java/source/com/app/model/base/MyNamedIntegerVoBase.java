//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyNamedIntegerVoBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaNamedIntegerVo Meta = MyMetaNamedIntegerVo.instance;
    public static final MyNamedIntegerVoTools Tools = MyNamedIntegerVoTools.instance;
    public static final MyNamedIntegerVoValidator Validator = MyNamedIntegerVoValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String name;
    private Integer value;

    //##################################################
    //# constructor
    //##################################################

    public MyNamedIntegerVoBase()
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

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer e)
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

    public boolean hasValue(Integer e)
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
        Validator.validate((MyNamedIntegerVo)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyNamedIntegerVo)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyNamedIntegerVo)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyNamedIntegerVo getCopy()
    {
        return (MyNamedIntegerVo)super.getCopy();
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
    public final MyNamedIntegerVo getBasicCopy()
    {
        MyNamedIntegerVo e;
        e = new MyNamedIntegerVo();
        e.setValue(getValue());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyNamedIntegerVoBase) )
            return false;

        MyNamedIntegerVoBase e = (MyNamedIntegerVoBase)o;
        return Kmu.isEqual(getName(), e.getName());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getName());
    }

    public boolean isSame(MyNamedIntegerVo e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyNamedIntegerVo e)
    {
        if ( !Kmu.isEqual(getValue(), e.getValue()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        return true;
    }

    public boolean isDifferent(MyNamedIntegerVo e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyNamedIntegerVo e)
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
        out.append("MyNamedIntegerVo");
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

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return name;
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
