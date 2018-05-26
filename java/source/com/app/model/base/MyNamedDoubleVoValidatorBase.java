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
 * Validation rules for namedDoubleVo.
 */
public class MyNamedDoubleVoValidatorBase
    extends MyDomainValidator<MyNamedDoubleVo>
{
    //##################################################
    //# static
    //##################################################

    public static final MyNamedDoubleVoValidator instance = new MyNamedDoubleVoValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator nameValidator;
    private KmDoubleValidator valueValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyNamedDoubleVoValidatorBase()
    {
        super();
        nameValidator = newNameValidator();
        valueValidator = newValueValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmDoubleValidator getValueValidator()
    {
        return valueValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyNamedDoubleVo value)
    {
        // fields...
        value.setName(nameValidator.convert(value.getName()));
        value.setValue(valueValidator.convert(value.getValue()));
    }

    @Override
    public void validateOnly(MyNamedDoubleVo value, KmErrorList errors)
    {
        // fields...
        nameValidator.validateOn(value.getName(), errors);
        valueValidator.validateOn(value.getValue(), errors);
        // required associations...
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
        e.setModelName("namedDoubleVo");
        e.setFieldName("name");
        return e;
    }

    public KmDoubleValidator newValueValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModelName("namedDoubleVo");
        e.setFieldName("value");
        return e;
    }


}

