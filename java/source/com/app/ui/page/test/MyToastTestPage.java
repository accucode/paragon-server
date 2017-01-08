package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyToastTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyToastTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyToastTestPage();
    }

    public static MyToastTestPage getInstance()
    {
        return _instance;
    }

    private MyToastTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.css().columnSpacer10();

        ScDiv body;
        body = form.addGroup("Toasts").getBody();
        body.css().pad().flexRow().rowSpacer5();
        body.addLink("Default", this::handleDefault);
        body.addLink("Notice", this::handleNotice);
        body.addLink("Success", this::handleSuccess);
        body.addLink("Warn", this::handleWarn);
        body.addLink("Error", this::handleError);

        body = form.addGroup("Sticky").getBody();
        body.css().pad().flexRow().rowSpacer5();
        body.addLink("Default", this::handleDefaultSticky);
        body.addLink("Notice", this::handleNoticeSticky);
        body.addLink("Success", this::handleSuccessSticky);
        body.addLink("Warn", this::handleWarnSticky);
        body.addLink("Error", this::handleErrorSticky);

        body = form.addGroup("Html").getBody();
        body.css().pad().flexColumn();
        body.addTextSpan("By default, toast messages are escaped.");
        body.addTextSpan("You also set raw html if desired.");
        body.addFlexGap(10);

        ScDiv row;
        row = body.addFlexRow();
        row.css().rowSpacer5();
        row.addLink("Text (default)", this::handleTextMessage);
        row.addLink("Html", this::handleHtmlMessage);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
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
