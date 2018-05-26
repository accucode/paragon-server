//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaSettings
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSettings instance = new MyMetaSettings();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSettings()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "settings";
    }

    public MySettingsValidator getValidator()
    {
        return MySettingsValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A single record with global settings. This provides a simple, typesafe way to store some global settings in the database. For example, we could define a global contact (email or phone) for technical assistance with the portal.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaSettings_AuditLogTitle AuditLogTitle = new MyMetaSettings_AuditLogTitle();
    public final MyMetaSettings_Code Code = new MyMetaSettings_Code();
    public final MyMetaSettings_DomainSubtitle DomainSubtitle = new MyMetaSettings_DomainSubtitle();
    public final MyMetaSettings_DomainTitle DomainTitle = new MyMetaSettings_DomainTitle();
    public final MyMetaSettings_SomeMessage SomeMessage = new MyMetaSettings_SomeMessage();
    public final MyMetaSettings_LockVersion LockVersion = new MyMetaSettings_LockVersion();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaSettings_AuditLogTitle
        extends KmMetaStringProperty<MySettings>
    {
        @Override
        public String getName()
        {
            return "auditLogTitle";
        }

        @Override
        public String getLabel()
        {
            return "Audit Log Title";
        }

        @Override
        public String getHelp()
        {
            return "This is used a the title in auditLogs. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MySettings model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MySettings model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# Code
    //##################################################

    public class MyMetaSettings_Code
        extends KmMetaIntegerProperty<MySettings>
        implements KmMetaDaoPropertyIF<MySettings,Integer>
    {
        @Override
        public String getName()
        {
            return "code";
        }

        @Override
        public String getLabel()
        {
            return "Code";
        }

        @Override
        public String getHelp()
        {
            return "The unique key; hardcoded to 1.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmIntegerValidator getValidator()
        {
            return MySettingsValidator.instance.getCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "code";
        }

        @Override
        public MySettingsDao getDao()
        {
            return getAccess().getSettingsDao();
        }

        public KmDaoIntegerKeyCursor<MySettings> createCursor()
        {
            KmDaoIntegerKeyCursor<MySettings> e;
            e = new KmDaoIntegerKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public Integer getValueFor(MySettings model)
        {
            return model.getCode();
        }

        @Override
        public void setValueFor(MySettings model, Integer value)
        {
            model.setCode(value);
        }

        @Override
        public boolean hasValueFor(MySettings model, Integer value)
        {
            return model.hasCode(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaSettings_DomainSubtitle
        extends KmMetaStringProperty<MySettings>
    {
        @Override
        public String getName()
        {
            return "domainSubtitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Subtitle";
        }

        @Override
        public String getHelp()
        {
            return "The subtitle commonly used for rows in a list. This MAY be null, if there is not subtitle.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MySettings model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MySettings model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaSettings_DomainTitle
        extends KmMetaStringProperty<MySettings>
    {
        @Override
        public String getName()
        {
            return "domainTitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Title";
        }

        @Override
        public String getHelp()
        {
            return "The title commonly used for rows in a list or dropdown field. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MySettings model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MySettings model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# SomeMessage
    //##################################################

    public class MyMetaSettings_SomeMessage
        extends KmMetaStringProperty<MySettings>
        implements KmMetaDaoPropertyIF<MySettings,String>
    {
        @Override
        public String getName()
        {
            return "someMessage";
        }

        @Override
        public String getLabel()
        {
            return "Some Message";
        }

        @Override
        public String getHelp()
        {
            return "Just a placeholder until more useful settings are defined.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MySettingsValidator.instance.getSomeMessageValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "someMessage";
        }

        @Override
        public MySettingsDao getDao()
        {
            return getAccess().getSettingsDao();
        }

        @Override
        public String getValueFor(MySettings model)
        {
            return model.getSomeMessage();
        }

        @Override
        public void setValueFor(MySettings model, String value)
        {
            model.setSomeMessage(value);
        }

        @Override
        public boolean hasValueFor(MySettings model, String value)
        {
            return model.hasSomeMessage(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaSettings_LockVersion
        extends KmMetaIntegerProperty<MySettings>
        implements KmMetaDaoPropertyIF<MySettings,Integer>
    {
        @Override
        public String getName()
        {
            return "lockVersion";
        }

        @Override
        public String getLabel()
        {
            return "Lock Version";
        }

        @Override
        public String getHelp()
        {
            return "This is used to coordinate optimistic locking in the database. This is usually not displayed.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmIntegerValidator getValidator()
        {
            return MySettingsValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MySettingsDao getDao()
        {
            return getAccess().getSettingsDao();
        }

        @Override
        public Integer getValueFor(MySettings model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MySettings model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MySettings model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }


    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
