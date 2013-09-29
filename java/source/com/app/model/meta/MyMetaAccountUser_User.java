//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyAccountUser;
import com.app.model.MyUser;

import com.kodemore.meta.KmMetaDaoAssociation;

public class MyMetaAccountUser_User
    extends KmMetaDaoAssociation<MyAccountUser,MyUser>
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
    public MyUser getValueFor(MyAccountUser model)
    {
        return model.getUser();
    }
    
    @Override
    public void setValueFor(MyAccountUser model, MyUser value)
    {
        model.setUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccountUser model, MyUser value)
    {
        return model.hasUser(value);
    }
}
