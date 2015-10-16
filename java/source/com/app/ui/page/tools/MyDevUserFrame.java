package com.app.ui.page.tools;

import com.kodemore.servlet.action.ScAction;
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

    private ScCard _viewChild;
    private ScCard _editChild;

    private Runnable _onChange;

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
        button = header.addButton("Edit", this::handleEdit);
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

        ScAction saveAction;
        saveAction = newAction(this::handleEditSaved);
        saveAction.disableChangeTracking();

        ScAction cancelAction;
        cancelAction = newAction(this::handleEditCancelled);
        cancelAction.disableChangeTracking();

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
        footer.addSubmitButton("Save");
        footer.addCancelButton(cancelAction);

        return child;
    }

    //##################################################
    //# accessing
    //##################################################

    public Runnable getOnChange()
    {
        return _onChange;
    }

    public void setOnChange(Runnable e)
    {
        _onChange = e;
    }

    public void fireOnChanged()
    {
        if ( _onChange != null )
            _onChange.run();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        renderEdit();
    }

    private void handleEditCancelled()
    {
        renderView();
    }

    private void handleEditSaved()
    {
        _editChild.validate();

        MyUser user;
        user = getUser();
        user.applyFrom(_editChild);

        renderView();

        fireOnChanged();
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
