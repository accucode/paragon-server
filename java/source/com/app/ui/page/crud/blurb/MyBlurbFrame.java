package com.app.ui.page.crud.blurb;

import com.app.model.MyBlurb;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyBlurbFrame
    extends MyCrudFrame<MyProject,MyBlurb>
{
    //##################################################
    //# constructor
    //##################################################

    public MyBlurbFrame()
    {
        this(new MyBlurbBuilder());
    }

    public MyBlurbFrame(MyBlurbBuilder e)
    {
        super(e);
    }
}
