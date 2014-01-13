package com.kodemore.authnet.request;

import java.io.PrintWriter;

public class KmAuthnetUpdateCustomerProfileResponse
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
        out.println("======= update Customer Profile Response =======");
        super.printFieldsOn(out);
    }
}
