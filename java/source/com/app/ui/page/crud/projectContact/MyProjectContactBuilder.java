package com.app.ui.page.crud.projectContact;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyProjectContactFinder;
import com.app.model.MyProject;
import com.app.model.MyProjectContact;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyProjectContactBuilder
    extends MyCrudBuilder<MyProject,MyProjectContact>
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
        return MyProjectContact.Meta;
    }

    @Override
    public MyProjectContactFinder getChildFinder()
    {
        return MyProjectContact.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyProjectContact child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyProjectContactSearchView newSearchView()
    {
        return new MyProjectContactSearchView(this);
    }

    @Override
    public MyCrudFrame<MyProject,MyProjectContact> newFrame()
    {
        return new MyProjectContactFrame(this);
    }

    @Override
    public MyCrudViewCard<MyProjectContact> newViewCard()
    {
        return new MyProjectContactViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyProjectContact> newEditCard()
    {
        return new MyProjectContactEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyProjectContact> newAddCard()
    {
        return new MyProjectContactAddCard(this);
    }

    @Override
    public MyCrudListView<MyProject,MyProjectContact> newListView()
    {
        return new MyProjectContactListView(this);
    }

}
