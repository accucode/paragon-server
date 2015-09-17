package com.kodemore.authnet.model;

import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetTransactionLineItem
{
    //##################################################
    //# constants
    //##################################################

    private static final String NOT_TAXABLE = "0";
    private static final String TAXABLE     = "1";

    //##################################################
    //# variables
    //##################################################

    private String     _itemId;
    private String     _name;
    private String     _description;
    private KmQuantity _quantity;
    private KmMoney    _unitPrice;
    private String     _taxable;

    //##################################################
    //# item id
    //##################################################

    public String getItemId()
    {
        return _itemId;
    }

    public void setItemId(String e)
    {
        _itemId = e;
    }

    public boolean hasItemId()
    {
        return _itemId != null;
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName()
    {
        return _name != null;
    }

    //##################################################
    //# description
    //##################################################

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public boolean hasDescription()
    {
        return _description != null;
    }

    //##################################################
    //# quantity
    //##################################################

    public KmQuantity getQuantity()
    {
        return _quantity;
    }

    public void setQuantity(KmQuantity e)
    {
        _quantity = e;
    }

    public boolean hasQuantity()
    {
        return _quantity != null;
    }

    //##################################################
    //# unit price
    //##################################################

    public KmMoney getUnitPrice()
    {
        return _unitPrice;
    }

    public void setUnitPrice(KmMoney e)
    {
        _unitPrice = e;
    }

    public boolean hasUnitPrice()
    {
        return _unitPrice != null;
    }

    //##################################################
    //# taxable
    //##################################################

    public String getTaxable()
    {
        return _taxable;
    }

    public void setTaxable()
    {
        _taxable = TAXABLE;
    }

    public void setNotTaxable()
    {
        _taxable = NOT_TAXABLE;
    }

    public boolean isTaxable()
    {
        return _taxable.equals(TAXABLE);
    }

    public boolean hasTaxable()
    {
        return _taxable != null;
    }

    //##################################################
    //# print xml
    //##################################################

    public void printXmlOn(KmXmlBuilder out)
    {
        out.begin("lineItems");

        if ( hasItemId() )
            out.value("itemId", getItemId());

        if ( hasName() )
            out.value("name", getName());

        if ( hasDescription() )
            out.value("description", getDescription());

        if ( hasQuantity() )
            out.value("quantity", getQuantity().format(2, false));

        if ( hasUnitPrice() )
            out.value("unitPrice", getUnitPrice().format(2, false));

        if ( hasTaxable() )
            out.value("taxable", getTaxable());

        out.end();
    }

}
