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

package com.kodemore.dao;

import com.kodemore.log.KmLog;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.utility.Kmu;

public abstract class KmDaoSessionManager
{
    //##################################################
    //# instance
    //##################################################

    private static KmDaoSessionManager _instance;

    public static void install(KmDaoSessionManager e)
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = e;
    }

    public static boolean isInstalled()
    {
        return _instance != null;
    }

    public static KmDaoSessionManager getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# thread local
    //##################################################

    private static final ThreadLocal<KmDaoSession> _session = KmThreadLocalManager.newLocal();

    //##################################################
    //# open / close
    //##################################################

    public void open()
    {
        KmDaoSession e = _getDaoSession();
        if ( e != null )
            throw Kmu.newFatal("Session already open.");

        e = newSession();
        e.open();

        _session.set(e);
    }

    public void close()
    {
        try
        {
            getDaoSession().close();
        }
        finally
        {
            try
            {
                _session.remove();
            }
            catch ( Exception ex )
            {
                KmLog.error(ex, "Failed to remove thread local session.");
            }
        }
    }

    public void closeQuietly()
    {
        try
        {
            close();
        }
        catch ( RuntimeException ex )
        {
            KmLog.error(ex, "Session.close failed, continuing....");
        }
    }

    //##################################################
    //# commit / rollback
    //##################################################

    public void begin()
    {
        getDaoSession().begin();
    }

    public void commit()
    {
        getDaoSession().commit();
    }

    public void rollback()
    {
        getDaoSession().rollback();
    }

    public void rollbackQuietly()
    {
        getDaoSession().rollbackQuietly();
    }

    public void rollbackSilently()
    {
        getDaoSession().rollbackSilently();
    }

    public void flush()
    {
        getDaoSession().flush();
    }

    //##################################################
    //# session
    //##################################################

    public boolean isActive()
    {
        return hasSession() && getDaoSession().isActive();
    }

    public boolean hasSession()
    {
        return _getDaoSession() != null;
    }

    public KmDaoSession getDaoSession()
    {
        KmDaoSession e = _getDaoSession();

        if ( e == null )
            throw Kmu.newFatal("Dao session NOT installed.");

        return e;
    }

    private KmDaoSession _getDaoSession()
    {
        return _session.get();
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract KmDaoSession newSession();
}
