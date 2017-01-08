package com.app.ui.page.manage.project;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.manage.crud.MyCrudManageView;

public final class MyProjectManageView
    extends MyCrudManageView<MyTenant,MyProject>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectManageView()
    {
        this(new MyProjectBuilder());
    }

    public MyProjectManageView(MyProjectBuilder e)
    {
        super(e);
    }
}
