//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaDaoAssociation;

import com.app.model.MyServerSession;
import com.app.model.MyUser;

public class MyMetaServerSession_User
    extends KmMetaDaoAssociation<MyServerSession,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "user";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyServerSession model)
    {
        return model.getUser();
    }
    
    @Override
    public void setValueFor(MyServerSession model, MyUser value)
    {
        model.setUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, MyUser value)
    {
        return model.hasUser(value);
    }
}
