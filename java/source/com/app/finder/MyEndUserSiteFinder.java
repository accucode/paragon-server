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

public class MyEndUserSiteFinder
    implements KmKeyFinderIF<MyEndUserSite,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyEndUserSite staticFind(String key)
    {
        return new MyEndUserSiteFinder().find(key);
    }

    public static MyEndUserSite staticFindDao(String key)
    {
        return new MyEndUserSiteFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEndUserSite find(String key)
    {
        return new MyEndUserSiteDao().findUid(key);
    }

    public MyEndUserSite findDao(String key)
    {
        MyDaoKeyFinder<MyEndUserSite,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
