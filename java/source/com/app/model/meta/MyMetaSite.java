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

public class MyMetaSite
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSite instance = new MyMetaSite();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSite()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "site";
    }

    public MySiteValidator getValidator()
    {
        return MySiteValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The sites associated with each customer. Each site typically identifes a physical building with a distinct mailing address.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaSite_AddressAttention AddressAttention = new MyMetaSite_AddressAttention();
    public final MyMetaSite_AddressCity AddressCity = new MyMetaSite_AddressCity();
    public final MyMetaSite_AddressCountry AddressCountry = new MyMetaSite_AddressCountry();
    public final MyMetaSite_AddressLongLine AddressLongLine = new MyMetaSite_AddressLongLine();
    public final MyMetaSite_AddressMultiLine AddressMultiLine = new MyMetaSite_AddressMultiLine();
    public final MyMetaSite_AddressPhone AddressPhone = new MyMetaSite_AddressPhone();
    public final MyMetaSite_AddressPostalCode AddressPostalCode = new MyMetaSite_AddressPostalCode();
    public final MyMetaSite_AddressRegion AddressRegion = new MyMetaSite_AddressRegion();
    public final MyMetaSite_AddressShortLine AddressShortLine = new MyMetaSite_AddressShortLine();
    public final MyMetaSite_AddressStreet1 AddressStreet1 = new MyMetaSite_AddressStreet1();
    public final MyMetaSite_AddressStreet2 AddressStreet2 = new MyMetaSite_AddressStreet2();
    public final MyMetaSite_AuditLogTitle AuditLogTitle = new MyMetaSite_AuditLogTitle();
    public final MyMetaSite_CreatedUtcTs CreatedUtcTs = new MyMetaSite_CreatedUtcTs();
    public final MyMetaSite_DomainSubtitle DomainSubtitle = new MyMetaSite_DomainSubtitle();
    public final MyMetaSite_DomainTitle DomainTitle = new MyMetaSite_DomainTitle();
    public final MyMetaSite_Enabled Enabled = new MyMetaSite_Enabled();
    public final MyMetaSite_EnabledStatus EnabledStatus = new MyMetaSite_EnabledStatus();
    public final MyMetaSite_FullName FullName = new MyMetaSite_FullName();
    public final MyMetaSite_Name Name = new MyMetaSite_Name();
    public final MyMetaSite_Number Number = new MyMetaSite_Number();
    public final MyMetaSite_PriorityName PriorityName = new MyMetaSite_PriorityName();
    public final MyMetaSite_TimeZoneCode TimeZoneCode = new MyMetaSite_TimeZoneCode();
    public final MyMetaSite_TimeZoneName TimeZoneName = new MyMetaSite_TimeZoneName();
    public final MyMetaSite_Uid Uid = new MyMetaSite_Uid();
    public final MyMetaSite_UpdatedUtcTs UpdatedUtcTs = new MyMetaSite_UpdatedUtcTs();
    public final MyMetaSite_LockVersion LockVersion = new MyMetaSite_LockVersion();
    public final MyMetaSite_CreatedLocalTs CreatedLocalTs = new MyMetaSite_CreatedLocalTs();
    public final MyMetaSite_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaSite_CreatedLocalTsMessage();
    public final MyMetaSite_CreatedLocalDate CreatedLocalDate = new MyMetaSite_CreatedLocalDate();
    public final MyMetaSite_CreatedLocalTime CreatedLocalTime = new MyMetaSite_CreatedLocalTime();
    public final MyMetaSite_UpdatedLocalTs UpdatedLocalTs = new MyMetaSite_UpdatedLocalTs();
    public final MyMetaSite_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaSite_UpdatedLocalTsMessage();
    public final MyMetaSite_UpdatedLocalDate UpdatedLocalDate = new MyMetaSite_UpdatedLocalDate();
    public final MyMetaSite_UpdatedLocalTime UpdatedLocalTime = new MyMetaSite_UpdatedLocalTime();
    public final MyMetaSite_CreatedByFullName CreatedByFullName = new MyMetaSite_CreatedByFullName();
    public final MyMetaSite_CustomerName CustomerName = new MyMetaSite_CustomerName();
    public final MyMetaSite_EffectiveInstallContactFullName EffectiveInstallContactFullName = new MyMetaSite_EffectiveInstallContactFullName();
    public final MyMetaSite_EffectiveInstallContactShortName EffectiveInstallContactShortName = new MyMetaSite_EffectiveInstallContactShortName();
    public final MyMetaSite_EffectiveInstallContactSummaryMultiline EffectiveInstallContactSummaryMultiline = new MyMetaSite_EffectiveInstallContactSummaryMultiline();
    public final MyMetaSite_EffectiveInstallContactEmail EffectiveInstallContactEmail = new MyMetaSite_EffectiveInstallContactEmail();
    public final MyMetaSite_EffectiveInstallContactPhone EffectiveInstallContactPhone = new MyMetaSite_EffectiveInstallContactPhone();
    public final MyMetaSite_EffectiveRequesterContactFullName EffectiveRequesterContactFullName = new MyMetaSite_EffectiveRequesterContactFullName();
    public final MyMetaSite_EffectiveRequesterContactShortName EffectiveRequesterContactShortName = new MyMetaSite_EffectiveRequesterContactShortName();
    public final MyMetaSite_EffectiveRequesterContactSummaryMultiline EffectiveRequesterContactSummaryMultiline = new MyMetaSite_EffectiveRequesterContactSummaryMultiline();
    public final MyMetaSite_EffectiveRequesterContactEmail EffectiveRequesterContactEmail = new MyMetaSite_EffectiveRequesterContactEmail();
    public final MyMetaSite_EffectiveRequesterContactPhone EffectiveRequesterContactPhone = new MyMetaSite_EffectiveRequesterContactPhone();
    public final MyMetaSite_EffectiveSalesContactFullName EffectiveSalesContactFullName = new MyMetaSite_EffectiveSalesContactFullName();
    public final MyMetaSite_EffectiveSalesContactShortName EffectiveSalesContactShortName = new MyMetaSite_EffectiveSalesContactShortName();
    public final MyMetaSite_EffectiveSalesContactSummaryMultiline EffectiveSalesContactSummaryMultiline = new MyMetaSite_EffectiveSalesContactSummaryMultiline();
    public final MyMetaSite_EffectiveSalesContactEmail EffectiveSalesContactEmail = new MyMetaSite_EffectiveSalesContactEmail();
    public final MyMetaSite_EffectiveSalesContactPhone EffectiveSalesContactPhone = new MyMetaSite_EffectiveSalesContactPhone();
    public final MyMetaSite_EffectiveSchedulingContactFullName EffectiveSchedulingContactFullName = new MyMetaSite_EffectiveSchedulingContactFullName();
    public final MyMetaSite_EffectiveSchedulingContactShortName EffectiveSchedulingContactShortName = new MyMetaSite_EffectiveSchedulingContactShortName();
    public final MyMetaSite_EffectiveSchedulingContactSummaryMultiline EffectiveSchedulingContactSummaryMultiline = new MyMetaSite_EffectiveSchedulingContactSummaryMultiline();
    public final MyMetaSite_EffectiveSchedulingContactEmail EffectiveSchedulingContactEmail = new MyMetaSite_EffectiveSchedulingContactEmail();
    public final MyMetaSite_EffectiveSchedulingContactPhone EffectiveSchedulingContactPhone = new MyMetaSite_EffectiveSchedulingContactPhone();
    public final MyMetaSite_EffectiveTechnicalContactFullName EffectiveTechnicalContactFullName = new MyMetaSite_EffectiveTechnicalContactFullName();
    public final MyMetaSite_EffectiveTechnicalContactShortName EffectiveTechnicalContactShortName = new MyMetaSite_EffectiveTechnicalContactShortName();
    public final MyMetaSite_EffectiveTechnicalContactSummaryMultiline EffectiveTechnicalContactSummaryMultiline = new MyMetaSite_EffectiveTechnicalContactSummaryMultiline();
    public final MyMetaSite_EffectiveTechnicalContactEmail EffectiveTechnicalContactEmail = new MyMetaSite_EffectiveTechnicalContactEmail();
    public final MyMetaSite_EffectiveTechnicalContactPhone EffectiveTechnicalContactPhone = new MyMetaSite_EffectiveTechnicalContactPhone();
    public final MyMetaSite_InstallContactFullName InstallContactFullName = new MyMetaSite_InstallContactFullName();
    public final MyMetaSite_InstallContactShortName InstallContactShortName = new MyMetaSite_InstallContactShortName();
    public final MyMetaSite_InstallContactSummaryMultiline InstallContactSummaryMultiline = new MyMetaSite_InstallContactSummaryMultiline();
    public final MyMetaSite_InstallContactEmail InstallContactEmail = new MyMetaSite_InstallContactEmail();
    public final MyMetaSite_InstallContactPhone InstallContactPhone = new MyMetaSite_InstallContactPhone();
    public final MyMetaSite_MainContactFullName MainContactFullName = new MyMetaSite_MainContactFullName();
    public final MyMetaSite_MainContactShortName MainContactShortName = new MyMetaSite_MainContactShortName();
    public final MyMetaSite_MainContactSummaryMultiline MainContactSummaryMultiline = new MyMetaSite_MainContactSummaryMultiline();
    public final MyMetaSite_MainContactEmail MainContactEmail = new MyMetaSite_MainContactEmail();
    public final MyMetaSite_MainContactPhone MainContactPhone = new MyMetaSite_MainContactPhone();
    public final MyMetaSite_RequesterContactFullName RequesterContactFullName = new MyMetaSite_RequesterContactFullName();
    public final MyMetaSite_RequesterContactShortName RequesterContactShortName = new MyMetaSite_RequesterContactShortName();
    public final MyMetaSite_RequesterContactSummaryMultiline RequesterContactSummaryMultiline = new MyMetaSite_RequesterContactSummaryMultiline();
    public final MyMetaSite_RequesterContactEmail RequesterContactEmail = new MyMetaSite_RequesterContactEmail();
    public final MyMetaSite_RequesterContactPhone RequesterContactPhone = new MyMetaSite_RequesterContactPhone();
    public final MyMetaSite_SalesContactFullName SalesContactFullName = new MyMetaSite_SalesContactFullName();
    public final MyMetaSite_SalesContactShortName SalesContactShortName = new MyMetaSite_SalesContactShortName();
    public final MyMetaSite_SalesContactSummaryMultiline SalesContactSummaryMultiline = new MyMetaSite_SalesContactSummaryMultiline();
    public final MyMetaSite_SalesContactEmail SalesContactEmail = new MyMetaSite_SalesContactEmail();
    public final MyMetaSite_SalesContactPhone SalesContactPhone = new MyMetaSite_SalesContactPhone();
    public final MyMetaSite_SchedulingContactFullName SchedulingContactFullName = new MyMetaSite_SchedulingContactFullName();
    public final MyMetaSite_SchedulingContactShortName SchedulingContactShortName = new MyMetaSite_SchedulingContactShortName();
    public final MyMetaSite_SchedulingContactSummaryMultiline SchedulingContactSummaryMultiline = new MyMetaSite_SchedulingContactSummaryMultiline();
    public final MyMetaSite_SchedulingContactEmail SchedulingContactEmail = new MyMetaSite_SchedulingContactEmail();
    public final MyMetaSite_SchedulingContactPhone SchedulingContactPhone = new MyMetaSite_SchedulingContactPhone();
    public final MyMetaSite_TechnicalContactFullName TechnicalContactFullName = new MyMetaSite_TechnicalContactFullName();
    public final MyMetaSite_TechnicalContactShortName TechnicalContactShortName = new MyMetaSite_TechnicalContactShortName();
    public final MyMetaSite_TechnicalContactSummaryMultiline TechnicalContactSummaryMultiline = new MyMetaSite_TechnicalContactSummaryMultiline();
    public final MyMetaSite_TechnicalContactEmail TechnicalContactEmail = new MyMetaSite_TechnicalContactEmail();
    public final MyMetaSite_TechnicalContactPhone TechnicalContactPhone = new MyMetaSite_TechnicalContactPhone();
    public final MyMetaSite_TypeName TypeName = new MyMetaSite_TypeName();
    public final MyMetaSite_UpdatedByFullName UpdatedByFullName = new MyMetaSite_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaSite_CreatedBy CreatedBy = new MyMetaSite_CreatedBy();
    public final MyMetaSite_Customer Customer = new MyMetaSite_Customer();
    public final MyMetaSite_EffectiveInstallContact EffectiveInstallContact = new MyMetaSite_EffectiveInstallContact();
    public final MyMetaSite_EffectiveRequesterContact EffectiveRequesterContact = new MyMetaSite_EffectiveRequesterContact();
    public final MyMetaSite_EffectiveSalesContact EffectiveSalesContact = new MyMetaSite_EffectiveSalesContact();
    public final MyMetaSite_EffectiveSchedulingContact EffectiveSchedulingContact = new MyMetaSite_EffectiveSchedulingContact();
    public final MyMetaSite_EffectiveTechnicalContact EffectiveTechnicalContact = new MyMetaSite_EffectiveTechnicalContact();
    public final MyMetaSite_InstallContact InstallContact = new MyMetaSite_InstallContact();
    public final MyMetaSite_MainContact MainContact = new MyMetaSite_MainContact();
    public final MyMetaSite_Priority Priority = new MyMetaSite_Priority();
    public final MyMetaSite_RequesterContact RequesterContact = new MyMetaSite_RequesterContact();
    public final MyMetaSite_SalesContact SalesContact = new MyMetaSite_SalesContact();
    public final MyMetaSite_SchedulingContact SchedulingContact = new MyMetaSite_SchedulingContact();
    public final MyMetaSite_TechnicalContact TechnicalContact = new MyMetaSite_TechnicalContact();
    public final MyMetaSite_Type Type = new MyMetaSite_Type();
    public final MyMetaSite_UpdatedBy UpdatedBy = new MyMetaSite_UpdatedBy();

    //##################################################
    //# AddressAttention
    //##################################################

    public class MyMetaSite_AddressAttention
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressAttention";
        }

        @Override
        public String getLabel()
        {
            return "Address Attention";
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
            return MySiteValidator.instance.getAddressAttentionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressAttention";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressAttention();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressAttention(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressAttention(value);
        }
    }

    //##################################################
    //# AddressCity
    //##################################################

    public class MyMetaSite_AddressCity
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressCity";
        }

        @Override
        public String getLabel()
        {
            return "Address City";
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
            return MySiteValidator.instance.getAddressCityValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressCity";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressCity();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressCity(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressCity(value);
        }
    }

    //##################################################
    //# AddressCountry
    //##################################################

    public class MyMetaSite_AddressCountry
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressCountry";
        }

        @Override
        public String getLabel()
        {
            return "Address Country";
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
            return MySiteValidator.instance.getAddressCountryValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressCountry";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressCountry();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressCountry(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressCountry(value);
        }
    }

    //##################################################
    //# AddressLongLine
    //##################################################

    public class MyMetaSite_AddressLongLine
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "addressLongLine";
        }

        @Override
        public String getLabel()
        {
            return "Address";
        }

        @Override
        public String getHelp()
        {
            return "The long format of the site address.";
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
        public String getValueFor(MySite model)
        {
            return model.getAddressLongLine();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressLongLine(value);
        }
    }

    //##################################################
    //# AddressMultiLine
    //##################################################

    public class MyMetaSite_AddressMultiLine
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "addressMultiLine";
        }

        @Override
        public String getLabel()
        {
            return "Address";
        }

        @Override
        public String getHelp()
        {
            return "The multi-line format of the site address.";
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
        public String getValueFor(MySite model)
        {
            return model.getAddressMultiLine();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressMultiLine(value);
        }
    }

    //##################################################
    //# AddressPhone
    //##################################################

    public class MyMetaSite_AddressPhone
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressPhone";
        }

        @Override
        public String getLabel()
        {
            return "Address Phone";
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
            return MySiteValidator.instance.getAddressPhoneValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressPhone";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressPhone(value);
        }
    }

    //##################################################
    //# AddressPostalCode
    //##################################################

    public class MyMetaSite_AddressPostalCode
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressPostalCode";
        }

        @Override
        public String getLabel()
        {
            return "Address Postal Code";
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
            return MySiteValidator.instance.getAddressPostalCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressPostalCode";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressPostalCode();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressPostalCode(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressPostalCode(value);
        }
    }

    //##################################################
    //# AddressRegion
    //##################################################

    public class MyMetaSite_AddressRegion
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressRegion";
        }

        @Override
        public String getLabel()
        {
            return "State";
        }

        @Override
        public String getHelp()
        {
            return "The name or abbreviation of the of the state (or region).";
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
            return MySiteValidator.instance.getAddressRegionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressRegion";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressRegion();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressRegion(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressRegion(value);
        }
    }

    //##################################################
    //# AddressShortLine
    //##################################################

    public class MyMetaSite_AddressShortLine
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "addressShortLine";
        }

        @Override
        public String getLabel()
        {
            return "Address";
        }

        @Override
        public String getHelp()
        {
            return "The short format of the site address.";
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
        public String getValueFor(MySite model)
        {
            return model.getAddressShortLine();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressShortLine(value);
        }
    }

    //##################################################
    //# AddressStreet1
    //##################################################

    public class MyMetaSite_AddressStreet1
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressStreet1";
        }

        @Override
        public String getLabel()
        {
            return "Address Street1";
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
            return MySiteValidator.instance.getAddressStreet1Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressStreet1";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressStreet1();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressStreet1(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressStreet1(value);
        }
    }

    //##################################################
    //# AddressStreet2
    //##################################################

    public class MyMetaSite_AddressStreet2
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "addressStreet2";
        }

        @Override
        public String getLabel()
        {
            return "Address Street2";
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
            return MySiteValidator.instance.getAddressStreet2Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "addressStreet2";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getAddressStreet2();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setAddressStreet2(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAddressStreet2(value);
        }
    }

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaSite_AuditLogTitle
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaSite_CreatedUtcTs
        extends KmMetaTimestampProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,KmTimestamp>
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
            return MySiteValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public KmTimestamp getValueFor(MySite model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MySite model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MySite model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaSite_DomainSubtitle
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaSite_DomainTitle
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaSite_Enabled
        extends KmMetaBooleanProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,Boolean>
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
            return MySiteValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public Boolean getValueFor(MySite model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MySite model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MySite model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaSite_EnabledStatus
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# FullName
    //##################################################

    public class MyMetaSite_FullName
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "fullName";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "The site number and name.";
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
            return MySiteValidator.instance.getFullNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fullName";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasFullName(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaSite_Name
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
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
            return "The site's name.  E.g.: Denver North.";
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
            return MySiteValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Number
    //##################################################

    public class MyMetaSite_Number
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "number";
        }

        @Override
        public String getLabel()
        {
            return "Number";
        }

        @Override
        public String getHelp()
        {
            return "The site's number.  E.g.: 0001.";
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
            return MySiteValidator.instance.getNumberValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "number";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getNumber();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setNumber(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasNumber(value);
        }
    }

    //##################################################
    //# PriorityName
    //##################################################

    public class MyMetaSite_PriorityName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "priorityName";
        }

        @Override
        public String getLabel()
        {
            return "Priority";
        }

        @Override
        public String getHelp()
        {
            return "This is used to prioritize important tasks.";
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
        public String getValueFor(MySite model)
        {
            return model.getPriorityName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasPriorityName(value);
        }
    }

    //##################################################
    //# TimeZoneCode
    //##################################################

    public class MyMetaSite_TimeZoneCode
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
    {
        @Override
        public String getName()
        {
            return "timeZoneCode";
        }

        @Override
        public String getLabel()
        {
            return "Time Zone";
        }

        @Override
        public String getHelp()
        {
            return "The time zone for this site.";
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
            return MySiteValidator.instance.getTimeZoneCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "timeZoneCode";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getTimeZoneCode();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setTimeZoneCode(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTimeZoneCode(value);
        }
    }

    //##################################################
    //# TimeZoneName
    //##################################################

    public class MyMetaSite_TimeZoneName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "timeZoneName";
        }

        @Override
        public String getLabel()
        {
            return "Time Zone";
        }

        @Override
        public String getHelp()
        {
            return "The time zone for this site.";
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
        public String getValueFor(MySite model)
        {
            return model.getTimeZoneName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTimeZoneName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaSite_Uid
        extends KmMetaStringProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,String>
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
            return MySiteValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        public KmDaoStringKeyCursor<MySite> createCursor()
        {
            KmDaoStringKeyCursor<MySite> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MySite model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaSite_UpdatedUtcTs
        extends KmMetaTimestampProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,KmTimestamp>
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
            return MySiteValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public KmTimestamp getValueFor(MySite model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MySite model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MySite model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaSite_LockVersion
        extends KmMetaIntegerProperty<MySite>
        implements KmMetaDaoPropertyIF<MySite,Integer>
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
            return MySiteValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MySiteDao getDao()
        {
            return getAccess().getSiteDao();
        }

        @Override
        public Integer getValueFor(MySite model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MySite model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MySite model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaSite_CreatedLocalTs
        extends KmMetaTimestampProperty<MySite>
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
        public KmTimestamp getValueFor(MySite model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MySite model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaSite_CreatedLocalTsMessage
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaSite_CreatedLocalDate
        extends KmMetaDateProperty<MySite>
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
        public KmDate getValueFor(MySite model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MySite model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaSite_CreatedLocalTime
        extends KmMetaTimeProperty<MySite>
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
        public KmTime getValueFor(MySite model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MySite model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaSite_UpdatedLocalTs
        extends KmMetaTimestampProperty<MySite>
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
        public KmTimestamp getValueFor(MySite model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MySite model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaSite_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaSite_UpdatedLocalDate
        extends KmMetaDateProperty<MySite>
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
        public KmDate getValueFor(MySite model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MySite model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaSite_UpdatedLocalTime
        extends KmMetaTimeProperty<MySite>
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
        public KmTime getValueFor(MySite model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MySite model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaSite_CreatedByFullName
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# CustomerName
    //##################################################

    public class MyMetaSite_CustomerName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "customerName";
        }

        @Override
        public String getLabel()
        {
            return "Customer Name";
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
        public String getValueFor(MySite model)
        {
            return model.getCustomerName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setCustomerName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasCustomerName(value);
        }
    }

    //##################################################
    //# EffectiveInstallContactFullName
    //##################################################

    public class MyMetaSite_EffectiveInstallContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveInstallContactFullName";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveInstallContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveInstallContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveInstallContactFullName(value);
        }
    }

    //##################################################
    //# EffectiveInstallContactShortName
    //##################################################

    public class MyMetaSite_EffectiveInstallContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveInstallContactShortName";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveInstallContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveInstallContactShortName(value);
        }
    }

    //##################################################
    //# EffectiveInstallContactSummaryMultiline
    //##################################################

    public class MyMetaSite_EffectiveInstallContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveInstallContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Install  Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveInstallContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveInstallContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# EffectiveInstallContactEmail
    //##################################################

    public class MyMetaSite_EffectiveInstallContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveInstallContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Effective Install Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveInstallContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveInstallContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveInstallContactEmail(value);
        }
    }

    //##################################################
    //# EffectiveInstallContactPhone
    //##################################################

    public class MyMetaSite_EffectiveInstallContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveInstallContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Effective Install Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveInstallContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveInstallContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveInstallContactPhone(value);
        }
    }

    //##################################################
    //# EffectiveRequesterContactFullName
    //##################################################

    public class MyMetaSite_EffectiveRequesterContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveRequesterContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Requester Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveRequesterContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveRequesterContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveRequesterContactFullName(value);
        }
    }

    //##################################################
    //# EffectiveRequesterContactShortName
    //##################################################

    public class MyMetaSite_EffectiveRequesterContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveRequesterContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Requester Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveRequesterContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveRequesterContactShortName(value);
        }
    }

    //##################################################
    //# EffectiveRequesterContactSummaryMultiline
    //##################################################

    public class MyMetaSite_EffectiveRequesterContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveRequesterContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Requester Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveRequesterContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveRequesterContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# EffectiveRequesterContactEmail
    //##################################################

    public class MyMetaSite_EffectiveRequesterContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveRequesterContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Effective Requester Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveRequesterContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveRequesterContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveRequesterContactEmail(value);
        }
    }

    //##################################################
    //# EffectiveRequesterContactPhone
    //##################################################

    public class MyMetaSite_EffectiveRequesterContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveRequesterContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Effective Requester Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveRequesterContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveRequesterContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveRequesterContactPhone(value);
        }
    }

    //##################################################
    //# EffectiveSalesContactFullName
    //##################################################

    public class MyMetaSite_EffectiveSalesContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSalesContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSalesContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveSalesContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSalesContactFullName(value);
        }
    }

    //##################################################
    //# EffectiveSalesContactShortName
    //##################################################

    public class MyMetaSite_EffectiveSalesContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSalesContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSalesContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSalesContactShortName(value);
        }
    }

    //##################################################
    //# EffectiveSalesContactSummaryMultiline
    //##################################################

    public class MyMetaSite_EffectiveSalesContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSalesContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSalesContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSalesContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# EffectiveSalesContactEmail
    //##################################################

    public class MyMetaSite_EffectiveSalesContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSalesContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Effective Sales Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSalesContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveSalesContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSalesContactEmail(value);
        }
    }

    //##################################################
    //# EffectiveSalesContactPhone
    //##################################################

    public class MyMetaSite_EffectiveSalesContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSalesContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Effective Sales Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSalesContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveSalesContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSalesContactPhone(value);
        }
    }

    //##################################################
    //# EffectiveSchedulingContactFullName
    //##################################################

    public class MyMetaSite_EffectiveSchedulingContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSchedulingContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSchedulingContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveSchedulingContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSchedulingContactFullName(value);
        }
    }

    //##################################################
    //# EffectiveSchedulingContactShortName
    //##################################################

    public class MyMetaSite_EffectiveSchedulingContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSchedulingContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSchedulingContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSchedulingContactShortName(value);
        }
    }

    //##################################################
    //# EffectiveSchedulingContactSummaryMultiline
    //##################################################

    public class MyMetaSite_EffectiveSchedulingContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSchedulingContactSummaryMultiline";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSchedulingContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSchedulingContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# EffectiveSchedulingContactEmail
    //##################################################

    public class MyMetaSite_EffectiveSchedulingContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSchedulingContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Effective Scheduling Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSchedulingContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveSchedulingContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSchedulingContactEmail(value);
        }
    }

    //##################################################
    //# EffectiveSchedulingContactPhone
    //##################################################

    public class MyMetaSite_EffectiveSchedulingContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveSchedulingContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Effective Scheduling Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveSchedulingContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveSchedulingContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveSchedulingContactPhone(value);
        }
    }

    //##################################################
    //# EffectiveTechnicalContactFullName
    //##################################################

    public class MyMetaSite_EffectiveTechnicalContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveTechnicalContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveTechnicalContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveTechnicalContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveTechnicalContactFullName(value);
        }
    }

    //##################################################
    //# EffectiveTechnicalContactShortName
    //##################################################

    public class MyMetaSite_EffectiveTechnicalContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveTechnicalContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveTechnicalContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveTechnicalContactShortName(value);
        }
    }

    //##################################################
    //# EffectiveTechnicalContactSummaryMultiline
    //##################################################

    public class MyMetaSite_EffectiveTechnicalContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveTechnicalContactSummaryMultiline";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveTechnicalContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveTechnicalContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# EffectiveTechnicalContactEmail
    //##################################################

    public class MyMetaSite_EffectiveTechnicalContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveTechnicalContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Effective Technical Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveTechnicalContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveTechnicalContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveTechnicalContactEmail(value);
        }
    }

    //##################################################
    //# EffectiveTechnicalContactPhone
    //##################################################

    public class MyMetaSite_EffectiveTechnicalContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "effectiveTechnicalContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Effective Technical Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getEffectiveTechnicalContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setEffectiveTechnicalContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasEffectiveTechnicalContactPhone(value);
        }
    }

    //##################################################
    //# InstallContactFullName
    //##################################################

    public class MyMetaSite_InstallContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "installContactFullName";
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
        public String getValueFor(MySite model)
        {
            return model.getInstallContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setInstallContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasInstallContactFullName(value);
        }
    }

    //##################################################
    //# InstallContactShortName
    //##################################################

    public class MyMetaSite_InstallContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "installContactShortName";
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
        public String getValueFor(MySite model)
        {
            return model.getInstallContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasInstallContactShortName(value);
        }
    }

    //##################################################
    //# InstallContactSummaryMultiline
    //##################################################

    public class MyMetaSite_InstallContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "installContactSummaryMultiline";
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
        public String getValueFor(MySite model)
        {
            return model.getInstallContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasInstallContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# InstallContactEmail
    //##################################################

    public class MyMetaSite_InstallContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "installContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Install Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getInstallContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setInstallContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasInstallContactEmail(value);
        }
    }

    //##################################################
    //# InstallContactPhone
    //##################################################

    public class MyMetaSite_InstallContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "installContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Install Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getInstallContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setInstallContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasInstallContactPhone(value);
        }
    }

    //##################################################
    //# MainContactFullName
    //##################################################

    public class MyMetaSite_MainContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "mainContactFullName";
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
        public String getValueFor(MySite model)
        {
            return model.getMainContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setMainContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasMainContactFullName(value);
        }
    }

    //##################################################
    //# MainContactShortName
    //##################################################

    public class MyMetaSite_MainContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "mainContactShortName";
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
        public String getValueFor(MySite model)
        {
            return model.getMainContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasMainContactShortName(value);
        }
    }

    //##################################################
    //# MainContactSummaryMultiline
    //##################################################

    public class MyMetaSite_MainContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "mainContactSummaryMultiline";
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
        public String getValueFor(MySite model)
        {
            return model.getMainContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasMainContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# MainContactEmail
    //##################################################

    public class MyMetaSite_MainContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "mainContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Main Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getMainContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setMainContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasMainContactEmail(value);
        }
    }

    //##################################################
    //# MainContactPhone
    //##################################################

    public class MyMetaSite_MainContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "mainContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Main Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getMainContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setMainContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasMainContactPhone(value);
        }
    }

    //##################################################
    //# RequesterContactFullName
    //##################################################

    public class MyMetaSite_RequesterContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "requesterContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getRequesterContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setRequesterContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasRequesterContactFullName(value);
        }
    }

    //##################################################
    //# RequesterContactShortName
    //##################################################

    public class MyMetaSite_RequesterContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "requesterContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getRequesterContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasRequesterContactShortName(value);
        }
    }

    //##################################################
    //# RequesterContactSummaryMultiline
    //##################################################

    public class MyMetaSite_RequesterContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "requesterContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getRequesterContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasRequesterContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# RequesterContactEmail
    //##################################################

    public class MyMetaSite_RequesterContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "requesterContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Requester Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getRequesterContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setRequesterContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasRequesterContactEmail(value);
        }
    }

    //##################################################
    //# RequesterContactPhone
    //##################################################

    public class MyMetaSite_RequesterContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "requesterContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Requester Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getRequesterContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setRequesterContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasRequesterContactPhone(value);
        }
    }

    //##################################################
    //# SalesContactFullName
    //##################################################

    public class MyMetaSite_SalesContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "salesContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getSalesContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setSalesContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSalesContactFullName(value);
        }
    }

    //##################################################
    //# SalesContactShortName
    //##################################################

    public class MyMetaSite_SalesContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "salesContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getSalesContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSalesContactShortName(value);
        }
    }

    //##################################################
    //# SalesContactSummaryMultiline
    //##################################################

    public class MyMetaSite_SalesContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "salesContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getSalesContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSalesContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# SalesContactEmail
    //##################################################

    public class MyMetaSite_SalesContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "salesContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getSalesContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setSalesContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSalesContactEmail(value);
        }
    }

    //##################################################
    //# SalesContactPhone
    //##################################################

    public class MyMetaSite_SalesContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "salesContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getSalesContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setSalesContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSalesContactPhone(value);
        }
    }

    //##################################################
    //# SchedulingContactFullName
    //##################################################

    public class MyMetaSite_SchedulingContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "schedulingContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getSchedulingContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setSchedulingContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSchedulingContactFullName(value);
        }
    }

    //##################################################
    //# SchedulingContactShortName
    //##################################################

    public class MyMetaSite_SchedulingContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "schedulingContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getSchedulingContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSchedulingContactShortName(value);
        }
    }

    //##################################################
    //# SchedulingContactSummaryMultiline
    //##################################################

    public class MyMetaSite_SchedulingContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "schedulingContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getSchedulingContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSchedulingContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# SchedulingContactEmail
    //##################################################

    public class MyMetaSite_SchedulingContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "schedulingContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getSchedulingContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setSchedulingContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSchedulingContactEmail(value);
        }
    }

    //##################################################
    //# SchedulingContactPhone
    //##################################################

    public class MyMetaSite_SchedulingContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "schedulingContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getSchedulingContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setSchedulingContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasSchedulingContactPhone(value);
        }
    }

    //##################################################
    //# TechnicalContactFullName
    //##################################################

    public class MyMetaSite_TechnicalContactFullName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "technicalContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getTechnicalContactFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setTechnicalContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTechnicalContactFullName(value);
        }
    }

    //##################################################
    //# TechnicalContactShortName
    //##################################################

    public class MyMetaSite_TechnicalContactShortName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "technicalContactShortName";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getTechnicalContactShortName();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTechnicalContactShortName(value);
        }
    }

    //##################################################
    //# TechnicalContactSummaryMultiline
    //##################################################

    public class MyMetaSite_TechnicalContactSummaryMultiline
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "technicalContactSummaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact";
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
        public String getValueFor(MySite model)
        {
            return model.getTechnicalContactSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTechnicalContactSummaryMultiline(value);
        }
    }

    //##################################################
    //# TechnicalContactEmail
    //##################################################

    public class MyMetaSite_TechnicalContactEmail
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "technicalContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact Email";
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
        public String getValueFor(MySite model)
        {
            return model.getTechnicalContactEmail();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setTechnicalContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTechnicalContactEmail(value);
        }
    }

    //##################################################
    //# TechnicalContactPhone
    //##################################################

    public class MyMetaSite_TechnicalContactPhone
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "technicalContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact Phone";
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
        public String getValueFor(MySite model)
        {
            return model.getTechnicalContactPhone();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setTechnicalContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTechnicalContactPhone(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaSite_TypeName
        extends KmMetaStringProperty<MySite>
    {
        @Override
        public String getName()
        {
            return "typeName";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The display name of the choice.";
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
        public String getValueFor(MySite model)
        {
            return model.getTypeName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setTypeName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaSite_UpdatedByFullName
        extends KmMetaStringProperty<MySite>
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
        public String getValueFor(MySite model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MySite model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MySite model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaSite_CreatedBy
        extends KmMetaDaoAssociation<MySite,MyUser>
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
        public MyUser getValueFor(MySite model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MySite model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Customer
    //##################################################

    public class MyMetaSite_Customer
        extends KmMetaDaoAssociation<MySite,MyCustomer>
    {
        @Override
        public String getName()
        {
            return "customer";
        }

        @Override
        public String getLabel()
        {
            return "Customer";
        }

        @Override
        public String getHelp()
        {
            return "The customer that owns this site.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyCustomer getValueFor(MySite model)
        {
            return model.getCustomer();
        }

        @Override
        public void setValueFor(MySite model, MyCustomer value)
        {
            model.setCustomer(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MyCustomer value)
        {
            return model.hasCustomer(value);
        }
    }

    //##################################################
    //# EffectiveInstallContact
    //##################################################

    public class MyMetaSite_EffectiveInstallContact
        extends KmMetaAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveInstallContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Install Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for installations. This defaults to the main contact if not set.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getEffectiveInstallContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasEffectiveInstallContact(value);
        }
    }

    //##################################################
    //# EffectiveRequesterContact
    //##################################################

    public class MyMetaSite_EffectiveRequesterContact
        extends KmMetaAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveRequesterContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Requester Contact";
        }

        @Override
        public String getHelp()
        {
            return "The contact that originally requested the job. This defaults to the main contact if not set.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getEffectiveRequesterContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasEffectiveRequesterContact(value);
        }
    }

    //##################################################
    //# EffectiveSalesContact
    //##################################################

    public class MyMetaSite_EffectiveSalesContact
        extends KmMetaAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveSalesContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Sales Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for sales or distributor support. This defaults to the main contact if not set.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getEffectiveSalesContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasEffectiveSalesContact(value);
        }
    }

    //##################################################
    //# EffectiveSchedulingContact
    //##################################################

    public class MyMetaSite_EffectiveSchedulingContact
        extends KmMetaAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveSchedulingContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Scheduling Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for scheduling on-site visits. This defaults to the main contact if not set.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getEffectiveSchedulingContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasEffectiveSchedulingContact(value);
        }
    }

    //##################################################
    //# EffectiveTechnicalContact
    //##################################################

    public class MyMetaSite_EffectiveTechnicalContact
        extends KmMetaAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveTechnicalContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Technical Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for IT support and technical questions. This defaults to the main contact if not set.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getEffectiveTechnicalContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasEffectiveTechnicalContact(value);
        }
    }

    //##################################################
    //# InstallContact
    //##################################################

    public class MyMetaSite_InstallContact
        extends KmMetaDaoAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "installContact";
        }

        @Override
        public String getLabel()
        {
            return "Install Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for installations.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getInstallContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            model.setInstallContact(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasInstallContact(value);
        }
    }

    //##################################################
    //# MainContact
    //##################################################

    public class MyMetaSite_MainContact
        extends KmMetaDaoAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "mainContact";
        }

        @Override
        public String getLabel()
        {
            return "Main Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for this site.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getMainContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            model.setMainContact(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasMainContact(value);
        }
    }

    //##################################################
    //# Priority
    //##################################################

    public class MyMetaSite_Priority
        extends KmMetaDaoAssociation<MySite,MyPriority>
    {
        @Override
        public String getName()
        {
            return "priority";
        }

        @Override
        public String getLabel()
        {
            return "Priority";
        }

        @Override
        public String getHelp()
        {
            return "This is used to prioritize important tasks.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyPriority getValueFor(MySite model)
        {
            return model.getPriority();
        }

        @Override
        public void setValueFor(MySite model, MyPriority value)
        {
            model.setPriority(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MyPriority value)
        {
            return model.hasPriority(value);
        }
    }

    //##################################################
    //# RequesterContact
    //##################################################

    public class MyMetaSite_RequesterContact
        extends KmMetaDaoAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "requesterContact";
        }

        @Override
        public String getLabel()
        {
            return "Requester Contact";
        }

        @Override
        public String getHelp()
        {
            return "The contact that originally requested the job.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getRequesterContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            model.setRequesterContact(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasRequesterContact(value);
        }
    }

    //##################################################
    //# SalesContact
    //##################################################

    public class MyMetaSite_SalesContact
        extends KmMetaDaoAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "salesContact";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for sales or distributor support.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getSalesContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            model.setSalesContact(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasSalesContact(value);
        }
    }

    //##################################################
    //# SchedulingContact
    //##################################################

    public class MyMetaSite_SchedulingContact
        extends KmMetaDaoAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "schedulingContact";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for scheduling on-site visits.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getSchedulingContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            model.setSchedulingContact(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasSchedulingContact(value);
        }
    }

    //##################################################
    //# TechnicalContact
    //##################################################

    public class MyMetaSite_TechnicalContact
        extends KmMetaDaoAssociation<MySite,MySiteContact>
    {
        @Override
        public String getName()
        {
            return "technicalContact";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact";
        }

        @Override
        public String getHelp()
        {
            return "The primary contact for IT support and technical questions.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySiteContact getValueFor(MySite model)
        {
            return model.getTechnicalContact();
        }

        @Override
        public void setValueFor(MySite model, MySiteContact value)
        {
            model.setTechnicalContact(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MySiteContact value)
        {
            return model.hasTechnicalContact(value);
        }
    }

    //##################################################
    //# Type
    //##################################################

    public class MyMetaSite_Type
        extends KmMetaDaoAssociation<MySite,MyChoice>
    {
        @Override
        public String getName()
        {
            return "type";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The site's type.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyChoice getValueFor(MySite model)
        {
            return model.getType();
        }

        @Override
        public void setValueFor(MySite model, MyChoice value)
        {
            model.setType(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MyChoice value)
        {
            return model.hasType(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaSite_UpdatedBy
        extends KmMetaDaoAssociation<MySite,MyUser>
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
        public MyUser getValueFor(MySite model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MySite model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MySite model, MyUser value)
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
