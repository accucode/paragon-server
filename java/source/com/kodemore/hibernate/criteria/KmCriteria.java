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

package com.kodemore.hibernate.criteria;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

public class KmCriteria
    extends KmAbstractCriteria
{
    //##################################################
    //# variables
    //##################################################

    private Criteria _criteria;
    private boolean  _sorted;

    //##################################################
    //# constructor
    //##################################################

    protected KmCriteria(Criteria e, KmAbstractCriteria parent)
    {
        super(parent);
        _criteria = e;
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

    private Criteria _sortOn(Order o)
    {
        _sorted = true;
        return _criteria.addOrder(o);
    }

    public boolean isSorted()
    {
        return _sorted;
    }

    //##################################################
    //# row limits
    //##################################################

    public void setFirstResult(Integer e)
    {
        _criteria.setFirstResult(e);
    }

    public void setMaxResults(int e)
    {
        _criteria.setMaxResults(e);
    }

    //##################################################
    //# find
    //##################################################

    public Object findUnique()
    {
        return _criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public KmList<?> findAll()
    {
        return new KmList<Object>(_criteria.list());
    }

    //##################################################
    //# projections (convenience)
    //##################################################

    public int findRowCount()
    {
        selectRowCount();
        return findInteger();
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public void _add(Criterion e)
    {
        _criteria.add(e);
    }

    public Criteria getInnerCriteria()
    {
        return _criteria;
    }

    @Override
    public KmCriteria getCriteria()
    {
        return this;
    }

    //##################################################
    //# alias
    //##################################################

    public String getAlias()
    {
        return _criteria.getAlias();
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

    //##################################################
    //# projections (results)
    //##################################################

    /**
     * Find a list of projections.
     * Assumes a projection with at least 2 attributes.
     * If the projection has only 1 attribute then hibernate
     * will not wrap the results in an array and a type cast
     * error will result.
     */
    @SuppressWarnings("unchecked")
    public KmList<Object[]> findRawResults()
    {
        return (KmList<Object[]>)findAll();
    }

    public KmProjectionResult findResults()
    {
        return new KmProjectionResult(findRawResults());
    }

    /**
     * Return the single string property for the projection results.
     * Assumes a projection with exactly one String property.
     * Assumes a projection with exactly on result row.
     */
    public String findString()
    {
        return (String)findUnique();
    }

    /**
     * Return the single string property for the projection results.
     * Assumes a projection with exactly one String property.
     */
    @SuppressWarnings("unchecked")
    public KmList<String> findStrings()
    {
        return (KmList<String>)findAll();
    }

    /**
     * Return the single Integer property for the projection results.
     * Assumes a projection with exactly one Integer property.
     * Assumes a projection with exactly one result row.
     */
    public Integer findInteger()
    {
        return Kmu.toInteger(findUnique());
    }

    /**
     * Return the single integer property for the projection results.
     * Assumes a projection with exactly one Integer property.
     */
    @SuppressWarnings("unchecked")
    public KmList<Integer> findIntegers()
    {
        return (KmList<Integer>)findAll();
    }

    /**
     * Return the single Double property for the projection results.
     * Assumes a projection with exactly one Double property.
     * Assumes a projection with exactly one result row.
     */
    public Double findDouble()
    {
        return (Double)findUnique();
    }

    /**
     * Return the single double property for the projection results.
     * Assumes a projection with exactly one Double property.
     */
    @SuppressWarnings("unchecked")
    public KmList<Double> findDoubles()
    {
        return (KmList<Double>)findAll();
    }

    /**
     * Return the single property for the projection results.
     * Assumes a projection with exactly one property.
     * Assumes a projection with exactly one result row.
     */
    public KmDate findDate()
    {
        return (KmDate)findUnique();
    }

    /**
     * Return the single property for the projection results.
     * Assumes a projection with exactly one property.
     * Assumes a projection with exactly one result row.
     */
    public KmTimestamp findTimestamp()
    {
        return (KmTimestamp)findUnique();
    }

    /**
     * Return the single property for the projection results.
     * Assumes a projection with exactly one property.
     */
    @SuppressWarnings("unchecked")
    public KmList<KmTimestamp> findTimestamps()
    {
        return (KmList<KmTimestamp>)findAll();
    }

    //##################################################
    //# support
    //##################################################

    protected KmList<String> getFullNames(String... names)
    {
        KmList<String> v = new KmList<String>();
        for ( String e : names )
            v.add(getFullName(e));
        return v;
    }

}
