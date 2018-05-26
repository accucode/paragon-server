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
 * Validation rules for attachment.
 */
public class MyAttachmentValidatorBase
    extends MyDomainValidator<MyAttachment>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAttachmentValidator instance = new MyAttachmentValidator();

    //##################################################
    //# variables
    //##################################################

    private KmBlobValidator contentValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator ownerTypeCodeValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAttachmentValidatorBase()
    {
        super();
        contentValidator = newContentValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        enabledValidator = newEnabledValidator();
        nameValidator = newNameValidator();
        ownerTypeCodeValidator = newOwnerTypeCodeValidator();
        typeCodeValidator = newTypeCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBlobValidator getContentValidator()
    {
        return contentValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getOwnerTypeCodeValidator()
    {
        return ownerTypeCodeValidator;
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
    public void convertOnly(MyAttachment value)
    {
        // fields...
        value.setContent(contentValidator.convert(value.getContent()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setName(nameValidator.convert(value.getName()));
        value.setOwnerTypeCode(ownerTypeCodeValidator.convert(value.getOwnerTypeCode()));
        value.setTypeCode(typeCodeValidator.convert(value.getTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyAttachment value, KmErrorList errors)
    {
        // fields...
        contentValidator.validateOn(value.getContent(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        nameValidator.validateOn(value.getName(), errors);
        ownerTypeCodeValidator.validateOn(value.getOwnerTypeCode(), errors);
        typeCodeValidator.validateOn(value.getTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("attachment", "project");
        if ( !value.hasTenant() )
            errors.addRequiredField("attachment", "tenant");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmBlobValidator newContentValidator()
    {
        KmBlobValidator e;
        e = new KmBlobValidator();
        e.setModelName("attachment");
        e.setFieldName("content");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("attachment");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("attachment");
        e.setFieldName("enabled");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(255);
        e.setAllowsPrintable(true);
        e.setModelName("attachment");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newOwnerTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("attachment");
        e.setFieldName("ownerTypeCode");
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
        e.setModelName("attachment");
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
        e.setModelName("attachment");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("attachment");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("attachment");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

