//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.model.MyEmailPart;
import com.app.model.MyEmailPartValidator;
import com.app.model.core.MyDomainValidator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.validator.KmBlobValidator;
import com.kodemore.validator.KmIntegerValidator;
import com.kodemore.validator.KmStringValidator;

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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setSequence(sequenceValidator.convertOnly(value.getSequence()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setAttachmentName(attachmentNameValidator.convertOnly(value.getAttachmentName()));
        value.setData(dataValidator.convertOnly(value.getData()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyEmailPart value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        sequenceValidator.validateOnly(value.getSequence(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
        attachmentNameValidator.validateOnly(value.getAttachmentName(), errors);
        dataValidator.validateOnly(value.getData(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
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
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
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
        e.setMaximumLength(30);
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

