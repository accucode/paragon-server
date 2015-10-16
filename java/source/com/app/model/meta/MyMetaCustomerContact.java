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

public class MyMetaCustomerContact
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaCustomerContact instance = new MyMetaCustomerContact();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaCustomerContact()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customerContact";
    }

    public static MyCustomerContactValidator getValidator()
    {
        return MyCustomerContactValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The contacts associated with a particular customer.  This contacts are primarily used for notifications across multiple orders.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaCustomerContact_Uid Uid = new MyMetaCustomerContact_Uid();
    public static final MyMetaCustomerContact_Name Name = new MyMetaCustomerContact_Name();
    public static final MyMetaCustomerContact_Title Title = new MyMetaCustomerContact_Title();
    public static final MyMetaCustomerContact_Phone Phone = new MyMetaCustomerContact_Phone();
    public static final MyMetaCustomerContact_Email Email = new MyMetaCustomerContact_Email();
    public static final MyMetaCustomerContact_OrderNotifications OrderNotifications = new MyMetaCustomerContact_OrderNotifications();
    public static final MyMetaCustomerContact_LockVersion LockVersion = new MyMetaCustomerContact_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaCustomerContact_Customer Customer = new MyMetaCustomerContact_Customer();
}
