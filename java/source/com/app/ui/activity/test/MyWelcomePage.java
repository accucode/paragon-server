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

    private ScTextField       _accountName;
    private ScTextField       _accountType;
    private ScTextField       _accountRole;
    private ScTextField       _userName;
    private ScTextField       _userEmail;
    private ScTextField       _defaultAccount;

    private ScFieldset        _accountInfo;
    private ScFieldset        _profile;

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
        group = root.addGroup();

        _welcomeMessage = group.setTitleWithIcon("source ", "welcome");

        ScDiv buttons;
        buttons = group.getHeader().addFloatRight().addPadSpaced();
        buttons.addButton("change Icon", newChangeIconAction());
        buttons.add(_dropdown);
        buttons.addSpaces(3);

        ScBox body;
        body = group.addPadSpaced();

        _accountInfo = new ScFieldset();
        _accountInfo.setLabel("Account Info");

        ScFieldset box;
        box = body.add(_accountInfo);
        box.css().floatLeft().pad();

        _accountName = new ScTextField();
        _accountName.setLabel("Name");
        _accountName.setReadOnly();

        _accountType = new ScTextField();
        _accountType.setLabel("Type");
        _accountType.setReadOnly();

        _accountRole = new ScTextField();
        _accountRole.setLabel("My Role");
        _accountRole.setReadOnly();

        ScFieldTable fields;
        fields = box.addFields();
        fields.add(_accountName);
        fields.add(_accountType);
        fields.add(_accountRole);

        _profile = new ScFieldset();
        _profile.setLabel("My Profile");

        box = body.add(_profile);
        box.css().floatLeft().pad();

        _userName = new ScTextField();
        _userName.setLabel("Name");
        _userName.setReadOnly();

        _userEmail = new ScTextField();
        _userEmail.setLabel("Email");
        _userEmail.setReadOnly();

        _defaultAccount = new ScTextField();
        _defaultAccount.setLabel("Default account");
        _defaultAccount.setReadOnly();

        fields = box.addFields();
        fields.add(_userName);
        fields.add(_userEmail);
        fields.add(_defaultAccount);
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
    //##################################################

    @Override
    public void start()
    {
        _welcomeMessage.setText("Welcome " + getCurrentUser().getName());
        _welcomeMessage.setImageSource(getCommonImageUrl("smiley.png"));
        _welcomeMessage.ajaxUpdateValues();

        // fixme_valerie: 
        //        _accountName.setValue(getCurrentAccount().getName());
        //        _accountType.setValue(getCurrentAccount().getTypeName());
        //        _accountRole.setValue(getAccountUser().getRoleName());
        _accountInfo.ajaxUpdateValues();

        _userName.setValue(getCurrentUser().getName());
        _userEmail.setValue(getCurrentUser().getEmail());
        _profile.ajaxUpdateValues();

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
