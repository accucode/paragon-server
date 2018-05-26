package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyChoiceCriteria;
import com.app.dao.base.MyChoiceDaoBase;
import com.app.model.MyProject;
import com.app.model.MyChoice;
import com.app.model.base.MyChoiceType;

public class MyChoiceDao
    extends MyChoiceDaoBase
{
    //##################################################
    //# find
    //##################################################

    public KmList<MyChoice> findAllChoicesFor(MyProject project, MyChoiceType type)
    {
        MyChoiceCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereTypeIs(type);
        c.sortOnName();
        return c.findAll();
    }

    public KmList<MyChoice> findEnabledChoicesFor(MyProject project, MyChoiceType type)
    {
        MyChoiceCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereTypeIs(type);
        c.whereEnabled().isTrue();
        c.sortOnName();
        return c.findAll();
    }

    public MyChoice findChoice(MyProject project, MyChoiceType type, String name)
    {
        MyChoiceCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereTypeIs(type);
        c.whereName().is(name);
        return c.findFirst();
    }

    public MyChoice findDefaultChoice(MyProject project, MyChoiceType type)
    {
        MyChoiceCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereTypeIs(type);
        c.whereDefaultValue().isTrue();
        return c.findFirst();
    }

    public MyChoice lazyFindChoice(MyProject project, MyChoiceType type, String name)
    {
        MyChoice e = findChoice(project, type, name);
        if ( e == null )
        {
            e = new MyChoice();
            e.setProject(project);
            e.setType(type);
            e.setName(name);
            e.daoAttach();
        }
        return e;
    }

    //##################################################
    //# is duplicate name
    //##################################################

    public boolean isDuplicateName(MyProject project, MyChoiceType type, String name)
    {
        MyChoiceCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereTypeIs(type);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyChoice choice, String name)
    {
        MyChoiceCriteria c;
        c = createCriteria();
        c.whereProjectIs(choice.getProject());
        c.whereTypeIs(choice.getType());
        c.whereName().is(name);
        c.whereUidIsNot(choice);
        return c.exists();
    }

    //##################################################
    //# default value
    //##################################################

    public void setDefaultValue(MyChoice e, boolean def)
    {
        if ( def )
            clearDefaultValueFor(e.getProject(), e.getType());

        e.setDefaultValue(def);
    }

    private void clearDefaultValueFor(MyProject project, MyChoiceType type)
    {
        KmList<MyChoice> v = findAllChoicesFor(project, type);
        for ( MyChoice e : v )
            e.setDefaultValue(false);
    }
}
