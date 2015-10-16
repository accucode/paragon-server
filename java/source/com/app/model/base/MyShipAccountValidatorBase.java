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
 * Validation rules for shipAccount.
 */
public class MyShipAccountValidatorBase
    extends MyDomainValidator<MyShipAccount>
{
    //##################################################
    //# static
    //##################################################

    public static final MyShipAccountValidator instance = new MyShipAccountValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator descriptionValidator;
    private KmBooleanValidator billedToCustomerValidator;
    private KmStringValidator shipOnAccountNameValidator;
    private KmStringValidator shipOnAccountNumberValidator;
    private KmStringValidator billToTypeCodeValidator;
    private KmStringValidator billToAccountValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyShipAccountValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValidator = newNameValidator();
        descriptionValidator = newDescriptionValidator();
        billedToCustomerValidator = newBilledToCustomerValidator();
        shipOnAccountNameValidator = newShipOnAccountNameValidator();
        shipOnAccountNumberValidator = newShipOnAccountNumberValidator();
        billToTypeCodeValidator = newBillToTypeCodeValidator();
        billToAccountValidator = newBillToAccountValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getDescriptionValidator()
    {
        return descriptionValidator;
    }

    public KmBooleanValidator getBilledToCustomerValidator()
    {
        return billedToCustomerValidator;
    }

    public KmStringValidator getShipOnAccountNameValidator()
    {
        return shipOnAccountNameValidator;
    }

    public KmStringValidator getShipOnAccountNumberValidator()
    {
        return shipOnAccountNumberValidator;
    }

    public KmStringValidator getBillToTypeCodeValidator()
    {
        return billToTypeCodeValidator;
    }

    public KmStringValidator getBillToAccountValidator()
    {
        return billToAccountValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyShipAccount value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setDescription(descriptionValidator.convertOnly(value.getDescription()));
        value.setBilledToCustomer(billedToCustomerValidator.convertOnly(value.getBilledToCustomer()));
        value.setShipOnAccountName(shipOnAccountNameValidator.convertOnly(value.getShipOnAccountName()));
        value.setShipOnAccountNumber(shipOnAccountNumberValidator.convertOnly(value.getShipOnAccountNumber()));
        value.setBillToTypeCode(billToTypeCodeValidator.convertOnly(value.getBillToTypeCode()));
        value.setBillToAccount(billToAccountValidator.convertOnly(value.getBillToAccount()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyShipAccount value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        descriptionValidator.validateOnly(value.getDescription(), errors);
        billedToCustomerValidator.validateOnly(value.getBilledToCustomer(), errors);
        shipOnAccountNameValidator.validateOnly(value.getShipOnAccountName(), errors);
        shipOnAccountNumberValidator.validateOnly(value.getShipOnAccountNumber(), errors);
        billToTypeCodeValidator.validateOnly(value.getBillToTypeCode(), errors);
        billToAccountValidator.validateOnly(value.getBillToAccount(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("shipAccount", "project"));
        if ( !value.hasCarrier() )
            errors.add(new KmRequiredValidationError("shipAccount", "carrier"));
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
        e.setModel("shipAccount");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("shipAccount");
        e.setField("name");
        return e;
    }

    public KmStringValidator newDescriptionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("shipAccount");
        e.setField("description");
        return e;
    }

    public KmBooleanValidator newBilledToCustomerValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("shipAccount");
        e.setField("billedToCustomer");
        e.setRequired();
        return e;
    }

    public KmStringValidator newShipOnAccountNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("shipAccount");
        e.setField("shipOnAccountName");
        return e;
    }

    public KmStringValidator newShipOnAccountNumberValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("shipAccount");
        e.setField("shipOnAccountNumber");
        return e;
    }

    public KmStringValidator newBillToTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("shipAccount");
        e.setField("billToTypeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newBillToAccountValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("shipAccount");
        e.setField("billToAccount");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("shipAccount");
        e.setField("lockVersion");
        return e;
    }


}

