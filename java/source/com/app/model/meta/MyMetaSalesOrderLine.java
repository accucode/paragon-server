//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaSalesOrderLine
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSalesOrderLine instance = new MyMetaSalesOrderLine();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSalesOrderLine()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "salesOrderLine";
    }

    public static MySalesOrderLineValidator getValidator()
    {
        return MySalesOrderLineValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A line on a sales order.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSalesOrderLine_Uid Uid = new MyMetaSalesOrderLine_Uid();
    public static final MyMetaSalesOrderLine_ListPrice ListPrice = new MyMetaSalesOrderLine_ListPrice();
    public static final MyMetaSalesOrderLine_UnitPrice UnitPrice = new MyMetaSalesOrderLine_UnitPrice();
    public static final MyMetaSalesOrderLine_OrderedQuantity OrderedQuantity = new MyMetaSalesOrderLine_OrderedQuantity();
    public static final MyMetaSalesOrderLine_FulfilledQuantity FulfilledQuantity = new MyMetaSalesOrderLine_FulfilledQuantity();
    public static final MyMetaSalesOrderLine_ExtendedPrice ExtendedPrice = new MyMetaSalesOrderLine_ExtendedPrice();
    public static final MyMetaSalesOrderLine_PriceAdjustment PriceAdjustment = new MyMetaSalesOrderLine_PriceAdjustment();
    public static final MyMetaSalesOrderLine_AdjustedPrice AdjustedPrice = new MyMetaSalesOrderLine_AdjustedPrice();
    public static final MyMetaSalesOrderLine_Tax Tax = new MyMetaSalesOrderLine_Tax();
    public static final MyMetaSalesOrderLine_TotalPrice TotalPrice = new MyMetaSalesOrderLine_TotalPrice();
    public static final MyMetaSalesOrderLine_LockVersion LockVersion = new MyMetaSalesOrderLine_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaSalesOrderLine_SalesOrder SalesOrder = new MyMetaSalesOrderLine_SalesOrder();
    public static final MyMetaSalesOrderLine_Product Product = new MyMetaSalesOrderLine_Product();
}
