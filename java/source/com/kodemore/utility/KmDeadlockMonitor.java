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

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import com.kodemore.log.KmLog;

/**
 * I provide a simple way to monitor for JVM thread deadlocks
 * and report them.
 */
public class KmDeadlockMonitor
    implements Runnable
{
    //##################################################
    //# static
    //##################################################

    public static void start()
    {
        Thread e;
        e = new Thread(new KmDeadlockMonitor());
        e.setDaemon(true);
        e.start();
    }

    //##################################################
    //# constructor
    //##################################################

    private KmDeadlockMonitor()
    {
        // none
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void run()
    {
        while ( true )
        {
            checkForDeadlocks();
            Kmu.sleepSeconds(10);
        }
    }

    //##################################################
    //# support
    //##################################################

    private void checkForDeadlocks()
    {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] ids = bean.findMonitorDeadlockedThreads();
        if ( ids == null || ids.length == 0 )
            return;

        String msg = "THREAD DEADLOCK; use a thread dump for additional detail.";
        System.out.println(msg);
        KmLog.error(msg);
    }
}
