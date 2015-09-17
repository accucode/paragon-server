package com.kodemore.command;

/**
 * Defaults for all commands, including those implemented
 * by the kodemore framework classes.  
 */
public class KmDaoBridge
{
    //##################################################
    //# install
    //##################################################

    private static KmDaoBridge _instance = new KmDaoBridge();

    protected static void install(KmDaoBridge e)
    {
        _instance = e;
    }

    public static KmDaoBridge getInstance()
    {
        return _instance;
    }

    //##################################################
    //# constructor
    //##################################################

    protected KmDaoBridge()
    {
        // protected
    }

    //##################################################
    //# warning
    //##################################################

    public int getWarningThresholdMs()
    {
        return 0;
    }

    //##################################################
    //# lock retry
    //##################################################

    /**
     * The number of times that the command should
     * attempt to grab the required lock, if any. 
     */
    public int getLockRetryCount()
    {
        return 0;
    }

    /**
     * The length of time the database should wait for
     * a lock during each attempt.
     */
    public int getLockTimeoutSeconds()
    {
        return 0;
    }

    /**
     * The length of time the application should wait
     * between multiple tries.
     */
    public int getLockRetryDelayMs()
    {
        return 0;
    }

    //##################################################
    //# stale object
    //##################################################

    /**
     * By default, commands are NOT retried when a Stale Object
     * error is thrown.  Subclasses can easily override this, but
     * must ensure that any initial state stored in the subclass
     * is reset for each retry.
     */
    protected int getStaleObjectRetryCount()
    {
        return 0;
    }

    /**
     * The delay, if any, to be used between tries.
     * This is the default, it can be overridden for
     * each command as necessary.
     */
    protected int getStaleObjectRetryDelayMs()
    {
        return 0;
    }

    /**
     * Called after the retry delay, but before the
     * next try.  Typically, used to reset state back
     * to the original condition.  
     */
    protected void onStaleObjectRetry()
    {
        // none
    }

}
