package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
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

    private ScText      _welcomeMessage;

    private ScTextField _accountName;
    private ScTextField _accountType;
    private ScTextField _accountRole;
    private ScTextField _userName;
    private ScTextField _userEmail;
    private ScTextField _defaultAccount;

    private ScFieldset  _accountInfo;
    private ScFieldset  _profile;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        installFieldsets(root);

        return root;
    }

    private void installFieldsets(ScBox root)
    {
        ScForm form = root.addForm();

        KmList<String> list = new KmList<String>();
        list.add("house");
        list.add("smiley");
        list.add("squares");

        ScGroup group;
        group = form.addGroup("Fieldset Samples");

        _welcomeMessage = group.setTitle("welcome");

        ScDiv buttons;
        buttons = group.getHeader().addFloatRight().addPadSpaced();
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
    //# start
    //##################################################

    @Override
    public void start()
    {
        _welcomeMessage.setValue("Welcome " + getCurrentUser().getName());
        _welcomeMessage.ajaxUpdateValues();

        _accountName.setValue(getCurrentAccount().getName());
        _accountType.setValue(getCurrentAccount().getTypeName());
        _accountRole.setValue(getCurrentAccountUser().getRoleName());
        _accountInfo.ajaxUpdateValues();

        _userName.setValue(getCurrentUser().getName());
        _userEmail.setValue(getCurrentUser().getEmail());
        _profile.ajaxUpdateValues();

        super.start();
    }
}
