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

    private KmDateValidator dateValidator;
    private KmIntegerValidator countValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyDatedCountVoValidatorBase()
    {
        super();
        dateValidator = newDateValidator();
        countValidator = newCountValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDateValidator getDateValidator()
    {
        return dateValidator;
    }

    public KmIntegerValidator getCountValidator()
    {
        return countValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyDatedCountVo value)
    {
        // fields...
        value.setDate(dateValidator.convertOnly(value.getDate()));
        value.setCount(countValidator.convertOnly(value.getCount()));
    }

    @Override
    public void validateOnly(MyDatedCountVo value, KmList<KmErrorIF> errors)
    {
        // fields...
        dateValidator.validateOnly(value.getDate(), errors);
        countValidator.validateOnly(value.getCount(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmDateValidator newDateValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModel("datedCountVo");
        e.setField("date");
        return e;
    }

    public KmIntegerValidator newCountValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("datedCountVo");
        e.setField("count");
        return e;
    }


}

