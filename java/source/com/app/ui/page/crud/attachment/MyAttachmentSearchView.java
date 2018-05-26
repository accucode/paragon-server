package com.app.ui.page.crud.attachment;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

import com.app.criteria.MyAttachmentCriteria;
import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyAttachmentSearchView
    extends MyCrudGeneralCriteriaSearchView<MyAttachmentOwnerIF,MyAttachment,MyAttachmentCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentSearchView(MyCrudBuilder<MyAttachmentOwnerIF,MyAttachment> e)
    {
        super(e);
    }

    //##################################################
    //# fields
    //##################################################

    @Override
    protected void installBasicFieldsOn(ScDiv root)
    {
        // none
    }

    @Override
    protected void installExtendedFieldsOn(ScDiv root)
    {
        // none
    }

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        // none
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyAttachmentCriteria createCriteria()
    {
        return getAccess().getAttachmentDao().createCriteria();
    }

    @Override
    protected void filter(MyAttachmentCriteria c)
    {
        MyAttachmentOwnerIF owner = getDomainParent();
        owner.applyAttachmentOwnerTo(c);
    }

    @Override
    protected void sort(MyAttachmentCriteria c)
    {
        c.sortOnName();
    }

}
