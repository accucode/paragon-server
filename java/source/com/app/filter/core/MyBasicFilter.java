package com.app.filter.core;

import com.kodemore.collection.KmList;
import com.kodemore.dao.KmAbstractDao;
import com.kodemore.hibernate.KmhModelCriteria;
import com.kodemore.hibernate.basic.KmhCriteria;

import com.app.command.base.MyFilterBase;

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
    public void applyTo(KmhModelCriteria<T> c)
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
    protected abstract void applyConditionsTo(KmhModelCriteria<T> c);

    /**
     * Apply any sorting.   By default, framework methods will
     * not include sorts when running aggregate methods like
     * count(*), nor when performing UPDATEs or DELETEs.
     */
    protected abstract void applySortsTo(KmhModelCriteria<T> c);

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
        KmhModelCriteria<T> c = composeFindAllCriteria();
        KmList<?> result = c.findAll();
        return castList(result);
    }

    @Override
    public KmList<T> findBatch(int index, int count)
    {
        KmhModelCriteria<T> c = composeFindBatchCriteria(index, count);
        KmList<?> result = c.findAll();
        return castList(result);
    }

    @Override
    public int getCount()
    {
        KmhModelCriteria<T> c = createCriteria();
        applyConditionsTo(c);
        return c.findRowCount();
    }

    //##################################################
    //# criteria
    //##################################################

    public KmhModelCriteria<T> composeFindAllCriteria()
    {
        KmhModelCriteria<T> c;
        c = createCriteria();
        applyTo(c);
        return c;
    }

    public KmhModelCriteria<T> composeFindBatchCriteria(int index, int count)
    {
        KmhModelCriteria<T> c;
        c = composeFindAllCriteria();
        c.setFirstResult(index);
        c.setMaxResults(count);
        return c;
    }

    //##################################################
    //# support
    //##################################################

    protected abstract KmAbstractDao<T,?> getDao();

    protected abstract KmhModelCriteria<T> createCriteria();

    /**
     * Clients should generally use the createCriteria() method instead.
     * I am primarily used by the framework to create the more useful
     * wrapper classes.
     */
    protected final KmhCriteria _createCriteria()
    {
        return getDao()._createCriteria();
    }

}
