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

public abstract class MyMemberSkillBase
    extends MyAbstractDomain
    implements MyDomainIF
    ,KmSequenceIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaMemberSkill Meta = MyMetaMemberSkill.instance;
    public static final MyMemberSkillTools Tools = MyMemberSkillTools.instance;
    public static final MyMemberSkillValidator Validator = MyMemberSkillValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private Integer sequence;
    private Integer lockVersion;
    private MyMember member;
    private MySkill skill;

    //##################################################
    //# constructor
    //##################################################

    public MyMemberSkillBase()
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
    //# field (sequence)
    //##################################################

    @Override
    public Integer getSequence()
    {
        return sequence;
    }

    @Override
    public void setSequence(Integer e)
    {
        checkReadOnly();
        e = Validator.getSequenceValidator().convertOnly(e);
        sequence = e;
    }

    public void clearSequence()
    {
        setSequence(null);
    }

    public boolean hasSequence()
    {
        return getSequence() != null;
    }

    public boolean hasSequence(Integer e)
    {
        return Kmu.isEqual(getSequence(), e);
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

    //##################################################
    //# skill
    //##################################################

    public MySkill getSkill()
    {
        return skill;
    }

    public void setSkill(MySkill e)
    {
        checkReadOnly();
        skill = e;
    }

    public void _setSkill(MySkill e)
    {
        checkReadOnly();
        skill = e;
    }

    public void clearSkill()
    {
        setSkill(null);
    }

    public boolean hasSkill()
    {
        return getSkill() != null;
    }

    public boolean hasSkill(MySkill e)
    {
        return Kmu.isEqual(getSkill(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyMemberSkill)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyMemberSkill)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyMemberSkill)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyMemberSkill getCopy()
    {
        return (MyMemberSkill)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        member = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyMemberSkillBase) )
            return false;

        MyMemberSkillBase e = (MyMemberSkillBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyMemberSkill e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyMemberSkill e)
    {
        if ( !Kmu.isEqual(getSequence(), e.getSequence()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyMemberSkill e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyMemberSkill e)
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
        out.append("MyMemberSkill");
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
        System.out.println("    Sequence = " + sequence);
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
