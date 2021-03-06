package com.app.ui.page.crud.user;

import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyUserFrame
    extends MyCrudFrame<MyTenant,MyUser>
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserFrame()
    {
        this(new MyUserBuilder());
    }

    public MyUserFrame(MyUserBuilder e)
    {
        super(e);
    }

}
