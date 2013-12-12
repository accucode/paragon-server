package com.app.bridge;

import java.sql.Connection;

import com.kodemore.database.KmDatabaseConnectionFactory;
import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.sql.adaptor.mySql.KmSqlMySqlAdaptor;

import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

/**
 * I implement the override hooks that the kodemore tools
 * use to open and close database connection.  I need
 * to be explicitly installed before any of the dependent
 * tools attempt to open a connection.
 */
public class MyDatabaseConnectionFactory
    extends KmDatabaseConnectionFactory
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        KmDatabaseConnectionFactory.install(new MyDatabaseConnectionFactory());
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public String getDefaultSchema()
    {
        MyPropertyRegistry p = getProperties();

        return p.getDatabaseSchema();
    }

    @Override
    public KmSqlAdaptor getAdaptor()
    {
        return new KmSqlMySqlAdaptor();
    }

    @Override
    public Connection openRaw()
    {
        MyPropertyRegistry p = getProperties();

        String driver = p.getDatabaseDriver();
        String uri = p.getDatabaseUri();
        String user = p.getDatabaseUser();
        String password = p.getDatabasePassword();

        return openDriver(driver, uri, user, password);
    }

    //##################################################
    //# support
    //##################################################

    private MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }
}
