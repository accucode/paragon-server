package com.app.ui.page.crud.project;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyProjectFrame
    extends MyCrudFrame<MyTenant,MyProject>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectFrame()
    {
        this(new MyProjectBuilder());
    }

    public MyProjectFrame(MyProjectBuilder e)
    {
        super(e);
    }

}
