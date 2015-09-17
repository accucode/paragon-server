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

public class MyPowerTypeFinder
    implements KmKeyFinderIF<MyPowerType,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyPowerType staticFind(String key)
    {
        return new MyPowerTypeFinder().find(key);
    }

    public static MyPowerType staticFindDao(String key)
    {
        return new MyPowerTypeFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPowerType find(String key)
    {
        return new MyPowerTypeDao().findUid(key);
    }

    public MyPowerType findDao(String key)
    {
        MyDaoKeyFinder<MyPowerType,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
