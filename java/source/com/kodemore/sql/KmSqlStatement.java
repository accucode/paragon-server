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

package com.kodemore.sql;

import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.utility.Kmu;

/**
 * I wrap the java.sql.Statement and provide convenience methods
 * for executing queries and updates.
 */
public abstract class KmSqlStatement
    implements KmSqlConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The wrapped sql statement.
     */
    private KmSqlStatementWrapper _statement;

    /**
     * The database adaptor used to translate values.
     */
    private KmSqlAdaptor _adaptor;

    /**
     * The expected update count.  By default the expected count is
     * ignored but it can be set to a value that is compared against
     * the actual update count.  This is ignored for select statements.
    //     */
    private KmSqlExpectedCount _expectedCount;

    /**
     * Any statements with a time >= this threshold will be printed
     * as a warning.  A threshold of 0 disables the warnings.  If
     * not set (null), then the default threshold will be used.
     */
    private Integer _slowSqlThresholdMs;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Create a statement.
     */
    public KmSqlStatement(KmSqlAdaptor a)
    {
        _adaptor = a;
        _expectedCount = new KmSqlExpectedCount();
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Get the sql string to execute as either a query or update.
     */
    public abstract String getSqlString();

    //##################################################
    //# statement
    //##################################################

    protected KmSqlStatementWrapper getStatement()
    {
        return _statement;
    }

    protected void setStatement(KmSqlStatementWrapper e)
    {
        _statement = e;
    }

    //##################################################
    //# slow sql threshold
    //##################################################

    public Integer getSlowSqlThresholdMs()
    {
        return _slowSqlThresholdMs;
    }

    public void setSlowSqlThresholdMs(Integer e)
    {
        _slowSqlThresholdMs = e;
    }

    public void disableSlowSqlThreshold()
    {
        setSlowSqlThresholdMs(0);
    }

    public void setDefaultSlowSqlThreshold()
    {
        setSlowSqlThresholdMs(null);
    }

    //##################################################
    //# actions
    //##################################################

    /**
     * Execute a query and return the wrapped results.
     */
    public KmSqlResultSet _executeQuery(KmSqlConnection con)
    {
        createStatement(con);

        String sql = getSqlString();
        return _statement.executeQuery(sql);
    }

    /**
     * Execute an update and return the update count.  The statement
     * could probably be closed but is left open for consistency.
     */
    public int _executeUpdate(KmSqlConnection con)
    {
        createStatement(con);

        String sql = getSqlString();
        int i = _statement.executeUpdate(sql);
        _expectedCount.check(i);
        return i;
    }

    private void createStatement(KmSqlConnection con)
    {
        _statement = con.createSqlStatement();
        if ( _slowSqlThresholdMs != null )
            _statement.setSlowSqlThresholdMs(_slowSqlThresholdMs);
    }

    /**
     * This method is guaranteed to execute without throwing an
     * exception.  This allows other code to be greatly simplified
     * and avoids the need to wrap and double wrap try-finally blocks
     * around all of the database clean up code.  In the unlikely event
     * that an exception is thrown while being closed, the error is
     * caught and reported to KmLog.error.
     */
    public void close()
    {
        if ( _statement != null )
        {
            _statement.close();
            _statement = null;
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public KmSqlAdaptor getAdaptor()
    {
        return _adaptor;
    }

    /**
     * Get a new sql formatter.
     */
    public KmSqlBuffer newBuffer()
    {
        return _adaptor.newBuffer();
    }

    //##################################################
    //# expected count
    //##################################################

    /**
     * Get the expected count.
     */
    public KmSqlExpectedCount getExpectedCount()
    {
        return _expectedCount;
    }

    /**
     * Set the expected count to a specific value.
     */
    public void setExpectedCount(int i)
    {
        _expectedCount.setCount(i);
    }

    /**
     * Set the expected count to a maximum value.
     */
    public void setMaximumCount(int i)
    {
        _expectedCount.setMaximum(i);
    }

    /**
     * Set the expected count to a minimum value.
     */
    public void setMinimumCount(int i)
    {
        _expectedCount.setMinimum(i);
    }

    /**
     * Set the expected count such that it is ignored.
     */
    public void ignoreExpectedCount()
    {
        _expectedCount.ignore();
    }

    //##################################################
    //# error
    //##################################################

    public RuntimeException newFatal(String s)
    {
        return Kmu.newFatal(s + "::" + toString());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return getSqlString();
    }

}
