package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetShipToAddress
    extends AuthnetAddress
{
    @Override
    protected void printXmlGroupOn(KmXmlBuilder out)
    {
        out.begin("shipTo");
    }

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        out.println("======= Ship To =======");
        super.printFieldsOn(out);
    }

}
