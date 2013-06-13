package com.kodemore.servlet.action;

import com.kodemore.exception.KmApplicationException;

public interface ScActionContextIF
{
    /**
     * Run any general security checks that apply to this context.
     * This is typically used to check things like the current user's
     * access to all of the actions within a given activity.
     */
    void checkSecurity();

    /**
     * Handle any "error" that was thrown out of the action's 
     * handle method.  
     * 
     * These should be relatively rare - the preferred
     * approach is for each handler to take greater responsibility for
     * handling any specific errors that it can reasonably know about.
     * For example, suppose the action is validating and updating the 
     * user's required email address. Then the action should generally
     * check the email, and if empty, display a custom error message 
     * where appropriate.  This case should generally NOT throw an 
     * application exception out of the handler.
     * 
     * Simple cases aside, there are many conditions that are difficult
     * for local action handlers to manage politely, without an explosion
     * of error handling code for cases that are very rare.  Therefore
     * it is considered acceptable for virtually any part of the application
     * (or framework) to throw an Application Exception.  Doing so should
     * abort the current operation, rollback any database transaction, and
     * politely display the error to the user. 
     */
    void handleError(KmApplicationException ex);

    /**
     * Handle any "fatal" error that was thrown out of the action's
     * handle method. Fatal errors are generally unhandled exceptions; 
     * things like null pointer exceptions, or exceptions thrown out of 
     * the low level database drivers.
     * 
     * Such errors are ALWAYS indicative of a bug in the application,
     * even if that bug is only that failure to handle an unavoidable
     * error in a more polite way.
     * 
     * There is no specific contract at this time, but it is considered
     * reasonable for fatal exceptions to log the user out of the 
     * application and to display the full "ugly" stack trace.
     */
    void handleFatal(RuntimeException ex);
}
