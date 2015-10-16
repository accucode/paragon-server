package com.app.hibernate;

import java.io.File;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.kodemore.file.KmFile;
import com.kodemore.utility.Kmu;

import com.app.file.MyResourceFiles;
import com.app.hibernate.base.MyHibernateConfigurationBase;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

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
    //# variables
    //##################################################

    private Configuration  _configuration;
    private SessionFactory _sessionFactory;

    //##################################################
    //# constructor
    //##################################################

    protected MyHibernateConfiguration()
    {
        _configuration = new Configuration();

        installMappings();
        installConfigFile();
        installInterceptor();
        installConnection();
        installSecondLevelCache();
        installMisc();
        installSessionFactory();
    }

    //##################################################
    //# public
    //##################################################

    public Session newSession()
    {
        return _sessionFactory.openSession();
    }

    public void shutDown()
    {
        if ( !_sessionFactory.isClosed() )
            _sessionFactory.close();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installMapping(String clazz)
    {
        String fileName = Kmu.format("%s.hbm.xml", clazz);
        KmFile mappingFolder = getHibernateFolder().getChild("mapping");
        KmFile mappingFile = mappingFolder.getChild(fileName);
        File file = mappingFile.getRealFile();

        _configuration.addFile(file);
    }

    private void installConfigFile()
    {
        KmFile folder = getHibernateFolder();
        KmFile file = folder.getChild("hibernate.cfg.xml");

        _configuration.configure(file.getRealFile());
    }

    private void installConnection()
    {
        MyPropertyRegistry p = getProperties();

        String driver = p.getDatabaseDriver();
        String url = p.getDatabaseUri() + p.getDatabaseSchema();
        String user = p.getDatabaseUser();
        String password = p.getDatabasePassword();

        _configuration.setProperty("hibernate.connection.driver_class", driver);
        _configuration.setProperty("hibernate.connection.url", url);
        _configuration.setProperty("hibernate.connection.username", user);
        _configuration.setProperty("hibernate.connection.password", password);
    }

    private void installSecondLevelCache()
    {
        MyPropertyRegistry p = getProperties();

        boolean usesCache = p.getHibernateUseSecondLevelCache();
        if ( !usesCache )
            return;

        String useSecondLevelCache = formatTrueFalse(true);
        String cacheProvider = p.getHibernateCacheProvider();
        String servers = p.getHibernateMemcachedServers();
        String cacheTime = p.getHibernateCacheTimeSeconds().toString();

        _configuration.setProperty("hibernate.cache.use_second_level_cache", useSecondLevelCache);
        _configuration.setProperty("hibernate.cache.provider_class", cacheProvider);
        _configuration.setProperty("hibernate.memcached.servers", servers);
        _configuration.setProperty("hibernate.memcached.cacheTimeSeconds", cacheTime);
    }

    private void installMisc()
    {
        MyPropertyRegistry p = getProperties();

        String showSql = formatTrueFalse(p.getShowHibernateSql());
        String releaseMode = "on_close";

        _configuration.setProperty("hibernate.show_sql", showSql);
        _configuration.setProperty("hibernate.connection.release_mode", releaseMode);
    }

    private void installInterceptor()
    {
        _configuration.setInterceptor(new MyHibernateInterceptor());
    }

    private void installSessionFactory()
    {
        Properties p = _configuration.getProperties();
        StandardServiceRegistryBuilder b = new StandardServiceRegistryBuilder();
        ServiceRegistry r = b.applySettings(p).build();

        _sessionFactory = _configuration.buildSessionFactory(r);
    }

    //##################################################
    //# support
    //##################################################

    private MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    private KmFile getHibernateFolder()
    {
        return MyResourceFiles.getInstance().getHibernateFolder();
    }

    private String formatTrueFalse(boolean b)
    {
        return b
            ? "true"
            : "false";
    }

}
