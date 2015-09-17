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

public abstract class MyFileBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaFile Meta = MyMetaFile.instance;
    public static final MyFileTools Tools = MyFileTools.instance;
    public static final MyFileValidator Validator = MyFileValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private Integer id;
    private String name;
    private String path;
    private KmTimestamp createdUtcTs;
    private String statusCode;
    private Integer size;
    private Integer partialSize;
    private Integer lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public MyFileBase()
    {
        super();
        setCreatedUtcTs(getNowUtc());
    }

    //##################################################
    //# field (id)
    //##################################################

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer e)
    {
        checkReadOnly();
        e = Validator.getIdValidator().convertOnly(e);
        id = e;
    }

    public void clearId()
    {
        setId(null);
    }

    public boolean hasId()
    {
        return getId() != null;
    }

    public boolean hasId(Integer e)
    {
        return Kmu.isEqual(getId(), e);
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
        name = Kmu.truncate(name, 100, ellipses);
    }

    //##################################################
    //# field (path)
    //##################################################

    public String getPath()
    {
        return path;
    }

    public void setPath(String e)
    {
        checkReadOnly();
        e = Validator.getPathValidator().convertOnly(e);
        path = e;
    }

    public void clearPath()
    {
        setPath(null);
    }

    public boolean hasPath()
    {
        return Kmu.hasValue(getPath());
    }

    public boolean hasPath(String e)
    {
        return Kmu.isEqualIgnoreCase(getPath(), e);
    }

    public void truncatePath()
    {
        truncatePath(false);
    }

    public void truncatePath(boolean ellipses)
    {
        path = Kmu.truncate(path, 100, ellipses);
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
        checkReadOnly();
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

    public MyFileStatus getStatus()
    {
        return MyFileStatus.findCode(getStatusCode());
    }

    public void setStatus(MyFileStatus e)
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

    public boolean hasStatus(MyFileStatus e)
    {
        return getStatus() == e;
    }

    public void setStatusNew()
    {
        setStatus(MyFileStatus.New);
    }

    public boolean isStatusNew()
    {
        return hasStatus(MyFileStatus.New);
    }

    public boolean isNotStatusNew()
    {
        return !isStatusNew();
    }

    public void setStatusReady()
    {
        setStatus(MyFileStatus.Ready);
    }

    public boolean isStatusReady()
    {
        return hasStatus(MyFileStatus.Ready);
    }

    public boolean isNotStatusReady()
    {
        return !isStatusReady();
    }

    public void setStatusDeleted()
    {
        setStatus(MyFileStatus.Deleted);
    }

    public boolean isStatusDeleted()
    {
        return hasStatus(MyFileStatus.Deleted);
    }

    public boolean isNotStatusDeleted()
    {
        return !isStatusDeleted();
    }

    public void setStatusError()
    {
        setStatus(MyFileStatus.Error);
    }

    public boolean isStatusError()
    {
        return hasStatus(MyFileStatus.Error);
    }

    public boolean isNotStatusError()
    {
        return !isStatusError();
    }

    //##################################################
    //# field (size)
    //##################################################

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer e)
    {
        checkReadOnly();
        e = Validator.getSizeValidator().convertOnly(e);
        size = e;
    }

    public void clearSize()
    {
        setSize(null);
    }

    public boolean hasSize()
    {
        return getSize() != null;
    }

    public boolean hasSize(Integer e)
    {
        return Kmu.isEqual(getSize(), e);
    }

    //##################################################
    //# field (partialSize)
    //##################################################

    public Integer getPartialSize()
    {
        return partialSize;
    }

    public void setPartialSize(Integer e)
    {
        checkReadOnly();
        e = Validator.getPartialSizeValidator().convertOnly(e);
        partialSize = e;
    }

    public void clearPartialSize()
    {
        setPartialSize(null);
    }

    public boolean hasPartialSize()
    {
        return getPartialSize() != null;
    }

    public boolean hasPartialSize(Integer e)
    {
        return Kmu.isEqual(getPartialSize(), e);
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyFile)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyFile)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyFile)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyFile getCopy()
    {
        return (MyFile)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        id = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyFileBase) )
            return false;

        MyFileBase e = (MyFileBase)o;
        return Kmu.isEqual(getId(), e.getId());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getId());
    }

    public boolean isSame(MyFile e)
    {
        if ( !Kmu.isEqual(getId(), e.getId()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyFile e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getPath(), e.getPath()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getStatusCode(), e.getStatusCode()) ) return false;
        if ( !Kmu.isEqual(getSize(), e.getSize()) ) return false;
        if ( !Kmu.isEqual(getPartialSize(), e.getPartialSize()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyFile e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyFile e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyFile");
        sb.append("(");
        sb.append("Id=");
        sb.append(id);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Id = " + id);
        System.out.println("    Name = " + name);
        System.out.println("    Path = " + path);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    StatusCode = " + statusCode);
        System.out.println("    Size = " + size);
        System.out.println("    PartialSize = " + partialSize);
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
        sb.append(f.formatAny(id));
        return sb.toString();
    }

}
