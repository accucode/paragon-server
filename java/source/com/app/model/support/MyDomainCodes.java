package com.app.model.support;

/**
 * I define some common database codes that are shared between
 * multiple enums.
 */
// fixme_wyatt: remove?
public interface MyDomainCodes
{
    // !!! NOTE !!!
    // !!! These are used in the DATABASE.
    // !!! Changing them requires a database migration.
    // !!! see types.stf, domainTypeCode.

    /**
     * I changed these to camel-case.
     * Need to review all uses and migrate database where pertinent.
     *
     * MAX LENGTH = 30
     * See types.stf, longEnumCode
     */
    String ATTACHMENT          = "Attachment";
    String CHANGE_REQUEST      = "ChangeRequest";
    String CUSTOMER            = "Customer";
    String CUSTOMER_SITE       = "CustomerSite";
    String DEVICE              = "Device";
    String ENTITLEMENT         = "Entitlement";
    String JOB                 = "Job";
    String PRODUCT_MASTER      = "ProductMaster";
    String PRODUCT_VERSION     = "ProductVersion";
    String PROJECT             = "Project";
    String SALES_ORDER         = "SalesOrder";
    String SALES_ORDER_LINE    = "SalesOrderLine";
    String SALES_ORDER_CONTACT = "SalesOrderContact";
    String SHIPMENT            = "Shipment";
    String SURVEY              = "Survey";
    String TICKET              = "Ticket";
    String STEP                = "Step";
    String TASK                = "Task";
    String VISIT               = "Visit";
}
