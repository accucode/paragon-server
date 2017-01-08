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

public class MyMetaAutoLogin
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAutoLogin instance = new MyMetaAutoLogin();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAutoLogin()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "autoLogin";
    }

    public MyAutoLoginValidator getValidator()
    {
        return MyAutoLoginValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Track the tokens that authorize a person/browser to automatically log in.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAutoLogin_Uid Uid = new MyMetaAutoLogin_Uid();
    public static final MyMetaAutoLogin_CreatedUtcTs CreatedUtcTs = new MyMetaAutoLogin_CreatedUtcTs();
    public static final MyMetaAutoLogin_LastTouchedUtcTs LastTouchedUtcTs = new MyMetaAutoLogin_LastTouchedUtcTs();
    public static final MyMetaAutoLogin_LockVersion LockVersion = new MyMetaAutoLogin_LockVersion();
    public static final MyMetaAutoLogin_DisplayString DisplayString = new MyMetaAutoLogin_DisplayString();
    public static final MyMetaAutoLogin_CreatedLocalTs CreatedLocalTs = new MyMetaAutoLogin_CreatedLocalTs();
    public static final MyMetaAutoLogin_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAutoLogin_CreatedLocalTsMessage();
    public static final MyMetaAutoLogin_CreatedLocalDate CreatedLocalDate = new MyMetaAutoLogin_CreatedLocalDate();
    public static final MyMetaAutoLogin_CreatedLocalTime CreatedLocalTime = new MyMetaAutoLogin_CreatedLocalTime();
    public static final MyMetaAutoLogin_LastTouchedLocalTs LastTouchedLocalTs = new MyMetaAutoLogin_LastTouchedLocalTs();
    public static final MyMetaAutoLogin_LastTouchedLocalTsMessage LastTouchedLocalTsMessage = new MyMetaAutoLogin_LastTouchedLocalTsMessage();
    public static final MyMetaAutoLogin_LastTouchedLocalDate LastTouchedLocalDate = new MyMetaAutoLogin_LastTouchedLocalDate();
    public static final MyMetaAutoLogin_LastTouchedLocalTime LastTouchedLocalTime = new MyMetaAutoLogin_LastTouchedLocalTime();
    public static final MyMetaAutoLogin_UserFullName UserFullName = new MyMetaAutoLogin_UserFullName();
    public static final MyMetaAutoLogin_TenantName TenantName = new MyMetaAutoLogin_TenantName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAutoLogin_User User = new MyMetaAutoLogin_User();
}
