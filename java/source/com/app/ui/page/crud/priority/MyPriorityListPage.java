package com.app.ui.page.crud.priority;

import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyPriorityListPage
    extends MyCrudListPage<MyProject,MyPriority>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyPriorityListPage _instance;

    public static void installInstance()
    {
        _instance = new MyPriorityListPage();
    }

    public static MyPriorityListPage getInstance()
    {
        return _instance;
    }

    private MyPriorityListPage()
    {
        super(new MyPriorityBuilder());
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
