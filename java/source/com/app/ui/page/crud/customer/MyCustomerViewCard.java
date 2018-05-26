package com.app.ui.page.crud.customer;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyCustomer;
import com.app.model.meta.MyMetaCustomer;
import com.app.ui.control.MyNotesView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.ui.page.crud.customerContact.MyCustomerContactListView;
import com.app.ui.page.crud.customerSite.MyCustomerSiteListView;

public class MyCustomerViewCard
    extends MyCrudViewCard<MyCustomer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerViewCard()
    {
        super(new MyCustomerBuilder());
    }

    public MyCustomerViewCard(MyCustomerBuilder e)
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
        body.add(createNotebook());
    }

    private ScControl createNotebook()
    {
        ScDomainNotebook<MyCustomer> e;
        e = new ScDomainNotebook<>();
        e.setFinder(MyCustomer.Finder);
        e.css().fill();
        e.add(createDetailsTab());
        e.add(createContactsTab());
        e.add(createSitesTab());
        e.add(createNotesTab());
        return e;
    }

    //==================================================
    //= install :: details tab
    //==================================================

    private ScGroup createDetailsTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setLabel("Details");
        e.setTitle("Customer Details");
        e.setFlavorDetail();
        e.css().fill();
        e.getBody().add(createDetailsLayout());
        return e;
    }

    private ScControl createDetailsLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createNameSection());
        e.add(createBillingAddressSection());
        return e;
    }

    private ScControl createNameSection()
    {
        MyMetaCustomer x = MyCustomer.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Name");
        e.addFieldText(x.Name);
        e.add(createEnabledRow());
        return e;
    }

    private ScControl createEnabledRow()
    {
        MyMetaCustomer x = MyCustomer.Meta;

        ScDiv row;
        row = new ScDiv();
        row.setLabel("Enabled");
        row.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        row.addFieldText(x.EnabledStatus);
        row.addLink("toggle", newCheckedAction(this::handleToggleEnabled));
        return row;
    }

    private ScControl createBillingAddressSection()
    {
        MyMetaCustomer x = MyCustomer.Meta;

        ScFieldText e;
        e = x.BillingAddressMultiLine.newFieldText();
        e.setLabel("Billing Address");
        return e;
    }

    //==================================================
    //= notebook :: other tabs
    //==================================================

    private ScControl createContactsTab()
    {
        MyCustomerContactListView e;
        e = new MyCustomerContactListView();
        e.setLabel("Contacts");
        e.css().fill();
        return e;
    }

    private ScControl createSitesTab()
    {
        MyCustomerSiteListView e;
        e = new MyCustomerSiteListView();
        e.setLabel("Sites");
        e.css().fill();
        return e;
    }

    private ScControl createNotesTab()
    {
        MyNotesView e;
        e = new MyNotesView();
        e.css().fill();
        return e;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleEnabled()
    {
        MyCustomer e;
        e = getDomainChild();
        e.toggleEnabled();
        e.validateAndCheck();

        ajaxReplace();
        fireChildChanged();
    }

}
