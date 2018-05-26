package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyAttachmentCriteria;
import com.app.dao.base.MyAttachmentDaoBase;
import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;

public class MyAttachmentDao
    extends MyAttachmentDaoBase
{
    //##################################################
    //# decorator
    //##################################################

    public KmList<MyAttachment> findAllFor(MyAttachmentOwnerIF owner)
    {
        MyAttachmentCriteria c;
        c = createCriteria();
        owner.applyAttachmentOwnerTo(c);
        return c.findAll();
    }
}
