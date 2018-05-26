package com.kodemore.hibernate;

/**
 * I define some common methods for domain objects that
 * know how to coordinate persistence with Hibernate.
 */
public interface KmhDaoDomainIF
{
    void daoAttach();

    void daoDetach();

    void daoDelete();

    void daoFetch();

    void daoEvict();
}
