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

public abstract class MyCustomerContactBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaCustomerContact Meta = MyMetaCustomerContact.instance;
    public static final MyCustomerContactTools Tools = MyCustomerContactTools.instance;
    public static final MyCustomerContactValidator Validator = MyCustomerContactValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private String title;
    private String phone;
    private String email;
    private Boolean orderNotifications;
    private Integer lockVersion;
    private MyCustomer customer;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactBase()
    {
        super();
        setUid(newUid());
        setOrderNotifications(false);
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
    //# field (title)
    //##################################################

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String e)
    {
        checkReadOnly();
        e = Validator.getTitleValidator().convertOnly(e);
        title = e;
    }

    public void clearTitle()
    {
        setTitle(null);
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(getTitle());
    }

    public boolean hasTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getTitle(), e);
    }

    public void truncateTitle()
    {
        truncateTitle(false);
    }

    public void truncateTitle(boolean ellipses)
    {
        title = Kmu.truncate(title, 50, ellipses);
    }

    //##################################################
    //# field (phone)
    //##################################################

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String e)
    {
        checkReadOnly();
        e = Validator.getPhoneValidator().convertOnly(e);
        phone = e;
    }

    public void clearPhone()
    {
        setPhone(null);
    }

    public boolean hasPhone()
    {
        return Kmu.hasValue(getPhone());
    }

    public boolean hasPhone(String e)
    {
        return Kmu.isEqualIgnoreCase(getPhone(), e);
    }

    public void truncatePhone()
    {
        truncatePhone(false);
    }

    public void truncatePhone(boolean ellipses)
    {
        phone = Kmu.truncate(phone, 30, ellipses);
    }

    //##################################################
    //# field (email)
    //##################################################

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        checkReadOnly();
        e = Validator.getEmailValidator().convertOnly(e);
        email = e;
    }

    public void clearEmail()
    {
        setEmail(null);
    }

    public boolean hasEmail()
    {
        return Kmu.hasValue(getEmail());
    }

    public boolean hasEmail(String e)
    {
        return Kmu.isEqualIgnoreCase(getEmail(), e);
    }

    public void truncateEmail()
    {
        truncateEmail(false);
    }

    public void truncateEmail(boolean ellipses)
    {
        email = Kmu.truncate(email, 50, ellipses);
    }

    //##################################################
    //# field (orderNotifications)
    //##################################################

    public Boolean getOrderNotifications()
    {
        return orderNotifications;
    }

    public void setOrderNotifications(Boolean e)
    {
        checkReadOnly();
        e = Validator.getOrderNotificationsValidator().convertOnly(e);
        orderNotifications = e;
    }

    public void clearOrderNotifications()
    {
        setOrderNotifications(null);
    }

    public boolean hasOrderNotifications()
    {
        return getOrderNotifications() != null;
    }

    public boolean hasOrderNotifications(Boolean e)
    {
        return Kmu.isEqual(getOrderNotifications(), e);
    }

    public boolean isOrderNotifications()
    {
        if ( getOrderNotifications() == null )
            return false;
        return getOrderNotifications();
    }

    public boolean isNotOrderNotifications()
    {
        return !isOrderNotifications();
    }

    public boolean isOrderNotifications(Boolean b)
    {
        return Kmu.isEqual(getOrderNotifications(), b);
    }

    public void toggleOrderNotifications()
    {
        setOrderNotifications(!getOrderNotifications());
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyCustomerContact)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyCustomerContact)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyCustomerContact)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyCustomerContact getCopy()
    {
        return (MyCustomerContact)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        customer = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyCustomerContactBase) )
            return false;

        MyCustomerContactBase e = (MyCustomerContactBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyCustomerContact e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyCustomerContact e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getTitle(), e.getTitle()) ) return false;
        if ( !Kmu.isEqual(getPhone(), e.getPhone()) ) return false;
        if ( !Kmu.isEqual(getEmail(), e.getEmail()) ) return false;
        if ( !Kmu.isEqual(getOrderNotifications(), e.getOrderNotifications()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyCustomerContact e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyCustomerContact e)
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
        out.append("MyCustomerContact");
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
        System.out.println("    Title = " + title);
        System.out.println("    Phone = " + phone);
        System.out.println("    Email = " + email);
        System.out.println("    OrderNotifications = " + orderNotifications);
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
