/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;

import com.kodemore.hibernate.proxy.KmhProxy;

/**
 * I provide much of the common behavior for different types of criteria.
 * I can be used to compose queries for both (attached) criteria and detached
 */
public abstract class KmhCriteria
    extends KmhElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * A proxy for the either a Criteria or a DetachedCriteria.
     * We use a proxy so that a single implementation can provide
     * various convenience methods for both types of criteria.
     */
    private KmhProxy _proxy;

    /**
     * Indicates if any sorting has been applied.
     * This is tracked because hibernate does not provide any methods to
     * inspect the criteria in order to determine if sorting has been applied.
     */
    private boolean _sorted;

    //##################################################
    //# constructor
    //##################################################

    public KmhCriteria(KmhProxy e)
    {
        _proxy = e;
    }

    public KmhCriteria(Criteria e)
    {
        _proxy = KmhProxy.create(e);
    }

    public KmhCriteria(DetachedCriteria e)
    {
        _proxy = KmhProxy.create(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmhProxy getProxy()
    {
        return _proxy;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public abstract KmhRootCriteria getRoot();

    @Override
    public KmhCriteria getCriteria()
    {
        return this;
    }

    @Override
    public void _add(Criterion e)
    {
        _proxy.add(e);
    }

    //##################################################
    //# join
    //##################################################

    public KmhJoin joinTo(String entityName)
    {
        return getRoot()._join(getCriteria(), entityName, JoinType.INNER_JOIN);
    }

    public KmhJoin leftJoinTo(String entityName)
    {
        return getRoot()._join(getCriteria(), entityName, JoinType.LEFT_OUTER_JOIN);
    }

    //##################################################
    //# sort
    //##################################################

    public void sort(boolean asc, String... properties)
    {
        if ( asc )
            sortAscending(properties);
        else
            sortDescending(properties);
    }

    public void sortBy(String... properties)
    {
        sortAscending(properties);
    }

    public void sortAscending(String... properties)
    {
        for ( String e : properties )
            _sortOn(Order.asc(e));
    }

    public void sortDescending(String... properties)
    {
        for ( String e : properties )
            _sortOn(Order.desc(e));
    }

    private void _sortOn(Order o)
    {
        _sorted = true;
        _proxy.addOrder(o);
    }

    public boolean isSorted()
    {
        return _sorted;
    }

    //##################################################
    //# alias
    //##################################################

    public String getAlias()
    {
        return _proxy.getAlias();
    }

    @Override
    public String getFullName(String property)
    {
        return getAlias() + "." + property;
    }

    //##################################################
    //# projections
    //##################################################

    public void addProjection(Projection e)
    {
        getRoot().addProjection(e);
    }

    //##################################################
    //# projections (select)
    //##################################################

    public void select(String name)
    {
        Projection e;
        e = Projections.property(getFullName(name));
        addProjection(e);
    }

    public void selectDistinct(String name)
    {
        Projection e;
        e = Projections.property(getFullName(name));
        e = Projections.distinct(e);
        addProjection(e);
    }

    public void selectCountDistinct(String name)
    {
        Projection e;
        e = Projections.countDistinct(getFullName(name));
        addProjection(e);
    }

    public void selectMinimum(String name)
    {
        Projection e;
        e = Projections.min(getFullName(name));
        addProjection(e);
    }

    public void selectMaximum(String name)
    {
        Projection e;
        e = Projections.max(getFullName(name));
        addProjection(e);
    }

    public void selectAverage(String name)
    {
        Projection e;
        e = Projections.avg(getFullName(name));
        addProjection(e);
    }

    public void selectSum(String name)
    {
        Projection e;
        e = Projections.sum(getFullName(name));
        addProjection(e);
    }

    public void selectRowCount()
    {
        Projection e;
        e = Projections.rowCount();
        addProjection(e);
    }

    public void groupBy(String name)
    {
        Projection e;
        e = Projections.groupProperty(getFullName(name));
        addProjection(e);
    }
}
