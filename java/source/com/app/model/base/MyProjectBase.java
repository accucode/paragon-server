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

public abstract class MyProjectBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaProject Meta = MyMetaProject.instance;
    public static final MyProjectTools Tools = MyProjectTools.instance;
    public static final MyProjectValidator Validator = MyProjectValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Integer lockVersion;
    private List<MyMember> members;
    private List<MyDepot> depots;
    private List<MyRegion> regions;
    private List<MyVendor> vendors;
    private List<MySkill> skills;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectBase()
    {
        super();
        setUid(newUid());
        members = new ArrayList<>();
        depots = new ArrayList<>();
        regions = new ArrayList<>();
        vendors = new ArrayList<>();
        skills = new ArrayList<>();
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
    //# Members (collection)
    //##################################################

    public KmCollection<MyMember> getMembers()
    {
        return new KmHibernateCollection<>(
            getBaseMembers(),
            (MyProject)this,
            MyMember.Meta.Project.getAdaptor());
    }

    public boolean hasMembers()
    {
        return !getBaseMembers().isEmpty();
    }

    public int getMemberCount()
    {
        return getBaseMembers().size();
    }

    public List<MyMember> getBaseMembers()
    {
        return members;
    }

    public MyMember addMember()
    {
        MyMember e;
        e = new MyMember();
        getMembers().add(e);
        return e;
    }

    public void addMember(MyMember e)
    {
        getMembers().add(e);
    }

    public boolean removeMember(MyMember e)
    {
        return getMembers().remove(e);
    }

    public boolean removeMemberUid(String myUid)
    {
        MyMember e = findMemberUid(myUid);
        if ( e == null )
            return false;

        return removeMember(e);
    }

    public MyMember findMemberUid(String myUid)
    {
        for ( MyMember e : getBaseMembers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearMembers()
    {
        getMembers().clear();
    }

    //##################################################
    //# Depots (collection)
    //##################################################

    public KmCollection<MyDepot> getDepots()
    {
        return new KmHibernateCollection<>(
            getBaseDepots(),
            (MyProject)this,
            MyDepot.Meta.Project.getAdaptor());
    }

    public boolean hasDepots()
    {
        return !getBaseDepots().isEmpty();
    }

    public int getDepotCount()
    {
        return getBaseDepots().size();
    }

    public List<MyDepot> getBaseDepots()
    {
        return depots;
    }

    public MyDepot addDepot()
    {
        MyDepot e;
        e = new MyDepot();
        getDepots().add(e);
        return e;
    }

    public void addDepot(MyDepot e)
    {
        getDepots().add(e);
    }

    public boolean removeDepot(MyDepot e)
    {
        return getDepots().remove(e);
    }

    public boolean removeDepotUid(String myUid)
    {
        MyDepot e = findDepotUid(myUid);
        if ( e == null )
            return false;

        return removeDepot(e);
    }

    public MyDepot findDepotUid(String myUid)
    {
        for ( MyDepot e : getBaseDepots() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearDepots()
    {
        getDepots().clear();
    }

    //##################################################
    //# Regions (collection)
    //##################################################

    public KmCollection<MyRegion> getRegions()
    {
        return new KmHibernateCollection<>(
            getBaseRegions(),
            (MyProject)this,
            MyRegion.Meta.Project.getAdaptor());
    }

    public boolean hasRegions()
    {
        return !getBaseRegions().isEmpty();
    }

    public int getRegionCount()
    {
        return getBaseRegions().size();
    }

    public List<MyRegion> getBaseRegions()
    {
        return regions;
    }

    public MyRegion addRegion()
    {
        MyRegion e;
        e = new MyRegion();
        getRegions().add(e);
        return e;
    }

    public void addRegion(MyRegion e)
    {
        getRegions().add(e);
    }

    public boolean removeRegion(MyRegion e)
    {
        return getRegions().remove(e);
    }

    public boolean removeRegionUid(String myUid)
    {
        MyRegion e = findRegionUid(myUid);
        if ( e == null )
            return false;

        return removeRegion(e);
    }

    public MyRegion findRegionUid(String myUid)
    {
        for ( MyRegion e : getBaseRegions() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearRegions()
    {
        getRegions().clear();
    }

    //##################################################
    //# Vendors (collection)
    //##################################################

    public KmCollection<MyVendor> getVendors()
    {
        return new KmHibernateCollection<>(
            getBaseVendors(),
            (MyProject)this,
            MyVendor.Meta.Project.getAdaptor());
    }

    public boolean hasVendors()
    {
        return !getBaseVendors().isEmpty();
    }

    public int getVendorCount()
    {
        return getBaseVendors().size();
    }

    public List<MyVendor> getBaseVendors()
    {
        return vendors;
    }

    public MyVendor addVendor()
    {
        MyVendor e;
        e = new MyVendor();
        getVendors().add(e);
        return e;
    }

    public void addVendor(MyVendor e)
    {
        getVendors().add(e);
    }

    public boolean removeVendor(MyVendor e)
    {
        return getVendors().remove(e);
    }

    public boolean removeVendorUid(String myUid)
    {
        MyVendor e = findVendorUid(myUid);
        if ( e == null )
            return false;

        return removeVendor(e);
    }

    public MyVendor findVendorUid(String myUid)
    {
        for ( MyVendor e : getBaseVendors() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearVendors()
    {
        getVendors().clear();
    }

    //##################################################
    //# Skills (collection)
    //##################################################

    public KmCollection<MySkill> getSkills()
    {
        return new KmHibernateCollection<>(
            getBaseSkills(),
            (MyProject)this,
            MySkill.Meta.Project.getAdaptor());
    }

    public boolean hasSkills()
    {
        return !getBaseSkills().isEmpty();
    }

    public int getSkillCount()
    {
        return getBaseSkills().size();
    }

    public List<MySkill> getBaseSkills()
    {
        return skills;
    }

    public MySkill addSkill()
    {
        MySkill e;
        e = new MySkill();
        getSkills().add(e);
        return e;
    }

    public void addSkill(MySkill e)
    {
        getSkills().add(e);
    }

    public boolean removeSkill(MySkill e)
    {
        return getSkills().remove(e);
    }

    public boolean removeSkillUid(String myUid)
    {
        MySkill e = findSkillUid(myUid);
        if ( e == null )
            return false;

        return removeSkill(e);
    }

    public MySkill findSkillUid(String myUid)
    {
        for ( MySkill e : getBaseSkills() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearSkills()
    {
        getSkills().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyProject)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyProject)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyProject)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyProject getCopy()
    {
        return (MyProject)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;

        List<MyMember> old_members = members;
        members = new ArrayList<>();
        for ( MyMember e : old_members )
            addMember(copy(e));

        List<MyDepot> old_depots = depots;
        depots = new ArrayList<>();
        for ( MyDepot e : old_depots )
            addDepot(copy(e));

        List<MyRegion> old_regions = regions;
        regions = new ArrayList<>();
        for ( MyRegion e : old_regions )
            addRegion(copy(e));

        List<MyVendor> old_vendors = vendors;
        vendors = new ArrayList<>();
        for ( MyVendor e : old_vendors )
            addVendor(copy(e));

        List<MySkill> old_skills = skills;
        skills = new ArrayList<>();
        for ( MySkill e : old_skills )
            addSkill(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyProjectBase) )
            return false;

        MyProjectBase e = (MyProjectBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyProject e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyProject e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyProject e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyProject e)
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
        out.append("MyProject");
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
