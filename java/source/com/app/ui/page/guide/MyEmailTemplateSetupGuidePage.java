package com.app.ui.page.guide;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.page.crud.emailTemplate.MyEmailTemplateListView;
import com.app.ui.page.crud.transfer.MyEmailTemplateTransferView;

public class MyEmailTemplateSetupGuidePage
    extends MyAbstractSetupGuidePage
{

    //##################################################
    //# singleton
    //##################################################

    private static MyEmailTemplateSetupGuidePage _instance;

    public static void installInstance()
    {
        _instance = new MyEmailTemplateSetupGuidePage();
    }

    public static MyEmailTemplateSetupGuidePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "Email Template";
    }

    @Override
    protected ScPage getPreviousPage()
    {
        return MySiteSetupGuidePage.getInstance();
    }

    @Override
    protected ScPage getNextPage()
    {
        return MyBlurbSetupGuidePage.getInstance();
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
                "Email Templates",
                "Set up templates for emails to be sent from your project.",
                "..."));

        return e;
    }

    @Override
    protected ScControl createListCard()
    {
        MyEmailTemplateListView e;
        e = new MyEmailTemplateListView();
        e.css().flexChildFiller();
        return e;
    }

    @Override
    protected ScControl createTransferCard()
    {
        MyEmailTemplateTransferView e;
        e = new MyEmailTemplateTransferView();
        e.css().flexChildFiller();

        ScForm form;
        form = new ScForm();
        form.css().flexColumn().flexChildFiller();
        form.add(e);
        return form;
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
