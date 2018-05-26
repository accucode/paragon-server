package com.app.ui.page.crud.siteContact;

import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MySiteContactListView
    extends MyCrudListView<MySite,MySiteContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteContactListView()
    {
        this(new MySiteContactBuilder());
    }

    public MySiteContactListView(MySiteContactBuilder e)
    {
        super(e);
    }
}
