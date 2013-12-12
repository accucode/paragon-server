//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MyFileDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyFile;

public class MyFileFinder
    implements KmKeyFinderIF<MyFile,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MyFile staticFind(Integer key)
    {
        return new MyFileFinder().find(key);
    }

    public static MyFile staticFindDao(Integer key)
    {
        return new MyFileFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyFile find(Integer key)
    {
        return new MyFileDao().findId(key);
    }

    public MyFile findDao(Integer key)
    {
        MyDaoKeyFinder<MyFile,Integer> e;
        e = new MyDaoKeyFinder<MyFile,Integer>(this, key);
        e.run();
        return e.getValue();
    }
}
