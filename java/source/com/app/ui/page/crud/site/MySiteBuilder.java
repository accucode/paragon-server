package com.app.ui.page.crud.site;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MySiteFinder;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MySiteBuilder
    extends MyCrudBuilder<MyProject,MySite>
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
    public MyProject getParentFor(MySite child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyProject,MySite> newFrame()
    {
        return new MySiteFrame(this);
    }

    @Override
    public MyCrudViewCard<MySite> newViewCard()
    {
        return new MySiteViewCard(this);
    }

    @Override
    public MyCrudEditCard<MySite> newEditCard()
    {
        return new MySiteEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MySite> newAddCard()
    {
        return new MySiteAddCard(this);
    }

    @Override
    public MyCrudListView<MyProject,MySite> newListView()
    {
        return new MySiteListView(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MySite> newSearchView()
    {
        return new MySiteSearchView(this);
    }
}
