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
 * Validation rules for namedIntegerVo.
 */
public class MyNamedIntegerVoValidatorBase
    extends MyDomainValidator<MyNamedIntegerVo>
{
    //##################################################
    //# static
    //##################################################

    public static final MyNamedIntegerVoValidator instance = new MyNamedIntegerVoValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator nameValidator;
    private KmIntegerValidator valueValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyNamedIntegerVoValidatorBase()
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

    public KmIntegerValidator getValueValidator()
    {
        return valueValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyNamedIntegerVo value)
    {
        // fields...
        value.setName(nameValidator.convert(value.getName()));
        value.setValue(valueValidator.convert(value.getValue()));
    }

    @Override
    public void validateOnly(MyNamedIntegerVo value, KmErrorList errors)
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
        e.setModelName("namedIntegerVo");
        e.setFieldName("name");
        return e;
    }

    public KmIntegerValidator newValueValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("namedIntegerVo");
        e.setFieldName("value");
        return e;
    }


}

