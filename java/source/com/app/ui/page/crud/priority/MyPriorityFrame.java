package com.app.ui.page.crud.priority;

import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyPriorityFrame
    extends MyCrudFrame<MyProject,MyPriority>
{
    //##################################################
    //# constructor
    //##################################################

    public MyPriorityFrame()
    {
        this(new MyPriorityBuilder());
    }

    public MyPriorityFrame(MyPriorityBuilder e)
    {
        super(e);
    }

}
