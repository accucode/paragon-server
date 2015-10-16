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

public class MyAuditLogFinder
    implements KmKeyFinderIF<MyAuditLog,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAuditLog staticFind(String key)
    {
        return new MyAuditLogFinder().find(key);
    }

    public static MyAuditLog staticFindDao(String key)
    {
        return new MyAuditLogFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAuditLog find(String key)
    {
        return new MyAuditLogDao().findUid(key);
    }

    public MyAuditLog findDao(String key)
    {
        MyDaoKeyFinder<MyAuditLog,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
