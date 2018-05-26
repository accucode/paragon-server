package com.app.ui.page.crud.projectContact;

import com.app.model.MyProject;
import com.app.model.MyProjectContact;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyProjectContactFrame
    extends MyCrudFrame<MyProject,MyProjectContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactFrame()
    {
        this(new MyProjectContactBuilder());
    }

    public MyProjectContactFrame(MyProjectContactBuilder e)
    {
        super(e);
    }

}
