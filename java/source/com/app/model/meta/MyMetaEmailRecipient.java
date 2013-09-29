//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyEmailRecipientValidator;

import com.kodemore.meta.KmMetaModel;

public class MyMetaEmailRecipient
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmailRecipient instance = new MyMetaEmailRecipient();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmailRecipient()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "emailRecipient";
    }

    public static MyEmailRecipientValidator getValidator()
    {
        return MyEmailRecipientValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEmailRecipient_Uid Uid = new MyMetaEmailRecipient_Uid();
    public static final MyMetaEmailRecipient_Address Address = new MyMetaEmailRecipient_Address();
    public static final MyMetaEmailRecipient_TypeCode TypeCode = new MyMetaEmailRecipient_TypeCode();
    public static final MyMetaEmailRecipient_LockVersion LockVersion = new MyMetaEmailRecipient_LockVersion();
    public static final MyMetaEmailRecipient_TypeName TypeName = new MyMetaEmailRecipient_TypeName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEmailRecipient_Email Email = new MyMetaEmailRecipient_Email();
}
