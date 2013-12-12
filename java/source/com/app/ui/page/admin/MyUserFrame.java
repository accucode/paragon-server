package com.app.ui.page.admin;

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

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyCardFrame;
import com.app.utility.MyButtonUrls;

public class MyUserFrame
    extends MyCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private ScCard     _viewChild;
    private ScCard     _editChild;

    private ScActionIF _onChangeAction;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

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
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton button;
        button = header.addButton("Edit", newEditAction());
        button.setImage(MyButtonUrls.edit());

        ScFieldTable fields;
        fields = group.addPad().addFields();
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
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Edit");
        group.style().minWidth(300);

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.css().widthFull();
        fields.addText(x.Uid);
        fields.add(emailField);
        fields.add(nameField);
        fields.add(roleField);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
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
        return getPageSession().getUser();
    }

    private void setUser(MyUser e)
    {
        getPageSession().setUser(e);
    }

    private void renderView()
    {
        MyUser user = getUser();

        _viewChild.applyFromModel(user);
        _viewChild.print();
    }

    private void renderEdit()
    {
        MyUser user;
        user = getPageSession().getUser();

        _editChild.applyFromModel(user);
        _editChild.print();
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
