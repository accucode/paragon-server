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
import com.kodemore.domain.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.finder.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyNamedMoneyVoBase
    extends MyAbstractValueDomain<MyNamedMoneyVo>
    implements KmDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaNamedMoneyVo Meta = MyMetaNamedMoneyVo.instance;
    public static final MyNamedMoneyVoTools Tools = MyNamedMoneyVoTools.instance;
    public static final MyNamedMoneyVoValidator Validator = MyNamedMoneyVoValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String name;
    private KmMoney value;

    //##################################################
    //# constructor
    //##################################################

    public MyNamedMoneyVoBase()
    {
        super();
    }

    //##################################################
    //# field (auditLogTitle)
    //##################################################

    public abstract String getAuditLogTitle();

    public boolean hasAuditLogTitle()
    {
        return Kmu.hasValue(getAuditLogTitle());
    }

    public boolean hasAuditLogTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getAuditLogTitle(), e);
    }

    //##################################################
    //# field (domainSubtitle)
    //##################################################

    public abstract String getDomainSubtitle();

    public boolean hasDomainSubtitle()
    {
        return Kmu.hasValue(getDomainSubtitle());
    }

    public boolean hasDomainSubtitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainSubtitle(), e);
    }

    //##################################################
    //# field (domainTitle)
    //##################################################

    public abstract String getDomainTitle();

    public boolean hasDomainTitle()
    {
        return Kmu.hasValue(getDomainTitle());
    }

    public boolean hasDomainTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainTitle(), e);
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
        e = Validator.getNameValidator().convert(e);
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

    public KmMoney getValue()
    {
        return value;
    }

    public void setValue(KmMoney e)
    {
        e = Validator.getValueValidator().convert(e);
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

    public boolean hasValue(KmMoney e)
    {
        return Kmu.isEqual(getValue(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyNamedMoneyVoValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyNamedMoneyVo asSubclass()
    {
        return (MyNamedMoneyVo)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyNamedMoneyVo getCopy()
    {
        return (MyNamedMoneyVo)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyNamedMoneyVo getBasicCopy()
    {
        MyNamedMoneyVo e;
        e = new MyNamedMoneyVo();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyNamedMoneyVo e)
    {
        e.setName(getName());
        e.setValue(getValue());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyNamedMoneyVo e)
    {
        setName(e.getName());
        setValue(e.getValue());
    }

    //##################################################
    //# compare
    //##################################################

    public boolean isSame(MyNamedMoneyVo e)
    {
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyNamedMoneyVo e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getValue(), e.getValue()) ) return false;
        return true;
    }

    public boolean isDifferent(MyNamedMoneyVo e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyNamedMoneyVo e)
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
        out.append("MyNamedMoneyVo");
        out.append("(");
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
