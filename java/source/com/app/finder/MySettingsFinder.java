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

public class MySettingsFinder
    implements KmKeyFinderIF<MySettings,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MySettings staticFind(Integer key)
    {
        return new MySettingsFinder().find(key);
    }

    public static MySettings staticFindDao(Integer key)
    {
        return new MySettingsFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySettings find(Integer key)
    {
        return new MySettingsDao().findCode(key);
    }

    public MySettings findDao(Integer key)
    {
        MyDaoKeyFinder<MySettings,Integer> e;
        e = new MyDaoKeyFinder<MySettings,Integer>(this, key);
        e.run();
        return e.getValue();
    }
}
