package com.kodemore.hibernate;

import org.hibernate.criterion.Restrictions;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.time.KmUnitDuration;

public class KmhUnitDurationCondition
    extends KmhPropertyCondition<KmUnitDuration>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhUnitDurationCondition(KmhElement context, String parentAlias, String property)
    {
        super(context, parentAlias, property);
    }

    @Override
    public void isNot(KmUnitDuration e)
    {
        context()._add(Restrictions.not(Restrictions.eq(fullName(), e)));
    }
}
