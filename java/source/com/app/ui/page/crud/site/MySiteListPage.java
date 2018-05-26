package com.app.ui.page.crud.site;

import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MySiteListPage
    extends MyCrudListPage<MyProject,MySite>
{
    //##################################################
    //# singleton
    //##################################################

    private static MySiteListPage _instance;

    public static void installInstance()
    {
        _instance = new MySiteListPage();
    }

    public static MySiteListPage getInstance()
    {
        return _instance;
    }

    private MySiteListPage()
    {
        super(createBuilder());
    }

    //##################################################
    //# test
    //##################################################

    private static MySiteBuilder createBuilder()
    {
        MySiteBuilder e;
        e = new MySiteBuilder();
        e.setSearchView(new MySiteSearchView(e));

        return e;
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyProject getDomainParent()
    {
        return getCurrentProject();
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectWorker;
    }
}
