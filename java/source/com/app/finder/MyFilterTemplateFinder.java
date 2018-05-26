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

public final class MyFilterTemplateFinder
    implements KmKeyFinderIF<MyFilterTemplate,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyFilterTemplateFinder instance = new MyFilterTemplateFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyFilterTemplateFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyFilterTemplate find(String key)
    {
        return new MyFilterTemplateDao().findUid(key);
    }

    public MyFilterTemplate findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
