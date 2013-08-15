/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.sql;

import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLogger;
import com.kodemore.utility.Kmu;

/**
 * I am used to provide simple connection pooling suitable for development,
 * but am not intended for production.
 */
public class KmSqlPooledConnectionFactory
    implements KmSqlConnectionFactoryIF
{
    //##################################################
    //# constants
    //##################################################

    private static final KmLogger    logger = KmLogger.create(KmSqlPooledConnectionFactory.class);

    //##################################################
    //# variables
    //##################################################

    private KmSqlConnectionFactoryIF _connectionFactory;
    private KmList<KmSqlConnection>  _openConnections;
    private KmList<KmSqlConnection>  _closedConnections;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlPooledConnectionFactory(KmSqlConnectionFactoryIF f)
    {
        _connectionFactory = f;
        _openConnections = new KmList<KmSqlConnection>();
        _closedConnections = new KmList<KmSqlConnection>();
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return _connectionFactory.getName();
    }

    //##################################################
    //# actions
    //##################################################

    @Override
    public synchronized KmSqlConnection open()
    {
        KmSqlConnection c = _open();
        _openConnections.add(c);
        _logCount("Open");
        return c;
    }

    private KmSqlConnection _open()
    {
        KmSqlConnection c;

        while ( _closedConnections.isNotEmpty() )
        {
            c = _closedConnections.removeLast();
            if ( _isAlive(c) )
                return c;
        }

        int n = getNewConnectionRetryCount() + 1;
        for ( int i = 0; i < n; i++ )
        {
            c = _createConnection();
            if ( _isAlive(c) )
                return c;
            Kmu.sleepMs(getNewConnectionRetryDelayMs());
        }

        throw new RuntimeException("Cannot get live connection.  Reason unknown.");
    }

    public synchronized void close(KmSqlConnection c)
    {
        _openConnections.remove(c);
        if ( _isAlive(c) )
            _closedConnections.add(c);
        _logCount("Close");
    }

    public synchronized void reset()
    {
        _closeAll(_openConnections);
        _closeAll(_closedConnections);
        _logCount("Reset");
    }

    //##################################################
    //# retry overrides
    //##################################################

    public int getNewConnectionRetryCount()
    {
        return 0;
    }

    public int getNewConnectionRetryDelayMs()
    {
        return 0;
    }

    //##################################################
    //# counts
    //##################################################

    public int getOpenConnectionCount()
    {
        return _openConnections.size();
    }

    public int getClosedConnectionCount()
    {
        return _closedConnections.size();
    }

    public int getPooledConnectionCount()
    {
        return getOpenConnectionCount() + getClosedConnectionCount();
    }

    //##################################################
    //# private
    //##################################################

    public KmSqlConnection _createConnection()
    {
        long t1 = System.nanoTime();

        KmSqlConnection c;
        c = _connectionFactory.open();
        c.setPool(this);

        long t2 = System.nanoTime();
        _logTime("Create new connection", t1, t2);
        return c;
    }

    public boolean _isAlive(KmSqlConnection c)
    {
        return c.isOpen();
    }

    public void _closeAll(List<KmSqlConnection> v)
    {
        for ( KmSqlConnection c : v )
            c.closeInnerConnection();
        v.clear();
    }

    public void _logCount(String s)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(_connectionFactory.getName());
        sb.append(": ");
        sb.append(s);
        sb.append(" (");
        sb.append(_openConnections.size());
        sb.append("/");
        sb.append(_closedConnections.size());
        sb.append(") ");
        _log(sb.toString());
    }

    public void _logTime(String s, long nanos1, long nanos2)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(_connectionFactory.getName());
        sb.append(": ");
        sb.append(s);
        sb.append(" (");
        sb.append((nanos2 - nanos1) / 1000000);
        sb.append(" ms)");
        _log(sb.toString());
    }

    public void _log(String s)
    {
        logger.debug(s);
    }

}
