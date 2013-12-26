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

public class MyMetaUserAccount
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaUserAccount instance = new MyMetaUserAccount();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaUserAccount()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "userAccount";
    }

    public static MyUserAccountValidator getValidator()
    {
        return MyUserAccountValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaUserAccount_Uid Uid = new MyMetaUserAccount_Uid();
    public static final MyMetaUserAccount_RoleCode RoleCode = new MyMetaUserAccount_RoleCode();
    public static final MyMetaUserAccount_LockVersion LockVersion = new MyMetaUserAccount_LockVersion();
    public static final MyMetaUserAccount_RoleName RoleName = new MyMetaUserAccount_RoleName();
    public static final MyMetaUserAccount_UserName UserName = new MyMetaUserAccount_UserName();
    public static final MyMetaUserAccount_UserEmail UserEmail = new MyMetaUserAccount_UserEmail();
    public static final MyMetaUserAccount_AccountName AccountName = new MyMetaUserAccount_AccountName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaUserAccount_User User = new MyMetaUserAccount_User();
    public static final MyMetaUserAccount_Account Account = new MyMetaUserAccount_Account();
}
