//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.app.dao.MyPasswordResetDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyPasswordReset;

import com.kodemore.utility.KmKeyFinderIF;

public class MyPasswordResetFinder
    implements KmKeyFinderIF<MyPasswordReset,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyPasswordReset staticFind(String key)
    {
        return new MyPasswordResetFinder().find(key);
    }

    public static MyPasswordReset staticFindDao(String key)
    {
        return new MyPasswordResetFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPasswordReset find(String key)
    {
        return new MyPasswordResetDao().findUid(key);
    }

    public MyPasswordReset findDao(String key)
    {
        MyDaoKeyFinder<MyPasswordReset,String> e;
        e = new MyDaoKeyFinder<MyPasswordReset,String>(this, key);
        e.run();
        return e.getValue();
    }
}
