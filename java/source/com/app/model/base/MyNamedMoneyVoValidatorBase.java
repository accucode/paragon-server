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
 * Validation rules for namedMoneyVo.
 */
public class MyNamedMoneyVoValidatorBase
    extends MyDomainValidator<MyNamedMoneyVo>
{
    //##################################################
    //# static
    //##################################################

    public static final MyNamedMoneyVoValidator instance = new MyNamedMoneyVoValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator nameValidator;
    private KmMoneyValidator valueValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyNamedMoneyVoValidatorBase()
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

    public KmMoneyValidator getValueValidator()
    {
        return valueValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyNamedMoneyVo value)
    {
        // fields...
        value.setName(nameValidator.convert(value.getName()));
        value.setValue(valueValidator.convert(value.getValue()));
    }

    @Override
    public void validateOnly(MyNamedMoneyVo value, KmErrorList errors)
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
        e.setModelName("namedMoneyVo");
        e.setFieldName("name");
        return e;
    }

    public KmMoneyValidator newValueValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModelName("namedMoneyVo");
        e.setFieldName("value");
        return e;
    }


}

