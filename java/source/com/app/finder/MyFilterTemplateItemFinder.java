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

public final class MyFilterTemplateItemFinder
    implements KmKeyFinderIF<MyFilterTemplateItem,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyFilterTemplateItemFinder instance = new MyFilterTemplateItemFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyFilterTemplateItemFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyFilterTemplateItem find(String key)
    {
        return new MyFilterTemplateItemDao().findUid(key);
    }

    public MyFilterTemplateItem findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
