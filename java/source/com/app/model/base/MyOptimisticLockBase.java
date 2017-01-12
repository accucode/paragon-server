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
public abstract class MyOptimisticLockBase
    extends MyAbstractDaoDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaOptimisticLock Meta = MyMetaOptimisticLock.instance;
    public static final MyOptimisticLockTools Tools = MyOptimisticLockTools.instance;
    public static final MyOptimisticLockValidator Validator = MyOptimisticLockValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String name;
    private Integer lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public MyOptimisticLockBase()
    {
        super();
        setLockVersion(0);
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
        name = Kmu.truncate(name, 100, ellipses);
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
        Validator.validate((MyOptimisticLock)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyOptimisticLock)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyOptimisticLock)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyOptimisticLock getCopy()
    {
        return (MyOptimisticLock)super.getCopy();
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
    public final MyOptimisticLock getBasicCopy()
    {
        MyOptimisticLock e;
        e = new MyOptimisticLock();
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyOptimisticLockBase) )
            return false;

        MyOptimisticLockBase e = (MyOptimisticLockBase)o;
        return Kmu.isEqual(getName(), e.getName());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getName());
    }

    public boolean isSame(MyOptimisticLock e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyOptimisticLock e)
    {
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        return true;
    }

    public boolean isDifferent(MyOptimisticLock e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyOptimisticLock e)
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
        out.append("MyOptimisticLock");
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
        System.out.println("    LockVersion = " + lockVersion);
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

    public void daoTouch()
    {
        setLockVersion(getLockVersion() + 1);
    }

}
