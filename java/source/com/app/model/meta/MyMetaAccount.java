//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaModel;

import com.app.model.MyAccountValidator;

public class MyMetaAccount
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAccount instance = new MyMetaAccount();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAccount()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "account";
    }

    public static MyAccountValidator getValidator()
    {
        return MyAccountValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAccount_Uid Uid = new MyMetaAccount_Uid();
    public static final MyMetaAccount_Name Name = new MyMetaAccount_Name();
    public static final MyMetaAccount_TypeCode TypeCode = new MyMetaAccount_TypeCode();
    public static final MyMetaAccount_LockVersion LockVersion = new MyMetaAccount_LockVersion();
    public static final MyMetaAccount_TypeName TypeName = new MyMetaAccount_TypeName();

    //##################################################
    //# associations
    //##################################################

}
