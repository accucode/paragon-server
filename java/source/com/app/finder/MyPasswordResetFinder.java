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
