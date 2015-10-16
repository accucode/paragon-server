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
 * Validation rules for salesOrderLine.
 */
public class MySalesOrderLineValidatorBase
    extends MyDomainValidator<MySalesOrderLine>
{
    //##################################################
    //# static
    //##################################################

    public static final MySalesOrderLineValidator instance = new MySalesOrderLineValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmMoneyValidator listPriceValidator;
    private KmMoneyValidator unitPriceValidator;
    private KmIntegerValidator orderedQuantityValidator;
    private KmIntegerValidator fulfilledQuantityValidator;
    private KmMoneyValidator extendedPriceValidator;
    private KmMoneyValidator priceAdjustmentValidator;
    private KmMoneyValidator adjustedPriceValidator;
    private KmMoneyValidator taxValidator;
    private KmMoneyValidator totalPriceValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MySalesOrderLineValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        listPriceValidator = newListPriceValidator();
        unitPriceValidator = newUnitPriceValidator();
        orderedQuantityValidator = newOrderedQuantityValidator();
        fulfilledQuantityValidator = newFulfilledQuantityValidator();
        extendedPriceValidator = newExtendedPriceValidator();
        priceAdjustmentValidator = newPriceAdjustmentValidator();
        adjustedPriceValidator = newAdjustedPriceValidator();
        taxValidator = newTaxValidator();
        totalPriceValidator = newTotalPriceValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmMoneyValidator getListPriceValidator()
    {
        return listPriceValidator;
    }

    public KmMoneyValidator getUnitPriceValidator()
    {
        return unitPriceValidator;
    }

    public KmIntegerValidator getOrderedQuantityValidator()
    {
        return orderedQuantityValidator;
    }

    public KmIntegerValidator getFulfilledQuantityValidator()
    {
        return fulfilledQuantityValidator;
    }

    public KmMoneyValidator getExtendedPriceValidator()
    {
        return extendedPriceValidator;
    }

    public KmMoneyValidator getPriceAdjustmentValidator()
    {
        return priceAdjustmentValidator;
    }

    public KmMoneyValidator getAdjustedPriceValidator()
    {
        return adjustedPriceValidator;
    }

    public KmMoneyValidator getTaxValidator()
    {
        return taxValidator;
    }

    public KmMoneyValidator getTotalPriceValidator()
    {
        return totalPriceValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MySalesOrderLine value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setListPrice(listPriceValidator.convertOnly(value.getListPrice()));
        value.setUnitPrice(unitPriceValidator.convertOnly(value.getUnitPrice()));
        value.setOrderedQuantity(orderedQuantityValidator.convertOnly(value.getOrderedQuantity()));
        value.setFulfilledQuantity(fulfilledQuantityValidator.convertOnly(value.getFulfilledQuantity()));
        value.setExtendedPrice(extendedPriceValidator.convertOnly(value.getExtendedPrice()));
        value.setPriceAdjustment(priceAdjustmentValidator.convertOnly(value.getPriceAdjustment()));
        value.setAdjustedPrice(adjustedPriceValidator.convertOnly(value.getAdjustedPrice()));
        value.setTax(taxValidator.convertOnly(value.getTax()));
        value.setTotalPrice(totalPriceValidator.convertOnly(value.getTotalPrice()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MySalesOrderLine value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        listPriceValidator.validateOnly(value.getListPrice(), errors);
        unitPriceValidator.validateOnly(value.getUnitPrice(), errors);
        orderedQuantityValidator.validateOnly(value.getOrderedQuantity(), errors);
        fulfilledQuantityValidator.validateOnly(value.getFulfilledQuantity(), errors);
        extendedPriceValidator.validateOnly(value.getExtendedPrice(), errors);
        priceAdjustmentValidator.validateOnly(value.getPriceAdjustment(), errors);
        adjustedPriceValidator.validateOnly(value.getAdjustedPrice(), errors);
        taxValidator.validateOnly(value.getTax(), errors);
        totalPriceValidator.validateOnly(value.getTotalPrice(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasSalesOrder() )
            errors.add(new KmRequiredValidationError("salesOrderLine", "salesOrder"));
        if ( !value.hasProduct() )
            errors.add(new KmRequiredValidationError("salesOrderLine", "product"));
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
        e.setModel("salesOrderLine");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newListPriceValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrderLine");
        e.setField("listPrice");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newUnitPriceValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrderLine");
        e.setField("unitPrice");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newOrderedQuantityValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("salesOrderLine");
        e.setField("orderedQuantity");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newFulfilledQuantityValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("salesOrderLine");
        e.setField("fulfilledQuantity");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newExtendedPriceValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrderLine");
        e.setField("extendedPrice");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newPriceAdjustmentValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrderLine");
        e.setField("priceAdjustment");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newAdjustedPriceValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrderLine");
        e.setField("adjustedPrice");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newTaxValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrderLine");
        e.setField("tax");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newTotalPriceValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrderLine");
        e.setField("totalPrice");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("salesOrderLine");
        e.setField("lockVersion");
        return e;
    }


}

