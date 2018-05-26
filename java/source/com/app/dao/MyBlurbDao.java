package com.app.dao;

import com.app.criteria.MyBlurbCriteria;
import com.app.dao.base.MyBlurbDaoBase;
import com.app.model.MyBlurb;
import com.app.model.MyProject;

public class MyBlurbDao
    extends MyBlurbDaoBase
{
    //##################################################
    //# find
    //##################################################

    public MyBlurb findName(MyProject project, String name)
    {
        MyBlurbCriteria c;
        c = createCriteria();
        c.whereName().is(name);
        c.whereProjectIs(project);
        return c.findFirst();
    }

    //##################################################
    //# duplicate name
    //##################################################

    public boolean isDuplicateName(MyProject project, String name)
    {
        MyBlurbCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyBlurb blurb, String name)
    {
        MyBlurbCriteria c;
        c = createCriteria();
        c.whereProjectIs(blurb.getProject());
        c.whereName().is(name);
        c.whereUidIsNot(blurb);
        return c.exists();
    }
}
