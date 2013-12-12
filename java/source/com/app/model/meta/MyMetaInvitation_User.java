//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaDaoAssociation;

import com.app.model.MyInvitation;
import com.app.model.MyUser;

public class MyMetaInvitation_User
    extends KmMetaDaoAssociation<MyInvitation,MyUser>
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
    public MyUser getValueFor(MyInvitation model)
    {
        return model.getUser();
    }
    
    @Override
    public void setValueFor(MyInvitation model, MyUser value)
    {
        model.setUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, MyUser value)
    {
        return model.hasUser(value);
    }
}
