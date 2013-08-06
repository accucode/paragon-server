package com.app.ui.activity.admin;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScFrameChild;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyFrame;
import com.app.utility.MyButtonUrls;

public class MyUserFrame
    extends MyFrame
{
    //##################################################
    //# variables
    //##################################################

    private ScFrameChild _viewChild;
    private ScFrameChild _editChild;
    private ScFrameChild _addChild;

    private ScActionIF   _onChangeAction;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _viewChild = createViewChild();
        _editChild = createEditChild();
        _addChild = createAddFrame();
    }

    private ScFrameChild createViewChild()
    {
        MyMetaUser x = MyUser.Meta;

        ScFrameChild child;
        child = createChild();

        ScGroup group;
        group = child.addGroup("View");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton button;
        button = header.addButton("Edit", newEditAction());
        button.setImage(MyButtonUrls.edit());

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addText(x.Uid);
        fields.addText(x.Email);
        fields.addText(x.Name);
        fields.addText(x.FavoriteColor);
        fields.addText(x.RoleName);

        return child;
    }

    private ScFrameChild createEditChild()
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

        ScColorField colorField;
        colorField = x.FavoriteColor.newField();
        colorField.setWidthFull();

        ScDropdown roleField;
        roleField = x.RoleCode.newDropdown();
        roleField.setValueAdaptor(x.RoleCode);
        roleField.css().widthFull();

        ScFrameChild child;
        child = createChild();

        ScForm form;
        form = child.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Edit");
        group.style().minWidth(300);

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.css().widthFull();
        fields.addText(x.Uid);
        fields.add(emailField);
        fields.add(nameField);
        fields.add(colorField);
        fields.add(roleField);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        return child;
    }

    private ScFrameChild createAddFrame()
    {
        MyMetaUser x = MyUser.Meta;

        ScActionIF saveAction = newAddSaveAction();
        ScActionIF cancelAction = newAddCancelAction();

        ScFrameChild child;
        child = createChild();

        ScForm form;
        form = child.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Add");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addField(x.Email);
        fields.addField(x.Name);

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

    private ScActionIF newAddSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddSave();
            }
        };
    }

    private ScActionIF newAddCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddCancel();
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

    private void handleAddCancel()
    {
        ajaxClear();
    }

    private void handleAddSave()
    {
        _addChild.ajax().hideAllErrors();
        _addChild.ajax().focus();
        _addChild.validate();

        MyUser e;
        e = new MyUser();
        e.applyFrom(_addChild);
        e.saveDao();

        flushDao();

        ajaxPrintViewUser(e);
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

    private void clearUser()
    {
        getPageSession().clearUser();
    }

    private void renderView()
    {
        MyUser user = getUser();

        _viewChild.applyFromModel(user);
        _viewChild.ajaxPrint();
    }

    private void renderEdit()
    {
        MyUser user;
        user = getPageSession().getUser();

        _editChild.applyFromModel(user);
        _editChild.ajaxPrint();
        _editChild.ajax().focus();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxPrintViewUser(MyUser e)
    {
        setUser(e);
        renderView();
    }

    public void ajaxPrintAddUser()
    {
        clearUser();
        _addChild.ajaxPrint();
    }

}