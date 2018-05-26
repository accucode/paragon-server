package com.app.filter.core;

import com.kodemore.filter.KmFilterIF;

import com.app.model.MyFilterTemplate;
import com.app.model.MyProject;
import com.app.model.base.MyFilterTemplateContextType;

public interface MyLoadableFilterIF<T>
    extends KmFilterIF<T>
{
    //##################################################
    //# accessing
    //##################################################

    MyProject getTemplateProject();

    MyFilterTemplateContextType getTemplateContextType();

    //##################################################
    //# search
    //##################################################

    /**
     * All loadable filters must support an additional quickSearch attribute.
     * This is NOT stored, but is used to supplement the persistent filter.
     */
    void setQuickSearch(String search);

    //##################################################
    //# load
    //##################################################

    void loadFromTemplate(MyFilterTemplate template);

    //##################################################
    //# save
    //##################################################

    void saveToTemplate(MyFilterTemplate def);

    //##################################################
    //# convert
    //##################################################

    default MyFilterTemplate toTemplate(String name)
    {
        MyFilterTemplate e;
        e = new MyFilterTemplate();
        e.setName(name);
        e.setProject(getTemplateProject());
        e.setContextType(getTemplateContextType());
        saveToTemplate(e);
        return e;
    }

    default MyFilterTemplate toPredefinedTemplate(String name)
    {
        MyFilterTemplate e;
        e = toTemplate(name);
        e.setTypePredefined();
        e.setModified(false);
        return e;
    }

}
