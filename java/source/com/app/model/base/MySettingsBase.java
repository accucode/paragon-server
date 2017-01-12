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
public abstract class MySettingsBase
    extends MyAbstractDaoDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSettings Meta = MyMetaSettings.instance;
    public static final MySettingsTools Tools = MySettingsTools.instance;
    public static final MySettingsValidator Validator = MySettingsValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private Integer code;
    private String someMessage;
    private Integer lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public MySettingsBase()
    {
        super();
        setLockVersion(0);
    }

    //##################################################
    //# field (code)
    //##################################################

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer e)
    {
        e = Validator.getCodeValidator().convertOnly(e);
        code = e;
    }

    public void clearCode()
    {
        setCode(null);
    }

    public boolean hasCode()
    {
        return getCode() != null;
    }

    public boolean hasCode(Integer e)
    {
        return Kmu.isEqual(getCode(), e);
    }

    //##################################################
    //# field (someMessage)
    //##################################################

    public String getSomeMessage()
    {
        return someMessage;
    }

    public void setSomeMessage(String e)
    {
        e = Validator.getSomeMessageValidator().convertOnly(e);
        someMessage = e;
    }

    public void clearSomeMessage()
    {
        setSomeMessage(null);
    }

    public boolean hasSomeMessage()
    {
        return Kmu.hasValue(getSomeMessage());
    }

    public boolean hasSomeMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getSomeMessage(), e);
    }

    public void truncateSomeMessage()
    {
        truncateSomeMessage(false);
    }

    public void truncateSomeMessage(boolean ellipses)
    {
        someMessage = Kmu.truncate(someMessage, 100, ellipses);
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MySettings)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MySettings)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MySettings)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MySettings getCopy()
    {
        return (MySettings)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        code = null;
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MySettings getBasicCopy()
    {
        MySettings e;
        e = new MySettings();
        e.setSomeMessage(getSomeMessage());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MySettingsBase) )
            return false;

        MySettingsBase e = (MySettingsBase)o;
        return Kmu.isEqual(getCode(), e.getCode());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getCode());
    }

    public boolean isSame(MySettings e)
    {
        if ( !Kmu.isEqual(getCode(), e.getCode()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MySettings e)
    {
        if ( !Kmu.isEqual(getSomeMessage(), e.getSomeMessage()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        return true;
    }

    public boolean isDifferent(MySettings e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MySettings e)
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
        out.append("MySettings");
        out.append("(");
        out.append("Code=");
        out.append(code);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Code = " + code);
        System.out.println("    SomeMessage = " + someMessage);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        ScFormatter f = getFormatter();

        StringBuilder out;
        out = new StringBuilder();
        out.append(f.formatAny(code));
        return out.toString();
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
