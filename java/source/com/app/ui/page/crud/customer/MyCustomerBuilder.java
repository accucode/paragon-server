package com.app.ui.page.crud.customer;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyCustomerFinder;
import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyCustomerBuilder
    extends MyCrudBuilder<MyProject,MyCustomer>
{
    //##################################################
    //# find
    //##################################################

    @Override
    public MyProject findParent(String uid)
    {
        return getAccess().findProjectUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MyCustomer.Meta;
    }

    @Override
    public MyCustomerFinder getChildFinder()
    {
        return MyCustomer.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyCustomer child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyProject,MyCustomer> newFrame()
    {
        return new MyCustomerFrame(this);
    }

    @Override
    public MyCrudViewCard<MyCustomer> newViewCard()
    {
        return new MyCustomerViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyCustomer> newEditCard()
    {
        return new MyCustomerEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyCustomer> newAddCard()
    {
        return new MyCustomerAddCard(this);
    }

    @Override
    public MyCrudListView<MyProject,MyCustomer> newListView()
    {
        return new MyCustomerListView(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyCustomer> newSearchView()
    {
        return new MyCustomerSearchView(this);
    }
}
