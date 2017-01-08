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

    APPLICATION_LOG("ApplicationLog","ApplicationLog"),
    AUDIT_LOG("AuditLog","AuditLog"),
    AUTO_LOGIN("AutoLogin","AutoLogin"),
    DOWNLOAD("Download","Download"),
    EMAIL("Email","Email"),
    EMAIL_PART("EmailPart","EmailPart"),
    EMAIL_RECIPIENT("EmailRecipient","EmailRecipient"),
    FIELD_TEST("FieldTest","FieldTest"),
    FILE("File","File"),
    HIBERNATE_CACHE_TEST("HibernateCacheTest","HibernateCacheTest"),
    INVITATION("Invitation","Invitation"),
    OPTIMISTIC_LOCK("OptimisticLock","OptimisticLock"),
    PASSWORD_RESET("PasswordReset","PasswordReset"),
    PATCH("Patch","Patch"),
    PERFORMANCE_LOG_DETAIL("PerformanceLogDetail","PerformanceLogDetail"),
    PERFORMANCE_LOG_SUMMARY("PerformanceLogSummary","PerformanceLogSummary"),
    PROJECT("Project","Project"),
    SERVER_SESSION("ServerSession","ServerSession"),
    SETTINGS("Settings","Settings"),
    TENANT("Tenant","Tenant"),
    THREAD_TOPIC("ThreadTopic","ThreadTopic"),
    USER("User","User"),
    USER_ACTIVATION("UserActivation","UserActivation"),
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
            case APPLICATION_LOG:
                return MyApplicationLog.class;

            case AUDIT_LOG:
                return MyAuditLog.class;

            case AUTO_LOGIN:
                return MyAutoLogin.class;

            case DOWNLOAD:
                return MyDownload.class;

            case EMAIL:
                return MyEmail.class;

            case EMAIL_PART:
                return MyEmailPart.class;

            case EMAIL_RECIPIENT:
                return MyEmailRecipient.class;

            case FIELD_TEST:
                return MyFieldTest.class;

            case FILE:
                return MyFile.class;

            case HIBERNATE_CACHE_TEST:
                return MyHibernateCacheTest.class;

            case INVITATION:
                return MyInvitation.class;

            case OPTIMISTIC_LOCK:
                return MyOptimisticLock.class;

            case PASSWORD_RESET:
                return MyPasswordReset.class;

            case PATCH:
                return MyPatch.class;

            case PERFORMANCE_LOG_DETAIL:
                return MyPerformanceLogDetail.class;

            case PERFORMANCE_LOG_SUMMARY:
                return MyPerformanceLogSummary.class;

            case PROJECT:
                return MyProject.class;

            case SERVER_SESSION:
                return MyServerSession.class;

            case SETTINGS:
                return MySettings.class;

            case TENANT:
                return MyTenant.class;

            case THREAD_TOPIC:
                return MyThreadTopic.class;

            case USER:
                return MyUser.class;

            case USER_ACTIVATION:
                return MyUserActivation.class;

        }
        throw Kmu.newEnumError(this);
    }
}
