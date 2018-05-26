package com.app.ui.page.crud.holiday;

import com.app.model.MyHoliday;
import com.app.model.MyProject;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyHolidayListPage
    extends MyCrudListPage<MyProject,MyHoliday>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyHolidayListPage _instance;

    public static void installInstance()
    {
        _instance = new MyHolidayListPage();
    }

    public static MyHolidayListPage getInstance()
    {
        return _instance;
    }

    private MyHolidayListPage()
    {
        super(new MyHolidayBuilder());
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectManager;
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyProject getDomainParent()
    {
        return getCurrentProject();
    }

}
