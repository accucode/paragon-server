package com.app.ui.layout;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScParagraph;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.utility.Kmu;

import com.app.ui.control.MyFormDialog;

public class MyPageErrorDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScTransientContainer _message;

    //##################################################
    //# constructor
    //##################################################

    public MyPageErrorDialog()
    {
        setLabel("Error");
        setWidth(800);
        setFlavorAlert();

        ScDiv body;
        body = getBody();
        body.css().pad().scroll();
        body.style().height(400);

        _message = body.addTransientContainer();

        ScDiv footer;
        footer = showFooter();
        footer.css().flexRow().flexAlignEnd();
        footer.css().buttonBox();
        footer.addScriptButton("Copy", newCopyScript(body));
        footer.addCloseButton(newUncheckedAction(this::ajaxClose));
    }

    private ScBlockScript newCopyScript(ScDiv body)
    {
        ScBlockScript e;
        e = ScBlockScript.create();
        e.selectAndCopyText(body);
        e.toast("Copied.");
        return e;
    }

    //##################################################
    //# accessing
    //##################################################

    public void ajaxOpenException(Throwable ex)
    {
        applyError(ex);
        ajaxOpen();
    }

    //##################################################
    //# support
    //##################################################

    private void applyError(Throwable ex)
    {
        ScDiv root;
        root = _message.addDiv();
        root.css().noWrap();

        ScParagraph title;
        title = root.addParagraph(ex.getClass().getSimpleName());
        title.css().bold();

        ScParagraph msg;
        msg = root.addParagraph(Kmu.getRootMessage(ex));
        msg.css().italic();

        root.addBreak();
        root.addText(Kmu.formatStackTrace(ex));
    }
}
