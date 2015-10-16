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
        _disabledModels.add("autoSignIn");
        _disabledModels.add("download");
        _disabledModels.add("file");
        _disabledModels.add("hibernateCacheTest");
        _disabledModels.add("orderNumber");
        _disabledModels.add("passwordReset");
        _disabledModels.add("patch");
        _disabledModels.add("performanceLogDetail");
        _disabledModels.add("performanceLogSummary");
        _disabledModels.add("serverSession");
        _disabledModels.add("settings");
        _disabledModels.add("threadTopic");

        _disabledFields = new KmSetImpl<>();
        _disabledFields.add(formatFieldKey("attentionGroup", "lockVersion"));
        _disabledFields.add(formatFieldKey("attributeField", "lockVersion"));
        _disabledFields.add(formatFieldKey("attributeValue", "lockVersion"));
        _disabledFields.add(formatFieldKey("autoSignIn", "lockVersion"));
        _disabledFields.add(formatFieldKey("customer", "lockVersion"));
        _disabledFields.add(formatFieldKey("customerContact", "lockVersion"));
        _disabledFields.add(formatFieldKey("customerSite", "lockVersion"));
        _disabledFields.add(formatFieldKey("customerTier", "lockVersion"));
        _disabledFields.add(formatFieldKey("depot", "lockVersion"));
        _disabledFields.add(formatFieldKey("download", "lockVersion"));
        _disabledFields.add(formatFieldKey("email", "lockVersion"));
        _disabledFields.add(formatFieldKey("emailPart", "lockVersion"));
        _disabledFields.add(formatFieldKey("emailRecipient", "lockVersion"));
        _disabledFields.add(formatFieldKey("endUser", "lockVersion"));
        _disabledFields.add(formatFieldKey("endUserSite", "lockVersion"));
        _disabledFields.add(formatFieldKey("fieldTest", "pinNumber2"));
        _disabledFields.add(formatFieldKey("fieldTest", "lockVersion"));
        _disabledFields.add(formatFieldKey("file", "lockVersion"));
        _disabledFields.add(formatFieldKey("hibernateCacheTest", "lockVersion"));
        _disabledFields.add(formatFieldKey("invitation", "lockVersion"));
        _disabledFields.add(formatFieldKey("masterProduct", "lockVersion"));
        _disabledFields.add(formatFieldKey("member", "lockVersion"));
        _disabledFields.add(formatFieldKey("memberSkill", "lockVersion"));
        _disabledFields.add(formatFieldKey("orderNumber", "lockVersion"));
        _disabledFields.add(formatFieldKey("passwordReset", "lockVersion"));
        _disabledFields.add(formatFieldKey("powerType", "lockVersion"));
        _disabledFields.add(formatFieldKey("product", "lockVersion"));
        _disabledFields.add(formatFieldKey("productCategory", "lockVersion"));
        _disabledFields.add(formatFieldKey("project", "lockVersion"));
        _disabledFields.add(formatFieldKey("region", "lockVersion"));
        _disabledFields.add(formatFieldKey("salesOrder", "lockVersion"));
        _disabledFields.add(formatFieldKey("salesOrderContact", "lockVersion"));
        _disabledFields.add(formatFieldKey("salesOrderLine", "lockVersion"));
        _disabledFields.add(formatFieldKey("serverSession", "lockVersion"));
        _disabledFields.add(formatFieldKey("settings", "lockVersion"));
        _disabledFields.add(formatFieldKey("shipAccount", "lockVersion"));
        _disabledFields.add(formatFieldKey("shipCarrier", "lockVersion"));
        _disabledFields.add(formatFieldKey("shipMethod", "lockVersion"));
        _disabledFields.add(formatFieldKey("shipment", "lockVersion"));
        _disabledFields.add(formatFieldKey("skill", "lockVersion"));
        _disabledFields.add(formatFieldKey("threadTopic", "lockVersion"));
        _disabledFields.add(formatFieldKey("user", "lockVersion"));
        _disabledFields.add(formatFieldKey("userActivation", "lockVersion"));
        _disabledFields.add(formatFieldKey("vendor", "lockVersion"));
        _disabledFields.add(formatFieldKey("visitType", "lockVersion"));

        _maskedFields = new KmSetImpl<>();
        _maskedFields.add(formatFieldKey("fieldTest", "pinNumber1"));
    }

    private static String formatFieldKey(String model, String field)
    {
        return model + "." + field;
    }
}

