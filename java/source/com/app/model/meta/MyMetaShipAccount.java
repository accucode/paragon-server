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

public class MyMetaShipAccount
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaShipAccount instance = new MyMetaShipAccount();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaShipAccount()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "shipAccount";
    }

    public static MyShipAccountValidator getValidator()
    {
        return MyShipAccountValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The shipping accounts determines the rules for things like which shipping carrier, account number, and bill to policy.\n For example, we may maintain a primary UPS account which bills to ourselves, and which we use when providing standard shipping to our customers.  We may set up a separate FedEx account for international shipping.  We may also set up accounts for specific customers that want product shipped on their own account rather than ours.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaShipAccount_Uid Uid = new MyMetaShipAccount_Uid();
    public static final MyMetaShipAccount_Name Name = new MyMetaShipAccount_Name();
    public static final MyMetaShipAccount_Description Description = new MyMetaShipAccount_Description();
    public static final MyMetaShipAccount_BilledToCustomer BilledToCustomer = new MyMetaShipAccount_BilledToCustomer();
    public static final MyMetaShipAccount_ShipOnAccountName ShipOnAccountName = new MyMetaShipAccount_ShipOnAccountName();
    public static final MyMetaShipAccount_ShipOnAccountNumber ShipOnAccountNumber = new MyMetaShipAccount_ShipOnAccountNumber();
    public static final MyMetaShipAccount_BillToTypeCode BillToTypeCode = new MyMetaShipAccount_BillToTypeCode();
    public static final MyMetaShipAccount_BillToAccount BillToAccount = new MyMetaShipAccount_BillToAccount();
    public static final MyMetaShipAccount_LockVersion LockVersion = new MyMetaShipAccount_LockVersion();
    public static final MyMetaShipAccount_BillToTypeName BillToTypeName = new MyMetaShipAccount_BillToTypeName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaShipAccount_Project Project = new MyMetaShipAccount_Project();
    public static final MyMetaShipAccount_Customer Customer = new MyMetaShipAccount_Customer();
    public static final MyMetaShipAccount_Carrier Carrier = new MyMetaShipAccount_Carrier();
}
