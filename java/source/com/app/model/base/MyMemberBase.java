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

public abstract class MyMemberBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaMember Meta = MyMetaMember.instance;
    public static final MyMemberTools Tools = MyMemberTools.instance;
    public static final MyMemberValidator Validator = MyMemberValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String roleCode;
    private Integer lockVersion;
    private MyProject project;
    private MyUser user;
    private List<MyMemberSkill> memberSkills;

    //##################################################
    //# constructor
    //##################################################

    public MyMemberBase()
    {
        super();
        setUid(newUid());
        setRoleCode(MyMemberRole.Worker.getCode());
        memberSkills = new ArrayList<>();
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
    //# field (roleCode)
    //##################################################

    public String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(String e)
    {
        checkReadOnly();
        e = Validator.getRoleCodeValidator().convertOnly(e);
        roleCode = e;
    }

    public void clearRoleCode()
    {
        setRoleCode(null);
    }

    public boolean hasRoleCode()
    {
        return Kmu.hasValue(getRoleCode());
    }

    public boolean hasRoleCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getRoleCode(), e);
    }

    public void truncateRoleCode()
    {
        truncateRoleCode(false);
    }

    public void truncateRoleCode(boolean ellipses)
    {
        roleCode = Kmu.truncate(roleCode, 1, ellipses);
    }

    public MyMemberRole getRole()
    {
        return MyMemberRole.findCode(getRoleCode());
    }

    public void setRole(MyMemberRole e)
    {
        if ( e == null )
            setRoleCode(null);
        else
            setRoleCode(e.getCode());
    }

    public boolean hasRole()
    {
        return getRole() != null;
    }

    public boolean hasRole(MyMemberRole e)
    {
        return getRole() == e;
    }

    public void setRoleManager()
    {
        setRole(MyMemberRole.Manager);
    }

    public boolean isRoleManager()
    {
        return hasRole(MyMemberRole.Manager);
    }

    public boolean isNotRoleManager()
    {
        return !isRoleManager();
    }

    public void setRoleWorker()
    {
        setRole(MyMemberRole.Worker);
    }

    public boolean isRoleWorker()
    {
        return hasRole(MyMemberRole.Worker);
    }

    public boolean isNotRoleWorker()
    {
        return !isRoleWorker();
    }

    public void setRoleCustomer()
    {
        setRole(MyMemberRole.Customer);
    }

    public boolean isRoleCustomer()
    {
        return hasRole(MyMemberRole.Customer);
    }

    public boolean isNotRoleCustomer()
    {
        return !isRoleCustomer();
    }

    //##################################################
    //# field (subtitle)
    //##################################################

    public abstract String getSubtitle();

    public boolean hasSubtitle()
    {
        return Kmu.hasValue(getSubtitle());
    }

    public boolean hasSubtitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getSubtitle(), e);
    }

    //##################################################
    //# field (skillNames)
    //##################################################

    public abstract String getSkillNames();

    public boolean hasSkillNames()
    {
        return Kmu.hasValue(getSkillNames());
    }

    public boolean hasSkillNames(String e)
    {
        return Kmu.isEqualIgnoreCase(getSkillNames(), e);
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
    //# field (roleName)
    //##################################################

    public final String getRoleName()
    {
        return Kmu.getName(getRole());
    }

    public boolean hasRoleName()
    {
        return Kmu.hasValue(getRoleName());
    }

    public boolean hasRoleName(String e)
    {
        return Kmu.isEqualIgnoreCase(getRoleName(), e);
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

    public String getProjectName()
    {
        if ( hasProject() )
            return getProject().getName();
        return null;
    }

    public void setProjectName(String e)
    {
        getProject().setName(e);
    }

    public boolean hasProjectName()
    {
        return hasProject() && getProject().hasName();
    }

    public boolean hasProjectName(String e)
    {
        return hasProject() && getProject().hasName(e);
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
        checkReadOnly();
        user = e;
    }

    public void _setUser(MyUser e)
    {
        checkReadOnly();
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

    public String getUserName()
    {
        if ( hasUser() )
            return getUser().getName();
        return null;
    }

    public void setUserName(String e)
    {
        getUser().setName(e);
    }

    public boolean hasUserName()
    {
        return hasUser() && getUser().hasName();
    }

    public boolean hasUserName(String e)
    {
        return hasUser() && getUser().hasName(e);
    }

    public String getUserEmail()
    {
        if ( hasUser() )
            return getUser().getEmail();
        return null;
    }

    public void setUserEmail(String e)
    {
        getUser().setEmail(e);
    }

    public boolean hasUserEmail()
    {
        return hasUser() && getUser().hasEmail();
    }

    public boolean hasUserEmail(String e)
    {
        return hasUser() && getUser().hasEmail(e);
    }


    //##################################################
    //# MemberSkills (collection)
    //##################################################

    public KmCollection<MyMemberSkill> getMemberSkills()
    {
        return new KmHibernateCollection<>(
            getBaseMemberSkills(),
            (MyMember)this,
            MyMemberSkill.Meta.Member.getAdaptor());
    }

    public KmList<MyMemberSkill> getSortedMemberSkills()
    {
        KmList<MyMemberSkill> v;
        v = getMemberSkills().toList();
        v.sortOn(MyMemberSkill.Meta.Sequence);
        return v;
    }

    public boolean hasMemberSkills()
    {
        return !getBaseMemberSkills().isEmpty();
    }

    public int getMemberSkillCount()
    {
        return getBaseMemberSkills().size();
    }

    public List<MyMemberSkill> getBaseMemberSkills()
    {
        return memberSkills;
    }

    public MyMemberSkill addMemberSkill()
    {
        MyMemberSkill e;
        e = new MyMemberSkill();
        e.setSequence(getMemberSkills().getNextSequence());
        getMemberSkills().add(e);
        return e;
    }

    public void addMemberSkill(MyMemberSkill e)
    {
        getMemberSkills().add(e);
    }

    public boolean removeMemberSkill(MyMemberSkill e)
    {
        return getMemberSkills().remove(e);
    }

    public boolean removeMemberSkillUid(String myUid)
    {
        MyMemberSkill e = findMemberSkillUid(myUid);
        if ( e == null )
            return false;

        return removeMemberSkill(e);
    }

    public MyMemberSkill findMemberSkillUid(String myUid)
    {
        for ( MyMemberSkill e : getBaseMemberSkills() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearMemberSkills()
    {
        getMemberSkills().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyMember)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyMember)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyMember)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyMember getCopy()
    {
        return (MyMember)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;

        List<MyMemberSkill> old_memberSkills = memberSkills;
        memberSkills = new ArrayList<>();
        for ( MyMemberSkill e : old_memberSkills )
            addMemberSkill(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyMemberBase) )
            return false;

        MyMemberBase e = (MyMemberBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyMember e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyMember e)
    {
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getSubtitle(), e.getSubtitle()) ) return false;
        if ( !Kmu.isEqual(getSkillNames(), e.getSkillNames()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getRoleName(), e.getRoleName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyMember e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyMember e)
    {
        return !isSameIgnoringKey(e);
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

        if ( p.hasKey("roleCode") )
            setRoleCode(p.getString("roleCode"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasRoleCode() )
            p.setString("roleCode", getRoleCode());

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
        sb.append("MyMember");
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
        System.out.println("    RoleCode = " + roleCode);
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
