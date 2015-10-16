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

public class MyFieldTestFinder
    implements KmKeyFinderIF<MyFieldTest,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyFieldTest staticFind(String key)
    {
        return new MyFieldTestFinder().find(key);
    }

    public static MyFieldTest staticFindDao(String key)
    {
        return new MyFieldTestFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyFieldTest find(String key)
    {
        return new MyFieldTestDao().findUid(key);
    }

    public MyFieldTest findDao(String key)
    {
        MyDaoKeyFinder<MyFieldTest,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
