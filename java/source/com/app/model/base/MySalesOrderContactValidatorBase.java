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
 * Validation rules for salesOrderContact.
 */
public class MySalesOrderContactValidatorBase
    extends MyDomainValidator<MySalesOrderContact>
{
    //##################################################
    //# static
    //##################################################

    public static final MySalesOrderContactValidator instance = new MySalesOrderContactValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator titleValidator;
    private KmStringValidator phoneValidator;
    private KmStringValidator emailValidator;
    private KmBooleanValidator orderNotificationsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MySalesOrderContactValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValidator = newNameValidator();
        titleValidator = newTitleValidator();
        phoneValidator = newPhoneValidator();
        emailValidator = newEmailValidator();
        orderNotificationsValidator = newOrderNotificationsValidator();
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

    public KmStringValidator getTitleValidator()
    {
        return titleValidator;
    }

    public KmStringValidator getPhoneValidator()
    {
        return phoneValidator;
    }

    public KmStringValidator getEmailValidator()
    {
        return emailValidator;
    }

    public KmBooleanValidator getOrderNotificationsValidator()
    {
        return orderNotificationsValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MySalesOrderContact value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setTitle(titleValidator.convertOnly(value.getTitle()));
        value.setPhone(phoneValidator.convertOnly(value.getPhone()));
        value.setEmail(emailValidator.convertOnly(value.getEmail()));
        value.setOrderNotifications(orderNotificationsValidator.convertOnly(value.getOrderNotifications()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MySalesOrderContact value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        titleValidator.validateOnly(value.getTitle(), errors);
        phoneValidator.validateOnly(value.getPhone(), errors);
        emailValidator.validateOnly(value.getEmail(), errors);
        orderNotificationsValidator.validateOnly(value.getOrderNotifications(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasSalesOrder() )
            errors.add(new KmRequiredValidationError("salesOrderContact", "salesOrder"));
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
        e.setModel("salesOrderContact");
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
        e.setModel("salesOrderContact");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTitleValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("salesOrderContact");
        e.setField("title");
        return e;
    }

    public KmStringValidator newPhoneValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("salesOrderContact");
        e.setField("phone");
        return e;
    }

    public KmStringValidator newEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("salesOrderContact");
        e.setField("email");
        return e;
    }

    public KmBooleanValidator newOrderNotificationsValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("salesOrderContact");
        e.setField("orderNotifications");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("salesOrderContact");
        e.setField("lockVersion");
        return e;
    }


}

