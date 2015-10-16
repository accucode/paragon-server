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

public class MyMetaPasswordReset
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPasswordReset instance = new MyMetaPasswordReset();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPasswordReset()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "passwordReset";
    }

    public static MyPasswordResetValidator getValidator()
    {
        return MyPasswordResetValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A request to reset a user's password.  When a user requests to reset a password, we confirm the request by sending an email.  When the user responds to the email, the response is checked against this record to authenticate the request.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPasswordReset_Uid Uid = new MyMetaPasswordReset_Uid();
    public static final MyMetaPasswordReset_Email Email = new MyMetaPasswordReset_Email();
    public static final MyMetaPasswordReset_Token Token = new MyMetaPasswordReset_Token();
    public static final MyMetaPasswordReset_CreatedUtcTs CreatedUtcTs = new MyMetaPasswordReset_CreatedUtcTs();
    public static final MyMetaPasswordReset_ExpirationUtcTs ExpirationUtcTs = new MyMetaPasswordReset_ExpirationUtcTs();
    public static final MyMetaPasswordReset_LockVersion LockVersion = new MyMetaPasswordReset_LockVersion();
    public static final MyMetaPasswordReset_CreatedLocalTs CreatedLocalTs = new MyMetaPasswordReset_CreatedLocalTs();
    public static final MyMetaPasswordReset_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaPasswordReset_CreatedLocalTsMessage();
    public static final MyMetaPasswordReset_CreatedLocalDate CreatedLocalDate = new MyMetaPasswordReset_CreatedLocalDate();
    public static final MyMetaPasswordReset_CreatedLocalTime CreatedLocalTime = new MyMetaPasswordReset_CreatedLocalTime();
    public static final MyMetaPasswordReset_ExpirationLocalTs ExpirationLocalTs = new MyMetaPasswordReset_ExpirationLocalTs();
    public static final MyMetaPasswordReset_ExpirationLocalTsMessage ExpirationLocalTsMessage = new MyMetaPasswordReset_ExpirationLocalTsMessage();
    public static final MyMetaPasswordReset_ExpirationLocalDate ExpirationLocalDate = new MyMetaPasswordReset_ExpirationLocalDate();
    public static final MyMetaPasswordReset_ExpirationLocalTime ExpirationLocalTime = new MyMetaPasswordReset_ExpirationLocalTime();

    //##################################################
    //# associations
    //##################################################

}
