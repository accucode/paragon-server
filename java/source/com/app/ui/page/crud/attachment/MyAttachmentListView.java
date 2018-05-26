package com.app.ui.page.crud.attachment;

import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyAttachmentListView
    extends MyCrudListView<MyAttachmentOwnerIF,MyAttachment>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentListView()
    {
        this(new MyAttachmentBuilder());
    }

    public MyAttachmentListView(MyAttachmentBuilder e)
    {
        super(e);
        setLabel("Attachments");
    }

    //##################################################
    //# owner
    //##################################################

    public void setOwner(MyAttachmentOwnerIF owner)
    {
        MyAttachmentOwnerType type = owner.getAttachmentOwnerType();
        getBuilder().setOwnerType(type);
        setDomainParent(owner);
    }

    private void _setOwner(Object obj)
    {
        if ( obj instanceof MyAttachmentOwnerIF )
            setOwner((MyAttachmentOwnerIF)obj);
        else
            clearOwner();
    }

    private void clearOwner()
    {
        getBuilder().setOwnerType(null);
        setDomainParent(null);
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        _setOwner(model);
        return false;
    }

    //##################################################
    //# support
    //##################################################

    public MyAttachmentBuilder getBuilder()
    {
        return (MyAttachmentBuilder)getCrudBuilder();
    }
}
