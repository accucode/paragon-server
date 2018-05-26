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
 * Validation rules for filterTemplate.
 */
public class MyFilterTemplateValidatorBase
    extends MyDomainValidator<MyFilterTemplate>
{
    //##################################################
    //# static
    //##################################################

    public static final MyFilterTemplateValidator instance = new MyFilterTemplateValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator contextTypeCodeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmBooleanValidator deletedValidator;
    private KmBooleanValidator modifiedValidator;
    private KmStringValidator nameValidator;
    private KmBooleanValidator preferredValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyFilterTemplateValidatorBase()
    {
        super();
        contextTypeCodeValidator = newContextTypeCodeValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        deletedValidator = newDeletedValidator();
        modifiedValidator = newModifiedValidator();
        nameValidator = newNameValidator();
        preferredValidator = newPreferredValidator();
        typeCodeValidator = newTypeCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getContextTypeCodeValidator()
    {
        return contextTypeCodeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmBooleanValidator getDeletedValidator()
    {
        return deletedValidator;
    }

    public KmBooleanValidator getModifiedValidator()
    {
        return modifiedValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmBooleanValidator getPreferredValidator()
    {
        return preferredValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyFilterTemplate value)
    {
        // fields...
        value.setContextTypeCode(contextTypeCodeValidator.convert(value.getContextTypeCode()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDeleted(deletedValidator.convert(value.getDeleted()));
        value.setModified(modifiedValidator.convert(value.getModified()));
        value.setName(nameValidator.convert(value.getName()));
        value.setPreferred(preferredValidator.convert(value.getPreferred()));
        value.setTypeCode(typeCodeValidator.convert(value.getTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyFilterTemplate value, KmErrorList errors)
    {
        // fields...
        contextTypeCodeValidator.validateOn(value.getContextTypeCode(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        deletedValidator.validateOn(value.getDeleted(), errors);
        modifiedValidator.validateOn(value.getModified(), errors);
        nameValidator.validateOn(value.getName(), errors);
        preferredValidator.validateOn(value.getPreferred(), errors);
        typeCodeValidator.validateOn(value.getTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("filterTemplate", "project");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newContextTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("filterTemplate");
        e.setFieldName("contextTypeCode");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("filterTemplate");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newDeletedValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("filterTemplate");
        e.setFieldName("deleted");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newModifiedValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("filterTemplate");
        e.setFieldName("modified");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("filterTemplate");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newPreferredValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("filterTemplate");
        e.setFieldName("preferred");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("filterTemplate");
        e.setFieldName("typeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("filterTemplate");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("filterTemplate");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("filterTemplate");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

