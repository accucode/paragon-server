//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyAccount;
import com.app.model.MyInvitation;

import com.kodemore.meta.KmMetaDaoAssociation;

public class MyMetaInvitation_Account
    extends KmMetaDaoAssociation<MyInvitation,MyAccount>
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
    public MyAccount getValueFor(MyInvitation model)
    {
        return model.getAccount();
    }
    
    @Override
    public void setValueFor(MyInvitation model, MyAccount value)
    {
        model.setAccount(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, MyAccount value)
    {
        return model.hasAccount(value);
    }
}
