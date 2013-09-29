//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyAccount;
import com.app.model.MyServerSession;

import com.kodemore.meta.KmMetaDaoAssociation;

public class MyMetaServerSession_Account
    extends KmMetaDaoAssociation<MyServerSession,MyAccount>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "account";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAccount getValueFor(MyServerSession model)
    {
        return model.getAccount();
    }
    
    @Override
    public void setValueFor(MyServerSession model, MyAccount value)
    {
        model.setAccount(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, MyAccount value)
    {
        return model.hasAccount(value);
    }
}
