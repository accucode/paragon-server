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
public abstract class MyPatchBase
    extends MyAbstractDaoDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaPatch Meta = MyMetaPatch.instance;
    public static final MyPatchTools Tools = MyPatchTools.instance;
    public static final MyPatchValidator Validator = MyPatchValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String name;
    private KmTimestamp installedUtcTs;
    private String source;

    //##################################################
    //# constructor
    //##################################################

    public MyPatchBase()
    {
        super();
        setInstalledUtcTs(nowUtc());
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
        name = Kmu.truncate(name, 50, ellipses);
    }

    //##################################################
    //# field (installedUtcTs)
    //##################################################

    public KmTimestamp getInstalledUtcTs()
    {
        return installedUtcTs;
    }

    public void setInstalledUtcTs(KmTimestamp e)
    {
        e = Validator.getInstalledUtcTsValidator().convertOnly(e);
        installedUtcTs = e;
    }

    public void clearInstalledUtcTs()
    {
        setInstalledUtcTs(null);
    }

    public boolean hasInstalledUtcTs()
    {
        return getInstalledUtcTs() != null;
    }

    public boolean hasInstalledUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getInstalledUtcTs(), e);
    }

    //##################################################
    //# field (source)
    //##################################################

    public String getSource()
    {
        return source;
    }

    public void setSource(String e)
    {
        e = Validator.getSourceValidator().convertOnly(e);
        source = e;
    }

    public void clearSource()
    {
        setSource(null);
    }

    public boolean hasSource()
    {
        return Kmu.hasValue(getSource());
    }

    public boolean hasSource(String e)
    {
        return Kmu.isEqualIgnoreCase(getSource(), e);
    }

    public void truncateSource()
    {
        truncateSource(false);
    }

    public void truncateSource(boolean ellipses)
    {
        source = Kmu.truncate(source, 50000, ellipses);
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
    //# field (installedLocalTs)
    //##################################################

    public final KmTimestamp getInstalledLocalTs()
    {
        return KmTimestampUtility.toLocal(getInstalledUtcTs());
    }

    public boolean hasInstalledLocalTs()
    {
        return getInstalledLocalTs() != null;
    }

    public boolean hasInstalledLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getInstalledLocalTs(), e);
    }

    //##################################################
    //# field (installedLocalTsMessage)
    //##################################################

    public final String getInstalledLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getInstalledUtcTs());
    }

    public boolean hasInstalledLocalTsMessage()
    {
        return Kmu.hasValue(getInstalledLocalTsMessage());
    }

    public boolean hasInstalledLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getInstalledLocalTsMessage(), e);
    }

    //##################################################
    //# field (installedLocalDate)
    //##################################################

    public final KmDate getInstalledLocalDate()
    {
        return KmTimestampUtility.getDate(getInstalledLocalTs());
    }

    public boolean hasInstalledLocalDate()
    {
        return getInstalledLocalDate() != null;
    }

    public boolean hasInstalledLocalDate(KmDate e)
    {
        return Kmu.isEqual(getInstalledLocalDate(), e);
    }

    //##################################################
    //# field (installedLocalTime)
    //##################################################

    public final KmTime getInstalledLocalTime()
    {
        return KmTimestampUtility.getTime(getInstalledLocalTs());
    }

    public boolean hasInstalledLocalTime()
    {
        return getInstalledLocalTime() != null;
    }

    public boolean hasInstalledLocalTime(KmTime e)
    {
        return Kmu.isEqual(getInstalledLocalTime(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyPatch)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyPatch)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyPatch)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyPatch getCopy()
    {
        return (MyPatch)super.getCopy();
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
    public final MyPatch getBasicCopy()
    {
        MyPatch e;
        e = new MyPatch();
        e.setInstalledUtcTs(getInstalledUtcTs());
        e.setSource(getSource());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyPatchBase) )
            return false;

        MyPatchBase e = (MyPatchBase)o;
        return Kmu.isEqual(getName(), e.getName());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getName());
    }

    public boolean isSame(MyPatch e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyPatch e)
    {
        if ( !Kmu.isEqual(getInstalledUtcTs(), e.getInstalledUtcTs()) ) return false;
        if ( !Kmu.isEqual(getSource(), e.getSource()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getInstalledLocalTs(), e.getInstalledLocalTs()) ) return false;
        if ( !Kmu.isEqual(getInstalledLocalTsMessage(), e.getInstalledLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getInstalledLocalDate(), e.getInstalledLocalDate()) ) return false;
        if ( !Kmu.isEqual(getInstalledLocalTime(), e.getInstalledLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyPatch e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyPatch e)
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
        out.append("MyPatch");
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
        System.out.println("    InstalledUtcTs = " + installedUtcTs);
        System.out.println("    Source = " + source);
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
