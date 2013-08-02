package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;

public class MyDomainDropdownSetValueTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDomainDropdownSetValueTestPage instance = new MyDomainDropdownSetValueTestPage();

    private MyDomainDropdownSetValueTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDomainDropdownField<MyUser,String> _fromDropdown;
    private ScDomainDropdownField<MyUser,String> _toDropdown;
    private ScDomainDropdownField<MyUser,String> _toDialogDropdown;

    private ScDialog                             _dialog;

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

        _fromDropdown = MyUser.Tools.newDomainDropdown();
        _fromDropdown.setOptionLabelAdaptor(MyMetaUser.Name);
        _fromDropdown.setNullNonePrefix();

        _toDropdown = MyUser.Tools.newDomainDropdown();
        _toDropdown.setOptionLabelAdaptor(MyMetaUser.Name);
        _toDropdown.setNullNonePrefix();

        ScGroup group;
        group = root.addGroup("Domain Dropdown Set Value Test");
        group.addPad().addText(
            "Select a user from this dropdown and then click 'Select User'.  The dropdown in the "
                + "group below should be updated to the user selected.");

        ScForm form;
        form = group.addForm();

        ScFieldTable fields;
        fields = form.addPad().addFields();
        fields.add(_fromDropdown);

        ScBox buttons;
        buttons = form.addButtonBoxLeft();
        buttons.addButton("Select User", newSelectUserAction());
        buttons.addButton("Select User (in dialog)", newShowDialogAction());

        group = root.addGroup("Updated Dropdown");
        fields = group.addPad().addFields();
        fields.add(_toDropdown);

        return root;
    }

    private void installDialog(ScBox root)
    {
        _dialog = root.addDialog();
        _dialog.getHeaderBox().addPad().addText("Dropdown in Dialog");
        _dialog.getBodyBox().hide();

        _toDialogDropdown = MyUser.Tools.newDomainDropdown();
        _toDialogDropdown.setOptionLabelAdaptor(MyMetaUser.Name);
        _toDialogDropdown.setNullNonePrefix();

        ScForm form;
        form = _dialog.getForm();

        ScFieldTable fields;
        fields = form.addPad().addFields();
        fields.css().width400();
        fields.add(_toDialogDropdown);
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newSelectUserAction()
    {
        return new ScAction()
        {
            @Override
            protected void handle()
            {
                handleSelectUser();
            }
        };
    }

    private ScActionIF newShowDialogAction()
    {
        return new ScAction()
        {
            @Override
            protected void handle()
            {
                handleShowDialog();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSelectUser()
    {
        MyUser e;
        e = _fromDropdown.getValue();

        _toDropdown.setValue(e);
        _toDropdown.ajaxUpdateValue();
    }

    private void handleShowDialog()
    {
        MyUser e;
        e = _fromDropdown.getValue();

        _toDialogDropdown.setValue(e);
        _toDialogDropdown.ajaxUpdateValue();

        _dialog.ajaxOpen();
    }
}
