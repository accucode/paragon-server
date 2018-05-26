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
public abstract class MyDatedCountVoBase
    extends MyAbstractValueDomain<MyDatedCountVo>
    implements KmDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaDatedCountVo Meta = MyMetaDatedCountVo.instance;
    public static final MyDatedCountVoTools Tools = MyDatedCountVoTools.instance;
    public static final MyDatedCountVoValidator Validator = MyDatedCountVoValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private Integer count;
    private KmDate date;

    //##################################################
    //# constructor
    //##################################################

    public MyDatedCountVoBase()
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
    //# field (count)
    //##################################################

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer e)
    {
        e = Validator.getCountValidator().convert(e);
        count = e;
    }

    public void clearCount()
    {
        setCount(null);
    }

    public boolean hasCount()
    {
        return getCount() != null;
    }

    public boolean hasCount(Integer e)
    {
        return Kmu.isEqual(getCount(), e);
    }

    //##################################################
    //# field (date)
    //##################################################

    public KmDate getDate()
    {
        return date;
    }

    public void setDate(KmDate e)
    {
        e = Validator.getDateValidator().convert(e);
        date = e;
    }

    public void clearDate()
    {
        setDate(null);
    }

    public boolean hasDate()
    {
        return getDate() != null;
    }

    public boolean hasDate(KmDate e)
    {
        return Kmu.isEqual(getDate(), e);
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
    //# validate
    //##################################################

    @Override
    protected final MyDatedCountVoValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyDatedCountVo asSubclass()
    {
        return (MyDatedCountVo)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyDatedCountVo getCopy()
    {
        return (MyDatedCountVo)super.getCopy();
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
    public final MyDatedCountVo getBasicCopy()
    {
        MyDatedCountVo e;
        e = new MyDatedCountVo();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyDatedCountVo e)
    {
        e.setCount(getCount());
        e.setDate(getDate());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyDatedCountVo e)
    {
        setCount(e.getCount());
        setDate(e.getDate());
    }

    //##################################################
    //# compare
    //##################################################

    public boolean isSame(MyDatedCountVo e)
    {
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyDatedCountVo e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getCount(), e.getCount()) ) return false;
        if ( !Kmu.isEqual(getDate(), e.getDate()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        return true;
    }

    public boolean isDifferent(MyDatedCountVo e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyDatedCountVo e)
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
        out.append("MyDatedCountVo");
        out.append("(");
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Count = " + count);
        System.out.println("    Date = " + date);
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
