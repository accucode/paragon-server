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

public class MySalesOrderFinder
    implements KmKeyFinderIF<MySalesOrder,String>
{
    //##################################################
    //# static
    //##################################################

    public static MySalesOrder staticFind(String key)
    {
        return new MySalesOrderFinder().find(key);
    }

    public static MySalesOrder staticFindDao(String key)
    {
        return new MySalesOrderFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySalesOrder find(String key)
    {
        return new MySalesOrderDao().findUid(key);
    }

    public MySalesOrder findDao(String key)
    {
        MyDaoKeyFinder<MySalesOrder,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
