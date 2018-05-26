package com.app.model;

import com.kodemore.domain.KmUidDomainIF;

import com.app.criteria.MyAttachmentCriteria;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.model.core.MyProjectDomainIF;

public interface MyAttachmentOwnerIF
    extends KmUidDomainIF, MyProjectDomainIF
{
    //##################################################
    //# type
    //##################################################

    MyAttachmentOwnerType getAttachmentOwnerType();

    //##################################################
    //# apply
    //##################################################

    void applyAttachmentOwnerTo(MyAttachment e);

    void applyAttachmentOwnerTo(MyAttachmentCriteria c);
}
