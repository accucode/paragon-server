package com.app.ui.activity.test;

import com.app.utility.MyButtonUrls;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupIconHeader;
import com.kodemore.servlet.field.ScDropdown;

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

    private ScDialog          _dialog;
    private ScGroupIconHeader _welcomeMessage;

    private ScDropdown        _dropdown;

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

        ScForm form = root.addForm();

        KmList<String> list = new KmList<String>();
        list.add("house");
        list.add("smiley");
        list.add("squares");

        _dropdown = new ScDropdown();
        _dropdown.setOptions(list);

        ScGroup group;
        group = form.addGroup();

        _welcomeMessage = group.setTitleWithIcon("source ", "welcome");

        ScBox body;
        body = group.addPad();
        body.addButton("change Icon", newChangeIconAction());
        body.add(_dropdown);

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

    private ScActionIF newChangeIconAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleChangeIcon();
            }
        };
    }

    //##################################################
    //# start
    //##################################################//

    @Override
    public void start()
    {
        _welcomeMessage.setText("Welcome " + getCurrentUser().getName());
        _welcomeMessage.setImageSource(getCommonImageUrl("smiley.png"));
        _welcomeMessage.ajaxUpdateValues();

        super.start();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToast()
    {
        ajax().toast("Button pressed");
    }

    private void handleClose()
    {
        _dialog.ajaxClose();
    }

    private void handleChangeIcon()
    {
        String house = getCommonImageUrl("house.png");
        String smiley = getCommonImageUrl("smiley.png");
        String squares = getCommonImageUrl("squares.png");

        System.out.println("==============" + _dropdown.getStringValue());

        _welcomeMessage.setText("Welcome " + getCurrentUser().getName());

        if ( _dropdown.getStringValue().equals("house") )
            _welcomeMessage.setImageSource(house);

        if ( _dropdown.getStringValue().equals("smiley") )
            _welcomeMessage.setImageSource(smiley);

        if ( _dropdown.getStringValue().equals("squares") )
            _welcomeMessage.setImageSource(squares);

        _welcomeMessage.ajax().replace();
    }
}
