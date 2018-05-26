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

public final class MyAttachmentFinder
    implements KmKeyFinderIF<MyAttachment,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyAttachmentFinder instance = new MyAttachmentFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyAttachmentFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAttachment find(String key)
    {
        return new MyAttachmentDao().findUid(key);
    }

    public MyAttachment findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
