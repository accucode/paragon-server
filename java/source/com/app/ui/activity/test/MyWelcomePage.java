package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupIconHeader;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;

public class MyWelcomePage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyWelcomePage instance = new MyWelcomePage();

    private MyWelcomePage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

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

        installFieldsets(root);

        return root;
    }

    private void installFieldsets(ScBox root)
    {
        KmList<String> list = new KmList<String>();
        list.add("house");
        list.add("smiley");
        list.add("squares");

        _dropdown = new ScDropdown();
        _dropdown.setOptions(list);

        ScGroup group;
        group = root.addGroup("Fieldset Samples");

        _welcomeMessage = group.setTitleWithIcon("source ", "welcome");

        ScDiv buttons;
        buttons = group.getHeader().addFloatRight().addPadSpaced();
        buttons.addButton("change Icon", newChangeIconAction());
        buttons.add(_dropdown);
        buttons.addSpaces(3);

        ScBox body;
        body = group.addPadSpaced();

        ScFieldset box;
        box = body.addFieldset("General Account Information");
        box.css().floatLeft().pad();

        ScTextField accountName = new ScTextField();
        accountName.setLabel("Name");
        accountName.setReadOnly();

        ScTextField accountType = new ScTextField();
        accountType.setLabel("Type");
        accountType.setReadOnly();

        ScTextField accountRole = new ScTextField();
        accountRole.setLabel("My Role");
        accountRole.setReadOnly();

        ScFieldTable fields;
        fields = box.addFields();
        fields.add(accountName);
        fields.add(accountType);
        fields.add(accountRole);

        box = body.addFieldset("My Profile");
        box.css().floatLeft().pad();

        ScTextField userName = new ScTextField();
        userName.setLabel("Name");
        userName.setReadOnly();

        ScTextField userEmail = new ScTextField();
        userEmail.setLabel("Email");
        userEmail.setReadOnly();

        ScTextField defaultAccount = new ScTextField();
        defaultAccount.setLabel("Default account");
        defaultAccount.setReadOnly();

        fields = box.addFields();
        fields.add(userName);
        fields.add(userEmail);
        fields.add(defaultAccount);
    }

    //##################################################
    //# action
    //##################################################

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

    private void handleChangeIcon()
    {
        String house = getCommonImageUrl("house.png");
        String smiley = getCommonImageUrl("smiley.png");
        String squares = getCommonImageUrl("squares.png");

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
