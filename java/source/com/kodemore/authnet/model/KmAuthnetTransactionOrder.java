package com.kodemore.authnet.model;

import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetTransactionOrder
{
    //##################################################
    //# variables
    //##################################################

    private String _invoiceNumber;
    private String _description;
    private String _poNumber;

    //##################################################
    //# invoice number
    //##################################################

    public String getInvoiceNumber()
    {
        return _invoiceNumber;
    }

    public void setInvoiceNumber(String e)
    {
        _invoiceNumber = e;
    }

    public boolean hasInvoiceNumber()
    {
        return _invoiceNumber != null;
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
    //# name
    //##################################################

    public String getPoNumber()
    {
        return _poNumber;
    }

    public void setPoNumber(String e)
    {
        _poNumber = e;
    }

    public boolean hasPoNumber()
    {
        return _poNumber != null;
    }

    //##################################################
    //# print xml
    //##################################################

    public void printXmlOn(KmXmlBuilder out)
    {
        out.begin("order");

        if ( hasInvoiceNumber() )
            out.value("invoiceNumber", getInvoiceNumber());

        if ( hasDescription() )
            out.value("description", getDescription());

        if ( hasPoNumber() )
            out.value("purchaseOrderNumber", getPoNumber());

        out.end();
    }

}
