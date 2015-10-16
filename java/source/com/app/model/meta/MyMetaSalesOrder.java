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

public class MyMetaSalesOrder
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSalesOrder instance = new MyMetaSalesOrder();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSalesOrder()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "salesOrder";
    }

    public static MySalesOrderValidator getValidator()
    {
        return MySalesOrderValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A sales order.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSalesOrder_Uid Uid = new MyMetaSalesOrder_Uid();
    public static final MyMetaSalesOrder_Number Number = new MyMetaSalesOrder_Number();
    public static final MyMetaSalesOrder_StatusCode StatusCode = new MyMetaSalesOrder_StatusCode();
    public static final MyMetaSalesOrder_HoldUntilUtcTs HoldUntilUtcTs = new MyMetaSalesOrder_HoldUntilUtcTs();
    public static final MyMetaSalesOrder_Expedite Expedite = new MyMetaSalesOrder_Expedite();
    public static final MyMetaSalesOrder_TaxExempt TaxExempt = new MyMetaSalesOrder_TaxExempt();
    public static final MyMetaSalesOrder_TaxRate TaxRate = new MyMetaSalesOrder_TaxRate();
    public static final MyMetaSalesOrder_DiscountRate DiscountRate = new MyMetaSalesOrder_DiscountRate();
    public static final MyMetaSalesOrder_TotalPrice TotalPrice = new MyMetaSalesOrder_TotalPrice();
    public static final MyMetaSalesOrder_TotalTax TotalTax = new MyMetaSalesOrder_TotalTax();
    public static final MyMetaSalesOrder_LockVersion LockVersion = new MyMetaSalesOrder_LockVersion();
    public static final MyMetaSalesOrder_StatusName StatusName = new MyMetaSalesOrder_StatusName();
    public static final MyMetaSalesOrder_HoldUntilLocalTs HoldUntilLocalTs = new MyMetaSalesOrder_HoldUntilLocalTs();
    public static final MyMetaSalesOrder_HoldUntilLocalTsMessage HoldUntilLocalTsMessage = new MyMetaSalesOrder_HoldUntilLocalTsMessage();
    public static final MyMetaSalesOrder_HoldUntilLocalDate HoldUntilLocalDate = new MyMetaSalesOrder_HoldUntilLocalDate();
    public static final MyMetaSalesOrder_HoldUntilLocalTime HoldUntilLocalTime = new MyMetaSalesOrder_HoldUntilLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaSalesOrder_Project Project = new MyMetaSalesOrder_Project();
    public static final MyMetaSalesOrder_Customer Customer = new MyMetaSalesOrder_Customer();
    public static final MyMetaSalesOrder_Region Region = new MyMetaSalesOrder_Region();
    public static final MyMetaSalesOrder_AttentionTo AttentionTo = new MyMetaSalesOrder_AttentionTo();
    public static final MyMetaSalesOrder_PowerType PowerType = new MyMetaSalesOrder_PowerType();
}
