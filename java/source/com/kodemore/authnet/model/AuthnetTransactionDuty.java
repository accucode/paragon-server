package com.kodemore.authnet.model;

public class AuthnetTransactionDuty
    extends AuthnetTransactionAbstractItem
{
    @Override
    protected String getXmlTag()
    {
        return "duty";
    }

}
