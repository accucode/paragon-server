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
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
