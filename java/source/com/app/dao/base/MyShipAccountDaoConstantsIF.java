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

public interface MyShipAccountDaoConstantsIF
{
    //##################################################
    //# fields
    //##################################################

    String UID = "uid";
    String NAME = "name";
    String DESCRIPTION = "description";
    String BILLED_TO_CUSTOMER = "billedToCustomer";
    String SHIP_ON_ACCOUNT_NAME = "shipOnAccountName";
    String SHIP_ON_ACCOUNT_NUMBER = "shipOnAccountNumber";
    String BILL_TO_TYPE_CODE = "billToTypeCode";
    String BILL_TO_ACCOUNT = "billToAccount";
    String LOCK_VERSION = "lockVersion";
    String BILL_TO_TYPE_NAME = "billToTypeName";

    //##################################################
    //# associations
    //##################################################

    String PROJECT = "project";
    String PROJECT_UID = "project.uid";

    String CUSTOMER = "customer";
    String CUSTOMER_UID = "customer.uid";

    String CARRIER = "carrier";
    String CARRIER_UID = "carrier.uid";

}
