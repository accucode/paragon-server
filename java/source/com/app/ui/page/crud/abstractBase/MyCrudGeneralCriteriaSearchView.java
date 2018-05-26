package com.app.ui.page.crud.abstractBase;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;

import com.app.criteria.core.MyAbstractCriteria;

/**
 * I display a paginated list, using the ScSimpleModelList to render
 * each page. I incorporate support for filters.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 * @param <R> The criteria object used to find the children.
 */
public abstract class MyCrudGeneralCriteriaSearchView<P extends KmUidDomainIF, C extends KmUidDomainIF, R extends MyAbstractCriteria<C>>
    extends MyCrudGeneralSearchView<P,C>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCrudGeneralCriteriaSearchView(MyCrudBuilder<P,C> e)
    {
        super(e);
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected final KmList<C> findChildren(int index, int count)
    {
        R c;
        c = createCriteria();
        c.setFirstResult(index);
        c.setMaxResults(count);

        filter(c);
        sort(c);

        return c.findAll();
    }

    protected final KmList<C> findChildren()
    {
        R c = createCriteria();

        filter(c);
        sort(c);

        return c.findAll();
    }

    @Override
    protected final int findChildCount()
    {
        R c = createCriteria();
        filter(c);
        return c.findRowCount();
    }

    protected abstract R createCriteria();

    protected abstract void filter(R c);

    protected abstract void sort(R c);
}
