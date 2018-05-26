package com.app.ui.page.crud.projectOption.core;

import com.app.model.MyProject;
import com.app.model.MyChoice;
import com.app.model.base.MyChoiceType;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public abstract class MyChoiceListPage
    extends MyCrudListPage<MyProject,MyChoice>
{
    //##################################################
    //# constructor
    //##################################################

    public MyChoiceListPage(MyChoiceBuilder e)
    {
        super(e);
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

    //##################################################
    //# topic
    //##################################################

    @Override
    protected MyChoiceBuilder getCrudBuilder()
    {
        return (MyChoiceBuilder)super.getCrudBuilder();
    }

    protected MyChoiceType getType()
    {
        return getCrudBuilder().getType();
    }

}
