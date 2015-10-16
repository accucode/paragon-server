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

public abstract class MyShipAccountBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaShipAccount Meta = MyMetaShipAccount.instance;
    public static final MyShipAccountTools Tools = MyShipAccountTools.instance;
    public static final MyShipAccountValidator Validator = MyShipAccountValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private String description;
    private Boolean billedToCustomer;
    private String shipOnAccountName;
    private String shipOnAccountNumber;
    private String billToTypeCode;
    private String billToAccount;
    private Integer lockVersion;
    private MyProject project;
    private MyCustomer customer;
    private MyShipCarrier carrier;

    //##################################################
    //# constructor
    //##################################################

    public MyShipAccountBase()
    {
        super();
        setUid(newUid());
        setBilledToCustomer(false);
        setBillToTypeCode(MyShipAccountBillToType.Sender.getCode());
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
    //# field (billedToCustomer)
    //##################################################

    public Boolean getBilledToCustomer()
    {
        return billedToCustomer;
    }

    public void setBilledToCustomer(Boolean e)
    {
        checkReadOnly();
        e = Validator.getBilledToCustomerValidator().convertOnly(e);
        billedToCustomer = e;
    }

    public void clearBilledToCustomer()
    {
        setBilledToCustomer(null);
    }

    public boolean hasBilledToCustomer()
    {
        return getBilledToCustomer() != null;
    }

    public boolean hasBilledToCustomer(Boolean e)
    {
        return Kmu.isEqual(getBilledToCustomer(), e);
    }

    public boolean isBilledToCustomer()
    {
        if ( getBilledToCustomer() == null )
            return false;
        return getBilledToCustomer();
    }

    public boolean isNotBilledToCustomer()
    {
        return !isBilledToCustomer();
    }

    public boolean isBilledToCustomer(Boolean b)
    {
        return Kmu.isEqual(getBilledToCustomer(), b);
    }

    public void toggleBilledToCustomer()
    {
        setBilledToCustomer(!getBilledToCustomer());
    }

    //##################################################
    //# field (shipOnAccountName)
    //##################################################

    public String getShipOnAccountName()
    {
        return shipOnAccountName;
    }

    public void setShipOnAccountName(String e)
    {
        checkReadOnly();
        e = Validator.getShipOnAccountNameValidator().convertOnly(e);
        shipOnAccountName = e;
    }

    public void clearShipOnAccountName()
    {
        setShipOnAccountName(null);
    }

    public boolean hasShipOnAccountName()
    {
        return Kmu.hasValue(getShipOnAccountName());
    }

    public boolean hasShipOnAccountName(String e)
    {
        return Kmu.isEqualIgnoreCase(getShipOnAccountName(), e);
    }

    public void truncateShipOnAccountName()
    {
        truncateShipOnAccountName(false);
    }

    public void truncateShipOnAccountName(boolean ellipses)
    {
        shipOnAccountName = Kmu.truncate(shipOnAccountName, 50, ellipses);
    }

    //##################################################
    //# field (shipOnAccountNumber)
    //##################################################

    public String getShipOnAccountNumber()
    {
        return shipOnAccountNumber;
    }

    public void setShipOnAccountNumber(String e)
    {
        checkReadOnly();
        e = Validator.getShipOnAccountNumberValidator().convertOnly(e);
        shipOnAccountNumber = e;
    }

    public void clearShipOnAccountNumber()
    {
        setShipOnAccountNumber(null);
    }

    public boolean hasShipOnAccountNumber()
    {
        return Kmu.hasValue(getShipOnAccountNumber());
    }

    public boolean hasShipOnAccountNumber(String e)
    {
        return Kmu.isEqualIgnoreCase(getShipOnAccountNumber(), e);
    }

    public void truncateShipOnAccountNumber()
    {
        truncateShipOnAccountNumber(false);
    }

    public void truncateShipOnAccountNumber(boolean ellipses)
    {
        shipOnAccountNumber = Kmu.truncate(shipOnAccountNumber, 50, ellipses);
    }

    //##################################################
    //# field (billToTypeCode)
    //##################################################

    public String getBillToTypeCode()
    {
        return billToTypeCode;
    }

    public void setBillToTypeCode(String e)
    {
        checkReadOnly();
        e = Validator.getBillToTypeCodeValidator().convertOnly(e);
        billToTypeCode = e;
    }

    public void clearBillToTypeCode()
    {
        setBillToTypeCode(null);
    }

    public boolean hasBillToTypeCode()
    {
        return Kmu.hasValue(getBillToTypeCode());
    }

    public boolean hasBillToTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillToTypeCode(), e);
    }

    public void truncateBillToTypeCode()
    {
        truncateBillToTypeCode(false);
    }

    public void truncateBillToTypeCode(boolean ellipses)
    {
        billToTypeCode = Kmu.truncate(billToTypeCode, 1, ellipses);
    }

    public MyShipAccountBillToType getBillToType()
    {
        return MyShipAccountBillToType.findCode(getBillToTypeCode());
    }

    public void setBillToType(MyShipAccountBillToType e)
    {
        if ( e == null )
            setBillToTypeCode(null);
        else
            setBillToTypeCode(e.getCode());
    }

    public boolean hasBillToType()
    {
        return getBillToType() != null;
    }

    public boolean hasBillToType(MyShipAccountBillToType e)
    {
        return getBillToType() == e;
    }

    public void setBillToTypeSender()
    {
        setBillToType(MyShipAccountBillToType.Sender);
    }

    public boolean isBillToTypeSender()
    {
        return hasBillToType(MyShipAccountBillToType.Sender);
    }

    public boolean isNotBillToTypeSender()
    {
        return !isBillToTypeSender();
    }

    public void setBillToTypeReceiving()
    {
        setBillToType(MyShipAccountBillToType.Receiving);
    }

    public boolean isBillToTypeReceiving()
    {
        return hasBillToType(MyShipAccountBillToType.Receiving);
    }

    public boolean isNotBillToTypeReceiving()
    {
        return !isBillToTypeReceiving();
    }

    public void setBillToTypeThird()
    {
        setBillToType(MyShipAccountBillToType.Third);
    }

    public boolean isBillToTypeThird()
    {
        return hasBillToType(MyShipAccountBillToType.Third);
    }

    public boolean isNotBillToTypeThird()
    {
        return !isBillToTypeThird();
    }

    //##################################################
    //# field (billToAccount)
    //##################################################

    public String getBillToAccount()
    {
        return billToAccount;
    }

    public void setBillToAccount(String e)
    {
        checkReadOnly();
        e = Validator.getBillToAccountValidator().convertOnly(e);
        billToAccount = e;
    }

    public void clearBillToAccount()
    {
        setBillToAccount(null);
    }

    public boolean hasBillToAccount()
    {
        return Kmu.hasValue(getBillToAccount());
    }

    public boolean hasBillToAccount(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillToAccount(), e);
    }

    public void truncateBillToAccount()
    {
        truncateBillToAccount(false);
    }

    public void truncateBillToAccount(boolean ellipses)
    {
        billToAccount = Kmu.truncate(billToAccount, 50, ellipses);
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
    //# field (billToTypeName)
    //##################################################

    public final String getBillToTypeName()
    {
        return Kmu.getName(getBillToType());
    }

    public boolean hasBillToTypeName()
    {
        return Kmu.hasValue(getBillToTypeName());
    }

    public boolean hasBillToTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillToTypeName(), e);
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
    //# carrier
    //##################################################

    public MyShipCarrier getCarrier()
    {
        return carrier;
    }

    public void setCarrier(MyShipCarrier e)
    {
        checkReadOnly();
        carrier = e;
    }

    public void _setCarrier(MyShipCarrier e)
    {
        checkReadOnly();
        carrier = e;
    }

    public void clearCarrier()
    {
        setCarrier(null);
    }

    public boolean hasCarrier()
    {
        return getCarrier() != null;
    }

    public boolean hasCarrier(MyShipCarrier e)
    {
        return Kmu.isEqual(getCarrier(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyShipAccount)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyShipAccount)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyShipAccount)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyShipAccount getCopy()
    {
        return (MyShipAccount)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyShipAccountBase) )
            return false;

        MyShipAccountBase e = (MyShipAccountBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyShipAccount e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyShipAccount e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getDescription(), e.getDescription()) ) return false;
        if ( !Kmu.isEqual(getBilledToCustomer(), e.getBilledToCustomer()) ) return false;
        if ( !Kmu.isEqual(getShipOnAccountName(), e.getShipOnAccountName()) ) return false;
        if ( !Kmu.isEqual(getShipOnAccountNumber(), e.getShipOnAccountNumber()) ) return false;
        if ( !Kmu.isEqual(getBillToTypeCode(), e.getBillToTypeCode()) ) return false;
        if ( !Kmu.isEqual(getBillToAccount(), e.getBillToAccount()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getBillToTypeName(), e.getBillToTypeName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyShipAccount e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyShipAccount e)
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
        out.append("MyShipAccount");
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
        System.out.println("    Description = " + description);
        System.out.println("    BilledToCustomer = " + billedToCustomer);
        System.out.println("    ShipOnAccountName = " + shipOnAccountName);
        System.out.println("    ShipOnAccountNumber = " + shipOnAccountNumber);
        System.out.println("    BillToTypeCode = " + billToTypeCode);
        System.out.println("    BillToAccount = " + billToAccount);
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
