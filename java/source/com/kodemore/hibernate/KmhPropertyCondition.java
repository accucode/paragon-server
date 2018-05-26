package com.kodemore.hibernate;

import java.util.Collection;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.basic.KmhElement;

public class KmhPropertyCondition<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmhElement _context;

    /**
     * The alias hibernate uses to identify the property's parent/table.
     *
     * In most cases this is a non-null value that is combined with the property.
     * For example: user.name (alias.property).
     *
     * NOTE, the alias is NOT necessarily the actual alias that hibernate
     * generates for the SQL. For special cases that format the raw sql text,
     * you must use the inline {alias} macro instead of this value.
     */
    private String _parentAlias;

    /**
     * The hibernate property, WITHOUT an alias prefix.
     * In most cases, the property should be combined with the alias
     * to get the fullName. However, the stand alone property is needed
     * when composing raw sql.
     */
    private String _property;

    //##################################################
    //# constructor
    //##################################################

    public KmhPropertyCondition(KmhElement context, String parentAlias, String property)
    {
        _context = context;
        _parentAlias = parentAlias;
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

    protected KmhElement context()
    {
        return _context;
    }

    protected String parentAlias()
    {
        return _parentAlias;
    }

    protected boolean hasParentAlias()
    {
        return _parentAlias != null;
    }

    protected String property()
    {
        return _property;
    }

    protected String fullName()
    {
        return hasParentAlias()
            ? parentAlias() + "." + property()
            : property();
    }

    //##################################################
    //# equals
    //##################################################

    public void equalsProperty(String propertyName)
    {
        context().addEqualProperty(propertyName, fullName());
    }

    public void notEqualsProperty(String propertyName)
    {
        context().addNotEqualProperty(propertyName, fullName());
    }

    public void is(T e)
    {
        context().addEqual(fullName(), e);
    }

    public void isNot(T e)
    {
        context().addNotEqual(fullName(), e);
    }

    public void isLessThan(T e)
    {
        context().addLessThan(fullName(), e);
    }

    public void isLessThanOrEqualTo(T e)
    {
        context().addLessThanOrEqualTo(fullName(), e);
    }

    public void isGreaterThan(T e)
    {
        context().addGreaterThan(fullName(), e);
    }

    public void isGreaterThanOrEqualTo(T e)
    {
        context().addGreaterThanOrEqualTo(fullName(), e);
    }

    public void isNull()
    {
        context().addIsNull(fullName());
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
        context().addIsNotNull(fullName());
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
        context().addIsIn(fullName(), arr);
    }

    @SuppressWarnings("unchecked")
    public void isNotIn(T... arr)
    {
        context().addIsNotIn(fullName(), arr);
    }

    public void isIn(Collection<T> v)
    {
        context().addIsIn(fullName(), v);
    }

    public void isNotIn(Collection<T> v)
    {
        context().addIsNotIn(fullName(), v);
    }

    //##################################################
    //# string
    //##################################################

    public void hasPrefix(String s)
    {
        context().addPrefix(fullName(), s);
    }

    public void isLike(String e)
    {
        context().addSuffix(fullName(), e);
    }

    public void hasSuffix(String s)
    {
        context().addSuffix(fullName(), s);
    }

    public void hasSubstring(String s)
    {
        context().addSubstring(fullName(), s);
    }

    //##################################################
    //# match against fulltext
    //##################################################

    public void matches(KmList<String> included)
    {
        context().matches(property(), included);
    }

    public void matches(KmList<String> included, KmList<String> excluded)
    {
        context().matches(property(), included, excluded);
    }

}
