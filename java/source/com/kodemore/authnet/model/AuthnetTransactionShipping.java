package com.kodemore.authnet.model;

public class AuthnetTransactionShipping
    extends AuthnetTransactionAbstractItem
{
    @Override
    protected String getXmlTag()
    {
        return "shipping";
    }
}
