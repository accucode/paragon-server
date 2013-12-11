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

    public void closeSafely()
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
            Kmu.fatal("Cannot create lock on empty key.");

        String sql = Kmu.format("select get_lock('%s', %s)", key, timeoutSeconds);

        int i = 0;
        while ( true )
        {
            if ( _lock(sql) )
                return true;

            if ( i >= retryCount )
                return false;

            i++;
            Kmu.sleepMs(retryDelayMs);
        }
    }

    private boolean _lock(String sql)
    {
        Integer x = _executeLockCommand(sql);
        if ( x == null )
            Kmu.fatal("Locking error; database error for: %s", sql);

        // success
        if ( x == 1 )
            return true;

        // timeout
        if ( x == 0 )
            return false;

        Kmu.fatal("Locking error; unhandled result(%s) for: %s", x, sql);
        return false;
    }

    private Integer _executeLockCommand(String sql)
    {
        Statement st = null;
        try
        {
            st = getConnection().createStatement();
            boolean isResultSet = st.execute(sql);
            if ( !isResultSet )
                Kmu.fatal("Locking error; no result set for: %s", sql);

            ResultSet rs = st.getResultSet();
            if ( !rs.next() )
                Kmu.fatal("Locking error; empty result set for: %s", sql);

            return rs.getInt(1);
        }
        catch ( Exception ex )
        {
            Kmu.fatal(ex, "Locking error; %s", sql);
            return null;
        }
        finally
        {
            try
            {
                if ( st != null )
                    st.close();
            }
            catch ( Exception ex )
            {
                KmLog.error(ex, "Unable to close connection, continuing...");
            }
        }
    }

    /**
     * Release the database lock.
     */
    public void unlock(String key)
    {
        if ( key == null )
            Kmu.fatal("Cannot unlock; no current lock.");

        String sql = Kmu.format("select release_lock('%s')", key);
        Integer x = _executeLockCommand(sql);

        if ( x == null )
            Kmu.fatal("Cannot release lock(%s); lock does not exist.", key);

        if ( x == 0 )
            Kmu.fatal("Cannot release lock(%s); lock is held by another connection.", key);

        if ( x == 1 )
            return;

        Kmu.fatal("Cannot release lock(%s); unknown response code(%s).", key, x);
    }

    public void unlockSafely(String key)
    {
        try
        {
            unlock(key);
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot unlock database.");
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
