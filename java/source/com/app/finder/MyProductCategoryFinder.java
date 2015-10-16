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

public class MyProductCategoryFinder
    implements KmKeyFinderIF<MyProductCategory,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyProductCategory staticFind(String key)
    {
        return new MyProductCategoryFinder().find(key);
    }

    public static MyProductCategory staticFindDao(String key)
    {
        return new MyProductCategoryFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyProductCategory find(String key)
    {
        return new MyProductCategoryDao().findUid(key);
    }

    public MyProductCategory findDao(String key)
    {
        MyDaoKeyFinder<MyProductCategory,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
