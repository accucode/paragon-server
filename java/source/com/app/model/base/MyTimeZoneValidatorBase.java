//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;

import com.app.model.MyTimeZone;
import com.app.model.MyTimeZoneValidator;
import com.app.model.core.MyDomainValidator;

/**
 * Validation rules for timeZone.
 */
public class MyTimeZoneValidatorBase
    extends MyDomainValidator<MyTimeZone>
{
    //##################################################
    //# static
    //##################################################

    public static final MyTimeZoneValidator instance = new MyTimeZoneValidator();

    //##################################################
    //# variables
    //##################################################


    //##################################################
    //# constructor
    //##################################################

    protected MyTimeZoneValidatorBase()
    {
        super();
    }

    //##################################################
    //# accessing
    //##################################################

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyTimeZone value)
    {
        // none
    }

    @Override
    public void validateOnly(MyTimeZone value, KmList<KmErrorIF> errors)
    {
        // none
    }

    //##################################################
    //# instance creation
    //##################################################


}

