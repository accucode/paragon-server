package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateRange;
import com.kodemore.time.KmMonth;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampRange;

public class KmhTimestampCondition
    extends KmhPropertyCondition<KmTimestamp>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhTimestampCondition(KmhElement context, String parentAlias, String property)
    {
        super(context, parentAlias, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isIn(KmTimestampRange tsr)
    {
        if ( tsr.hasStart() )
            isGreaterThanOrEqualTo(tsr.getStart());

        if ( tsr.hasEnd() )
            isLessThanOrEqualTo(tsr.getEnd());
    }

    public void isIn(KmDateRange dr)
    {
        isIn(dr.toTimestampRange());
    }

    public void isIn(KmMonth e)
    {
        isIn(e.toTimestampRange());
    }

    public void isOn(KmDate e)
    {
        if ( e == null )
            isNull();
        else
            isIn(e.toTimestampInterval());
    }

}
