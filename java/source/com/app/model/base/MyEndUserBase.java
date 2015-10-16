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

public abstract class MyEndUserBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaEndUser Meta = MyMetaEndUser.instance;
    public static final MyEndUserTools Tools = MyEndUserTools.instance;
    public static final MyEndUserValidator Validator = MyEndUserValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Integer lockVersion;
    private MyCustomer customer;
    private List<MyEndUserSite> sites;

    //##################################################
    //# constructor
    //##################################################

    public MyEndUserBase()
    {
        super();
        setUid(newUid());
        sites = new ArrayList<>();
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
    //# customer
    //##################################################

    public MyCustomer getCustomer()
    {
        return customer;
    }

    public void setCustomer(MyCustomer e)
    {
        checkReadOnly();
        customer = e;
    }

    public void _setCustomer(MyCustomer e)
    {
        checkReadOnly();
        customer = e;
    }

    public void clearCustomer()
    {
        setCustomer(null);
    }

    public boolean hasCustomer()
    {
        return getCustomer() != null;
    }

    public boolean hasCustomer(MyCustomer e)
    {
        return Kmu.isEqual(getCustomer(), e);
    }


    //##################################################
    //# Sites (collection)
    //##################################################

    public KmCollection<MyEndUserSite> getSites()
    {
        return new KmHibernateCollection<>(
            getBaseSites(),
            (MyEndUser)this,
            MyEndUserSite.Meta.EndUser.getAdaptor());
    }

    public boolean hasSites()
    {
        return !getBaseSites().isEmpty();
    }

    public int getSiteCount()
    {
        return getBaseSites().size();
    }

    public List<MyEndUserSite> getBaseSites()
    {
        return sites;
    }

    public MyEndUserSite addSite()
    {
        MyEndUserSite e;
        e = new MyEndUserSite();
        getSites().add(e);
        return e;
    }

    public void addSite(MyEndUserSite e)
    {
        getSites().add(e);
    }

    public boolean removeSite(MyEndUserSite e)
    {
        return getSites().remove(e);
    }

    public boolean removeSiteUid(String myUid)
    {
        MyEndUserSite e = findSiteUid(myUid);
        if ( e == null )
            return false;

        return removeSite(e);
    }

    public MyEndUserSite findSiteUid(String myUid)
    {
        for ( MyEndUserSite e : getBaseSites() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearSites()
    {
        getSites().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyEndUser)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyEndUser)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyEndUser)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyEndUser getCopy()
    {
        return (MyEndUser)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        customer = null;

        List<MyEndUserSite> old_sites = sites;
        sites = new ArrayList<>();
        for ( MyEndUserSite e : old_sites )
            addSite(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyEndUserBase) )
            return false;

        MyEndUserBase e = (MyEndUserBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyEndUser e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyEndUser e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyEndUser e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyEndUser e)
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
        out.append("MyEndUser");
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
