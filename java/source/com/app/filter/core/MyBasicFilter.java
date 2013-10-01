package com.app.filter.core;

import java.io.Serializable;

import com.app.command.base.MyFilterBase;

import com.kodemore.collection.KmList;
import com.kodemore.dao.KmAbstractDao;
import com.kodemore.hibernate.criteria.KmCriteria;
import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MyBasicFilter<T>
    extends MyFilterBase<T>
{
    //##################################################
    //# apply
    //##################################################

    /**
     * Apply the full filter.  A convenience for applying all
     * conditions, sorts, and row limits.
     */
    public void applyTo(KmModelCriteria<T> c)
    {
        applyConditionsTo(c);
        applySortsTo(c);
    }

    /**
     * Apply only the conditions.  Conditions are generally
     * the portion of the query managed in the WHERE clause.
     * It is assumed that these conditions can be applied
     * to typical SELECTS, but also to aggregate select like
     * SELECT COUNT(*), and also to other actions like UPDATEs
     * and DELETEs.
     */
    protected abstract void applyConditionsTo(KmModelCriteria<T> c);

    /**
     * Apply any sorting.   By default, framework methods will
     * not include sorts when running aggregate methods like
     * count(*), nor when performing UPDATEs or DELETEs.
     */
    protected abstract void applySortsTo(KmModelCriteria<T> c);

    //##################################################
    //# find (callbacks)
    //##################################################

    /*
     * The following methods are callbacks.
     * That is, they are used as part of the contract with
     * the respective commands.  For example, above you will
     * find a findAll() method.  That methods creates a
     * FindAllCommand, which in turn calls the _findAll
     * method below.  The significance is that the _findAll
     * method is guaranteed to be run inside a session/transaction.
     */
    @Override
    public KmList<T> findAll()
    {
        KmModelCriteria<T> c = createCriteria();
        applyTo(c);
        KmList<?> result = c.findAll();
        return castList(result);
    }

    @Override
    public KmList<T> findBatch(int index, int count)
    {
        KmModelCriteria<T> c = createCriteria();
        applyTo(c);
        c.setFirstResult(index);
        c.setMaxResults(count);
        KmList<?> result = c.findAll();
        return castList(result);
    }

    @Override
    public int getCount()
    {
        KmModelCriteria<T> c = createCriteria();
        applyConditionsTo(c);
        return c.findRowCount();
    }

    //##################################################
    //# support
    //##################################################

    @Override
    protected abstract KmAbstractDao<T,? extends Serializable> getDao();

    protected final KmCriteria createGenericCriteria()
    {
        return getDao().createGenericCriteria();
    }

    protected abstract KmModelCriteria<T> createCriteria();
}
