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

public class MyMetaAutoSignIn
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAutoSignIn instance = new MyMetaAutoSignIn();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAutoSignIn()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "autoSignIn";
    }

    public static MyAutoSignInValidator getValidator()
    {
        return MyAutoSignInValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Track the tokens that authorize a person/browser to automatically sign in.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAutoSignIn_Uid Uid = new MyMetaAutoSignIn_Uid();
    public static final MyMetaAutoSignIn_CreatedUtcTs CreatedUtcTs = new MyMetaAutoSignIn_CreatedUtcTs();
    public static final MyMetaAutoSignIn_LastTouchedUtcTs LastTouchedUtcTs = new MyMetaAutoSignIn_LastTouchedUtcTs();
    public static final MyMetaAutoSignIn_LockVersion LockVersion = new MyMetaAutoSignIn_LockVersion();
    public static final MyMetaAutoSignIn_CreatedLocalTs CreatedLocalTs = new MyMetaAutoSignIn_CreatedLocalTs();
    public static final MyMetaAutoSignIn_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAutoSignIn_CreatedLocalTsMessage();
    public static final MyMetaAutoSignIn_CreatedLocalDate CreatedLocalDate = new MyMetaAutoSignIn_CreatedLocalDate();
    public static final MyMetaAutoSignIn_CreatedLocalTime CreatedLocalTime = new MyMetaAutoSignIn_CreatedLocalTime();
    public static final MyMetaAutoSignIn_LastTouchedLocalTs LastTouchedLocalTs = new MyMetaAutoSignIn_LastTouchedLocalTs();
    public static final MyMetaAutoSignIn_LastTouchedLocalTsMessage LastTouchedLocalTsMessage = new MyMetaAutoSignIn_LastTouchedLocalTsMessage();
    public static final MyMetaAutoSignIn_LastTouchedLocalDate LastTouchedLocalDate = new MyMetaAutoSignIn_LastTouchedLocalDate();
    public static final MyMetaAutoSignIn_LastTouchedLocalTime LastTouchedLocalTime = new MyMetaAutoSignIn_LastTouchedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAutoSignIn_User User = new MyMetaAutoSignIn_User();
}
