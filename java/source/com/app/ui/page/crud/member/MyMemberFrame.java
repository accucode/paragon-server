package com.app.ui.page.crud.member;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyMemberFrame
    extends MyCrudFrame<MyProject,MyMember>
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberFrame()
    {
        this(new MyMemberBuilder());
    }

    public MyMemberFrame(MyMemberBuilder e)
    {
        super(e);
    }

}
