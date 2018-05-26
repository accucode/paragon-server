package com.app.ui.page.crud.site;

import com.kodemore.collection.KmList;

import com.app.criteria.MySiteCriteria;
import com.app.filter.MySiteFilter;
import com.app.model.MyFilterTemplate;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.base.MyFilterTemplateContextType;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudNamedCriteriaSearchView;
import com.app.utility.MyGlobals;

public final class MySiteSearchView
    extends MyCrudNamedCriteriaSearchView<MyProject,MySite,MySiteCriteria>
{
    //##################################################
    //# variables
    //##################################################

    private MySiteFilterDialog _editDialog;

    //##################################################
    //# constructor
    //##################################################

    public MySiteSearchView(MyCrudBuilder<MyProject,MySite> e)
    {
        super(e);

        _editDialog = new MySiteFilterDialog();
        _editDialog.onApply(this::ajaxSelectTemplate);
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected MyFilterTemplateContextType getContextType()
    {
        return MyFilterTemplateContextType.Site;
    }

    //##################################################
    //# filter
    //##################################################

    @Override
    protected MySiteFilter createFilter()
    {
        return new MySiteFilter();
    }

    //##################################################
    //# abstract
    //##################################################

    @Override
    protected MyProject getFilterProject()
    {
        return MyGlobals.getCurrentProject();
    }

    @Override
    protected KmList<String> autoCompleteSearch(String term)
    {
        MySiteCriteria c;
        c = getAccess().getSiteDao().createCriteria();
        c.selectName();
        c.joinToCustomer().whereProjectIs(getFilterProject());
        c.whereFullName().hasSubstring(term);
        c.sortOnName();
        c.setMaxResults(10);
        return c.findStrings();
    }

    @Override
    protected KmList<MyFilterTemplate> findPredefinedCandidates(
        MyProject project,
        MyFilterTemplateContextType context)
    {
        return MySiteFilter.getPredefinedTemplatesFor(project);
    }

    @Override
    protected void editFilter(MyFilterTemplate template)
    {
        _editDialog.ajaxOpen(template);
    }

}
