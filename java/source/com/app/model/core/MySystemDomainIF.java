package com.app.model.core;

/**
 * Used to identify domain models that are NOT associated with
 * either a project or tenant.
 *
 * This sole purpose of this interface is to act as a flag
 * so that we can check that all domain models have been configured.
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
public interface MySystemDomainIF
{
    // none
}
