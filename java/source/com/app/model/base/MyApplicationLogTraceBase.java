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
import com.app.utility.*;

public abstract class MyApplicationLogTraceBase
    extends MyAbstractDomain
    implements KmSequenceIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaApplicationLogTrace Meta = MyMetaApplicationLogTrace.instance;
    public static final MyApplicationLogTraceTools Tools = MyApplicationLogTraceTools.instance;
    public static final MyApplicationLogTraceValidator Validator = MyApplicationLogTraceValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private Integer id;
    private Integer sequence;
    private String value;
    private MyApplicationLog log;

    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogTraceBase()
    {
        super();
    }

    //##################################################
    //# field (id)
    //##################################################

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer e)
    {
        checkReadOnly();
        e = Validator.getIdValidator().convertOnly(e);
        id = e;
    }

    public void clearId()
    {
        setId(null);
    }

    public boolean hasId()
    {
        return getId() != null;
    }

    public boolean hasId(Integer e)
    {
        return Kmu.isEqual(getId(), e);
    }

    //##################################################
    //# field (sequence)
    //##################################################

    @Override
    public Integer getSequence()
    {
        return sequence;
    }

    @Override
    public void setSequence(Integer e)
    {
        checkReadOnly();
        e = Validator.getSequenceValidator().convertOnly(e);
        sequence = e;
    }

    public void clearSequence()
    {
        setSequence(null);
    }

    public boolean hasSequence()
    {
        return getSequence() != null;
    }

    public boolean hasSequence(Integer e)
    {
        return Kmu.isEqual(getSequence(), e);
    }

    //##################################################
    //# field (value)
    //##################################################

    public String getValue()
    {
        return value;
    }

    public void setValue(String e)
    {
        checkReadOnly();
        e = Validator.getValueValidator().convertOnly(e);
        value = e;
    }

    public void clearValue()
    {
        setValue(null);
    }

    public boolean hasValue()
    {
        return Kmu.hasValue(getValue());
    }

    public boolean hasValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getValue(), e);
    }

    public void truncateValue()
    {
        truncateValue(false);
    }

    public void truncateValue(boolean ellipses)
    {
        value = Kmu.truncate(value, 1000, ellipses);
    }

    //##################################################
    //# log
    //##################################################

    public MyApplicationLog getLog()
    {
        return log;
    }

    public void setLog(MyApplicationLog e)
    {
        checkReadOnly();
        log = e;
    }

    public void _setLog(MyApplicationLog e)
    {
        checkReadOnly();
        log = e;
    }

    public void clearLog()
    {
        setLog(null);
    }

    public boolean hasLog()
    {
        return getLog() != null;
    }

    public boolean hasLog(MyApplicationLog e)
    {
        return Kmu.isEqual(getLog(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyApplicationLogTrace)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyApplicationLogTrace)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyApplicationLogTrace)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyApplicationLogTrace getCopy()
    {
        return (MyApplicationLogTrace)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        id = null;
        log = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyApplicationLogTraceBase) )
            return false;

        MyApplicationLogTraceBase e = (MyApplicationLogTraceBase)o;
        return Kmu.isEqual(getId(), e.getId());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getId());
    }

    public boolean isSame(MyApplicationLogTrace e)
    {
        if ( !Kmu.isEqual(getId(), e.getId()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyApplicationLogTrace e)
    {
        if ( !Kmu.isEqual(getSequence(), e.getSequence()) ) return false;
        if ( !Kmu.isEqual(getValue(), e.getValue()) ) return false;
        return true;
    }

    public boolean isDifferent(MyApplicationLogTrace e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyApplicationLogTrace e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyApplicationLogTrace");
        sb.append("(");
        sb.append("Id=");
        sb.append(id);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Id = " + id);
        System.out.println("    Sequence = " + sequence);
        System.out.println("    Value = " + value);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(id));
        return sb.toString();
    }

}
