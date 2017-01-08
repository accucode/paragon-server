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

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator sequenceValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator attachmentNameValidator;
    private KmBlobValidator dataValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyEmailPartValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        sequenceValidator = newSequenceValidator();
        typeCodeValidator = newTypeCodeValidator();
        attachmentNameValidator = newAttachmentNameValidator();
        dataValidator = newDataValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    public KmIntegerValidator getSequenceValidator()
    {
        return sequenceValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getAttachmentNameValidator()
    {
        return attachmentNameValidator;
    }

    public KmBlobValidator getDataValidator()
    {
        return dataValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convertOnly(value.getUpdatedUtcTs()));
        value.setSequence(sequenceValidator.convertOnly(value.getSequence()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setAttachmentName(attachmentNameValidator.convertOnly(value.getAttachmentName()));
        value.setData(dataValidator.convertOnly(value.getData()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyEmailPart value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        updatedUtcTsValidator.validateOnly(value.getUpdatedUtcTs(), errors);
        sequenceValidator.validateOnly(value.getSequence(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
        attachmentNameValidator.validateOnly(value.getAttachmentName(), errors);
        dataValidator.validateOnly(value.getData(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasEmail() )
            errors.add(new KmRequiredValidationError("emailPart", "email"));
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
        e.setModel("emailPart");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("emailPart");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("emailPart");
        e.setField("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newSequenceValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("emailPart");
        e.setField("sequence");
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
        e.setModel("emailPart");
        e.setField("typeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newAttachmentNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("emailPart");
        e.setField("attachmentName");
        return e;
    }

    public KmBlobValidator newDataValidator()
    {
        KmBlobValidator e;
        e = new KmBlobValidator();
        e.setModel("emailPart");
        e.setField("data");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("emailPart");
        e.setField("lockVersion");
        return e;
    }


}

