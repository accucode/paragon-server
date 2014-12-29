package com.app.ui.layout;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScParagraph;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.utility.Kmu;

import com.app.ui.control.MyDialog;

public class MyPageErrorDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScTransientContainer _message;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setKey("pageError");
        setLabel("Error");
        setWidth(600);
        setFlavorWarning();

        ScDiv body;
        body = getBody();
        body.css().pad().scroll();
        body.style().height(400);

        _message = body.addTransientContainer();

        ScFlexbox footer;
        footer = showFooter();
        footer.alignEnd();
        footer.css().buttonBox();
        footer.addButton("Close", newAjaxCloseAction());
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
