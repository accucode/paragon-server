//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaDaoAssociation;

import com.app.model.MyAccount;
import com.app.model.MyAccountUser;

public class MyMetaAccountUser_Account
    extends KmMetaDaoAssociation<MyAccountUser,MyAccount>
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
    public MyAccount getValueFor(MyAccountUser model)
    {
        return model.getAccount();
    }
    
    @Override
    public void setValueFor(MyAccountUser model, MyAccount value)
    {
        model.setAccount(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccountUser model, MyAccount value)
    {
        return model.hasAccount(value);
    }
}
