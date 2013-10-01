//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyPasswordReset;
import com.app.model.MyUser;

import com.kodemore.meta.KmMetaDaoAssociation;

public class MyMetaPasswordReset_User
    extends KmMetaDaoAssociation<MyPasswordReset,MyUser>
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
    public MyUser getValueFor(MyPasswordReset model)
    {
        return model.getUser();
    }
    
    @Override
    public void setValueFor(MyPasswordReset model, MyUser value)
    {
        model.setUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyPasswordReset model, MyUser value)
    {
        return model.hasUser(value);
    }
}
