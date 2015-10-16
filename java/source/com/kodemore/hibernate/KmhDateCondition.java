package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateInterval;

public class KmhDateCondition
    extends KmhPropertyCondition<KmDate>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhDateCondition(KmhElement context, String property)
    {
        super(context, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isIn(KmDateInterval di)
    {
        if ( di.hasStart() )
            context().addGreaterThanOrEqualTo(property(), di.getStart());

        if ( di.hasEnd() )
            context().addLessThanOrEqualTo(property(), di.getEnd());
    }
}
