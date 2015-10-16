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

public abstract class MyShipMethodBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaShipMethod Meta = MyMetaShipMethod.instance;
    public static final MyShipMethodTools Tools = MyShipMethodTools.instance;
    public static final MyShipMethodValidator Validator = MyShipMethodValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Integer lockVersion;
    private MyShipCarrier carrier;

    //##################################################
    //# constructor
    //##################################################

    public MyShipMethodBase()
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
    //# carrier
    //##################################################

    public MyShipCarrier getCarrier()
    {
        return carrier;
    }

    public void setCarrier(MyShipCarrier e)
    {
        checkReadOnly();
        carrier = e;
    }

    public void _setCarrier(MyShipCarrier e)
    {
        checkReadOnly();
        carrier = e;
    }

    public void clearCarrier()
    {
        setCarrier(null);
    }

    public boolean hasCarrier()
    {
        return getCarrier() != null;
    }

    public boolean hasCarrier(MyShipCarrier e)
    {
        return Kmu.isEqual(getCarrier(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyShipMethod)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyShipMethod)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyShipMethod)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyShipMethod getCopy()
    {
        return (MyShipMethod)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        carrier = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyShipMethodBase) )
            return false;

        MyShipMethodBase e = (MyShipMethodBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyShipMethod e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyShipMethod e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyShipMethod e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyShipMethod e)
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
        out.append("MyShipMethod");
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
