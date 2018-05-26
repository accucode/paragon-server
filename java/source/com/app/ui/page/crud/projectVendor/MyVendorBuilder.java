package com.app.ui.page.crud.projectVendor;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyVendorFinder;
import com.app.model.MyProject;
import com.app.model.MyVendor;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyVendorBuilder
    extends MyCrudBuilder<MyProject,MyVendor>
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
        return MyVendor.Meta;
    }

    @Override
    public MyVendorFinder getChildFinder()
    {
        return MyVendor.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyVendor child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyProject,MyVendor> newFrame()
    {
        return new MyVendorFrame(this);
    }

    @Override
    public MyCrudViewCard<MyVendor> newViewCard()
    {
        return new MyVendorViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyVendor> newEditCard()
    {
        return new MyVendorEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyVendor> newAddCard()
    {
        return new MyVendorAddCard(this);
    }

    @Override
    public MyCrudListView<MyProject,MyVendor> newListView()
    {
        return new MyVendorListView(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyVendor> newSearchView()
    {
        return new MyVendorSearchView(this);
    }
}
