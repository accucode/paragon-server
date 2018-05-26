package com.app.filter.value;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.utility.KmEnumIF;

import com.app.model.MySite;

public class MyFilterSiteValue
    extends MyFilterValue<MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterSiteValue(KmEnumIF e)
    {
        super(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MySite getValue()
    {
        String uid = getStringValue();
        return getAccess().findSiteUid(uid);
    }

    @Override
    public void setValue(MySite e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        setStringValue(uid);
    }
}
