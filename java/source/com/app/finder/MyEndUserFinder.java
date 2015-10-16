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

public class MyEndUserFinder
    implements KmKeyFinderIF<MyEndUser,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyEndUser staticFind(String key)
    {
        return new MyEndUserFinder().find(key);
    }

    public static MyEndUser staticFindDao(String key)
    {
        return new MyEndUserFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEndUser find(String key)
    {
        return new MyEndUserDao().findUid(key);
    }

    public MyEndUser findDao(String key)
    {
        MyDaoKeyFinder<MyEndUser,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
