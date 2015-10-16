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

public abstract class MyEndUserSiteBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaEndUserSite Meta = MyMetaEndUserSite.instance;
    public static final MyEndUserSiteTools Tools = MyEndUserSiteTools.instance;
    public static final MyEndUserSiteValidator Validator = MyEndUserSiteValidator.instance;

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
    private MyEndUser endUser;

    //##################################################
    //# constructor
    //##################################################

    public MyEndUserSiteBase()
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
    //# endUser
    //##################################################

    public MyEndUser getEndUser()
    {
        return endUser;
    }

    public void setEndUser(MyEndUser e)
    {
        checkReadOnly();
        endUser = e;
    }

    public void _setEndUser(MyEndUser e)
    {
        checkReadOnly();
        endUser = e;
    }

    public void clearEndUser()
    {
        setEndUser(null);
    }

    public boolean hasEndUser()
    {
        return getEndUser() != null;
    }

    public boolean hasEndUser(MyEndUser e)
    {
        return Kmu.isEqual(getEndUser(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyEndUserSite)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyEndUserSite)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyEndUserSite)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyEndUserSite getCopy()
    {
        return (MyEndUserSite)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        endUser = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyEndUserSiteBase) )
            return false;

        MyEndUserSiteBase e = (MyEndUserSiteBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyEndUserSite e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyEndUserSite e)
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

    public boolean isDifferent(MyEndUserSite e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyEndUserSite e)
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
        out.append("MyEndUserSite");
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
