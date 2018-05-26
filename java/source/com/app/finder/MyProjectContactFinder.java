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

public final class MyProjectContactFinder
    implements KmKeyFinderIF<MyProjectContact,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyProjectContactFinder instance = new MyProjectContactFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyProjectContactFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyProjectContact find(String key)
    {
        return new MyProjectContactDao().findUid(key);
    }

    public MyProjectContact findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
