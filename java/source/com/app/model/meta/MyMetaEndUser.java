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

public class MyMetaEndUser
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEndUser instance = new MyMetaEndUser();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEndUser()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "endUser";
    }

    public static MyEndUserValidator getValidator()
    {
        return MyEndUserValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The end users associated with a particular customer.  The end user represents the person (or business) that maintains physical possession of our equipment.  This is important for both maintenance and leases, and the end user may be someone different than the customer that actually pays us.\n Because end users are typically defined and entered by the customer, we do NOT model end users as a globally shared party within the project. Each customer has its own set of end users, and this may result in the same end user being defined multiple times under different customers.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEndUser_Uid Uid = new MyMetaEndUser_Uid();
    public static final MyMetaEndUser_Name Name = new MyMetaEndUser_Name();
    public static final MyMetaEndUser_LockVersion LockVersion = new MyMetaEndUser_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEndUser_Customer Customer = new MyMetaEndUser_Customer();
}
