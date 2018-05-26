package com.app.ui.page.crud.member;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyMemberFinder;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyMemberBuilder
    extends MyCrudBuilder<MyProject,MyMember>
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
        return MyMember.Meta;
    }

    @Override
    public MyMemberFinder getChildFinder()
    {
        return MyMember.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyMember child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyProject,MyMember> newFrame()
    {
        return new MyMemberFrame(this);
    }

    @Override
    public MyCrudViewCard<MyMember> newViewCard()
    {
        return new MyMemberViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyMember> newEditCard()
    {
        return new MyMemberEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyMember> newAddCard()
    {
        return new MyMemberAddCard(this);
    }

    @Override
    public MyCrudListView<MyProject,MyMember> newListView()
    {
        return new MyMemberListView(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyMember> newSearchView()
    {
        return new MyMemberSearchView(this);
    }

}
