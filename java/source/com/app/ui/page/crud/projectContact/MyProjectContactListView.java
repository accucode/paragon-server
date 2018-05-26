package com.app.ui.page.crud.projectContact;

import com.app.model.MyProject;
import com.app.model.MyProjectContact;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyProjectContactListView
    extends MyCrudListView<MyProject,MyProjectContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactListView()
    {
        this(new MyProjectContactBuilder());
    }

    public MyProjectContactListView(MyProjectContactBuilder e)
    {
        super(e);
    }
}
