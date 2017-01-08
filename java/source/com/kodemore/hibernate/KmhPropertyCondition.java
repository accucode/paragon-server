package com.kodemore.hibernate;

import java.util.Collection;

import com.kodemore.hibernate.basic.KmhElement;

public class KmhPropertyCondition<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmhElement _context;
    private String     _property;

    //##################################################
    //# constructor
    //##################################################

    public KmhPropertyCondition(KmhElement context, String property)
    {
        _context = context;
        _property = property;
    }

    /**
     * In most cases the context is provided in the constructor.
     * In order to handle compound junctions that combine multiple contexts
     * the framework may override the initial context with a different one
     * is some circumstances.
     */
    protected void _setContext(KmhElement e)
    {
        _context = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public void equalsProperty(String propertyName)
    {
        context().addEqualProperty(property(), propertyName);
    }

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

    //##################################################
    //# is in
    //##################################################

    @SuppressWarnings("unchecked")
    public void isIn(T... arr)
    {
        context().addIsIn(property(), arr);
    }

    @SuppressWarnings("unchecked")
    public void isNotIn(T... arr)
    {
        context().addIsNotIn(property(), arr);
    }

    public void isIn(Collection<T> v)
    {
        context().addIsIn(property(), v);
    }

    public void isNotIn(Collection<T> v)
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

    protected KmhElement context()
    {
        return _context;
    }

    protected String property()
    {
        return _property;
    }

}
