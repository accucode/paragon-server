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

public final class MyDownloadFinder
    implements KmKeyFinderIF<MyDownload,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyDownloadFinder instance = new MyDownloadFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyDownloadFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyDownload find(String key)
    {
        return new MyDownloadDao().findUid(key);
    }

    public MyDownload findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
