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

public class MyMetaNamedIntegerVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNamedIntegerVo instance = new MyMetaNamedIntegerVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNamedIntegerVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "namedIntegerVo";
    }

    public MyNamedIntegerVoValidator getValidator()
    {
        return MyNamedIntegerVoValidator.instance;
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

    public final MyMetaNamedIntegerVo_AuditLogTitle AuditLogTitle = new MyMetaNamedIntegerVo_AuditLogTitle();
    public final MyMetaNamedIntegerVo_DomainSubtitle DomainSubtitle = new MyMetaNamedIntegerVo_DomainSubtitle();
    public final MyMetaNamedIntegerVo_DomainTitle DomainTitle = new MyMetaNamedIntegerVo_DomainTitle();
    public final MyMetaNamedIntegerVo_Name Name = new MyMetaNamedIntegerVo_Name();
    public final MyMetaNamedIntegerVo_Value Value = new MyMetaNamedIntegerVo_Value();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaNamedIntegerVo_AuditLogTitle
        extends KmMetaStringProperty<MyNamedIntegerVo>
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
        public String getValueFor(MyNamedIntegerVo model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyNamedIntegerVo model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaNamedIntegerVo_DomainSubtitle
        extends KmMetaStringProperty<MyNamedIntegerVo>
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
        public String getValueFor(MyNamedIntegerVo model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyNamedIntegerVo model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaNamedIntegerVo_DomainTitle
        extends KmMetaStringProperty<MyNamedIntegerVo>
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
        public String getValueFor(MyNamedIntegerVo model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyNamedIntegerVo model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaNamedIntegerVo_Name
        extends KmMetaStringProperty<MyNamedIntegerVo>
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
            return MyNamedIntegerVoValidator.instance.getNameValidator();
        }

        @Override
        public String getValueFor(MyNamedIntegerVo model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyNamedIntegerVo model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyNamedIntegerVo model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Value
    //##################################################

    public class MyMetaNamedIntegerVo_Value
        extends KmMetaIntegerProperty<MyNamedIntegerVo>
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
        public KmIntegerValidator getValidator()
        {
            return MyNamedIntegerVoValidator.instance.getValueValidator();
        }

        @Override
        public Integer getValueFor(MyNamedIntegerVo model)
        {
            return model.getValue();
        }

        @Override
        public void setValueFor(MyNamedIntegerVo model, Integer value)
        {
            model.setValue(value);
        }

        @Override
        public boolean hasValueFor(MyNamedIntegerVo model, Integer value)
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
