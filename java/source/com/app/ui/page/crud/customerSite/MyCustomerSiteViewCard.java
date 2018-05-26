package com.app.ui.page.crud.customerSite;

import com.kodemore.servlet.control.ScDiv;

import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.ui.page.crud.panels.MySiteViewPanel;

public class MyCustomerSiteViewCard
    extends MyCrudViewCard<MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteViewCard()
    {
        super(new MyCustomerSiteBuilder());
    }

    public MyCustomerSiteViewCard(MyCustomerSiteBuilder e)
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
        body.add(createPanel());
    }

    private MySiteViewPanel createPanel()
    {
        MySiteViewPanel e;
        e = new MySiteViewPanel();
        e.css().fill();
        return e;
    }
}
