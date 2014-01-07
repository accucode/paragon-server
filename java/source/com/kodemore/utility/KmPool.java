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

import com.kodemore.collection.KmList;

/**
 * I am used to manage a pool of resources that are shared and reused
 * but which are not thread safe.  I take care of synchronizing access
 * to the process or creating, accessing, and releasing resources.
 * Null instances are not supported.
 */
public abstract class KmPool
{
    //##################################################
    //# variables
    //##################################################

    private KmList<Object> _inList;
    private KmList<Object> _outList;

    private int            _retryCount;
    private int            _retryDelayMs;

    //##################################################
    //# constructor
    //##################################################

    public KmPool()
    {
        _inList = new KmList<Object>();
        _outList = new KmList<Object>();
    }

    //##################################################
    //# accessing
    //##################################################

    public Object get()
    {
        // this is NOT synchroized to allow other clients to perform
        // checkIns while retrying the checkOut.
        Object e = _getValue();
        preGet(e);
        return e;
    }

    public synchronized void release(Object e)
    {
        if ( !_outList.contains(e) )
            error("Cannot checkin; object is not checked out: " + e);
        postRelease(e);
        _outList.remove(e);
        _inList.add(e);
    }

    //##################################################
    //# private
    //##################################################

    public Object _getValue()
    {
        Object e;
        e = _getExisting();
        if ( e != null )
            return e;

        e = _retry();
        if ( e != null )
            return e;

        return _getCreate();
    }

    public Object _retry()
    {
        int n = _retryCount;
        for ( int i = 0; i < n; i++ )
        {
            Kmu.sleepMs(_retryDelayMs);
            Object e = _getExisting();
            if ( e != null )
                return e;
        }
        return null;
    }

    public synchronized Object _getExisting()
    {
        if ( _inList.isEmpty() )
            return null;
        Object e = _inList.removeLast();
        _outList.add(e);
        return e;
    }

    public synchronized Object _getCreate()
    {
        Object e;
        e = _getExisting();
        if ( e != null )
            return e;
        e = create();
        _outList.add(e);
        return e;
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract Object create();

    public void preGet(Object e)
    {
        // hook for subclasses.
    }

    public void postRelease(Object e)
    {
        // hook for subclasses.
    }

    //##################################################
    //# utility
    //##################################################

    public void error(String s)
    {
        throw new RuntimeException(s);
    }
}
