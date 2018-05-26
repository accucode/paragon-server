package com.app.ui.page.crud.attachment;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDropzone;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyAttachmentAddCard
    extends MyCrudAddCard<MyAttachmentOwnerIF,MyAttachment>
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _ownerUidField;
    private ScHiddenField<String> _ownerTypeCodeField;

    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentAddCard()
    {
        super(new MyAttachmentBuilder());
    }

    public MyAttachmentAddCard(MyAttachmentBuilder e)
    {
        super(e);
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean allowsSave()
    {
        return false;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBody(ScDiv body)
    {
        body.css().auto();
        body.add(createDropzone());
    }

    private ScDropzone createDropzone()
    {
        ScDropzone e;
        e = new ScDropzone();
        e.setUploadHandler(this::handleUpload);
        e.setDoneAction(newCheckedAction(this::handleDone));

        _ownerUidField = e.addHiddenField();
        _ownerTypeCodeField = e.addHiddenField();

        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyAttachmentOwnerIF owner)
    {
        MyAttachmentOwnerType type = owner.getAttachmentOwnerType();

        _ownerUidField.setValue(owner.getUid());
        _ownerTypeCodeField.setValue(type.getCode());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleUpload(String fileName, byte[] bytes)
    {
        MyAttachment e;
        e = new MyAttachment();
        e.applyOwner(getOwner());
        e.setName(fileName);
        e.setTypeFromName();
        e.setContentBytes(bytes);
        e.daoAttach();
    }

    private void handleDone()
    {
        ajaxToast("Attachment(s) uploaded");
        fireListRefresh();
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyAttachment saveNewChildOn(MyAttachmentOwnerIF parent)
    {
        return null;
    }

    //##################################################
    //# support
    //##################################################

    private MyAttachmentOwnerIF getOwner()
    {
        String uid = _ownerUidField.getValue();
        return getOwnerType().findOwner(uid);
    }

    private MyAttachmentOwnerType getOwnerType()
    {
        String code = _ownerTypeCodeField.getValue();
        return MyAttachmentOwnerType.findCode(code);
    }

}
