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

public final class MyApplicationLogFinder
    implements KmKeyFinderIF<MyApplicationLog,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyApplicationLogFinder instance = new MyApplicationLogFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyApplicationLogFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyApplicationLog find(String key)
    {
        return new MyApplicationLogDao().findUid(key);
    }

    public MyApplicationLog findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
