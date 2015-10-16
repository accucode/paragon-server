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

public abstract class MyHibernateCacheTestBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaHibernateCacheTest Meta = MyMetaHibernateCacheTest.instance;
    public static final MyHibernateCacheTestTools Tools = MyHibernateCacheTestTools.instance;
    public static final MyHibernateCacheTestValidator Validator = MyHibernateCacheTestValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String data;
    private Integer lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTestBase()
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
    //# field (data)
    //##################################################

    public String getData()
    {
        return data;
    }

    public void setData(String e)
    {
        checkReadOnly();
        e = Validator.getDataValidator().convertOnly(e);
        data = e;
    }

    public void clearData()
    {
        setData(null);
    }

    public boolean hasData()
    {
        return Kmu.hasValue(getData());
    }

    public boolean hasData(String e)
    {
        return Kmu.isEqualIgnoreCase(getData(), e);
    }

    public void truncateData()
    {
        truncateData(false);
    }

    public void truncateData(boolean ellipses)
    {
        data = Kmu.truncate(data, 1000, ellipses);
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyHibernateCacheTest)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyHibernateCacheTest)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyHibernateCacheTest)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyHibernateCacheTest getCopy()
    {
        return (MyHibernateCacheTest)super.getCopy();
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
        if ( !(o instanceof MyHibernateCacheTestBase) )
            return false;

        MyHibernateCacheTestBase e = (MyHibernateCacheTestBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyHibernateCacheTest e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyHibernateCacheTest e)
    {
        if ( !Kmu.isEqual(getData(), e.getData()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyHibernateCacheTest e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyHibernateCacheTest e)
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
        out.append("MyHibernateCacheTest");
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
        System.out.println("    Data = " + data);
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
