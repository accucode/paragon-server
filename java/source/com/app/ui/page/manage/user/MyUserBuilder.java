package com.app.ui.page.manage.user;

import java.util.function.Function;
import java.util.function.Predicate;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaModel;

import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.manage.crud.MyCrudAddCard;
import com.app.ui.page.manage.crud.MyCrudBuilder;
import com.app.ui.page.manage.crud.MyCrudEditCard;
import com.app.ui.page.manage.crud.MyCrudFrame;
import com.app.ui.page.manage.crud.MyCrudManageView;
import com.app.ui.page.manage.crud.MyCrudViewCard;

public class MyUserBuilder
    extends MyCrudBuilder<MyTenant,MyUser>
{
    //##################################################
    //# parent
    //##################################################

    @Override
    public MyTenant findParent(String uid)
    {
        return getAccess().findTenantUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MyUser.Meta;
    }

    @Override
    public Function<MyUser,String> getChildTitleFunction()
    {
        return MyUser.Meta.FullName;
    }

    @Override
    public Function<MyUser,String> getChildSubtitleFunction()
    {
        return MyUser.Meta.Email;
    }

    @Override
    public MyUser findChild(String uid)
    {
        return getAccess().findUserUid(uid);
    }

    @Override
    public Predicate<MyUser> getChildActive()
    {
        return MyUser.Meta.Active;
    }

    //##################################################
    //# parent / child
    //##################################################

    @Override
    public MyTenant getParentFor(MyUser child)
    {
        return child.getTenant();
    }

    @Override
    public KmList<MyUser> getChildrenFor(MyTenant tenant)
    {
        return tenant.getUsersByFullName();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyTenant,MyUser> newFrame()
    {
        return new MyUserFrame(this);
    }

    @Override
    public MyCrudViewCard<MyUser> newViewCard()
    {
        return new MyUserViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyUser> newEditCard()
    {
        return new MyUserEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyTenant,MyUser> newAddCard()
    {
        return new MyUserAddCard(this);
    }

    @Override
    public MyCrudManageView<MyTenant,MyUser> newManageView()
    {
        return new MyUserManageView(this);
    }

    //##################################################
    //# allows
    //##################################################

    @Override
    protected boolean allowsEditFor(MyUser e)
    {
        return e.isRoleDeveloper()
            ? getGlobals().getCurrentUser().allowsManageDevelopers()
            : super.allowsEditFor(e);
    }
}
