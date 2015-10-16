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

public abstract class MyPerformanceLogSummaryBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaPerformanceLogSummary Meta = MyMetaPerformanceLogSummary.instance;
    public static final MyPerformanceLogSummaryTools Tools = MyPerformanceLogSummaryTools.instance;
    public static final MyPerformanceLogSummaryValidator Validator = MyPerformanceLogSummaryValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmDate utcDate;
    private String name;
    private Integer count;
    private Integer minimumMs;
    private Integer maximumMs;
    private Integer averageMs;
    private Integer totalMs;

    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummaryBase()
    {
        super();
        setUid(newUid());
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        checkReadOnly();
        e = Validator.getUidValidator().convertOnly(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (utcDate)
    //##################################################

    public KmDate getUtcDate()
    {
        return utcDate;
    }

    public void setUtcDate(KmDate e)
    {
        checkReadOnly();
        e = Validator.getUtcDateValidator().convertOnly(e);
        utcDate = e;
    }

    public void clearUtcDate()
    {
        setUtcDate(null);
    }

    public boolean hasUtcDate()
    {
        return getUtcDate() != null;
    }

    public boolean hasUtcDate(KmDate e)
    {
        return Kmu.isEqual(getUtcDate(), e);
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
    //# field (count)
    //##################################################

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer e)
    {
        checkReadOnly();
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
    //# field (minimumMs)
    //##################################################

    public Integer getMinimumMs()
    {
        return minimumMs;
    }

    public void setMinimumMs(Integer e)
    {
        checkReadOnly();
        e = Validator.getMinimumMsValidator().convertOnly(e);
        minimumMs = e;
    }

    public void clearMinimumMs()
    {
        setMinimumMs(null);
    }

    public boolean hasMinimumMs()
    {
        return getMinimumMs() != null;
    }

    public boolean hasMinimumMs(Integer e)
    {
        return Kmu.isEqual(getMinimumMs(), e);
    }

    //##################################################
    //# field (maximumMs)
    //##################################################

    public Integer getMaximumMs()
    {
        return maximumMs;
    }

    public void setMaximumMs(Integer e)
    {
        checkReadOnly();
        e = Validator.getMaximumMsValidator().convertOnly(e);
        maximumMs = e;
    }

    public void clearMaximumMs()
    {
        setMaximumMs(null);
    }

    public boolean hasMaximumMs()
    {
        return getMaximumMs() != null;
    }

    public boolean hasMaximumMs(Integer e)
    {
        return Kmu.isEqual(getMaximumMs(), e);
    }

    //##################################################
    //# field (averageMs)
    //##################################################

    public Integer getAverageMs()
    {
        return averageMs;
    }

    public void setAverageMs(Integer e)
    {
        checkReadOnly();
        e = Validator.getAverageMsValidator().convertOnly(e);
        averageMs = e;
    }

    public void clearAverageMs()
    {
        setAverageMs(null);
    }

    public boolean hasAverageMs()
    {
        return getAverageMs() != null;
    }

    public boolean hasAverageMs(Integer e)
    {
        return Kmu.isEqual(getAverageMs(), e);
    }

    //##################################################
    //# field (totalMs)
    //##################################################

    public Integer getTotalMs()
    {
        return totalMs;
    }

    public void setTotalMs(Integer e)
    {
        checkReadOnly();
        e = Validator.getTotalMsValidator().convertOnly(e);
        totalMs = e;
    }

    public void clearTotalMs()
    {
        setTotalMs(null);
    }

    public boolean hasTotalMs()
    {
        return getTotalMs() != null;
    }

    public boolean hasTotalMs(Integer e)
    {
        return Kmu.isEqual(getTotalMs(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyPerformanceLogSummary)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyPerformanceLogSummary)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyPerformanceLogSummary)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyPerformanceLogSummary getCopy()
    {
        return (MyPerformanceLogSummary)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyPerformanceLogSummaryBase) )
            return false;

        MyPerformanceLogSummaryBase e = (MyPerformanceLogSummaryBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyPerformanceLogSummary e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyPerformanceLogSummary e)
    {
        if ( !Kmu.isEqual(getUtcDate(), e.getUtcDate()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getCount(), e.getCount()) ) return false;
        if ( !Kmu.isEqual(getMinimumMs(), e.getMinimumMs()) ) return false;
        if ( !Kmu.isEqual(getMaximumMs(), e.getMaximumMs()) ) return false;
        if ( !Kmu.isEqual(getAverageMs(), e.getAverageMs()) ) return false;
        if ( !Kmu.isEqual(getTotalMs(), e.getTotalMs()) ) return false;
        return true;
    }

    public boolean isDifferent(MyPerformanceLogSummary e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyPerformanceLogSummary e)
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
        out.append("MyPerformanceLogSummary");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    UtcDate = " + utcDate);
        System.out.println("    Name = " + name);
        System.out.println("    Count = " + count);
        System.out.println("    MinimumMs = " + minimumMs);
        System.out.println("    MaximumMs = " + maximumMs);
        System.out.println("    AverageMs = " + averageMs);
        System.out.println("    TotalMs = " + totalMs);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return uid;
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
