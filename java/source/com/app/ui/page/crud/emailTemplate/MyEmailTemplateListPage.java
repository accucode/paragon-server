package com.app.ui.page.crud.emailTemplate;

import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyEmailTemplateListPage
    extends MyCrudListPage<MyProject,MyEmailTemplate>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyEmailTemplateListPage _instance;

    public static void installInstance()
    {
        _instance = new MyEmailTemplateListPage();
    }

    public static MyEmailTemplateListPage getInstance()
    {
        return _instance;
    }

    private MyEmailTemplateListPage()
    {
        super(new MyEmailTemplateBuilder());
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
