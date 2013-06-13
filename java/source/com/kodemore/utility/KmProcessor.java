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

package com.kodemore.utility;

import com.kodemore.log.KmLog;

/**
 * I am used to model a process that returns a single value.
 */
public class KmProcessor
{
    //##################################################
    //# variables
    //##################################################

    private KmProcessIF _process;
    private Thread      _thread;
    private boolean     _ok;
    private Object      _result;

    private int         _delayMs;
    private int         _timeoutMs;

    //##################################################
    //# constructor
    //##################################################

    public KmProcessor()
    {
        _delayMs = 1000; //  1 second
        _timeoutMs = 10000; // 10 seconds
    }

    //##################################################
    //# accessing
    //##################################################

    public KmProcessIF getProcess()
    {
        return _process;
    }

    public void setProcess(KmProcessIF e)
    {
        _process = e;
    }

    public int getDelayMs()
    {
        return _delayMs;
    }

    public void setDelayMs(int ms)
    {
        _delayMs = ms;
    }

    public int getTimeoutMs()
    {
        return _timeoutMs;
    }

    public void setTimeoutMs(int ms)
    {
        _timeoutMs = ms;
    }

    public Object getResult()
    {
        return _result;
    }

    public void setResult(Object e)
    {
        _result = e;
    }

    //##################################################
    //# actions
    //##################################################

    public void run()
    {
        _thread = _newThread();
        _ok = false;
        _result = null;
        _thread.start();
        _watch();
    }

    public boolean isRunning()
    {
        return _thread != null && _thread.isAlive();
    }

    public boolean isOk()
    {
        return _ok;
    }

    public long now()
    {
        return System.currentTimeMillis();
    }

    //##################################################
    //# private
    //##################################################

    public Thread _newThread()
    {
        return new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    _result = _process.run();
                }
                catch ( Exception ex )
                {
                    KmLog.error(ex, "Error in processor, continuing.");
                }
            }
        };
    }

    public void _watch()
    {
        long start = now();
        while ( true )
        {
            if ( now() - start > _timeoutMs )
            {
                _thread.interrupt();
                break;
            }
            Kmu.sleep(_delayMs);
            if ( !_thread.isAlive() )
            {
                _ok = true;
                _thread = null;
                break;
            }
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmProcessIF e = new KmProcessIF()
        {
            @Override
            public Object run()
            {
                int n = 10;
                for ( int i = 0; i < n; i++ )
                    Kmu.sleep(100);
                return "success";
            }
        };

        KmProcessor p = new KmProcessor();
        p.setDelayMs(100);
        p.setTimeoutMs(5000);
        p.setProcess(e);
        p.run();

        System.out.println("isRunning: " + p.isRunning());
        System.out.println("ok:        " + p.isOk());
        System.out.println("result:    " + p.getResult());
        System.out.println("done.");
    }

}
