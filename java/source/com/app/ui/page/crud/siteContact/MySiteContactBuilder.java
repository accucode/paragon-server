package com.app.ui.page.crud.siteContact;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MySiteContactFinder;
import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MySiteContactBuilder
    extends MyCrudBuilder<MySite,MySiteContact>
{
    //##################################################
    //# find
    //##################################################

    @Override
    public MySite findParent(String uid)
    {
        return getAccess().findSiteUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MySiteContact.Meta;
    }

    @Override
    public MySiteContactFinder getChildFinder()
    {
        return MySiteContact.Finder;
    }

    @Override
    public String getChildLabel()
    {
        return "Contact";
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MySite getParentFor(MySiteContact child)
    {
        return child.getSite();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MySiteContactSearchView newSearchView()
    {
        return new MySiteContactSearchView(this);
    }

    @Override
    public MyCrudFrame<MySite,MySiteContact> newFrame()
    {
        return new MySiteContactFrame(this);
    }

    @Override
    public MyCrudViewCard<MySiteContact> newViewCard()
    {
        return new MySiteContactViewCard(this);
    }

    @Override
    public MyCrudEditCard<MySiteContact> newEditCard()
    {
        return new MySiteContactEditCard(this);
    }

    @Override
    public MyCrudAddCard<MySite,MySiteContact> newAddCard()
    {
        return new MySiteContactAddCard(this);
    }

    @Override
    public MyCrudListView<MySite,MySiteContact> newListView()
    {
        return new MySiteContactListView(this);
    }
}
