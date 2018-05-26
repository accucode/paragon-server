package com.app.model.core;

/**
 * I am the parent for non-persistent "value objects".
 *
 * My hierarchy is not stored in the database, so
 * there is no primary key, and no dao methods.
 */
public abstract class MyAbstractValueDomain<T extends MyAbstractDomain<?>>
    extends MyAbstractDomain<T>
{
    // none
}
