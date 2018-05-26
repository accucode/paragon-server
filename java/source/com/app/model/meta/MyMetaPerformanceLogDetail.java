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

public class MyMetaPerformanceLogDetail
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPerformanceLogDetail instance = new MyMetaPerformanceLogDetail();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPerformanceLogDetail()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "performanceLogDetail";
    }

    public MyPerformanceLogDetailValidator getValidator()
    {
        return MyPerformanceLogDetailValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A log for performance metrics.  We track a number of performance metrics on the system.  This is primarily used as a tool in production to identify hotspots that may require tuning and optimization.  Some care needs to be taken to avoid enabling so many metrics that the performance logging itself becomes a bottleneck.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaPerformanceLogDetail_AuditLogTitle AuditLogTitle = new MyMetaPerformanceLogDetail_AuditLogTitle();
    public final MyMetaPerformanceLogDetail_CreatedUtcTs CreatedUtcTs = new MyMetaPerformanceLogDetail_CreatedUtcTs();
    public final MyMetaPerformanceLogDetail_DomainSubtitle DomainSubtitle = new MyMetaPerformanceLogDetail_DomainSubtitle();
    public final MyMetaPerformanceLogDetail_DomainTitle DomainTitle = new MyMetaPerformanceLogDetail_DomainTitle();
    public final MyMetaPerformanceLogDetail_DurationMs DurationMs = new MyMetaPerformanceLogDetail_DurationMs();
    public final MyMetaPerformanceLogDetail_Name Name = new MyMetaPerformanceLogDetail_Name();
    public final MyMetaPerformanceLogDetail_Uid Uid = new MyMetaPerformanceLogDetail_Uid();
    public final MyMetaPerformanceLogDetail_CreatedLocalTs CreatedLocalTs = new MyMetaPerformanceLogDetail_CreatedLocalTs();
    public final MyMetaPerformanceLogDetail_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaPerformanceLogDetail_CreatedLocalTsMessage();
    public final MyMetaPerformanceLogDetail_CreatedLocalDate CreatedLocalDate = new MyMetaPerformanceLogDetail_CreatedLocalDate();
    public final MyMetaPerformanceLogDetail_CreatedLocalTime CreatedLocalTime = new MyMetaPerformanceLogDetail_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaPerformanceLogDetail_AuditLogTitle
        extends KmMetaStringProperty<MyPerformanceLogDetail>
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
        public String getValueFor(MyPerformanceLogDetail model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaPerformanceLogDetail_CreatedUtcTs
        extends KmMetaTimestampProperty<MyPerformanceLogDetail>
        implements KmMetaDaoPropertyIF<MyPerformanceLogDetail,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "createdUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Created Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The time when this log was created. This is usually very very close to when the task ended (not started).";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmTimestampValidator getValidator()
        {
            return MyPerformanceLogDetailValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyPerformanceLogDetailDao getDao()
        {
            return getAccess().getPerformanceLogDetailDao();
        }

        @Override
        public KmTimestamp getValueFor(MyPerformanceLogDetail model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyPerformanceLogDetail model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaPerformanceLogDetail_DomainSubtitle
        extends KmMetaStringProperty<MyPerformanceLogDetail>
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
        public String getValueFor(MyPerformanceLogDetail model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaPerformanceLogDetail_DomainTitle
        extends KmMetaStringProperty<MyPerformanceLogDetail>
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
        public String getValueFor(MyPerformanceLogDetail model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# DurationMs
    //##################################################

    public class MyMetaPerformanceLogDetail_DurationMs
        extends KmMetaIntegerProperty<MyPerformanceLogDetail>
        implements KmMetaDaoPropertyIF<MyPerformanceLogDetail,Integer>
    {
        @Override
        public String getName()
        {
            return "durationMs";
        }

        @Override
        public String getLabel()
        {
            return "Duration Ms";
        }

        @Override
        public String getHelp()
        {
            return "The duration of the task in milliseconds.";
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
            return MyPerformanceLogDetailValidator.instance.getDurationMsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "durationMs";
        }

        @Override
        public MyPerformanceLogDetailDao getDao()
        {
            return getAccess().getPerformanceLogDetailDao();
        }

        @Override
        public Integer getValueFor(MyPerformanceLogDetail model)
        {
            return model.getDurationMs();
        }

        @Override
        public void setValueFor(MyPerformanceLogDetail model, Integer value)
        {
            model.setDurationMs(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, Integer value)
        {
            return model.hasDurationMs(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaPerformanceLogDetail_Name
        extends KmMetaStringProperty<MyPerformanceLogDetail>
        implements KmMetaDaoPropertyIF<MyPerformanceLogDetail,String>
    {
        @Override
        public String getName()
        {
            return "name";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "The display name.  E.g.: the classname of the servlet or job.";
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
            return MyPerformanceLogDetailValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyPerformanceLogDetailDao getDao()
        {
            return getAccess().getPerformanceLogDetailDao();
        }

        @Override
        public String getValueFor(MyPerformanceLogDetail model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyPerformanceLogDetail model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaPerformanceLogDetail_Uid
        extends KmMetaStringProperty<MyPerformanceLogDetail>
        implements KmMetaDaoPropertyIF<MyPerformanceLogDetail,String>
    {
        @Override
        public String getName()
        {
            return "uid";
        }

        @Override
        public String getLabel()
        {
            return "Uid";
        }

        @Override
        public String getHelp()
        {
            return "The global unique key.  This is a large hex-encoded number, and is usually not displayed to users.  This is currently NOT a standard format, but is instead a format that we use internally.";
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
            return MyPerformanceLogDetailValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyPerformanceLogDetailDao getDao()
        {
            return getAccess().getPerformanceLogDetailDao();
        }

        public KmDaoStringKeyCursor<MyPerformanceLogDetail> createCursor()
        {
            KmDaoStringKeyCursor<MyPerformanceLogDetail> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyPerformanceLogDetail model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyPerformanceLogDetail model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaPerformanceLogDetail_CreatedLocalTs
        extends KmMetaTimestampProperty<MyPerformanceLogDetail>
    {
        @Override
        public String getName()
        {
            return "createdLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created timestamp converted to the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTimestamp getValueFor(MyPerformanceLogDetail model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaPerformanceLogDetail_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyPerformanceLogDetail>
    {
        @Override
        public String getName()
        {
            return "createdLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyPerformanceLogDetail model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaPerformanceLogDetail_CreatedLocalDate
        extends KmMetaDateProperty<MyPerformanceLogDetail>
    {
        @Override
        public String getName()
        {
            return "createdLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created date based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmDate getValueFor(MyPerformanceLogDetail model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaPerformanceLogDetail_CreatedLocalTime
        extends KmMetaTimeProperty<MyPerformanceLogDetail>
    {
        @Override
        public String getName()
        {
            return "createdLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created time of day based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTime getValueFor(MyPerformanceLogDetail model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogDetail model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
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
