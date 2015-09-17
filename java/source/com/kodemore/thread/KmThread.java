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

package com.kodemore.thread;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.kodemore.utility.Kmu;

/**
 * I provide a simple extension for 'killable' thread.  The kill
 * method does not (cannot) directly kill the thread.  Instead,
 * this provides a simple hook for thread clients to set a state
 * that the thread subclass can monitor and used to determine
 * when to die.
 */
public class KmThread
    extends Thread
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Used to indicate that someone has requested that I stop.
     *
     * This is used to politely stop a thread, allowing the thread
     * to decide when to exit.  The problem with using interrupt() is that
     * we may not really want to interrupt/stop the thread in the middle of
     * wait or io operation.
     */
    private boolean _stopRequest;

    //##################################################
    //# constructor
    //##################################################

    public KmThread()
    {
        // none
    }

    public KmThread(Runnable e)
    {
        super(e);
    }

    public <A> KmThread(Consumer<A> con, A a)
    {
        this(Kmu.toRunnable(con, a));
    }

    public <A, B> KmThread(BiConsumer<A,B> con, A a, B b)
    {
        this(Kmu.toRunnable(con, a, b));
    }

    //##################################################
    //# start
    //##################################################

    /**
     * Wait the requested number of seconds, then start this thread.
     * The waiting is also done in a separate thread so that the caller
     * is not interrupted.
     */
    public void startLater(final int secs)
    {
        final Thread me = this;
        new Thread()
        {
            @Override
            public void run()
            {
                Kmu.sleepSeconds(secs);
                me.start();
            }
        }.start();
    }

    /**
     * Start this a short time later, typically after about 1 second.
     */
    public void startLater()
    {
        startLater(1);
    }

    //##################################################
    //# stop request
    //##################################################

    /**
     * Request that this thread stop at the next appropriate time.
     * This simply sets a flag, which the thread should be implemented to
     * check periodically.
     */
    public void requestStop()
    {
        _stopRequest = true;
    }

    /**
     * Request that the thread stop, then wait until it dies.
     */
    public void requestStopAndWait()
    {
        requestStop();
        waitForDeath();
    }

    public boolean hasStopRequest()
    {
        return _stopRequest;
    }

    //##################################################
    //# wait
    //##################################################

    /**
     * Wait for this thread to die.
     * If called on myself, this will never finish.
     */
    public void waitForDeath()
    {
        while ( isAlive() )
            Kmu.sleepMs(100);
    }

}
