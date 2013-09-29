//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyDownload;
import com.app.model.MyUser;

import com.kodemore.meta.KmMetaDaoAssociation;

public class MyMetaDownload_User
    extends KmMetaDaoAssociation<MyDownload,MyUser>
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
    public MyUser getValueFor(MyDownload model)
    {
        return model.getUser();
    }
    
    @Override
    public void setValueFor(MyDownload model, MyUser value)
    {
        model.setUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyDownload model, MyUser value)
    {
        return model.hasUser(value);
    }
}
