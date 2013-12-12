//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaDaoAssociation;

import com.app.model.MyAutoSignIn;
import com.app.model.MyServerSession;

public class MyMetaServerSession_AutoSignIn
    extends KmMetaDaoAssociation<MyServerSession,MyAutoSignIn>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "autoSignIn";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAutoSignIn getValueFor(MyServerSession model)
    {
        return model.getAutoSignIn();
    }
    
    @Override
    public void setValueFor(MyServerSession model, MyAutoSignIn value)
    {
        model.setAutoSignIn(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, MyAutoSignIn value)
    {
        return model.hasAutoSignIn(value);
    }
}
