package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.utility.MyButtonUrls;

public class MyShowDialogTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyShowDialogTestPage instance = new MyShowDialogTestPage();

    private MyShowDialogTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDialog _dialog;

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
        root.css().gap();

        installDialog(root);

        ScGroup group;
        group = root.addGroup();

        ScBox body;
        body = group.addPad();
        body.addButton("Show Dialog", newOpenAction());
    }

    private void installDialog(ScBox root)
    {
        _dialog = root.addDialog();
        _dialog.getHeaderBox().addPad().addText("This is the Header");
        _dialog.getFooterBox().addPad().addText("This is the Footer.");

        ScBox body = _dialog.getBodyBox();
        body.addPad().addText("This is the Body of the dialog.");

        ScGroup group;
        group = body.addGroup();
        group.addPad().addText("This is text inside the group, with a text field below.");
        group.addPad().addTextField();
        group.addPad().addButton("Toast Button", newToastAction());

        ScActionButton button;
        button = body.addPad().addButton("Close Dialog", newCloseAction());
        button.setImage(MyButtonUrls.cancel());
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newOpenAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleOpen();
            }
        };
    }

    private ScActionIF newToastAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleToast();
            }
        };
    }

    private ScActionIF newCloseAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleClose();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleOpen()
    {
        _dialog.ajaxOpen();
    }

    private void handleToast()
    {
        ajax().toast("Button pressed");
    }

    private void handleClose()
    {
        _dialog.ajaxClose();
    }
}
