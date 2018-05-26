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

public final class MyAutoLoginFinder
    implements KmKeyFinderIF<MyAutoLogin,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyAutoLoginFinder instance = new MyAutoLoginFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyAutoLoginFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAutoLogin find(String key)
    {
        return new MyAutoLoginDao().findUid(key);
    }

    public MyAutoLogin findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
