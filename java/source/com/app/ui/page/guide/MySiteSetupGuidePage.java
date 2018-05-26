package com.app.ui.page.guide;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.page.crud.site.MySiteListView;
import com.app.ui.page.crud.transfer.MySiteTransferView;
import com.app.ui.page.importer.MySiteImporterView;

public class MySiteSetupGuidePage
    extends MyAbstractSetupGuidePage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySiteSetupGuidePage _instance;

    public static void installInstance()
    {
        _instance = new MySiteSetupGuidePage();
    }

    public static MySiteSetupGuidePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "Site";
    }

    @Override
    protected ScPage getPreviousPage()
    {
        return MyCustomerSetupGuidePage.getInstance();
    }

    @Override
    protected ScPage getNextPage()
    {
        return MyEmailTemplateSetupGuidePage.getInstance();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installInstructionsOn(ScDiv body)
    {
        body.add(newInfoSection());
        body.add(newListSection(false));
        body.add(newTransferSection(false));
        body.add(newImportSection(true));
    }

    @Override
    protected ScControl createInfoCard()
    {
        ScGroup e;
        e = new ScGroup();
        e.css().flexChildFiller();
        e.setFlavorSummary();
        e.setTitle("Info");

        ScDiv body;
        body = e.getBody();
        body.css().gap20().auto();

        body.add(
            new MySetupInfoItem(
                "Sites",
                "Sites are the customer locations where you are going to do work for this project.",
                "Site info..."));
        return e;
    }

    @Override
    protected ScControl createListCard()
    {
        MySiteListView e;
        e = new MySiteListView();
        e.css().flexChildFiller();
        return e;
    }

    @Override
    protected ScControl createTransferCard()
    {
        MySiteTransferView e;
        e = new MySiteTransferView();
        e.css().flexChildFiller();

        ScForm form;
        form = new ScForm();
        form.css().flexColumn().flexChildFiller();
        form.add(e);
        return form;
    }

    @Override
    protected ScControl createImportCard()
    {
        MySiteImporterView e;
        e = new MySiteImporterView();
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        getListCard().applyFromModel(getCurrentProject());
    }
}
