package com.kodemore.hibernate.criteria;

public class KmBooleanCriteria
    extends KmPropertyCriteria<Boolean>
{
    //##################################################
    //# constructor
    //##################################################

    public KmBooleanCriteria(KmAbstractCriteria context, String property)
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
