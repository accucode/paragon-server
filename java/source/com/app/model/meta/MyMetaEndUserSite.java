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

public class MyMetaEndUserSite
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEndUserSite instance = new MyMetaEndUserSite();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEndUserSite()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "endUserSite";
    }

    public static MyEndUserSiteValidator getValidator()
    {
        return MyEndUserSiteValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The sites (addresses/locations) associated with each end user.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEndUserSite_Uid Uid = new MyMetaEndUserSite_Uid();
    public static final MyMetaEndUserSite_Name Name = new MyMetaEndUserSite_Name();
    public static final MyMetaEndUserSite_AddressStreet1 AddressStreet1 = new MyMetaEndUserSite_AddressStreet1();
    public static final MyMetaEndUserSite_AddressStreet2 AddressStreet2 = new MyMetaEndUserSite_AddressStreet2();
    public static final MyMetaEndUserSite_AddressCity AddressCity = new MyMetaEndUserSite_AddressCity();
    public static final MyMetaEndUserSite_AddressRegion AddressRegion = new MyMetaEndUserSite_AddressRegion();
    public static final MyMetaEndUserSite_AddressPostalCode AddressPostalCode = new MyMetaEndUserSite_AddressPostalCode();
    public static final MyMetaEndUserSite_AddressCountry AddressCountry = new MyMetaEndUserSite_AddressCountry();
    public static final MyMetaEndUserSite_LockVersion LockVersion = new MyMetaEndUserSite_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEndUserSite_EndUser EndUser = new MyMetaEndUserSite_EndUser();
}
