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

public final class MyChoiceFinder
    implements KmKeyFinderIF<MyChoice,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyChoiceFinder instance = new MyChoiceFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyChoiceFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyChoice find(String key)
    {
        return new MyChoiceDao().findUid(key);
    }

    public MyChoice findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
