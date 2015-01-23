package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

public class MyToastTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyToastTestPage instance = new MyToastTestPage();

    private MyToastTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();
        form.css().gap();

        ScGroup group;
        group = form.addGroup("Toasts");

        ScBox links;
        links = group.getBody().addLinkBox();
        links.addLink("Default", this::handleDefault);
        links.addLink("Notice", this::handleNotice);
        links.addLink("Success", this::handleSuccess);
        links.addLink("Warn", this::handleWarn);
        links.addLink("Error", this::handleError);

        group = form.addGroup("Sticky");
        links = group.getBody().addLinkBox();
        links.addLink("Default", this::handleDefaultSticky);
        links.addLink("Notice", this::handleNoticeSticky);
        links.addLink("Success", this::handleSuccessSticky);
        links.addLink("Warn", this::handleWarnSticky);
        links.addLink("Error", this::handleErrorSticky);

        group = form.addGroup("Html");
        group.style().width(300);
        links = group.getBody().addLinkBox();
        links.addText(""
            + "By default, toast messages are escaped.  "
            + "However, you can easily set raw html if desired.");
        links.addBreak();
        links.addLink("Text (default)", this::handleTextMessage);
        links.addLink("Html", this::handleHtmlMessage);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleDefault()
    {
        ajax().toast("toast(...)");
    }

    private void handleNotice()
    {
        ajax().toast("toast(...).notice()").notice();
    }

    private void handleSuccess()
    {
        ajax().toast("toast(...).success()").success();
    }

    private void handleWarn()
    {
        ajax().toast("toast(...).warn()").warn();
    }

    private void handleError()
    {
        ajax().toast("toast(...).error()").error();
    }

    private void handleDefaultSticky()
    {
        ajax().toast("toast(...).sticky()").sticky();
    }

    private void handleNoticeSticky()
    {
        ajax().toast("toast(...).notice().sticky()").notice().sticky();
    }

    private void handleSuccessSticky()
    {
        ajax().toast("toast(...).success.sticky()").success().sticky();
    }

    private void handleWarnSticky()
    {
        ajax().toast("toast(...).warn().sticky()").warn().sticky();
    }

    private void handleErrorSticky()
    {
        ajax().toast("toast(...).error().sticky()").error().sticky();
    }

    private void handleTextMessage()
    {
        ajax().toast("<span style='font-size:36px'>text</span>").sticky();
    }

    private void handleHtmlMessage()
    {
        ajax().toast().sticky().setHtml("<span style='font-size:36px'>html</span>");
    }
}
