package com.app.ui.page.guide;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.page.crud.blurb.MyBlurbListView;
import com.app.ui.page.crud.transfer.MyBlurbTransferView;

public class MyBlurbSetupGuidePage
    extends MyAbstractSetupGuidePage
{

    //##################################################
    //# singleton
    //##################################################

    private static MyBlurbSetupGuidePage _instance;

    public static void installInstance()
    {
        _instance = new MyBlurbSetupGuidePage();
    }

    public static MyBlurbSetupGuidePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "Blurb";
    }

    @Override
    protected ScPage getPreviousPage()
    {
        return MyEmailTemplateSetupGuidePage.getInstance();
    }

    @Override
    protected ScPage getNextPage()
    {
        return null;
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
                "Blurbs",
                "Blurbs are templates for documents.",
                ""
                    + "You can author blurbs which can be used to quickly generate documents "
                    + "and information about the various elements in your project. Information "
                    + "will be automatically filled in when you go to view the blurb when running "
                    + "tasks."));

        return e;
    }

    @Override
    protected ScControl createListCard()
    {
        MyBlurbListView e;
        e = new MyBlurbListView();
        e.css().flexChildFiller();
        return e;
    }

    @Override
    protected ScControl createTransferCard()
    {
        MyBlurbTransferView e;
        e = new MyBlurbTransferView();
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
