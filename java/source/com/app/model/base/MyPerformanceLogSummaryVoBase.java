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

public abstract class MyPerformanceLogSummaryVoBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaPerformanceLogSummaryVo Meta = MyMetaPerformanceLogSummaryVo.instance;
    public static final MyPerformanceLogSummaryVoTools Tools = MyPerformanceLogSummaryVoTools.instance;
    public static final MyPerformanceLogSummaryVoValidator Validator = MyPerformanceLogSummaryVoValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String name;
    private Integer count;
    private Integer minimumMs;
    private Integer maximumMs;
    private Integer averageMs;
    private Integer totalMs;

    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummaryVoBase()
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
        Validator.validate((MyPerformanceLogSummaryVo)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyPerformanceLogSummaryVo)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyPerformanceLogSummaryVo)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyPerformanceLogSummaryVo getCopy()
    {
        return (MyPerformanceLogSummaryVo)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
    }

    //##################################################
    //# compare
    //##################################################

    public boolean isSame(MyPerformanceLogSummaryVo e)
    {
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyPerformanceLogSummaryVo e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getCount(), e.getCount()) ) return false;
        if ( !Kmu.isEqual(getMinimumMs(), e.getMinimumMs()) ) return false;
        if ( !Kmu.isEqual(getMaximumMs(), e.getMaximumMs()) ) return false;
        if ( !Kmu.isEqual(getAverageMs(), e.getAverageMs()) ) return false;
        if ( !Kmu.isEqual(getTotalMs(), e.getTotalMs()) ) return false;
        return true;
    }

    public boolean isDifferent(MyPerformanceLogSummaryVo e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyPerformanceLogSummaryVo e)
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

        if ( p.hasKey("name") )
            setName(p.getString("name"));

        if ( p.hasKey("count") )
            setCount(p.getInteger("count"));

        if ( p.hasKey("minimumMs") )
            setMinimumMs(p.getInteger("minimumMs"));

        if ( p.hasKey("maximumMs") )
            setMaximumMs(p.getInteger("maximumMs"));

        if ( p.hasKey("averageMs") )
            setAverageMs(p.getInteger("averageMs"));

        if ( p.hasKey("totalMs") )
            setTotalMs(p.getInteger("totalMs"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasName() )
            p.setString("name", getName());

        if ( hasCount() )
            p.setInteger("count", getCount());

        if ( hasMinimumMs() )
            p.setInteger("minimumMs", getMinimumMs());

        if ( hasMaximumMs() )
            p.setInteger("maximumMs", getMaximumMs());

        if ( hasAverageMs() )
            p.setInteger("averageMs", getAverageMs());

        if ( hasTotalMs() )
            p.setInteger("totalMs", getTotalMs());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyPerformanceLogSummaryVo");
        sb.append("(");
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Name = " + name);
        System.out.println("    Count = " + count);
        System.out.println("    MinimumMs = " + minimumMs);
        System.out.println("    MaximumMs = " + maximumMs);
        System.out.println("    AverageMs = " + averageMs);
        System.out.println("    TotalMs = " + totalMs);
    }

}
