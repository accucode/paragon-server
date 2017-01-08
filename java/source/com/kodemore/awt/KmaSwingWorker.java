/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.awt;

import javax.swing.SwingUtilities;

public abstract class KmaSwingWorker
{
    //##################################################
    //# variables
    //##################################################

    private Object    _value;
    private ThreadVar _threadVar;

    //##################################################
    //# constructor
    //##################################################

    public KmaSwingWorker()
    {
        final Runnable doFinished = new Runnable()
        {
            @Override
            public void run()
            {
                finished();
            }
        };

        Runnable doConstruct = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    setValue(construct());
                }
                finally
                {
                    _threadVar.clear();
                }
                SwingUtilities.invokeLater(doFinished);
            }
        };

        Thread t = new Thread(doConstruct);
        _threadVar = new ThreadVar(t);
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract Object construct();

    //##################################################
    //# accessing
    //##################################################

    protected synchronized Object getValue()
    {
        return _value;
    }

    private synchronized void setValue(Object x)
    {
        _value = x;
    }

    public Object get()
    {
        while ( true )
        {
            Thread t = _threadVar.get();
            if ( t == null )
                return getValue();
            try
            {
                t.join();
            }
            catch ( InterruptedException ex )
            {
                Thread.currentThread().interrupt();
                return null;
            }
        }
    }

    //##################################################
    //# actions
    //##################################################

    public void start()
    {
        Thread t = _threadVar.get();
        if ( t != null )
            t.start();
    }

    public void interrupt()
    {
        Thread t = _threadVar.get();

        if ( t != null )
            t.interrupt();

        _threadVar.clear();
    }

    public void finished()
    {
        // hook for subclasses
    }

    //##################################################
    //# threadvar
    //##################################################

    /**
     * Class to maintain reference to current worker thread
     * under separate synchronization control.
     */
    private static class ThreadVar
    {
        private Thread thread;

        private ThreadVar(Thread t)
        {
            thread = t;
        }

        private synchronized Thread get()
        {
            return thread;
        }

        private synchronized void clear()
        {
            thread = null;
        }
    }

}
