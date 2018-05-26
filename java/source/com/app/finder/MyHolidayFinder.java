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

public final class MyHolidayFinder
    implements KmKeyFinderIF<MyHoliday,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyHolidayFinder instance = new MyHolidayFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyHolidayFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyHoliday find(String key)
    {
        return new MyHolidayDao().findUid(key);
    }

    public MyHoliday findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
