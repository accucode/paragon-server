package com.app.ui.page.crud.customerContact;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyCustomerContactFinder;
import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyCustomerContactBuilder
    extends MyCrudBuilder<MyCustomer,MyCustomerContact>
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
        return MyCustomerContact.Meta;
    }

    @Override
    public MyCustomerContactFinder getChildFinder()
    {
        return MyCustomerContact.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyCustomer getParentFor(MyCustomerContact child)
    {
        return child.getCustomer();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCustomerContactSearchView newSearchView()
    {
        return new MyCustomerContactSearchView(this);
    }

    @Override
    public MyCrudFrame<MyCustomer,MyCustomerContact> newFrame()
    {
        return new MyCustomerContactFrame(this);
    }

    @Override
    public MyCrudViewCard<MyCustomerContact> newViewCard()
    {
        return new MyCustomerContactViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyCustomerContact> newEditCard()
    {
        return new MyCustomerContactEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyCustomer,MyCustomerContact> newAddCard()
    {
        return new MyCustomerContactAddCard(this);
    }

    @Override
    public MyCrudListView<MyCustomer,MyCustomerContact> newListView()
    {
        return new MyCustomerContactListView(this);
    }

}
