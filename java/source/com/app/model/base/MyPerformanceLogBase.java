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

public abstract class MyPerformanceLogBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaPerformanceLog Meta = MyMetaPerformanceLog.instance;
    public static final MyPerformanceLogTools Tools = MyPerformanceLogTools.instance;
    public static final MyPerformanceLogValidator Validator = MyPerformanceLogValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private Integer id;
    private String name;
    private KmTimestamp createdUtcTs;
    private Integer durationMs;

    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogBase()
    {
        super();
        setCreatedUtcTs(getNowUtc());
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
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        checkReadOnly();
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
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        checkReadOnly();
        e = Validator.getCreatedUtcTsValidator().convertOnly(e);
        createdUtcTs = e;
    }

    public void clearCreatedUtcTs()
    {
        setCreatedUtcTs(null);
    }

    public boolean hasCreatedUtcTs()
    {
        return getCreatedUtcTs() != null;
    }

    public boolean hasCreatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedUtcTs(), e);
    }

    //##################################################
    //# field (durationMs)
    //##################################################

    public Integer getDurationMs()
    {
        return durationMs;
    }

    public void setDurationMs(Integer e)
    {
        checkReadOnly();
        e = Validator.getDurationMsValidator().convertOnly(e);
        durationMs = e;
    }

    public void clearDurationMs()
    {
        setDurationMs(null);
    }

    public boolean hasDurationMs()
    {
        return getDurationMs() != null;
    }

    public boolean hasDurationMs(Integer e)
    {
        return Kmu.isEqual(getDurationMs(), e);
    }

    //##################################################
    //# field (createdLocalTs)
    //##################################################

    public final KmTimestamp getCreatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTs()
    {
        return getCreatedLocalTs() != null;
    }

    public boolean hasCreatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedLocalTs(), e);
    }

    //##################################################
    //# field (createdLocalTsMessage)
    //##################################################

    public final String getCreatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTsMessage()
    {
        return Kmu.hasValue(getCreatedLocalTsMessage());
    }

    public boolean hasCreatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getCreatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (createdLocalDate)
    //##################################################

    public final KmDate getCreatedLocalDate()
    {
        return KmTimestampUtility.getDate(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalDate()
    {
        return getCreatedLocalDate() != null;
    }

    public boolean hasCreatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getCreatedLocalDate(), e);
    }

    //##################################################
    //# field (createdLocalTime)
    //##################################################

    public final KmTime getCreatedLocalTime()
    {
        return KmTimestampUtility.getTime(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalTime()
    {
        return getCreatedLocalTime() != null;
    }

    public boolean hasCreatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getCreatedLocalTime(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyPerformanceLog)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyPerformanceLog)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyPerformanceLog)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyPerformanceLog getCopy()
    {
        return (MyPerformanceLog)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        id = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyPerformanceLogBase) )
            return false;

        MyPerformanceLogBase e = (MyPerformanceLogBase)o;
        return Kmu.isEqual(getId(), e.getId());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getId());
    }

    public boolean isSame(MyPerformanceLog e)
    {
        if ( !Kmu.isEqual(getId(), e.getId()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyPerformanceLog e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDurationMs(), e.getDurationMs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyPerformanceLog e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyPerformanceLog e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("id") )
            setId(p.getInteger("id"));

        if ( p.hasKey("name") )
            setName(p.getString("name"));

        if ( p.hasKey("durationMs") )
            setDurationMs(p.getInteger("durationMs"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasId() )
            p.setInteger("id", getId());

        if ( hasName() )
            p.setString("name", getName());

        if ( hasDurationMs() )
            p.setInteger("durationMs", getDurationMs());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyPerformanceLog");
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
        System.out.println("    Name = " + name);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    DurationMs = " + durationMs);
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
