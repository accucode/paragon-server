package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyEmailTemplateCriteria;
import com.app.dao.base.MyEmailTemplateDaoBase;
import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;

public class MyEmailTemplateDao
    extends MyEmailTemplateDaoBase
{
    //##################################################
    //# duplicate name
    //##################################################

    public boolean isDuplicateName(MyProject project, String name)
    {
        MyEmailTemplateCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyEmailTemplate template, String name)
    {
        MyEmailTemplateCriteria c;
        c = createCriteria();
        c.whereProjectIs(template.getProject());
        c.whereName().is(name);
        c.whereUidIsNot(template);
        return c.exists();
    }

    //##################################################
    //# auto complete
    //##################################################

    public KmList<String> autoCompleteNames(MyProject project, String term)
    {
        MyEmailTemplateCriteria c;
        c = createCriteria();
        c.selectName();
        c.whereProjectIs(project);
        c.whereEnabled().isTrue();
        c.whereName().hasSubstring(term);
        c.sortOnName();
        return c.findStrings(20);
    }

}
