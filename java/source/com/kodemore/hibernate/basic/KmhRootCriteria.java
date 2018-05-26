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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.hibernate.KmhProjectionResult;
import com.kodemore.hibernate.proxy.KmhCriteriaProxy;
import com.kodemore.hibernate.proxy.KmhProxy;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;
import com.kodemore.utility.Kmu;

/**
 * I am the single root of the criteria hierarchy.  When composing
 * a hibernate criteria, a hierarchy of criteria is created with the
 * various table JOINs and JUNCTIONs.
 *
 * In some cases, parts of the hierarchy are composed of Detached Criteria
 * which do not have direct access to the session.  In particular, hibernate
 * requires the use of Detached Criteria to compose subqueries.
 *
 * The root provide a hook for the management of shared singletons such as
 * the list of projections, and joins.  Also, the root is always attached
 * to the session and is used to execute the query with methods such as
 * findAll().
 */
public class KmhRootCriteria
    extends KmhCriteria
{
    //##################################################
    //# variables
    //##################################################

    private int _aliasIndex;

    /**
     * Entity name -> criteria
     */
    private KmMap<String,KmhJoin> _joins;

    private ProjectionList _projections;

    //##################################################
    //# constructor
    //##################################################

    public KmhRootCriteria(Criteria c)
    {
        super(c);
        _joins = new KmMap<>();
        _projections = null;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public KmhRootCriteria getRoot()
    {
        return this;
    }

    private String getNextAlias()
    {
        return "a" + _aliasIndex++;
    }

    protected KmhJoin _join(KmhCriteria parent, String entityName, JoinType type)
    {
        KmhJoin j = _joins.get(entityName);
        if ( j != null )
        {
            if ( !j.hasType(type) )
                throw Kmu.newFatal("Rejoin to entity(%s), with wrong join type.", entityName);
            return j;
        }

        String alias = getNextAlias();
        KmhProxy c = parent.getProxy().createCriteria(entityName, alias, type);

        j = new KmhJoin(c, parent, entityName, type);
        _joins.put(entityName, j);
        return j;
    }

    //##################################################
    //# projections
    //##################################################

    @Override
    public void addProjection(Projection e)
    {
        if ( _projections == null )
        {
            _projections = Projections.projectionList();
            getProxy().setProjection(_projections);
        }

        _projections.add(e);
    }

    //##################################################
    //# accessing
    //##################################################

    private Criteria getInnerCriteria()
    {
        return ((KmhCriteriaProxy)getProxy()).getInner();
    }

    //##################################################
    //# row limits
    //##################################################

    public void setFirstResult(Integer e)
    {
        getInnerCriteria().setFirstResult(e);
    }

    public void setMaxResults(int e)
    {
        getInnerCriteria().setMaxResults(e);
    }

    //##################################################
    //# find (model)
    //##################################################

    /**
     * Find the single, unique, result.
     * Return null, if no result is found.
     * Throw an exception, if multiple results are found.
     */
    public Object findUnique()
    {
        return getInnerCriteria().uniqueResult();
    }

    /**
     * Find all matching results.
     * Return an empty list, if no results are found.
     */
    @SuppressWarnings("unchecked")
    public KmList<?> findAll()
    {
        return new KmList<>(getInnerCriteria().list());
    }

    //##################################################
    //# find (projections)
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

    public KmhProjectionResult findResults()
    {
        return new KmhProjectionResult(findRawResults());
    }

    //==================================================
    //= find :: string
    //==================================================

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

    //==================================================
    //= find :: integer
    //==================================================

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

    //==================================================
    //= find :: double
    //==================================================

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

    //==================================================
    //= find :: quantity
    //==================================================

    /**
     * Return the single property for the projection results.
     * Assumes a projection with exactly one property.
     * Assumes a projection with exactly one result row.
     */
    public KmQuantity findQuantity()
    {
        return (KmQuantity)findUnique();
    }

    /**
     * Return the single quantity property for the projection results.
     * Assumes a projection with exactly one property.
     */
    @SuppressWarnings("unchecked")
    public KmList<KmQuantity> findQuantities()
    {
        return (KmList<KmQuantity>)findAll();
    }

    //==================================================
    //= find :: money
    //==================================================

    /**
     * Return the single property for the projection results.
     * Assumes a projection with exactly one property.
     * Assumes a projection with exactly one result row.
     */
    public KmMoney findMoney()
    {
        return (KmMoney)findUnique();
    }

    /**
     * Return the single money property for the projection results.
     * Assumes a projection with exactly one property.
     */
    @SuppressWarnings("unchecked")
    public KmList<KmMoney> findMonies()
    {
        return (KmList<KmMoney>)findAll();
    }

    //==================================================
    //= find :: date
    //==================================================

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
     * Return the single date property for the projection results.
     * Assumes a projection with exactly one date property.
     */
    @SuppressWarnings("unchecked")
    public KmList<KmDate> findDates()
    {
        return (KmList<KmDate>)findAll();
    }

    //==================================================
    //= find :: timestamps
    //==================================================

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
    //# find (convenience)
    //##################################################

    /**
     * Count the number of matching results.
     * Note: this can be slow for large tables, even if the number of matches is very small.
     */
    public int findRowCount()
    {
        selectRowCount();
        return findInteger();
    }

}
