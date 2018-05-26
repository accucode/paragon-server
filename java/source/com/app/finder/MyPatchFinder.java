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

public final class MyPatchFinder
    implements KmKeyFinderIF<MyPatch,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyPatchFinder instance = new MyPatchFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyPatchFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPatch find(String key)
    {
        return new MyPatchDao().findName(key);
    }

    public MyPatch findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
