package com.app.ui.page.crud.user;

import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyUserListView
    extends MyCrudListView<MyTenant,MyUser>
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserListView()
    {
        this(new MyUserBuilder());
    }

    public MyUserListView(MyUserBuilder e)
    {
        super(e);
    }
}
