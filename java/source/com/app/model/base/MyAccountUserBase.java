//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
import com.app.model.MyAccountUserTools;
import com.app.model.MyAccountUserValidator;
import com.app.model.MyUser;
import com.app.model.core.MyAbstractDomain;
import com.app.model.meta.MyMetaAccountUser;

import com.kodemore.collection.KmMap;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.KmProperties;
import com.kodemore.utility.Kmu;

public abstract class MyAccountUserBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAccountUser Meta = MyMetaAccountUser.instance;
    public static final MyAccountUserTools Tools = MyAccountUserTools.instance;
    public static final MyAccountUserValidator Validator = MyAccountUserValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String roleCode;
    private Integer lockVersion;
    private MyAccount account;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyAccountUserBase()
    {
        super();
        setUid(newUid());
        setRoleCode(MyAccountUserRole.User.getCode());
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

    public MyAccountUserRole getRole()
    {
        return MyAccountUserRole.findCode(getRoleCode());
    }

    public void setRole(MyAccountUserRole e)
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

    public boolean hasRole(MyAccountUserRole e)
    {
        return getRole() == e;
    }

    public void setRoleOwner()
    {
        setRole(MyAccountUserRole.Owner);
    }

    public boolean isRoleOwner()
    {
        return hasRole(MyAccountUserRole.Owner);
    }

    public boolean isNotRoleOwner()
    {
        return !isRoleOwner();
    }

    public void setRoleManager()
    {
        setRole(MyAccountUserRole.Manager);
    }

    public boolean isRoleManager()
    {
        return hasRole(MyAccountUserRole.Manager);
    }

    public boolean isNotRoleManager()
    {
        return !isRoleManager();
    }

    public void setRoleUser()
    {
        setRole(MyAccountUserRole.User);
    }

    public boolean isRoleUser()
    {
        return hasRole(MyAccountUserRole.User);
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyAccountUser)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAccountUser)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAccountUser)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAccountUser getCopy()
    {
        return (MyAccountUser)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        account = null;
        user = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyAccountUserBase) )
            return false;

        MyAccountUserBase e = (MyAccountUserBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAccountUser e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAccountUser e)
    {
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getRoleName(), e.getRoleName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAccountUser e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAccountUser e)
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
        sb.append("MyAccountUser");
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
