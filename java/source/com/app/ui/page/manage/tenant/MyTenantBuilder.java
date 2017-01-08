package com.app.ui.page.manage.tenant;

import java.util.function.Function;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaModel;

import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.manage.crud.MyCrudAddCard;
import com.app.ui.page.manage.crud.MyCrudBuilder;
import com.app.ui.page.manage.crud.MyCrudEditCard;
import com.app.ui.page.manage.crud.MyCrudFrame;
import com.app.ui.page.manage.crud.MyCrudManageView;
import com.app.ui.page.manage.crud.MyCrudViewCard;

public class MyTenantBuilder
    extends MyCrudBuilder<MyNullDomain,MyTenant>
{
    //##################################################
    //# parent
    //##################################################

    @Override
    public MyNullDomain findParent(String uid)
    {
        return null;
    }

    @Override
    protected boolean allowsNullParent()
    {
        return true;
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
    public Function<MyTenant,String> getChildTitleFunction()
    {
        return MyTenant.Meta.Name;
    }

    @Override
    public Function<MyTenant,String> getChildSubtitleFunction()
    {
        return null;
    }

    @Override
    public MyTenant findChild(String uid)
    {
        return getAccess().findTenantUid(uid);
    }

    //##################################################
    //# parent / child
    //##################################################

    @Override
    public MyNullDomain getParentFor(MyTenant child)
    {
        return null;
    }

    @Override
    public KmList<MyTenant> getChildrenFor(MyNullDomain ignored)
    {
        KmList<MyTenant> v;
        v = getAccess().getTenantDao().findAll();
        v.sortOn(e -> e.getName());
        return v;
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudManageView<MyNullDomain,MyTenant> newManageView()
    {
        return new MyTenantManageView(this);
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
}
