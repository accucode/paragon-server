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

public class MyVisitTypeFinder
    implements KmKeyFinderIF<MyVisitType,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyVisitType staticFind(String key)
    {
        return new MyVisitTypeFinder().find(key);
    }

    public static MyVisitType staticFindDao(String key)
    {
        return new MyVisitTypeFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyVisitType find(String key)
    {
        return new MyVisitTypeDao().findUid(key);
    }

    public MyVisitType findDao(String key)
    {
        MyDaoKeyFinder<MyVisitType,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
