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
    private String orderNumberPrefix;
    private Integer lockVersion;
    private List<MyMember> members;
    private List<MyDepot> depots;
    private List<MyPowerType> powerTypes;
    private List<MyRegion> regions;
    private List<MyVendor> vendors;
    private List<MySkill> skills;
    private List<MyVisitType> visitTypes;
    private List<MyAttentionGroup> attentionGroups;
    private List<MyMasterProduct> masterProducts;
    private List<MyProductCategory> productCategories;
    private List<MyShipCarrier> shipCarriers;
    private List<MyCustomer> customers;
    private List<MyCustomerTier> customerTiers;
    private List<MyShipAccount> shipAccounts;

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
        attentionGroups = new ArrayList<>();
        masterProducts = new ArrayList<>();
        productCategories = new ArrayList<>();
        shipCarriers = new ArrayList<>();
        customers = new ArrayList<>();
        customerTiers = new ArrayList<>();
        shipAccounts = new ArrayList<>();
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
    //# field (orderNumberPrefix)
    //##################################################

    public String getOrderNumberPrefix()
    {
        return orderNumberPrefix;
    }

    public void setOrderNumberPrefix(String e)
    {
        checkReadOnly();
        e = Validator.getOrderNumberPrefixValidator().convertOnly(e);
        orderNumberPrefix = e;
    }

    public void clearOrderNumberPrefix()
    {
        setOrderNumberPrefix(null);
    }

    public boolean hasOrderNumberPrefix()
    {
        return Kmu.hasValue(getOrderNumberPrefix());
    }

    public boolean hasOrderNumberPrefix(String e)
    {
        return Kmu.isEqualIgnoreCase(getOrderNumberPrefix(), e);
    }

    public void truncateOrderNumberPrefix()
    {
        truncateOrderNumberPrefix(false);
    }

    public void truncateOrderNumberPrefix(boolean ellipses)
    {
        orderNumberPrefix = Kmu.truncate(orderNumberPrefix, 5, ellipses);
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
    //# AttentionGroups (collection)
    //##################################################

    public KmCollection<MyAttentionGroup> getAttentionGroups()
    {
        return new KmHibernateCollection<>(
            getBaseAttentionGroups(),
            (MyProject)this,
            MyAttentionGroup.Meta.Project.getAdaptor());
    }

    public boolean hasAttentionGroups()
    {
        return !getBaseAttentionGroups().isEmpty();
    }

    public int getAttentionGroupCount()
    {
        return getBaseAttentionGroups().size();
    }

    public List<MyAttentionGroup> getBaseAttentionGroups()
    {
        return attentionGroups;
    }

    public MyAttentionGroup addAttentionGroup()
    {
        MyAttentionGroup e;
        e = new MyAttentionGroup();
        getAttentionGroups().add(e);
        return e;
    }

    public void addAttentionGroup(MyAttentionGroup e)
    {
        getAttentionGroups().add(e);
    }

    public boolean removeAttentionGroup(MyAttentionGroup e)
    {
        return getAttentionGroups().remove(e);
    }

    public boolean removeAttentionGroupUid(String myUid)
    {
        MyAttentionGroup e = findAttentionGroupUid(myUid);
        if ( e == null )
            return false;

        return removeAttentionGroup(e);
    }

    public MyAttentionGroup findAttentionGroupUid(String myUid)
    {
        for ( MyAttentionGroup e : getBaseAttentionGroups() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearAttentionGroups()
    {
        getAttentionGroups().clear();
    }

    //##################################################
    //# MasterProducts (collection)
    //##################################################

    public KmCollection<MyMasterProduct> getMasterProducts()
    {
        return new KmHibernateCollection<>(
            getBaseMasterProducts(),
            (MyProject)this,
            MyMasterProduct.Meta.Project.getAdaptor());
    }

    public boolean hasMasterProducts()
    {
        return !getBaseMasterProducts().isEmpty();
    }

    public int getMasterProductCount()
    {
        return getBaseMasterProducts().size();
    }

    public List<MyMasterProduct> getBaseMasterProducts()
    {
        return masterProducts;
    }

    public MyMasterProduct addMasterProduct()
    {
        MyMasterProduct e;
        e = new MyMasterProduct();
        getMasterProducts().add(e);
        return e;
    }

    public void addMasterProduct(MyMasterProduct e)
    {
        getMasterProducts().add(e);
    }

    public boolean removeMasterProduct(MyMasterProduct e)
    {
        return getMasterProducts().remove(e);
    }

    public boolean removeMasterProductUid(String myUid)
    {
        MyMasterProduct e = findMasterProductUid(myUid);
        if ( e == null )
            return false;

        return removeMasterProduct(e);
    }

    public MyMasterProduct findMasterProductUid(String myUid)
    {
        for ( MyMasterProduct e : getBaseMasterProducts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearMasterProducts()
    {
        getMasterProducts().clear();
    }

    //##################################################
    //# ProductCategories (collection)
    //##################################################

    public KmCollection<MyProductCategory> getProductCategories()
    {
        return new KmHibernateCollection<>(
            getBaseProductCategories(),
            (MyProject)this,
            MyProductCategory.Meta.Project.getAdaptor());
    }

    public boolean hasProductCategories()
    {
        return !getBaseProductCategories().isEmpty();
    }

    public int getProductCategoryCount()
    {
        return getBaseProductCategories().size();
    }

    public List<MyProductCategory> getBaseProductCategories()
    {
        return productCategories;
    }

    public MyProductCategory addProductCategory()
    {
        MyProductCategory e;
        e = new MyProductCategory();
        getProductCategories().add(e);
        return e;
    }

    public void addProductCategory(MyProductCategory e)
    {
        getProductCategories().add(e);
    }

    public boolean removeProductCategory(MyProductCategory e)
    {
        return getProductCategories().remove(e);
    }

    public boolean removeProductCategoryUid(String myUid)
    {
        MyProductCategory e = findProductCategoryUid(myUid);
        if ( e == null )
            return false;

        return removeProductCategory(e);
    }

    public MyProductCategory findProductCategoryUid(String myUid)
    {
        for ( MyProductCategory e : getBaseProductCategories() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearProductCategories()
    {
        getProductCategories().clear();
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
    //# Customers (collection)
    //##################################################

    public KmCollection<MyCustomer> getCustomers()
    {
        return new KmHibernateCollection<>(
            getBaseCustomers(),
            (MyProject)this,
            MyCustomer.Meta.Project.getAdaptor());
    }

    public boolean hasCustomers()
    {
        return !getBaseCustomers().isEmpty();
    }

    public int getCustomerCount()
    {
        return getBaseCustomers().size();
    }

    public List<MyCustomer> getBaseCustomers()
    {
        return customers;
    }

    public MyCustomer addCustomer()
    {
        MyCustomer e;
        e = new MyCustomer();
        getCustomers().add(e);
        return e;
    }

    public void addCustomer(MyCustomer e)
    {
        getCustomers().add(e);
    }

    public boolean removeCustomer(MyCustomer e)
    {
        return getCustomers().remove(e);
    }

    public boolean removeCustomerUid(String myUid)
    {
        MyCustomer e = findCustomerUid(myUid);
        if ( e == null )
            return false;

        return removeCustomer(e);
    }

    public MyCustomer findCustomerUid(String myUid)
    {
        for ( MyCustomer e : getBaseCustomers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearCustomers()
    {
        getCustomers().clear();
    }

    //##################################################
    //# CustomerTiers (collection)
    //##################################################

    public KmCollection<MyCustomerTier> getCustomerTiers()
    {
        return new KmHibernateCollection<>(
            getBaseCustomerTiers(),
            (MyProject)this,
            MyCustomerTier.Meta.Project.getAdaptor());
    }

    public boolean hasCustomerTiers()
    {
        return !getBaseCustomerTiers().isEmpty();
    }

    public int getCustomerTierCount()
    {
        return getBaseCustomerTiers().size();
    }

    public List<MyCustomerTier> getBaseCustomerTiers()
    {
        return customerTiers;
    }

    public MyCustomerTier addCustomerTier()
    {
        MyCustomerTier e;
        e = new MyCustomerTier();
        getCustomerTiers().add(e);
        return e;
    }

    public void addCustomerTier(MyCustomerTier e)
    {
        getCustomerTiers().add(e);
    }

    public boolean removeCustomerTier(MyCustomerTier e)
    {
        return getCustomerTiers().remove(e);
    }

    public boolean removeCustomerTierUid(String myUid)
    {
        MyCustomerTier e = findCustomerTierUid(myUid);
        if ( e == null )
            return false;

        return removeCustomerTier(e);
    }

    public MyCustomerTier findCustomerTierUid(String myUid)
    {
        for ( MyCustomerTier e : getBaseCustomerTiers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearCustomerTiers()
    {
        getCustomerTiers().clear();
    }

    //##################################################
    //# ShipAccounts (collection)
    //##################################################

    public KmCollection<MyShipAccount> getShipAccounts()
    {
        return new KmHibernateCollection<>(
            getBaseShipAccounts(),
            (MyProject)this,
            MyShipAccount.Meta.Project.getAdaptor());
    }

    public boolean hasShipAccounts()
    {
        return !getBaseShipAccounts().isEmpty();
    }

    public int getShipAccountCount()
    {
        return getBaseShipAccounts().size();
    }

    public List<MyShipAccount> getBaseShipAccounts()
    {
        return shipAccounts;
    }

    public MyShipAccount addShipAccount()
    {
        MyShipAccount e;
        e = new MyShipAccount();
        getShipAccounts().add(e);
        return e;
    }

    public void addShipAccount(MyShipAccount e)
    {
        getShipAccounts().add(e);
    }

    public boolean removeShipAccount(MyShipAccount e)
    {
        return getShipAccounts().remove(e);
    }

    public boolean removeShipAccountUid(String myUid)
    {
        MyShipAccount e = findShipAccountUid(myUid);
        if ( e == null )
            return false;

        return removeShipAccount(e);
    }

    public MyShipAccount findShipAccountUid(String myUid)
    {
        for ( MyShipAccount e : getBaseShipAccounts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearShipAccounts()
    {
        getShipAccounts().clear();
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

        List<MyAttentionGroup> old_attentionGroups = attentionGroups;
        attentionGroups = new ArrayList<>();
        for ( MyAttentionGroup e : old_attentionGroups )
            addAttentionGroup(copy(e));

        List<MyMasterProduct> old_masterProducts = masterProducts;
        masterProducts = new ArrayList<>();
        for ( MyMasterProduct e : old_masterProducts )
            addMasterProduct(copy(e));

        List<MyProductCategory> old_productCategories = productCategories;
        productCategories = new ArrayList<>();
        for ( MyProductCategory e : old_productCategories )
            addProductCategory(copy(e));

        List<MyShipCarrier> old_shipCarriers = shipCarriers;
        shipCarriers = new ArrayList<>();
        for ( MyShipCarrier e : old_shipCarriers )
            addShipCarrier(copy(e));

        List<MyCustomer> old_customers = customers;
        customers = new ArrayList<>();
        for ( MyCustomer e : old_customers )
            addCustomer(copy(e));

        List<MyCustomerTier> old_customerTiers = customerTiers;
        customerTiers = new ArrayList<>();
        for ( MyCustomerTier e : old_customerTiers )
            addCustomerTier(copy(e));

        List<MyShipAccount> old_shipAccounts = shipAccounts;
        shipAccounts = new ArrayList<>();
        for ( MyShipAccount e : old_shipAccounts )
            addShipAccount(copy(e));
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
        if ( !Kmu.isEqual(getOrderNumberPrefix(), e.getOrderNumberPrefix()) ) return false;
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
        System.out.println("    OrderNumberPrefix = " + orderNumberPrefix);
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
