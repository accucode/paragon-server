package com.kodemore.authnet.model;

public class AuthnetTransactionTax
    extends AuthnetTransactionAbstractItem
{
    @Override
    protected String getXmlTag()
    {
        return "tax";
    }

}
