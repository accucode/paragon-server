package com.app.ui.page.crud.priority;

import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyPriorityListView
    extends MyCrudListView<MyProject,MyPriority>
{
    //##################################################
    //# constructor
    //##################################################

    public MyPriorityListView()
    {
        this(new MyPriorityBuilder());
    }

    public MyPriorityListView(MyPriorityBuilder e)
    {
        super(e);
    }
}
