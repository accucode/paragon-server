package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmDuration;

public class KmhDurationCondition
    extends KmhPropertyCondition<KmDuration>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhDurationCondition(KmhElement context, String property)
    {
        super(context, property);
    }

}
