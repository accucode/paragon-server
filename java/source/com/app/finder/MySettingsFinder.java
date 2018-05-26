//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.command.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public final class MySettingsFinder
    implements KmKeyFinderIF<MySettings,Integer>
{
    //##################################################
    //# instance
    //##################################################

    public static final MySettingsFinder instance = new MySettingsFinder();

    //##################################################
    //# constructor
    //##################################################

    private MySettingsFinder()
    {
        // private
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
        return KmDao.fetch(this::find, key);
    }
}
