package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.filter.MySiteFilter;
import com.app.model.base.MyFilterTemplateContextType;

// todo_wyatt: fancy filters (e.g.: for site)
public class MyPredefinedFilterTemplates
{
    public static KmList<MyFilterTemplate> getListFor(
        MyProject project,
        MyFilterTemplateContextType context)
    {
        switch ( context )
        {
            case Site:
                return MySiteFilter.getPredefinedTemplatesFor(project);
        }
        throw Kmu.newEnumError(context);
    }
}
