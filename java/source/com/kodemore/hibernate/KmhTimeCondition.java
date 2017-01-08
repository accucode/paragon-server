package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimeInterval;

public class KmhTimeCondition
    extends KmhPropertyCondition<KmDate>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhTimeCondition(KmhElement context, String property)
    {
        super(context, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isIn(KmTimeInterval ti)
    {
        if ( ti.hasStart() )
            context().addGreaterThanOrEqualTo(property(), ti.getStart());

        if ( ti.hasEnd() )
            context().addLessThanOrEqualTo(property(), ti.getEnd());
    }
}
