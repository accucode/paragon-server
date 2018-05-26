package com.app.ui.page.crud.user;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyUserFinder;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyUserBuilder
    extends MyCrudBuilder<MyTenant,MyUser>
{
    //##################################################
    //# find
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
    public MyUserFinder getChildFinder()
    {
        return MyUser.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyTenant getParentFor(MyUser child)
    {
        return child.getTenant();
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
    public MyCrudListView<MyTenant,MyUser> newListView()
    {
        return new MyUserListView(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyTenant,MyUser> newSearchView()
    {
        return new MyUserSearchView(this);
    }

    //##################################################
    //# allows
    //##################################################

    @Override
    protected boolean showsEditFor(MyUser e)
    {
        return e.isRoleDeveloper()
            ? getGlobals().getCurrentUser().allowsManageDevelopers()
            : super.showsEditFor(e);
    }
}
