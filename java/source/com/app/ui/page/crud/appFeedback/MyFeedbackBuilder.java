package com.app.ui.page.crud.appFeedback;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyFeedbackFinder;
import com.app.model.MyFeedback;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyFeedbackBuilder
    extends MyCrudBuilder<MyNullDomain,MyFeedback>
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
        return MyFeedback.Meta;
    }

    @Override
    public MyFeedbackFinder getChildFinder()
    {
        return MyFeedback.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyNullDomain getParentFor(MyFeedback child)
    {
        return null;
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyFeedbackSearchView newSearchView()
    {
        return new MyFeedbackSearchView(this);
    }

    @Override
    public MyCrudListView<MyNullDomain,MyFeedback> newListView()
    {
        return new MyFeedbackListView(this);
    }

    @Override
    public MyCrudFrame<MyNullDomain,MyFeedback> newFrame()
    {
        return new MyFeedbackFrame(this);
    }

    @Override
    public MyCrudViewCard<MyFeedback> newViewCard()
    {
        return new MyFeedbackViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyFeedback> newEditCard()
    {
        return new MyFeedbackEditCard();
    }

    @Override
    public MyCrudAddCard<MyNullDomain,MyFeedback> newAddCard()
    {
        return null;
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
