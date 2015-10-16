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

public class MyMetaCustomerTier
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaCustomerTier instance = new MyMetaCustomerTier();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaCustomerTier()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customerTier";
    }

    public static MyCustomerTierValidator getValidator()
    {
        return MyCustomerTierValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The tiers used to organize and report of customers. Examples may include OEM, Distributor, Reseller, and Consumer.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaCustomerTier_Uid Uid = new MyMetaCustomerTier_Uid();
    public static final MyMetaCustomerTier_Name Name = new MyMetaCustomerTier_Name();
    public static final MyMetaCustomerTier_DiscountRate DiscountRate = new MyMetaCustomerTier_DiscountRate();
    public static final MyMetaCustomerTier_LockVersion LockVersion = new MyMetaCustomerTier_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaCustomerTier_Project Project = new MyMetaCustomerTier_Project();
}
