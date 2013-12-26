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

public abstract class MyUserAccountBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaUserAccount Meta = MyMetaUserAccount.instance;
    public static final MyUserAccountTools Tools = MyUserAccountTools.instance;
    public static final MyUserAccountValidator Validator = MyUserAccountValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String roleCode;
    private Integer lockVersion;
    private MyUser user;
    private MyAccount account;

    //##################################################
    //# constructor
    //##################################################

    public MyUserAccountBase()
    {
        super();
        setUid(newUid());
        setRoleCode(MyUserAccountRole.User.getCode());
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

    public MyUserAccountRole getRole()
    {
        return MyUserAccountRole.findCode(getRoleCode());
    }

    public void setRole(MyUserAccountRole e)
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

    public boolean hasRole(MyUserAccountRole e)
    {
        return getRole() == e;
    }

    public void setRoleOwner()
    {
        setRole(MyUserAccountRole.Owner);
    }

    public boolean isRoleOwner()
    {
        return hasRole(MyUserAccountRole.Owner);
    }

    public boolean isNotRoleOwner()
    {
        return !isRoleOwner();
    }

    public void setRoleManager()
    {
        setRole(MyUserAccountRole.Manager);
    }

    public boolean isRoleManager()
    {
        return hasRole(MyUserAccountRole.Manager);
    }

    public boolean isNotRoleManager()
    {
        return !isRoleManager();
    }

    public void setRoleUser()
    {
        setRole(MyUserAccountRole.User);
    }

    public boolean isRoleUser()
    {
        return hasRole(MyUserAccountRole.User);
    }

    public boolean isNotRoleUser()
    {
        return !isRoleUser();
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
    //# account
    //##################################################

    public MyAccount getAccount()
    {
        return account;
    }

    public void setAccount(MyAccount e)
    {
        checkReadOnly();
        account = e;
    }

    public void _setAccount(MyAccount e)
    {
        checkReadOnly();
        account = e;
    }

    public void clearAccount()
    {
        setAccount(null);
    }

    public boolean hasAccount()
    {
        return getAccount() != null;
    }

    public boolean hasAccount(MyAccount e)
    {
        return Kmu.isEqual(getAccount(), e);
    }

    public String getAccountName()
    {
        if ( hasAccount() )
            return getAccount().getName();
        return null;
    }

    public void setAccountName(String e)
    {
        getAccount().setName(e);
    }

    public boolean hasAccountName()
    {
        return hasAccount() && getAccount().hasName();
    }

    public boolean hasAccountName(String e)
    {
        return hasAccount() && getAccount().hasName(e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyUserAccount)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyUserAccount)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyUserAccount)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyUserAccount getCopy()
    {
        return (MyUserAccount)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        user = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyUserAccountBase) )
            return false;

        MyUserAccountBase e = (MyUserAccountBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyUserAccount e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyUserAccount e)
    {
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getRoleName(), e.getRoleName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyUserAccount e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyUserAccount e)
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
        sb.append("MyUserAccount");
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
