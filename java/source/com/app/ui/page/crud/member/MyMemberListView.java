package com.app.ui.page.crud.member;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyMemberListView
    extends MyCrudListView<MyProject,MyMember>
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberListView()
    {
        this(new MyMemberBuilder());
    }

    public MyMemberListView(MyMemberBuilder e)
    {
        super(e);
    }
}
