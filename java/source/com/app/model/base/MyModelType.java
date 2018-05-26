//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;
import com.app.model.*;

public enum MyModelType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    ApplicationLog("ApplicationLog","ApplicationLog"),
    Attachment("Attachment","Attachment"),
    AuditBundle("AuditBundle","AuditBundle"),
    AuditLog("AuditLog","AuditLog"),
    AutoLogin("AutoLogin","AutoLogin"),
    Blurb("Blurb","Blurb"),
    Choice("Choice","Choice"),
    Customer("Customer","Customer"),
    CustomerContact("CustomerContact","CustomerContact"),
    DefaultRecipient("DefaultRecipient","DefaultRecipient"),
    Download("Download","Download"),
    Email("Email","Email"),
    EmailPart("EmailPart","EmailPart"),
    EmailRecipient("EmailRecipient","EmailRecipient"),
    EmailTemplate("EmailTemplate","EmailTemplate"),
    Feedback("Feedback","Feedback"),
    FieldTest("FieldTest","FieldTest"),
    FilterTemplate("FilterTemplate","FilterTemplate"),
    FilterTemplateItem("FilterTemplateItem","FilterTemplateItem"),
    HibernateCacheTest("HibernateCacheTest","HibernateCacheTest"),
    Holiday("Holiday","Holiday"),
    Member("Member","Member"),
    Note("Note","Note"),
    OptimisticLock("OptimisticLock","OptimisticLock"),
    PasswordReset("PasswordReset","PasswordReset"),
    Patch("Patch","Patch"),
    PerformanceLogDetail("PerformanceLogDetail","PerformanceLogDetail"),
    PerformanceLogSummary("PerformanceLogSummary","PerformanceLogSummary"),
    Priority("Priority","Priority"),
    Project("Project","Project"),
    ProjectContact("ProjectContact","ProjectContact"),
    ServerSession("ServerSession","ServerSession"),
    Settings("Settings","Settings"),
    Site("Site","Site"),
    SiteContact("SiteContact","SiteContact"),
    Tenant("Tenant","Tenant"),
    ThreadTopic("ThreadTopic","ThreadTopic"),
    User("User","User"),
    UserActivation("UserActivation","UserActivation"),
    UserRecentProject("UserRecentProject","UserRecentProject"),
    Vendor("Vendor","Vendor"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyModelType> _values;
    private static final KmMap<String,MyModelType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyModelType e : EnumSet.allOf(MyModelType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyModelType> getValues()
    {
        return _values;
    }

    public static MyModelType findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyModelType(String code, String label)
    {
        _code = code;
        _label = label;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getCode()
    {
        return _code;
    }

    @Override
    public String getLabel()
    {
        return _label;
    }

    //##################################################
    //# class
    //##################################################

    public Class<?> getJavaClass()
    {
        switch ( this )
        {
            case ApplicationLog:
                return MyApplicationLog.class;

            case Attachment:
                return MyAttachment.class;

            case AuditBundle:
                return MyAuditBundle.class;

            case AuditLog:
                return MyAuditLog.class;

            case AutoLogin:
                return MyAutoLogin.class;

            case Blurb:
                return MyBlurb.class;

            case Choice:
                return MyChoice.class;

            case Customer:
                return MyCustomer.class;

            case CustomerContact:
                return MyCustomerContact.class;

            case DefaultRecipient:
                return MyDefaultRecipient.class;

            case Download:
                return MyDownload.class;

            case Email:
                return MyEmail.class;

            case EmailPart:
                return MyEmailPart.class;

            case EmailRecipient:
                return MyEmailRecipient.class;

            case EmailTemplate:
                return MyEmailTemplate.class;

            case Feedback:
                return MyFeedback.class;

            case FieldTest:
                return MyFieldTest.class;

            case FilterTemplate:
                return MyFilterTemplate.class;

            case FilterTemplateItem:
                return MyFilterTemplateItem.class;

            case HibernateCacheTest:
                return MyHibernateCacheTest.class;

            case Holiday:
                return MyHoliday.class;

            case Member:
                return MyMember.class;

            case Note:
                return MyNote.class;

            case OptimisticLock:
                return MyOptimisticLock.class;

            case PasswordReset:
                return MyPasswordReset.class;

            case Patch:
                return MyPatch.class;

            case PerformanceLogDetail:
                return MyPerformanceLogDetail.class;

            case PerformanceLogSummary:
                return MyPerformanceLogSummary.class;

            case Priority:
                return MyPriority.class;

            case Project:
                return MyProject.class;

            case ProjectContact:
                return MyProjectContact.class;

            case ServerSession:
                return MyServerSession.class;

            case Settings:
                return MySettings.class;

            case Site:
                return MySite.class;

            case SiteContact:
                return MySiteContact.class;

            case Tenant:
                return MyTenant.class;

            case ThreadTopic:
                return MyThreadTopic.class;

            case User:
                return MyUser.class;

            case UserActivation:
                return MyUserActivation.class;

            case UserRecentProject:
                return MyUserRecentProject.class;

            case Vendor:
                return MyVendor.class;

        }
        throw Kmu.newEnumError(this);
    }
}
