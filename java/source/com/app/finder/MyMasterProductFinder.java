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

public class MyMasterProductFinder
    implements KmKeyFinderIF<MyMasterProduct,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyMasterProduct staticFind(String key)
    {
        return new MyMasterProductFinder().find(key);
    }

    public static MyMasterProduct staticFindDao(String key)
    {
        return new MyMasterProductFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyMasterProduct find(String key)
    {
        return new MyMasterProductDao().findUid(key);
    }

    public MyMasterProduct findDao(String key)
    {
        MyDaoKeyFinder<MyMasterProduct,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
