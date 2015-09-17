package com.kodemore.servlet.action;

/**
 * I provide a standard mechanism for delegating to the appropriate context.
 * This is primarily used to allow controls a loosely coupled access to the
 * page.  This also allows for those rare cases where a page is not available
 * to provide the context.
 *
 * @see ScContextIF
 */
public interface ScContextSupplierIF
{
    ScContextIF getContext();
}
