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
 * Validation rules for emailPart.
 */
public class MyEmailPartValidatorBase
    extends MyDomainValidator<MyEmailPart>
{
    //##################################################
    //# static
    //##################################################

    public static final MyEmailPartValidator instance = new MyEmailPartValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator attachmentNameValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmBlobValidator dataValidator;
    private KmIntegerValidator sequenceValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyEmailPartValidatorBase()
    {
        super();
        attachmentNameValidator = newAttachmentNameValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        dataValidator = newDataValidator();
        sequenceValidator = newSequenceValidator();
        typeCodeValidator = newTypeCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getAttachmentNameValidator()
    {
        return attachmentNameValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmBlobValidator getDataValidator()
    {
        return dataValidator;
    }

    public KmIntegerValidator getSequenceValidator()
    {
        return sequenceValidator;
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
    public void convertOnly(MyEmailPart value)
    {
        // fields...
        value.setAttachmentName(attachmentNameValidator.convert(value.getAttachmentName()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setData(dataValidator.convert(value.getData()));
        value.setSequence(sequenceValidator.convert(value.getSequence()));
        value.setTypeCode(typeCodeValidator.convert(value.getTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyEmailPart value, KmErrorList errors)
    {
        // fields...
        attachmentNameValidator.validateOn(value.getAttachmentName(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        dataValidator.validateOn(value.getData(), errors);
        sequenceValidator.validateOn(value.getSequence(), errors);
        typeCodeValidator.validateOn(value.getTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasEmail() )
            errors.addRequiredField("emailPart", "email");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newAttachmentNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(255);
        e.setAllowsPrintable(true);
        e.setModelName("emailPart");
        e.setFieldName("attachmentName");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("emailPart");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmBlobValidator newDataValidator()
    {
        KmBlobValidator e;
        e = new KmBlobValidator();
        e.setModelName("emailPart");
        e.setFieldName("data");
        return e;
    }

    public KmIntegerValidator newSequenceValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("emailPart");
        e.setFieldName("sequence");
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
        e.setModelName("emailPart");
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
        e.setModelName("emailPart");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("emailPart");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("emailPart");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

