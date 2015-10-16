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

public abstract class MyShipmentBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaShipment Meta = MyMetaShipment.instance;
    public static final MyShipmentTools Tools = MyShipmentTools.instance;
    public static final MyShipmentValidator Validator = MyShipmentValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String trackingNumber;
    private Double weight;
    private KmMoney cost;
    private Boolean invoiceCustomer;
    private Integer lockVersion;
    private MySalesOrder salesOrder;
    private MyShipAccount account;
    private MyShipMethod method;
    private MyDepot depot;

    //##################################################
    //# constructor
    //##################################################

    public MyShipmentBase()
    {
        super();
        setUid(newUid());
        setInvoiceCustomer(false);
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
    //# field (trackingNumber)
    //##################################################

    public String getTrackingNumber()
    {
        return trackingNumber;
    }

    public void setTrackingNumber(String e)
    {
        checkReadOnly();
        e = Validator.getTrackingNumberValidator().convertOnly(e);
        trackingNumber = e;
    }

    public void clearTrackingNumber()
    {
        setTrackingNumber(null);
    }

    public boolean hasTrackingNumber()
    {
        return Kmu.hasValue(getTrackingNumber());
    }

    public boolean hasTrackingNumber(String e)
    {
        return Kmu.isEqualIgnoreCase(getTrackingNumber(), e);
    }

    public void truncateTrackingNumber()
    {
        truncateTrackingNumber(false);
    }

    public void truncateTrackingNumber(boolean ellipses)
    {
        trackingNumber = Kmu.truncate(trackingNumber, 50, ellipses);
    }

    //##################################################
    //# field (weight)
    //##################################################

    public Double getWeight()
    {
        return weight;
    }

    public void setWeight(Double e)
    {
        checkReadOnly();
        e = Validator.getWeightValidator().convertOnly(e);
        weight = e;
    }

    public void clearWeight()
    {
        setWeight(null);
    }

    public boolean hasWeight()
    {
        return getWeight() != null;
    }

    public boolean hasWeight(Double e)
    {
        return Kmu.isEqual(getWeight(), e);
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
    //# field (invoiceCustomer)
    //##################################################

    public Boolean getInvoiceCustomer()
    {
        return invoiceCustomer;
    }

    public void setInvoiceCustomer(Boolean e)
    {
        checkReadOnly();
        e = Validator.getInvoiceCustomerValidator().convertOnly(e);
        invoiceCustomer = e;
    }

    public void clearInvoiceCustomer()
    {
        setInvoiceCustomer(null);
    }

    public boolean hasInvoiceCustomer()
    {
        return getInvoiceCustomer() != null;
    }

    public boolean hasInvoiceCustomer(Boolean e)
    {
        return Kmu.isEqual(getInvoiceCustomer(), e);
    }

    public boolean isInvoiceCustomer()
    {
        if ( getInvoiceCustomer() == null )
            return false;
        return getInvoiceCustomer();
    }

    public boolean isNotInvoiceCustomer()
    {
        return !isInvoiceCustomer();
    }

    public boolean isInvoiceCustomer(Boolean b)
    {
        return Kmu.isEqual(getInvoiceCustomer(), b);
    }

    public void toggleInvoiceCustomer()
    {
        setInvoiceCustomer(!getInvoiceCustomer());
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
    //# account
    //##################################################

    public MyShipAccount getAccount()
    {
        return account;
    }

    public void setAccount(MyShipAccount e)
    {
        checkReadOnly();
        account = e;
    }

    public void _setAccount(MyShipAccount e)
    {
        checkReadOnly();
        account = e;
    }

    public void clearAccount()
    {
        setAccount(null);
    }

    public boolean hasAccount()
    {
        return getAccount() != null;
    }

    public boolean hasAccount(MyShipAccount e)
    {
        return Kmu.isEqual(getAccount(), e);
    }

    //##################################################
    //# method
    //##################################################

    public MyShipMethod getMethod()
    {
        return method;
    }

    public void setMethod(MyShipMethod e)
    {
        checkReadOnly();
        method = e;
    }

    public void _setMethod(MyShipMethod e)
    {
        checkReadOnly();
        method = e;
    }

    public void clearMethod()
    {
        setMethod(null);
    }

    public boolean hasMethod()
    {
        return getMethod() != null;
    }

    public boolean hasMethod(MyShipMethod e)
    {
        return Kmu.isEqual(getMethod(), e);
    }

    //##################################################
    //# depot
    //##################################################

    public MyDepot getDepot()
    {
        return depot;
    }

    public void setDepot(MyDepot e)
    {
        checkReadOnly();
        depot = e;
    }

    public void _setDepot(MyDepot e)
    {
        checkReadOnly();
        depot = e;
    }

    public void clearDepot()
    {
        setDepot(null);
    }

    public boolean hasDepot()
    {
        return getDepot() != null;
    }

    public boolean hasDepot(MyDepot e)
    {
        return Kmu.isEqual(getDepot(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyShipment)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyShipment)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyShipment)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyShipment getCopy()
    {
        return (MyShipment)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        salesOrder = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyShipmentBase) )
            return false;

        MyShipmentBase e = (MyShipmentBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyShipment e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyShipment e)
    {
        if ( !Kmu.isEqual(getTrackingNumber(), e.getTrackingNumber()) ) return false;
        if ( !Kmu.isEqual(getWeight(), e.getWeight()) ) return false;
        if ( !Kmu.isEqual(getCost(), e.getCost()) ) return false;
        if ( !Kmu.isEqual(getInvoiceCustomer(), e.getInvoiceCustomer()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyShipment e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyShipment e)
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
        out.append("MyShipment");
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
        System.out.println("    TrackingNumber = " + trackingNumber);
        System.out.println("    Weight = " + weight);
        System.out.println("    Cost = " + cost);
        System.out.println("    InvoiceCustomer = " + invoiceCustomer);
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
