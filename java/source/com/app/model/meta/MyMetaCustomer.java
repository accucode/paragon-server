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

public class MyMetaCustomer
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaCustomer instance = new MyMetaCustomer();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaCustomer()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customer";
    }

    public MyCustomerValidator getValidator()
    {
        return MyCustomerValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The customer details that are specific to a particular project.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaCustomer_AuditLogTitle AuditLogTitle = new MyMetaCustomer_AuditLogTitle();
    public final MyMetaCustomer_BillingAddressLongLine BillingAddressLongLine = new MyMetaCustomer_BillingAddressLongLine();
    public final MyMetaCustomer_BillingAddressMultiLine BillingAddressMultiLine = new MyMetaCustomer_BillingAddressMultiLine();
    public final MyMetaCustomer_BillingAddressMultiLineHtml BillingAddressMultiLineHtml = new MyMetaCustomer_BillingAddressMultiLineHtml();
    public final MyMetaCustomer_BillingAddressShortLine BillingAddressShortLine = new MyMetaCustomer_BillingAddressShortLine();
    public final MyMetaCustomer_BillingAttention BillingAttention = new MyMetaCustomer_BillingAttention();
    public final MyMetaCustomer_BillingCity BillingCity = new MyMetaCustomer_BillingCity();
    public final MyMetaCustomer_BillingCountry BillingCountry = new MyMetaCustomer_BillingCountry();
    public final MyMetaCustomer_BillingPhone BillingPhone = new MyMetaCustomer_BillingPhone();
    public final MyMetaCustomer_BillingPostalCode BillingPostalCode = new MyMetaCustomer_BillingPostalCode();
    public final MyMetaCustomer_BillingRegion BillingRegion = new MyMetaCustomer_BillingRegion();
    public final MyMetaCustomer_BillingStreet1 BillingStreet1 = new MyMetaCustomer_BillingStreet1();
    public final MyMetaCustomer_BillingStreet2 BillingStreet2 = new MyMetaCustomer_BillingStreet2();
    public final MyMetaCustomer_CreatedUtcTs CreatedUtcTs = new MyMetaCustomer_CreatedUtcTs();
    public final MyMetaCustomer_DomainSubtitle DomainSubtitle = new MyMetaCustomer_DomainSubtitle();
    public final MyMetaCustomer_DomainTitle DomainTitle = new MyMetaCustomer_DomainTitle();
    public final MyMetaCustomer_Enabled Enabled = new MyMetaCustomer_Enabled();
    public final MyMetaCustomer_EnabledStatus EnabledStatus = new MyMetaCustomer_EnabledStatus();
    public final MyMetaCustomer_Name Name = new MyMetaCustomer_Name();
    public final MyMetaCustomer_Uid Uid = new MyMetaCustomer_Uid();
    public final MyMetaCustomer_UpdatedUtcTs UpdatedUtcTs = new MyMetaCustomer_UpdatedUtcTs();
    public final MyMetaCustomer_LockVersion LockVersion = new MyMetaCustomer_LockVersion();
    public final MyMetaCustomer_CreatedLocalTs CreatedLocalTs = new MyMetaCustomer_CreatedLocalTs();
    public final MyMetaCustomer_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaCustomer_CreatedLocalTsMessage();
    public final MyMetaCustomer_CreatedLocalDate CreatedLocalDate = new MyMetaCustomer_CreatedLocalDate();
    public final MyMetaCustomer_CreatedLocalTime CreatedLocalTime = new MyMetaCustomer_CreatedLocalTime();
    public final MyMetaCustomer_UpdatedLocalTs UpdatedLocalTs = new MyMetaCustomer_UpdatedLocalTs();
    public final MyMetaCustomer_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaCustomer_UpdatedLocalTsMessage();
    public final MyMetaCustomer_UpdatedLocalDate UpdatedLocalDate = new MyMetaCustomer_UpdatedLocalDate();
    public final MyMetaCustomer_UpdatedLocalTime UpdatedLocalTime = new MyMetaCustomer_UpdatedLocalTime();
    public final MyMetaCustomer_ApprovalContactFullName ApprovalContactFullName = new MyMetaCustomer_ApprovalContactFullName();
    public final MyMetaCustomer_ApprovalContactShortName ApprovalContactShortName = new MyMetaCustomer_ApprovalContactShortName();
    public final MyMetaCustomer_ApprovalContactSummaryMultiline ApprovalContactSummaryMultiline = new MyMetaCustomer_ApprovalContactSummaryMultiline();
    public final MyMetaCustomer_ApprovalContactEmail ApprovalContactEmail = new MyMetaCustomer_ApprovalContactEmail();
    public final MyMetaCustomer_ApprovalContactPhone ApprovalContactPhone = new MyMetaCustomer_ApprovalContactPhone();
    public final MyMetaCustomer_BillingContactFullName BillingContactFullName = new MyMetaCustomer_BillingContactFullName();
    public final MyMetaCustomer_BillingContactShortName BillingContactShortName = new MyMetaCustomer_BillingContactShortName();
    public final MyMetaCustomer_BillingContactSummaryMultiline BillingContactSummaryMultiline = new MyMetaCustomer_BillingContactSummaryMultiline();
    public final MyMetaCustomer_BillingContactEmail BillingContactEmail = new MyMetaCustomer_BillingContactEmail();
    public final MyMetaCustomer_BillingContactPhone BillingContactPhone = new MyMetaCustomer_BillingContactPhone();
    public final MyMetaCustomer_CreatedByFullName CreatedByFullName = new MyMetaCustomer_CreatedByFullName();
    public final MyMetaCustomer_UpdatedByFullName UpdatedByFullName = new MyMetaCustomer_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaCustomer_ApprovalContact ApprovalContact = new MyMetaCustomer_ApprovalContact();
    public final MyMetaCustomer_BillingContact BillingContact = new MyMetaCustomer_BillingContact();
    public final MyMetaCustomer_CreatedBy CreatedBy = new MyMetaCustomer_CreatedBy();
    public final MyMetaCustomer_Project Project = new MyMetaCustomer_Project();
    public final MyMetaCustomer_UpdatedBy UpdatedBy = new MyMetaCustomer_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaCustomer_AuditLogTitle
        extends KmMetaStringProperty<MyCustomer>
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
        public String getValueFor(MyCustomer model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# BillingAddressLongLine
    //##################################################

    public class MyMetaCustomer_BillingAddressLongLine
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingAddressLongLine";
        }

        @Override
        public String getLabel()
        {
            return "Billing Address Long Line";
        }

        @Override
        public String getHelp()
        {
            return "The long format of the address.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingAddressLongLine();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingAddressLongLine(value);
        }
    }

    //##################################################
    //# BillingAddressMultiLine
    //##################################################

    public class MyMetaCustomer_BillingAddressMultiLine
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingAddressMultiLine";
        }

        @Override
        public String getLabel()
        {
            return "Billing Address Multi Line";
        }

        @Override
        public String getHelp()
        {
            return "The multi-line format of the address.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingAddressMultiLine();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingAddressMultiLine(value);
        }
    }

    //##################################################
    //# BillingAddressMultiLineHtml
    //##################################################

    public class MyMetaCustomer_BillingAddressMultiLineHtml
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingAddressMultiLineHtml";
        }

        @Override
        public String getLabel()
        {
            return "Billing Address Multi Line Html";
        }

        @Override
        public String getHelp()
        {
            return "The html multi-line format of the address.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingAddressMultiLineHtml();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingAddressMultiLineHtml(value);
        }
    }

    //##################################################
    //# BillingAddressShortLine
    //##################################################

    public class MyMetaCustomer_BillingAddressShortLine
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingAddressShortLine";
        }

        @Override
        public String getLabel()
        {
            return "Billing Address Short Line";
        }

        @Override
        public String getHelp()
        {
            return "The short format of the address.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingAddressShortLine();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingAddressShortLine(value);
        }
    }

    //##################################################
    //# BillingAttention
    //##################################################

    public class MyMetaCustomer_BillingAttention
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingAttention";
        }

        @Override
        public String getLabel()
        {
            return "Billing Attention";
        }

        @Override
        public String getHelp()
        {
            return "The attention line of the address.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getBillingAttentionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingAttention";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingAttention();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingAttention(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingAttention(value);
        }
    }

    //##################################################
    //# BillingCity
    //##################################################

    public class MyMetaCustomer_BillingCity
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingCity";
        }

        @Override
        public String getLabel()
        {
            return "Billing City";
        }

        @Override
        public String getHelp()
        {
            return "The name of the city.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getBillingCityValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingCity";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingCity();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingCity(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingCity(value);
        }
    }

    //##################################################
    //# BillingCountry
    //##################################################

    public class MyMetaCustomer_BillingCountry
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingCountry";
        }

        @Override
        public String getLabel()
        {
            return "Billing Country";
        }

        @Override
        public String getHelp()
        {
            return "The name or abbreviation of the country.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getBillingCountryValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingCountry";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingCountry();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingCountry(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingCountry(value);
        }
    }

    //##################################################
    //# BillingPhone
    //##################################################

    public class MyMetaCustomer_BillingPhone
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingPhone";
        }

        @Override
        public String getLabel()
        {
            return "Billing Phone";
        }

        @Override
        public String getHelp()
        {
            return "The phone number.";
        }

        @Override
        public int getColumnWidth()
        {
            return 12;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getBillingPhoneValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingPhone";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingPhone();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingPhone(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingPhone(value);
        }
    }

    //##################################################
    //# BillingPostalCode
    //##################################################

    public class MyMetaCustomer_BillingPostalCode
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingPostalCode";
        }

        @Override
        public String getLabel()
        {
            return "Billing Postal Code";
        }

        @Override
        public String getHelp()
        {
            return "The zip/postal code.";
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
            return MyCustomerValidator.instance.getBillingPostalCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingPostalCode";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingPostalCode();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingPostalCode(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingPostalCode(value);
        }
    }

    //##################################################
    //# BillingRegion
    //##################################################

    public class MyMetaCustomer_BillingRegion
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingRegion";
        }

        @Override
        public String getLabel()
        {
            return "Billing Region";
        }

        @Override
        public String getHelp()
        {
            return "The name or abbreviation of the of the region (or state).";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getBillingRegionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingRegion";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingRegion();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingRegion(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingRegion(value);
        }
    }

    //##################################################
    //# BillingStreet1
    //##################################################

    public class MyMetaCustomer_BillingStreet1
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingStreet1";
        }

        @Override
        public String getLabel()
        {
            return "Billing Street1";
        }

        @Override
        public String getHelp()
        {
            return "The first line of the street address.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getBillingStreet1Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingStreet1";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingStreet1();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingStreet1(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingStreet1(value);
        }
    }

    //##################################################
    //# BillingStreet2
    //##################################################

    public class MyMetaCustomer_BillingStreet2
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
    {
        @Override
        public String getName()
        {
            return "billingStreet2";
        }

        @Override
        public String getLabel()
        {
            return "Billing Street2";
        }

        @Override
        public String getHelp()
        {
            return "The second line of the street address.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getBillingStreet2Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "billingStreet2";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingStreet2();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingStreet2(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingStreet2(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaCustomer_CreatedUtcTs
        extends KmMetaTimestampProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,KmTimestamp>
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
            return "The time this record was originally created.";
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
            return MyCustomerValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public KmTimestamp getValueFor(MyCustomer model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyCustomer model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaCustomer_DomainSubtitle
        extends KmMetaStringProperty<MyCustomer>
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
        public String getValueFor(MyCustomer model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaCustomer_DomainTitle
        extends KmMetaStringProperty<MyCustomer>
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
        public String getValueFor(MyCustomer model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaCustomer_Enabled
        extends KmMetaBooleanProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,Boolean>
    {
        @Override
        public String getName()
        {
            return "enabled";
        }

        @Override
        public String getLabel()
        {
            return "Enabled";
        }

        @Override
        public String getHelp()
        {
            return "Disable to hide this on various screens.";
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
        public KmBooleanValidator getValidator()
        {
            return MyCustomerValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public Boolean getValueFor(MyCustomer model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyCustomer model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaCustomer_EnabledStatus
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "enabledStatus";
        }

        @Override
        public String getLabel()
        {
            return "Enabled";
        }

        @Override
        public String getHelp()
        {
            return "Disable to hide this on various screens.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaCustomer_Name
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
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
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyCustomerValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaCustomer_Uid
        extends KmMetaStringProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,String>
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
            return MyCustomerValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        public KmDaoStringKeyCursor<MyCustomer> createCursor()
        {
            KmDaoStringKeyCursor<MyCustomer> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaCustomer_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "updatedUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Updated Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The time this record was last updated.";
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
            return MyCustomerValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public KmTimestamp getValueFor(MyCustomer model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyCustomer model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaCustomer_LockVersion
        extends KmMetaIntegerProperty<MyCustomer>
        implements KmMetaDaoPropertyIF<MyCustomer,Integer>
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
            return MyCustomerValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyCustomerDao getDao()
        {
            return getAccess().getCustomerDao();
        }

        @Override
        public Integer getValueFor(MyCustomer model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyCustomer model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaCustomer_CreatedLocalTs
        extends KmMetaTimestampProperty<MyCustomer>
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
        public KmTimestamp getValueFor(MyCustomer model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaCustomer_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyCustomer>
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
        public String getValueFor(MyCustomer model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaCustomer_CreatedLocalDate
        extends KmMetaDateProperty<MyCustomer>
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
        public KmDate getValueFor(MyCustomer model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaCustomer_CreatedLocalTime
        extends KmMetaTimeProperty<MyCustomer>
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
        public KmTime getValueFor(MyCustomer model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaCustomer_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyCustomer model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaCustomer_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaCustomer_UpdatedLocalDate
        extends KmMetaDateProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "updatedLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated date based on the user's local timezone.";
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
        public KmDate getValueFor(MyCustomer model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaCustomer_UpdatedLocalTime
        extends KmMetaTimeProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyCustomer model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# ApprovalContactFullName
    //##################################################

    public class MyMetaCustomer_ApprovalContactFullName
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "approvalContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Main Contact";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getApprovalContactFullName();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setApprovalContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasApprovalContactFullName(value);
        }
    }

    //##################################################
    //# ApprovalContactShortName
    //##################################################

    public class MyMetaCustomer_ApprovalContactShortName
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "approvalContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Main Contact";
        }

        @Override
        public String getHelp()
        {
            return "Return a single name, preferably the nickname or first name. This should never be blank.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getApprovalContactShortName();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasApprovalContactShortName(value);
        }
    }

    //##################################################
    //# ApprovalContactSummaryMultiline
    //##################################################

    public class MyMetaCustomer_ApprovalContactSummaryMultiline
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "approvalContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Main Contact";
        }

        @Override
        public String getHelp()
        {
            return "The contact's name, phone, and email formatted into a multiline summary.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getApprovalContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasApprovalContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# ApprovalContactEmail
    //##################################################

    public class MyMetaCustomer_ApprovalContactEmail
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "approvalContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Approval Contact Email";
        }

        @Override
        public String getHelp()
        {
            return "The person's email address.  E.g.: john.doe@example.net.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getApprovalContactEmail();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setApprovalContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasApprovalContactEmail(value);
        }
    }

    //##################################################
    //# ApprovalContactPhone
    //##################################################

    public class MyMetaCustomer_ApprovalContactPhone
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "approvalContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Approval Contact Phone";
        }

        @Override
        public String getHelp()
        {
            return "The person's phone number.  E.g.: 303.555.1234.";
        }

        @Override
        public int getColumnWidth()
        {
            return 12;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getApprovalContactPhone();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setApprovalContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasApprovalContactPhone(value);
        }
    }

    //##################################################
    //# BillingContactFullName
    //##################################################

    public class MyMetaCustomer_BillingContactFullName
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Install Contact";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingContactFullName();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingContactFullName(value);
        }
    }

    //##################################################
    //# BillingContactShortName
    //##################################################

    public class MyMetaCustomer_BillingContactShortName
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Install Contact";
        }

        @Override
        public String getHelp()
        {
            return "Return a single name, preferably the nickname or first name. This should never be blank.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingContactShortName();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingContactShortName(value);
        }
    }

    //##################################################
    //# BillingContactSummaryMultiline
    //##################################################

    public class MyMetaCustomer_BillingContactSummaryMultiline
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Install Contact";
        }

        @Override
        public String getHelp()
        {
            return "The contact's name, phone, and email formatted into a multiline summary.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# BillingContactEmail
    //##################################################

    public class MyMetaCustomer_BillingContactEmail
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Billing Contact Email";
        }

        @Override
        public String getHelp()
        {
            return "The person's email address.  E.g.: john.doe@example.net.";
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
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingContactEmail();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingContactEmail(value);
        }
    }

    //##################################################
    //# BillingContactPhone
    //##################################################

    public class MyMetaCustomer_BillingContactPhone
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "billingContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Billing Contact Phone";
        }

        @Override
        public String getHelp()
        {
            return "The person's phone number.  E.g.: 303.555.1234.";
        }

        @Override
        public int getColumnWidth()
        {
            return 12;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getBillingContactPhone();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setBillingContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasBillingContactPhone(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaCustomer_CreatedByFullName
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "createdByFullName";
        }

        @Override
        public String getLabel()
        {
            return "Created By";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaCustomer_UpdatedByFullName
        extends KmMetaStringProperty<MyCustomer>
    {
        @Override
        public String getName()
        {
            return "updatedByFullName";
        }

        @Override
        public String getLabel()
        {
            return "Updated By";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyCustomer model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyCustomer model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# ApprovalContact
    //##################################################

    public class MyMetaCustomer_ApprovalContact
        extends KmMetaDaoAssociation<MyCustomer,MyCustomerContact>
    {
        @Override
        public String getName()
        {
            return "approvalContact";
        }

        @Override
        public String getLabel()
        {
            return "Approval Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for job approvals.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyCustomerContact getValueFor(MyCustomer model)
        {
            return model.getApprovalContact();
        }

        @Override
        public void setValueFor(MyCustomer model, MyCustomerContact value)
        {
            model.setApprovalContact(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, MyCustomerContact value)
        {
            return model.hasApprovalContact(value);
        }
    }

    //##################################################
    //# BillingContact
    //##################################################

    public class MyMetaCustomer_BillingContact
        extends KmMetaDaoAssociation<MyCustomer,MyCustomerContact>
    {
        @Override
        public String getName()
        {
            return "billingContact";
        }

        @Override
        public String getLabel()
        {
            return "Billing Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for billing.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyCustomerContact getValueFor(MyCustomer model)
        {
            return model.getBillingContact();
        }

        @Override
        public void setValueFor(MyCustomer model, MyCustomerContact value)
        {
            model.setBillingContact(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, MyCustomerContact value)
        {
            return model.hasBillingContact(value);
        }
    }

    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaCustomer_CreatedBy
        extends KmMetaDaoAssociation<MyCustomer,MyUser>
    {
        @Override
        public String getName()
        {
            return "createdBy";
        }

        @Override
        public String getLabel()
        {
            return "Created By";
        }

        @Override
        public String getHelp()
        {
            return "The user that originally created this record, if known.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyCustomer model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyCustomer model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaCustomer_Project
        extends KmMetaDaoAssociation<MyCustomer,MyProject>
    {
        @Override
        public String getName()
        {
            return "project";
        }

        @Override
        public String getLabel()
        {
            return "Project";
        }

        @Override
        public String getHelp()
        {
            return "The project to which this customer belongs.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyCustomer model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyCustomer model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaCustomer_UpdatedBy
        extends KmMetaDaoAssociation<MyCustomer,MyUser>
    {
        @Override
        public String getName()
        {
            return "updatedBy";
        }

        @Override
        public String getLabel()
        {
            return "Updated By";
        }

        @Override
        public String getHelp()
        {
            return "The user that last updated this record, if known.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyCustomer model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyCustomer model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyCustomer model, MyUser value)
        {
            return model.hasUpdatedBy(value);
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
