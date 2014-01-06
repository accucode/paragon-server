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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.utility.Kmu;

/**
 * I wrap the standard java.sql.Connection class.  I provide hooks for
 * connection pooling, and formatting.
 */
public class KmSqlConnection
    implements KmSqlConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private Connection                    _connection;
    private KmSqlPooledConnectionFactory  _pool;
    private String                        _name;
    private KmSqlAdaptor                  _adaptor;
    private KmList<KmSqlStatementWrapper> _openStatements;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlConnection(Connection c)
    {
        _connection = c;
        _pool = null;
        _name = null;
        _adaptor = null;
        _openStatements = new KmList<KmSqlStatementWrapper>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmSqlPooledConnectionFactory getPool()
    {
        return _pool;
    }

    public void setPool(KmSqlPooledConnectionFactory p)
    {
        _pool = p;
    }

    public boolean hasPool()
    {
        return getPool() != null;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String s)
    {
        _name = s;
    }

    public KmSqlBuffer newBuffer()
    {
        return _adaptor.newBuffer();
    }

    public KmSqlAdaptor getAdaptor()
    {
        return _adaptor;
    }

    public void setAdaptor(KmSqlAdaptor adaptor)
    {
        _adaptor = adaptor;
    }

    public KmSqlConnectionWrapper getWrapper()
    {
        return new KmSqlConnectionWrapper(this);
    }

    //##################################################
    //# statements (convenience)
    //##################################################

    public KmSqlSelect createSelect()
    {
        return new KmSqlSelect(_adaptor);
    }

    public KmSqlInsert createInsert()
    {
        return new KmSqlInsert(_adaptor);
    }

    public KmSqlUpdate createUpdate()
    {
        return new KmSqlUpdate(_adaptor);
    }

    public KmSqlDelete createDelete()
    {
        return new KmSqlDelete(_adaptor);
    }

    //##################################################
    //# actions
    //##################################################

    public void useSchema(String s)
    {
        if ( s == null )
            return;

        KmSqlStatementWrapper st = createSqlStatement();
        try
        {
            st.executeUpdate("use " + s);
        }
        finally
        {
            st.close();
        }
    }

    public void commit()
    {
        try
        {
            _logTransaction("commit");
            _connection.commit();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Close the wrapped connection.  This method is guaranteed to
     * NOT throw an exception.  In the unlikely event that an exception
     * occurs while attempting to close the connection, the error is
     * sent to KmLog.error().
     */
    public void close()
    {
        _autoCloseStatements();
        if ( hasPool() )
            getPool().close(this);
        else
            closeInnerConnection();
    }

    /**
     * Close any open statements.  Statement should be explicitly closed
     * as soon as they are no longer needed; however, the connection
     * double checks for statements that were left open by accident and
     * closes them.  A warning is issued for any statement that requires
     * automatic closing.
     */
    public void _autoCloseStatements()
    {
        for ( KmSqlStatementWrapper e : _openStatements.getShallowCopy() )
        {
            KmLog.warnTrace("Open statement; automatic close on connection.close.");
            e.close();
        }
    }

    /**
     * Close the wrapped connection.  This method is guaranteed to
     * NOT throw an exception.  In the unlikely event that an exception
     * occurs while attempting to close the connection, the error is
     * sent to KmLog.error().
     */
    public void closeInnerConnection()
    {
        try
        {
            quietRollback();
            _connection.close();
        }
        catch ( SQLException ex )
        {
            KmLog.error(ex, "Cannot close connection.");
        }
        finally
        {
            _connection = null;
        }
    }

    /**
     * Attempt to rollback the connection; any exception will be
     * wrapped in a bagged exception and thrown.  This is the
     * rollback that should be used by most clients, compare to
     * quietRollback and silentRollback.
     */
    public void rollback()
    {
        try
        {
            _logTransaction("rollback");
            _connection.rollback();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Attempt to rollback the connection; write any exception
     * to the log but do not throw it.
     */
    public void quietRollback()
    {
        try
        {
            _logTransaction("rollback");
            _connection.rollback();
        }
        catch ( Exception ex )
        {
            // this is Exception rather than SQLException in case some
            // other non-SQLException is thrown.
            KmLog.error(ex, "Cannot rollback connection.");
        }
    }

    public void setAutoCommit(boolean b)
    {
        try
        {
            _getConnection().setAutoCommit(b);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public boolean isOpen()
    {
        return !isClosed();
    }

    public boolean isClosed()
    {
        try
        {
            // WARNING

            // The implementation of this method is based on
            // impirical testing with stale connections on 6/29/06,
            // MySql 5.0 and JDK 1.5.0_06.  Please do NOT modify without
            // discussion and careful testing.

            // In an ideal world this would determine if the connection is
            // open or closed, but it is not reliable...
            if ( _connection.isClosed() )
                return true;

            // The rollback does generate an internal exception, but for
            // some reason, that exception is not thrown until some subsequent
            // request is made; such as a select, or update...
            _connection.rollback();

            // The exception that was generated (but not thrown) during the
            // rollback does mark the connection as closed so that this test
            // now correctly reports whether the connection is still open or not...
            return _connection.isClosed();
        }
        catch ( Exception ex )
        {
            return true;
        }
    }

    //##################################################
    //# statements
    //##################################################

    public KmSqlStatementWrapper createSqlStatement()
    {
        try
        {
            Statement st;
            st = _connection.createStatement();
            st.setEscapeProcessing(false);

            KmSqlStatementWrapper kmSt = new KmSqlStatementWrapper(this, st);
            _openStatements.add(kmSt);
            return kmSt;
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public KmSqlPreparedStatement prepareStatement(String sql)
    {
        try
        {
            PreparedStatement ps = _connection.prepareStatement(sql);
            return new KmSqlPreparedStatement(this, ps, sql);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# execute (double dispatch)
    //##################################################

    public KmSqlResultSet execute(KmSqlSelect st)
    {
        return st.execute(this);
    }

    public int execute(KmSqlUpdateIF st)
    {
        return st.execute(this);
    }

    //##################################################
    //# unsupported
    //##################################################

    public int getLastId()
    {
        KmSqlStatementWrapper st = null;
        try
        {
            String sql = _adaptor.getLastIdSqlString();
            st = createSqlStatement();
            KmSqlResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.get_int();
        }
        finally
        {
            if ( st != null )
                st.close();
        }
    }

    public long getLastLongId()
    {
        KmSqlStatementWrapper st = null;
        try
        {
            String sql = _adaptor.getLastIdSqlString();
            st = createSqlStatement();
            KmSqlResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.get_long();
        }
        finally
        {
            if ( st != null )
                st.close();
        }
    }

    //##################################################
    //# accessing (private)
    //##################################################

    public Connection _getConnection()
    {
        return _connection;
    }

    public void _setConnection(Connection c)
    {
        _connection = c;
    }

    public void _removeOpenStatement(KmSqlStatementWrapper st)
    {
        _openStatements.remove(st);
    }

    //##################################################
    //# logging (private)
    //##################################################

    public void _logTransaction(String s)
    {
        SqlTransactionLogger.debug(getName() + " :: " + s);
    }

}
