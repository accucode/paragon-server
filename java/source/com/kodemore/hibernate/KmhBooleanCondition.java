package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;

public class KmhBooleanCondition
    extends KmhPropertyCondition<Boolean>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhBooleanCondition(KmhElement context, String property)
    {
        super(context, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isTrue()
    {
        context().addTrue(property());
    }

    public void isFalse()
    {
        context().addFalse(property());
    }

}
