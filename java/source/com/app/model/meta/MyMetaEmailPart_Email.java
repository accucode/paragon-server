//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyEmail;
import com.app.model.MyEmailPart;

import com.kodemore.meta.KmMetaDaoAssociation;

public class MyMetaEmailPart_Email
    extends KmMetaDaoAssociation<MyEmailPart,MyEmail>
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
    public MyEmail getValueFor(MyEmailPart model)
    {
        return model.getEmail();
    }
    
    @Override
    public void setValueFor(MyEmailPart model, MyEmail value)
    {
        model.setEmail(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailPart model, MyEmail value)
    {
        return model.hasEmail(value);
    }
}
