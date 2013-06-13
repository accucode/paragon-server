package com.kodemore.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.kodemore.sql.KmSqlConnection;
import com.kodemore.sql.KmSqlUtility;
import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.utility.Kmu;

/**
 * Some utility methods for specialized database manipulation.
 * This is only used for things like resetting the database,
 * or creating new schemas on the fly.
 */
public abstract class KmDatabaseConnectionFactory
{
    //##################################################
    //# instance
    //##################################################

    private static KmDatabaseConnectionFactory _instance;

    public static void install(KmDatabaseConnectionFactory e)
    {
        if ( _instance != null )
            throw new RuntimeException("Already installed.");

        _instance = e;
    }

    public static KmDatabaseConnectionFactory getInstance()
    {
        return _instance;
    }

    //##################################################
    //# connections
    //##################################################

    public abstract String getDefaultSchema();

    public abstract KmSqlAdaptor getAdaptor();

    public abstract Connection openRaw();

    public void closeRaw(Connection e)
    {
        try
        {
            e.close();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public KmSqlConnection open()
    {
        KmSqlConnection c;
        c = new KmSqlConnection(openRaw());
        c.setAdaptor(getAdaptor());
        return c;
    }

    public void close(KmSqlConnection e)
    {
        e.close();
    }

    //##################################################
    //# convenience
    //##################################################

    protected Connection openDriver(String driver, String url, String username, String password)
    {
        return KmSqlUtility.openDriver(driver, url, username, password);
    }

    protected Connection openDataSource(
        String path,
        String factory,
        String url,
        String username,
        String password)
    {
        return KmSqlUtility.openDataSource(path, factory, url, username, password);
    }

}
