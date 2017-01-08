package com.kodemore.servlet.action;

import com.kodemore.exception.KmSecurityException;

/**
 * I handle security checks.  For example, checking if a user is required, or
 * if the user is required to have specific permissions to access a particular
 * part of the application.
 */
public interface ScSecurityManagerIF
{
    /**
     * Run any general security checks that apply to this context.
     * This is typically used to check things like the current user's
     * access to all of the actions within a given page.  If there
     * are any security violations, throw a KmSecurityException
     * with an brief message.
     */
    void checkSecurity();

    /**
     * This delegates to checkSecurity() but returns a boolean instead of
     * throwing a SecurityException.
     *
     * Return true if the security check passed.
     * Return false if the security check failed.
     *
     * Note that this only catches Security Exceptions.  Any other exceptions
     * such as applicationExceptions or runtimeExceptions are simply thrown.
     */
    default boolean checkSecuritySilently()
    {
        try
        {
            checkSecurity();
            return true;
        }
        catch ( KmSecurityException ex )
        {
            return false;
        }
    }

}
