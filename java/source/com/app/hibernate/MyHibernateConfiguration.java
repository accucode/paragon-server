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
            throw Kmu.newFatal("Already installed.");

        _instance = new MyHibernateConfiguration();
    }

    public static MyHibernateConfiguration getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

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

        if ( useSecondLevelCache() )
            setSecondLevelCacheProperties(c);
    }

    private void setSecondLevelCacheProperties(Configuration c)
    {
        MyPropertyRegistry p = getProperties();
        String cacheProvider = p.getHibernateCacheProvider();
        String servers = p.getHibernateMemcachedServers();
        Integer cacheTime = p.getHibernateCacheTimeSeconds();

        c.setProperty(
            "hibernate.cache.use_second_level_cache",
            formatTrueFalse(useSecondLevelCache()));
        c.setProperty("hibernate.cache.provider_class", cacheProvider);
        c.setProperty("hibernate.memcached.servers", servers);
        c.setProperty("hibernate.memcached.cacheTimeSeconds", cacheTime.toString());

    }

    private boolean useSecondLevelCache()
    {
        return getProperties().getHibernateUseSecondLevelCache();
    }

    private boolean getShowSql()
    {
        return getProperties().getShowHibernateSql();
    }

    private String formatTrueFalse(boolean b)
    {
        return b
            ? "true"
            : "false";
    }

}
