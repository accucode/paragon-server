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

package com.kodemore.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kodemore.log.KmLog;
import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.utility.Kmu;

/**
 * A simple wrapper for java.sql.Statement
 */
public class KmSqlStatementWrapper
    implements KmSqlConstantsIF
{
    //##################################################
    //# static
    //##################################################

    /**
     * See _slowSqlThresholdMs
     */
    public static int defaultSlowSqlThresholdMs = 0;

    public static void disableDefaultSlowSqlWarnings()
    {
        defaultSlowSqlThresholdMs = 0;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The connection that created this statement;
     */
    private KmSqlConnection _connection;

    /**
     * The java.util.Statement that is wrapped for convenience.
     */
    private Statement _statement;

    /**
     * Any statements with a time >= this threshold will be printed
     * as a warning.  A threshold of 0 disables the warnings.
     */
    private int _slowSqlThresholdMs;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Create an instance that wraps a java.sql.Statement.
     */
    public KmSqlStatementWrapper(KmSqlConnection con, Statement s)
    {
        _connection = con;
        _statement = s;
        _slowSqlThresholdMs = defaultSlowSqlThresholdMs;
    }

    //##################################################
    //# warning threshold
    //##################################################

    public int getSlowSqlThresholdMs()
    {
        return _slowSqlThresholdMs;
    }

    public void setSlowSqlThresholdMs(int e)
    {
        _slowSqlThresholdMs = e;
    }

    public void disableSlowSqlWarnings()
    {
        setSlowSqlThresholdMs(0);
    }

    //##################################################
    //# execute
    //##################################################

    /**
     * Execute a query and return the wrapped sql result set.
     * The statement is not closed since it must remain open
     * while processing the result set.
     */
    @SuppressWarnings("resource")
    public KmSqlResultSet executeQuery(String sql)
    {
        try
        {
            long nanos = System.nanoTime();
            ResultSet inner = _statement.executeQuery(sql);

            KmSqlResultSet rs;
            rs = new KmSqlResultSet(getAdaptor(), inner);
            debug(sql, nanos);
            return rs;
        }
        catch ( SQLException ex )
        {
            throw new KmSqlException(ex, getConnectionName(), sql);
        }
    }

    /**
     * Execute an update (insert, update, delete, etc...) and return the
     * number of rows that were modified.  The statement is left open in
     * case additional updates are to be run against the same statement.
     */
    public int executeUpdate(String sql)
    {
        try
        {
            long nanos = System.nanoTime();
            int i = _statement.executeUpdate(sql);
            debug(sql, nanos);
            return i;
        }
        catch ( SQLException ex )
        {
            throw new KmSqlException(ex, getConnectionName(), sql);
        }
    }

    /**
     * Close the underlying statement.  This method is guaranteed
     * to NOT throw any exceptions.  This is done in order to greatly
     * simplify the database clean up routines where multiple statements
     * and connections need to be closed.  In the unlikely event that
     * a statement throws an exception while closing, the exception is
     * sent to KmLog.error().
     */
    public void close()
    {
        try
        {
            if ( _statement != null )
            {
                _statement.close();
                _connection._removeOpenStatement(this);
            }
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "%s: Cannot close statement.", getConnectionName());
        }
        finally
        {
            _statement = null;
        }
    }

    public KmSqlAdaptor getAdaptor()
    {
        return _connection.getAdaptor();
    }

    //##################################################
    //# execute (private)
    //##################################################

    public boolean _execute(String sql)
    {
        try
        {
            return _statement.execute(sql);
        }
        catch ( SQLException ex )
        {
            throw new KmSqlException(ex, getConnectionName(), sql);
        }
    }

    public int _getUpdateCount()
    {
        try
        {
            int i = _statement.getUpdateCount();
            return i;
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    @SuppressWarnings("resource")
    public KmSqlResultSet _getResultSet()
    {
        try
        {
            ResultSet rs = _statement.getResultSet();
            return new KmSqlResultSet(getAdaptor(), rs);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public boolean _getMoreResults()
    {
        try
        {
            return _statement.getMoreResults();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public Statement _getStatement()
    {
        return _statement;
    }

    //##################################################
    //# debug
    //##################################################

    private void debug(String s, long nanoStart)
    {
        long nanoStop = System.nanoTime();
        double totalMs = (nanoStop - nanoStart) / 1000000.0;

        boolean debug = SqlStatementLogger.isDebugEnabled();
        boolean warn = _slowSqlThresholdMs > 0 && totalMs >= _slowSqlThresholdMs;
        if ( !(debug || warn) )
            return;

        String msg = composeDebugMessage(s, totalMs);

        if ( debug )
            SqlStatementLogger.debug(msg);

        if ( warn )
            SqlStatementLogger.warnTrace("slowSql: " + msg);
    }

    private String composeDebugMessage(String s, double totalMs)
    {
        StringBuilder sb;
        sb = new StringBuilder(s.length() + 30);
        sb.append(getConnectionName());
        sb.append(": ");
        sb.append(s);
        sb.append(" (");
        sb.append(Kmu.formatDouble(totalMs, 2));
        sb.append(" ms)");
        return sb.toString();
    }

    private String getConnectionName()
    {
        if ( _connection == null )
            return "No Connection";
        String s = _connection.getName();
        if ( Kmu.isEmpty(s) )
            return "No Name";
        return s;
    }

}
