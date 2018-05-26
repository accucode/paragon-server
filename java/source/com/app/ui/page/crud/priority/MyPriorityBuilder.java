package com.app.ui.page.crud.priority;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyPriorityFinder;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyPriorityBuilder
    extends MyCrudBuilder<MyProject,MyPriority>
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
        return MyPriority.Meta;
    }

    @Override
    public MyPriorityFinder getChildFinder()
    {
        return MyPriority.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyPriority child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyProject,MyPriority> newFrame()
    {
        return new MyPriorityFrame(this);
    }

    @Override
    public MyCrudViewCard<MyPriority> newViewCard()
    {
        return new MyPriorityViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyPriority> newEditCard()
    {
        return new MyPriorityEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyPriority> newAddCard()
    {
        return new MyPriorityAddCard(this);
    }

    @Override
    public MyCrudListView<MyProject,MyPriority> newListView()
    {
        return new MyPriorityListView(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyPriority> newSearchView()
    {
        return new MyPrioritySearchView(this);
    }
}
