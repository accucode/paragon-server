package com.kodemore.command;

import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.StaleObjectStateException;
import org.hibernate.StaleStateException;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.dao.KmDaoSessionManager;
import com.kodemore.exception.KmSignalingException;
import com.kodemore.hibernate.lock.KmhDaoOptimisticLockException;
import com.kodemore.log.KmLogger;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

/**
 * I implement a
 * @author Wyatt
 *
 */
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

    /**
     * Log a warning if the command takes too long to run.
     * This does not interrupt or otherwise affect the command.
     */
    private int _warningThresholdMs;

    /**
     * If true, ignore any stale object exceptions.
     * False by default.
     *
     * Stale object exceptions are typically thrown when two independent
     * threads attempt to modify the same object.  First in wins, the second
     * throws a stale object exception.
     *
     * If a stale object retry is defined, then any stale object exceptions
     * will be caught and handled as a retry.  Once the retry limit is
     * reached, any additional exception will be throw unless this flag
     * is set to ignore it.
     */
    private boolean _ignoreStaleExceptions;

    /**
     * The number of times to retry the transaction if a stale object
     * exception is detected.
     */
    private int _staleObjectRetryCount;

    /**
     * The delay to way before retrying the transaction after a stale
     * object exception.
     */
    private int _staleObjectRetryDelayMs;

    /**
     * The database lock key.  We primarily rely on optimistic locking
     * via the lockVersion column that is automatically managed for more
     * tables.  However, there are still some rare cases where a traditional
     * lock key is used.
     *
     * This creates a global lock on the entire database installation and
     * should generally be avoided except where absolutely necessary.
     */
    private String _lockKey;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoCommand()
    {
        KmDaoBridge bridge = getBridge();

        _warningThresholdMs = bridge.getWarningThresholdMs();
        _staleObjectRetryCount = bridge.getStaleObjectRetryCount();
        _staleObjectRetryDelayMs = bridge.getStaleObjectRetryDelayMs();
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

    public boolean getIgnoreStaleExceptions()
    {
        return _ignoreStaleExceptions;
    }

    public void setIgnoreStaleExceptions(boolean b)
    {
        _ignoreStaleExceptions = b;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void run()
    {
        try
        {
            KmTimer timer = startTimer();

            if ( getSessionManager().hasSession() )
                runInOpenTransaction();
            else
                runInNewTransaction();

            stopTimer(timer);
        }
        catch ( KmSignalingException ex )
        {
            throw ex;
        }
        catch ( RuntimeException ex )
        {
            throw withContext(ex);
        }
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
                if ( !isRetryable(ex) )
                    throw ex;

                if ( retries >= retryCount )
                {
                if ( _ignoreStaleExceptions )
                    break;

                throw new KmhDaoOptimisticLockException(ex);
            }

                retries++;
                Kmu.sleepMs(retryDelayMs);
                onStaleObjectRetry();
            }
    }

    /**
     * Determine if the exception indicates an error state that we can retry.
     *
     * For example, we can generally retry the Hibernate exceptions for
     * optimistic locking.
     *
     * Also, we retry constraint violation exceptions.  These generally indicate
     * a collision on a unique key/index.  In most cases this is effectively the
     * same type of situation as an optimistic lock, so we retry this as well.
     */
    private boolean isRetryable(RuntimeException ex)
    {
        Throwable root = Kmu.getRootCause(ex);

        return root instanceof StaleStateException
            || root instanceof StaleObjectStateException
            || root instanceof SQLIntegrityConstraintViolationException;
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
        catch ( KmDaoRollbackException ex )
        {
            // ignore
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

    public String getLockKey()
    {
        return _lockKey;
    }

    public void setLockKey(String e)
    {
        _lockKey = e;
    }

    public boolean requiresLock()
    {
        return getLockKey() != null;
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
            throw Kmu.newFatal(
                "Command(%s) requires lock(%s), but is running in unlocked transaction.",
                getSimpleClassName(),
                getLockKey());

        if ( !session.hasLock(getLockKey()) )
            throw Kmu.newFatal(
                "Command(%s) requires lock(%s), but is running in transaction with lock(%s).",
                getSimpleClassName(),
                getLockKey(),
                session.getLock());
    }

    //##################################################
    //# stale object retry
    //##################################################

    public final int getStaleObjectRetryCount()
    {
        return _staleObjectRetryCount;
    }

    public void setStaleObjectRetryCount(int e)
    {
        _staleObjectRetryCount = e;
    }

    public final int getStaleObjectRetryDelayMs()
    {
        return _staleObjectRetryDelayMs;
    }

    public void setStaleObjectRetryDelayMs(int e)
    {
        _staleObjectRetryDelayMs = e;
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
