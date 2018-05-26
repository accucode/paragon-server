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

public final class MyEmailFinder
    implements KmKeyFinderIF<MyEmail,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyEmailFinder instance = new MyEmailFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmail find(String key)
    {
        return new MyEmailDao().findUid(key);
    }

    public MyEmail findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
