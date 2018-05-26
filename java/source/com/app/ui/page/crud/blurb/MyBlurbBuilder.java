package com.app.ui.page.crud.blurb;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyBlurbFinder;
import com.app.model.MyBlurb;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyBlurbBuilder
    extends MyCrudBuilder<MyProject,MyBlurb>
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
        return MyBlurb.Meta;
    }

    @Override
    public MyBlurbFinder getChildFinder()
    {
        return MyBlurb.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyBlurb child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudListView<MyProject,MyBlurb> newListView()
    {
        return new MyBlurbListView(this);
    }

    @Override
    public MyCrudFrame<MyProject,MyBlurb> newFrame()
    {
        return new MyBlurbFrame(this);
    }

    @Override
    public MyCrudViewCard<MyBlurb> newViewCard()
    {
        return new MyBlurbViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyBlurb> newEditCard()
    {
        return new MyBlurbEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyBlurb> newAddCard()
    {
        return new MyBlurbAddCard(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyBlurb> newSearchView()
    {
        return new MyBlurbSearchView(this);
    }
}
