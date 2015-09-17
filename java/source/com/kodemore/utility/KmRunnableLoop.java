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

package com.kodemore.utility;

import com.kodemore.log.KmLog;
import com.kodemore.log.KmLogger;

/**
 * I implement a Runnable that is intended to run forever.  I log all
 * Exceptions and log them, but then continue.
 */
public abstract class KmRunnableLoop
    implements Runnable, KmConstantsIF
{
    //##################################################
    //# logger
    //##################################################

    private static final KmLogger logger = KmLogger.create(KmRunnableLoop.class);

    //##################################################
    //# variables
    //##################################################

    private Thread _thread;

    //##################################################
    //# abstract
    //##################################################

    /**
     * This is where the real work should be done.
     */
    public abstract void process() throws Exception;

    /**
     * Determine the amount of time to sleep after each iteration.
     */
    public abstract int getSleepMilliseconds();

    //##################################################
    //# accessing
    //##################################################

    public synchronized Thread getThread()
    {
        return _thread;
    }

    public synchronized boolean isOk()
    {
        return _thread != null && _thread.isAlive();
    }

    //##################################################
    //# thread
    //##################################################

    @Override
    public void run()
    {
        try
        {
            loop();
        }
        finally
        {
            String s = "LOOP TERMINATED: Unknown fatal exception in [" + getDebugName() + "].";
            KmLog.fatal(s);
        }
    }

    private void loop()
    {
        while ( true )
        {
            try
            {
                log();
                process();
            }
            catch ( Exception ex )
            {
                KmLog.error(ex, "LOOP ERROR: Attempting to continue loop (%s).", getDebugName());
            }
            Kmu.sleepMs(getSleepMilliseconds());
        }
    }

    //##################################################
    //# utility
    //##################################################

    public void start()
    {
        if ( isOk() )
            return;

        synchronized (this)
        {
            _thread = new Thread(this);
            _thread.start();
        }
    }

    private void log()
    {
        String s = "Running Loop: " + getDebugName();
        logger.debug(s);
    }

    private String getDebugName()
    {
        return Kmu.getSimpleClassName(this);
    }
}
