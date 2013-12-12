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
import com.kodemore.validator.KmIntegerValidator;
import com.kodemore.validator.KmStringValidator;

import com.app.model.MyNamedCountVo;
import com.app.model.MyNamedCountVoValidator;
import com.app.model.core.MyDomainValidator;

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

