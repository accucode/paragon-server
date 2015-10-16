package com.app.model;

import com.kodemore.types.KmMoney;

import com.app.model.base.MySalesOrderBase;

public class MySalesOrder
    extends MySalesOrderBase
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrder()
    {
        super();
    }

    //##################################################
    //# updates
    //##################################################

    /**
     * Update the order totals based on the lines.
     * This does NOT recalculate information in the individual lines.
     */
    public void updateTotals()
    {
        KmMoney price = KmMoney.ZERO;
        KmMoney tax = KmMoney.ZERO;

        for ( MySalesOrderLine e : getLines() )
        {
            price.add(e.getTotalPrice());
            tax.add(e.getTax());
        }

        setTotalPrice(price);
        setTotalTax(tax);
    }

    @Override
    protected void handleTaxRateChange()
    {
        for ( MySalesOrderLine e : getLines() )
            e.updatePrice();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getNumber();
    }

}
