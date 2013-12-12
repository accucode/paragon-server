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

import com.app.model.MySystemLogTrace;
import com.app.model.MySystemLogTraceValidator;
import com.app.model.core.MyDomainValidator;

/**
 * Validation rules for systemLogTrace.
 */
public class MySystemLogTraceValidatorBase
    extends MyDomainValidator<MySystemLogTrace>
{
    //##################################################
    //# static
    //##################################################

    public static final MySystemLogTraceValidator instance = new MySystemLogTraceValidator();

    //##################################################
    //# variables
    //##################################################

    private KmIntegerValidator idValidator;
    private KmIntegerValidator sequenceValidator;
    private KmStringValidator valueValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MySystemLogTraceValidatorBase()
    {
        super();
        idValidator = newIdValidator();
        sequenceValidator = newSequenceValidator();
        valueValidator = newValueValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmIntegerValidator getIdValidator()
    {
        return idValidator;
    }

    public KmIntegerValidator getSequenceValidator()
    {
        return sequenceValidator;
    }

    public KmStringValidator getValueValidator()
    {
        return valueValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MySystemLogTrace value)
    {
        value.setId(idValidator.convertOnly(value.getId()));
        value.setSequence(sequenceValidator.convertOnly(value.getSequence()));
        value.setValue(valueValidator.convertOnly(value.getValue()));
    }

    @Override
    public void validateOnly(MySystemLogTrace value, KmList<KmErrorIF> errors)
    {
        idValidator.validateOnly(value.getId(), errors);
        sequenceValidator.validateOnly(value.getSequence(), errors);
        valueValidator.validateOnly(value.getValue(), errors);
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmIntegerValidator newIdValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("systemLogTrace");
        e.setField("id");
        return e;
    }

    public KmIntegerValidator newSequenceValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("systemLogTrace");
        e.setField("sequence");
        e.setRequired();
        return e;
    }

    public KmStringValidator newValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setModel("systemLogTrace");
        e.setField("value");
        return e;
    }


}

