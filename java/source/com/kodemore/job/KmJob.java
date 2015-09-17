/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.job;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.hibernate.lock.KmhDaoLockException;
import com.kodemore.log.KmLog;
import com.kodemore.time.KmTimeConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * A simple wrapper for a job to be run.  Jobs are intended to be
 * used in conjuction with a Scheduler.
 */
public abstract class KmJob
{
    //##################################################
    //# variables
    //##################################################

    private long _lastStartTime;
    private long _lastEndTime;
    private int  _lastRunTime;

    private boolean _running;

    private boolean _ignoreLockExceptions;

    /**
     * Indicates if this job is active, or idle.
     * The job is considered active if there was significant activity
     * during last run.  Idle means that there was no significant activity
     * during the last run.  Jobs may define two frequencies, the active
     * frequency and the idle frequency.  This intent is to rapidly clear
     * queued work if there is any, but not to waste a lot of cycles on
     * checking the job when there is no work to be done.
     */
    private boolean _active;

    //##################################################
    //# constructor
    //##################################################

    public KmJob()
    {
        long now = now();

        _lastStartTime = now;
        _lastEndTime = now;

        _ignoreLockExceptions = true;
    }

    //##################################################
    //# public
    //##################################################

    /**
     * Run the job if after the next scheduled time.
     */
    public void check()
    {
        if ( isReadyToRun() )
            run();
    }

    public boolean isReadyToRun()
    {
        return now() >= getNextStartTime();
    }

    public boolean isActive()
    {
        return _active;
    }

    public void run()
    {
        _active = _run();
    }

    public boolean _run()
    {
        if ( !isRunnable() )
            return false;

        try
        {
            _running = true;
            _lastStartTime = now();
            return handle();
        }
        catch ( KmhDaoLockException ex )
        {
            return handleLockException();
        }
        catch ( KmApplicationException ex )
        {
            return handleApplicationException(ex);
        }
        catch ( Exception ex )
        {
            return handleException(ex);
        }
        finally
        {
            tryCleanUp();
            _lastEndTime = now();
            _lastRunTime = (int)(_lastEndTime - _lastStartTime);
            _running = false;
            tryLogPerformance(_lastRunTime);
        }
    }

    protected boolean isRunnable()
    {
        return isEnabled();
    }

    private boolean handleApplicationException(KmApplicationException ex)
    {
        if ( ex.hasSingleDatabaseLockError() )
            return handleLockException();

        KmLog.error(ex, "Error in Job: (%s).", getName());
        return true;
    }

    private boolean handleLockException()
    {
        if ( _ignoreLockExceptions )
            return true;

        KmLog.error("Cannot get database lock for job (%s).", getName());
        return false;
    }

    private boolean handleException(Exception ex)
    {
        KmLog.error(ex, "Error in Job: (%s).", getName());
        return true;
    }

    private void tryCleanUp()
    {
        try
        {
            cleanUp();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Error in job(%s) cleanup.", getName());
        }
    }

    public void reset()
    {
        long now = now();
        _lastStartTime = now;
        _lastEndTime = now;
        _lastRunTime = 0;
        _active = true;
    }

    protected void preRun()
    {
        // noop
    }

    protected void postRun()
    {
        // noop
    }

    protected void cleanUp()
    {
        // noop
    }

    //##################################################
    //# accessing
    //##################################################

    public long getLastStartTime()
    {
        return _lastStartTime;
    }

    public long getLastEndTime()
    {
        return _lastEndTime;
    }

    public int getLastRunTime()
    {
        if ( _running )
            return 0;
        return _lastRunTime;
    }

    public long getNextStartTime()
    {
        if ( _active )
            return getLastEndTime() + getActiveMs();
        return getLastEndTime() + getIdleMs();
    }

    public boolean isRunning()
    {
        return _running;
    }

    public String getName()
    {
        return Kmu.getSimpleClassName(this);
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Determines if the job should be run at all.
     */
    protected abstract boolean isEnabled();

    protected boolean isDisabled()
    {
        return !isEnabled();
    }

    /**
     * The frequency to run this job when active.
     */
    protected abstract int getActiveMs();

    /**
     * The frequency to run this job when idle.
     */
    protected int getIdleMs()
    {
        return getActiveMs();
    }

    /**
     * Run the job.  This should not be directly called by clients.
     * The return valid indicates if the job is considered to have
     * run.  This allows the job to do some minimal status checking
     * against the database and still return false to indicate that
     * no work was done.
     */
    protected abstract boolean handle();

    /**
     * The job manager should call this ONCE if the loop stops.
     * This allows the job to perform any cleanup and remove
     * any resources that may be cached across multiple runs.
     *
     * By default, this does nothing.
     */
    protected void handleStop()
    {
        // subclass
    }

    //##################################################
    //# log performance
    //##################################################

    private void tryLogPerformance(int ms)
    {
        try
        {
            logPerformance(ms);
        }
        catch ( Exception ex )
        {
            KmLog.fatal(ex, "Cannot log performance.");
        }
    }

    protected abstract void logPerformance(int ms);

    //##################################################
    //# support
    //##################################################

    private long now()
    {
        return System.currentTimeMillis();
    }

    protected int secondsToMs(Integer seconds)
    {
        return seconds * KmTimeConstantsIF.MS_PER_SECOND;
    }

    protected int minutesToMs(Integer minutes)
    {
        return minutes * KmTimeConstantsIF.MS_PER_MINUTE;
    }

}
