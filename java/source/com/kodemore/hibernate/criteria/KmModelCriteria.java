package com.kodemore.hibernate.criteria;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

public abstract class KmModelCriteria<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmCriteria         _parent;
    private KmAbstractCriteria _context;

    //##################################################
    //# constructor
    //##################################################

    public KmModelCriteria(KmCriteria parent)
    {
        this(parent, parent);
    }

    public KmModelCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        _parent = parent;
        _context = context;
    }

    //##################################################
    //# where
    //##################################################

    public <E> KmPropertyCriteria<E> whereProperty(KmMetaDaoPropertyIF<T,E> e)
    {
        return new KmPropertyCriteria<>(context(), fullName(e.getDaoPropertyName()));
    }

    public KmStringCriteria whereString(KmMetaDaoPropertyIF<T,String> attr)
    {
        return new KmStringCriteria(context(), fullName(attr.getDaoPropertyName()));
    }

    public KmIntegerCriteria whereInteger(KmMetaDaoPropertyIF<T,Integer> attr)
    {
        return new KmIntegerCriteria(context(), fullName(attr.getDaoPropertyName()));
    }

    public KmBooleanCriteria whereBoolean(KmMetaDaoPropertyIF<T,Boolean> attr)
    {
        return new KmBooleanCriteria(context(), fullName(attr.getDaoPropertyName()));
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

    public KmCriteria parent()
    {
        return _parent;
    }

    public KmAbstractCriteria context()
    {
        return _context;
    }

    public boolean isSorted()
    {
        return parent().isSorted();
    }

    protected KmJoin joinTo(String property)
    {
        return parent().joinTo(property);
    }

    protected KmJoin leftJoinTo(String property)
    {
        return parent().leftJoinTo(property);
    }

    protected String fullName(String property)
    {
        return parent().getFullName(property);
    }

    public abstract KmModelCriteria<T> createOn(KmModelJunction context);

    protected KmRootCriteria root()
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

    public void setMaxResults(int count)
    {
        root().setMaxResults(count);
    }

    //##################################################
    //# find
    //##################################################

    @SuppressWarnings("unchecked")
    public KmList<T> findAll()
    {
        return (KmList<T>)_parent.findAll();
    }

    public T findFirst()
    {
        setMaxResults(1);
        return findAll().getFirstSafe();
    }

    @SuppressWarnings("unchecked")
    public T findUnique()
    {
        return (T)_parent.findUnique();
    }

    public boolean exists()
    {
        return findFirst() != null;
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

    //##################################################
    //# projection (results)
    //##################################################

    public KmProjectionResult findResults()
    {
        return _parent.findResults();
    }

    public KmList<Object[]> findRawResults()
    {
        return _parent.findRawResults();
    }

    public String findString()
    {
        return _parent.findString();
    }

    public KmList<String> findStrings()
    {
        return _parent.findStrings();
    }

    public Integer findInteger()
    {
        return _parent.findInteger();
    }

    public KmList<Integer> findIntegers()
    {
        return _parent.findIntegers();
    }

    public Double findDouble()
    {
        return _parent.findDouble();
    }

    public KmList<Double> findDoubles()
    {
        return _parent.findDoubles();
    }

    public KmDate findDate()
    {
        return _parent.findDate();
    }

    public KmTimestamp findTimestamp()
    {
        return _parent.findTimestamp();
    }

    public KmList<KmTimestamp> findTimestamps()
    {
        return _parent.findTimestamps();
    }

    //##################################################
    //# projection (convenience)
    //##################################################

    public Integer findRowCount()
    {
        return parent().findRowCount();
    }
}
