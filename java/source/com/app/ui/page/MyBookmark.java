package com.app.ui.page;

import com.kodemore.servlet.ScBookmark;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyTenant;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public class MyBookmark
    extends ScBookmark
{
    //##################################################
    //# constructor
    //##################################################

    public MyBookmark(MyPage e)
    {
        super(e);
    }

    //##################################################
    //# url
    //##################################################

    public final String formatEntryUrlFor(MyTenant e)
    {
        return MyUrls.formatEntryUrl(e, composeParameters());
    }

    //##################################################
    //# support
    //##################################################

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
