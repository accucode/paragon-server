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

public abstract class MyShipCarrierBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaShipCarrier Meta = MyMetaShipCarrier.instance;
    public static final MyShipCarrierTools Tools = MyShipCarrierTools.instance;
    public static final MyShipCarrierValidator Validator = MyShipCarrierValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private Integer lockVersion;
    private MyProject project;
    private List<MyShipMethod> shipMethods;

    //##################################################
    //# constructor
    //##################################################

    public MyShipCarrierBase()
    {
        super();
        setUid(newUid());
        shipMethods = new ArrayList<>();
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
    //# field (methodNames)
    //##################################################

    public abstract String getMethodNames();

    public boolean hasMethodNames()
    {
        return Kmu.hasValue(getMethodNames());
    }

    public boolean hasMethodNames(String e)
    {
        return Kmu.isEqualIgnoreCase(getMethodNames(), e);
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


    //##################################################
    //# ShipMethods (collection)
    //##################################################

    public KmCollection<MyShipMethod> getShipMethods()
    {
        return new KmHibernateCollection<>(
            getBaseShipMethods(),
            (MyShipCarrier)this,
            MyShipMethod.Meta.Carrier.getAdaptor());
    }

    public boolean hasShipMethods()
    {
        return !getBaseShipMethods().isEmpty();
    }

    public int getShipMethodCount()
    {
        return getBaseShipMethods().size();
    }

    public List<MyShipMethod> getBaseShipMethods()
    {
        return shipMethods;
    }

    public MyShipMethod addShipMethod()
    {
        MyShipMethod e;
        e = new MyShipMethod();
        getShipMethods().add(e);
        return e;
    }

    public void addShipMethod(MyShipMethod e)
    {
        getShipMethods().add(e);
    }

    public boolean removeShipMethod(MyShipMethod e)
    {
        return getShipMethods().remove(e);
    }

    public boolean removeShipMethodUid(String myUid)
    {
        MyShipMethod e = findShipMethodUid(myUid);
        if ( e == null )
            return false;

        return removeShipMethod(e);
    }

    public MyShipMethod findShipMethodUid(String myUid)
    {
        for ( MyShipMethod e : getBaseShipMethods() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearShipMethods()
    {
        getShipMethods().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyShipCarrier)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyShipCarrier)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyShipCarrier)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyShipCarrier getCopy()
    {
        return (MyShipCarrier)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;

        List<MyShipMethod> old_shipMethods = shipMethods;
        shipMethods = new ArrayList<>();
        for ( MyShipMethod e : old_shipMethods )
            addShipMethod(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyShipCarrierBase) )
            return false;

        MyShipCarrierBase e = (MyShipCarrierBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyShipCarrier e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyShipCarrier e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getMethodNames(), e.getMethodNames()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        return true;
    }

    public boolean isDifferent(MyShipCarrier e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyShipCarrier e)
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

        if ( p.hasKey("name") )
            setName(p.getString("name"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasName() )
            p.setString("name", getName());

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
        sb.append("MyShipCarrier");
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
        System.out.println("    Name = " + name);
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
