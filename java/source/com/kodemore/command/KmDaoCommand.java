package com.kodemore.command;

import org.hibernate.StaleObjectStateException;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.dao.KmDaoSessionManager;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.hibernate.lock.KmDaoLockException;
import com.kodemore.hibernate.lock.KmDaoOptimisticLockException;
import com.kodemore.log.KmLogger;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

public abstract class KmDaoCommand
    extends KmCommand
{
    //##################################################
    //# constants
    //##################################################

    private static final KmLogger logger = KmLogger.create(KmDaoCommand.class);

    //##################################################
    //# variables
    //##################################################

    private int                   _warningThresholdMs;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoCommand()
    {
        _warningThresholdMs = getBridge().getWarningThresholdMs();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getWarningThresholdMs()
    {
        return _warningThresholdMs;
    }

    public void setWarningThresholdMs(int e)
    {
        _warningThresholdMs = e;
    }

    public boolean hasWarningThresholdMs()
    {
        return getWarningThresholdMs() > 0;
    }

    public void disableWarningThresholdMs()
    {
        setWarningThresholdMs(0);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void run()
    {
        boolean alreadyOpen = getSessionManager().hasSession();
        try
        {
            KmTimer timer = startTimer();

            if ( alreadyOpen )
                runInOpenTransaction();
            else
                runInNewTransaction();

            stopTimer(timer);
        }
        catch ( KmDaoRollbackException ex )
        {
            if ( alreadyOpen )
                throw ex;
        }
        catch ( KmDaoLockException ex )
        {
            throw ex;
        }
        catch ( RuntimeException ex )
        {
            handleError(ex);
        }
    }

    protected void handleError(RuntimeException ex)
    {
        if ( ex instanceof KmApplicationException )
            throw ex;

        throw withContext(ex);
    }

    private void runInOpenTransaction()
    {
        checkLock();
        runDao();
    }

    private void runInNewTransaction()
    {
        int retries = 0;
        int retryCount = getStaleObjectRetryCount();
        int retryDelayMs = getStaleObjectRetryDelayMs();

        while ( true )
            try
            {
                runOnceInNewTransaction();
                break;
            }
            catch ( RuntimeException ex )
            {
                Throwable root = Kmu.getRootCause(ex);
                if ( !(root instanceof StaleObjectStateException) )
                    throw ex;

                if ( retries < retryCount )
                {
                    retries++;
                    Kmu.sleepMs(retryDelayMs);
                    onStaleObjectRetry();
                    continue;
                }
                throw new KmDaoOptimisticLockException(ex);
            }
    }

    private void runOnceInNewTransaction()
    {
        KmDaoSessionManager mgr;
        mgr = getSessionManager();
        mgr.open();

        try
        {
            installLock();
            runDao();
            mgr.commit();
            releaseLock();
        }
        finally
        {
            if ( mgr.isActive() )
                mgr.rollbackSilently();

            mgr.closeQuietly();
        }
    }

    //##################################################
    //# framework overrides
    //##################################################

    /**
     * Do all work inside the dao session.
     * This is a framework extention, not an application extension.
     */
    protected void runDao()
    {
        preHandle();
        handle();
        postHandle();
    }

    /**
     * Do work before handle is called, but after the session starts.
     * This is a framework extention, not an application extension.
     */
    protected void preHandle()
    {
        // subclass override
    }

    /**
     * Do work after handle(), but before the session ends.
     * This is a framework extention, not an application extension.
     */
    protected void postHandle()
    {
        // subclass override
    }

    //##################################################
    //# timer
    //##################################################

    private KmTimer startTimer()
    {
        return KmTimer.run();
    }

    private void stopTimer(KmTimer timer)
    {
        timer.stop();
        checkTimer(timer);
    }

    protected void checkTimer(KmTimer timer)
    {
        checkWarningThreshold(timer);
    }

    private void checkWarningThreshold(KmTimer timer)
    {
        if ( !hasWarningThresholdMs() )
            return;

        double ms = timer.getMilliseconds();
        if ( ms < getWarningThresholdMs() )
            return;

        String s = Kmu.format("Slow command %sms, Class(%s)", (int)ms, getSimpleClassName());

        String c = getContext();
        if ( c != null )
            s += " Context:\n" + c;

        logger.warn(s);
    }

    //##################################################
    //# application override
    //##################################################

    protected abstract void handle();

    //##################################################
    //# lock
    //##################################################

    public boolean requiresLock()
    {
        return getLockKey() != null;
    }

    public String getLockKey()
    {
        return null;
    }

    public int getLockTimeoutSeconds()
    {
        return getBridge().getLockTimeoutSeconds();
    }

    public int getLockRetryCount()
    {
        return getBridge().getLockRetryCount();
    }

    public int getLockRetryDelayMs()
    {
        return getBridge().getLockRetryDelayMs();
    }

    //##################################################
    //# lock (private)
    //##################################################

    private void installLock()
    {
        if ( !requiresLock() )
            return;

        getDaoSession().lockFailing(
            getLockKey(),
            getLockTimeoutSeconds(),
            getLockRetryCount(),
            getLockRetryDelayMs());
    }

    private void releaseLock()
    {
        if ( !requiresLock() )
            return;

        getDaoSession().unlockQuietly();
    }

    private void checkLock()
    {
        if ( !requiresLock() )
            return;

        KmDaoSession session = getDaoSession();
        if ( !session.isLocked() )
            fatal(
                "Command(%s) requires lock(%s), but is running in unlocked transaction.",
                getSimpleClassName(),
                getLockKey());

        if ( !session.hasLock(getLockKey()) )
            fatal(
                "Command(%s) requires lock(%s), but is running in transaction with lock(%s).",
                getSimpleClassName(),
                getLockKey(),
                session.getLock());
    }

    //##################################################
    //# stale object retry
    //##################################################

    protected int getStaleObjectRetryCount()
    {
        return getBridge().getStaleObjectRetryCount();
    }

    protected int getStaleObjectRetryDelayMs()
    {
        return getBridge().getStaleObjectRetryDelayMs();
    }

    protected void onStaleObjectRetry()
    {
        getBridge().onStaleObjectRetry();
    }

    //##################################################
    //# support
    //##################################################

    protected KmDaoSessionManager getSessionManager()
    {
        return KmDaoSessionManager.getInstance();
    }

    protected KmDaoSession getDaoSession()
    {
        return getSessionManager().getDaoSession();
    }

    protected void fetch(Object e)
    {
        getDaoSession().fetch(e);
    }

    protected KmDaoBridge getBridge()
    {
        return KmDaoBridge.getInstance();
    }

}
