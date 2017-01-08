package com.kodemore.servlet.action;

import com.kodemore.exception.KmApplicationException;

/**
 * I define handling of errors, that is KmApplicationExceptions.
 *
 * These types of errors are typically displayed in a relatively polite
 * way to users and are used to handle things like...
 * - required field is missing a value
 * - duplicate key
 * - field too long
 *
 * When feasible, the local ui should display field specific help rather
 * than relying the the container/page to display a generic error.  For
 * example, if Name is required to be unique, it is usually better to
 * display the error messsage as part of the name field.
 */
public interface ScErrorManagerIF
{
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

}
