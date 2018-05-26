package com.app.ui.page.crud.customer;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyCustomerListPage
    extends MyCrudListPage<MyProject,MyCustomer>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyCustomerListPage _instance;

    public static void installInstance()
    {
        _instance = new MyCustomerListPage();
    }

    public static MyCustomerListPage getInstance()
    {
        return _instance;
    }

    private MyCustomerListPage()
    {
        super(new MyCustomerBuilder());
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
