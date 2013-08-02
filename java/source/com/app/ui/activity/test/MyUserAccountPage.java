package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScText;

import com.app.utility.MyButtonUrls;

public class MyUserAccountPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserAccountPage instance = new MyUserAccountPage();

    private MyUserAccountPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDialog _dialog;
    private ScText   _welcomeMessage;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        installDialog(root);

        _welcomeMessage = new ScText();
        _welcomeMessage.setValue("welcome");

        ScGroup group;
        group = root.addGroup();
        group.style().bold();
        group.style().size(25);

        group.getHeader().add(_welcomeMessage);

        ScBox body;
        body = group.addPad();
        body.addButton("Show Dialog", newOpenAction());

        return root;
    }

    private void installDialog(ScBox root)
    {
        _dialog = root.addDialog();
        _dialog.getHeaderBox().addPad().addText("This is the Header");
        _dialog.getFooterBox().addPad().addText("This is the Footer.");

        ScBox body = _dialog.getBodyBox();
        body.addPad().addText("This is the Body of the dialog.");

        ScGroup group;
        group = body.addGroup("This is a Group inside the body");
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
    //# start
    //##################################################//

    @Override
    public void start()
    {
        _welcomeMessage.setValue("Welcome " + getCurrentUser().getName());
        _welcomeMessage.ajaxUpdateValues();

        super.start();
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
