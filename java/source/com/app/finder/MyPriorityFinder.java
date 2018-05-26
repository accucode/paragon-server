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

public final class MyPriorityFinder
    implements KmKeyFinderIF<MyPriority,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyPriorityFinder instance = new MyPriorityFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyPriorityFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPriority find(String key)
    {
        return new MyPriorityDao().findUid(key);
    }

    public MyPriority findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
