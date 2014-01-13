package com.kodemore.authnet.request;

import java.io.PrintWriter;

public class KmAuthnetCreatePaymentProfileResponse
    extends KmAuthnetAbstractResponse
{
    //##################################################
    //# variables
    //##################################################

    private Integer _paymentProfileId;

    //##################################################
    //# accessing
    //##################################################

    public Integer getPaymentProfileId()
    {
        return _paymentProfileId;
    }

    public void setPaymentProfileId(Integer e)
    {
        _paymentProfileId = e;
    }

    public boolean hasPaymentProfileId()
    {
        return _paymentProfileId != null;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    protected void parseXml()
    {
        super.parseXml();
        _paymentProfileId = getIntegerAt("customerPaymentProfileId");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        super.printFieldsOn(out);
        out.println("======= Create Payment Profile =======");
        out.println("payment profile id: " + getPaymentProfileId());
    }

}
