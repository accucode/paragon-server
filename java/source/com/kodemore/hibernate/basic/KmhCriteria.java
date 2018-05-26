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

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

import com.kodemore.hibernate.proxy.KmhProxy;
import com.kodemore.utility.Kmu;

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

    @Override
    public final String getAlias()
    {
        return _proxy.getAlias();
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

    /**
     * Group on the year of a date or timestamp. For example, if you have
     * a column: createdUtcTs, then you can use groupByYear('createdUtcTs')
     * to group on the created year.
     *
     * This DOES work, but only when it applies to the primary
     * criteria. The reason for this limitation is the combination
     * of these two factors:
     *
     * 1) The underlying hibernate framework only allows you to call
     *      setProjections(...) once, so you can only call it on ONE
     *      criteria per statement.
     *
     * 2) The {alias} macro is filled in by hibernate based on which
     *      criteria you add the projections to. The Km framework currently
     *      adds the projects to the root criteria, so that is what hibernate
     *      uses to fill in the alias.
     *
     * In practice, this limitation may not be significant for two reasons
     *
     *  1) When you want to do a groupBy, it is usually on something in the
     *      root critieria anyway.
     *
     *  2) You can work around this limitation by grouping directly on a
     *      column, rather than on a function. The Km framework makes this
     *      easy via the autogenerated dependencies. For example if you want
     *      to group by year(createdUtcTs) then you can simply create a createdUtcYear
     *      column and just keep it in sync with the utcTs. Then you can use the
     *      groupBy(column) and the problem goes away. This approach also has
     *      a significant performance benefit since the database generally cannot
     *      optimize queries or utilize indexes when grouping on a function.
     */
    public void groupByYear(String name)
    {
        String alias = "yy";
        String select = Kmu.format("year({alias}.%s) as %s", name, alias);
        String groupBy = alias;
        String[] aliases = new String[]
        {
            alias
        };
        Type[] types = new Type[]
        {
            IntegerType.INSTANCE
        };

        Projection e;
        e = Projections.sqlGroupProjection(select, groupBy, aliases, types);
        addProjection(e);
    }

    /**
     * @see #groupByYear(String)
     */
    public void groupByMonth(String name)
    {
        String alias = "mm";
        String select = Kmu.format("month({alias}.%s) as %s", name, alias);
        String groupBy = alias;
        String[] aliases = new String[]
        {
            alias
        };
        Type[] types = new Type[]
        {
            IntegerType.INSTANCE
        };

        Projection e;
        e = Projections.sqlGroupProjection(select, groupBy, aliases, types);
        addProjection(e);
    }

    /**
     * @see #groupByYear(String)
     */
    public void groupBySqlDate(String name)
    {
        String alias = "dt";
        String select = Kmu.format("date({alias}.%s) as %s", name, alias);
        String groupBy = alias;
        String[] aliases = new String[]
        {
            alias
        };
        Type[] types = new Type[]
        {
            DateType.INSTANCE
        };

        Projection e;
        e = Projections.sqlGroupProjection(select, groupBy, aliases, types);
        addProjection(e);
    }
}
