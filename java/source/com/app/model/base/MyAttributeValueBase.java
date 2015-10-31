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

public abstract class MyAttributeValueBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAttributeValue Meta = MyMetaAttributeValue.instance;
    public static final MyAttributeValueTools Tools = MyAttributeValueTools.instance;
    public static final MyAttributeValueValidator Validator = MyAttributeValueValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String textValue;
    private Integer lockVersion;
    private MyAttributeField field;
    private MyProduct product;
    private MyCustomerSite customerSite;
    private MySalesOrderLine salesOrderLine;

    //##################################################
    //# constructor
    //##################################################

    public MyAttributeValueBase()
    {
        super();
        setUid(newUid());
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
    //# field (textValue)
    //##################################################

    public String getTextValue()
    {
        return textValue;
    }

    public void setTextValue(String e)
    {
        checkReadOnly();
        e = Validator.getTextValueValidator().convertOnly(e);
        textValue = e;
    }

    public void clearTextValue()
    {
        setTextValue(null);
    }

    public boolean hasTextValue()
    {
        return Kmu.hasValue(getTextValue());
    }

    public boolean hasTextValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getTextValue(), e);
    }

    public void truncateTextValue()
    {
        truncateTextValue(false);
    }

    public void truncateTextValue(boolean ellipses)
    {
        textValue = Kmu.truncate(textValue, 100, ellipses);
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
    //# field
    //##################################################

    public MyAttributeField getField()
    {
        return field;
    }

    public void setField(MyAttributeField e)
    {
        checkReadOnly();
        field = e;
    }

    public void _setField(MyAttributeField e)
    {
        checkReadOnly();
        field = e;
    }

    public void clearField()
    {
        setField(null);
    }

    public boolean hasField()
    {
        return getField() != null;
    }

    public boolean hasField(MyAttributeField e)
    {
        return Kmu.isEqual(getField(), e);
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
    //# customerSite
    //##################################################

    public MyCustomerSite getCustomerSite()
    {
        return customerSite;
    }

    public void setCustomerSite(MyCustomerSite e)
    {
        checkReadOnly();
        customerSite = e;
    }

    public void _setCustomerSite(MyCustomerSite e)
    {
        checkReadOnly();
        customerSite = e;
    }

    public void clearCustomerSite()
    {
        setCustomerSite(null);
    }

    public boolean hasCustomerSite()
    {
        return getCustomerSite() != null;
    }

    public boolean hasCustomerSite(MyCustomerSite e)
    {
        return Kmu.isEqual(getCustomerSite(), e);
    }

    //##################################################
    //# salesOrderLine
    //##################################################

    public MySalesOrderLine getSalesOrderLine()
    {
        return salesOrderLine;
    }

    public void setSalesOrderLine(MySalesOrderLine e)
    {
        checkReadOnly();
        salesOrderLine = e;
    }

    public void _setSalesOrderLine(MySalesOrderLine e)
    {
        checkReadOnly();
        salesOrderLine = e;
    }

    public void clearSalesOrderLine()
    {
        setSalesOrderLine(null);
    }

    public boolean hasSalesOrderLine()
    {
        return getSalesOrderLine() != null;
    }

    public boolean hasSalesOrderLine(MySalesOrderLine e)
    {
        return Kmu.isEqual(getSalesOrderLine(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyAttributeValue)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAttributeValue)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAttributeValue)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAttributeValue getCopy()
    {
        return (MyAttributeValue)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        field = null;
        product = null;
        customerSite = null;
        salesOrderLine = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyAttributeValueBase) )
            return false;

        MyAttributeValueBase e = (MyAttributeValueBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAttributeValue e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAttributeValue e)
    {
        if ( !Kmu.isEqual(getTextValue(), e.getTextValue()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAttributeValue e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAttributeValue e)
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
        out.append("MyAttributeValue");
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
        System.out.println("    TextValue = " + textValue);
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
