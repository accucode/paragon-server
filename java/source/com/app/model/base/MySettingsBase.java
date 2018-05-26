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
import com.kodemore.domain.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.finder.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MySettingsBase
    extends MyAbstractDaoDomain<MySettings>
    implements KmDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSettings Meta = MyMetaSettings.instance;
    public static final MySettingsTools Tools = MySettingsTools.instance;
    public static final MySettingsValidator Validator = MySettingsValidator.instance;
    public static final MySettingsFinder Finder = MySettingsFinder.instance;

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
    //# field (auditLogTitle)
    //##################################################

    public abstract String getAuditLogTitle();

    public boolean hasAuditLogTitle()
    {
        return Kmu.hasValue(getAuditLogTitle());
    }

    public boolean hasAuditLogTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getAuditLogTitle(), e);
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
        e = Validator.getCodeValidator().convert(e);
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
    //# field (domainSubtitle)
    //##################################################

    public abstract String getDomainSubtitle();

    public boolean hasDomainSubtitle()
    {
        return Kmu.hasValue(getDomainSubtitle());
    }

    public boolean hasDomainSubtitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainSubtitle(), e);
    }

    //##################################################
    //# field (domainTitle)
    //##################################################

    public abstract String getDomainTitle();

    public boolean hasDomainTitle()
    {
        return Kmu.hasValue(getDomainTitle());
    }

    public boolean hasDomainTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainTitle(), e);
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
        e = Validator.getSomeMessageValidator().convert(e);
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
        e = Validator.getLockVersionValidator().convert(e);
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
    //# validate
    //##################################################

    @Override
    protected final MySettingsValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MySettings asSubclass()
    {
        return (MySettings)this;
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
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MySettings e)
    {
        e.setSomeMessage(getSomeMessage());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MySettings e)
    {
        setSomeMessage(e.getSomeMessage());
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
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getSomeMessage(), e.getSomeMessage()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
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
