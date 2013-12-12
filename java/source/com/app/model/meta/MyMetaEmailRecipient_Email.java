//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaDaoAssociation;

import com.app.model.MyEmail;
import com.app.model.MyEmailRecipient;

public class MyMetaEmailRecipient_Email
    extends KmMetaDaoAssociation<MyEmailRecipient,MyEmail>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "email";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyEmail getValueFor(MyEmailRecipient model)
    {
        return model.getEmail();
    }
    
    @Override
    public void setValueFor(MyEmailRecipient model, MyEmail value)
    {
        model.setEmail(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailRecipient model, MyEmail value)
    {
        return model.hasEmail(value);
    }
}
