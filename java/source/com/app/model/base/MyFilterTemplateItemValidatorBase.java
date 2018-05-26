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
 * Validation rules for filterTemplateItem.
 */
public class MyFilterTemplateItemValidatorBase
    extends MyDomainValidator<MyFilterTemplateItem>
{
    //##################################################
    //# static
    //##################################################

    public static final MyFilterTemplateItemValidator instance = new MyFilterTemplateItemValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator attributeCodeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmBooleanValidator usedValidator;
    private KmStringValidator valueValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyFilterTemplateItemValidatorBase()
    {
        super();
        attributeCodeValidator = newAttributeCodeValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        usedValidator = newUsedValidator();
        valueValidator = newValueValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getAttributeCodeValidator()
    {
        return attributeCodeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    public KmBooleanValidator getUsedValidator()
    {
        return usedValidator;
    }

    public KmStringValidator getValueValidator()
    {
        return valueValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyFilterTemplateItem value)
    {
        // fields...
        value.setAttributeCode(attributeCodeValidator.convert(value.getAttributeCode()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setUsed(usedValidator.convert(value.getUsed()));
        value.setValue(valueValidator.convert(value.getValue()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyFilterTemplateItem value, KmErrorList errors)
    {
        // fields...
        attributeCodeValidator.validateOn(value.getAttributeCode(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        usedValidator.validateOn(value.getUsed(), errors);
        valueValidator.validateOn(value.getValue(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasTemplate() )
            errors.addRequiredField("filterTemplateItem", "template");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newAttributeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("filterTemplateItem");
        e.setFieldName("attributeCode");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("filterTemplateItem");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("filterTemplateItem");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("filterTemplateItem");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newUsedValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("filterTemplateItem");
        e.setFieldName("used");
        e.setRequired();
        return e;
    }

    public KmStringValidator newValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("filterTemplateItem");
        e.setFieldName("value");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("filterTemplateItem");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

