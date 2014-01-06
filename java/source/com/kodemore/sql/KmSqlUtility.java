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
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.utility.Kmu;

/**
 * I contains the common methods to creating a new connection.
 */
public abstract class KmSqlUtility
    implements KmSqlConstantsIF
{
    //##################################################
    //# utility
    //##################################################

    /**
     * Examples:
     * driver: "COM.ibm.db2.jdbc.app.DB2Driver"
     * url:    "jdbc:db2:d_hs"
     */
    public static KmSqlConnection openDriverConnection(
        String driver,
        String url,
        String login,
        String password,
        KmSqlAdaptor adaptor)
    {
        Connection c = openDriver(driver, url, login, password);

        KmSqlConnection con;
        con = new KmSqlConnection(c);
        con.setAdaptor(adaptor);
        return con;
    }

    /**
     * Examples:
     * driver: "COM.ibm.db2.jdbc.app.DB2Driver"
     * url:    "jdbc:db2:d_hs"
     */
    public static Connection openDriver(String driver, String url, String username, String password)
    {
        try
        {
            log("Open Url Connection");
            log("   driver:     " + driver);
            log("   url:        " + url);
            log("   username:   " + username);
            log("   password:   " + password);
            loadDriver(driver);

            Connection c;
            c = DriverManager.getConnection(url, username, password);
            c.setAutoCommit(false);
            return c;
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public static KmSqlConnection openDataSourceConnection(
        String path,
        String factory,
        String url,
        String username,
        String password,
        KmSqlAdaptor adaptor)
    {
        Connection c = openDataSource(path, factory, url, username, password);

        KmSqlConnection con;
        con = new KmSqlConnection(c);
        con.setAdaptor(adaptor);
        return con;
    }

    public static Connection openDataSource(
        String path,
        String factory,
        String url,
        String username,
        String password)
    {
        try
        {
            log("Open DataSource Connection");
            log("   path:     " + path);
            log("   factory:  " + factory);
            log("   url:      " + url);
            log("   username: " + username);
            log("   password: " + password);
            DataSource ds = (DataSource)KmSqlJndiContext.lookup(path, factory, url);

            Connection c;
            c = ds.getConnection(username, password);
            c.setAutoCommit(false);
            return c;
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# private
    //##################################################

    public static void loadDriver(String driver)
    {
        try
        {
            // must create an instance to ensure the class loader can find the driver
            Class.forName(driver).newInstance();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public static void log(String s)
    {
        SqlConnectionLogger.debug(s);
    }
}
