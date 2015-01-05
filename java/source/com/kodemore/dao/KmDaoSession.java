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

package com.kodemore.dao;

import java.math.BigInteger;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kodemore.hibernate.lock.KmDaoPessimisticLockException;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

public abstract class KmDaoSession
{
    //##################################################
    //# variables
    //##################################################

    private Session     _session;
    private Transaction _transaction;

    private String      _lockKey;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoSession()
    {
        // none
    }

    //##################################################
    //# public
    //##################################################

    public void open()
    {
        _session = newSession();
        begin();
    }

    public void close()
    {
        checkLockOnClose();
        checkTransactionOnClose();

        _transaction = null;

        _session.close();
        _session = null;
    }

    public void begin()
    {
        if ( _transaction == null )
        {
            _transaction = _session.beginTransaction();
            return;
        }

        if ( _transaction.isActive() )
            throw Kmu.newFatal("Attempt to begin transaction, but transaction is already 'active'.");

        _transaction.begin();
        clearCache();
    }

    public void commit()
    {
        _transaction.commit();
        clearCache();
    }

    public void commitAndContinue()
    {
        commit();
        begin();
    }

    public void rollback()
    {
        _transaction.rollback();
        clearCache();
    }

    /**
     * Attempt to rollback the transaction, any exceptions are logged instead of being thrown.
     */
    public void rollbackQuietly()
    {
        try
        {
            rollback();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Session.rollback failed, continuing....");
        }
    }

    /**
     * Attempt to rollback the transaction, any exceptions are ignored.
     */
    public void rollbackSilently()
    {
        try
        {
            rollback();
        }
        catch ( Exception ex )
        {
            // none
        }
    }

    public void clear()
    {
        clearCache();
        getSession().clear();
    }

    public void flush()
    {
        getSession().flush();
    }

    public boolean isDirty()
    {
        return getSession().isDirty();
    }

    public void evict(Object e)
    {
        getSession().evict(e);
    }

    public void save(Object e)
    {
        getSession().save(e);
    }

    public void delete(Object e)
    {
        getSession().delete(e);
    }

    public void update(Object e)
    {
        getSession().update(e);
    }

    @SuppressWarnings("unchecked")
    public <T> T merge(T e)
    {
        return (T)getSession().merge(e);
    }

    public boolean isActive()
    {
        return getTransaction().isActive();
    }

    public void fetch(Object e)
    {
        Hibernate.initialize(e);
    }

    //##################################################
    //# cache
    //##################################################

    /**
     * I provide a hook for subclasses to manage custom caching.
     * This method marks the end of a cache period.
     * And cached values should be discarded.
     * See also, beginCache().
     */
    protected void clearCache()
    {
        // subclass override
    }

    //##################################################
    //# lock (connection)
    //##################################################

    /**
     * Attempt to lock the specified key and return an immediate
     * response indicating if the lock was successful or not.
     */
    public boolean lock(String key)
    {
        return lock(key, 0, 0, 0);
    }

    /**
     * Key: the key that is used to coordinate the database lock.
     *
     * RetryCount: the number of RE-tries when attempting to get a lock.
     * A count of zero means 1 try total.
     *
     * RetryDelayMs: If the retry count is > 0, this is the number of ms to
     * wait between each try.
     *
     * TimeoutSeconds: This value is passed to the database and control how
     * long the database itself waits when attempting to get the lock.  Zero
     * is a valid value.
     *
     * The return value is true to indicate that the lock has been successfully
     * acquired, or false to indicate that the lock was already in use by some
     * other connection.
     *
     * A non-specialized RuntimeException is thrown for low level database
     * problems such as: no connection, or malformed sql syntax.  RuntimeExceptions
     * are also generated for problems such as an attempt to lock on an empty key,
     * or an attempt to lock the key that is already locked by this connection.
     */
    public boolean lock(String key, int timeoutSeconds, int retryCount, int retryDelayMs)
    {
        if ( Kmu.isEmpty(key) )
            throw Kmu.newFatal("Cannot create lock on empty key.");

        if ( Kmu.hasValue(_lockKey) )
            throw Kmu.newFatal("Cannot lock(%s), already locked on(%s).", key, _lockKey);

        String sql = Kmu.format("select get_lock('%s', %s)", key, timeoutSeconds);

        int i = 0;
        while ( true )
        {
            if ( _lock(sql) )
            {
                _lockKey = key;
                return true;
            }

            if ( i >= retryCount )
                return false;

            i++;
            Kmu.sleepMs(retryDelayMs);
        }
    }

    /**
     * Like lock, but will throw an KmLockFailureException in cases that would
     * otherwise have returned false from the lock() method.  Non-specialized
     * RuntimeExceptions may still be thrown for low level problems like database
     * connections, or malformed sql syntax.
     */
    public void lockFailing(String key)
    {
        if ( !lock(key) )
            throw new KmDaoPessimisticLockException(key);
    }

    public void lockFailing(String key, int timeoutSeconds, int retryCount, int retryDelayMs)
    {
        if ( !lock(key, timeoutSeconds, retryCount, retryDelayMs) )
            throw new KmDaoPessimisticLockException(key);
    }

    /**
     * Release the current database lock.
     */
    public void unlock()
    {
        if ( _lockKey == null )
            throw Kmu.newFatal("Cannot unlock; no current lock.");

        String sql = Kmu.format("select release_lock('%s')", _lockKey);
        Integer x = _executeLockCommand(sql);

        if ( x == null )
            throw Kmu.newFatal("Cannot release lock(%s); lock does not exist.", _lockKey);

        if ( x == 0 )
            throw Kmu.newFatal(
                "Cannot release lock(%s); lock is held by another connection.",
                _lockKey);

        if ( x == 1 )
        {
            _lockKey = null;
            return;
        }

        throw Kmu.newFatal("Cannot release lock(%s); unknown response code(%s).", _lockKey, x);
    }

    /**
     * Same as unlock except any expcetions are logged but not thrown.
     */
    public void unlockQuietly()
    {
        try
        {
            unlock();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot release database lock.");
        }
    }

    //##################################################
    //# lock (accessing)
    //##################################################

    public String getLock()
    {
        return _lockKey;
    }

    /**
     * Determine if this connection has any lock.
     */
    public boolean isLocked()
    {
        return _lockKey != null;
    }

    /**
     * Determine if this connection has a specific lock.
     */
    public boolean hasLock(String key)
    {
        return Kmu.isEqual(_lockKey, key);
    }

    //##################################################
    //# lock (general)
    //##################################################

    /**
     * Determine if the specified lock is busy.
     * This test is not specific to this connection.
     */
    public boolean isLockBusy(String key)
    {
        return !isLockFree(key);
    }

    /**
     * Determine if the specified lock is free.
     * This test is not specific to this connection.
     */
    public boolean isLockFree(String key)
    {
        if ( Kmu.isEmpty(key) )
            throw Kmu.newFatal("Cannot check lock status for empty key.");

        String sql = Kmu.format("select is_free_lock('%s')", key);
        Integer x = _executeLockCommand(sql);

        if ( x == null )
            throw Kmu.newFatal("Database error for: %s", sql);

        if ( x == 1 )
            return true;

        if ( x == 0 )
            return false;

        throw Kmu.newFatal("Unhandled database response(%s) for: %s", x, sql);
    }

    //##################################################
    //# lock (private)
    //##################################################

    private Integer _executeLockCommand(String sql)
    {
        SQLQuery q = null;
        try
        {
            q = _session.createSQLQuery(sql);
            Object res = q.uniqueResult();

            if ( res instanceof BigInteger )
                return ((BigInteger)res).intValue();

            return (Integer)res;
        }
        catch ( Exception ex )
        {
            throw Kmu.newFatal(ex, "Locking error; %s", sql);
        }
    }

    private boolean _lock(String sql)
    {
        Integer x = _executeLockCommand(sql);
        if ( x == null )
            throw Kmu.newFatal("Locking error; database error for: %s", sql);

        // success
        if ( x == 1 )
            return true;

        // timeout
        if ( x == 0 )
            return false;

        throw Kmu.newFatal("Locking error; unhandled result(%s) for: %s", x, sql);
    }

    private void checkLockOnClose()
    {
        if ( !isLocked() )
            return;

        KmLog.warnTrace(
            "A connection is being closed without releasing the database lock(%s).  Attempting to auto-unlock.",
            _lockKey);
        unlockQuietly();
    }

    private void checkTransactionOnClose()
    {
        if ( _transaction != null && _transaction.isActive() )
            KmLog.warnTrace("A connection is being closed with an active transaction.");
    }

    //##################################################
    //# hibernate
    //##################################################

    public Session getSession()
    {
        return _session;
    }

    public Transaction getTransaction()
    {
        return _transaction;
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract Session newSession();

}
