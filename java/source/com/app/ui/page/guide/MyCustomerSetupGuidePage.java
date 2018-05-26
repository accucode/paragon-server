package com.app.ui.page.guide;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.page.crud.customer.MyCustomerListView;
import com.app.ui.page.crud.transfer.MyCustomerTransferView;
import com.app.ui.page.importer.MyCustomerImporterView;

public class MyCustomerSetupGuidePage
    extends MyAbstractSetupGuidePage
{

    //##################################################
    //# singleton
    //##################################################

    private static MyCustomerSetupGuidePage _instance;

    public static void installInstance()
    {
        _instance = new MyCustomerSetupGuidePage();
    }

    public static MyCustomerSetupGuidePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "Customer";
    }

    @Override
    protected ScPage getPreviousPage()
    {
        return MyMemberSetupGuidePage.getInstance();
    }

    @Override
    protected ScPage getNextPage()
    {
        return MySiteSetupGuidePage.getInstance();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installInstructionsOn(ScDiv body)
    {
        body.add(newInfoSection());
        body.add(newListSection(false));
        body.add(newTransferSection(true));
        body.add(newImportSection(false));
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
                "Customers",
                "Customers are the people or organizations you are going to do work for.",
                "Customer info..."));
        return e;
    }

    @Override
    protected ScControl createListCard()
    {
        MyCustomerListView e;
        e = new MyCustomerListView();
        e.css().flexChildFiller();
        return e;
    }

    @Override
    protected ScControl createTransferCard()
    {
        MyCustomerTransferView e;
        e = new MyCustomerTransferView();
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
        MyCustomerImporterView e;
        e = new MyCustomerImporterView();
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
