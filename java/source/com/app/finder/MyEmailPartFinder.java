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

public class MyEmailPartFinder
    implements KmKeyFinderIF<MyEmailPart,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyEmailPart staticFind(String key)
    {
        return new MyEmailPartFinder().find(key);
    }

    public static MyEmailPart staticFindDao(String key)
    {
        return new MyEmailPartFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmailPart find(String key)
    {
        return new MyEmailPartDao().findUid(key);
    }

    public MyEmailPart findDao(String key)
    {
        MyDaoKeyFinder<MyEmailPart,String> e;
        e = new MyDaoKeyFinder<MyEmailPart,String>(this, key);
        e.run();
        return e.getValue();
    }
}
