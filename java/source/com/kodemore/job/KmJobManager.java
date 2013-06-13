/*
  Copyright (c) 2005-2011 www.kodemore.com

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
import com.kodemore.hibernate.lock.KmDaoOptimisticLockException;
import com.kodemore.hibernate.lock.KmDaoPessimisticLockException;
import com.kodemore.log.KmLog;
import com.kodemore.log.KmLogger;
import com.kodemore.thread.KmKillableThread;
import com.kodemore.utility.Kmu;

public abstract class KmJobManager
{
    //##################################################
    //# variables
    //##################################################

    private String           _name;
    private KmKillableThread _thread;
    private KmLogger         _logger;

    //##################################################
    //# constructor
    //##################################################

    public KmJobManager()
    {
        _name = Kmu.getSimpleClassName(this);
        _thread = null;
        _logger = KmLogger.getLogger(getClass());
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
        startDelayedMs(0);
    }

    public void startDelayedSeconds(int secs)
    {
        startDelayedMs(secs * 1000);
    }

    public synchronized void startDelayedMs(int ms)
    {
        if ( _thread != null )
            return;

        _thread = newThread(ms);
        _thread.start();
    }

    public synchronized void stop()
    {
        if ( _thread == null )
            return;

        KmLog.info("Stopping Job Manager (%s).", _name);
        _thread.kill();
        _thread = null;
    }

    public synchronized boolean isRunning()
    {
        return _thread != null;
    }

    //##################################################
    //# private
    //##################################################

    private KmKillableThread newThread(final int startDelayMs)
    {
        return new KmKillableThread()
        {
            @Override
            public void run()
            {
                try
                {
                    Kmu.sleep(startDelayMs);
                    KmLog.info("Starting Job Manager (%s).", _name);

                    while ( true )
                        try
                        {
                            loop();
                            cycleSleep();
                            if ( isKilled() )
                                break;
                        }
                        catch ( Throwable ex )
                        {
                            KmLog.fatal(ex, "Job Manager Error(%s), Continuing.", _name);
                        }
                }
                finally
                {
                    _thread = null;
                    if ( !isKilled() )
                        KmLog.fatal(
                            "Job Manager TERMINATED: Unknown fatal exception in (%s).",
                            _name);
                }
            }
        };
    }

    protected abstract void loop();

    protected abstract int getCycleSleepMs();

    //##################################################
    //# utility
    //##################################################

    protected void runJob(KmJob j)
    {
        try
        {
            if ( !j.isReadyToRun() )
                return;

            debug("job (%s) start...", j.getName());
            j.start();
            debug("job (%s) done.", j.getName());
        }
        catch ( KmDaoPessimisticLockException ex )
        {
            KmLog.warn("Skipping job(%s), pessimistic lock failed.", j.getName());
        }
        catch ( KmDaoOptimisticLockException ex )
        {
            KmLog.warn("Skipping job(%s), optimistic lock failed.", j.getName());
        }
        catch ( Exception ex )
        {
            KmLog.fatal(ex, "CRON ERROR in job(%s)", j.getName());
        }
    }

    protected int getMsToNextJob(KmList<KmJob> v)
    {
        int min = 500;
        int max = 60000;

        if ( v.isEmpty() )
            return max;

        long now = now();

        long next = Long.MAX_VALUE;
        for ( KmJob e : v )
        {
            if ( e.isDisabled() )
                continue;

            long i = e.getNextStartTime();
            if ( i <= now )
                return min;

            next = Math.min(next, i);
        }

        int ms = (int)(next - now);
        return Kmu.constrain(ms, min, max);
    }

    private void cycleSleep()
    {
        Kmu.sleep(getCycleSleepMs());
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
