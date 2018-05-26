/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.servlet.utility;

import java.util.concurrent.atomic.AtomicInteger;

import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.variable.ScLocalIF;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.utility.Kmu;

public class ScLocalRegistry
    implements ScConstantsIF
{
    //##################################################
    //# static
    //##################################################

    private static ScLocalRegistry _instance;

    public static synchronized void install()
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = new ScLocalRegistry();
    }

    public static ScLocalRegistry getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private int                        _nextPersistentKey;
    private ThreadLocal<AtomicInteger> _nextTransientKey;
    private boolean                    _locked;

    //##################################################
    //# constructor
    //##################################################

    private ScLocalRegistry()
    {
        _nextPersistentKey = 0;
        _nextTransientKey = KmThreadLocalManager.newLocal();
        _locked = false;
    }

    //##################################################
    //# register
    //##################################################

    public void register(ScLocalIF e)
    {
        if ( _locked )
            registerTransient(e);
        else
            registerPersistent(e);
    }

    private void registerPersistent(ScLocalIF e)
    {
        int key = _nextPersistentKey;
        e.registerKey(key);
        _nextPersistentKey++;
    }

    private void registerTransient(ScLocalIF e)
    {
        AtomicInteger i = _nextTransientKey.get();
        if ( i == null )
        {
            i = new AtomicInteger(-1);
            _nextTransientKey.set(i);
        }

        int key = i.getAndDecrement();
        e.registerKey(key);
    }

    //==================================================
    //= lock
    //==================================================

    public void lock()
    {
        _locked = true;
    }
}
