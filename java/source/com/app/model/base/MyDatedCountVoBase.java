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
public abstract class MyDatedCountVoBase
    extends MyAbstractDomain
    implements MyDomainIF
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

    private KmDate date;
    private Integer count;

    //##################################################
    //# constructor
    //##################################################

    public MyDatedCountVoBase()
    {
        super();
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
        e = Validator.getDateValidator().convertOnly(e);
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
    //# field (count)
    //##################################################

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer e)
    {
        e = Validator.getCountValidator().convertOnly(e);
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
        Validator.validate((MyDatedCountVo)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyDatedCountVo)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyDatedCountVo)this);
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
        date = null;
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
        e.setCount(getCount());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyDatedCountVoBase) )
            return false;

        MyDatedCountVoBase e = (MyDatedCountVoBase)o;
        return Kmu.isEqual(getDate(), e.getDate());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getDate());
    }

    public boolean isSame(MyDatedCountVo e)
    {
        if ( !Kmu.isEqual(getDate(), e.getDate()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyDatedCountVo e)
    {
        if ( !Kmu.isEqual(getCount(), e.getCount()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
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
        out.append("Date=");
        out.append(date);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Date = " + date);
        System.out.println("    Count = " + count);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        ScFormatter f = getFormatter();

        StringBuilder out;
        out = new StringBuilder();
        out.append(f.formatAny(date));
        return out.toString();
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
