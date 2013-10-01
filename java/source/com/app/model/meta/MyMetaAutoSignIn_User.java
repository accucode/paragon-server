//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyAutoSignIn;
import com.app.model.MyUser;

import com.kodemore.meta.KmMetaDaoAssociation;

public class MyMetaAutoSignIn_User
    extends KmMetaDaoAssociation<MyAutoSignIn,MyUser>
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
    public MyUser getValueFor(MyAutoSignIn model)
    {
        return model.getUser();
    }
    
    @Override
    public void setValueFor(MyAutoSignIn model, MyUser value)
    {
        model.setUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, MyUser value)
    {
        return model.hasUser(value);
    }
}
