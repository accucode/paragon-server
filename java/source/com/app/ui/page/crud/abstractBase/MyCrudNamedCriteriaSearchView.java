package com.app.ui.page.crud.abstractBase;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.filter.core.MyLoadableFilterIF;
import com.app.model.MyFilterTemplate;

/**
 * I display a paginated list, using the ScSimpleModelList to render
 * each page. I incorporate support for filters.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 * @param <R> The criteria object used to find the children.
 */
public abstract class MyCrudNamedCriteriaSearchView<P extends KmUidDomainIF, C extends KmUidDomainIF, R extends MyAbstractCriteria<C>>
    extends MyCrudNamedSearchView<P,C>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCrudNamedCriteriaSearchView(MyCrudBuilder<P,C> e)
    {
        super(e);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected final KmList<C> findChildren(int index, int count)
    {
        MyLoadableFilterIF<C> f = getSelectedFilter();
        return f == null
            ? KmList.createEmpty()
            : f.findBatch(index, count);
    }

    @Override
    protected final int findChildCount()
    {
        MyLoadableFilterIF<C> f = getSelectedFilter();
        return f == null
            ? 0
            : f.getCount();
    }

    //##################################################
    //# filter
    //##################################################

    private MyLoadableFilterIF<C> getSelectedFilter()
    {
        MyFilterTemplate template = getSelectedTemplate();
        if ( template == null )
            return null;

        MyLoadableFilterIF<C> f;
        f = createFilter();
        f.loadFromTemplate(template);

        if ( hasSearchText() )
            f.setQuickSearch(getSearchText());

        return f;
    }

    protected abstract MyLoadableFilterIF<C> createFilter();
}
