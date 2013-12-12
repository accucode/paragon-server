//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MyPatchDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyPatch;

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
        e = new MyDaoKeyFinder<MyPatch,String>(this, key);
        e.run();
        return e.getValue();
    }
}
