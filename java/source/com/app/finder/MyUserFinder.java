//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.command.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public final class MyUserFinder
    implements KmKeyFinderIF<MyUser,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyUserFinder instance = new MyUserFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyUserFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyUser find(String key)
    {
        return new MyUserDao().findUid(key);
    }

    public MyUser findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
