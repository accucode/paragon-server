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
        _disabledModels.add("auditBundle");
        _disabledModels.add("auditLog");
        _disabledModels.add("autoLogin");
        _disabledModels.add("download");
        _disabledModels.add("feedback");
        _disabledModels.add("hibernateCacheTest");
        _disabledModels.add("optimisticLock");
        _disabledModels.add("passwordReset");
        _disabledModels.add("patch");
        _disabledModels.add("performanceLogDetail");
        _disabledModels.add("performanceLogSummary");
        _disabledModels.add("priority");
        _disabledModels.add("serverSession");
        _disabledModels.add("tenant");
        _disabledModels.add("threadTopic");
        _disabledModels.add("userRecentProject");

        _disabledFields = new KmSetImpl<>();
        _disabledFields.add(formatFieldKey("attachment", "content"));
        _disabledFields.add(formatFieldKey("attachment", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("attachment", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("attachment", "lockVersion"));
        _disabledFields.add(formatFieldKey("attachment", "createdBy"));
        _disabledFields.add(formatFieldKey("attachment", "updatedBy"));
        _disabledFields.add(formatFieldKey("autoLogin", "lockVersion"));
        _disabledFields.add(formatFieldKey("blurb", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("blurb", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("blurb", "lockVersion"));
        _disabledFields.add(formatFieldKey("blurb", "createdBy"));
        _disabledFields.add(formatFieldKey("blurb", "updatedBy"));
        _disabledFields.add(formatFieldKey("choice", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("choice", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("choice", "lockVersion"));
        _disabledFields.add(formatFieldKey("choice", "createdBy"));
        _disabledFields.add(formatFieldKey("choice", "updatedBy"));
        _disabledFields.add(formatFieldKey("customer", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("customer", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("customer", "lockVersion"));
        _disabledFields.add(formatFieldKey("customer", "createdBy"));
        _disabledFields.add(formatFieldKey("customer", "updatedBy"));
        _disabledFields.add(formatFieldKey("customerContact", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("customerContact", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("customerContact", "lockVersion"));
        _disabledFields.add(formatFieldKey("customerContact", "createdBy"));
        _disabledFields.add(formatFieldKey("customerContact", "updatedBy"));
        _disabledFields.add(formatFieldKey("defaultRecipient", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("defaultRecipient", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("defaultRecipient", "lockVersion"));
        _disabledFields.add(formatFieldKey("defaultRecipient", "createdBy"));
        _disabledFields.add(formatFieldKey("defaultRecipient", "updatedBy"));
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
        _disabledFields.add(formatFieldKey("emailTemplate", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("emailTemplate", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("emailTemplate", "lockVersion"));
        _disabledFields.add(formatFieldKey("emailTemplate", "createdBy"));
        _disabledFields.add(formatFieldKey("emailTemplate", "updatedBy"));
        _disabledFields.add(formatFieldKey("feedback", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("feedback", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("feedback", "createdBy"));
        _disabledFields.add(formatFieldKey("feedback", "updatedBy"));
        _disabledFields.add(formatFieldKey("fieldTest", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("fieldTest", "pinNumber2"));
        _disabledFields.add(formatFieldKey("fieldTest", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("fieldTest", "lockVersion"));
        _disabledFields.add(formatFieldKey("fieldTest", "createdBy"));
        _disabledFields.add(formatFieldKey("fieldTest", "updatedBy"));
        _disabledFields.add(formatFieldKey("filterTemplate", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("filterTemplate", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("filterTemplate", "lockVersion"));
        _disabledFields.add(formatFieldKey("filterTemplate", "createdBy"));
        _disabledFields.add(formatFieldKey("filterTemplate", "updatedBy"));
        _disabledFields.add(formatFieldKey("filterTemplateItem", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("filterTemplateItem", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("filterTemplateItem", "lockVersion"));
        _disabledFields.add(formatFieldKey("filterTemplateItem", "createdBy"));
        _disabledFields.add(formatFieldKey("filterTemplateItem", "updatedBy"));
        _disabledFields.add(formatFieldKey("hibernateCacheTest", "lockVersion"));
        _disabledFields.add(formatFieldKey("holiday", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("holiday", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("holiday", "lockVersion"));
        _disabledFields.add(formatFieldKey("holiday", "createdBy"));
        _disabledFields.add(formatFieldKey("holiday", "updatedBy"));
        _disabledFields.add(formatFieldKey("member", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("member", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("member", "lockVersion"));
        _disabledFields.add(formatFieldKey("member", "createdBy"));
        _disabledFields.add(formatFieldKey("member", "updatedBy"));
        _disabledFields.add(formatFieldKey("note", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("note", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("note", "lockVersion"));
        _disabledFields.add(formatFieldKey("note", "createdBy"));
        _disabledFields.add(formatFieldKey("note", "updatedBy"));
        _disabledFields.add(formatFieldKey("optimisticLock", "lockVersion"));
        _disabledFields.add(formatFieldKey("passwordReset", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("passwordReset", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("passwordReset", "lockVersion"));
        _disabledFields.add(formatFieldKey("passwordReset", "createdBy"));
        _disabledFields.add(formatFieldKey("passwordReset", "updatedBy"));
        _disabledFields.add(formatFieldKey("priority", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("priority", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("priority", "createdBy"));
        _disabledFields.add(formatFieldKey("priority", "updatedBy"));
        _disabledFields.add(formatFieldKey("project", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("project", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("project", "lockVersion"));
        _disabledFields.add(formatFieldKey("project", "createdBy"));
        _disabledFields.add(formatFieldKey("project", "updatedBy"));
        _disabledFields.add(formatFieldKey("projectContact", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("projectContact", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("projectContact", "lockVersion"));
        _disabledFields.add(formatFieldKey("projectContact", "createdBy"));
        _disabledFields.add(formatFieldKey("projectContact", "updatedBy"));
        _disabledFields.add(formatFieldKey("serverSession", "lockVersion"));
        _disabledFields.add(formatFieldKey("settings", "lockVersion"));
        _disabledFields.add(formatFieldKey("site", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("site", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("site", "lockVersion"));
        _disabledFields.add(formatFieldKey("site", "createdBy"));
        _disabledFields.add(formatFieldKey("site", "updatedBy"));
        _disabledFields.add(formatFieldKey("siteContact", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("siteContact", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("siteContact", "lockVersion"));
        _disabledFields.add(formatFieldKey("siteContact", "createdBy"));
        _disabledFields.add(formatFieldKey("siteContact", "updatedBy"));
        _disabledFields.add(formatFieldKey("tenant", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("tenant", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("tenant", "lockVersion"));
        _disabledFields.add(formatFieldKey("tenant", "createdBy"));
        _disabledFields.add(formatFieldKey("tenant", "updatedBy"));
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
        _disabledFields.add(formatFieldKey("userRecentProject", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("userRecentProject", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("userRecentProject", "lockVersion"));
        _disabledFields.add(formatFieldKey("userRecentProject", "createdBy"));
        _disabledFields.add(formatFieldKey("userRecentProject", "updatedBy"));
        _disabledFields.add(formatFieldKey("vendor", "createdUtcTs"));
        _disabledFields.add(formatFieldKey("vendor", "updatedUtcTs"));
        _disabledFields.add(formatFieldKey("vendor", "lockVersion"));
        _disabledFields.add(formatFieldKey("vendor", "createdBy"));
        _disabledFields.add(formatFieldKey("vendor", "updatedBy"));

        _maskedFields = new KmSetImpl<>();
        _maskedFields.add(formatFieldKey("fieldTest", "pinNumber1"));
        _maskedFields.add(formatFieldKey("user", "passwordHash"));
        _maskedFields.add(formatFieldKey("user", "passwordSalt"));
    }

    private static String formatFieldKey(String model, String field)
    {
        return model + "." + field;
    }
}

