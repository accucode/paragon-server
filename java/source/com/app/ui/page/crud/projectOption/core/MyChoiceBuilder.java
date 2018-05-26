package com.app.ui.page.crud.projectOption.core;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyChoiceFinder;
import com.app.model.MyProject;
import com.app.model.MyChoice;
import com.app.model.base.MyChoiceType;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public abstract class MyChoiceBuilder
    extends MyCrudBuilder<MyProject,MyChoice>
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
        return MyChoice.Meta;
    }

    @Override
    public MyChoiceFinder getChildFinder()
    {
        return MyChoice.Finder;
    }

    @Override
    public String getChildLabel()
    {
        return getType().getLabel();
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyChoice e)
    {
        return e.getProject();
    }

    //##################################################
    //# topic
    //##################################################

    public abstract MyChoiceType getType();

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyProject,MyChoice> newFrame()
    {
        return new MyChoiceFrame(this);
    }

    @Override
    public MyCrudViewCard<MyChoice> newViewCard()
    {
        return new MyChoiceViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyChoice> newEditCard()
    {
        return new MyChoiceEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyChoice> newAddCard()
    {
        return new MyChoiceAddCard(this);
    }

    @Override
    public MyCrudListView<MyProject,MyChoice> newListView()
    {
        return new MyChoiceListView(this);
    }

    @Override
    public MyChoiceListView getListView()
    {
        return (MyChoiceListView)super.getListView();
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyChoice> newSearchView()
    {
        return new MyChoiceSearchView(this);
    }
}
