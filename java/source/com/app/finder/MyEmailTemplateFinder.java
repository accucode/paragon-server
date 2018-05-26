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

public final class MyEmailTemplateFinder
    implements KmKeyFinderIF<MyEmailTemplate,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyEmailTemplateFinder instance = new MyEmailTemplateFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailTemplateFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmailTemplate find(String key)
    {
        return new MyEmailTemplateDao().findUid(key);
    }

    public MyEmailTemplate findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
