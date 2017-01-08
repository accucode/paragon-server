package com.app.ui.page.manage.project;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.manage.crud.MyCrudManagePage;

public final class MyProjectManagePage
    extends MyCrudManagePage<MyTenant,MyProject>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectManagePage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectManagePage();
    }

    public static MyProjectManagePage getInstance()
    {
        return _instance;
    }

    private MyProjectManagePage()
    {
        super(new MyProjectBuilder());
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyTenant getDomainParent()
    {
        return getCurrentTenant();
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
    }

    @Override
    public String getHelpMessage()
    {
        return getCrudBuilder().getChildHelp();
    }
}
