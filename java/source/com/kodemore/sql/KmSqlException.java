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

import java.sql.SQLException;

import com.kodemore.utility.Kmu;

/**
 * I am used to specialize sql exceptions so that they may be more easily
 * caught and handled.
 */
public class KmSqlException
    extends RuntimeException
{
    //##################################################
    //# variables
    //##################################################

    private String       _connectionName;
    private String       _sql;
    private SQLException _sqlException;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlException(SQLException ex, String connectionName, String sql)
    {
        super(ex.getMessage());
        _sqlException = ex;
        _connectionName = connectionName;
        _sql = sql;
        setSql(sql);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getConnectionName()
    {
        return _connectionName;
    }

    public void setConnectionName(String s)
    {
        _connectionName = s;
    }

    public String getSql()
    {
        return _sql;
    }

    public String getAbbreviatedSql()
    {
        return Kmu.truncate(_sql, 1000, true);
    }

    public void setSql(String e)
    {
        _sql = e;
    }

    public SQLException getSqlException()
    {
        return _sqlException;
    }

    public void setSqlException(SQLException e)
    {
        _sqlException = e;
    }

    @Override
    public String getMessage()
    {
        return Kmu.format(
            "Message: %s. Connection: %s. Sql (length=%s): %s.",
            super.getMessage(),
            _connectionName,
            _sql.length(),
            getAbbreviatedSql());
    }
}
