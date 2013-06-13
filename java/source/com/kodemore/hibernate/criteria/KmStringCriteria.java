package com.kodemore.hibernate.criteria;

import com.kodemore.utility.KmCodedEnumIF;

public class KmStringCriteria
    extends KmPropertyCriteria<String>
{
    //##################################################
    //# constructor
    //##################################################

    public KmStringCriteria(KmAbstractCriteria context, String property)
    {
        super(context, property);
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public void hasPrefix(String s)
    {
        context().addPrefix(property(), s);
    }

    @Override
    public void isLike(String e)
    {
        context().addSuffix(property(), e);
    }

    @Override
    public void hasSuffix(String s)
    {
        context().addSuffix(property(), s);
    }

    @Override
    public void hasSubstring(String s)
    {
        context().addSubstring(property(), s);
    }

    //##################################################
    //# coded enum
    //##################################################

    public void is(KmCodedEnumIF e)
    {
        if ( e == null )
            isNull();
        else
            is(e.getCode());
    }

    public void isNot(KmCodedEnumIF e)
    {
        if ( e == null )
            isNotNull();
        else
            isNot(e.getCode());
    }

}
