//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.exception.error.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

/**
 * Information about the audit log policy.
 * By default, all models and fields are audited; exceptions are defined here.
 */
public class MyAuditLogInfo
{
    //##################################################
    //# testing
    //##################################################

    public static boolean isModelDisabled(String model)
    {
        return _disabledModels.contains(model);
    }

    public static boolean isFieldDisabled(String model, String field)
    {
        String key = formatFieldKey(model, field);
        return _disabledFields.contains(key);
    }

    public static boolean isFieldMasked(String model, String field)
    {
        String key = formatFieldKey(model, field);
        return _maskedFields.contains(key);
    }

    //##################################################
    //# setup
    //##################################################

    private static final KmSet<String> _disabledModels;
    private static final KmSet<String> _disabledFields;
    private static final KmSet<String> _maskedFields;

    static
    {
        _disabledModels = new KmSetImpl<>();
        _disabledModels.add("applicationLog");
        _disabledModels.add("auditLog");
        _disabledModels.add("autoLogin");
        _disabledModels.add("download");
        _disabledModels.add("file");
        _disabledModels.add("hibernateCacheTest");
        _disabledModels.add("optimisticLock");
        _disabledModels.add("passwordReset");
        _disabledModels.add("patch");
        _disabledModels.add("performanceLogDetail");
        _disabledModels.add("performanceLogSummary");
        _disabledModels.add("serverSession");
        _disabledModels.add("tenant");
        _disabledModels.add("threadTopic");

        _disabledFields = new KmSetImpl<>();
        _disabledFields.add(formatFieldKey("autoLogin", "lockVersion"));
        _disabledFields.add(formatFieldKey("download", "lockVersion"));
        _disabledFields.add(formatFieldKey("email", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("email", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("email", "lockVersion"));
        _disabledFields.add(formatFieldKey("email", "createdBy"));
        _disabledFields.add(formatFieldKey("email", "updatedBy"));
        _disabledFields.add(formatFieldKey("emailPart", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("emailPart", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("emailPart", "lockVersion"));
        _disabledFields.add(formatFieldKey("emailPart", "createdBy"));
        _disabledFields.add(formatFieldKey("emailPart", "updatedBy"));
        _disabledFields.add(formatFieldKey("emailRecipient", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("emailRecipient", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("emailRecipient", "lockVersion"));
        _disabledFields.add(formatFieldKey("emailRecipient", "createdBy"));
        _disabledFields.add(formatFieldKey("emailRecipient", "updatedBy"));
        _disabledFields.add(formatFieldKey("fieldTest", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("fieldTest", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("fieldTest", "pinNumber2"));
        _disabledFields.add(formatFieldKey("fieldTest", "lockVersion"));
        _disabledFields.add(formatFieldKey("fieldTest", "createdBy"));
        _disabledFields.add(formatFieldKey("fieldTest", "updatedBy"));
        _disabledFields.add(formatFieldKey("file", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("file", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("file", "lockVersion"));
        _disabledFields.add(formatFieldKey("file", "createdBy"));
        _disabledFields.add(formatFieldKey("file", "updatedBy"));
        _disabledFields.add(formatFieldKey("hibernateCacheTest", "lockVersion"));
        _disabledFields.add(formatFieldKey("invitation", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("invitation", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("invitation", "lockVersion"));
        _disabledFields.add(formatFieldKey("invitation", "createdBy"));
        _disabledFields.add(formatFieldKey("invitation", "updatedBy"));
        _disabledFields.add(formatFieldKey("optimisticLock", "lockVersion"));
        _disabledFields.add(formatFieldKey("passwordReset", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("passwordReset", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("passwordReset", "lockVersion"));
        _disabledFields.add(formatFieldKey("passwordReset", "createdBy"));
        _disabledFields.add(formatFieldKey("passwordReset", "updatedBy"));
        _disabledFields.add(formatFieldKey("project", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("project", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("project", "catalogVersion"));
        _disabledFields.add(formatFieldKey("project", "lockVersion"));
        _disabledFields.add(formatFieldKey("project", "createdBy"));
        _disabledFields.add(formatFieldKey("project", "updatedBy"));
        _disabledFields.add(formatFieldKey("serverSession", "lockVersion"));
        _disabledFields.add(formatFieldKey("settings", "lockVersion"));
        _disabledFields.add(formatFieldKey("tenant", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("tenant", "lockVersion"));
        _disabledFields.add(formatFieldKey("threadTopic", "lockVersion"));
        _disabledFields.add(formatFieldKey("user", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("user", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("user", "lockVersion"));
        _disabledFields.add(formatFieldKey("user", "createdBy"));
        _disabledFields.add(formatFieldKey("user", "updatedBy"));
        _disabledFields.add(formatFieldKey("userActivation", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("userActivation", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("userActivation", "lockVersion"));
        _disabledFields.add(formatFieldKey("userActivation", "createdBy"));
        _disabledFields.add(formatFieldKey("userActivation", "updatedBy"));

        _maskedFields = new KmSetImpl<>();
        _maskedFields.add(formatFieldKey("fieldTest", "pinNumber1"));
    }

    private static String formatFieldKey(String model, String field)
    {
        return model + "." + field;
    }
}

