package com.app.model;

import com.kodemore.utility.KmEnumIF;

import com.app.model.base.MyDefaultRecipientContactType;

/**
 * I provide ad hoc custom extensions to the autogenerated enum.
 */
public interface MyDefaultRecipientContactTypeIF
    extends KmEnumIF
{
    //##################################################
    //# self
    //##################################################

    default MyDefaultRecipientContactType self()
    {
        return (MyDefaultRecipientContactType)this;
    }

    //##################################################
    //# extensions
    //##################################################

    // put custom methods here
}
