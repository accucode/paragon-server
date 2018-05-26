package com.app.ui.page.crud.site;

import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MySiteFrame
    extends MyCrudFrame<MyProject,MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteFrame()
    {
        this(new MySiteBuilder());
    }

    public MySiteFrame(MySiteBuilder e)
    {
        super(e);
    }

}
