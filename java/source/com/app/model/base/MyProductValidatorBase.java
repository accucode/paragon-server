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
 * Validation rules for product.
 */
public class MyProductValidatorBase
    extends MyDomainValidator<MyProduct>
{
    //##################################################
    //# static
    //##################################################

    public static final MyProductValidator instance = new MyProductValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator statusCodeValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator descriptionValidator;
    private KmMoneyValidator listPriceValidator;
    private KmBooleanValidator discountableValidator;
    private KmBooleanValidator taxableValidator;
    private KmMoneyValidator costValidator;
    private KmBooleanValidator requiresShipValidator;
    private KmStringValidator shipInstructionValidator;
    private KmStringValidator pickInstructionValidator;
    private KmIntegerValidator networkPortsProducedValidator;
    private KmIntegerValidator networkPortsConsumedValidator;
    private KmIntegerValidator poePortsProducedValidator;
    private KmIntegerValidator poePortsConsumedValidator;
    private KmIntegerValidator vendorPartNumberValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyProductValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        statusCodeValidator = newStatusCodeValidator();
        nameValidator = newNameValidator();
        descriptionValidator = newDescriptionValidator();
        listPriceValidator = newListPriceValidator();
        discountableValidator = newDiscountableValidator();
        taxableValidator = newTaxableValidator();
        costValidator = newCostValidator();
        requiresShipValidator = newRequiresShipValidator();
        shipInstructionValidator = newShipInstructionValidator();
        pickInstructionValidator = newPickInstructionValidator();
        networkPortsProducedValidator = newNetworkPortsProducedValidator();
        networkPortsConsumedValidator = newNetworkPortsConsumedValidator();
        poePortsProducedValidator = newPoePortsProducedValidator();
        poePortsConsumedValidator = newPoePortsConsumedValidator();
        vendorPartNumberValidator = newVendorPartNumberValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getDescriptionValidator()
    {
        return descriptionValidator;
    }

    public KmMoneyValidator getListPriceValidator()
    {
        return listPriceValidator;
    }

    public KmBooleanValidator getDiscountableValidator()
    {
        return discountableValidator;
    }

    public KmBooleanValidator getTaxableValidator()
    {
        return taxableValidator;
    }

    public KmMoneyValidator getCostValidator()
    {
        return costValidator;
    }

    public KmBooleanValidator getRequiresShipValidator()
    {
        return requiresShipValidator;
    }

    public KmStringValidator getShipInstructionValidator()
    {
        return shipInstructionValidator;
    }

    public KmStringValidator getPickInstructionValidator()
    {
        return pickInstructionValidator;
    }

    public KmIntegerValidator getNetworkPortsProducedValidator()
    {
        return networkPortsProducedValidator;
    }

    public KmIntegerValidator getNetworkPortsConsumedValidator()
    {
        return networkPortsConsumedValidator;
    }

    public KmIntegerValidator getPoePortsProducedValidator()
    {
        return poePortsProducedValidator;
    }

    public KmIntegerValidator getPoePortsConsumedValidator()
    {
        return poePortsConsumedValidator;
    }

    public KmIntegerValidator getVendorPartNumberValidator()
    {
        return vendorPartNumberValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyProduct value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setStatusCode(statusCodeValidator.convertOnly(value.getStatusCode()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setDescription(descriptionValidator.convertOnly(value.getDescription()));
        value.setListPrice(listPriceValidator.convertOnly(value.getListPrice()));
        value.setDiscountable(discountableValidator.convertOnly(value.getDiscountable()));
        value.setTaxable(taxableValidator.convertOnly(value.getTaxable()));
        value.setCost(costValidator.convertOnly(value.getCost()));
        value.setRequiresShip(requiresShipValidator.convertOnly(value.getRequiresShip()));
        value.setShipInstruction(shipInstructionValidator.convertOnly(value.getShipInstruction()));
        value.setPickInstruction(pickInstructionValidator.convertOnly(value.getPickInstruction()));
        value.setNetworkPortsProduced(networkPortsProducedValidator.convertOnly(value.getNetworkPortsProduced()));
        value.setNetworkPortsConsumed(networkPortsConsumedValidator.convertOnly(value.getNetworkPortsConsumed()));
        value.setPoePortsProduced(poePortsProducedValidator.convertOnly(value.getPoePortsProduced()));
        value.setPoePortsConsumed(poePortsConsumedValidator.convertOnly(value.getPoePortsConsumed()));
        value.setVendorPartNumber(vendorPartNumberValidator.convertOnly(value.getVendorPartNumber()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyProduct value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        statusCodeValidator.validateOnly(value.getStatusCode(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        descriptionValidator.validateOnly(value.getDescription(), errors);
        listPriceValidator.validateOnly(value.getListPrice(), errors);
        discountableValidator.validateOnly(value.getDiscountable(), errors);
        taxableValidator.validateOnly(value.getTaxable(), errors);
        costValidator.validateOnly(value.getCost(), errors);
        requiresShipValidator.validateOnly(value.getRequiresShip(), errors);
        shipInstructionValidator.validateOnly(value.getShipInstruction(), errors);
        pickInstructionValidator.validateOnly(value.getPickInstruction(), errors);
        networkPortsProducedValidator.validateOnly(value.getNetworkPortsProduced(), errors);
        networkPortsConsumedValidator.validateOnly(value.getNetworkPortsConsumed(), errors);
        poePortsProducedValidator.validateOnly(value.getPoePortsProduced(), errors);
        poePortsConsumedValidator.validateOnly(value.getPoePortsConsumed(), errors);
        vendorPartNumberValidator.validateOnly(value.getVendorPartNumber(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("product", "project"));
        if ( !value.hasMaster() )
            errors.add(new KmRequiredValidationError("product", "master"));
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
        e.setModel("product");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newStatusCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("product");
        e.setField("statusCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("product");
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
        e.setModel("product");
        e.setField("description");
        return e;
    }

    public KmMoneyValidator newListPriceValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("product");
        e.setField("listPrice");
        return e;
    }

    public KmBooleanValidator newDiscountableValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("product");
        e.setField("discountable");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newTaxableValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("product");
        e.setField("taxable");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newCostValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("product");
        e.setField("cost");
        return e;
    }

    public KmBooleanValidator newRequiresShipValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("product");
        e.setField("requiresShip");
        e.setRequired();
        return e;
    }

    public KmStringValidator newShipInstructionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("product");
        e.setField("shipInstruction");
        return e;
    }

    public KmStringValidator newPickInstructionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("product");
        e.setField("pickInstruction");
        return e;
    }

    public KmIntegerValidator newNetworkPortsProducedValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("product");
        e.setField("networkPortsProduced");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newNetworkPortsConsumedValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("product");
        e.setField("networkPortsConsumed");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newPoePortsProducedValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("product");
        e.setField("poePortsProduced");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newPoePortsConsumedValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("product");
        e.setField("poePortsConsumed");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newVendorPartNumberValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("product");
        e.setField("vendorPartNumber");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("product");
        e.setField("lockVersion");
        return e;
    }


}

