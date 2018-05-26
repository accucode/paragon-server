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

public final class MyUserRecentProjectFinder
    implements KmKeyFinderIF<MyUserRecentProject,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyUserRecentProjectFinder instance = new MyUserRecentProjectFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyUserRecentProjectFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyUserRecentProject find(String key)
    {
        return new MyUserRecentProjectDao().findUid(key);
    }

    public MyUserRecentProject findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
