package com.app.ui.page.crud.siteContact;

import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MySiteContactFrame
    extends MyCrudFrame<MySite,MySiteContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteContactFrame()
    {
        this(new MySiteContactBuilder());
    }

    public MySiteContactFrame(MySiteContactBuilder e)
    {
        super(e);
    }

}
