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

public class MyAttributeValueFinder
    implements KmKeyFinderIF<MyAttributeValue,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAttributeValue staticFind(String key)
    {
        return new MyAttributeValueFinder().find(key);
    }

    public static MyAttributeValue staticFindDao(String key)
    {
        return new MyAttributeValueFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAttributeValue find(String key)
    {
        return new MyAttributeValueDao().findUid(key);
    }

    public MyAttributeValue findDao(String key)
    {
        MyDaoKeyFinder<MyAttributeValue,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
