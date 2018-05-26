package com.app.ui.page.crud.customerSite;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;

import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard2;
import com.app.ui.page.crud.panels.MySiteEditPanel;

public class MyCustomerSiteEditCard
    extends MyCrudEditCard2<MySite>
{
    //##################################################
    //# variables
    //##################################################

    private MySiteEditPanel _panel;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteEditCard()
    {
        super(new MyCustomerSiteBuilder());
    }

    public MyCustomerSiteEditCard(MyCustomerSiteBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBody(ScDiv body)
    {
        body.add(createPanel());
    }

    private ScControl createPanel()
    {
        MySiteEditPanel e;
        e = new MySiteEditPanel();
        e.css().fill().auto();
        _panel = e;
        return e;
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
