package com.app.model;

import com.kodemore.exception.error.KmErrorList;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyEmailRecipientValidatorBase;

/**
 * Custom validation rules for emailRecipient.
 */
public class MyEmailRecipientValidator
    extends MyEmailRecipientValidatorBase
{
    //##################################################
    //# validate
    //##################################################

    @Override
    public void validateOnly(MyEmailRecipient value, KmErrorList errors)
    {
        super.validateOnly(value, errors);

        validateAddress(value, errors);
    }

    //##################################################
    //# address
    //##################################################

    private void validateAddress(MyEmailRecipient value, KmErrorList errors)
    {
        String address = value.getAddress();
        if ( !Kmu.isValidEmailAddress(address) )
            errors.addGeneralError("Invalid Email Address: %s", address);
    }
}
