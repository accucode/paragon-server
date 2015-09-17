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

public class MyCategoryFinder
    implements KmKeyFinderIF<MyCategory,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyCategory staticFind(String key)
    {
        return new MyCategoryFinder().find(key);
    }

    public static MyCategory staticFindDao(String key)
    {
        return new MyCategoryFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCategory find(String key)
    {
        return new MyCategoryDao().findUid(key);
    }

    public MyCategory findDao(String key)
    {
        MyDaoKeyFinder<MyCategory,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
