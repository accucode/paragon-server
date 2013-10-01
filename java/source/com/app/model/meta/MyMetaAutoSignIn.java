//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyAutoSignInValidator;

import com.kodemore.meta.KmMetaModel;

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

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAutoSignIn_Uid Uid = new MyMetaAutoSignIn_Uid();
    public static final MyMetaAutoSignIn_CreatedUtcTs CreatedUtcTs = new MyMetaAutoSignIn_CreatedUtcTs();
    public static final MyMetaAutoSignIn_LastUtcTs LastUtcTs = new MyMetaAutoSignIn_LastUtcTs();
    public static final MyMetaAutoSignIn_LockVersion LockVersion = new MyMetaAutoSignIn_LockVersion();
    public static final MyMetaAutoSignIn_CreatedLocalTs CreatedLocalTs = new MyMetaAutoSignIn_CreatedLocalTs();
    public static final MyMetaAutoSignIn_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAutoSignIn_CreatedLocalTsMessage();
    public static final MyMetaAutoSignIn_CreatedLocalDate CreatedLocalDate = new MyMetaAutoSignIn_CreatedLocalDate();
    public static final MyMetaAutoSignIn_CreatedLocalTime CreatedLocalTime = new MyMetaAutoSignIn_CreatedLocalTime();
    public static final MyMetaAutoSignIn_LastLocalTs LastLocalTs = new MyMetaAutoSignIn_LastLocalTs();
    public static final MyMetaAutoSignIn_LastLocalTsMessage LastLocalTsMessage = new MyMetaAutoSignIn_LastLocalTsMessage();
    public static final MyMetaAutoSignIn_LastLocalDate LastLocalDate = new MyMetaAutoSignIn_LastLocalDate();
    public static final MyMetaAutoSignIn_LastLocalTime LastLocalTime = new MyMetaAutoSignIn_LastLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAutoSignIn_User User = new MyMetaAutoSignIn_User();
}
