package com.kodemore.hibernate;

import org.hibernate.criterion.DetachedCriteria;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmCriteriaFilter;
import com.kodemore.hibernate.basic.KmhCriteria;
import com.kodemore.hibernate.basic.KmhElement;
import com.kodemore.hibernate.basic.KmhJoin;
import com.kodemore.hibernate.basic.KmhRootCriteria;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;

public abstract class KmhModelCriteria<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmhElement _context;

    //##################################################
    //# constructor
    //##################################################

    public KmhModelCriteria(KmhElement context)
    {
        _context = context;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmhCriteria parent()
    {
        return context().getCriteria();
    }

    public KmhElement context()
    {
        return _context;
    }

    //##################################################
    //# where
    //##################################################

    public <E> KmhPropertyCondition<E> whereProperty(KmMetaDaoPropertyIF<T,E> attr)
    {
        return new KmhPropertyCondition<>(context(), alias(), attr.getDaoPropertyName());
    }

    public KmhStringCondition whereString(KmMetaDaoPropertyIF<T,String> attr)
    {
        return new KmhStringCondition(context(), alias(), attr.getDaoPropertyName());
    }

    public KmhIntegerCondition whereInteger(KmMetaDaoPropertyIF<T,Integer> attr)
    {
        return new KmhIntegerCondition(context(), alias(), attr.getDaoPropertyName());
    }

    public KmhBooleanCondition whereBoolean(KmMetaDaoPropertyIF<T,Boolean> attr)
    {
        return new KmhBooleanCondition(context(), alias(), attr.getDaoPropertyName());
    }

    public KmhDateCondition whereDate(KmMetaDaoPropertyIF<T,KmDate> attr)
    {
        return new KmhDateCondition(context(), alias(), attr.getDaoPropertyName());
    }

    public KmhTimestampCondition whereTimestamp(KmMetaDaoPropertyIF<T,KmTimestamp> attr)
    {
        return new KmhTimestampCondition(context(), alias(), attr.getDaoPropertyName());
    }

    public KmhSubqueryCondition whereSubquery(KmhModelCriteria<?> c)
    {
        DetachedCriteria dc = c.context().getCriteria().getProxy().asDetached().getInner();
        return new KmhSubqueryCondition(context(), dc);
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOn(KmMetaDaoPropertyIF<T,?> attr)
    {
        parent().sortAscending(attr.getDaoPropertyName());
    }

    //##################################################
    //# support
    //##################################################

    public boolean isSorted()
    {
        return parent().isSorted();
    }

    protected KmhJoin joinTo(String property)
    {
        return parent().joinTo(property);
    }

    protected KmhJoin leftJoinTo(String property)
    {
        return parent().leftJoinTo(property);
    }

    protected String alias()
    {
        return parent().getAlias();
    }

    protected String fullName(String property)
    {
        return parent().getFullName(property);
    }

    protected KmhRootCriteria root()
    {
        return parent().getRoot();
    }

    //##################################################
    //# batch
    //##################################################

    public void setFirstResult(int index)
    {
        root().setFirstResult(index);
    }

    public void clearFirstResult()
    {
        setFirstResult(0);
    }

    public void setMaxResults(int count)
    {
        root().setMaxResults(count);
    }

    public void setRowLimit(int count)
    {
        setMaxResults(count);
    }

    public void clearMaxResults()
    {
        setMaxResults(Integer.MAX_VALUE);
    }

    //##################################################
    //# projection (select)
    //##################################################

    protected void select(String name)
    {
        parent().select(name);
    }

    protected void selectDistinct(String name)
    {
        parent().selectDistinct(name);
    }

    protected void selectCountDistinct(String name)
    {
        parent().selectCountDistinct(name);
    }

    protected void selectMinimum(String name)
    {
        parent().selectMinimum(name);
    }

    protected void selectMaximum(String name)
    {
        parent().selectMaximum(name);
    }

    protected void selectAverage(String name)
    {
        parent().selectAverage(name);
    }

    protected void selectSum(String name)
    {
        parent().selectSum(name);
    }

    public void selectRowCount()
    {
        parent().selectRowCount();
    }

    protected void groupBy(String name)
    {
        parent().groupBy(name);
    }

    //==================================================
    //= group by :: fn
    //==================================================

    protected void groupByYear(String name)
    {
        parent().groupByYear(name);
    }

    protected void groupByMonth(String name)
    {
        parent().groupByMonth(name);
    }

    protected void groupBySqlDate(String name)
    {
        parent().groupBySqlDate(name);
    }

    //==================================================
    //= group by :: timestamp fn
    //==================================================

    public void groupByTimestampYear(KmMetaDaoPropertyIF<?,KmTimestamp> e)
    {
        groupByYear(e.getDaoPropertyName());
    }

    public void groupByTimestampMonth(KmMetaDaoPropertyIF<?,KmTimestamp> e)
    {
        groupByMonth(e.getDaoPropertyName());
    }

    public void groupByTimestampSqlDate(KmMetaDaoPropertyIF<?,KmTimestamp> e)
    {
        groupBySqlDate(e.getDaoPropertyName());
    }

    //==================================================
    //= group by :: date fn
    //==================================================

    public void groupByDateYear(KmMetaDaoPropertyIF<?,KmDate> e)
    {
        groupByYear(e.getDaoPropertyName());
    }

    public void groupByDateMonth(KmMetaDaoPropertyIF<?,KmDate> e)
    {
        groupByMonth(e.getDaoPropertyName());
    }

    //##################################################
    //# projection (results)
    //##################################################

    public KmhProjectionResult findResults()
    {
        return root().findResults();
    }

    public KmList<Object[]> findRawResults()
    {
        return root().findRawResults();
    }

    public String findString()
    {
        return root().findString();
    }

    public KmList<String> findStrings()
    {
        return root().findStrings();
    }

    public KmList<String> findStrings(int limit)
    {
        setMaxResults(limit);
        return root().findStrings();
    }

    public Integer findInteger()
    {
        return root().findInteger();
    }

    public KmList<Integer> findIntegers()
    {
        return root().findIntegers();
    }

    public Double findDouble()
    {
        return root().findDouble();
    }

    public KmList<Double> findDoubles()
    {
        return root().findDoubles();
    }

    public KmQuantity findQuantity()
    {
        return root().findQuantity();
    }

    public KmList<KmQuantity> findQuantities()
    {
        return root().findQuantities();
    }

    public KmMoney findMoney()
    {
        return root().findMoney();
    }

    public KmList<KmMoney> findMonies()
    {
        return root().findMonies();
    }

    public KmDate findDate()
    {
        return root().findDate();
    }

    public KmTimestamp findTimestamp()
    {
        return root().findTimestamp();
    }

    public KmList<KmTimestamp> findTimestamps()
    {
        return root().findTimestamps();
    }

    //##################################################
    //# projection (convenience)
    //##################################################

    public int findRowCount()
    {
        return root().findRowCount();
    }

    //##################################################
    //# find
    //##################################################

    @SuppressWarnings("unchecked")
    public KmList<T> findAll()
    {
        return (KmList<T>)root().findAll();
    }

    public T findFirst()
    {
        return findFirst(1).getFirstSafe();
    }

    public KmList<T> findFirst(int n)
    {
        setMaxResults(n);
        return findAll().getFirstSafe(n);
    }

    @SuppressWarnings("unchecked")
    public T findUnique()
    {
        return (T)root().findUnique();
    }

    public boolean exists()
    {
        return findFirst() != null;
    }

    //##################################################
    //# conversion
    //##################################################

    public KmCriteriaFilter<T> toFilter()
    {
        return new KmCriteriaFilter<>(this);
    }
}
