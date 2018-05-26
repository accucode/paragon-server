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
public abstract class MyPerformanceLogSummaryBase
    extends MyAbstractDaoDomain<MyPerformanceLogSummary>
    implements KmUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaPerformanceLogSummary Meta = MyMetaPerformanceLogSummary.instance;
    public static final MyPerformanceLogSummaryTools Tools = MyPerformanceLogSummaryTools.instance;
    public static final MyPerformanceLogSummaryValidator Validator = MyPerformanceLogSummaryValidator.instance;
    public static final MyPerformanceLogSummaryFinder Finder = MyPerformanceLogSummaryFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private Integer averageMs;
    private Integer count;
    private Integer maximumMs;
    private Integer minimumMs;
    private String name;
    private Integer totalMs;
    private String uid;
    private KmDate utcDate;

    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummaryBase()
    {
        super();
        setUid(newUid());
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
    //# field (averageMs)
    //##################################################

    public Integer getAverageMs()
    {
        return averageMs;
    }

    public void setAverageMs(Integer e)
    {
        e = Validator.getAverageMsValidator().convert(e);
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
    //# field (maximumMs)
    //##################################################

    public Integer getMaximumMs()
    {
        return maximumMs;
    }

    public void setMaximumMs(Integer e)
    {
        e = Validator.getMaximumMsValidator().convert(e);
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
    //# field (minimumMs)
    //##################################################

    public Integer getMinimumMs()
    {
        return minimumMs;
    }

    public void setMinimumMs(Integer e)
    {
        e = Validator.getMinimumMsValidator().convert(e);
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
    //# field (totalMs)
    //##################################################

    public Integer getTotalMs()
    {
        return totalMs;
    }

    public void setTotalMs(Integer e)
    {
        e = Validator.getTotalMsValidator().convert(e);
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
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        e = Validator.getUidValidator().convert(e);
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
        e = Validator.getUtcDateValidator().convert(e);
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
    //# validate
    //##################################################

    @Override
    protected final MyPerformanceLogSummaryValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyPerformanceLogSummary asSubclass()
    {
        return (MyPerformanceLogSummary)this;
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
        uid = newUid();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyPerformanceLogSummary getBasicCopy()
    {
        MyPerformanceLogSummary e;
        e = new MyPerformanceLogSummary();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyPerformanceLogSummary e)
    {
        e.setAverageMs(getAverageMs());
        e.setCount(getCount());
        e.setMaximumMs(getMaximumMs());
        e.setMinimumMs(getMinimumMs());
        e.setName(getName());
        e.setTotalMs(getTotalMs());
        e.setUtcDate(getUtcDate());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyPerformanceLogSummary e)
    {
        setAverageMs(e.getAverageMs());
        setCount(e.getCount());
        setMaximumMs(e.getMaximumMs());
        setMinimumMs(e.getMinimumMs());
        setName(e.getName());
        setTotalMs(e.getTotalMs());
        setUtcDate(e.getUtcDate());
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
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getAverageMs(), e.getAverageMs()) ) return false;
        if ( !Kmu.isEqual(getCount(), e.getCount()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getMaximumMs(), e.getMaximumMs()) ) return false;
        if ( !Kmu.isEqual(getMinimumMs(), e.getMinimumMs()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getTotalMs(), e.getTotalMs()) ) return false;
        if ( !Kmu.isEqual(getUtcDate(), e.getUtcDate()) ) return false;
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
        System.out.println("    AverageMs = " + averageMs);
        System.out.println("    Count = " + count);
        System.out.println("    MaximumMs = " + maximumMs);
        System.out.println("    MinimumMs = " + minimumMs);
        System.out.println("    Name = " + name);
        System.out.println("    TotalMs = " + totalMs);
        System.out.println("    Uid = " + uid);
        System.out.println("    UtcDate = " + utcDate);
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
