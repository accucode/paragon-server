/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.hibernate.basic;

import java.util.Collection;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public abstract class KmhElement
{
    //##################################################
    //# constructor
    //##################################################

    public KmhElement()
    {
        // none
    }

    //##################################################
    //# tree
    //##################################################

    /**
     * Return the single root associated with this element hierarchy.
     */
    public abstract KmhRootCriteria getRoot();

    /**
     * Return the criteria.  In many cases, this is simply myself.  However,
     * joins and junctions return a reference to the associated criteria.
     */
    public abstract KmhCriteria getCriteria();

    /**
     * Add a criterion to the appropriate context.
     */
    public abstract void _add(Criterion e);

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

    public void addNotEqual(String property, Object value)
    {
        if ( value == null )
            addIsNotNull(property);
        else
            _add(Restrictions.ne(property, value));
    }

    public void addEqualProperty(String property1, String property2)
    {
        _add(Restrictions.eqProperty(property1, property2));
    }

    public void addNotEqualProperty(String property1, String property2)
    {
        _add(Restrictions.neProperty(property1, property2));
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

    public void addSubstring(KmhJoin join, String property, String value)
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
    //# match against fulltext
    //##################################################

    public void matches(String property, KmList<String> included)
    {
        KmList<String> excluded = KmList.createEmpty();
        matches(property, included, excluded);
    }

    /**
     * Perform a boolean fulltext search against a set of terms.
     * The column being searched must have a FULLTEXT index.
     */
    public void matches(String property, KmList<String> included, KmList<String> excluded)
    {
        KmList<String> terms;
        terms = new KmList<>();
        terms.addAll(included.collect(e -> "+" + e));
        terms.addAll(excluded.collect(e -> "-" + e));

        String against = terms.join(" ");
        String sql = Kmu.format("match({alias}.%s) against(? in boolean mode)", property);

        Criterion restriction = Restrictions.sqlRestriction(sql, against, StringType.INSTANCE);
        _add(restriction);
    }

    //##################################################
    //# is in
    //##################################################

    public void addIsIn(String property, Object[] arr)
    {
        if ( arr == null || arr.length == 0 )
        {
            addFalse();
            return;
        }

        if ( arr.length == 1 )
        {
            addEqual(property, arr[0]);
            return;
        }

        _add(Restrictions.in(property, arr));
    }

    public void addIsIn(String property, Collection<?> v)
    {
        if ( v == null )
            addFalse();
        else
            addIsIn(property, v.toArray());
    }

    //##################################################
    //# is not in
    //##################################################

    public void addIsNotIn(String property, Object[] arr)
    {
        if ( arr == null || arr.length == 0 )
        {
            addTrue();
            return;
        }

        if ( arr.length == 1 )
        {
            addNotEqual(property, arr[0]);
            return;
        }

        _add(Restrictions.not(Restrictions.in(property, arr)));
    }

    public void addIsNotIn(String property, Collection<?> v)
    {
        if ( v == null )
            addTrue();
        else
            addIsNotIn(property, v.toArray());
    }

    //##################################################
    //# junctions
    //##################################################

    public KmhJunction addAnd()
    {
        Junction j = Restrictions.conjunction();
        _add(j);
        return new KmhJunction(this, j);
    }

    public KmhJunction addOr()
    {
        Junction j = Restrictions.disjunction();
        _add(j);
        return new KmhJunction(this, j);
    }

    //##################################################
    //# junctions (not)
    //##################################################

    public KmhJunction addNotAnd()
    {
        Junction j = Restrictions.conjunction();
        Criterion not = Restrictions.not(j);
        _add(not);
        return new KmhJunction(this, j);
    }

    public KmhJunction addNotOr()
    {
        Junction j = Restrictions.disjunction();
        Criterion not = Restrictions.not(j);
        _add(not);
        return new KmhJunction(this, j);
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

    //##################################################
    //# property
    //##################################################

    public String getAlias()
    {
        return null;
    }

    public final boolean hasAlias()
    {
        return getAlias() != null;
    }

    public final String getFullName(String property)
    {
        return hasAlias()
            ? getAlias() + "." + property
            : property;
    }

}
