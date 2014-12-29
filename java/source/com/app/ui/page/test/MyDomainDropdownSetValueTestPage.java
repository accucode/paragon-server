package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;

public class MyDomainDropdownSetValueTestPage
    extends MyAbstractTestEntryPage
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
    private ScDomainDropdownField<MyUser,String> _dialogDropdown;

    private ScDialog                             _dialog;

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

        installDialog();
        installDropdownGroupOn(root);
        installTargetGroupOn(root);
    }

    private void installDropdownGroupOn(ScPageRoot root)
    {
        _fromDropdown = MyUser.Tools.newDomainDropdown();
        _fromDropdown.setOptionLabelAdaptor(MyMetaUser.Name);
        _fromDropdown.setNullNonePrefix();

        _toDropdown = MyUser.Tools.newDomainDropdown();
        _toDropdown.setOptionLabelAdaptor(MyMetaUser.Name);
        _toDropdown.setNullNonePrefix();

        ScGroup group;
        group = root.addGroup("Domain Dropdown Test");

        ScDiv body;
        body = group.getBody();
        body.addPad().addText(
            "Select a user from this dropdown and then click 'Select User'.  The dropdown in the "
                + "group below should be updated to the user selected.");

        ScForm form;
        form = body.addForm();

        ScFieldTable fields;
        fields = form.addPad().addFieldTable();
        fields.add(_fromDropdown);

        ScBox buttons;
        buttons = form.addButtonBox();
        buttons.addButton("Select User", newSelectUserAction());
        buttons.addButton("Select User (in dialog)", newShowDialogAction());
    }

    private void installTargetGroupOn(ScPageRoot root)
    {
        ScGroup group;
        ScDiv body;
        ScFieldTable fields;
        group = root.addGroup("Target");

        body = group.getBody();
        fields = body.addPad().addFieldTable();
        fields.add(_toDropdown);
    }

    private void installDialog()
    {
        _dialogDropdown = MyUser.Tools.newDomainDropdown();
        _dialogDropdown.setOptionLabelAdaptor(MyMetaUser.Name);
        _dialogDropdown.setNullNonePrefix();

        _dialog = new ScDialog();
        _dialog.setLabel("Select User");
        _dialog.setSubmitAction(newDialogSubmitAction());

        ScDiv body;
        body = _dialog.getBody();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(_dialogDropdown);

        ScFlexbox footer;
        footer = _dialog.showFooter();
        footer.alignEnd();
        footer.css().buttonBox();
        footer.addSubmitButton();
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newSelectUserAction()
    {
        return new ScAction(this)
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
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleShowDialog();
            }
        };
    }

    private ScActionIF newDialogSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDialogSubmit();
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
        MyUser user = _fromDropdown.getValue();

        _dialogDropdown.setValue(user);
        _dialog.ajaxOpen();
    }

    private void handleDialogSubmit()
    {
        MyUser e;
        e = _dialogDropdown.getValue();

        _dialog.ajaxClose();

        _toDropdown.setValue(e);
        _toDropdown.ajaxUpdateValue();
    }

}
