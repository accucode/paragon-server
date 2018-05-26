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
 * Validation rules for member.
 */
public class MyMemberValidatorBase
    extends MyDomainValidator<MyMember>
{
    //##################################################
    //# static
    //##################################################

    public static final MyMemberValidator instance = new MyMemberValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmIntegerValidator dashboardLineCount1Validator;
    private KmIntegerValidator dashboardLineCount2Validator;
    private KmStringValidator dashboardOrientationTypeCodeValidator;
    private KmStringValidator dashboardPanelCodeAValidator;
    private KmStringValidator dashboardPanelCodeBValidator;
    private KmStringValidator dashboardPanelCodeCValidator;
    private KmStringValidator dashboardPanelCodeDValidator;
    private KmStringValidator dashboardPanelCodeEValidator;
    private KmStringValidator dashboardPanelCodeFValidator;
    private KmStringValidator dashboardPanelCodeGValidator;
    private KmIntegerValidator dashboardRefreshMinutesValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator roleCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyMemberValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        dashboardLineCount1Validator = newDashboardLineCount1Validator();
        dashboardLineCount2Validator = newDashboardLineCount2Validator();
        dashboardOrientationTypeCodeValidator = newDashboardOrientationTypeCodeValidator();
        dashboardPanelCodeAValidator = newDashboardPanelCodeAValidator();
        dashboardPanelCodeBValidator = newDashboardPanelCodeBValidator();
        dashboardPanelCodeCValidator = newDashboardPanelCodeCValidator();
        dashboardPanelCodeDValidator = newDashboardPanelCodeDValidator();
        dashboardPanelCodeEValidator = newDashboardPanelCodeEValidator();
        dashboardPanelCodeFValidator = newDashboardPanelCodeFValidator();
        dashboardPanelCodeGValidator = newDashboardPanelCodeGValidator();
        dashboardRefreshMinutesValidator = newDashboardRefreshMinutesValidator();
        enabledValidator = newEnabledValidator();
        roleCodeValidator = newRoleCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmIntegerValidator getDashboardLineCount1Validator()
    {
        return dashboardLineCount1Validator;
    }

    public KmIntegerValidator getDashboardLineCount2Validator()
    {
        return dashboardLineCount2Validator;
    }

    public KmStringValidator getDashboardOrientationTypeCodeValidator()
    {
        return dashboardOrientationTypeCodeValidator;
    }

    public KmStringValidator getDashboardPanelCodeAValidator()
    {
        return dashboardPanelCodeAValidator;
    }

    public KmStringValidator getDashboardPanelCodeBValidator()
    {
        return dashboardPanelCodeBValidator;
    }

    public KmStringValidator getDashboardPanelCodeCValidator()
    {
        return dashboardPanelCodeCValidator;
    }

    public KmStringValidator getDashboardPanelCodeDValidator()
    {
        return dashboardPanelCodeDValidator;
    }

    public KmStringValidator getDashboardPanelCodeEValidator()
    {
        return dashboardPanelCodeEValidator;
    }

    public KmStringValidator getDashboardPanelCodeFValidator()
    {
        return dashboardPanelCodeFValidator;
    }

    public KmStringValidator getDashboardPanelCodeGValidator()
    {
        return dashboardPanelCodeGValidator;
    }

    public KmIntegerValidator getDashboardRefreshMinutesValidator()
    {
        return dashboardRefreshMinutesValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getRoleCodeValidator()
    {
        return roleCodeValidator;
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
    public void convertOnly(MyMember value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDashboardLineCount1(dashboardLineCount1Validator.convert(value.getDashboardLineCount1()));
        value.setDashboardLineCount2(dashboardLineCount2Validator.convert(value.getDashboardLineCount2()));
        value.setDashboardOrientationTypeCode(dashboardOrientationTypeCodeValidator.convert(value.getDashboardOrientationTypeCode()));
        value.setDashboardPanelCodeA(dashboardPanelCodeAValidator.convert(value.getDashboardPanelCodeA()));
        value.setDashboardPanelCodeB(dashboardPanelCodeBValidator.convert(value.getDashboardPanelCodeB()));
        value.setDashboardPanelCodeC(dashboardPanelCodeCValidator.convert(value.getDashboardPanelCodeC()));
        value.setDashboardPanelCodeD(dashboardPanelCodeDValidator.convert(value.getDashboardPanelCodeD()));
        value.setDashboardPanelCodeE(dashboardPanelCodeEValidator.convert(value.getDashboardPanelCodeE()));
        value.setDashboardPanelCodeF(dashboardPanelCodeFValidator.convert(value.getDashboardPanelCodeF()));
        value.setDashboardPanelCodeG(dashboardPanelCodeGValidator.convert(value.getDashboardPanelCodeG()));
        value.setDashboardRefreshMinutes(dashboardRefreshMinutesValidator.convert(value.getDashboardRefreshMinutes()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setRoleCode(roleCodeValidator.convert(value.getRoleCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyMember value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        dashboardLineCount1Validator.validateOn(value.getDashboardLineCount1(), errors);
        dashboardLineCount2Validator.validateOn(value.getDashboardLineCount2(), errors);
        dashboardOrientationTypeCodeValidator.validateOn(value.getDashboardOrientationTypeCode(), errors);
        dashboardPanelCodeAValidator.validateOn(value.getDashboardPanelCodeA(), errors);
        dashboardPanelCodeBValidator.validateOn(value.getDashboardPanelCodeB(), errors);
        dashboardPanelCodeCValidator.validateOn(value.getDashboardPanelCodeC(), errors);
        dashboardPanelCodeDValidator.validateOn(value.getDashboardPanelCodeD(), errors);
        dashboardPanelCodeEValidator.validateOn(value.getDashboardPanelCodeE(), errors);
        dashboardPanelCodeFValidator.validateOn(value.getDashboardPanelCodeF(), errors);
        dashboardPanelCodeGValidator.validateOn(value.getDashboardPanelCodeG(), errors);
        dashboardRefreshMinutesValidator.validateOn(value.getDashboardRefreshMinutes(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        roleCodeValidator.validateOn(value.getRoleCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("member", "project");
        if ( !value.hasUser() )
            errors.addRequiredField("member", "user");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("member");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newDashboardLineCount1Validator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("member");
        e.setFieldName("dashboardLineCount1");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newDashboardLineCount2Validator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("member");
        e.setFieldName("dashboardLineCount2");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDashboardOrientationTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardOrientationTypeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDashboardPanelCodeAValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardPanelCodeA");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDashboardPanelCodeBValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardPanelCodeB");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeCValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardPanelCodeC");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeDValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardPanelCodeD");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeEValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardPanelCodeE");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeFValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardPanelCodeF");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeGValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("dashboardPanelCodeG");
        return e;
    }

    public KmIntegerValidator newDashboardRefreshMinutesValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("member");
        e.setFieldName("dashboardRefreshMinutes");
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("member");
        e.setFieldName("enabled");
        e.setRequired();
        return e;
    }

    public KmStringValidator newRoleCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("member");
        e.setFieldName("roleCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("member");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("member");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("member");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

