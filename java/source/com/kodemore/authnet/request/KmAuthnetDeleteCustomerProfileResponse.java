package com.kodemore.authnet.request;

import java.io.PrintWriter;

public class KmAuthnetDeleteCustomerProfileResponse
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
        super.printFieldsOn(out);
        out.println("======= Delete Customer Profile Response =======");
    }

}
