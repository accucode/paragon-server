package com.app.ui.page.manage.user;

import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.manage.crud.MyCrudManageView;

public final class MyUserManageView
    extends MyCrudManageView<MyTenant,MyUser>
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserManageView()
    {
        this(new MyUserBuilder());
    }

    public MyUserManageView(MyUserBuilder e)
    {
        super(e);
    }
}
