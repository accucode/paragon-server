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

public abstract class MyCustomerBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaCustomer Meta = MyMetaCustomer.instance;
    public static final MyCustomerTools Tools = MyCustomerTools.instance;
    public static final MyCustomerValidator Validator = MyCustomerValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Double discountRate;
    private String addressStreet1;
    private String addressStreet2;
    private String addressCity;
    private String addressRegion;
    private String addressPostalCode;
    private String addressCountry;
    private Integer lockVersion;
    private MyProject project;
    private MyCustomerTier tier;
    private List<MyCustomerContact> contacts;
    private List<MyEndUser> endUsers;
    private List<MyCustomerSite> sites;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerBase()
    {
        super();
        setUid(newUid());
        setDiscountRate(0.0);
        contacts = new ArrayList<>();
        endUsers = new ArrayList<>();
        sites = new ArrayList<>();
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
    //# tier
    //##################################################

    public MyCustomerTier getTier()
    {
        return tier;
    }

    public void setTier(MyCustomerTier e)
    {
        checkReadOnly();
        tier = e;
    }

    public void _setTier(MyCustomerTier e)
    {
        checkReadOnly();
        tier = e;
    }

    public void clearTier()
    {
        setTier(null);
    }

    public boolean hasTier()
    {
        return getTier() != null;
    }

    public boolean hasTier(MyCustomerTier e)
    {
        return Kmu.isEqual(getTier(), e);
    }


    //##################################################
    //# Contacts (collection)
    //##################################################

    public KmCollection<MyCustomerContact> getContacts()
    {
        return new KmHibernateCollection<>(
            getBaseContacts(),
            (MyCustomer)this,
            MyCustomerContact.Meta.Customer.getAdaptor());
    }

    public boolean hasContacts()
    {
        return !getBaseContacts().isEmpty();
    }

    public int getContactCount()
    {
        return getBaseContacts().size();
    }

    public List<MyCustomerContact> getBaseContacts()
    {
        return contacts;
    }

    public MyCustomerContact addContact()
    {
        MyCustomerContact e;
        e = new MyCustomerContact();
        getContacts().add(e);
        return e;
    }

    public void addContact(MyCustomerContact e)
    {
        getContacts().add(e);
    }

    public boolean removeContact(MyCustomerContact e)
    {
        return getContacts().remove(e);
    }

    public boolean removeContactUid(String myUid)
    {
        MyCustomerContact e = findContactUid(myUid);
        if ( e == null )
            return false;

        return removeContact(e);
    }

    public MyCustomerContact findContactUid(String myUid)
    {
        for ( MyCustomerContact e : getBaseContacts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearContacts()
    {
        getContacts().clear();
    }

    //##################################################
    //# EndUsers (collection)
    //##################################################

    public KmCollection<MyEndUser> getEndUsers()
    {
        return new KmHibernateCollection<>(
            getBaseEndUsers(),
            (MyCustomer)this,
            MyEndUser.Meta.Customer.getAdaptor());
    }

    public boolean hasEndUsers()
    {
        return !getBaseEndUsers().isEmpty();
    }

    public int getEndUserCount()
    {
        return getBaseEndUsers().size();
    }

    public List<MyEndUser> getBaseEndUsers()
    {
        return endUsers;
    }

    public MyEndUser addEndUser()
    {
        MyEndUser e;
        e = new MyEndUser();
        getEndUsers().add(e);
        return e;
    }

    public void addEndUser(MyEndUser e)
    {
        getEndUsers().add(e);
    }

    public boolean removeEndUser(MyEndUser e)
    {
        return getEndUsers().remove(e);
    }

    public boolean removeEndUserUid(String myUid)
    {
        MyEndUser e = findEndUserUid(myUid);
        if ( e == null )
            return false;

        return removeEndUser(e);
    }

    public MyEndUser findEndUserUid(String myUid)
    {
        for ( MyEndUser e : getBaseEndUsers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearEndUsers()
    {
        getEndUsers().clear();
    }

    //##################################################
    //# Sites (collection)
    //##################################################

    public KmCollection<MyCustomerSite> getSites()
    {
        return new KmHibernateCollection<>(
            getBaseSites(),
            (MyCustomer)this,
            MyCustomerSite.Meta.Customer.getAdaptor());
    }

    public boolean hasSites()
    {
        return !getBaseSites().isEmpty();
    }

    public int getSiteCount()
    {
        return getBaseSites().size();
    }

    public List<MyCustomerSite> getBaseSites()
    {
        return sites;
    }

    public MyCustomerSite addSite()
    {
        MyCustomerSite e;
        e = new MyCustomerSite();
        getSites().add(e);
        return e;
    }

    public void addSite(MyCustomerSite e)
    {
        getSites().add(e);
    }

    public boolean removeSite(MyCustomerSite e)
    {
        return getSites().remove(e);
    }

    public boolean removeSiteUid(String myUid)
    {
        MyCustomerSite e = findSiteUid(myUid);
        if ( e == null )
            return false;

        return removeSite(e);
    }

    public MyCustomerSite findSiteUid(String myUid)
    {
        for ( MyCustomerSite e : getBaseSites() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearSites()
    {
        getSites().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyCustomer)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyCustomer)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyCustomer)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyCustomer getCopy()
    {
        return (MyCustomer)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;

        List<MyCustomerContact> old_contacts = contacts;
        contacts = new ArrayList<>();
        for ( MyCustomerContact e : old_contacts )
            addContact(copy(e));

        List<MyEndUser> old_endUsers = endUsers;
        endUsers = new ArrayList<>();
        for ( MyEndUser e : old_endUsers )
            addEndUser(copy(e));

        List<MyCustomerSite> old_sites = sites;
        sites = new ArrayList<>();
        for ( MyCustomerSite e : old_sites )
            addSite(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyCustomerBase) )
            return false;

        MyCustomerBase e = (MyCustomerBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyCustomer e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyCustomer e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getDiscountRate(), e.getDiscountRate()) ) return false;
        if ( !Kmu.isEqual(getAddressStreet1(), e.getAddressStreet1()) ) return false;
        if ( !Kmu.isEqual(getAddressStreet2(), e.getAddressStreet2()) ) return false;
        if ( !Kmu.isEqual(getAddressCity(), e.getAddressCity()) ) return false;
        if ( !Kmu.isEqual(getAddressRegion(), e.getAddressRegion()) ) return false;
        if ( !Kmu.isEqual(getAddressPostalCode(), e.getAddressPostalCode()) ) return false;
        if ( !Kmu.isEqual(getAddressCountry(), e.getAddressCountry()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyCustomer e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyCustomer e)
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
        out.append("MyCustomer");
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
        System.out.println("    DiscountRate = " + discountRate);
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
