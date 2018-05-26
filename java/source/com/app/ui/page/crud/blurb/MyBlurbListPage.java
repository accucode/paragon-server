package com.app.ui.page.crud.blurb;

import com.app.model.MyBlurb;
import com.app.model.MyProject;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyBlurbListPage
    extends MyCrudListPage<MyProject,MyBlurb>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyBlurbListPage _instance;

    public static void installInstance()
    {
        _instance = new MyBlurbListPage();
    }

    public static MyBlurbListPage getInstance()
    {
        return _instance;
    }

    private MyBlurbListPage()
    {
        super(new MyBlurbBuilder());
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
        return MySecurityLevel.projectManager;
    }
}
