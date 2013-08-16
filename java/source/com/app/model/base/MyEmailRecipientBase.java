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

public abstract class MyEmailRecipientBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaEmailRecipient Meta = MyMetaEmailRecipient.instance;
    public static final MyEmailRecipientTools Tools = MyEmailRecipientTools.instance;
    public static final MyEmailRecipientValidator Validator = MyEmailRecipientValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String address;
    private String typeCode;
    private Integer lockVersion;
    private MyEmail email;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailRecipientBase()
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
        return Kmu.isEqual(getUid(), e);
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
    //# field (address)
    //##################################################

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String e)
    {
        checkReadOnly();
        e = Validator.getAddressValidator().convertOnly(e);
        address = e;
    }

    public void clearAddress()
    {
        setAddress(null);
    }

    public boolean hasAddress()
    {
        return Kmu.hasValue(getAddress());
    }

    public boolean hasAddress(String e)
    {
        return Kmu.isEqual(getAddress(), e);
    }

    public void truncateAddress()
    {
        truncateAddress(false);
    }

    public void truncateAddress(boolean ellipses)
    {
        address = Kmu.truncate(address, 50, ellipses);
    }

    //##################################################
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        checkReadOnly();
        e = Validator.getTypeCodeValidator().convertOnly(e);
        typeCode = e;
    }

    public void clearTypeCode()
    {
        setTypeCode(null);
    }

    public boolean hasTypeCode()
    {
        return Kmu.hasValue(getTypeCode());
    }

    public boolean hasTypeCode(String e)
    {
        return Kmu.isEqual(getTypeCode(), e);
    }

    public void truncateTypeCode()
    {
        truncateTypeCode(false);
    }

    public void truncateTypeCode(boolean ellipses)
    {
        typeCode = Kmu.truncate(typeCode, 1, ellipses);
    }

    public MyEmailRecipientType getType()
    {
        return MyEmailRecipientType.findCode(getTypeCode());
    }

    public void setType(MyEmailRecipientType e)
    {
        if ( e == null )
            setTypeCode(null);
        else
            setTypeCode(e.getCode());
    }

    public boolean hasType()
    {
        return getType() != null;
    }

    public boolean hasType(MyEmailRecipientType e)
    {
        return getType() == e;
    }

    public void setTypeTo()
    {
        setType(MyEmailRecipientType.To);
    }

    public boolean isTypeTo()
    {
        return hasType(MyEmailRecipientType.To);
    }

    public boolean isNotTypeTo()
    {
        return !isTypeTo();
    }

    public void setTypeCc()
    {
        setType(MyEmailRecipientType.Cc);
    }

    public boolean isTypeCc()
    {
        return hasType(MyEmailRecipientType.Cc);
    }

    public boolean isNotTypeCc()
    {
        return !isTypeCc();
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
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return Kmu.getName(getType());
    }

    public boolean hasTypeName()
    {
        return Kmu.hasValue(getTypeName());
    }

    public boolean hasTypeName(String e)
    {
        return Kmu.isEqual(getTypeName(), e);
    }

    //##################################################
    //# email
    //##################################################

    public MyEmail getEmail()
    {
        return email;
    }

    public void setEmail(MyEmail e)
    {
        checkReadOnly();
        email = e;
    }

    public void _setEmail(MyEmail e)
    {
        checkReadOnly();
        email = e;
    }

    public void clearEmail()
    {
        setEmail(null);
    }

    public boolean hasEmail()
    {
        return getEmail() != null;
    }

    public boolean hasEmail(MyEmail e)
    {
        return Kmu.isEqual(getEmail(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyEmailRecipient)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyEmailRecipient)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyEmailRecipient)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyEmailRecipient getCopy()
    {
        return (MyEmailRecipient)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        email = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyEmailRecipientBase) )
            return false;

        MyEmailRecipientBase e = (MyEmailRecipientBase) o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyEmailRecipient e)
    {
        if ( ! Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyEmailRecipient e)
    {
        if ( ! Kmu.isEqual(getAddress(), e.getAddress()) ) return false;
        if ( ! Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( ! Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( ! Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyEmailRecipient e)
    {
        return ! isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyEmailRecipient e)
    {
        return ! isSameIgnoringKey(e);
    }

    //##################################################
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("uid") )
            setUid(p.getString("uid"));

        if ( p.hasKey("address") )
            setAddress(p.getString("address"));

        if ( p.hasKey("typeCode") )
            setTypeCode(p.getString("typeCode"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasAddress() )
            p.setString("address", getAddress());

        if ( hasTypeCode() )
            p.setString("typeCode", getTypeCode());

        if ( hasLockVersion() )
            p.setInteger("lockVersion", getLockVersion());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyEmailRecipient");
        sb.append("(");
        sb.append("Uid=");
        sb.append(uid);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    Address = " + address);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(uid));
        return sb.toString();
    }

}
