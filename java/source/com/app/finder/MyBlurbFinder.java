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

public final class MyBlurbFinder
    implements KmKeyFinderIF<MyBlurb,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyBlurbFinder instance = new MyBlurbFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyBlurbFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyBlurb find(String key)
    {
        return new MyBlurbDao().findUid(key);
    }

    public MyBlurb findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
