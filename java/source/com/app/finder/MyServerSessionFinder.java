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

public final class MyServerSessionFinder
    implements KmKeyFinderIF<MyServerSession,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyServerSessionFinder instance = new MyServerSessionFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyServerSessionFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyServerSession find(String key)
    {
        return new MyServerSessionDao().findUid(key);
    }

    public MyServerSession findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
