package com.app.filter.value;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.utility.KmEnumIF;

import com.app.model.MyProject;

public class MyFilterProjectValue
    extends MyFilterValue<MyProject>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterProjectValue(KmEnumIF e)
    {
        super(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProject getValue()
    {
        String uid = getStringValue();
        return getAccess().findProjectUid(uid);
    }

    @Override
    public void setValue(MyProject e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        setStringValue(uid);
    }
}
