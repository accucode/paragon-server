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
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyDownloadBase
    extends MyAbstractDaoDomain
    implements MyUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaDownload Meta = MyMetaDownload.instance;
    public static final MyDownloadTools Tools = MyDownloadTools.instance;
    public static final MyDownloadValidator Validator = MyDownloadValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private String name;
    private String typeCode;
    private String fileName;
    private KmBlob bytes;
    private Integer lockVersion;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyDownloadBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setTypeCode(MyUserRole.Other.getCode());
        setLockVersion(0);
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
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        e = Validator.getCreatedUtcTsValidator().convertOnly(e);
        createdUtcTs = e;
    }

    public void clearCreatedUtcTs()
    {
        setCreatedUtcTs(null);
    }

    public boolean hasCreatedUtcTs()
    {
        return getCreatedUtcTs() != null;
    }

    public boolean hasCreatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedUtcTs(), e);
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
        name = Kmu.truncate(name, 200, ellipses);
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
        return Kmu.isEqualIgnoreCase(getTypeCode(), e);
    }

    public void truncateTypeCode()
    {
        truncateTypeCode(false);
    }

    public void truncateTypeCode(boolean ellipses)
    {
        typeCode = Kmu.truncate(typeCode, 30, ellipses);
    }

    public MyDownloadType getType()
    {
        return MyDownloadType.findCode(getTypeCode());
    }

    public void setType(MyDownloadType e)
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

    public boolean hasType(MyDownloadType e)
    {
        return getType() == e;
    }

    public void setTypeFile()
    {
        setType(MyDownloadType.File);
    }

    public boolean isTypeFile()
    {
        return hasType(MyDownloadType.File);
    }

    public boolean isNotTypeFile()
    {
        return !isTypeFile();
    }

    public void setTypeBytes()
    {
        setType(MyDownloadType.Bytes);
    }

    public boolean isTypeBytes()
    {
        return hasType(MyDownloadType.Bytes);
    }

    public boolean isNotTypeBytes()
    {
        return !isTypeBytes();
    }

    //##################################################
    //# field (fileName)
    //##################################################

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String e)
    {
        e = Validator.getFileNameValidator().convertOnly(e);
        fileName = e;
    }

    public void clearFileName()
    {
        setFileName(null);
    }

    public boolean hasFileName()
    {
        return Kmu.hasValue(getFileName());
    }

    public boolean hasFileName(String e)
    {
        return Kmu.isEqualIgnoreCase(getFileName(), e);
    }

    public void truncateFileName()
    {
        truncateFileName(false);
    }

    public void truncateFileName(boolean ellipses)
    {
        fileName = Kmu.truncate(fileName, 50, ellipses);
    }

    //##################################################
    //# field (bytes)
    //##################################################

    public KmBlob getBytes()
    {
        return bytes;
    }

    public void setBytes(KmBlob e)
    {
        e = Validator.getBytesValidator().convertOnly(e);
        bytes = e;
    }

    public void clearBytes()
    {
        setBytes(null);
    }

    public boolean hasBytes()
    {
        return getBytes() != null;
    }

    public boolean hasBytes(KmBlob e)
    {
        return Kmu.isEqual(getBytes(), e);
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
    //# field (displayString)
    //##################################################

    public abstract String getDisplayString();

    public boolean hasDisplayString()
    {
        return Kmu.hasValue(getDisplayString());
    }

    public boolean hasDisplayString(String e)
    {
        return Kmu.isEqualIgnoreCase(getDisplayString(), e);
    }

    //##################################################
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return KmEnumIF.getLabelFor(getType());
    }

    public boolean hasTypeName()
    {
        return Kmu.hasValue(getTypeName());
    }

    public boolean hasTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeName(), e);
    }

    //##################################################
    //# field (createdLocalTs)
    //##################################################

    public final KmTimestamp getCreatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTs()
    {
        return getCreatedLocalTs() != null;
    }

    public boolean hasCreatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedLocalTs(), e);
    }

    //##################################################
    //# field (createdLocalTsMessage)
    //##################################################

    public final String getCreatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTsMessage()
    {
        return Kmu.hasValue(getCreatedLocalTsMessage());
    }

    public boolean hasCreatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getCreatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (createdLocalDate)
    //##################################################

    public final KmDate getCreatedLocalDate()
    {
        return KmTimestampUtility.getDate(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalDate()
    {
        return getCreatedLocalDate() != null;
    }

    public boolean hasCreatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getCreatedLocalDate(), e);
    }

    //##################################################
    //# field (createdLocalTime)
    //##################################################

    public final KmTime getCreatedLocalTime()
    {
        return KmTimestampUtility.getTime(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalTime()
    {
        return getCreatedLocalTime() != null;
    }

    public boolean hasCreatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getCreatedLocalTime(), e);
    }

    //##################################################
    //# user
    //##################################################

    public MyUser getUser()
    {
        return user;
    }

    public void setUser(MyUser e)
    {
        user = e;
    }

    public void _setUser(MyUser e)
    {
        user = e;
    }

    public void clearUser()
    {
        setUser(null);
    }

    public boolean hasUser()
    {
        return getUser() != null;
    }

    public boolean hasUser(MyUser e)
    {
        return Kmu.isEqual(getUser(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyDownload)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyDownload)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyDownload)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyDownload getCopy()
    {
        return (MyDownload)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyDownload getBasicCopy()
    {
        MyDownload e;
        e = new MyDownload();
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setName(getName());
        e.setTypeCode(getTypeCode());
        e.setFileName(getFileName());
        e.setBytes(getBytes());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyDownloadBase) )
            return false;

        MyDownloadBase e = (MyDownloadBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyDownload e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyDownload e)
    {
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getFileName(), e.getFileName()) ) return false;
        if ( !Kmu.isEqual(getBytes(), e.getBytes()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyDownload e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyDownload e)
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
        out.append("MyDownload");
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
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Name = " + name);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    FileName = " + fileName);
        System.out.println("    Bytes = " + bytes);
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

    public void daoTouch()
    {
        setLockVersion(getLockVersion() + 1);
    }

}
