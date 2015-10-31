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

public abstract class MyCustomerSiteBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaCustomerSite Meta = MyMetaCustomerSite.instance;
    public static final MyCustomerSiteTools Tools = MyCustomerSiteTools.instance;
    public static final MyCustomerSiteValidator Validator = MyCustomerSiteValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private String addressStreet1;
    private String addressStreet2;
    private String addressCity;
    private String addressRegion;
    private String addressPostalCode;
    private String addressCountry;
    private Integer lockVersion;
    private MyCustomer customer;
    private List<MyAttributeValue> attributeValues;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteBase()
    {
        super();
        setUid(newUid());
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
    //# field (addressStreet1)
    //##################################################

    public String getAddressStreet1()
    {
        return addressStreet1;
    }

    public void setAddressStreet1(String e)
    {
        checkReadOnly();
        e = Validator.getAddressStreet1Validator().convertOnly(e);
        addressStreet1 = e;
    }

    public void clearAddressStreet1()
    {
        setAddressStreet1(null);
    }

    public boolean hasAddressStreet1()
    {
        return Kmu.hasValue(getAddressStreet1());
    }

    public boolean hasAddressStreet1(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressStreet1(), e);
    }

    public void truncateAddressStreet1()
    {
        truncateAddressStreet1(false);
    }

    public void truncateAddressStreet1(boolean ellipses)
    {
        addressStreet1 = Kmu.truncate(addressStreet1, 50, ellipses);
    }

    //##################################################
    //# field (addressStreet2)
    //##################################################

    public String getAddressStreet2()
    {
        return addressStreet2;
    }

    public void setAddressStreet2(String e)
    {
        checkReadOnly();
        e = Validator.getAddressStreet2Validator().convertOnly(e);
        addressStreet2 = e;
    }

    public void clearAddressStreet2()
    {
        setAddressStreet2(null);
    }

    public boolean hasAddressStreet2()
    {
        return Kmu.hasValue(getAddressStreet2());
    }

    public boolean hasAddressStreet2(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressStreet2(), e);
    }

    public void truncateAddressStreet2()
    {
        truncateAddressStreet2(false);
    }

    public void truncateAddressStreet2(boolean ellipses)
    {
        addressStreet2 = Kmu.truncate(addressStreet2, 50, ellipses);
    }

    //##################################################
    //# field (addressCity)
    //##################################################

    public String getAddressCity()
    {
        return addressCity;
    }

    public void setAddressCity(String e)
    {
        checkReadOnly();
        e = Validator.getAddressCityValidator().convertOnly(e);
        addressCity = e;
    }

    public void clearAddressCity()
    {
        setAddressCity(null);
    }

    public boolean hasAddressCity()
    {
        return Kmu.hasValue(getAddressCity());
    }

    public boolean hasAddressCity(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressCity(), e);
    }

    public void truncateAddressCity()
    {
        truncateAddressCity(false);
    }

    public void truncateAddressCity(boolean ellipses)
    {
        addressCity = Kmu.truncate(addressCity, 50, ellipses);
    }

    //##################################################
    //# field (addressRegion)
    //##################################################

    public String getAddressRegion()
    {
        return addressRegion;
    }

    public void setAddressRegion(String e)
    {
        checkReadOnly();
        e = Validator.getAddressRegionValidator().convertOnly(e);
        addressRegion = e;
    }

    public void clearAddressRegion()
    {
        setAddressRegion(null);
    }

    public boolean hasAddressRegion()
    {
        return Kmu.hasValue(getAddressRegion());
    }

    public boolean hasAddressRegion(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressRegion(), e);
    }

    public void truncateAddressRegion()
    {
        truncateAddressRegion(false);
    }

    public void truncateAddressRegion(boolean ellipses)
    {
        addressRegion = Kmu.truncate(addressRegion, 50, ellipses);
    }

    //##################################################
    //# field (addressPostalCode)
    //##################################################

    public String getAddressPostalCode()
    {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String e)
    {
        checkReadOnly();
        e = Validator.getAddressPostalCodeValidator().convertOnly(e);
        addressPostalCode = e;
    }

    public void clearAddressPostalCode()
    {
        setAddressPostalCode(null);
    }

    public boolean hasAddressPostalCode()
    {
        return Kmu.hasValue(getAddressPostalCode());
    }

    public boolean hasAddressPostalCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressPostalCode(), e);
    }

    public void truncateAddressPostalCode()
    {
        truncateAddressPostalCode(false);
    }

    public void truncateAddressPostalCode(boolean ellipses)
    {
        addressPostalCode = Kmu.truncate(addressPostalCode, 20, ellipses);
    }

    //##################################################
    //# field (addressCountry)
    //##################################################

    public String getAddressCountry()
    {
        return addressCountry;
    }

    public void setAddressCountry(String e)
    {
        checkReadOnly();
        e = Validator.getAddressCountryValidator().convertOnly(e);
        addressCountry = e;
    }

    public void clearAddressCountry()
    {
        setAddressCountry(null);
    }

    public boolean hasAddressCountry()
    {
        return Kmu.hasValue(getAddressCountry());
    }

    public boolean hasAddressCountry(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressCountry(), e);
    }

    public void truncateAddressCountry()
    {
        truncateAddressCountry(false);
    }

    public void truncateAddressCountry(boolean ellipses)
    {
        addressCountry = Kmu.truncate(addressCountry, 50, ellipses);
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
    //# AttributeValues (collection)
    //##################################################

    public KmCollection<MyAttributeValue> getAttributeValues()
    {
        return new KmHibernateCollection<>(
            getBaseAttributeValues(),
            (MyCustomerSite)this,
            MyAttributeValue.Meta.CustomerSite.getAdaptor());
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
        Validator.validate((MyCustomerSite)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyCustomerSite)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyCustomerSite)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyCustomerSite getCopy()
    {
        return (MyCustomerSite)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        customer = null;

        attributeValues = new ArrayList<>();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyCustomerSiteBase) )
            return false;

        MyCustomerSiteBase e = (MyCustomerSiteBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyCustomerSite e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyCustomerSite e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getAddressStreet1(), e.getAddressStreet1()) ) return false;
        if ( !Kmu.isEqual(getAddressStreet2(), e.getAddressStreet2()) ) return false;
        if ( !Kmu.isEqual(getAddressCity(), e.getAddressCity()) ) return false;
        if ( !Kmu.isEqual(getAddressRegion(), e.getAddressRegion()) ) return false;
        if ( !Kmu.isEqual(getAddressPostalCode(), e.getAddressPostalCode()) ) return false;
        if ( !Kmu.isEqual(getAddressCountry(), e.getAddressCountry()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyCustomerSite e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyCustomerSite e)
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
        out.append("MyCustomerSite");
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
        System.out.println("    AddressStreet1 = " + addressStreet1);
        System.out.println("    AddressStreet2 = " + addressStreet2);
        System.out.println("    AddressCity = " + addressCity);
        System.out.println("    AddressRegion = " + addressRegion);
        System.out.println("    AddressPostalCode = " + addressPostalCode);
        System.out.println("    AddressCountry = " + addressCountry);
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
