package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyPriorityCriteria;
import com.app.dao.base.MyPriorityDaoBase;
import com.app.model.MyPriority;
import com.app.model.MyProject;

public class MyPriorityDao
    extends MyPriorityDaoBase
{
    //##################################################
    //# find
    //##################################################

    public KmList<MyPriority> findAllFor(MyProject e)
    {
        MyPriorityCriteria c;
        c = createCriteria();
        c.whereProjectIs(e);
        return c.findAll();
    }

    //##################################################
    //# duplicate name
    //##################################################

    public MyPriority findName(MyProject project, String name)
    {
        MyPriorityCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.findUnique();
    }

    public boolean isDuplicateName(MyProject project, String name)
    {
        MyPriorityCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyPriority priority, String name)
    {
        MyPriorityCriteria c;
        c = createCriteria();
        c.whereProjectIs(priority.getProject());
        c.whereName().is(name);
        c.whereUidIsNot(priority);
        return c.exists();
    }

    //##################################################
    //# duplicate sequence
    //##################################################

    public boolean isDuplicateSequence(MyProject project, String sequence)
    {
        MyPriorityCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereSequenceCode().is(sequence);
        return c.exists();
    }

    public boolean isDuplicateSequence(MyPriority priority, String sequence)
    {
        MyPriorityCriteria c;
        c = createCriteria();
        c.whereProjectIs(priority.getProject());
        c.whereSequenceCode().is(sequence);
        c.whereUidIsNot(priority);
        return c.exists();
    }
}
