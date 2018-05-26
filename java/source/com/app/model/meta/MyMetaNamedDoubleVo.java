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

public class MyMetaNamedDoubleVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNamedDoubleVo instance = new MyMetaNamedDoubleVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNamedDoubleVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "namedDoubleVo";
    }

    public MyNamedDoubleVoValidator getValidator()
    {
        return MyNamedDoubleVoValidator.instance;
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

    public final MyMetaNamedDoubleVo_AuditLogTitle AuditLogTitle = new MyMetaNamedDoubleVo_AuditLogTitle();
    public final MyMetaNamedDoubleVo_DomainSubtitle DomainSubtitle = new MyMetaNamedDoubleVo_DomainSubtitle();
    public final MyMetaNamedDoubleVo_DomainTitle DomainTitle = new MyMetaNamedDoubleVo_DomainTitle();
    public final MyMetaNamedDoubleVo_Name Name = new MyMetaNamedDoubleVo_Name();
    public final MyMetaNamedDoubleVo_Value Value = new MyMetaNamedDoubleVo_Value();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaNamedDoubleVo_AuditLogTitle
        extends KmMetaStringProperty<MyNamedDoubleVo>
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
        public String getValueFor(MyNamedDoubleVo model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyNamedDoubleVo model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaNamedDoubleVo_DomainSubtitle
        extends KmMetaStringProperty<MyNamedDoubleVo>
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
        public String getValueFor(MyNamedDoubleVo model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyNamedDoubleVo model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaNamedDoubleVo_DomainTitle
        extends KmMetaStringProperty<MyNamedDoubleVo>
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
        public String getValueFor(MyNamedDoubleVo model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyNamedDoubleVo model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaNamedDoubleVo_Name
        extends KmMetaStringProperty<MyNamedDoubleVo>
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
            return "The display name.";
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
            return MyNamedDoubleVoValidator.instance.getNameValidator();
        }

        @Override
        public String getValueFor(MyNamedDoubleVo model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyNamedDoubleVo model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyNamedDoubleVo model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Value
    //##################################################

    public class MyMetaNamedDoubleVo_Value
        extends KmMetaDoubleProperty<MyNamedDoubleVo>
    {
        @Override
        public String getName()
        {
            return "value";
        }

        @Override
        public String getLabel()
        {
            return "Value";
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
        public KmDoubleValidator getValidator()
        {
            return MyNamedDoubleVoValidator.instance.getValueValidator();
        }

        @Override
        public Double getValueFor(MyNamedDoubleVo model)
        {
            return model.getValue();
        }

        @Override
        public void setValueFor(MyNamedDoubleVo model, Double value)
        {
            model.setValue(value);
        }

        @Override
        public boolean hasValueFor(MyNamedDoubleVo model, Double value)
        {
            return model.hasValue(value);
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
