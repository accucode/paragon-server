package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyProjectCriteria;
import com.app.dao.base.MyProjectDaoBase;
import com.app.model.MyProject;
import com.app.model.MyTenant;

public class MyProjectDao
    extends MyProjectDaoBase
{
    //##################################################
    //# duplicate code
    //##################################################

    public boolean isDuplicateCode(MyTenant tenant, String code)
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.whereTenantIs(tenant);
        c.whereCode().is(code);
        return c.exists();
    }

    public boolean isDuplicateCode(MyProject project, String code)
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.whereTenantIs(project.getTenant());
        c.whereCode().is(code);
        c.whereUidIsNot(project);
        return c.exists();
    }

    //##################################################
    //# duplicate name
    //##################################################

    public boolean isDuplicateName(MyTenant tenant, String name)
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.whereTenantIs(tenant);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyProject project, String name)
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.whereTenantIs(project.getTenant());
        c.whereName().is(name);
        c.whereUidIsNot(project);
        return c.exists();
    }

    //##################################################
    //# enabled
    //##################################################

    public KmList<MyProject> findEnabled()
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.whereEnabled().isTrue();
        return c.findAll();
    }
}
