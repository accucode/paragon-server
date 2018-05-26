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

public class MyMetaDatedCountVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaDatedCountVo instance = new MyMetaDatedCountVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaDatedCountVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "datedCountVo";
    }

    public MyDatedCountVoValidator getValidator()
    {
        return MyDatedCountVoValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "This is a non-persistent domain model; it is NOT stored in the database.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaDatedCountVo_AuditLogTitle AuditLogTitle = new MyMetaDatedCountVo_AuditLogTitle();
    public final MyMetaDatedCountVo_Count Count = new MyMetaDatedCountVo_Count();
    public final MyMetaDatedCountVo_Date Date = new MyMetaDatedCountVo_Date();
    public final MyMetaDatedCountVo_DomainSubtitle DomainSubtitle = new MyMetaDatedCountVo_DomainSubtitle();
    public final MyMetaDatedCountVo_DomainTitle DomainTitle = new MyMetaDatedCountVo_DomainTitle();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaDatedCountVo_AuditLogTitle
        extends KmMetaStringProperty<MyDatedCountVo>
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
        public String getValueFor(MyDatedCountVo model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyDatedCountVo model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# Count
    //##################################################

    public class MyMetaDatedCountVo_Count
        extends KmMetaIntegerProperty<MyDatedCountVo>
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
            return null;
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
            return MyDatedCountVoValidator.instance.getCountValidator();
        }

        @Override
        public Integer getValueFor(MyDatedCountVo model)
        {
            return model.getCount();
        }

        @Override
        public void setValueFor(MyDatedCountVo model, Integer value)
        {
            model.setCount(value);
        }

        @Override
        public boolean hasValueFor(MyDatedCountVo model, Integer value)
        {
            return model.hasCount(value);
        }
    }

    //##################################################
    //# Date
    //##################################################

    public class MyMetaDatedCountVo_Date
        extends KmMetaDateProperty<MyDatedCountVo>
    {
        @Override
        public String getName()
        {
            return "date";
        }

        @Override
        public String getLabel()
        {
            return "Date";
        }

        @Override
        public String getHelp()
        {
            return "The date being counted.";
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
            return MyDatedCountVoValidator.instance.getDateValidator();
        }

        @Override
        public KmDate getValueFor(MyDatedCountVo model)
        {
            return model.getDate();
        }

        @Override
        public void setValueFor(MyDatedCountVo model, KmDate value)
        {
            model.setDate(value);
        }

        @Override
        public boolean hasValueFor(MyDatedCountVo model, KmDate value)
        {
            return model.hasDate(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaDatedCountVo_DomainSubtitle
        extends KmMetaStringProperty<MyDatedCountVo>
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
        public String getValueFor(MyDatedCountVo model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyDatedCountVo model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaDatedCountVo_DomainTitle
        extends KmMetaStringProperty<MyDatedCountVo>
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
        public String getValueFor(MyDatedCountVo model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyDatedCountVo model, String value)
        {
            return model.hasDomainTitle(value);
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
