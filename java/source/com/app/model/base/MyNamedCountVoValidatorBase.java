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
 * Validation rules for namedCountVo.
 */
public class MyNamedCountVoValidatorBase
    extends MyDomainValidator<MyNamedCountVo>
{
    //##################################################
    //# static
    //##################################################

    public static final MyNamedCountVoValidator instance = new MyNamedCountVoValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator nameValidator;
    private KmIntegerValidator countValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyNamedCountVoValidatorBase()
    {
        super();
        nameValidator = newNameValidator();
        countValidator = newCountValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmIntegerValidator getCountValidator()
    {
        return countValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyNamedCountVo value)
    {
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setCount(countValidator.convertOnly(value.getCount()));
    }

    @Override
    public void validateOnly(MyNamedCountVo value, KmList<KmErrorIF> errors)
    {
        nameValidator.validateOnly(value.getName(), errors);
        countValidator.validateOnly(value.getCount(), errors);
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("namedCountVo");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newCountValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("namedCountVo");
        e.setField("count");
        e.setRequired();
        return e;
    }


}

