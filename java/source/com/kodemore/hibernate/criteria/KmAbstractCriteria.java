/*
  Copyright (c) 2005-2013 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.hibernate.criteria;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;

import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.utility.Kmu;

public abstract class KmAbstractCriteria
    implements KmCriteriaIF
{
    //##################################################
    //# variables
    //##################################################

    private KmAbstractCriteria _parent;

    //##################################################
    //# constructor
    //##################################################

    public KmAbstractCriteria(KmAbstractCriteria parent)
    {
        _parent = parent;
    }

    //##################################################
    //# tree
    //##################################################

    public KmRootCriteria getRoot()
    {
        return _parent.getRoot();
    }

    public KmCriteria getCriteria()
    {
        return _parent.getCriteria();
    }

    //##################################################
    //# where
    //##################################################

    public void addEqual(String property, Object value)
    {
        if ( value == null )
            addIsNull(property);
        else
            _add(Restrictions.eq(property, value));
    }

    public <V> void addEqual(KmMetaDaoPropertyIF<?,V> attr, V value)
    {
        addEqual(attr.getDaoPropertyName(), value);
    }

    public void addEqual(KmJoin join, String property, Object value)
    {
        addEqual(join.getFullName(property), value);
    }

    public void addNotEqual(String property, Object value)
    {
        if ( value == null )
            addIsNotNull(property);
        else
            _add(Restrictions.ne(property, value));
    }

    public <V> void addNotEqual(KmMetaDaoPropertyIF<?,V> attr, V value)
    {
        addNotEqual(attr.getDaoPropertyName(), value);
    }

    public void addNotEqual(KmJoin join, String property, Object value)
    {
        addNotEqual(join.getFullName(property), value);
    }

    public void addLessThan(String property, Object value)
    {
        _add(Restrictions.lt(property, value));
    }

    public void addLessThanOrEqualTo(String property, Object value)
    {
        _add(Restrictions.le(property, value));
    }

    public void addGreaterThan(String property, Object value)
    {
        _add(Restrictions.gt(property, value));
    }

    public void addGreaterThanOrEqualTo(String property, Object value)
    {
        _add(Restrictions.ge(property, value));
    }

    public void addLike(String property, String value)
    {
        _add(Restrictions.like(property, value));
    }

    public void addPrefix(String property, String value)
    {
        String s = formatLikePrefix(value);
        addLike(property, s);
    }

    public void addSuffix(String property, String value)
    {
        String s = formatLikeSuffix(value);
        addLike(property, s);
    }

    public void addSubstring(String property, String value)
    {
        String s = formatLikeSubstring(value);
        addLike(property, s);
    }

    public void addSubstring(KmJoin join, String property, String value)
    {
        addSubstring(join.getFullName(property), value);
    }

    public void addTrue(String property)
    {
        addEqual(property, true);
    }

    public void addFalse(String property)
    {
        addEqual(property, false);
    }

    public void addIsNull(String property, boolean isNull)
    {
        if ( isNull )
            addIsNull(property);
        else
            addIsNotNull(property);
    }

    public void addIsNull(String property)
    {
        _add(Restrictions.isNull(property));
    }

    public void addIsNotNull(String property)
    {
        _add(Restrictions.isNotNull(property));
    }

    //##################################################
    //# is in
    //##################################################

    public void addIsIn(String property, Object[] v)
    {
        if ( v == null || v.length == 0 )
            addFalse();
        else
            _add(Restrictions.in(property, v));
    }

    public void addIsIn(String property, Collection<?> v)
    {
        if ( v == null || v.isEmpty() )
            addFalse();
        else
            _add(Restrictions.in(property, v));
    }

    //##################################################
    //# is not in
    //##################################################

    public void addIsNotIn(String property, Object[] v)
    {
        if ( v == null || v.length == 0 )
            addTrue();
        else
            _add(Restrictions.not(Restrictions.in(property, v)));
    }

    public void addIsNotIn(String property, Collection<?> v)
    {
        if ( v == null || v.isEmpty() )
            addTrue();
        else
            _add(Restrictions.not(Restrictions.in(property, v)));
    }

    //##################################################
    //# junctions
    //##################################################

    public KmJunction addOr()
    {
        Junction j = Restrictions.disjunction();
        _add(j);
        return new KmJunction(this, j);
    }

    public KmJunction addAnd()
    {
        Junction j = Restrictions.conjunction();
        _add(j);
        return new KmJunction(this, j);
    }

    //##################################################
    //# boolean literals
    //##################################################

    public void addTrue()
    {
        _add(Restrictions.sqlRestriction("true"));
    }

    public void addFalse()
    {
        _add(Restrictions.sqlRestriction("false"));
    }

    //##################################################
    //# support
    //##################################################

    public abstract void _add(Criterion e);

    private String formatLikePrefix(String s)
    {
        s = escapeLike(s);
        return s + "%";
    }

    private String formatLikeSuffix(String s)
    {
        s = escapeLike(s);
        return "%" + s;
    }

    private String formatLikeSubstring(String s)
    {
        s = escapeLike(s);
        return "%" + s + "%";
    }

    private String escapeLike(String s)
    {
        return Kmu.replaceAll(s, "%", "\\%");
    }

    public String getFullName(String property)
    {
        return property;
    }

    //##################################################
    //# join
    //##################################################

    public KmJoin joinTo(String entityName)
    {
        return getRoot()._join(getCriteria(), entityName, Criteria.INNER_JOIN);
    }

    public KmJoin leftJoinTo(String entityName)
    {
        return getRoot()._join(getCriteria(), entityName, Criteria.LEFT_JOIN);
    }

}
