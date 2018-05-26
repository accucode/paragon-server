package com.app.ui.page.crud.projectOption.core;

import com.app.model.MyProject;
import com.app.model.MyChoice;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyChoiceListView
    extends MyCrudListView<MyProject,MyChoice>
{
    //##################################################
    //# constructor
    //##################################################

    public MyChoiceListView(MyChoiceBuilder e)
    {
        super(e);
    }
}
