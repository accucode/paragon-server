package com.app.model;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.base.MyBlurbOwnerType;
import com.app.model.core.MyProjectDomainIF;

public interface MyBlurbOwnerIF
    extends MyProjectDomainIF, KmUidDomainIF
{
    //##################################################
    //# type
    //##################################################

    MyBlurbOwnerType getBlurbOwnerType();
}
