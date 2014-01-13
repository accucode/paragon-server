package com.kodemore.authnet.request;

import java.io.PrintWriter;

public class KmAuthnetCreateCustomerProfileResponse
    extends KmAuthnetAbstractResponse
{
    //##################################################
    //# variables
    //##################################################

    private Integer _customerProfileId;

    //##################################################
    //# accessing
    //##################################################

    public Integer getCustomerProfileId()
    {
        return _customerProfileId;
    }

    public void setCustomerProfileId(Integer customerProfileId)
    {
        _customerProfileId = customerProfileId;
    }

    public boolean hasCustomerProfileId()
    {
        return _customerProfileId != null;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    protected void parseXml()
    {
        super.parseXml();
        _customerProfileId = getIntegerAt("customerProfileId");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        super.printFieldsOn(out);
        out.println("======= Create Customer Profile =======");
        out.println("customer profile id: " + getCustomerProfileId());

    }

}
