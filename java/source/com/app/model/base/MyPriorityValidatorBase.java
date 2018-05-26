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
 * Validation rules for priority.
 */
public class MyPriorityValidatorBase
    extends MyDomainValidator<MyPriority>
{
    //##################################################
    //# static
    //##################################################

    public static final MyPriorityValidator instance = new MyPriorityValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator categoryCodeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator sequenceCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPriorityValidatorBase()
    {
        super();
        categoryCodeValidator = newCategoryCodeValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        nameValidator = newNameValidator();
        sequenceCodeValidator = newSequenceCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getCategoryCodeValidator()
    {
        return categoryCodeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getSequenceCodeValidator()
    {
        return sequenceCodeValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyPriority value)
    {
        // fields...
        value.setCategoryCode(categoryCodeValidator.convert(value.getCategoryCode()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setName(nameValidator.convert(value.getName()));
        value.setSequenceCode(sequenceCodeValidator.convert(value.getSequenceCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
    }

    @Override
    public void validateOnly(MyPriority value, KmErrorList errors)
    {
        // fields...
        categoryCodeValidator.validateOn(value.getCategoryCode(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        nameValidator.validateOn(value.getName(), errors);
        sequenceCodeValidator.validateOn(value.getSequenceCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("priority", "project");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newCategoryCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("priority");
        e.setFieldName("categoryCode");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("priority");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("priority");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSequenceCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("priority");
        e.setFieldName("sequenceCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("priority");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("priority");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }


}

