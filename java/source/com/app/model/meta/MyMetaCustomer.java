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

public class MyMetaCustomer
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaCustomer instance = new MyMetaCustomer();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaCustomer()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customer";
    }

    public static MyCustomerValidator getValidator()
    {
        return MyCustomerValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The customers associated with a particular project.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaCustomer_Uid Uid = new MyMetaCustomer_Uid();
    public static final MyMetaCustomer_Name Name = new MyMetaCustomer_Name();
    public static final MyMetaCustomer_DiscountRate DiscountRate = new MyMetaCustomer_DiscountRate();
    public static final MyMetaCustomer_AddressStreet1 AddressStreet1 = new MyMetaCustomer_AddressStreet1();
    public static final MyMetaCustomer_AddressStreet2 AddressStreet2 = new MyMetaCustomer_AddressStreet2();
    public static final MyMetaCustomer_AddressCity AddressCity = new MyMetaCustomer_AddressCity();
    public static final MyMetaCustomer_AddressRegion AddressRegion = new MyMetaCustomer_AddressRegion();
    public static final MyMetaCustomer_AddressPostalCode AddressPostalCode = new MyMetaCustomer_AddressPostalCode();
    public static final MyMetaCustomer_AddressCountry AddressCountry = new MyMetaCustomer_AddressCountry();
    public static final MyMetaCustomer_LockVersion LockVersion = new MyMetaCustomer_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaCustomer_Project Project = new MyMetaCustomer_Project();
    public static final MyMetaCustomer_Tier Tier = new MyMetaCustomer_Tier();
}
