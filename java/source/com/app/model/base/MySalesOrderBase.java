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

public abstract class MySalesOrderBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSalesOrder Meta = MyMetaSalesOrder.instance;
    public static final MySalesOrderTools Tools = MySalesOrderTools.instance;
    public static final MySalesOrderValidator Validator = MySalesOrderValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String number;
    private String statusCode;
    private KmTimestamp holdUntilUtcTs;
    private Boolean expedite;
    private Boolean taxExempt;
    private Double taxRate;
    private Double discountRate;
    private KmMoney totalPrice;
    private KmMoney totalTax;
    private Integer lockVersion;
    private MyProject project;
    private MyCustomer customer;
    private MyRegion region;
    private MyAttentionGroup attentionTo;
    private MyPowerType powerType;
    private List<MySalesOrderContact> contacts;
    private List<MySalesOrderLine> lines;
    private List<MyShipment> shipments;

    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderBase()
    {
        super();
        setUid(newUid());
        setStatusCode(MySalesOrderStatus.New.getCode());
        setExpedite(false);
        setTaxExempt(false);
        setTaxRate(0.0);
        setDiscountRate(0.0);
        setTotalPrice(KmMoney.ZERO);
        setTotalTax(KmMoney.ZERO);
        contacts = new ArrayList<>();
        lines = new ArrayList<>();
        shipments = new ArrayList<>();
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
    //# field (number)
    //##################################################

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String e)
    {
        checkReadOnly();
        e = Validator.getNumberValidator().convertOnly(e);
        number = e;
    }

    public void clearNumber()
    {
        setNumber(null);
    }

    public boolean hasNumber()
    {
        return Kmu.hasValue(getNumber());
    }

    public boolean hasNumber(String e)
    {
        return Kmu.isEqualIgnoreCase(getNumber(), e);
    }

    public void truncateNumber()
    {
        truncateNumber(false);
    }

    public void truncateNumber(boolean ellipses)
    {
        number = Kmu.truncate(number, 50, ellipses);
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

    public MySalesOrderStatus getStatus()
    {
        return MySalesOrderStatus.findCode(getStatusCode());
    }

    public void setStatus(MySalesOrderStatus e)
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

    public boolean hasStatus(MySalesOrderStatus e)
    {
        return getStatus() == e;
    }

    public void setStatusNew()
    {
        setStatus(MySalesOrderStatus.New);
    }

    public boolean isStatusNew()
    {
        return hasStatus(MySalesOrderStatus.New);
    }

    public boolean isNotStatusNew()
    {
        return !isStatusNew();
    }

    public void setStatusIn()
    {
        setStatus(MySalesOrderStatus.In);
    }

    public boolean isStatusIn()
    {
        return hasStatus(MySalesOrderStatus.In);
    }

    public boolean isNotStatusIn()
    {
        return !isStatusIn();
    }

    public void setStatusClosed()
    {
        setStatus(MySalesOrderStatus.Closed);
    }

    public boolean isStatusClosed()
    {
        return hasStatus(MySalesOrderStatus.Closed);
    }

    public boolean isNotStatusClosed()
    {
        return !isStatusClosed();
    }

    //##################################################
    //# field (holdUntilUtcTs)
    //##################################################

    public KmTimestamp getHoldUntilUtcTs()
    {
        return holdUntilUtcTs;
    }

    public void setHoldUntilUtcTs(KmTimestamp e)
    {
        checkReadOnly();
        e = Validator.getHoldUntilUtcTsValidator().convertOnly(e);
        holdUntilUtcTs = e;
    }

    public void clearHoldUntilUtcTs()
    {
        setHoldUntilUtcTs(null);
    }

    public boolean hasHoldUntilUtcTs()
    {
        return getHoldUntilUtcTs() != null;
    }

    public boolean hasHoldUntilUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getHoldUntilUtcTs(), e);
    }

    //##################################################
    //# field (expedite)
    //##################################################

    public Boolean getExpedite()
    {
        return expedite;
    }

    public void setExpedite(Boolean e)
    {
        checkReadOnly();
        e = Validator.getExpediteValidator().convertOnly(e);
        expedite = e;
    }

    public void clearExpedite()
    {
        setExpedite(null);
    }

    public boolean hasExpedite()
    {
        return getExpedite() != null;
    }

    public boolean hasExpedite(Boolean e)
    {
        return Kmu.isEqual(getExpedite(), e);
    }

    public boolean isExpedite()
    {
        if ( getExpedite() == null )
            return false;
        return getExpedite();
    }

    public boolean isNotExpedite()
    {
        return !isExpedite();
    }

    public boolean isExpedite(Boolean b)
    {
        return Kmu.isEqual(getExpedite(), b);
    }

    public void toggleExpedite()
    {
        setExpedite(!getExpedite());
    }

    //##################################################
    //# field (taxExempt)
    //##################################################

    public Boolean getTaxExempt()
    {
        return taxExempt;
    }

    public void setTaxExempt(Boolean e)
    {
        checkReadOnly();
        e = Validator.getTaxExemptValidator().convertOnly(e);
        taxExempt = e;
    }

    public void clearTaxExempt()
    {
        setTaxExempt(null);
    }

    public boolean hasTaxExempt()
    {
        return getTaxExempt() != null;
    }

    public boolean hasTaxExempt(Boolean e)
    {
        return Kmu.isEqual(getTaxExempt(), e);
    }

    public boolean isTaxExempt()
    {
        if ( getTaxExempt() == null )
            return false;
        return getTaxExempt();
    }

    public boolean isNotTaxExempt()
    {
        return !isTaxExempt();
    }

    public boolean isTaxExempt(Boolean b)
    {
        return Kmu.isEqual(getTaxExempt(), b);
    }

    public void toggleTaxExempt()
    {
        setTaxExempt(!getTaxExempt());
    }

    //##################################################
    //# field (taxRate)
    //##################################################

    public Double getTaxRate()
    {
        return taxRate;
    }

    public void setTaxRate(Double e)
    {
        checkReadOnly();
        e = Validator.getTaxRateValidator().convertOnly(e);
        Double oldValue = taxRate;
        taxRate = e;
        if ( Kmu.isNotEqual(e, oldValue) )
        {
            handleTaxRateChange();
        }
    }

    public void clearTaxRate()
    {
        setTaxRate(null);
    }

    public boolean hasTaxRate()
    {
        return getTaxRate() != null;
    }

    public boolean hasTaxRate(Double e)
    {
        return Kmu.isEqual(getTaxRate(), e);
    }

    //##################################################
    //# field (discountRate)
    //##################################################

    public Double getDiscountRate()
    {
        return discountRate;
    }

    public void setDiscountRate(Double e)
    {
        checkReadOnly();
        e = Validator.getDiscountRateValidator().convertOnly(e);
        discountRate = e;
    }

    public void clearDiscountRate()
    {
        setDiscountRate(null);
    }

    public boolean hasDiscountRate()
    {
        return getDiscountRate() != null;
    }

    public boolean hasDiscountRate(Double e)
    {
        return Kmu.isEqual(getDiscountRate(), e);
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
    //# field (totalTax)
    //##################################################

    public KmMoney getTotalTax()
    {
        return totalTax;
    }

    public void setTotalTax(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getTotalTaxValidator().convertOnly(e);
        totalTax = e;
    }

    public void clearTotalTax()
    {
        setTotalTax(null);
    }

    public boolean hasTotalTax()
    {
        return getTotalTax() != null;
    }

    public boolean hasTotalTax(KmMoney e)
    {
        return Kmu.isEqual(getTotalTax(), e);
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
    //# field (holdUntilLocalTs)
    //##################################################

    public final KmTimestamp getHoldUntilLocalTs()
    {
        return KmTimestampUtility.toLocal(getHoldUntilUtcTs());
    }

    public boolean hasHoldUntilLocalTs()
    {
        return getHoldUntilLocalTs() != null;
    }

    public boolean hasHoldUntilLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getHoldUntilLocalTs(), e);
    }

    //##################################################
    //# field (holdUntilLocalTsMessage)
    //##################################################

    public final String getHoldUntilLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getHoldUntilUtcTs());
    }

    public boolean hasHoldUntilLocalTsMessage()
    {
        return Kmu.hasValue(getHoldUntilLocalTsMessage());
    }

    public boolean hasHoldUntilLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getHoldUntilLocalTsMessage(), e);
    }

    //##################################################
    //# field (holdUntilLocalDate)
    //##################################################

    public final KmDate getHoldUntilLocalDate()
    {
        return KmTimestampUtility.getDate(getHoldUntilLocalTs());
    }

    public boolean hasHoldUntilLocalDate()
    {
        return getHoldUntilLocalDate() != null;
    }

    public boolean hasHoldUntilLocalDate(KmDate e)
    {
        return Kmu.isEqual(getHoldUntilLocalDate(), e);
    }

    //##################################################
    //# field (holdUntilLocalTime)
    //##################################################

    public final KmTime getHoldUntilLocalTime()
    {
        return KmTimestampUtility.getTime(getHoldUntilLocalTs());
    }

    public boolean hasHoldUntilLocalTime()
    {
        return getHoldUntilLocalTime() != null;
    }

    public boolean hasHoldUntilLocalTime(KmTime e)
    {
        return Kmu.isEqual(getHoldUntilLocalTime(), e);
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
    //# region
    //##################################################

    public MyRegion getRegion()
    {
        return region;
    }

    public void setRegion(MyRegion e)
    {
        checkReadOnly();
        region = e;
    }

    public void _setRegion(MyRegion e)
    {
        checkReadOnly();
        region = e;
    }

    public void clearRegion()
    {
        setRegion(null);
    }

    public boolean hasRegion()
    {
        return getRegion() != null;
    }

    public boolean hasRegion(MyRegion e)
    {
        return Kmu.isEqual(getRegion(), e);
    }

    //##################################################
    //# attentionTo
    //##################################################

    public MyAttentionGroup getAttentionTo()
    {
        return attentionTo;
    }

    public void setAttentionTo(MyAttentionGroup e)
    {
        checkReadOnly();
        attentionTo = e;
    }

    public void _setAttentionTo(MyAttentionGroup e)
    {
        checkReadOnly();
        attentionTo = e;
    }

    public void clearAttentionTo()
    {
        setAttentionTo(null);
    }

    public boolean hasAttentionTo()
    {
        return getAttentionTo() != null;
    }

    public boolean hasAttentionTo(MyAttentionGroup e)
    {
        return Kmu.isEqual(getAttentionTo(), e);
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
    //# Contacts (collection)
    //##################################################

    public KmCollection<MySalesOrderContact> getContacts()
    {
        return new KmHibernateCollection<>(
            getBaseContacts(),
            (MySalesOrder)this,
            MySalesOrderContact.Meta.SalesOrder.getAdaptor());
    }

    public boolean hasContacts()
    {
        return !getBaseContacts().isEmpty();
    }

    public int getContactCount()
    {
        return getBaseContacts().size();
    }

    public List<MySalesOrderContact> getBaseContacts()
    {
        return contacts;
    }

    public MySalesOrderContact addContact()
    {
        MySalesOrderContact e;
        e = new MySalesOrderContact();
        getContacts().add(e);
        return e;
    }

    public void addContact(MySalesOrderContact e)
    {
        getContacts().add(e);
    }

    public boolean removeContact(MySalesOrderContact e)
    {
        return getContacts().remove(e);
    }

    public boolean removeContactUid(String myUid)
    {
        MySalesOrderContact e = findContactUid(myUid);
        if ( e == null )
            return false;

        return removeContact(e);
    }

    public MySalesOrderContact findContactUid(String myUid)
    {
        for ( MySalesOrderContact e : getBaseContacts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearContacts()
    {
        getContacts().clear();
    }

    //##################################################
    //# Lines (collection)
    //##################################################

    public KmCollection<MySalesOrderLine> getLines()
    {
        return new KmHibernateCollection<>(
            getBaseLines(),
            (MySalesOrder)this,
            MySalesOrderLine.Meta.SalesOrder.getAdaptor());
    }

    public boolean hasLines()
    {
        return !getBaseLines().isEmpty();
    }

    public int getLineCount()
    {
        return getBaseLines().size();
    }

    public List<MySalesOrderLine> getBaseLines()
    {
        return lines;
    }

    public MySalesOrderLine addLine()
    {
        MySalesOrderLine e;
        e = new MySalesOrderLine();
        getLines().add(e);
        return e;
    }

    public void addLine(MySalesOrderLine e)
    {
        getLines().add(e);
    }

    public boolean removeLine(MySalesOrderLine e)
    {
        return getLines().remove(e);
    }

    public boolean removeLineUid(String myUid)
    {
        MySalesOrderLine e = findLineUid(myUid);
        if ( e == null )
            return false;

        return removeLine(e);
    }

    public MySalesOrderLine findLineUid(String myUid)
    {
        for ( MySalesOrderLine e : getBaseLines() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearLines()
    {
        getLines().clear();
    }

    //##################################################
    //# Shipments (collection)
    //##################################################

    public KmCollection<MyShipment> getShipments()
    {
        return new KmHibernateCollection<>(
            getBaseShipments(),
            (MySalesOrder)this,
            MyShipment.Meta.SalesOrder.getAdaptor());
    }

    public boolean hasShipments()
    {
        return !getBaseShipments().isEmpty();
    }

    public int getShipmentCount()
    {
        return getBaseShipments().size();
    }

    public List<MyShipment> getBaseShipments()
    {
        return shipments;
    }

    public MyShipment addShipment()
    {
        MyShipment e;
        e = new MyShipment();
        getShipments().add(e);
        return e;
    }

    public void addShipment(MyShipment e)
    {
        getShipments().add(e);
    }

    public boolean removeShipment(MyShipment e)
    {
        return getShipments().remove(e);
    }

    public boolean removeShipmentUid(String myUid)
    {
        MyShipment e = findShipmentUid(myUid);
        if ( e == null )
            return false;

        return removeShipment(e);
    }

    public MyShipment findShipmentUid(String myUid)
    {
        for ( MyShipment e : getBaseShipments() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearShipments()
    {
        getShipments().clear();
    }

    //##################################################
    //# on change
    //##################################################

    protected abstract void handleTaxRateChange();

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MySalesOrder)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MySalesOrder)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MySalesOrder)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MySalesOrder getCopy()
    {
        return (MySalesOrder)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;

        List<MySalesOrderContact> old_contacts = contacts;
        contacts = new ArrayList<>();
        for ( MySalesOrderContact e : old_contacts )
            addContact(copy(e));

        List<MySalesOrderLine> old_lines = lines;
        lines = new ArrayList<>();
        for ( MySalesOrderLine e : old_lines )
            addLine(copy(e));

        List<MyShipment> old_shipments = shipments;
        shipments = new ArrayList<>();
        for ( MyShipment e : old_shipments )
            addShipment(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MySalesOrderBase) )
            return false;

        MySalesOrderBase e = (MySalesOrderBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MySalesOrder e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MySalesOrder e)
    {
        if ( !Kmu.isEqual(getNumber(), e.getNumber()) ) return false;
        if ( !Kmu.isEqual(getStatusCode(), e.getStatusCode()) ) return false;
        if ( !Kmu.isEqual(getHoldUntilUtcTs(), e.getHoldUntilUtcTs()) ) return false;
        if ( !Kmu.isEqual(getExpedite(), e.getExpedite()) ) return false;
        if ( !Kmu.isEqual(getTaxExempt(), e.getTaxExempt()) ) return false;
        if ( !Kmu.isEqual(getTaxRate(), e.getTaxRate()) ) return false;
        if ( !Kmu.isEqual(getDiscountRate(), e.getDiscountRate()) ) return false;
        if ( !Kmu.isEqual(getTotalPrice(), e.getTotalPrice()) ) return false;
        if ( !Kmu.isEqual(getTotalTax(), e.getTotalTax()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
        if ( !Kmu.isEqual(getHoldUntilLocalTs(), e.getHoldUntilLocalTs()) ) return false;
        if ( !Kmu.isEqual(getHoldUntilLocalTsMessage(), e.getHoldUntilLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getHoldUntilLocalDate(), e.getHoldUntilLocalDate()) ) return false;
        if ( !Kmu.isEqual(getHoldUntilLocalTime(), e.getHoldUntilLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MySalesOrder e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MySalesOrder e)
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
        out.append("MySalesOrder");
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
        System.out.println("    Number = " + number);
        System.out.println("    StatusCode = " + statusCode);
        System.out.println("    HoldUntilUtcTs = " + holdUntilUtcTs);
        System.out.println("    Expedite = " + expedite);
        System.out.println("    TaxExempt = " + taxExempt);
        System.out.println("    TaxRate = " + taxRate);
        System.out.println("    DiscountRate = " + discountRate);
        System.out.println("    TotalPrice = " + totalPrice);
        System.out.println("    TotalTax = " + totalTax);
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
