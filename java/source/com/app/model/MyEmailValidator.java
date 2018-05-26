package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.exception.error.KmErrorList;

import com.app.model.base.MyEmailValidatorBase;

/**
 * Custom validation rules for email.
 */
public class MyEmailValidator
    extends MyEmailValidatorBase
{
    //##################################################
    //# validate
    //##################################################

    @Override
    public void validateOnly(MyEmail value, KmErrorList errors)
    {
        super.validateOnly(value, errors);

        validateRecipients(value, errors);
    }

    //##################################################
    //# recipients
    //##################################################

    private void validateRecipients(MyEmail value, KmErrorList errors)
    {
        KmCollection<MyEmailRecipient> v = value.getRecipients();

        if ( !v.containsIf(e -> e.isTypeTo()) )
            errors.addGeneralError("Email must have at least one TO recipient.");
    }
}
