package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateRange;

public class KmhDateCondition
    extends KmhPropertyCondition<KmDate>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhDateCondition(KmhElement context, String parentAlias, String property)
    {
        super(context, parentAlias, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isIn(KmDateRange di)
    {
        if ( di.hasStart() )
            context().addGreaterThanOrEqualTo(fullName(), di.getStart());

        if ( di.hasEnd() )
            context().addLessThanOrEqualTo(fullName(), di.getEnd());
    }
}
