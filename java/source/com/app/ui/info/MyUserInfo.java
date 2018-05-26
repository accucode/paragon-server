package com.app.ui.info;

import com.app.model.MyUser;
import com.app.ui.page.crud.user.MyUserListPage;

public class MyUserInfo
    extends MyDomainInfo<MyUser>
{
    //##################################################
    //# text
    //##################################################

    @Override
    protected String getLabelFor(MyUser e)
    {
        return "User";
    }

    @Override
    protected String getNameFor(MyUser e)
    {
        return e.getFullName();
    }

    @Override
    protected String getHelpFor(MyUser e)
    {
        return null;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MyUser findTargetFor(String uid)
    {
        return getAccess().findUserUid(uid);
    }

    //##################################################
    //# open
    //##################################################

    @Override
    protected void openLinkFor(MyUser e)
    {
        MyUserListPage.getInstance().ajaxEnterChild(e);
    }

    @Override
    protected String formatPopoutUrlFor(MyUser e)
    {
        return MyUserListPage.getInstance().formatEntryUrlFor(e);
    }

}
