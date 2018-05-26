package com.app.ui.page.crud.customerSite;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MySiteFinder;
import com.app.model.MyCustomer;
import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyCustomerSiteBuilder
    extends MyCrudBuilder<MyCustomer,MySite>
{
    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomer findParent(String uid)
    {
        return getAccess().findCustomerUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MySite.Meta;
    }

    @Override
    public MySiteFinder getChildFinder()
    {
        return MySite.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyCustomer getParentFor(MySite child)
    {
        return child.getCustomer();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCustomerSiteSearchView newSearchView()
    {
        return new MyCustomerSiteSearchView(this);
    }

    @Override
    public MyCrudFrame<MyCustomer,MySite> newFrame()
    {
        return new MyCustomerSiteFrame(this);
    }

    @Override
    public MyCrudViewCard<MySite> newViewCard()
    {
        return new MyCustomerSiteViewCard(this);
    }

    @Override
    public MyCrudEditCard<MySite> newEditCard()
    {
        return new MyCustomerSiteEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyCustomer,MySite> newAddCard()
    {
        return new MyCustomerSiteAddCard(this);
    }

    @Override
    public MyCrudListView<MyCustomer,MySite> newListView()
    {
        return new MyCustomerSiteListView(this);
    }

}
