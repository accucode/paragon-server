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

public abstract class MyAttentionMemberBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAttentionMember Meta = MyMetaAttentionMember.instance;
    public static final MyAttentionMemberTools Tools = MyAttentionMemberTools.instance;
    public static final MyAttentionMemberValidator Validator = MyAttentionMemberValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private Integer lockVersion;
    private MyAttentionGroup group;
    private MyMember member;

    //##################################################
    //# constructor
    //##################################################

    public MyAttentionMemberBase()
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
    //# group
    //##################################################

    public MyAttentionGroup getGroup()
    {
        return group;
    }

    public void setGroup(MyAttentionGroup e)
    {
        checkReadOnly();
        group = e;
    }

    public void _setGroup(MyAttentionGroup e)
    {
        checkReadOnly();
        group = e;
    }

    public void clearGroup()
    {
        setGroup(null);
    }

    public boolean hasGroup()
    {
        return getGroup() != null;
    }

    public boolean hasGroup(MyAttentionGroup e)
    {
        return Kmu.isEqual(getGroup(), e);
    }

    public String getGroupName()
    {
        if ( hasGroup() )
            return getGroup().getName();
        return null;
    }

    public void setGroupName(String e)
    {
        getGroup().setName(e);
    }

    public boolean hasGroupName()
    {
        return hasGroup() && getGroup().hasName();
    }

    public boolean hasGroupName(String e)
    {
        return hasGroup() && getGroup().hasName(e);
    }

    //##################################################
    //# member
    //##################################################

    public MyMember getMember()
    {
        return member;
    }

    public void setMember(MyMember e)
    {
        checkReadOnly();
        member = e;
    }

    public void _setMember(MyMember e)
    {
        checkReadOnly();
        member = e;
    }

    public void clearMember()
    {
        setMember(null);
    }

    public boolean hasMember()
    {
        return getMember() != null;
    }

    public boolean hasMember(MyMember e)
    {
        return Kmu.isEqual(getMember(), e);
    }

    public String getUserName()
    {
        if ( hasMember() )
            return getMember().getUserName();
        return null;
    }

    public void setUserName(String e)
    {
        getMember().setUserName(e);
    }

    public boolean hasUserName()
    {
        return hasMember() && getMember().hasUserName();
    }

    public boolean hasUserName(String e)
    {
        return hasMember() && getMember().hasUserName(e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyAttentionMember)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAttentionMember)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAttentionMember)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAttentionMember getCopy()
    {
        return (MyAttentionMember)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        group = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyAttentionMemberBase) )
            return false;

        MyAttentionMemberBase e = (MyAttentionMemberBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAttentionMember e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAttentionMember e)
    {
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAttentionMember e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAttentionMember e)
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
        out.append("MyAttentionMember");
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
