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
 * Validation rules for attributeValue.
 */
public class MyAttributeValueValidatorBase
    extends MyDomainValidator<MyAttributeValue>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAttributeValueValidator instance = new MyAttributeValueValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator textValueValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAttributeValueValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        textValueValidator = newTextValueValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getTextValueValidator()
    {
        return textValueValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAttributeValue value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setTextValue(textValueValidator.convertOnly(value.getTextValue()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyAttributeValue value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        textValueValidator.validateOnly(value.getTextValue(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasField() )
            errors.add(new KmRequiredValidationError("attributeValue", "field"));
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("attributeValue");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTextValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("attributeValue");
        e.setField("textValue");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("attributeValue");
        e.setField("lockVersion");
        return e;
    }


}

