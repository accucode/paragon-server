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

public class MyMetaShipment
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaShipment instance = new MyMetaShipment();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaShipment()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "shipment";
    }

    public static MyShipmentValidator getValidator()
    {
        return MyShipmentValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "This is primarily used to track parcel shipments sent via third party carriers such as FedEx or UPS.  The expectation is to create a separate shipment for each distinct tracking number.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaShipment_Uid Uid = new MyMetaShipment_Uid();
    public static final MyMetaShipment_TrackingNumber TrackingNumber = new MyMetaShipment_TrackingNumber();
    public static final MyMetaShipment_Weight Weight = new MyMetaShipment_Weight();
    public static final MyMetaShipment_Cost Cost = new MyMetaShipment_Cost();
    public static final MyMetaShipment_InvoiceCustomer InvoiceCustomer = new MyMetaShipment_InvoiceCustomer();
    public static final MyMetaShipment_LockVersion LockVersion = new MyMetaShipment_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaShipment_SalesOrder SalesOrder = new MyMetaShipment_SalesOrder();
    public static final MyMetaShipment_Account Account = new MyMetaShipment_Account();
    public static final MyMetaShipment_Method Method = new MyMetaShipment_Method();
    public static final MyMetaShipment_Depot Depot = new MyMetaShipment_Depot();
}
