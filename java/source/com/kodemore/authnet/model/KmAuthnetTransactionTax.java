package com.kodemore.authnet.model;

public class KmAuthnetTransactionTax
    extends KmAuthnetTransactionAbstractItem
{
    @Override
    protected String getXmlTag()
    {
        return "tax";
    }

}
