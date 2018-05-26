package com.app.ui.page.crud.blurb;

import com.app.model.MyBlurb;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyBlurbListView
    extends MyCrudListView<MyProject,MyBlurb>
{
    //##################################################
    //# constructor
    //##################################################

    public MyBlurbListView()
    {
        this(new MyBlurbBuilder());
    }

    public MyBlurbListView(MyBlurbBuilder e)
    {
        super(e);
    }
}
