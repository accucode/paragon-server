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

public abstract class MyNamedCountVoBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaNamedCountVo Meta = MyMetaNamedCountVo.instance;
    public static final MyNamedCountVoTools Tools = MyNamedCountVoTools.instance;
    public static final MyNamedCountVoValidator Validator = MyNamedCountVoValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String name;
    private Integer count;

    //##################################################
    //# constructor
    //##################################################

    public MyNamedCountVoBase()
    {
        super();
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
        return Kmu.isEqual(getName(), e);
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
    //# field (count)
    //##################################################

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer e)
    {
        checkReadOnly();
        e = Validator.getCountValidator().convertOnly(e);
        count = e;
    }

    public void clearCount()
    {
        setCount(null);
    }

    public boolean hasCount()
    {
        return getCount() != null;
    }

    public boolean hasCount(Integer e)
    {
        return Kmu.isEqual(getCount(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyNamedCountVo)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyNamedCountVo)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyNamedCountVo)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyNamedCountVo getCopy()
    {
        return (MyNamedCountVo)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        name = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyNamedCountVoBase) )
            return false;

        MyNamedCountVoBase e = (MyNamedCountVoBase) o;
        return Kmu.isEqual(getName(), e.getName());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getName());
    }

    public boolean isSame(MyNamedCountVo e)
    {
        if ( ! Kmu.isEqual(getName(), e.getName()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyNamedCountVo e)
    {
        if ( ! Kmu.isEqual(getCount(), e.getCount()) ) return false;
        return true;
    }

    public boolean isDifferent(MyNamedCountVo e)
    {
        return ! isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyNamedCountVo e)
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

        if ( p.hasKey("name") )
            setName(p.getString("name"));

        if ( p.hasKey("count") )
            setCount(p.getInteger("count"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasName() )
            p.setString("name", getName());

        if ( hasCount() )
            p.setInteger("count", getCount());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyNamedCountVo");
        sb.append("(");
        sb.append("Name=");
        sb.append(name);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Name = " + name);
        System.out.println("    Count = " + count);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(name));
        return sb.toString();
    }

}
