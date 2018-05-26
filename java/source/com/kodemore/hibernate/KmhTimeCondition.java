package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimeRange;

public class KmhTimeCondition
    extends KmhPropertyCondition<KmDate>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhTimeCondition(KmhElement context, String parentAlias, String property)
    {
        super(context, parentAlias, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isIn(KmTimeRange ti)
    {
        if ( ti.hasStart() )
            context().addGreaterThanOrEqualTo(fullName(), ti.getStart());

        if ( ti.hasEnd() )
            context().addLessThanOrEqualTo(fullName(), ti.getEnd());
    }
}
