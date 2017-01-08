package com.app.ui.page.tools;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.utility.MyButtonUrls;
import com.app.utility.MyGlobals;

public class MyDevUserFrame
    extends ScCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _userUid;

    private ScCard        _viewChild;
    private ScCard        _editChild;

    private Runnable      _onChange;

    //##################################################
    //# constructor
    //##################################################

    public MyDevUserFrame()
    {
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

        ScDiv buttons;
        buttons = group.getBanner().getRight();
        buttons.css().pad5();

        ScActionButton button;
        button = buttons.addButton("Edit", this::handleEdit);
        button.setImage(MyButtonUrls.edit());

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.addFieldText(x.Uid);
        fields.addFieldText(x.LongName);
        fields.addFieldText(x.Email);
        fields.addFieldText(x.RoleName);

        return child;
    }

    private ScCard createEditChild()
    {
        MyMetaUser x = MyUser.Meta;

        ScCard child;
        child = addCard();

        ScForm form;
        form = child.addForm();
        form.setSubmitAction(this::handleEditSaved);
        form.setEscapeAction(this::handleEditCancelled);

        ScGroup group;
        group = form.addGroup("Edit");
        group.style().minWidth(300);

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.css().widthFull();
        fields.addFieldText(x.Uid);
        fields.addSpace();
        fields.addFieldFull(x.FirstName);
        fields.addFieldFull(x.LastName);
        fields.addFieldFull(x.Nickname);
        fields.addSpace();
        fields.addFieldFull(x.Email);
        fields.addFieldFull(x.Phone);
        fields.addSpace();
        fields.add(x.RoleCode.newDropdown());

        ScDiv footer;
        footer = group.showFooter().addButtonBox();
        footer.addSaveButton();
        footer.addCancelButton(this::handleEditCancelled);

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
        return MyGlobals.getAccess().findUserUid(uid);
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
        _viewChild.ajaxPrintCard();
    }

    private void renderEdit()
    {
        _editChild.applyFromModel(getUser());
        _editChild.ajaxPrintCard();
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
