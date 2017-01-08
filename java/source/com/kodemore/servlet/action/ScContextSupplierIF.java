package com.kodemore.servlet.action;

/**
 * I am used primarily by ScActions in order to determine how security
 * and errors should be managed.
 *
 * Security management is usually broadcast up the ui hierarhcy
 * to the ScPageRoot control which then delegates it to the current page.
 *
 * Error management is usually broadcast up the ui hierarchy to some container
 * that know how to display an error banner.  In most cases, errors are handled
 * locally and the action attaches the error to the pertinent field or control.
 * In some cases, application exceptions are throw that are not easy to catch
 * in the action handler.  In these cases, the error manager displays the error
 * message in a prominent location; e.g.: in a banner above the "save" button.
 *
 * @see ScSecurityManagerIF
 * @see ScErrorManagerIF
 */
public interface ScContextSupplierIF
{
    ScSecurityManagerIF getSecurityManager();

    ScErrorManagerIF getErrorManager();
}
