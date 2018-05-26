package com.app.ui.control;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.utility.ScActionRegistry;

import com.app.model.MyNote;
import com.app.model.MyNoteOwnerIF;
import com.app.model.MyNotes;
import com.app.model.base.MyNoteOwnerType;
import com.app.model.meta.MyMetaNote;

public class MyAddNoteDialog
    extends MyFormDialog
{
    //##################################################
    //# instance
    //##################################################

    private static MyAddNoteDialog _instance;

    public static MyAddNoteDialog getInstance()
    {
        return _instance;
    }

    public static void installInstance()
    {
        _instance = new MyAddNoteDialog();
    }

    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _ownerUidField;
    private ScHiddenField<String> _ownerTypeCodeField;

    private ScHiddenField<Integer> _callbackActionKeyField;
    private ScTextArea             _messageField;

    //##################################################
    //# constructor
    //##################################################

    public MyAddNoteDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        onSubmit(newUncheckedAction(this::handleSubmit));

        setLabel("Add Note");

        ScDiv header;
        header = getHeader();
        header.add(createOwnerUidField());
        header.add(createOwnerTypeCodeField());
        header.add(createCallbackActionField());

        ScDiv body;
        body = getBody();
        body.css().pad();
        body.add(createMessageField());

        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton("Add Note");
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    private ScControl createOwnerUidField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _ownerUidField = e;
        return e;
    }

    private ScControl createOwnerTypeCodeField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _ownerTypeCodeField = e;
        return e;
    }

    private ScControl createCallbackActionField()
    {
        ScHiddenField<Integer> e;
        e = new ScHiddenField<>();
        _callbackActionKeyField = e;
        return e;
    }

    private ScControl createMessageField()
    {
        MyMetaNote x = MyNote.Meta;

        ScTextArea e;
        e = x.Message.newMultilineField();
        e.layoutBlock(200);
        _messageField = e;
        return e;
    }

    //##################################################
    //# open
    //##################################################

    public void ajaxOpen(MyNoteOwnerIF e, ScAction callback)
    {
        setOwner(e);
        setCallbackAction(callback);

        super.ajaxOpen();
    }

    //##################################################
    //# context stub
    //##################################################

    private MyNoteOwnerIF getOwner()
    {
        MyNoteOwnerType type = getOwnerType();
        String uid = _ownerUidField.getValue();

        return type.findOwnerUid(uid);
    }

    private MyNoteOwnerType getOwnerType()
    {
        String typeCode = _ownerTypeCodeField.getValue();
        MyNoteOwnerType type = MyNoteOwnerType.findCode(typeCode);
        return type;
    }

    private void setOwner(MyNoteOwnerIF e)
    {
        _ownerUidField.setValue(e.getUid());
        _ownerTypeCodeField.setValue(e.getNoteOwnerType().getCode());
    }

    //##################################################
    //# callback action
    //##################################################

    private ScAction getCallbackAction()
    {
        Integer key = _callbackActionKeyField.getValue();
        return ScActionRegistry.getInstance().findKey(key);
    }

    private void setCallbackAction(ScAction e)
    {
        _callbackActionKeyField.setValue(e.getKey());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        ajaxHideAllErrors();
        validateAndCheck();

        MyNoteOwnerIF owner = getOwner();
        String msg = _messageField.getValue();
        MyNote note = owner.addUserNote(msg);
        getAccess().flush();

        ajaxClose();

        getData().ajax().runDelayedAction(getCallbackAction(), note.getUid());
    }

}
