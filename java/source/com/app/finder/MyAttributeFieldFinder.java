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

public class MyAttributeFieldFinder
    implements KmKeyFinderIF<MyAttributeField,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAttributeField staticFind(String key)
    {
        return new MyAttributeFieldFinder().find(key);
    }

    public static MyAttributeField staticFindDao(String key)
    {
        return new MyAttributeFieldFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAttributeField find(String key)
    {
        return new MyAttributeFieldDao().findUid(key);
    }

    public MyAttributeField findDao(String key)
    {
        MyDaoKeyFinder<MyAttributeField,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
