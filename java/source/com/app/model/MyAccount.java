package com.app.model;

import com.kodemore.collection.KmCollection;

import com.app.model.base.MyAccountBase;
import com.app.model.meta.MyMetaAccountUser;
import com.app.model.meta.MyMetaUser;

public class MyAccount
    extends MyAccountBase
{
    //##################################################
    //# constants
    //##################################################

    public static final String ROOT_UID = "root";

    //##################################################
    //# constructor
    //##################################################

    public MyAccount()
    {
        super();
    }

    //##################################################
    //# users
    //##################################################

    public KmCollection<MyUser> getUsers()
    {
        MyMetaAccountUser x = MyAccountUser.Meta;

        return getAccountUsers().collect(x.User);
    }

    public KmCollection<String> getUserNames()
    {
        MyMetaUser x = MyUser.Meta;

        return getUsers().collect(x.Name);
    }
}
