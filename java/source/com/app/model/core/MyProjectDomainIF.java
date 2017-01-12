package com.app.model.core;

import com.app.model.MyProject;

/**
 * Used to identify domain models that are associated with a particular project.
 *
 * The project must be NON-NULL.
 * However, the project is NOT required to remain the same.
 *
 * For example, a Sales Order must be associated with a project. But it is feasible
 * for the sales order to be transferred (reassigned) to another project.
 *
 * All domain models should implement one of:
 *      MyProjectDomainIF
 *      MyTenantDomainIF
 *      MySystemDomainIF
 *
 * @see MyProjectDomainIF
 * @see MyTenantDomainIF
 * @see MySystemDomainIF
 */
public interface MyProjectDomainIF
{
    MyProject getProject();
}
