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

public class MySalesOrderContactFinder
    implements KmKeyFinderIF<MySalesOrderContact,String>
{
    //##################################################
    //# static
    //##################################################

    public static MySalesOrderContact staticFind(String key)
    {
        return new MySalesOrderContactFinder().find(key);
    }

    public static MySalesOrderContact staticFindDao(String key)
    {
        return new MySalesOrderContactFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySalesOrderContact find(String key)
    {
        return new MySalesOrderContactDao().findUid(key);
    }

    public MySalesOrderContact findDao(String key)
    {
        MyDaoKeyFinder<MySalesOrderContact,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
