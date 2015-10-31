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
    //# accessing :: convenience
    //##################################################

    public void addLine(int qty, MyProduct product)
    {
        MySalesOrderLine line;
        line = addLine();
        line.setOrderedQuantity(qty);
        line.setProduct(product);
        line.updatePricing();
        line.attachDao();

        updateTotals();
    }

    //##################################################
    //# updates
    //##################################################

    public void updatePricing()
    {
        for ( MySalesOrderLine e : getLines() )
            e.updatePricing();

        updateTotals();
    }

    /**
     * Update the order totals based on the lines.
     * This does NOT recalculate information in the individual lines.
     */
    private void updateTotals()
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

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getNumber();
    }

}
