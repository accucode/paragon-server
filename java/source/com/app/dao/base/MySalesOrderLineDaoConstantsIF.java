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

public interface MySalesOrderLineDaoConstantsIF
{
    //##################################################
    //# fields
    //##################################################

    String UID = "uid";
    String LIST_PRICE = "listPrice";
    String UNIT_PRICE = "unitPrice";
    String ORDERED_QUANTITY = "orderedQuantity";
    String FULFILLED_QUANTITY = "fulfilledQuantity";
    String EXTENDED_PRICE = "extendedPrice";
    String PRICE_ADJUSTMENT = "priceAdjustment";
    String ADJUSTED_PRICE = "adjustedPrice";
    String TAX = "tax";
    String TOTAL_PRICE = "totalPrice";
    String LOCK_VERSION = "lockVersion";

    //##################################################
    //# associations
    //##################################################

    String SALES_ORDER = "salesOrder";
    String SALES_ORDER_UID = "salesOrder.uid";

    String PRODUCT = "product";
    String PRODUCT_UID = "product.uid";

    //##################################################
    //# collections
    //##################################################

    String ATTRIBUTE_VALUES = "attributeValues";
}
