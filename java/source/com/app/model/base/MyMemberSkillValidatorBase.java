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
 * Validation rules for memberSkill.
 */
public class MyMemberSkillValidatorBase
    extends MyDomainValidator<MyMemberSkill>
{
    //##################################################
    //# static
    //##################################################

    public static final MyMemberSkillValidator instance = new MyMemberSkillValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmIntegerValidator sequenceValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyMemberSkillValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        sequenceValidator = newSequenceValidator();
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

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyMemberSkill value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setSequence(sequenceValidator.convertOnly(value.getSequence()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyMemberSkill value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        sequenceValidator.validateOnly(value.getSequence(), errors);
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
        e.setModel("memberSkill");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newSequenceValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("memberSkill");
        e.setField("sequence");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("memberSkill");
        e.setField("lockVersion");
        return e;
    }


}

