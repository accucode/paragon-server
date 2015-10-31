package com.app.model;

import com.kodemore.types.KmMoney;

import com.app.model.base.MySalesOrderLineBase;

public class MySalesOrderLine
    extends MySalesOrderLineBase
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderLine()
    {
        super();
    }

    //##################################################
    //# price
    //##################################################

    /**
     * Update the price, recalculating it based on current attributes
     * in the order and line.
     */
    public void updatePricing()
    {
        KmMoney listPrice = getProduct().getListPrice();

        Double discountRate = getEffectiveDiscountRate();
        KmMoney discount = listPrice.multiply(discountRate);
        KmMoney unitPrice = listPrice.subtract(discount);

        Integer qty = getOrderedQuantity();
        KmMoney extendedPrice = unitPrice.multiply(qty);

        KmMoney adj = getPriceAdjustment();
        KmMoney adjustedPrice = extendedPrice.add(adj);

        KmMoney tax = adjustedPrice.multiply(getEffectiveTaxRate());
        KmMoney totalPrice = adjustedPrice.add(tax);

        setListPrice(listPrice);
        setUnitPrice(unitPrice);
        setExtendedPrice(extendedPrice);
        setAdjustedPrice(adjustedPrice);
        setTax(tax);
        setTotalPrice(totalPrice);
    }

    private double getEffectiveTaxRate()
    {
        if ( !hasSalesOrder() )
            return 0.0;

        if ( getSalesOrder().isTaxExempt() )
            return 0.0;

        if ( getProduct().isNotTaxable() )
            return 0.0;

        return getSalesOrder().getTaxRate();
    }

    private double getEffectiveDiscountRate()
    {
        if ( getProduct().isNotDiscountable() )
            return 0.0;

        return getSalesOrder().getDiscountRate();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getProduct().getPartNumber();
    }

}
