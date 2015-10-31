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

public abstract class MyProductBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaProduct Meta = MyMetaProduct.instance;
    public static final MyProductTools Tools = MyProductTools.instance;
    public static final MyProductValidator Validator = MyProductValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String statusCode;
    private String name;
    private String description;
    private KmMoney listPrice;
    private Boolean discountable;
    private Boolean taxable;
    private KmMoney cost;
    private Boolean requiresShip;
    private String shipInstruction;
    private String pickInstruction;
    private Integer networkPortsProduced;
    private Integer networkPortsConsumed;
    private Integer poePortsProduced;
    private Integer poePortsConsumed;
    private Integer vendorPartNumber;
    private Integer lockVersion;
    private MyProject project;
    private MyMasterProduct master;
    private MyProductCategory category;
    private MyPowerType powerType;
    private MyVendor vendor;
    private List<MyAttributeValue> attributeValues;

    //##################################################
    //# constructor
    //##################################################

    public MyProductBase()
    {
        super();
        setUid(newUid());
        setStatusCode(MyProductStatus.Draft.getCode());
        setDiscountable(true);
        setTaxable(true);
        setRequiresShip(true);
        setNetworkPortsProduced(0);
        setNetworkPortsConsumed(0);
        setPoePortsProduced(0);
        setPoePortsConsumed(0);
        setVendorPartNumber(0);
        attributeValues = new ArrayList<>();
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
    //# field (statusCode)
    //##################################################

    public String getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(String e)
    {
        checkReadOnly();
        e = Validator.getStatusCodeValidator().convertOnly(e);
        statusCode = e;
    }

    public void clearStatusCode()
    {
        setStatusCode(null);
    }

    public boolean hasStatusCode()
    {
        return Kmu.hasValue(getStatusCode());
    }

    public boolean hasStatusCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getStatusCode(), e);
    }

    public void truncateStatusCode()
    {
        truncateStatusCode(false);
    }

    public void truncateStatusCode(boolean ellipses)
    {
        statusCode = Kmu.truncate(statusCode, 1, ellipses);
    }

    public MyProductStatus getStatus()
    {
        return MyProductStatus.findCode(getStatusCode());
    }

    public void setStatus(MyProductStatus e)
    {
        if ( e == null )
            setStatusCode(null);
        else
            setStatusCode(e.getCode());
    }

    public boolean hasStatus()
    {
        return getStatus() != null;
    }

    public boolean hasStatus(MyProductStatus e)
    {
        return getStatus() == e;
    }

    public void setStatusDraft()
    {
        setStatus(MyProductStatus.Draft);
    }

    public boolean isStatusDraft()
    {
        return hasStatus(MyProductStatus.Draft);
    }

    public boolean isNotStatusDraft()
    {
        return !isStatusDraft();
    }

    public void setStatusPublished()
    {
        setStatus(MyProductStatus.Published);
    }

    public boolean isStatusPublished()
    {
        return hasStatus(MyProductStatus.Published);
    }

    public boolean isNotStatusPublished()
    {
        return !isStatusPublished();
    }

    public void setStatusCancelled()
    {
        setStatus(MyProductStatus.Cancelled);
    }

    public boolean isStatusCancelled()
    {
        return hasStatus(MyProductStatus.Cancelled);
    }

    public boolean isNotStatusCancelled()
    {
        return !isStatusCancelled();
    }

    public void setStatusArchived()
    {
        setStatus(MyProductStatus.Archived);
    }

    public boolean isStatusArchived()
    {
        return hasStatus(MyProductStatus.Archived);
    }

    public boolean isNotStatusArchived()
    {
        return !isStatusArchived();
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
    //# field (description)
    //##################################################

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String e)
    {
        checkReadOnly();
        e = Validator.getDescriptionValidator().convertOnly(e);
        description = e;
    }

    public void clearDescription()
    {
        setDescription(null);
    }

    public boolean hasDescription()
    {
        return Kmu.hasValue(getDescription());
    }

    public boolean hasDescription(String e)
    {
        return Kmu.isEqualIgnoreCase(getDescription(), e);
    }

    public void truncateDescription()
    {
        truncateDescription(false);
    }

    public void truncateDescription(boolean ellipses)
    {
        description = Kmu.truncate(description, 1000, ellipses);
    }

    //##################################################
    //# field (listPrice)
    //##################################################

    public KmMoney getListPrice()
    {
        return listPrice;
    }

    public void setListPrice(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getListPriceValidator().convertOnly(e);
        listPrice = e;
    }

    public void clearListPrice()
    {
        setListPrice(null);
    }

    public boolean hasListPrice()
    {
        return getListPrice() != null;
    }

    public boolean hasListPrice(KmMoney e)
    {
        return Kmu.isEqual(getListPrice(), e);
    }

    //##################################################
    //# field (discountable)
    //##################################################

    public Boolean getDiscountable()
    {
        return discountable;
    }

    public void setDiscountable(Boolean e)
    {
        checkReadOnly();
        e = Validator.getDiscountableValidator().convertOnly(e);
        discountable = e;
    }

    public void clearDiscountable()
    {
        setDiscountable(null);
    }

    public boolean hasDiscountable()
    {
        return getDiscountable() != null;
    }

    public boolean hasDiscountable(Boolean e)
    {
        return Kmu.isEqual(getDiscountable(), e);
    }

    public boolean isDiscountable()
    {
        if ( getDiscountable() == null )
            return false;
        return getDiscountable();
    }

    public boolean isNotDiscountable()
    {
        return !isDiscountable();
    }

    public boolean isDiscountable(Boolean b)
    {
        return Kmu.isEqual(getDiscountable(), b);
    }

    public void toggleDiscountable()
    {
        setDiscountable(!getDiscountable());
    }

    //##################################################
    //# field (taxable)
    //##################################################

    public Boolean getTaxable()
    {
        return taxable;
    }

    public void setTaxable(Boolean e)
    {
        checkReadOnly();
        e = Validator.getTaxableValidator().convertOnly(e);
        taxable = e;
    }

    public void clearTaxable()
    {
        setTaxable(null);
    }

    public boolean hasTaxable()
    {
        return getTaxable() != null;
    }

    public boolean hasTaxable(Boolean e)
    {
        return Kmu.isEqual(getTaxable(), e);
    }

    public boolean isTaxable()
    {
        if ( getTaxable() == null )
            return false;
        return getTaxable();
    }

    public boolean isNotTaxable()
    {
        return !isTaxable();
    }

    public boolean isTaxable(Boolean b)
    {
        return Kmu.isEqual(getTaxable(), b);
    }

    public void toggleTaxable()
    {
        setTaxable(!getTaxable());
    }

    //##################################################
    //# field (cost)
    //##################################################

    public KmMoney getCost()
    {
        return cost;
    }

    public void setCost(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getCostValidator().convertOnly(e);
        cost = e;
    }

    public void clearCost()
    {
        setCost(null);
    }

    public boolean hasCost()
    {
        return getCost() != null;
    }

    public boolean hasCost(KmMoney e)
    {
        return Kmu.isEqual(getCost(), e);
    }

    //##################################################
    //# field (requiresShip)
    //##################################################

    public Boolean getRequiresShip()
    {
        return requiresShip;
    }

    public void setRequiresShip(Boolean e)
    {
        checkReadOnly();
        e = Validator.getRequiresShipValidator().convertOnly(e);
        requiresShip = e;
    }

    public void clearRequiresShip()
    {
        setRequiresShip(null);
    }

    public boolean hasRequiresShip()
    {
        return getRequiresShip() != null;
    }

    public boolean hasRequiresShip(Boolean e)
    {
        return Kmu.isEqual(getRequiresShip(), e);
    }

    public boolean isRequiresShip()
    {
        if ( getRequiresShip() == null )
            return false;
        return getRequiresShip();
    }

    public boolean isNotRequiresShip()
    {
        return !isRequiresShip();
    }

    public boolean isRequiresShip(Boolean b)
    {
        return Kmu.isEqual(getRequiresShip(), b);
    }

    public void toggleRequiresShip()
    {
        setRequiresShip(!getRequiresShip());
    }

    //##################################################
    //# field (shipInstruction)
    //##################################################

    public String getShipInstruction()
    {
        return shipInstruction;
    }

    public void setShipInstruction(String e)
    {
        checkReadOnly();
        e = Validator.getShipInstructionValidator().convertOnly(e);
        shipInstruction = e;
    }

    public void clearShipInstruction()
    {
        setShipInstruction(null);
    }

    public boolean hasShipInstruction()
    {
        return Kmu.hasValue(getShipInstruction());
    }

    public boolean hasShipInstruction(String e)
    {
        return Kmu.isEqualIgnoreCase(getShipInstruction(), e);
    }

    public void truncateShipInstruction()
    {
        truncateShipInstruction(false);
    }

    public void truncateShipInstruction(boolean ellipses)
    {
        shipInstruction = Kmu.truncate(shipInstruction, 1000, ellipses);
    }

    //##################################################
    //# field (pickInstruction)
    //##################################################

    public String getPickInstruction()
    {
        return pickInstruction;
    }

    public void setPickInstruction(String e)
    {
        checkReadOnly();
        e = Validator.getPickInstructionValidator().convertOnly(e);
        pickInstruction = e;
    }

    public void clearPickInstruction()
    {
        setPickInstruction(null);
    }

    public boolean hasPickInstruction()
    {
        return Kmu.hasValue(getPickInstruction());
    }

    public boolean hasPickInstruction(String e)
    {
        return Kmu.isEqualIgnoreCase(getPickInstruction(), e);
    }

    public void truncatePickInstruction()
    {
        truncatePickInstruction(false);
    }

    public void truncatePickInstruction(boolean ellipses)
    {
        pickInstruction = Kmu.truncate(pickInstruction, 1000, ellipses);
    }

    //##################################################
    //# field (networkPortsProduced)
    //##################################################

    public Integer getNetworkPortsProduced()
    {
        return networkPortsProduced;
    }

    public void setNetworkPortsProduced(Integer e)
    {
        checkReadOnly();
        e = Validator.getNetworkPortsProducedValidator().convertOnly(e);
        networkPortsProduced = e;
    }

    public void clearNetworkPortsProduced()
    {
        setNetworkPortsProduced(null);
    }

    public boolean hasNetworkPortsProduced()
    {
        return getNetworkPortsProduced() != null;
    }

    public boolean hasNetworkPortsProduced(Integer e)
    {
        return Kmu.isEqual(getNetworkPortsProduced(), e);
    }

    //##################################################
    //# field (networkPortsConsumed)
    //##################################################

    public Integer getNetworkPortsConsumed()
    {
        return networkPortsConsumed;
    }

    public void setNetworkPortsConsumed(Integer e)
    {
        checkReadOnly();
        e = Validator.getNetworkPortsConsumedValidator().convertOnly(e);
        networkPortsConsumed = e;
    }

    public void clearNetworkPortsConsumed()
    {
        setNetworkPortsConsumed(null);
    }

    public boolean hasNetworkPortsConsumed()
    {
        return getNetworkPortsConsumed() != null;
    }

    public boolean hasNetworkPortsConsumed(Integer e)
    {
        return Kmu.isEqual(getNetworkPortsConsumed(), e);
    }

    //##################################################
    //# field (poePortsProduced)
    //##################################################

    public Integer getPoePortsProduced()
    {
        return poePortsProduced;
    }

    public void setPoePortsProduced(Integer e)
    {
        checkReadOnly();
        e = Validator.getPoePortsProducedValidator().convertOnly(e);
        poePortsProduced = e;
    }

    public void clearPoePortsProduced()
    {
        setPoePortsProduced(null);
    }

    public boolean hasPoePortsProduced()
    {
        return getPoePortsProduced() != null;
    }

    public boolean hasPoePortsProduced(Integer e)
    {
        return Kmu.isEqual(getPoePortsProduced(), e);
    }

    //##################################################
    //# field (poePortsConsumed)
    //##################################################

    public Integer getPoePortsConsumed()
    {
        return poePortsConsumed;
    }

    public void setPoePortsConsumed(Integer e)
    {
        checkReadOnly();
        e = Validator.getPoePortsConsumedValidator().convertOnly(e);
        poePortsConsumed = e;
    }

    public void clearPoePortsConsumed()
    {
        setPoePortsConsumed(null);
    }

    public boolean hasPoePortsConsumed()
    {
        return getPoePortsConsumed() != null;
    }

    public boolean hasPoePortsConsumed(Integer e)
    {
        return Kmu.isEqual(getPoePortsConsumed(), e);
    }

    //##################################################
    //# field (vendorPartNumber)
    //##################################################

    public Integer getVendorPartNumber()
    {
        return vendorPartNumber;
    }

    public void setVendorPartNumber(Integer e)
    {
        checkReadOnly();
        e = Validator.getVendorPartNumberValidator().convertOnly(e);
        vendorPartNumber = e;
    }

    public void clearVendorPartNumber()
    {
        setVendorPartNumber(null);
    }

    public boolean hasVendorPartNumber()
    {
        return getVendorPartNumber() != null;
    }

    public boolean hasVendorPartNumber(Integer e)
    {
        return Kmu.isEqual(getVendorPartNumber(), e);
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
    //# field (statusName)
    //##################################################

    public final String getStatusName()
    {
        return Kmu.getName(getStatus());
    }

    public boolean hasStatusName()
    {
        return Kmu.hasValue(getStatusName());
    }

    public boolean hasStatusName(String e)
    {
        return Kmu.isEqualIgnoreCase(getStatusName(), e);
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
    //# master
    //##################################################

    public MyMasterProduct getMaster()
    {
        return master;
    }

    public void setMaster(MyMasterProduct e)
    {
        checkReadOnly();
        master = e;
        updateProject();
    }

    public void _setMaster(MyMasterProduct e)
    {
        checkReadOnly();
        master = e;
    }

    public void clearMaster()
    {
        setMaster(null);
    }

    public boolean hasMaster()
    {
        return getMaster() != null;
    }

    public boolean hasMaster(MyMasterProduct e)
    {
        return Kmu.isEqual(getMaster(), e);
    }

    public String getPartNumber()
    {
        if ( hasMaster() )
            return getMaster().getPartNumber();
        return null;
    }

    public void setPartNumber(String e)
    {
        getMaster().setPartNumber(e);
    }

    public boolean hasPartNumber()
    {
        return hasMaster() && getMaster().hasPartNumber();
    }

    public boolean hasPartNumber(String e)
    {
        return hasMaster() && getMaster().hasPartNumber(e);
    }

    //##################################################
    //# category
    //##################################################

    public MyProductCategory getCategory()
    {
        return category;
    }

    public void setCategory(MyProductCategory e)
    {
        checkReadOnly();
        category = e;
    }

    public void _setCategory(MyProductCategory e)
    {
        checkReadOnly();
        category = e;
    }

    public void clearCategory()
    {
        setCategory(null);
    }

    public boolean hasCategory()
    {
        return getCategory() != null;
    }

    public boolean hasCategory(MyProductCategory e)
    {
        return Kmu.isEqual(getCategory(), e);
    }

    public String getCategoryName()
    {
        if ( hasCategory() )
            return getCategory().getName();
        return null;
    }

    public void setCategoryName(String e)
    {
        getCategory().setName(e);
    }

    public boolean hasCategoryName()
    {
        return hasCategory() && getCategory().hasName();
    }

    public boolean hasCategoryName(String e)
    {
        return hasCategory() && getCategory().hasName(e);
    }

    //##################################################
    //# powerType
    //##################################################

    public MyPowerType getPowerType()
    {
        return powerType;
    }

    public void setPowerType(MyPowerType e)
    {
        checkReadOnly();
        powerType = e;
    }

    public void _setPowerType(MyPowerType e)
    {
        checkReadOnly();
        powerType = e;
    }

    public void clearPowerType()
    {
        setPowerType(null);
    }

    public boolean hasPowerType()
    {
        return getPowerType() != null;
    }

    public boolean hasPowerType(MyPowerType e)
    {
        return Kmu.isEqual(getPowerType(), e);
    }

    //##################################################
    //# vendor
    //##################################################

    public MyVendor getVendor()
    {
        return vendor;
    }

    public void setVendor(MyVendor e)
    {
        checkReadOnly();
        vendor = e;
    }

    public void _setVendor(MyVendor e)
    {
        checkReadOnly();
        vendor = e;
    }

    public void clearVendor()
    {
        setVendor(null);
    }

    public boolean hasVendor()
    {
        return getVendor() != null;
    }

    public boolean hasVendor(MyVendor e)
    {
        return Kmu.isEqual(getVendor(), e);
    }


    //##################################################
    //# AttributeValues (collection)
    //##################################################

    public KmCollection<MyAttributeValue> getAttributeValues()
    {
        return new KmHibernateCollection<>(
            getBaseAttributeValues(),
            (MyProduct)this,
            MyAttributeValue.Meta.Product.getAdaptor());
    }

    public boolean hasAttributeValues()
    {
        return !getBaseAttributeValues().isEmpty();
    }

    public int getAttributeValueCount()
    {
        return getBaseAttributeValues().size();
    }

    public List<MyAttributeValue> getBaseAttributeValues()
    {
        return attributeValues;
    }

    public MyAttributeValue addAttributeValue()
    {
        MyAttributeValue e;
        e = new MyAttributeValue();
        getAttributeValues().add(e);
        return e;
    }

    public void addAttributeValue(MyAttributeValue e)
    {
        getAttributeValues().add(e);
    }

    public boolean removeAttributeValue(MyAttributeValue e)
    {
        return getAttributeValues().remove(e);
    }

    public boolean removeAttributeValueUid(String myUid)
    {
        MyAttributeValue e = findAttributeValueUid(myUid);
        if ( e == null )
            return false;

        return removeAttributeValue(e);
    }

    public MyAttributeValue findAttributeValueUid(String myUid)
    {
        for ( MyAttributeValue e : getBaseAttributeValues() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearAttributeValues()
    {
        getAttributeValues().clear();
    }

    //##################################################
    //# on change
    //##################################################

    protected abstract void updateProject();

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyProduct)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyProduct)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyProduct)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyProduct getCopy()
    {
        return (MyProduct)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        master = null;

        attributeValues = new ArrayList<>();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyProductBase) )
            return false;

        MyProductBase e = (MyProductBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyProduct e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyProduct e)
    {
        if ( !Kmu.isEqual(getStatusCode(), e.getStatusCode()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getDescription(), e.getDescription()) ) return false;
        if ( !Kmu.isEqual(getListPrice(), e.getListPrice()) ) return false;
        if ( !Kmu.isEqual(getDiscountable(), e.getDiscountable()) ) return false;
        if ( !Kmu.isEqual(getTaxable(), e.getTaxable()) ) return false;
        if ( !Kmu.isEqual(getCost(), e.getCost()) ) return false;
        if ( !Kmu.isEqual(getRequiresShip(), e.getRequiresShip()) ) return false;
        if ( !Kmu.isEqual(getShipInstruction(), e.getShipInstruction()) ) return false;
        if ( !Kmu.isEqual(getPickInstruction(), e.getPickInstruction()) ) return false;
        if ( !Kmu.isEqual(getNetworkPortsProduced(), e.getNetworkPortsProduced()) ) return false;
        if ( !Kmu.isEqual(getNetworkPortsConsumed(), e.getNetworkPortsConsumed()) ) return false;
        if ( !Kmu.isEqual(getPoePortsProduced(), e.getPoePortsProduced()) ) return false;
        if ( !Kmu.isEqual(getPoePortsConsumed(), e.getPoePortsConsumed()) ) return false;
        if ( !Kmu.isEqual(getVendorPartNumber(), e.getVendorPartNumber()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyProduct e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyProduct e)
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
        out.append("MyProduct");
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
        System.out.println("    StatusCode = " + statusCode);
        System.out.println("    Name = " + name);
        System.out.println("    Description = " + description);
        System.out.println("    ListPrice = " + listPrice);
        System.out.println("    Discountable = " + discountable);
        System.out.println("    Taxable = " + taxable);
        System.out.println("    Cost = " + cost);
        System.out.println("    RequiresShip = " + requiresShip);
        System.out.println("    ShipInstruction = " + shipInstruction);
        System.out.println("    PickInstruction = " + pickInstruction);
        System.out.println("    NetworkPortsProduced = " + networkPortsProduced);
        System.out.println("    NetworkPortsConsumed = " + networkPortsConsumed);
        System.out.println("    PoePortsProduced = " + poePortsProduced);
        System.out.println("    PoePortsConsumed = " + poePortsConsumed);
        System.out.println("    VendorPartNumber = " + vendorPartNumber);
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
