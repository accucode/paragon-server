package com.kodemore.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * Some utility methods for specialized database manipulation.
 * This is only used for things like resetting the database,
 * or creating new schemas on the fly.
 */
public class KmDatabaseTool
{
    //##################################################
    //# variables
    //##################################################

    private Connection _connection;
    private boolean    _openDefaultSchema;

    //##################################################
    //# constructor
    //##################################################

    public KmDatabaseTool()
    {
        _connection = null;
        _openDefaultSchema = true;
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getOpenDefaultSchema()
    {
        return _openDefaultSchema;
    }

    public void setOpenDefaultSchema(boolean e)
    {
        _openDefaultSchema = e;
    }

    //##################################################
    //# open
    //##################################################

    public void open()
    {
        _connection = getConnectionFactory().openRaw();
        if ( _openDefaultSchema )
            useDefaultSchema();
    }

    public boolean isOpen()
    {
        return _connection != null;
    }

    public Connection getConnection()
    {
        return _connection;
    }

    //##################################################
    //# general
    //##################################################

    public void commit()
    {
        try
        {
            _connection.commit();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void rollback()
    {
        try
        {
            _connection.rollback();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void close()
    {
        try
        {
            if ( _connection == null )
                return;

            _connection.close();
            _connection = null;
        }
        catch ( SQLException ex )
        {
            KmLog.error(ex, "Cannot close connection.");
        }
    }

    //##################################################
    //# scripts
    //##################################################

    public void runScriptFile(String path)
    {
        KmFile file = new KmFile(path);
        runScriptFile(file);
    }

    public void runScriptFile(KmFile file)
    {
        KmLog.info("Running script file: %s", file);
        String script = file.readString();
        runScript(script);
    }

    public void runScript(String script)
    {
        String[] v = script.split(";");
        for ( String e : v )
            execute(e);
    }

    public int execute(String s)
    {
        if ( s == null )
            return 0;

        s = s.trim();
        if ( s.length() == 0 )
            return 0;

        Statement st = createStatement();
        try
        {
            return st.executeUpdate(s);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            closeSafely(st);
        }
    }

    //##################################################
    //# schemas
    //##################################################

    public KmList<String> getSchemaNames()
    {
        return getStringResults("show databases");
    }

    public void createSchema(String name)
    {
        KmLog.info("Creating schema: %s", name);
        execute("create database " + name);
    }

    public void useSchema(String name)
    {
        execute("use " + name);
    }

    public void dropSchema(String name)
    {
        KmLog.info("Dropping schema: %s", name);
        execute("drop database " + name);
    }

    public void dropTable(String name)
    {
        KmLog.info("Dropping table: %s", name);
        execute("drop table " + name);
    }

    public boolean hasSchema(String s)
    {
        return getSchemaNames().contains(s);
    }

    public void useDefaultSchema()
    {
        String s = getDefaultSchema();
        if ( Kmu.hasValue(s) )
            useSchema(s);
    }

    public String getDefaultSchema()
    {
        return getConnectionFactory().getDefaultSchema();
    }

    //##################################################
    //# tables
    //##################################################

    public KmList<String> getTableNames()
    {
        return getStringResults("show tables");
    }

    //##################################################
    //# convenience
    //##################################################

    /**
     * Run a simple query.  Assumes the result will have
     * a single row, with a single integer column.
     */
    public Integer getSingleInteger(String sql)
    {
        Statement st = null;
        ResultSet rs = null;
        try
        {
            st = createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            closeSafely(rs);
            closeSafely(st);
        }
    }

    /**
     * Run a query.  Assumes the result may have multiple
     * rows, but each row will contain a single string column.
     */
    public KmList<String> getStringResults(String sql)
    {
        Statement st = null;
        ResultSet rs = null;
        try
        {
            st = createStatement();
            rs = st.executeQuery(sql);

            KmList<String> v = new KmList<String>();
            while ( rs.next() )
                v.add(rs.getString(1));
            return v;
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            closeSafely(rs);
            closeSafely(st);
        }
    }

    //##################################################
    //# statements
    //##################################################

    public Statement createStatement()
    {
        try
        {
            return _connection.createStatement();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void closeSafely(ResultSet rs)
    {
        try
        {
            if ( rs != null )
                rs.close();
        }
        catch ( SQLException ex )
        {
            KmLog.error(ex, "Cannot close result set.");
        }
    }

    public void closeSafely(Statement st)
    {
        try
        {
            st.close();
        }
        catch ( SQLException ex )
        {
            KmLog.error(ex, "Cannot close statement.");
        }
    }

    //##################################################
    //# convenience
    //##################################################

    public KmDatabaseConnectionFactory getConnectionFactory()
    {
        return KmDatabaseConnectionFactory.getInstance();
    }

}
