package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;

public class KmhIntegerCondition
    extends KmhPropertyCondition<Integer>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhIntegerCondition(KmhElement context, String property)
    {
        super(context, property);
    }
}
