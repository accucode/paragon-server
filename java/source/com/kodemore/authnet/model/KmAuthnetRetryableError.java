package com.kodemore.authnet.model;

/**
 * I am used to indicate that although the request failed
 * unexpectedly, it is safe to retry the transaction.
 *
 * For example, the client pay attempt to charge a credit card.
 * If unable to connect to the authnet server, then it is assumed
 * that the transaction can be safeful retried at some later time.
 * In this case a retryable error will be thrown.
 *
 * On the other hand, if we successfully send the charge request
 * to authnet but fail when trying to parse the response, then there
 * is no way to know if Authnet already applied the charge, and some
 * other non-retryable exception should be thrown instead.
 */
public class KmAuthnetRetryableError
    extends RuntimeException
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If true, then the exception will be logged as a warning
     * rather than an exception.
     */
    private boolean _logWarn;

    /**
     * If true, this transaction can be retried automatically.
     * No intervention or review is required by any party.
     */
    private boolean _autoRetry;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetRetryableError(Throwable cause)
    {
        super(cause);
    }

    public KmAuthnetRetryableError(String message)
    {
        super(message);
    }

    //##################################################
    //# accessing
    //##################################################

    public void setLogWarn()
    {
        _logWarn = true;
    }

    public boolean isLogWarn()
    {
        return _logWarn;
    }

    public void setAutoRetry()
    {
        _autoRetry = true;
    }

    public boolean isAutoRetry()
    {
        return _autoRetry;
    }

    //##################################################
    //# convenience
    //##################################################

    public String getRootMessage()
    {
        return getRootCause().getMessage();
    }

    public Throwable getRootCause()
    {
        Throwable ex = this;
        while ( true )
        {
            if ( ex.getCause() == null )
                return ex;

            ex = getCause();
        }
    }
}
