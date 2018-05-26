package com.app.ui.page.crud.projectVendor;

import com.app.model.MyProject;
import com.app.model.MyVendor;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyVendorListPage
    extends MyCrudListPage<MyProject,MyVendor>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyVendorListPage _instance;

    public static void installInstance()
    {
        _instance = new MyVendorListPage();
    }

    public static MyVendorListPage getInstance()
    {
        return _instance;
    }

    private MyVendorListPage()
    {
        super(new MyVendorBuilder());
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
