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
    implements KmKeyFinderIF<MyFile,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyFile staticFind(String key)
    {
        return new MyFileFinder().find(key);
    }

    public static MyFile staticFindDao(String key)
    {
        return new MyFileFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyFile find(String key)
    {
        return new MyFileDao().findUid(key);
    }

    public MyFile findDao(String key)
    {
        MyDaoKeyFinder<MyFile,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
