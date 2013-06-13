package com.kodemore.hibernate.criteria;

import java.util.Collection;

public class KmPropertyCriteria<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmAbstractCriteria _context;
    private String             _property;

    //##################################################
    //# constructor
    //##################################################

    public KmPropertyCriteria(KmAbstractCriteria context, String property)
    {
        _context = context;
        _property = property;
    }

    //##################################################
    //# accessing
    //##################################################

    public void is(T e)
    {
        context().addEqual(property(), e);
    }

    public void isNot(T e)
    {
        context().addNotEqual(property(), e);
    }

    public void isLessThan(T e)
    {
        context().addLessThan(property(), e);
    }

    public void isLessThanOrEqualTo(T e)
    {
        context().addLessThanOrEqualTo(property(), e);
    }

    public void isGreaterThan(T e)
    {
        context().addGreaterThan(property(), e);
    }

    public void isGreaterThanOrEqualTo(T e)
    {
        context().addGreaterThanOrEqualTo(property(), e);
    }

    public void isNull()
    {
        context().addIsNull(property());
    }

    public void isNull(boolean isNull)
    {
        if ( isNull )
            isNull();
        else
            isNotNull();
    }

    public void isNotNull()
    {
        context().addIsNotNull(property());
    }

    public void isNotNull(boolean isNotNull)
    {
        isNull(!isNotNull);
    }

    public void isIn(Collection<?> v)
    {
        context().addIsIn(property(), v);
    }

    public void isNotIn(Collection<?> v)
    {
        context().addIsNotIn(property(), v);
    }

    //##################################################
    //# string
    //##################################################

    public void hasPrefix(String s)
    {
        context().addPrefix(property(), s);
    }

    public void isLike(String e)
    {
        context().addSuffix(property(), e);
    }

    public void hasSuffix(String s)
    {
        context().addSuffix(property(), s);
    }

    public void hasSubstring(String s)
    {
        context().addSubstring(property(), s);
    }

    //##################################################
    //# support
    //##################################################

    protected KmAbstractCriteria context()
    {
        return _context;
    }

    protected String property()
    {
        return _property;
    }

}
