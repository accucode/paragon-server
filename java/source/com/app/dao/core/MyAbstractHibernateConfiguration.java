package com.app.dao.core;

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
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

public abstract class MyAbstractHibernateConfiguration
{
    //##################################################
    //# variables
    //##################################################

    private Configuration   _configuration;
    private SessionFactory  _sessionFactory;
    private ServiceRegistry _serviceRegistry;

    //##################################################
    //# constructor
    //##################################################

    protected MyAbstractHibernateConfiguration()
    {
        _configuration = new Configuration();
        addCustomMappings();
        _configuration.configure(getConfigFile());

        addCustomConfigurations(_configuration);

        Properties props;
        props = _configuration.getProperties();

        StandardServiceRegistryBuilder builder;
        builder = new StandardServiceRegistryBuilder();

        _serviceRegistry = builder.applySettings(props).build();
        _sessionFactory = _configuration.buildSessionFactory(_serviceRegistry);
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
    //# support
    //##################################################

    protected abstract void addCustomMappings();

    protected abstract void addCustomConfigurations(Configuration config);

    protected void addMapping(String clazz)
    {
        File file = getMappingFile(clazz);

        _configuration.addFile(file);
    }

    private File getConfigFile()
    {
        KmFile folder = getHibernateFolder();
        KmFile file = folder.getChild("hibernate.cfg.xml");

        return file.getRealFile();
    }

    private File getMappingFile(String clazz)
    {
        String name = Kmu.format("%s.hbm.xml", clazz);
        KmFile mapping = getHibernateFolder().getChild("mapping");

        return mapping.getChild(name).getRealFile();
    }

    private KmFile getHibernateFolder()
    {
        return MyResourceFiles.getInstance().getHibernateFolder();
    }

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

}
