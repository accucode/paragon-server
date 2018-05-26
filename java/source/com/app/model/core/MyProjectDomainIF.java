package com.app.model.core;

import com.app.model.MyProject;
import com.app.model.MyTenant;

/**
 * Used to identify domain models that are associated with a particular project.
 *
 * The project must be NON-NULL.
 *
 * We do NOT support moving a model from one project to another.
 * For example, if Job 123 is part of project A then it will always
 * be part of project A.
 *
 * @see MyProjectDomainIF
 * @see MyTenantDomainIF
 * @see MySystemDomainIF
 */
public interface MyProjectDomainIF
{
    //##################################################
    //# tenant
    //##################################################

    MyTenant getTenant();

    default String getTenantName()
    {
        MyTenant e = getTenant();
        return e == null
            ? null
            : e.getName();
    }

    //##################################################
    //# project
    //##################################################

    MyProject getProject();

    default String getProjectName()
    {
        MyProject e = getProject();
        return e == null
            ? null
            : e.getName();
    }

}
