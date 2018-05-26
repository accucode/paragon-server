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

public class MyMetaNamedMoneyVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNamedMoneyVo instance = new MyMetaNamedMoneyVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNamedMoneyVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "namedMoneyVo";
    }

    public MyNamedMoneyVoValidator getValidator()
    {
        return MyNamedMoneyVoValidator.instance;
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

    public final MyMetaNamedMoneyVo_AuditLogTitle AuditLogTitle = new MyMetaNamedMoneyVo_AuditLogTitle();
    public final MyMetaNamedMoneyVo_DomainSubtitle DomainSubtitle = new MyMetaNamedMoneyVo_DomainSubtitle();
    public final MyMetaNamedMoneyVo_DomainTitle DomainTitle = new MyMetaNamedMoneyVo_DomainTitle();
    public final MyMetaNamedMoneyVo_Name Name = new MyMetaNamedMoneyVo_Name();
    public final MyMetaNamedMoneyVo_Value Value = new MyMetaNamedMoneyVo_Value();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaNamedMoneyVo_AuditLogTitle
        extends KmMetaStringProperty<MyNamedMoneyVo>
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
        public String getValueFor(MyNamedMoneyVo model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyNamedMoneyVo model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaNamedMoneyVo_DomainSubtitle
        extends KmMetaStringProperty<MyNamedMoneyVo>
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
        public String getValueFor(MyNamedMoneyVo model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyNamedMoneyVo model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaNamedMoneyVo_DomainTitle
        extends KmMetaStringProperty<MyNamedMoneyVo>
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
        public String getValueFor(MyNamedMoneyVo model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyNamedMoneyVo model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaNamedMoneyVo_Name
        extends KmMetaStringProperty<MyNamedMoneyVo>
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
            return MyNamedMoneyVoValidator.instance.getNameValidator();
        }

        @Override
        public String getValueFor(MyNamedMoneyVo model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyNamedMoneyVo model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyNamedMoneyVo model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Value
    //##################################################

    public class MyMetaNamedMoneyVo_Value
        extends KmMetaMoneyProperty<MyNamedMoneyVo>
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
        public KmMoneyValidator getValidator()
        {
            return MyNamedMoneyVoValidator.instance.getValueValidator();
        }

        @Override
        public KmMoney getValueFor(MyNamedMoneyVo model)
        {
            return model.getValue();
        }

        @Override
        public void setValueFor(MyNamedMoneyVo model, KmMoney value)
        {
            model.setValue(value);
        }

        @Override
        public boolean hasValueFor(MyNamedMoneyVo model, KmMoney value)
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
