package com.app.model.core;

import com.kodemore.collection.KmList;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.log.KmLog;
import com.kodemore.utility.KmConstantsIF;

public abstract class MyDomainValidator<T>
    implements KmConstantsIF, Cloneable
{
    //##################################################
    //# validate
    //##################################################

    public boolean isValid(T value)
    {
        KmList<KmErrorIF> errors = new KmList<>();
        validate(value, errors);
        return errors.isEmpty();
    }

    public void validate(T value)
    {
        KmList<KmErrorIF> errors = new KmList<>();
        validate(value, errors);
        if ( errors.isNotEmpty() )
            throw new KmApplicationException(errors);
    }

    public void validateWarn(T value)
    {
        KmList<KmErrorIF> errors = new KmList<>();
        validate(value, errors);
        if ( errors.isNotEmpty() )
            KmLog.warnTrace(errors.getFirst().formatMessage());
    }

    public void validate(T value, KmList<KmErrorIF> errors)
    {
        convertOnly(value);
        validateOnly(value, errors);
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract void convertOnly(T value);

    public abstract void validateOnly(T value, KmList<KmErrorIF> errors);

}
