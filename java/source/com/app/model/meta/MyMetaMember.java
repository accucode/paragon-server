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

public class MyMetaMember
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaMember instance = new MyMetaMember();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaMember()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "member";
    }

    public MyMemberValidator getValidator()
    {
        return MyMemberValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The list of members determines which users have access to a specific project. Although users are global, their roles, skills, and access may vary by project.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaMember_AuditLogTitle AuditLogTitle = new MyMetaMember_AuditLogTitle();
    public final MyMetaMember_CreatedUtcTs CreatedUtcTs = new MyMetaMember_CreatedUtcTs();
    public final MyMetaMember_DashboardLineCount1 DashboardLineCount1 = new MyMetaMember_DashboardLineCount1();
    public final MyMetaMember_DashboardLineCount2 DashboardLineCount2 = new MyMetaMember_DashboardLineCount2();
    public final MyMetaMember_DashboardOrientationTypeCode DashboardOrientationTypeCode = new MyMetaMember_DashboardOrientationTypeCode();
    public final MyMetaMember_DashboardPanelCodeA DashboardPanelCodeA = new MyMetaMember_DashboardPanelCodeA();
    public final MyMetaMember_DashboardPanelCodeB DashboardPanelCodeB = new MyMetaMember_DashboardPanelCodeB();
    public final MyMetaMember_DashboardPanelCodeC DashboardPanelCodeC = new MyMetaMember_DashboardPanelCodeC();
    public final MyMetaMember_DashboardPanelCodeD DashboardPanelCodeD = new MyMetaMember_DashboardPanelCodeD();
    public final MyMetaMember_DashboardPanelCodeE DashboardPanelCodeE = new MyMetaMember_DashboardPanelCodeE();
    public final MyMetaMember_DashboardPanelCodeF DashboardPanelCodeF = new MyMetaMember_DashboardPanelCodeF();
    public final MyMetaMember_DashboardPanelCodeG DashboardPanelCodeG = new MyMetaMember_DashboardPanelCodeG();
    public final MyMetaMember_DashboardRefreshMinutes DashboardRefreshMinutes = new MyMetaMember_DashboardRefreshMinutes();
    public final MyMetaMember_DomainSubtitle DomainSubtitle = new MyMetaMember_DomainSubtitle();
    public final MyMetaMember_DomainTitle DomainTitle = new MyMetaMember_DomainTitle();
    public final MyMetaMember_Enabled Enabled = new MyMetaMember_Enabled();
    public final MyMetaMember_EnabledStatus EnabledStatus = new MyMetaMember_EnabledStatus();
    public final MyMetaMember_RoleCode RoleCode = new MyMetaMember_RoleCode();
    public final MyMetaMember_RoleDescription RoleDescription = new MyMetaMember_RoleDescription();
    public final MyMetaMember_Uid Uid = new MyMetaMember_Uid();
    public final MyMetaMember_UpdatedUtcTs UpdatedUtcTs = new MyMetaMember_UpdatedUtcTs();
    public final MyMetaMember_LockVersion LockVersion = new MyMetaMember_LockVersion();
    public final MyMetaMember_RoleName RoleName = new MyMetaMember_RoleName();
    public final MyMetaMember_CreatedLocalTs CreatedLocalTs = new MyMetaMember_CreatedLocalTs();
    public final MyMetaMember_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaMember_CreatedLocalTsMessage();
    public final MyMetaMember_CreatedLocalDate CreatedLocalDate = new MyMetaMember_CreatedLocalDate();
    public final MyMetaMember_CreatedLocalTime CreatedLocalTime = new MyMetaMember_CreatedLocalTime();
    public final MyMetaMember_UpdatedLocalTs UpdatedLocalTs = new MyMetaMember_UpdatedLocalTs();
    public final MyMetaMember_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaMember_UpdatedLocalTsMessage();
    public final MyMetaMember_UpdatedLocalDate UpdatedLocalDate = new MyMetaMember_UpdatedLocalDate();
    public final MyMetaMember_UpdatedLocalTime UpdatedLocalTime = new MyMetaMember_UpdatedLocalTime();
    public final MyMetaMember_CreatedByFullName CreatedByFullName = new MyMetaMember_CreatedByFullName();
    public final MyMetaMember_ProjectName ProjectName = new MyMetaMember_ProjectName();
    public final MyMetaMember_UpdatedByFullName UpdatedByFullName = new MyMetaMember_UpdatedByFullName();
    public final MyMetaMember_UserFullName UserFullName = new MyMetaMember_UserFullName();
    public final MyMetaMember_UserEmail UserEmail = new MyMetaMember_UserEmail();
    public final MyMetaMember_UserTimeZoneCode UserTimeZoneCode = new MyMetaMember_UserTimeZoneCode();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaMember_CreatedBy CreatedBy = new MyMetaMember_CreatedBy();
    public final MyMetaMember_Project Project = new MyMetaMember_Project();
    public final MyMetaMember_UpdatedBy UpdatedBy = new MyMetaMember_UpdatedBy();
    public final MyMetaMember_User User = new MyMetaMember_User();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaMember_AuditLogTitle
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaMember_CreatedUtcTs
        extends KmMetaTimestampProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,KmTimestamp>
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
            return MyMemberValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public KmTimestamp getValueFor(MyMember model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyMember model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DashboardLineCount1
    //##################################################

    public class MyMetaMember_DashboardLineCount1
        extends KmMetaIntegerProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,Integer>
    {
        @Override
        public String getName()
        {
            return "dashboardLineCount1";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Line Count1";
        }

        @Override
        public String getHelp()
        {
            return "The number of panels to display on the first line, 0-3.";
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
            return MyMemberValidator.instance.getDashboardLineCount1Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardLineCount1";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public Integer getValueFor(MyMember model)
        {
            return model.getDashboardLineCount1();
        }

        @Override
        public void setValueFor(MyMember model, Integer value)
        {
            model.setDashboardLineCount1(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, Integer value)
        {
            return model.hasDashboardLineCount1(value);
        }
    }

    //##################################################
    //# DashboardLineCount2
    //##################################################

    public class MyMetaMember_DashboardLineCount2
        extends KmMetaIntegerProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,Integer>
    {
        @Override
        public String getName()
        {
            return "dashboardLineCount2";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Line Count2";
        }

        @Override
        public String getHelp()
        {
            return "The number of panels to display on the second line, 0-3.";
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
            return MyMemberValidator.instance.getDashboardLineCount2Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardLineCount2";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public Integer getValueFor(MyMember model)
        {
            return model.getDashboardLineCount2();
        }

        @Override
        public void setValueFor(MyMember model, Integer value)
        {
            model.setDashboardLineCount2(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, Integer value)
        {
            return model.hasDashboardLineCount2(value);
        }
    }

    //##################################################
    //# DashboardOrientationTypeCode
    //##################################################

    public class MyMetaMember_DashboardOrientationTypeCode
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardOrientationTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Orientation Type Code";
        }

        @Override
        public String getHelp()
        {
            return "Indicates whether the dashboard should be organized for portrait or landscape. The 'Auto' mode will attempt to update the layout automatically depending on the orientation of your screen.";
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
            return MyMemberValidator.instance.getDashboardOrientationTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardOrientationTypeCode";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardOrientationTypeCode();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardOrientationTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardOrientationTypeCode(value);
        }
    }

    //##################################################
    //# DashboardPanelCodeA
    //##################################################

    public class MyMetaMember_DashboardPanelCodeA
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardPanelCodeA";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Panel CodeA";
        }

        @Override
        public String getHelp()
        {
            return "The panel to display in position A.";
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
            return MyMemberValidator.instance.getDashboardPanelCodeAValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardPanelCodeA";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardPanelCodeA();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardPanelCodeA(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardPanelCodeA(value);
        }
    }

    //##################################################
    //# DashboardPanelCodeB
    //##################################################

    public class MyMetaMember_DashboardPanelCodeB
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardPanelCodeB";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Panel CodeB";
        }

        @Override
        public String getHelp()
        {
            return "The panel to display in position B.";
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
            return MyMemberValidator.instance.getDashboardPanelCodeBValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardPanelCodeB";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardPanelCodeB();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardPanelCodeB(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardPanelCodeB(value);
        }
    }

    //##################################################
    //# DashboardPanelCodeC
    //##################################################

    public class MyMetaMember_DashboardPanelCodeC
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardPanelCodeC";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Panel CodeC";
        }

        @Override
        public String getHelp()
        {
            return "The panel to display in position B.";
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
            return MyMemberValidator.instance.getDashboardPanelCodeCValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardPanelCodeC";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardPanelCodeC();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardPanelCodeC(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardPanelCodeC(value);
        }
    }

    //##################################################
    //# DashboardPanelCodeD
    //##################################################

    public class MyMetaMember_DashboardPanelCodeD
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardPanelCodeD";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Panel CodeD";
        }

        @Override
        public String getHelp()
        {
            return "The panel to display in position D.";
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
            return MyMemberValidator.instance.getDashboardPanelCodeDValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardPanelCodeD";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardPanelCodeD();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardPanelCodeD(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardPanelCodeD(value);
        }
    }

    //##################################################
    //# DashboardPanelCodeE
    //##################################################

    public class MyMetaMember_DashboardPanelCodeE
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardPanelCodeE";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Panel CodeE";
        }

        @Override
        public String getHelp()
        {
            return "The panel to display in position E.";
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
            return MyMemberValidator.instance.getDashboardPanelCodeEValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardPanelCodeE";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardPanelCodeE();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardPanelCodeE(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardPanelCodeE(value);
        }
    }

    //##################################################
    //# DashboardPanelCodeF
    //##################################################

    public class MyMetaMember_DashboardPanelCodeF
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardPanelCodeF";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Panel CodeF";
        }

        @Override
        public String getHelp()
        {
            return "The panel to display in position F.";
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
            return MyMemberValidator.instance.getDashboardPanelCodeFValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardPanelCodeF";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardPanelCodeF();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardPanelCodeF(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardPanelCodeF(value);
        }
    }

    //##################################################
    //# DashboardPanelCodeG
    //##################################################

    public class MyMetaMember_DashboardPanelCodeG
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "dashboardPanelCodeG";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Panel CodeG";
        }

        @Override
        public String getHelp()
        {
            return "The panel to display in position G.";
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
            return MyMemberValidator.instance.getDashboardPanelCodeGValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardPanelCodeG";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getDashboardPanelCodeG();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setDashboardPanelCodeG(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDashboardPanelCodeG(value);
        }
    }

    //##################################################
    //# DashboardRefreshMinutes
    //##################################################

    public class MyMetaMember_DashboardRefreshMinutes
        extends KmMetaIntegerProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,Integer>
    {
        @Override
        public String getName()
        {
            return "dashboardRefreshMinutes";
        }

        @Override
        public String getLabel()
        {
            return "Dashboard Refresh Minutes";
        }

        @Override
        public String getHelp()
        {
            return "If set, the dashboard will be automatically refreshed every x minutes.";
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
            return MyMemberValidator.instance.getDashboardRefreshMinutesValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dashboardRefreshMinutes";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public Integer getValueFor(MyMember model)
        {
            return model.getDashboardRefreshMinutes();
        }

        @Override
        public void setValueFor(MyMember model, Integer value)
        {
            model.setDashboardRefreshMinutes(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, Integer value)
        {
            return model.hasDashboardRefreshMinutes(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaMember_DomainSubtitle
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaMember_DomainTitle
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaMember_Enabled
        extends KmMetaBooleanProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,Boolean>
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
            return MyMemberValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public Boolean getValueFor(MyMember model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyMember model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaMember_EnabledStatus
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# RoleCode
    //##################################################

    public class MyMetaMember_RoleCode
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
    {
        @Override
        public String getName()
        {
            return "roleCode";
        }

        @Override
        public String getLabel()
        {
            return "Role";
        }

        @Override
        public String getHelp()
        {
            return "The member's role.\n\n Manager, is allowed to manage project wide settings like members, the item catalog, and task setup.\n\n Worker, has basic project access.  Can view and update job, perform tasks, etc.";
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
            return MyMemberValidator.instance.getRoleCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "roleCode";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyMemberRole::values);
            return e;
        }

        public ScDynamicEnumDropdownField newDropdown(String label)
        {
            ScDynamicEnumDropdownField e;
            e = newDropdown();
            e.setLabel(label);
            return e;
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getRoleCode();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setRoleCode(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasRoleCode(value);
        }
    }

    //##################################################
    //# RoleDescription
    //##################################################

    public class MyMetaMember_RoleDescription
        extends KmMetaStringProperty<MyMember>
    {
        @Override
        public String getName()
        {
            return "roleDescription";
        }

        @Override
        public String getLabel()
        {
            return "Role";
        }

        @Override
        public String getHelp()
        {
            return "The role'e name along with additional details such as the customer name.";
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
        public String getValueFor(MyMember model)
        {
            return model.getRoleDescription();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasRoleDescription(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaMember_Uid
        extends KmMetaStringProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,String>
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
            return MyMemberValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        public KmDaoStringKeyCursor<MyMember> createCursor()
        {
            KmDaoStringKeyCursor<MyMember> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaMember_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,KmTimestamp>
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
            return MyMemberValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public KmTimestamp getValueFor(MyMember model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyMember model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaMember_LockVersion
        extends KmMetaIntegerProperty<MyMember>
        implements KmMetaDaoPropertyIF<MyMember,Integer>
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
            return MyMemberValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyMemberDao getDao()
        {
            return getAccess().getMemberDao();
        }

        @Override
        public Integer getValueFor(MyMember model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyMember model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# RoleName
    //##################################################

    public class MyMetaMember_RoleName
        extends KmMetaStringProperty<MyMember>
    {
        @Override
        public String getName()
        {
            return "roleName";
        }

        @Override
        public String getLabel()
        {
            return "Role";
        }

        @Override
        public String getHelp()
        {
            return "The member's role.\n\n Manager, is allowed to manage project wide settings like members, the item catalog, and task setup.\n\n Worker, has basic project access.  Can view and update job, perform tasks, etc.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyMember model)
        {
            return model.getRoleName();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasRoleName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaMember_CreatedLocalTs
        extends KmMetaTimestampProperty<MyMember>
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
        public KmTimestamp getValueFor(MyMember model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyMember model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaMember_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaMember_CreatedLocalDate
        extends KmMetaDateProperty<MyMember>
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
        public KmDate getValueFor(MyMember model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyMember model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaMember_CreatedLocalTime
        extends KmMetaTimeProperty<MyMember>
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
        public KmTime getValueFor(MyMember model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyMember model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaMember_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyMember>
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
        public KmTimestamp getValueFor(MyMember model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyMember model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaMember_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaMember_UpdatedLocalDate
        extends KmMetaDateProperty<MyMember>
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
        public KmDate getValueFor(MyMember model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyMember model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaMember_UpdatedLocalTime
        extends KmMetaTimeProperty<MyMember>
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
        public KmTime getValueFor(MyMember model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyMember model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaMember_CreatedByFullName
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# ProjectName
    //##################################################

    public class MyMetaMember_ProjectName
        extends KmMetaStringProperty<MyMember>
    {
        @Override
        public String getName()
        {
            return "projectName";
        }

        @Override
        public String getLabel()
        {
            return "Project Name";
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
        public String getValueFor(MyMember model)
        {
            return model.getProjectName();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setProjectName(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasProjectName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaMember_UpdatedByFullName
        extends KmMetaStringProperty<MyMember>
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
        public String getValueFor(MyMember model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }

    //##################################################
    //# UserFullName
    //##################################################

    public class MyMetaMember_UserFullName
        extends KmMetaStringProperty<MyMember>
    {
        @Override
        public String getName()
        {
            return "userFullName";
        }

        @Override
        public String getLabel()
        {
            return "Name";
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
        public String getValueFor(MyMember model)
        {
            return model.getUserFullName();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setUserFullName(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasUserFullName(value);
        }
    }

    //##################################################
    //# UserEmail
    //##################################################

    public class MyMetaMember_UserEmail
        extends KmMetaStringProperty<MyMember>
    {
        @Override
        public String getName()
        {
            return "userEmail";
        }

        @Override
        public String getLabel()
        {
            return "Email";
        }

        @Override
        public String getHelp()
        {
            return "Used both to sign in, and to send emails to this user.";
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
        public String getValueFor(MyMember model)
        {
            return model.getUserEmail();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setUserEmail(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasUserEmail(value);
        }
    }

    //##################################################
    //# UserTimeZoneCode
    //##################################################

    public class MyMetaMember_UserTimeZoneCode
        extends KmMetaStringProperty<MyMember>
    {
        @Override
        public String getName()
        {
            return "userTimeZoneCode";
        }

        @Override
        public String getLabel()
        {
            return "Time Zone";
        }

        @Override
        public String getHelp()
        {
            return "The user's preferred time zone.";
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
        public String getValueFor(MyMember model)
        {
            return model.getUserTimeZoneCode();
        }

        @Override
        public void setValueFor(MyMember model, String value)
        {
            model.setUserTimeZoneCode(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, String value)
        {
            return model.hasUserTimeZoneCode(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaMember_CreatedBy
        extends KmMetaDaoAssociation<MyMember,MyUser>
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
        public MyUser getValueFor(MyMember model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyMember model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaMember_Project
        extends KmMetaDaoAssociation<MyMember,MyProject>
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
            return "The project to which this member belongs.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyMember model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyMember model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaMember_UpdatedBy
        extends KmMetaDaoAssociation<MyMember,MyUser>
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
        public MyUser getValueFor(MyMember model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyMember model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, MyUser value)
        {
            return model.hasUpdatedBy(value);
        }
    }

    //##################################################
    //# User
    //##################################################

    public class MyMetaMember_User
        extends KmMetaDaoAssociation<MyMember,MyUser>
    {
        @Override
        public String getName()
        {
            return "user";
        }

        @Override
        public String getLabel()
        {
            return "User";
        }

        @Override
        public String getHelp()
        {
            return "The user being granted access.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyUser getValueFor(MyMember model)
        {
            return model.getUser();
        }

        @Override
        public void setValueFor(MyMember model, MyUser value)
        {
            model.setUser(value);
        }

        @Override
        public boolean hasValueFor(MyMember model, MyUser value)
        {
            return model.hasUser(value);
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
