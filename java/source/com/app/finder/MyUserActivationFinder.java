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

public final class MyUserActivationFinder
    implements KmKeyFinderIF<MyUserActivation,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyUserActivationFinder instance = new MyUserActivationFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyUserActivationFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyUserActivation find(String key)
    {
        return new MyUserActivationDao().findUid(key);
    }

    public MyUserActivation findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
