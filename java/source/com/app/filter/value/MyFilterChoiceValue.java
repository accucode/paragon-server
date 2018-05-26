package com.app.filter.value;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.utility.KmEnumIF;

import com.app.model.MyChoice;

public class MyFilterChoiceValue
    extends MyFilterValue<MyChoice>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterChoiceValue(KmEnumIF e)
    {
        super(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyChoice getValue()
    {
        String uid = getStringValue();
        return getAccess().findChoiceUid(uid);
    }

    @Override
    public void setValue(MyChoice e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        setStringValue(uid);
    }
}
