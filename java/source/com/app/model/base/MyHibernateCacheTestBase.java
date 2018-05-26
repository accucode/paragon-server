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
public abstract class MyHibernateCacheTestBase
    extends MyAbstractDaoDomain<MyHibernateCacheTest>
    implements KmUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaHibernateCacheTest Meta = MyMetaHibernateCacheTest.instance;
    public static final MyHibernateCacheTestTools Tools = MyHibernateCacheTestTools.instance;
    public static final MyHibernateCacheTestValidator Validator = MyHibernateCacheTestValidator.instance;
    public static final MyHibernateCacheTestFinder Finder = MyHibernateCacheTestFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String data;
    private String uid;
    private Integer lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTestBase()
    {
        super();
        setUid(newUid());
        setLockVersion(0);
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
    //# field (data)
    //##################################################

    public String getData()
    {
        return data;
    }

    public void setData(String e)
    {
        e = Validator.getDataValidator().convert(e);
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
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        e = Validator.getLockVersionValidator().convert(e);
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
    protected final MyHibernateCacheTestValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyHibernateCacheTest asSubclass()
    {
        return (MyHibernateCacheTest)this;
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
        uid = newUid();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyHibernateCacheTest getBasicCopy()
    {
        MyHibernateCacheTest e;
        e = new MyHibernateCacheTest();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyHibernateCacheTest e)
    {
        e.setData(getData());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyHibernateCacheTest e)
    {
        setData(e.getData());
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
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getData(), e.getData()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
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
        System.out.println("    Data = " + data);
        System.out.println("    Uid = " + uid);
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

    public void daoTouch()
    {
        setLockVersion(getLockVersion() + 1);
    }

}
