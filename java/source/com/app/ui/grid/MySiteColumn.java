package com.app.ui.grid;

import java.util.function.Function;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MySite;
import com.app.ui.grid.core.MyPopoutColumn;

public class MySiteColumn<P extends KmUidDomainIF>
    extends MyPopoutColumn<P,MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteColumn()
    {
        super();
    }

    public MySiteColumn(Function<P,MySite> fn)
    {
        super(fn);
    }

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        setHeader("Site");
        setWidth(200);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    protected String getTitleFor(MySite e)
    {
        return e.getFullName();
    }

    @Override
    protected MySite findChild(String uid)
    {
        return getAccess().findSiteUid(uid);
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    protected void ajaxViewChild(MySite e)
    {
        e.ajaxEnterPage();
    }

    @Override
    protected String getPopoutUrlFor(MySite e)
    {
        return e.formatEntryUrl();
    }
}
