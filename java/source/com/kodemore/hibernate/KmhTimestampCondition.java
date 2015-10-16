package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampInterval;

public class KmhTimestampCondition
    extends KmhPropertyCondition<KmTimestamp>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhTimestampCondition(KmhElement context, String property)
    {
        super(context, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isIn(KmTimestampInterval ti)
    {
        if ( ti.hasStart() )
            isGreaterThanOrEqualTo(ti.getStart());

        if ( ti.hasEnd() )
            isLessThanOrEqualTo(ti.getEnd());
    }

    public void isOn(KmDate e)
    {
        if ( e == null )
            isNull();
        else
            isIn(e.toTimestampInterval());
    }

}
