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

public class MySalesOrderLineFinder
    implements KmKeyFinderIF<MySalesOrderLine,String>
{
    //##################################################
    //# static
    //##################################################

    public static MySalesOrderLine staticFind(String key)
    {
        return new MySalesOrderLineFinder().find(key);
    }

    public static MySalesOrderLine staticFindDao(String key)
    {
        return new MySalesOrderLineFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySalesOrderLine find(String key)
    {
        return new MySalesOrderLineDao().findUid(key);
    }

    public MySalesOrderLine findDao(String key)
    {
        MyDaoKeyFinder<MySalesOrderLine,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
