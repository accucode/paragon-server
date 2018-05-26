package com.app.ui.page;

import com.kodemore.servlet.ScPageRegistry;

import com.app.ui.dashboard.core.MyDashboardPage;
import com.app.ui.servlet.base.MyPageRegistryBase;

public class MyPageRegistry
    extends MyPageRegistryBase
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        ScPageRegistry.install(new MyPageRegistry());
    }

    public static MyPageRegistry getInstance()
    {
        return (MyPageRegistry)ScPageRegistry.getInstance();
    }

    //##################################################
    //# constructor
    //##################################################

    protected MyPageRegistry()
    {
        // protected
    }

    //##################################################
    //# accessing
    //##################################################

    public MyPage getHomeActivity()
    {
        return MyDashboardPage.getInstance();
    }

    public void add(MyPage e)
    {
        super.add(e);
    }

    @Override
    public MyPage findKey(String key)
    {
        return (MyPage)super.findKey(key);
    }

}
