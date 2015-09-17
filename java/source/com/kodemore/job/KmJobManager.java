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

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.lock.KmhDaoOptimisticLockException;
import com.kodemore.hibernate.lock.KmhDaoPessimisticLockException;
import com.kodemore.log.KmLog;
import com.kodemore.log.KmLogger;
import com.kodemore.thread.KmThread;
import com.kodemore.utility.Kmu;

public abstract class KmJobManager
{
    //##################################################
    //# variables
    //##################################################

    private String   _name;
    private KmThread _thread;
    private KmLogger _logger;

    //##################################################
    //# constructor
    //##################################################

    public KmJobManager()
    {
        _name = Kmu.getSimpleClassName(this);
        _thread = null;
        _logger = KmLogger.create(getClass());
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    //##################################################
    //# thread
    //##################################################

    public synchronized void start()
    {
        if ( _thread != null )
            return;

        _thread = newThread();
        _thread.startLater();
    }

    public synchronized void stop()
    {
        if ( _thread == null )
            return;

        KmLog.info("Job Manager (%s), stopping...", _name);

        _thread.requestStopAndWait();
        _thread = null;
    }

    public synchronized boolean isRunning()
    {
        return _thread != null;
    }

    //##################################################
    //# private
    //##################################################

    private KmThread newThread()
    {
        return new KmThread()
        {
            @Override
            public void run()
            {
                try
                {
                    KmLog.info("Job Manager (%s), started.", _name);

                    onStart();
                    loop();
                    onStop();

                    KmLog.info("Job Manager (%s), stopped.", _name);
                }
                finally
                {
                    if ( !hasStopRequest() )
                        KmLog.fatal(
                            "Job Manager TERMINATED: Unknown fatal exception in (%s).",
                            _name);
                }
            }

            private void loop()
            {
                while ( !hasStopRequest() )
                    try
                    {
                        runOnce();
                        loopSleep();
                    }
                    catch ( Throwable ex )
                    {
                        KmLog.fatal(ex, "Job Manager Error(%s), Continuing.", _name);
                    }
            }
        };
    }

    /**
     * Called once, before the loop starts.
     * Subclasses can optionally override this.
     */
    protected void onStart()
    {
        // subclass
    }

    /**
     * Called once, after the loop stops normally via stop().
     * Subclasses can optionally override this.
     */
    protected void onStop()
    {
        // subclass
    }

    /**
     * Perform the work of a single iteration.
     * The manager is responsible for managing the loop.
     */
    protected abstract void runOnce();

    /**
     * Determine how long the manager should wait before
     */
    protected abstract int getLoopSleepMs();

    //##################################################
    //# utility
    //##################################################

    protected void runJob(KmJob e)
    {
        try
        {
            if ( !e.isReadyToRun() )
                return;

            debug("job (%s) starting...", e.getName());
            e.run();
            debug("job (%s) done.", e.getName());
        }
        catch ( KmhDaoPessimisticLockException ex )
        {
            KmLog.warn("Skipping job(%s), pessimistic lock failed.", e.getName());
        }
        catch ( KmhDaoOptimisticLockException ex )
        {
            KmLog.warn("Skipping job(%s), optimistic lock failed.", e.getName());
        }
        catch ( Exception ex )
        {
            KmLog.fatal(ex, "CRON ERROR in job(%s)", e.getName());
        }
    }

    /**
     * Determine the number of ms until the next job is scheduled to start.
     * This may return a negative number if one of the jobs is already overdue.
     */
    protected int getMsToNextJob(KmList<KmJob> v)
    {
        long next = Long.MAX_VALUE;

        for ( KmJob e : v )
            if ( e.isEnabled() )
                next = Math.min(next, e.getNextStartTime());

        return (int)(next - now());
    }

    /**
     * Sleep for a while before iterating the loop again.
     * This is done to avoid needlessly tying up the cpu when we know
     * that there are no jobs scheduled to run again for a while.
     *
     * Note that the maximum sleep time is constrained to a few seconds.
     * This means that even if no jobs are scheduled to run for another hour
     * the manager will continue to wake up and check every few seconds.
     * This is done for two purposes:
     *
     * 1) So we can dynamically change the frequency of a job.
     * 2) So we can politely shutdown the job manager without waiting a long time.
     */
    private void loopSleep()
    {
        int def = getLoopSleepMs();
        int min = 0;
        int max = 5000;

        int ms = Kmu.constrain(def, min, max);
        Kmu.sleepMs(ms);
    }

    //##################################################
    //# support
    //##################################################

    private long now()
    {
        return System.currentTimeMillis();
    }

    protected void debug(String s, Object... args)
    {
        getLogger().debug(s, args);
    }

    protected KmLogger getLogger()
    {
        return _logger;
    }

}
