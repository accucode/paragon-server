package com.app.ui.page.crud.site;

import com.kodemore.servlet.control.ScDiv;

import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.ui.page.crud.panels.MySiteViewPanel;

public class MySiteViewCard
    extends MyCrudViewCard<MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteViewCard()
    {
        super(new MySiteBuilder());
    }

    public MySiteViewCard(MySiteBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        detachBody();
        body.add(newPanel());
    }

    private MySiteViewPanel newPanel()
    {
        MySiteViewPanel e;
        e = new MySiteViewPanel();
        e.css().fill();
        e.onChildChanged(this::fireChildChanged);
        e.onChildListChanged(this::fireChildListChanged);
        return e;
    }

}
