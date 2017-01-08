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

public class MyMetaUserActivation
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaUserActivation instance = new MyMetaUserActivation();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaUserActivation()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "userActivation";
    }

    public MyUserActivationValidator getValidator()
    {
        return MyUserActivationValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A request to activate a new user account via email.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaUserActivation_Uid Uid = new MyMetaUserActivation_Uid();
    public static final MyMetaUserActivation_CreatedUtcTs CreatedUtcTs = new MyMetaUserActivation_CreatedUtcTs();
    public static final MyMetaUserActivation_UpdatedUtcTs UpdatedUtcTs = new MyMetaUserActivation_UpdatedUtcTs();
    public static final MyMetaUserActivation_Email Email = new MyMetaUserActivation_Email();
    public static final MyMetaUserActivation_Token Token = new MyMetaUserActivation_Token();
    public static final MyMetaUserActivation_ExpirationUtcTs ExpirationUtcTs = new MyMetaUserActivation_ExpirationUtcTs();
    public static final MyMetaUserActivation_LockVersion LockVersion = new MyMetaUserActivation_LockVersion();
    public static final MyMetaUserActivation_DisplayString DisplayString = new MyMetaUserActivation_DisplayString();
    public static final MyMetaUserActivation_CreatedLocalTs CreatedLocalTs = new MyMetaUserActivation_CreatedLocalTs();
    public static final MyMetaUserActivation_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaUserActivation_CreatedLocalTsMessage();
    public static final MyMetaUserActivation_CreatedLocalDate CreatedLocalDate = new MyMetaUserActivation_CreatedLocalDate();
    public static final MyMetaUserActivation_CreatedLocalTime CreatedLocalTime = new MyMetaUserActivation_CreatedLocalTime();
    public static final MyMetaUserActivation_UpdatedLocalTs UpdatedLocalTs = new MyMetaUserActivation_UpdatedLocalTs();
    public static final MyMetaUserActivation_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaUserActivation_UpdatedLocalTsMessage();
    public static final MyMetaUserActivation_UpdatedLocalDate UpdatedLocalDate = new MyMetaUserActivation_UpdatedLocalDate();
    public static final MyMetaUserActivation_UpdatedLocalTime UpdatedLocalTime = new MyMetaUserActivation_UpdatedLocalTime();
    public static final MyMetaUserActivation_ExpirationLocalTs ExpirationLocalTs = new MyMetaUserActivation_ExpirationLocalTs();
    public static final MyMetaUserActivation_ExpirationLocalTsMessage ExpirationLocalTsMessage = new MyMetaUserActivation_ExpirationLocalTsMessage();
    public static final MyMetaUserActivation_ExpirationLocalDate ExpirationLocalDate = new MyMetaUserActivation_ExpirationLocalDate();
    public static final MyMetaUserActivation_ExpirationLocalTime ExpirationLocalTime = new MyMetaUserActivation_ExpirationLocalTime();
    public static final MyMetaUserActivation_CreatedByFullName CreatedByFullName = new MyMetaUserActivation_CreatedByFullName();
    public static final MyMetaUserActivation_UpdatedByFullName UpdatedByFullName = new MyMetaUserActivation_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaUserActivation_CreatedBy CreatedBy = new MyMetaUserActivation_CreatedBy();
    public static final MyMetaUserActivation_UpdatedBy UpdatedBy = new MyMetaUserActivation_UpdatedBy();
    public static final MyMetaUserActivation_Tenant Tenant = new MyMetaUserActivation_Tenant();
}
