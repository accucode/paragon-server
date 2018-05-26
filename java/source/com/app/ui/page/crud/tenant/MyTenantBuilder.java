package com.app.ui.page.crud.tenant;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyTenantFinder;
import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyTenantBuilder
    extends MyCrudBuilder<MyNullDomain,MyTenant>
{
    //##################################################
    //# find
    //##################################################

    @Override
    public MyNullDomain findParent(String uid)
    {
        return null;
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MyTenant.Meta;
    }

    @Override
    public MyTenantFinder getChildFinder()
    {
        return MyTenant.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyNullDomain getParentFor(MyTenant child)
    {
        return null;
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyTenantSearchView newSearchView()
    {
        return new MyTenantSearchView(this);
    }

    @Override
    public MyCrudListView<MyNullDomain,MyTenant> newListView()
    {
        return new MyTenantListView(this);
    }

    @Override
    public MyCrudFrame<MyNullDomain,MyTenant> newFrame()
    {
        return new MyTenantFrame(this);
    }

    @Override
    public MyCrudViewCard<MyTenant> newViewCard()
    {
        return new MyTenantViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyTenant> newEditCard()
    {
        return new MyTenantEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyNullDomain,MyTenant> newAddCard()
    {
        return new MyTenantAddCard(this);
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    protected boolean allowsNullParent()
    {
        return true;
    }

}
