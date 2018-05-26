package com.app.filter.value;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.utility.KmEnumIF;

import com.app.model.MyCustomer;

public class MyFilterCustomerValue
    extends MyFilterValue<MyCustomer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterCustomerValue(KmEnumIF e)
    {
        super(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyCustomer getValue()
    {
        String uid = getStringValue();
        return getAccess().findCustomerUid(uid);
    }

    @Override
    public void setValue(MyCustomer e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        setStringValue(uid);
    }
}
