package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.utility.KmEnumIF;

public class KmhStringCondition
    extends KmhPropertyCondition<String>
{
    //##################################################
    //# constructor
    //##################################################

    public KmhStringCondition(KmhElement context, String parentAlias, String property)
    {
        super(context, parentAlias, property);
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public void hasPrefix(String s)
    {
        context().addPrefix(fullName(), s);
    }

    @Override
    public void isLike(String e)
    {
        context().addSuffix(fullName(), e);
    }

    @Override
    public void hasSuffix(String s)
    {
        context().addSuffix(fullName(), s);
    }

    @Override
    public void hasSubstring(String s)
    {
        context().addSubstring(fullName(), s);
    }

    //##################################################
    //# coded enum
    //##################################################

    public void is(KmEnumIF e)
    {
        if ( e == null )
            isNull();
        else
            is(e.getCode());
    }

    public void isNot(KmEnumIF e)
    {
        if ( e == null )
            isNotNull();
        else
            isNot(e.getCode());
    }
}
