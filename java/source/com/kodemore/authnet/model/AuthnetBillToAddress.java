package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetBillToAddress
    extends AuthnetAddress
{
    //##################################################
    //# print
    //##################################################

    @Override
    protected void printXmlGroupOn(KmXmlBuilder out)
    {
        out.begin("billTo");
    }

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        out.println("======= Bill To =======");
        super.printFieldsOn(out);
    }

}
