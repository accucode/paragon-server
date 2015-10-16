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

public abstract class MyCustomerTierBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaCustomerTier Meta = MyMetaCustomerTier.instance;
    public static final MyCustomerTierTools Tools = MyCustomerTierTools.instance;
    public static final MyCustomerTierValidator Validator = MyCustomerTierValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Double discountRate;
    private Integer lockVersion;
    private MyProject project;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerTierBase()
    {
        super();
        setUid(newUid());
        setDiscountRate(0.0);
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
        name = Kmu.truncate(name, 50, ellipses);
    }

    //##################################################
    //# field (discountRate)
    //##################################################

    public Double getDiscountRate()
    {
        return discountRate;
    }

    public void setDiscountRate(Double e)
    {
        checkReadOnly();
        e = Validator.getDiscountRateValidator().convertOnly(e);
        discountRate = e;
    }

    public void clearDiscountRate()
    {
        setDiscountRate(null);
    }

    public boolean hasDiscountRate()
    {
        return getDiscountRate() != null;
    }

    public boolean hasDiscountRate(Double e)
    {
        return Kmu.isEqual(getDiscountRate(), e);
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
        Validator.validate((MyCustomerTier)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyCustomerTier)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyCustomerTier)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyCustomerTier getCopy()
    {
        return (MyCustomerTier)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyCustomerTierBase) )
            return false;

        MyCustomerTierBase e = (MyCustomerTierBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyCustomerTier e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyCustomerTier e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getDiscountRate(), e.getDiscountRate()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyCustomerTier e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyCustomerTier e)
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
        out.append("MyCustomerTier");
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
        System.out.println("    Name = " + name);
        System.out.println("    DiscountRate = " + discountRate);
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
