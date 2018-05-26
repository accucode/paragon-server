//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.exception.error.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

/**
 * Validation rules for datedCountVo.
 */
public class MyDatedCountVoValidatorBase
    extends MyDomainValidator<MyDatedCountVo>
{
    //##################################################
    //# static
    //##################################################

    public static final MyDatedCountVoValidator instance = new MyDatedCountVoValidator();

    //##################################################
    //# variables
    //##################################################

    private KmIntegerValidator countValidator;
    private KmDateValidator dateValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyDatedCountVoValidatorBase()
    {
        super();
        countValidator = newCountValidator();
        dateValidator = newDateValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmIntegerValidator getCountValidator()
    {
        return countValidator;
    }

    public KmDateValidator getDateValidator()
    {
        return dateValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyDatedCountVo value)
    {
        // fields...
        value.setCount(countValidator.convert(value.getCount()));
        value.setDate(dateValidator.convert(value.getDate()));
    }

    @Override
    public void validateOnly(MyDatedCountVo value, KmErrorList errors)
    {
        // fields...
        countValidator.validateOn(value.getCount(), errors);
        dateValidator.validateOn(value.getDate(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmIntegerValidator newCountValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("datedCountVo");
        e.setFieldName("count");
        return e;
    }

    public KmDateValidator newDateValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModelName("datedCountVo");
        e.setFieldName("date");
        return e;
    }


}

