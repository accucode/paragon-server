package com.app.ui.page.crud.project;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.MyPageModule;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyProjectListPage
    extends MyCrudListPage<MyTenant,MyProject>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectListPage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectListPage();
    }

    public static MyProjectListPage getInstance()
    {
        return _instance;
    }

    private MyProjectListPage()
    {
        super(new MyProjectBuilder());
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.tenantAdmin;
    }

    @Override
    protected MyPageModule getModule()
    {
        return MyPageModule.Global;
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyTenant getDomainParent()
    {
        return getCurrentTenant();
    }
}
