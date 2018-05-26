package com.app.model.core;

import com.kodemore.exception.error.KmErrorList;
import com.kodemore.utility.KmConstantsIF;

/**
 * Validate the FIELDS and associations contained within
 * a particular domain model. If you need to perform semantic
 * validation on the model itself, this should be done by overriding
 * validateModelOn in the domain model itself.
 */
public abstract class MyDomainValidator<T>
    implements KmConstantsIF, Cloneable
{
    //##################################################
    //# validate
    //##################################################

    public final void validateAndCheck(T value)
    {
        getValidationErrors(value).check();
    }

    public final KmErrorList getValidationErrors(T value)
    {
        KmErrorList errors = new KmErrorList();
        validateOn(value, errors);
        return errors;
    }

    public final void validateOn(T value, KmErrorList errors)
    {
        convertOnly(value);
        validateOnly(value, errors);
    }

    public final boolean isValid(T value)
    {
        return getValidationErrors(value).isOk();
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract void convertOnly(T value);

    public abstract void validateOnly(T value, KmErrorList errors);

}
