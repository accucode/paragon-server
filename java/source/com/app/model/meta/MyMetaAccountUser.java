//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaModel;

import com.app.model.MyAccountUserValidator;

public class MyMetaAccountUser
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAccountUser instance = new MyMetaAccountUser();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAccountUser()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "accountUser";
    }

    public static MyAccountUserValidator getValidator()
    {
        return MyAccountUserValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAccountUser_Uid Uid = new MyMetaAccountUser_Uid();
    public static final MyMetaAccountUser_RoleCode RoleCode = new MyMetaAccountUser_RoleCode();
    public static final MyMetaAccountUser_LockVersion LockVersion = new MyMetaAccountUser_LockVersion();
    public static final MyMetaAccountUser_RoleName RoleName = new MyMetaAccountUser_RoleName();
    public static final MyMetaAccountUser_AccountName AccountName = new MyMetaAccountUser_AccountName();
    public static final MyMetaAccountUser_UserName UserName = new MyMetaAccountUser_UserName();
    public static final MyMetaAccountUser_UserEmail UserEmail = new MyMetaAccountUser_UserEmail();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAccountUser_Account Account = new MyMetaAccountUser_Account();
    public static final MyMetaAccountUser_User User = new MyMetaAccountUser_User();
}
