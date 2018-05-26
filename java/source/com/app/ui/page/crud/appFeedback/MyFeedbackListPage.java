package com.app.ui.page.crud.appFeedback;

import com.app.model.MyFeedback;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyFeedbackListPage
    extends MyCrudListPage<MyNullDomain,MyFeedback>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyFeedbackListPage _instance;

    public static void installInstance()
    {
        _instance = new MyFeedbackListPage();
    }

    public static MyFeedbackListPage getInstance()
    {
        return _instance;
    }

    private MyFeedbackListPage()
    {
        super(new MyFeedbackBuilder());
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyNullDomain getDomainParent()
    {
        return null;
    }

}
