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

public abstract class MySalesOrderLineBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSalesOrderLine Meta = MyMetaSalesOrderLine.instance;
    public static final MySalesOrderLineTools Tools = MySalesOrderLineTools.instance;
    public static final MySalesOrderLineValidator Validator = MySalesOrderLineValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmMoney listPrice;
    private KmMoney unitPrice;
    private Integer orderedQuantity;
    private Integer fulfilledQuantity;
    private KmMoney extendedPrice;
    private KmMoney priceAdjustment;
    private KmMoney adjustedPrice;
    private KmMoney tax;
    private KmMoney totalPrice;
    private Integer lockVersion;
    private MySalesOrder salesOrder;
    private MyProduct product;
    private List<MyAttributeValue> attributeValues;

    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderLineBase()
    {
        super();
        setUid(newUid());
        setOrderedQuantity(1);
        setFulfilledQuantity(0);
        setPriceAdjustment(KmMoney.ZERO);
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
    //# field (unitPrice)
    //##################################################

    public KmMoney getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getUnitPriceValidator().convertOnly(e);
        unitPrice = e;
    }

    public void clearUnitPrice()
    {
        setUnitPrice(null);
    }

    public boolean hasUnitPrice()
    {
        return getUnitPrice() != null;
    }

    public boolean hasUnitPrice(KmMoney e)
    {
        return Kmu.isEqual(getUnitPrice(), e);
    }

    //##################################################
    //# field (orderedQuantity)
    //##################################################

    public Integer getOrderedQuantity()
    {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Integer e)
    {
        checkReadOnly();
        e = Validator.getOrderedQuantityValidator().convertOnly(e);
        orderedQuantity = e;
    }

    public void clearOrderedQuantity()
    {
        setOrderedQuantity(null);
    }

    public boolean hasOrderedQuantity()
    {
        return getOrderedQuantity() != null;
    }

    public boolean hasOrderedQuantity(Integer e)
    {
        return Kmu.isEqual(getOrderedQuantity(), e);
    }

    //##################################################
    //# field (fulfilledQuantity)
    //##################################################

    public Integer getFulfilledQuantity()
    {
        return fulfilledQuantity;
    }

    public void setFulfilledQuantity(Integer e)
    {
        checkReadOnly();
        e = Validator.getFulfilledQuantityValidator().convertOnly(e);
        fulfilledQuantity = e;
    }

    public void clearFulfilledQuantity()
    {
        setFulfilledQuantity(null);
    }

    public boolean hasFulfilledQuantity()
    {
        return getFulfilledQuantity() != null;
    }

    public boolean hasFulfilledQuantity(Integer e)
    {
        return Kmu.isEqual(getFulfilledQuantity(), e);
    }

    //##################################################
    //# field (extendedPrice)
    //##################################################

    public KmMoney getExtendedPrice()
    {
        return extendedPrice;
    }

    public void setExtendedPrice(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getExtendedPriceValidator().convertOnly(e);
        extendedPrice = e;
    }

    public void clearExtendedPrice()
    {
        setExtendedPrice(null);
    }

    public boolean hasExtendedPrice()
    {
        return getExtendedPrice() != null;
    }

    public boolean hasExtendedPrice(KmMoney e)
    {
        return Kmu.isEqual(getExtendedPrice(), e);
    }

    //##################################################
    //# field (priceAdjustment)
    //##################################################

    public KmMoney getPriceAdjustment()
    {
        return priceAdjustment;
    }

    public void setPriceAdjustment(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getPriceAdjustmentValidator().convertOnly(e);
        priceAdjustment = e;
    }

    public void clearPriceAdjustment()
    {
        setPriceAdjustment(null);
    }

    public boolean hasPriceAdjustment()
    {
        return getPriceAdjustment() != null;
    }

    public boolean hasPriceAdjustment(KmMoney e)
    {
        return Kmu.isEqual(getPriceAdjustment(), e);
    }

    //##################################################
    //# field (adjustedPrice)
    //##################################################

    public KmMoney getAdjustedPrice()
    {
        return adjustedPrice;
    }

    public void setAdjustedPrice(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getAdjustedPriceValidator().convertOnly(e);
        adjustedPrice = e;
    }

    public void clearAdjustedPrice()
    {
        setAdjustedPrice(null);
    }

    public boolean hasAdjustedPrice()
    {
        return getAdjustedPrice() != null;
    }

    public boolean hasAdjustedPrice(KmMoney e)
    {
        return Kmu.isEqual(getAdjustedPrice(), e);
    }

    //##################################################
    //# field (tax)
    //##################################################

    public KmMoney getTax()
    {
        return tax;
    }

    public void setTax(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getTaxValidator().convertOnly(e);
        tax = e;
    }

    public void clearTax()
    {
        setTax(null);
    }

    public boolean hasTax()
    {
        return getTax() != null;
    }

    public boolean hasTax(KmMoney e)
    {
        return Kmu.isEqual(getTax(), e);
    }

    //##################################################
    //# field (totalPrice)
    //##################################################

    public KmMoney getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getTotalPriceValidator().convertOnly(e);
        totalPrice = e;
    }

    public void clearTotalPrice()
    {
        setTotalPrice(null);
    }

    public boolean hasTotalPrice()
    {
        return getTotalPrice() != null;
    }

    public boolean hasTotalPrice(KmMoney e)
    {
        return Kmu.isEqual(getTotalPrice(), e);
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
    //# salesOrder
    //##################################################

    public MySalesOrder getSalesOrder()
    {
        return salesOrder;
    }

    public void setSalesOrder(MySalesOrder e)
    {
        checkReadOnly();
        salesOrder = e;
    }

    public void _setSalesOrder(MySalesOrder e)
    {
        checkReadOnly();
        salesOrder = e;
    }

    public void clearSalesOrder()
    {
        setSalesOrder(null);
    }

    public boolean hasSalesOrder()
    {
        return getSalesOrder() != null;
    }

    public boolean hasSalesOrder(MySalesOrder e)
    {
        return Kmu.isEqual(getSalesOrder(), e);
    }

    //##################################################
    //# product
    //##################################################

    public MyProduct getProduct()
    {
        return product;
    }

    public void setProduct(MyProduct e)
    {
        checkReadOnly();
        product = e;
    }

    public void _setProduct(MyProduct e)
    {
        checkReadOnly();
        product = e;
    }

    public void clearProduct()
    {
        setProduct(null);
    }

    public boolean hasProduct()
    {
        return getProduct() != null;
    }

    public boolean hasProduct(MyProduct e)
    {
        return Kmu.isEqual(getProduct(), e);
    }


    //##################################################
    //# AttributeValues (collection)
    //##################################################

    public KmCollection<MyAttributeValue> getAttributeValues()
    {
        return new KmHibernateCollection<>(
            getBaseAttributeValues(),
            (MySalesOrderLine)this,
            MyAttributeValue.Meta.SalesOrderLine.getAdaptor());
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MySalesOrderLine)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MySalesOrderLine)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MySalesOrderLine)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MySalesOrderLine getCopy()
    {
        return (MySalesOrderLine)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        salesOrder = null;

        attributeValues = new ArrayList<>();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MySalesOrderLineBase) )
            return false;

        MySalesOrderLineBase e = (MySalesOrderLineBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MySalesOrderLine e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MySalesOrderLine e)
    {
        if ( !Kmu.isEqual(getListPrice(), e.getListPrice()) ) return false;
        if ( !Kmu.isEqual(getUnitPrice(), e.getUnitPrice()) ) return false;
        if ( !Kmu.isEqual(getOrderedQuantity(), e.getOrderedQuantity()) ) return false;
        if ( !Kmu.isEqual(getFulfilledQuantity(), e.getFulfilledQuantity()) ) return false;
        if ( !Kmu.isEqual(getExtendedPrice(), e.getExtendedPrice()) ) return false;
        if ( !Kmu.isEqual(getPriceAdjustment(), e.getPriceAdjustment()) ) return false;
        if ( !Kmu.isEqual(getAdjustedPrice(), e.getAdjustedPrice()) ) return false;
        if ( !Kmu.isEqual(getTax(), e.getTax()) ) return false;
        if ( !Kmu.isEqual(getTotalPrice(), e.getTotalPrice()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MySalesOrderLine e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MySalesOrderLine e)
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
        out.append("MySalesOrderLine");
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
        System.out.println("    ListPrice = " + listPrice);
        System.out.println("    UnitPrice = " + unitPrice);
        System.out.println("    OrderedQuantity = " + orderedQuantity);
        System.out.println("    FulfilledQuantity = " + fulfilledQuantity);
        System.out.println("    ExtendedPrice = " + extendedPrice);
        System.out.println("    PriceAdjustment = " + priceAdjustment);
        System.out.println("    AdjustedPrice = " + adjustedPrice);
        System.out.println("    Tax = " + tax);
        System.out.println("    TotalPrice = " + totalPrice);
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
