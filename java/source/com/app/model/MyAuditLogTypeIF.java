package com.app.model;

import com.kodemore.utility.KmEnumIF;

import com.app.model.base.MyAuditLogType;

/**
 * I provide ad hoc custom extensions to the autogenerated enum.
 */
public interface MyAuditLogTypeIF
    extends KmEnumIF
{
    //##################################################
    //# self
    //##################################################

    default MyAuditLogType self()
    {
        return (MyAuditLogType)this;
    }

    //##################################################
    //# extensions
    //##################################################

    // put custom methods here
}