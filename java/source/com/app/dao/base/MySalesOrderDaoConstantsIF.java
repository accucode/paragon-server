//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.collection.*;
import com.app.model.*;

public interface MySalesOrderDaoConstantsIF
{
    //##################################################
    //# fields
    //##################################################

    String UID = "uid";
    String NUMBER = "number";
    String STATUS_CODE = "statusCode";
    String HOLD_UNTIL_UTC_TS = "holdUntilUtcTs";
    String EXPEDITE = "expedite";
    String TAX_EXEMPT = "taxExempt";
    String TAX_RATE = "taxRate";
    String DISCOUNT_RATE = "discountRate";
    String TOTAL_PRICE = "totalPrice";
    String TOTAL_TAX = "totalTax";
    String LOCK_VERSION = "lockVersion";
    String STATUS_NAME = "statusName";
    String HOLD_UNTIL_LOCAL_TS = "holdUntilLocalTs";
    String HOLD_UNTIL_LOCAL_TS_MESSAGE = "holdUntilLocalTsMessage";
    String HOLD_UNTIL_LOCAL_DATE = "holdUntilLocalDate";
    String HOLD_UNTIL_LOCAL_TIME = "holdUntilLocalTime";

    //##################################################
    //# associations
    //##################################################

    String PROJECT = "project";
    String PROJECT_UID = "project.uid";

    String CUSTOMER = "customer";
    String CUSTOMER_UID = "customer.uid";

    String REGION = "region";
    String REGION_UID = "region.uid";

    String ATTENTION_TO = "attentionTo";
    String ATTENTION_TO_UID = "attentionTo.uid";

    String POWER_TYPE = "powerType";
    String POWER_TYPE_UID = "powerType.uid";

    //##################################################
    //# collections
    //##################################################

    String CONTACTS = "contacts";
    String LINES = "lines";
    String SHIPMENTS = "shipments";
}
