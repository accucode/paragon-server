package com.app.model.core;

import com.app.model.MyTenant;

/**
 * Used to identify domain models associated with a particular tenant.
 *
 * The tenant must be NON-NULL.
 * The tenant should NEVER change.
 *
 * All domain models should implement one of:
 *
 *      MyProjectDomainIF
 *      MyTenantDomainIF
 *      MySystemDomainIF
 *
 * @see MyProjectDomainIF
 * @see MyTenantDomainIF
 * @see MySystemDomainIF
 */
public interface MyTenantDomainIF
{
    MyTenant getTenant();
}
