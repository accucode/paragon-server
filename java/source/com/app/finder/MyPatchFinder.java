//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public class MyPatchFinder
    implements KmKeyFinderIF<MyPatch,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyPatch staticFind(String key)
    {
        return new MyPatchFinder().find(key);
    }

    public static MyPatch staticFindDao(String key)
    {
        return new MyPatchFinder().findDao(key);
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
        MyDaoKeyFinder<MyPatch,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
