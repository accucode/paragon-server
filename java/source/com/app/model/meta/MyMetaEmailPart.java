//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyEmailPartValidator;

import com.kodemore.meta.KmMetaModel;

public class MyMetaEmailPart
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmailPart instance = new MyMetaEmailPart();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmailPart()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "emailPart";
    }

    public static MyEmailPartValidator getValidator()
    {
        return MyEmailPartValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEmailPart_Uid Uid = new MyMetaEmailPart_Uid();
    public static final MyMetaEmailPart_Sequence Sequence = new MyMetaEmailPart_Sequence();
    public static final MyMetaEmailPart_TypeCode TypeCode = new MyMetaEmailPart_TypeCode();
    public static final MyMetaEmailPart_AttachmentName AttachmentName = new MyMetaEmailPart_AttachmentName();
    public static final MyMetaEmailPart_Data Data = new MyMetaEmailPart_Data();
    public static final MyMetaEmailPart_LockVersion LockVersion = new MyMetaEmailPart_LockVersion();
    public static final MyMetaEmailPart_TypeName TypeName = new MyMetaEmailPart_TypeName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEmailPart_Email Email = new MyMetaEmailPart_Email();
}
