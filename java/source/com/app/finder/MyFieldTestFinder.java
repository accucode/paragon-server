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

public final class MyFieldTestFinder
    implements KmKeyFinderIF<MyFieldTest,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyFieldTestFinder instance = new MyFieldTestFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyFieldTestFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyFieldTest find(String key)
    {
        return new MyFieldTestDao().findUid(key);
    }

    public MyFieldTest findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
