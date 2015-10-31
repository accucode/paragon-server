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

public abstract class MyNextOrderNumberBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaNextOrderNumber Meta = MyMetaNextOrderNumber.instance;
    public static final MyNextOrderNumberTools Tools = MyNextOrderNumberTools.instance;
    public static final MyNextOrderNumberValidator Validator = MyNextOrderNumberValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmDate date;
    private Integer nextNumber;
    private Integer lockVersion;
    private MyProject project;

    //##################################################
    //# constructor
    //##################################################

    public MyNextOrderNumberBase()
    {
        super();
        setUid(newUid());
        setNextNumber(1);
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
    //# field (date)
    //##################################################

    public KmDate getDate()
    {
        return date;
    }

    public void setDate(KmDate e)
    {
        checkReadOnly();
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
    //# field (nextNumber)
    //##################################################

    public Integer getNextNumber()
    {
        return nextNumber;
    }

    public void setNextNumber(Integer e)
    {
        checkReadOnly();
        e = Validator.getNextNumberValidator().convertOnly(e);
        nextNumber = e;
    }

    public void clearNextNumber()
    {
        setNextNumber(null);
    }

    public boolean hasNextNumber()
    {
        return getNextNumber() != null;
    }

    public boolean hasNextNumber(Integer e)
    {
        return Kmu.isEqual(getNextNumber(), e);
    }

    //##################################################
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        checkReadOnly();
        e = Validator.getLockVersionValidator().convertOnly(e);
        lockVersion = e;
    }

    public void clearLockVersion()
    {
        setLockVersion(null);
    }

    public boolean hasLockVersion()
    {
        return getLockVersion() != null;
    }

    public boolean hasLockVersion(Integer e)
    {
        return Kmu.isEqual(getLockVersion(), e);
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        return project;
    }

    public void setProject(MyProject e)
    {
        checkReadOnly();
        project = e;
    }

    public void _setProject(MyProject e)
    {
        checkReadOnly();
        project = e;
    }

    public void clearProject()
    {
        setProject(null);
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    public boolean hasProject(MyProject e)
    {
        return Kmu.isEqual(getProject(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyNextOrderNumber)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyNextOrderNumber)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyNextOrderNumber)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyNextOrderNumber getCopy()
    {
        return (MyNextOrderNumber)super.getCopy();
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
        if ( !(o instanceof MyNextOrderNumberBase) )
            return false;

        MyNextOrderNumberBase e = (MyNextOrderNumberBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyNextOrderNumber e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyNextOrderNumber e)
    {
        if ( !Kmu.isEqual(getDate(), e.getDate()) ) return false;
        if ( !Kmu.isEqual(getNextNumber(), e.getNextNumber()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyNextOrderNumber e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyNextOrderNumber e)
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
        out.append("MyNextOrderNumber");
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
        System.out.println("    Date = " + date);
        System.out.println("    NextNumber = " + nextNumber);
        System.out.println("    LockVersion = " + lockVersion);
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
