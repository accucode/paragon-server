package com.app.ui.page.crud.member;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyMemberListPage
    extends MyCrudListPage<MyProject,MyMember>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyMemberListPage _instance;

    public static void installInstance()
    {
        _instance = new MyMemberListPage();
    }

    public static MyMemberListPage getInstance()
    {
        return _instance;
    }

    private MyMemberListPage()
    {
        super(new MyMemberBuilder());
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
