package com.kodemore.authnet.model;

public class KmAuthnetTransactionShipping
    extends KmAuthnetTransactionAbstractItem
{
    @Override
    protected String getXmlTag()
    {
        return "shipping";
    }
}
