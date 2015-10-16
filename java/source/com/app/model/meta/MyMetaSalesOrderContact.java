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

public class MyMetaSalesOrderContact
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSalesOrderContact instance = new MyMetaSalesOrderContact();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSalesOrderContact()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "salesOrderContact";
    }

    public static MySalesOrderContactValidator getValidator()
    {
        return MySalesOrderContactValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The contacts associated with a particular order.  These contacts are primarily used for notifications related to a single order.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSalesOrderContact_Uid Uid = new MyMetaSalesOrderContact_Uid();
    public static final MyMetaSalesOrderContact_Name Name = new MyMetaSalesOrderContact_Name();
    public static final MyMetaSalesOrderContact_Title Title = new MyMetaSalesOrderContact_Title();
    public static final MyMetaSalesOrderContact_Phone Phone = new MyMetaSalesOrderContact_Phone();
    public static final MyMetaSalesOrderContact_Email Email = new MyMetaSalesOrderContact_Email();
    public static final MyMetaSalesOrderContact_OrderNotifications OrderNotifications = new MyMetaSalesOrderContact_OrderNotifications();
    public static final MyMetaSalesOrderContact_LockVersion LockVersion = new MyMetaSalesOrderContact_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaSalesOrderContact_SalesOrder SalesOrder = new MyMetaSalesOrderContact_SalesOrder();
}
