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

public class MyMetaCustomerSite
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaCustomerSite instance = new MyMetaCustomerSite();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaCustomerSite()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customerSite";
    }

    public static MyCustomerSiteValidator getValidator()
    {
        return MyCustomerSiteValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The sites (addresses/locations) associated with each customer.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaCustomerSite_Uid Uid = new MyMetaCustomerSite_Uid();
    public static final MyMetaCustomerSite_Name Name = new MyMetaCustomerSite_Name();
    public static final MyMetaCustomerSite_AddressStreet1 AddressStreet1 = new MyMetaCustomerSite_AddressStreet1();
    public static final MyMetaCustomerSite_AddressStreet2 AddressStreet2 = new MyMetaCustomerSite_AddressStreet2();
    public static final MyMetaCustomerSite_AddressCity AddressCity = new MyMetaCustomerSite_AddressCity();
    public static final MyMetaCustomerSite_AddressRegion AddressRegion = new MyMetaCustomerSite_AddressRegion();
    public static final MyMetaCustomerSite_AddressPostalCode AddressPostalCode = new MyMetaCustomerSite_AddressPostalCode();
    public static final MyMetaCustomerSite_AddressCountry AddressCountry = new MyMetaCustomerSite_AddressCountry();
    public static final MyMetaCustomerSite_LockVersion LockVersion = new MyMetaCustomerSite_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaCustomerSite_Customer Customer = new MyMetaCustomerSite_Customer();
}
