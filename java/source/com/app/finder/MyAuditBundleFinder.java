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

public final class MyAuditBundleFinder
    implements KmKeyFinderIF<MyAuditBundle,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyAuditBundleFinder instance = new MyAuditBundleFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyAuditBundleFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAuditBundle find(String key)
    {
        return new MyAuditBundleDao().findUid(key);
    }

    public MyAuditBundle findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
