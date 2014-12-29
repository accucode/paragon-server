package com.app.ui.page.tools;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyCardFrame;
import com.app.utility.MyButtonUrls;

public class MyDevUserFrame
    extends MyCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _userUid;

    private ScCard        _viewChild;
    private ScCard        _editChild;

    private ScActionIF    _onChangeAction;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        useFlipAnimation();

        _userUid = new ScLocalString();
        _userUid.setAutoSave();

        _viewChild = createViewChild();
        _editChild = createEditChild();
    }

    private ScCard createViewChild()
    {
        MyMetaUser x = MyUser.Meta;

        ScCard child;
        child = addCard();

        ScGroup group;
        group = child.addGroup("View");

        ScDiv header;
        header = group.getBanner().addFloatRight();
        header.css().pad5();

        ScActionButton button;
        button = header.addButton("Edit", newEditAction());
        button.setImage(MyButtonUrls.edit());

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.addText(x.Uid);
        fields.addText(x.Email);
        fields.addText(x.Name);
        fields.addText(x.RoleName);

        return child;
    }

    private ScCard createEditChild()
    {
        MyMetaUser x = MyUser.Meta;

        ScActionIF saveAction = newEditSaveAction();
        ScActionIF cancelAction = newEditCancelAction();

        ScTextField emailField;
        emailField = x.Email.newField();
        emailField.setWidthFull();

        ScTextField nameField;
        nameField = x.Name.newField();
        nameField.setWidthFull();

        ScDropdown roleField;
        roleField = x.RoleCode.newDropdown();
        roleField.setValueAdaptor(x.RoleCode);
        roleField.css().widthFull();

        ScCard child;
        child = addCard();

        ScForm form;
        form = child.addForm();
        form.setSubmitAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Edit");
        group.style().minWidth(300);

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.css().widthFull();
        fields.addText(x.Uid);
        fields.add(emailField);
        fields.add(nameField);
        fields.add(roleField);

        group.addBodyDivider();

        ScDiv footer;
        footer = group.getBody().addButtonBox();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        return child;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newEditAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEdit();
            }
        };
    }

    private ScActionIF newEditCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditCancel();
            }
        };
    }

    private ScActionIF newEditSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditSave();
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public ScActionIF getOnChangeAction()
    {
        return _onChangeAction;
    }

    public void setOnChangeAction(ScActionIF e)
    {
        _onChangeAction = e;
    }

    public void fireOnChangeAction()
    {
        if ( _onChangeAction != null )
            _onChangeAction.run();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        renderEdit();
    }

    private void handleEditCancel()
    {
        renderView();
    }

    private void handleEditSave()
    {
        _editChild.validate();

        MyUser user;
        user = getUser();
        user.applyFrom(_editChild);
        user.validate();

        renderView();

        fireOnChangeAction();
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getUser()
    {
        String uid = _userUid.getValue();
        return getAccess().findUserUid(uid);
    }

    private void setUser(MyUser e)
    {
        if ( e == null )
            _userUid.clearValue();
        else
            _userUid.setValue(e.getUid());
    }

    private void renderView()
    {
        _viewChild.applyFromModel(getUser());
        _viewChild.ajaxPrint();
    }

    private void renderEdit()
    {
        _editChild.applyFromModel(getUser());
        _editChild.ajaxPrint();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxPrintViewUser(MyUser e)
    {
        setUser(e);
        renderView();
    }

}
