package com.kodemore.authnet.request;

import java.io.PrintWriter;

public class AuthnetDeletePaymentProfileResponse
    extends AuthnetAbstractResponse
{
    //##################################################
    //# parse
    //##################################################

    @Override
    protected void parseXml()
    {
        super.parseXml();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        super.printFieldsOn(out);
        out.println("======= Delete Payment Profile Response =======");
    }

}
