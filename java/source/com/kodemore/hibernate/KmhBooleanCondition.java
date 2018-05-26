package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;

public class KmhBooleanCondition
    extends KmhPropertyCondition<Boolean>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhBooleanCondition(KmhElement context, String parentAlias, String property)
    {
        super(context, parentAlias, property);
    }

    //##################################################
    //# testing
    //##################################################

    public void isTrue()
    {
        context().addTrue(fullName());
    }

    public void isFalse()
    {
        context().addFalse(fullName());
    }

}
