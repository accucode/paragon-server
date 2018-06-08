package com.app.model;

import com.kodemore.utility.KmEnumIF;

import com.app.model.base.MyEmailStatus;

/**
 * I provide ad hoc custom extensions to the autogenerated enum.
 */
public interface MyEmailStatusIF
    extends KmEnumIF
{
    //##################################################
    //# self
    //##################################################

    default MyEmailStatus self()
    {
        return (MyEmailStatus)this;
    }

    //##################################################
    //# extensions
    //##################################################

    // put custom methods here
}