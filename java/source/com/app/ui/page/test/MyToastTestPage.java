package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

public class MyToastTestPage
    extends MyTestPage
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
    public ScParameterList composeLocalQueryParameters()
    {
        return null;
    }

    @Override
    public void applyLocalQueryParameters(ScParameterList v)
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

        ScGroupArray groups;
        groups = form.addGroupArray(150, 200);
        groups.style().floatLeft();

        ScGroup group;
        group = groups.addGroup("Toasts");

        ScBox links;
        links = group.addLinkBox();
        links.addLink("Default", newDefaultAction());
        links.addLink("Notice", newNoticeAction());
        links.addLink("Success", newSuccessAction());
        links.addLink("Warn", newWarnAction());
        links.addLink("Error", newErrorAction());

        group = groups.addGroup("Sticky");
        links = group.addLinkBox();
        links.addLink("Default", newDefaultStickyAction());
        links.addLink("Notice", newNoticeStickyAction());
        links.addLink("Success", newSuccessStickyAction());
        links.addLink("Warn", newWarnStickyAction());
        links.addLink("Error", newErrorStickyAction());

        group = groups.addGroup("Html");
        group.style().width(300);
        links = group.addLinkBox();
        links.addText("By default, toast messages are escaped.  However, you can easily set raw html if desired.");
        links.addBreak();
        links.addLink("Text (default)", newTextMessageAction());
        links.addLink("Html", newHtmlMessageAction());
    }

    private ScActionIF newDefaultAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDefault();
            }
        };
    }

    private ScActionIF newNoticeAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleNotice();
            }
        };
    }

    private ScActionIF newSuccessAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSuccess();
            }
        };
    }

    private ScActionIF newWarnAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleWarn();
            }
        };
    }

    private ScActionIF newErrorAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleError();
            }
        };
    }

    private ScActionIF newDefaultStickyAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDefaultSticky();
            }
        };
    }

    private ScActionIF newNoticeStickyAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleNoticeSticky();
            }
        };
    }

    private ScActionIF newSuccessStickyAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSuccessSticky();
            }
        };
    }

    private ScActionIF newWarnStickyAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleWarnSticky();
            }
        };
    }

    private ScActionIF newErrorStickyAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleErrorSticky();
            }
        };
    }

    private ScActionIF newTextMessageAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTextMessage();
            }
        };
    }

    private ScActionIF newHtmlMessageAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleHtmlMessage();
            }
        };
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
