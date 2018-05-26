package com.app.model;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.base.MyEmailTemplateContextType;
import com.app.model.core.MyProjectDomainIF;

public interface MyEmailTemplateContextIF
    extends MyProjectDomainIF, KmUidDomainIF
{
    //##################################################
    //# type
    //##################################################

    MyEmailTemplateContextType getEmailTemplateContextType();
}
