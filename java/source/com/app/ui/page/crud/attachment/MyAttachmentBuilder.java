package com.app.ui.page.crud.attachment;

import com.kodemore.meta.KmMetaModel;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.finder.MyAttachmentFinder;
import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyAttachmentBuilder
    extends MyCrudBuilder<MyAttachmentOwnerIF,MyAttachment>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _ownerTypeCode;

    //##################################################
    //# constructors
    //##################################################

    public MyAttachmentBuilder()
    {
        _ownerTypeCode = new ScLocalString();
        _ownerTypeCode.setAutoSave();
    }

    //##################################################
    //# owner type
    //##################################################

    public MyAttachmentOwnerType getOwnerType()
    {
        return MyAttachmentOwnerType.findCode(_ownerTypeCode.getValue());
    }

    public void setOwnerType(MyAttachmentOwnerType e)
    {
        if ( e == null )
            _ownerTypeCode.clearValue();
        else
            _ownerTypeCode.setValue(e.getCode());
    }

    public void clearType()
    {
        _ownerTypeCode.clearValue();
    }

    //##################################################
    //# owner
    //##################################################

    private MyAttachmentOwnerIF findOwnerUid(String uid)
    {
        return getOwnerType().findOwner(uid);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAttachmentOwnerIF findParent(String uid)
    {
        return findOwnerUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MyAttachment.Meta;
    }

    @Override
    public MyAttachmentFinder getChildFinder()
    {
        return MyAttachment.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyAttachmentOwnerIF getParentFor(MyAttachment e)
    {
        return e.getOwner();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyAttachmentSearchView newSearchView()
    {
        return new MyAttachmentSearchView(this);
    }

    @Override
    public MyCrudViewCard<MyAttachment> newViewCard()
    {
        return new MyAttachmentViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyAttachment> newEditCard()
    {
        // no edit card for attachments
        return null;
    }

    @Override
    public MyCrudAddCard<MyAttachmentOwnerIF,MyAttachment> newAddCard()
    {
        return new MyAttachmentAddCard(this);
    }

    @Override
    public MyCrudListView<MyAttachmentOwnerIF,MyAttachment> newListView()
    {
        return new MyAttachmentListView(this);
    }

    @Override
    public MyCrudFrame<MyAttachmentOwnerIF,MyAttachment> newFrame()
    {
        return new MyAttachmentFrame(this);
    }

    //##################################################
    //# allows
    //##################################################

    @Override
    protected boolean showsEditFor(MyAttachment e)
    {
        // no editing attachments
        return false;
    }

}
