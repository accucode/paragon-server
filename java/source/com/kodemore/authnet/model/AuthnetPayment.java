package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.xml.utility.KmXmlBuilder;

public abstract class AuthnetPayment
{
    //##################################################
    //# constants
    //##################################################

    public static final Integer PAYMENT_TYPE_CREDIT_CARD  = 1;
    public static final Integer PAYMENT_TYPE_BANK_ACCOUNT = 2;

    //##################################################
    //# accessing
    //##################################################

    protected abstract Integer getType();

    //##################################################
    //# validate
    //##################################################

    public boolean isValid()
    {
        return true;
    }

    //##################################################
    //# print
    //##################################################

    public abstract void printFieldsOn(PrintWriter out);

    protected void printXmlOn(KmXmlBuilder out)
    {
        out.begin("payment");
        printInternalXmlOn(out);
        out.end();
    }

    protected abstract void printInternalXmlOn(KmXmlBuilder out);
}
