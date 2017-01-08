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

public enum MyModelAssociationType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    AUDIT_LOG_USER("AuditLogUser","AuditLog_User"),
    AUTO_LOGIN_USER("AutoLoginUser","AutoLogin_User"),
    DOWNLOAD_USER("DownloadUser","Download_User"),
    EMAIL_CREATED_BY("EmailCreatedBy","Email_CreatedBy"),
    EMAIL_UPDATED_BY("EmailUpdatedBy","Email_UpdatedBy"),
    EMAIL_RECIPIENTS("EmailRecipients","Email_Recipients"),
    EMAIL_PARTS("EmailParts","Email_Parts"),
    EMAIL_PART_CREATED_BY("EmailPartCreatedBy","EmailPart_CreatedBy"),
    EMAIL_PART_UPDATED_BY("EmailPartUpdatedBy","EmailPart_UpdatedBy"),
    EMAIL_RECIPIENT_CREATED_BY("EmailRecipientCreatedBy","EmailRecipient_CreatedBy"),
    EMAIL_RECIPIENT_UPDATED_BY("EmailRecipientUpdatedBy","EmailRecipient_UpdatedBy"),
    FIELD_TEST_CREATED_BY("FieldTestCreatedBy","FieldTest_CreatedBy"),
    FIELD_TEST_UPDATED_BY("FieldTestUpdatedBy","FieldTest_UpdatedBy"),
    FIELD_TEST_USER_TEST("FieldTestUserTest","FieldTest_UserTest"),
    FILE_CREATED_BY("FileCreatedBy","File_CreatedBy"),
    FILE_UPDATED_BY("FileUpdatedBy","File_UpdatedBy"),
    INVITATION_CREATED_BY("InvitationCreatedBy","Invitation_CreatedBy"),
    INVITATION_UPDATED_BY("InvitationUpdatedBy","Invitation_UpdatedBy"),
    INVITATION_FROM_USER("InvitationFromUser","Invitation_FromUser"),
    INVITATION_PROJECT("InvitationProject","Invitation_Project"),
    PASSWORD_RESET_CREATED_BY("PasswordResetCreatedBy","PasswordReset_CreatedBy"),
    PASSWORD_RESET_UPDATED_BY("PasswordResetUpdatedBy","PasswordReset_UpdatedBy"),
    PASSWORD_RESET_TENANT("PasswordResetTenant","PasswordReset_Tenant"),
    PROJECT_CREATED_BY("ProjectCreatedBy","Project_CreatedBy"),
    PROJECT_UPDATED_BY("ProjectUpdatedBy","Project_UpdatedBy"),
    SERVER_SESSION_TENANT("ServerSessionTenant","ServerSession_Tenant"),
    SERVER_SESSION_USER("ServerSessionUser","ServerSession_User"),
    SERVER_SESSION_AUTO_LOGIN("ServerSessionAutoLogin","ServerSession_AutoLogin"),
    TENANT_PROJECTS("TenantProjects","Tenant_Projects"),
    TENANT_USERS("TenantUsers","Tenant_Users"),
    USER_CREATED_BY("UserCreatedBy","User_CreatedBy"),
    USER_UPDATED_BY("UserUpdatedBy","User_UpdatedBy"),
    USER_LAST_PROJECT("UserLastProject","User_LastProject"),
    USER_ACTIVATION_CREATED_BY("UserActivationCreatedBy","UserActivation_CreatedBy"),
    USER_ACTIVATION_UPDATED_BY("UserActivationUpdatedBy","UserActivation_UpdatedBy"),
    USER_ACTIVATION_TENANT("UserActivationTenant","UserActivation_Tenant"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyModelAssociationType> _values;
    private static final KmMap<String,MyModelAssociationType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyModelAssociationType e : EnumSet.allOf(MyModelAssociationType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyModelAssociationType> getValues()
    {
        return _values;
    }

    public static MyModelAssociationType findCode(String code)
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

    private MyModelAssociationType(String code, String label)
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
}
