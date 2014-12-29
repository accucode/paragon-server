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
    private List<MyPowerType> powerTypes;
    private List<MyRegion> regions;
    private List<MyVendor> vendors;
    private List<MySkill> skills;
    private List<MyVisitType> visitTypes;
    private List<MyProduct> products;
    private List<MyCategory> categories;
    private List<MyShipCarrier> shipCarriers;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectBase()
    {
        super();
        setUid(newUid());
        members = new ArrayList<>();
        depots = new ArrayList<>();
        powerTypes = new ArrayList<>();
        regions = new ArrayList<>();
        vendors = new ArrayList<>();
        skills = new ArrayList<>();
        visitTypes = new ArrayList<>();
        products = new ArrayList<>();
        categories = new ArrayList<>();
        shipCarriers = new ArrayList<>();
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
    //# PowerTypes (collection)
    //##################################################

    public KmCollection<MyPowerType> getPowerTypes()
    {
        return new KmHibernateCollection<>(
            getBasePowerTypes(),
            (MyProject)this,
            MyPowerType.Meta.Project.getAdaptor());
    }

    public boolean hasPowerTypes()
    {
        return !getBasePowerTypes().isEmpty();
    }

    public int getPowerTypeCount()
    {
        return getBasePowerTypes().size();
    }

    public List<MyPowerType> getBasePowerTypes()
    {
        return powerTypes;
    }

    public MyPowerType addPowerType()
    {
        MyPowerType e;
        e = new MyPowerType();
        getPowerTypes().add(e);
        return e;
    }

    public void addPowerType(MyPowerType e)
    {
        getPowerTypes().add(e);
    }

    public boolean removePowerType(MyPowerType e)
    {
        return getPowerTypes().remove(e);
    }

    public boolean removePowerTypeUid(String myUid)
    {
        MyPowerType e = findPowerTypeUid(myUid);
        if ( e == null )
            return false;

        return removePowerType(e);
    }

    public MyPowerType findPowerTypeUid(String myUid)
    {
        for ( MyPowerType e : getBasePowerTypes() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearPowerTypes()
    {
        getPowerTypes().clear();
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
    //# VisitTypes (collection)
    //##################################################

    public KmCollection<MyVisitType> getVisitTypes()
    {
        return new KmHibernateCollection<>(
            getBaseVisitTypes(),
            (MyProject)this,
            MyVisitType.Meta.Project.getAdaptor());
    }

    public boolean hasVisitTypes()
    {
        return !getBaseVisitTypes().isEmpty();
    }

    public int getVisitTypeCount()
    {
        return getBaseVisitTypes().size();
    }

    public List<MyVisitType> getBaseVisitTypes()
    {
        return visitTypes;
    }

    public MyVisitType addVisitType()
    {
        MyVisitType e;
        e = new MyVisitType();
        getVisitTypes().add(e);
        return e;
    }

    public void addVisitType(MyVisitType e)
    {
        getVisitTypes().add(e);
    }

    public boolean removeVisitType(MyVisitType e)
    {
        return getVisitTypes().remove(e);
    }

    public boolean removeVisitTypeUid(String myUid)
    {
        MyVisitType e = findVisitTypeUid(myUid);
        if ( e == null )
            return false;

        return removeVisitType(e);
    }

    public MyVisitType findVisitTypeUid(String myUid)
    {
        for ( MyVisitType e : getBaseVisitTypes() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearVisitTypes()
    {
        getVisitTypes().clear();
    }

    //##################################################
    //# Products (collection)
    //##################################################

    public KmCollection<MyProduct> getProducts()
    {
        return new KmHibernateCollection<>(
            getBaseProducts(),
            (MyProject)this,
            MyProduct.Meta.Project.getAdaptor());
    }

    public boolean hasProducts()
    {
        return !getBaseProducts().isEmpty();
    }

    public int getProductCount()
    {
        return getBaseProducts().size();
    }

    public List<MyProduct> getBaseProducts()
    {
        return products;
    }

    public MyProduct addProduct()
    {
        MyProduct e;
        e = new MyProduct();
        getProducts().add(e);
        return e;
    }

    public void addProduct(MyProduct e)
    {
        getProducts().add(e);
    }

    public boolean removeProduct(MyProduct e)
    {
        return getProducts().remove(e);
    }

    public boolean removeProductUid(String myUid)
    {
        MyProduct e = findProductUid(myUid);
        if ( e == null )
            return false;

        return removeProduct(e);
    }

    public MyProduct findProductUid(String myUid)
    {
        for ( MyProduct e : getBaseProducts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearProducts()
    {
        getProducts().clear();
    }

    //##################################################
    //# Categories (collection)
    //##################################################

    public KmCollection<MyCategory> getCategories()
    {
        return new KmHibernateCollection<>(
            getBaseCategories(),
            (MyProject)this,
            MyCategory.Meta.Project.getAdaptor());
    }

    public boolean hasCategories()
    {
        return !getBaseCategories().isEmpty();
    }

    public int getCategoryCount()
    {
        return getBaseCategories().size();
    }

    public List<MyCategory> getBaseCategories()
    {
        return categories;
    }

    public MyCategory addCategory()
    {
        MyCategory e;
        e = new MyCategory();
        getCategories().add(e);
        return e;
    }

    public void addCategory(MyCategory e)
    {
        getCategories().add(e);
    }

    public boolean removeCategory(MyCategory e)
    {
        return getCategories().remove(e);
    }

    public boolean removeCategoryUid(String myUid)
    {
        MyCategory e = findCategoryUid(myUid);
        if ( e == null )
            return false;

        return removeCategory(e);
    }

    public MyCategory findCategoryUid(String myUid)
    {
        for ( MyCategory e : getBaseCategories() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearCategories()
    {
        getCategories().clear();
    }

    //##################################################
    //# ShipCarriers (collection)
    //##################################################

    public KmCollection<MyShipCarrier> getShipCarriers()
    {
        return new KmHibernateCollection<>(
            getBaseShipCarriers(),
            (MyProject)this,
            MyShipCarrier.Meta.Project.getAdaptor());
    }

    public boolean hasShipCarriers()
    {
        return !getBaseShipCarriers().isEmpty();
    }

    public int getShipCarrierCount()
    {
        return getBaseShipCarriers().size();
    }

    public List<MyShipCarrier> getBaseShipCarriers()
    {
        return shipCarriers;
    }

    public MyShipCarrier addShipCarrier()
    {
        MyShipCarrier e;
        e = new MyShipCarrier();
        getShipCarriers().add(e);
        return e;
    }

    public void addShipCarrier(MyShipCarrier e)
    {
        getShipCarriers().add(e);
    }

    public boolean removeShipCarrier(MyShipCarrier e)
    {
        return getShipCarriers().remove(e);
    }

    public boolean removeShipCarrierUid(String myUid)
    {
        MyShipCarrier e = findShipCarrierUid(myUid);
        if ( e == null )
            return false;

        return removeShipCarrier(e);
    }

    public MyShipCarrier findShipCarrierUid(String myUid)
    {
        for ( MyShipCarrier e : getBaseShipCarriers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearShipCarriers()
    {
        getShipCarriers().clear();
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

        List<MyPowerType> old_powerTypes = powerTypes;
        powerTypes = new ArrayList<>();
        for ( MyPowerType e : old_powerTypes )
            addPowerType(copy(e));

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

        List<MyVisitType> old_visitTypes = visitTypes;
        visitTypes = new ArrayList<>();
        for ( MyVisitType e : old_visitTypes )
            addVisitType(copy(e));

        List<MyProduct> old_products = products;
        products = new ArrayList<>();
        for ( MyProduct e : old_products )
            addProduct(copy(e));

        List<MyCategory> old_categories = categories;
        categories = new ArrayList<>();
        for ( MyCategory e : old_categories )
            addCategory(copy(e));

        List<MyShipCarrier> old_shipCarriers = shipCarriers;
        shipCarriers = new ArrayList<>();
        for ( MyShipCarrier e : old_shipCarriers )
            addShipCarrier(copy(e));
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
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("uid") )
            setUid(p.getString("uid"));

        if ( p.hasKey("name") )
            setName(p.getString("name"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasName() )
            p.setString("name", getName());

        if ( hasLockVersion() )
            p.setInteger("lockVersion", getLockVersion());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyProject");
        sb.append("(");
        sb.append("Uid=");
        sb.append(uid);
        sb.append(")");
        return sb.toString();
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
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(uid));
        return sb.toString();
    }

}
