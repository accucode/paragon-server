package com.app.hibernate;

import org.hibernate.cfg.Configuration;

import com.kodemore.utility.Kmu;

import com.app.hibernate.base.MyHibernateConfigurationBase;
import com.app.property.MyPropertyRegistry;

public class MyHibernateConfiguration
    extends MyHibernateConfigurationBase
{
    //##################################################
    //# instance
    //##################################################

    private static MyHibernateConfiguration _instance;

    public static void install()
    {
        if ( _instance != null )
            Kmu.fatal("Already installed.");

        _instance = new MyHibernateConfiguration();
    }

    public static MyHibernateConfiguration getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not installed.");

        return _instance;
    }

    public static boolean isInstalled()
    {
        return _instance != null;
    }

    //##################################################
    //# private
    //##################################################

    @Override
    protected void addCustomConfigurations(Configuration c)
    {
        MyPropertyRegistry p = getProperties();

        String driver = p.getDatabaseDriver();
        String url = p.getDatabaseUri() + p.getDatabaseSchema();
        String user = p.getDatabaseUser();
        String password = p.getDatabasePassword();

        c.setProperty("hibernate.connection.driver_class", driver);
        c.setProperty("hibernate.connection.url", url);
        c.setProperty("hibernate.connection.username", user);
        c.setProperty("hibernate.connection.password", password);

        c.setProperty("hibernate.connection.release_mode", "on_close");
        c.setProperty("hibernate.show_sql", formatTrueFalse(getShowSql()));
    }

    private String formatTrueFalse(boolean b)
    {
        return b
            ? "true"
            : "false";
    }

    private boolean getShowSql()
    {
        return getProperties().getShowHibernateSql();
    }
}
