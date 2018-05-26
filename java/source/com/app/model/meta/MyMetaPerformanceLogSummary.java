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

public class MyMetaPerformanceLogSummary
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPerformanceLogSummary instance = new MyMetaPerformanceLogSummary();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPerformanceLogSummary()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "performanceLogSummary";
    }

    public MyPerformanceLogSummaryValidator getValidator()
    {
        return MyPerformanceLogSummaryValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A daily summary of the performance logs.  The logs for each day are grouped by name stored with various aggregates such as the min, max, and average durations.  Although the individual performance logs are automatically deleted (after a ~week), these daily summary logs are kept indefinitely for long term reporting.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaPerformanceLogSummary_AuditLogTitle AuditLogTitle = new MyMetaPerformanceLogSummary_AuditLogTitle();
    public final MyMetaPerformanceLogSummary_AverageMs AverageMs = new MyMetaPerformanceLogSummary_AverageMs();
    public final MyMetaPerformanceLogSummary_Count Count = new MyMetaPerformanceLogSummary_Count();
    public final MyMetaPerformanceLogSummary_DomainSubtitle DomainSubtitle = new MyMetaPerformanceLogSummary_DomainSubtitle();
    public final MyMetaPerformanceLogSummary_DomainTitle DomainTitle = new MyMetaPerformanceLogSummary_DomainTitle();
    public final MyMetaPerformanceLogSummary_MaximumMs MaximumMs = new MyMetaPerformanceLogSummary_MaximumMs();
    public final MyMetaPerformanceLogSummary_MinimumMs MinimumMs = new MyMetaPerformanceLogSummary_MinimumMs();
    public final MyMetaPerformanceLogSummary_Name Name = new MyMetaPerformanceLogSummary_Name();
    public final MyMetaPerformanceLogSummary_TotalMs TotalMs = new MyMetaPerformanceLogSummary_TotalMs();
    public final MyMetaPerformanceLogSummary_Uid Uid = new MyMetaPerformanceLogSummary_Uid();
    public final MyMetaPerformanceLogSummary_UtcDate UtcDate = new MyMetaPerformanceLogSummary_UtcDate();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaPerformanceLogSummary_AuditLogTitle
        extends KmMetaStringProperty<MyPerformanceLogSummary>
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
        public String getValueFor(MyPerformanceLogSummary model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# AverageMs
    //##################################################

    public class MyMetaPerformanceLogSummary_AverageMs
        extends KmMetaIntegerProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,Integer>
    {
        @Override
        public String getName()
        {
            return "averageMs";
        }

        @Override
        public String getLabel()
        {
            return "Average Ms";
        }

        @Override
        public String getHelp()
        {
            return "Aggregate information about the individual logs.";
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
            return MyPerformanceLogSummaryValidator.instance.getAverageMsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "averageMs";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        @Override
        public Integer getValueFor(MyPerformanceLogSummary model)
        {
            return model.getAverageMs();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, Integer value)
        {
            model.setAverageMs(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, Integer value)
        {
            return model.hasAverageMs(value);
        }
    }

    //##################################################
    //# Count
    //##################################################

    public class MyMetaPerformanceLogSummary_Count
        extends KmMetaIntegerProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,Integer>
    {
        @Override
        public String getName()
        {
            return "count";
        }

        @Override
        public String getLabel()
        {
            return "Count";
        }

        @Override
        public String getHelp()
        {
            return "The number of performance logs being aggregated.";
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
            return MyPerformanceLogSummaryValidator.instance.getCountValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "count";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        @Override
        public Integer getValueFor(MyPerformanceLogSummary model)
        {
            return model.getCount();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, Integer value)
        {
            model.setCount(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, Integer value)
        {
            return model.hasCount(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaPerformanceLogSummary_DomainSubtitle
        extends KmMetaStringProperty<MyPerformanceLogSummary>
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
        public String getValueFor(MyPerformanceLogSummary model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaPerformanceLogSummary_DomainTitle
        extends KmMetaStringProperty<MyPerformanceLogSummary>
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
        public String getValueFor(MyPerformanceLogSummary model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# MaximumMs
    //##################################################

    public class MyMetaPerformanceLogSummary_MaximumMs
        extends KmMetaIntegerProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,Integer>
    {
        @Override
        public String getName()
        {
            return "maximumMs";
        }

        @Override
        public String getLabel()
        {
            return "Maximum Ms";
        }

        @Override
        public String getHelp()
        {
            return "Aggregate information about the individual logs.";
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
            return MyPerformanceLogSummaryValidator.instance.getMaximumMsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "maximumMs";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        @Override
        public Integer getValueFor(MyPerformanceLogSummary model)
        {
            return model.getMaximumMs();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, Integer value)
        {
            model.setMaximumMs(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, Integer value)
        {
            return model.hasMaximumMs(value);
        }
    }

    //##################################################
    //# MinimumMs
    //##################################################

    public class MyMetaPerformanceLogSummary_MinimumMs
        extends KmMetaIntegerProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,Integer>
    {
        @Override
        public String getName()
        {
            return "minimumMs";
        }

        @Override
        public String getLabel()
        {
            return "Minimum Ms";
        }

        @Override
        public String getHelp()
        {
            return "Aggregate information about the individual logs.";
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
            return MyPerformanceLogSummaryValidator.instance.getMinimumMsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "minimumMs";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        @Override
        public Integer getValueFor(MyPerformanceLogSummary model)
        {
            return model.getMinimumMs();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, Integer value)
        {
            model.setMinimumMs(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, Integer value)
        {
            return model.hasMinimumMs(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaPerformanceLogSummary_Name
        extends KmMetaStringProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,String>
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
            return MyPerformanceLogSummaryValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        @Override
        public String getValueFor(MyPerformanceLogSummary model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# TotalMs
    //##################################################

    public class MyMetaPerformanceLogSummary_TotalMs
        extends KmMetaIntegerProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,Integer>
    {
        @Override
        public String getName()
        {
            return "totalMs";
        }

        @Override
        public String getLabel()
        {
            return "Total Ms";
        }

        @Override
        public String getHelp()
        {
            return "Aggregate information about the individual logs.";
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
            return MyPerformanceLogSummaryValidator.instance.getTotalMsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "totalMs";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        @Override
        public Integer getValueFor(MyPerformanceLogSummary model)
        {
            return model.getTotalMs();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, Integer value)
        {
            model.setTotalMs(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, Integer value)
        {
            return model.hasTotalMs(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaPerformanceLogSummary_Uid
        extends KmMetaStringProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,String>
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
            return MyPerformanceLogSummaryValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        public KmDaoStringKeyCursor<MyPerformanceLogSummary> createCursor()
        {
            KmDaoStringKeyCursor<MyPerformanceLogSummary> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyPerformanceLogSummary model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UtcDate
    //##################################################

    public class MyMetaPerformanceLogSummary_UtcDate
        extends KmMetaDateProperty<MyPerformanceLogSummary>
        implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,KmDate>
    {
        @Override
        public String getName()
        {
            return "utcDate";
        }

        @Override
        public String getLabel()
        {
            return "Utc Date";
        }

        @Override
        public String getHelp()
        {
            return "The day being summarized.";
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
        public KmDateValidator getValidator()
        {
            return MyPerformanceLogSummaryValidator.instance.getUtcDateValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "utcDate";
        }

        @Override
        public MyPerformanceLogSummaryDao getDao()
        {
            return getAccess().getPerformanceLogSummaryDao();
        }

        @Override
        public KmDate getValueFor(MyPerformanceLogSummary model)
        {
            return model.getUtcDate();
        }

        @Override
        public void setValueFor(MyPerformanceLogSummary model, KmDate value)
        {
            model.setUtcDate(value);
        }

        @Override
        public boolean hasValueFor(MyPerformanceLogSummary model, KmDate value)
        {
            return model.hasUtcDate(value);
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
