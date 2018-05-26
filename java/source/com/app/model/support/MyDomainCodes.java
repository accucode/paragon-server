package com.app.model.support;

/**
 * I define some common database codes that are shared between
 * multiple enums.
 */
public interface MyDomainCodes
{
    // !!! NOTE !!!
    // !!! These are used in the DATABASE.
    // !!! Changing them requires a database migration.
    // !!! see types.stf, domainTypeCode.

    /**
     * MAX LENGTH = 30
     * See types.stf, longEnumCode
     */
    String ATTACHMENT      = "Attachment";
    String CHANGE_REQUEST  = "ChangeRequest";
    String CUSTOMER        = "Customer";
    String DEVICE          = "Device";
    String ENTITLEMENT     = "Entitlement";
    String PRODUCT_MASTER  = "ProductMaster";
    String PRODUCT_VERSION = "ProductVersion";
    String PROJECT         = "Project";

    String JOB         = "Job";
    String JOB_LINE    = "JobLine";
    String JOB_CONTACT = "JobContact";

    String SHIPMENT = "Shipment";
    String SITE     = "CustomerSite";
    String SURVEY   = "Survey";
    String TENANT   = "Tenant";
    String STEP     = "Step";
    String TASK     = "Task";
    String USER     = "User";
    String VISIT    = "Visit";
}
