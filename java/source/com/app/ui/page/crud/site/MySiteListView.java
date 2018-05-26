package com.app.ui.page.crud.site;

import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MySiteListView
    extends MyCrudListView<MyProject,MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteListView()
    {
        this(new MySiteBuilder());
    }

    public MySiteListView(MySiteBuilder e)
    {
        super(e);
    }
}
