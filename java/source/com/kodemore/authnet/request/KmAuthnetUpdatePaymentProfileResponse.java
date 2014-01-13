package com.kodemore.authnet.request;

import java.io.PrintWriter;

public class KmAuthnetUpdatePaymentProfileResponse
    extends KmAuthnetAbstractResponse
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
        out.println("======= Update Customer Payment Profile Response =======");
        super.printFieldsOn(out);
    }
}
