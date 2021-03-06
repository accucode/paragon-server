package com.app.model;

import com.kodemore.utility.KmEnumIF;

import com.app.model.base.MyFilterTemplateContextType;

/**
 * I provide ad hoc custom extensions to the autogenerated enum.
 */
public interface MyFilterTemplateContextTypeIF
    extends KmEnumIF
{
    //##################################################
    //# self
    //##################################################

    default MyFilterTemplateContextType self()
    {
        return (MyFilterTemplateContextType)this;
    }

    //##################################################
    //# extensions
    //##################################################

    // put custom methods here
}
