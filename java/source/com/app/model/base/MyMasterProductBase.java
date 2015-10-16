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

public abstract class MyMasterProductBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaMasterProduct Meta = MyMetaMasterProduct.instance;
    public static final MyMasterProductTools Tools = MyMasterProductTools.instance;
    public static final MyMasterProductValidator Validator = MyMasterProductValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String partNumber;
    private Boolean active;
    private Integer lockVersion;
    private MyProject project;
    private MyProduct publishedVersion;
    private MyProduct draftVersion;
    private List<MyProduct> versions;

    //##################################################
    //# constructor
    //##################################################

    public MyMasterProductBase()
    {
        super();
        setUid(newUid());
        setActive(true);
        versions = new ArrayList<>();
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
    //# field (partNumber)
    //##################################################

    public String getPartNumber()
    {
        return partNumber;
    }

    public void setPartNumber(String e)
    {
        checkReadOnly();
        e = Validator.getPartNumberValidator().convertOnly(e);
        partNumber = e;
    }

    public void clearPartNumber()
    {
        setPartNumber(null);
    }

    public boolean hasPartNumber()
    {
        return Kmu.hasValue(getPartNumber());
    }

    public boolean hasPartNumber(String e)
    {
        return Kmu.isEqualIgnoreCase(getPartNumber(), e);
    }

    public void truncatePartNumber()
    {
        truncatePartNumber(false);
    }

    public void truncatePartNumber(boolean ellipses)
    {
        partNumber = Kmu.truncate(partNumber, 50, ellipses);
    }

    //##################################################
    //# field (active)
    //##################################################

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean e)
    {
        checkReadOnly();
        e = Validator.getActiveValidator().convertOnly(e);
        active = e;
    }

    public void clearActive()
    {
        setActive(null);
    }

    public boolean hasActive()
    {
        return getActive() != null;
    }

    public boolean hasActive(Boolean e)
    {
        return Kmu.isEqual(getActive(), e);
    }

    public boolean isActive()
    {
        if ( getActive() == null )
            return false;
        return getActive();
    }

    public boolean isNotActive()
    {
        return !isActive();
    }

    public boolean isActive(Boolean b)
    {
        return Kmu.isEqual(getActive(), b);
    }

    public void toggleActive()
    {
        setActive(!getActive());
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
    //# publishedVersion
    //##################################################

    public MyProduct getPublishedVersion()
    {
        return publishedVersion;
    }

    public void setPublishedVersion(MyProduct e)
    {
        checkReadOnly();
        publishedVersion = e;
    }

    public void _setPublishedVersion(MyProduct e)
    {
        checkReadOnly();
        publishedVersion = e;
    }

    public void clearPublishedVersion()
    {
        setPublishedVersion(null);
    }

    public boolean hasPublishedVersion()
    {
        return getPublishedVersion() != null;
    }

    public boolean hasPublishedVersion(MyProduct e)
    {
        return Kmu.isEqual(getPublishedVersion(), e);
    }

    //##################################################
    //# draftVersion
    //##################################################

    public MyProduct getDraftVersion()
    {
        return draftVersion;
    }

    public void setDraftVersion(MyProduct e)
    {
        checkReadOnly();
        draftVersion = e;
    }

    public void _setDraftVersion(MyProduct e)
    {
        checkReadOnly();
        draftVersion = e;
    }

    public void clearDraftVersion()
    {
        setDraftVersion(null);
    }

    public boolean hasDraftVersion()
    {
        return getDraftVersion() != null;
    }

    public boolean hasDraftVersion(MyProduct e)
    {
        return Kmu.isEqual(getDraftVersion(), e);
    }


    //##################################################
    //# Versions (collection)
    //##################################################

    public KmCollection<MyProduct> getVersions()
    {
        return new KmHibernateCollection<>(
            getBaseVersions(),
            (MyMasterProduct)this,
            MyProduct.Meta.Master.getAdaptor());
    }

    public boolean hasVersions()
    {
        return !getBaseVersions().isEmpty();
    }

    public int getVersionCount()
    {
        return getBaseVersions().size();
    }

    public List<MyProduct> getBaseVersions()
    {
        return versions;
    }

    public MyProduct addVersion()
    {
        MyProduct e;
        e = new MyProduct();
        getVersions().add(e);
        return e;
    }

    public void addVersion(MyProduct e)
    {
        getVersions().add(e);
    }

    public boolean removeVersion(MyProduct e)
    {
        return getVersions().remove(e);
    }

    public boolean removeVersionUid(String myUid)
    {
        MyProduct e = findVersionUid(myUid);
        if ( e == null )
            return false;

        return removeVersion(e);
    }

    public MyProduct findVersionUid(String myUid)
    {
        for ( MyProduct e : getBaseVersions() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearVersions()
    {
        getVersions().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyMasterProduct)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyMasterProduct)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyMasterProduct)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyMasterProduct getCopy()
    {
        return (MyMasterProduct)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;

        List<MyProduct> old_versions = versions;
        versions = new ArrayList<>();
        for ( MyProduct e : old_versions )
            addVersion(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyMasterProductBase) )
            return false;

        MyMasterProductBase e = (MyMasterProductBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyMasterProduct e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyMasterProduct e)
    {
        if ( !Kmu.isEqual(getPartNumber(), e.getPartNumber()) ) return false;
        if ( !Kmu.isEqual(getActive(), e.getActive()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyMasterProduct e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyMasterProduct e)
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
        out.append("MyMasterProduct");
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
        System.out.println("    PartNumber = " + partNumber);
        System.out.println("    Active = " + active);
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
