package com.app.ui.page.crud.site;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;

import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard2;
import com.app.ui.page.crud.panels.MySiteEditPanel;

public class MySiteEditCard
    extends MyCrudEditCard2<MySite>
{
    //##################################################
    //# variables
    //##################################################

    private MySiteEditPanel _panel;

    //##################################################
    //# constructor
    //##################################################

    public MySiteEditCard()
    {
        super(new MySiteBuilder());
    }

    public MySiteEditCard(MySiteBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBody(ScDiv body)
    {
        body.add(newPanel());
    }

    private ScControl newPanel()
    {
        MySiteEditPanel e;
        e = new MySiteEditPanel();
        e.css().fill().auto();
        _panel = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MySite site)
    {
        _panel.applyFromModel(site);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MySite e)
    {
        _panel.saveDomainChild(e);
    }
}
