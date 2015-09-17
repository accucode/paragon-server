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

public class MyProjectFinder
    implements KmKeyFinderIF<MyProject,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyProject staticFind(String key)
    {
        return new MyProjectFinder().find(key);
    }

    public static MyProject staticFindDao(String key)
    {
        return new MyProjectFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyProject find(String key)
    {
        return new MyProjectDao().findUid(key);
    }

    public MyProject findDao(String key)
    {
        MyDaoKeyFinder<MyProject,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
