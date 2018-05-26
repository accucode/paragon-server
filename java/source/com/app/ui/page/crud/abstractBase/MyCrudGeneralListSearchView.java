package com.app.ui.page.crud.abstractBase;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;

/**
 * I display a paginated list, using the ScSimpleModelList to render
 * each page. I incorporate support for filters.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public abstract class MyCrudGeneralListSearchView<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends MyCrudGeneralSearchView<P,C>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCrudGeneralListSearchView(MyCrudBuilder<P,C> e)
    {
        super(e);
    }

    //##################################################
    //# criteria
    //##################################################

    protected abstract KmList<C> findChildren();

    @Override
    protected final KmList<C> findChildren(int index, int count)
    {
        return findChildren().getBatchSafe(index, count);
    }

    @Override
    protected final int findChildCount()
    {
        return findChildren().size();
    }
}
