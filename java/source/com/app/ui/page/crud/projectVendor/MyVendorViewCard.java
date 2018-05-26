package com.app.ui.page.crud.projectVendor;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyVendorViewCard
    extends MyCrudViewCard<MyVendor>
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendorViewCard()
    {
        super(new MyVendorBuilder());
    }

    public MyVendorViewCard(MyVendorBuilder e)
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
        ScDomainNotebook<MyVendor> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyVendor.Finder);
        e.add(createDetailTab());
        return e;
    }

    private ScControl createDetailTab()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        return e.inNotebookTab("Vendor", "Details");
    }

    private ScControl createGeneralSection()
    {
        MyMetaVendor x = MyVendor.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.Name);
        e.add(createEnabledRow());
        return e;
    }

    private ScDiv createEnabledRow()
    {
        MyMetaVendor x = MyVendor.Meta;

        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        e.setLabel("Enabled");
        e.addFieldText(x.EnabledStatus);
        e.addLink("toggle", newCheckedAction(this::handleToggleEnabled));
        return e;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleEnabled()
    {
        MyVendor e;
        e = getDomainChild();
        e.toggleEnabled();
        e.validateAndCheck();

        ajaxReplace();
        fireChildChanged();
    }
}
