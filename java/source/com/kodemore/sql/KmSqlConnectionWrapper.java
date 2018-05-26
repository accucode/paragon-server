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

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * I provide a simply wrapper that makes a KmSqlConnection look like
 * a java.sql.Connection.  This allows KmSqlConnection to remain simple
 * while also allowing for those external interfaces that need to adhere
 * to the full java.sql.Connection interface.
 */
public class KmSqlConnectionWrapper
    implements Connection
{
    //##################################################
    //# variables
    //##################################################

    private KmSqlConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlConnectionWrapper(KmSqlConnection c)
    {
        _connection = c;
    }

    public Connection getJavaConnection()
    {
        return _connection._getConnection();
    }

    //##################################################
    //# kodemore connection
    //##################################################

    @Override
    public void close()
    {
        _connection.close();
    }

    @Override
    public void commit()
    {
        _connection.commit();
    }

    @Override
    public boolean isClosed()
    {
        return _connection.isClosed();
    }

    @Override
    public void rollback()
    {
        _connection.rollback();
    }

    @Override
    public void setAutoCommit(boolean autoCommit)
    {
        _connection.setAutoCommit(autoCommit);
    }

    //##################################################
    //# java connection
    //##################################################

    @Override
    public void clearWarnings() throws SQLException
    {
        getJavaConnection().clearWarnings();
    }

    @Override
    public Statement createStatement() throws SQLException
    {
        return getJavaConnection().createStatement();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency)
        throws SQLException
    {
        return getJavaConnection().createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public Statement createStatement(
        int resultSetType,
        int resultSetConcurrency,
        int resultSetHoldability)
        throws SQLException
    {
        return getJavaConnection().createStatement(
            resultSetType,
            resultSetConcurrency,
            resultSetHoldability);
    }

    @Override
    public boolean getAutoCommit() throws SQLException
    {
        return getJavaConnection().getAutoCommit();
    }

    @Override
    public String getCatalog() throws SQLException
    {
        return getJavaConnection().getCatalog();
    }

    @Override
    public int getHoldability() throws SQLException
    {
        return getJavaConnection().getHoldability();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException
    {
        return getJavaConnection().getMetaData();
    }

    @Override
    public int getTransactionIsolation() throws SQLException
    {
        return getJavaConnection().getTransactionIsolation();
    }

    @Override
    public Map<String,Class<?>> getTypeMap() throws SQLException
    {
        return getJavaConnection().getTypeMap();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException
    {
        return getJavaConnection().getWarnings();
    }

    @Override
    public boolean isReadOnly() throws SQLException
    {
        return getJavaConnection().isReadOnly();
    }

    @Override
    public String nativeSQL(String sql) throws SQLException
    {
        return getJavaConnection().nativeSQL(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException
    {
        return getJavaConnection().prepareCall(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
        throws SQLException
    {
        return getJavaConnection().prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(
        String sql,
        int resultSetType,
        int resultSetConcurrency,
        int resultSetHoldability)
        throws SQLException
    {
        return getJavaConnection().prepareCall(
            sql,
            resultSetType,
            resultSetConcurrency,
            resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException
    {
        return getJavaConnection().prepareStatement(sql);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException
    {
        return getJavaConnection().prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException
    {
        return getJavaConnection().prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException
    {
        return getJavaConnection().prepareStatement(sql, columnNames);
    }

    @Override
    public PreparedStatement prepareStatement(
        String sql,
        int resultSetType,
        int resultSetConcurrency)
        throws SQLException
    {
        return getJavaConnection().prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(
        String sql,
        int resultSetType,
        int resultSetConcurrency,
        int resultSetHoldability)
        throws SQLException
    {
        return getJavaConnection().prepareStatement(
            sql,
            resultSetType,
            resultSetConcurrency,
            resultSetHoldability);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException
    {
        getJavaConnection().releaseSavepoint(savepoint);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException
    {
        getJavaConnection().rollback(savepoint);
    }

    @Override
    public void setCatalog(String catalog) throws SQLException
    {
        getJavaConnection().setCatalog(catalog);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException
    {
        getJavaConnection().setHoldability(holdability);
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException
    {
        getJavaConnection().setReadOnly(readOnly);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException
    {
        return getJavaConnection().setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException
    {
        return getJavaConnection().setSavepoint(name);
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException
    {
        getJavaConnection().setTransactionIsolation(level);
    }

    @Override
    public void setTypeMap(Map<String,Class<?>> map) throws SQLException
    {
        getJavaConnection().setTypeMap(map);
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException
    {
        return getJavaConnection().createArrayOf(typeName, elements);
    }

    @Override
    public Blob createBlob() throws SQLException
    {
        return getJavaConnection().createBlob();
    }

    @Override
    public Clob createClob() throws SQLException
    {
        return getJavaConnection().createClob();
    }

    @Override
    public NClob createNClob() throws SQLException
    {
        return getJavaConnection().createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException
    {
        return getJavaConnection().createSQLXML();
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException
    {
        return getJavaConnection().createStruct(typeName, attributes);
    }

    @Override
    public Properties getClientInfo() throws SQLException
    {
        return getJavaConnection().getClientInfo();
    }

    @Override
    public String getClientInfo(String name) throws SQLException
    {
        return getJavaConnection().getClientInfo(name);
    }

    @Override
    public boolean isValid(int timeout) throws SQLException
    {
        return getJavaConnection().isValid(timeout);
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException
    {
        getJavaConnection().setClientInfo(properties);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException
    {
        getJavaConnection().setClientInfo(name, value);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        return getJavaConnection().isWrapperFor(iface);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        return getJavaConnection().unwrap(iface);
    }

    //##################################################
    //# jdk 1.7
    //##################################################

    @Override
    public void setSchema(String schema) throws SQLException
    {
        getJavaConnection().setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException
    {
        return getJavaConnection().getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException
    {
        getJavaConnection().abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException
    {
        getJavaConnection().setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException
    {
        return getJavaConnection().getNetworkTimeout();
    }

}
