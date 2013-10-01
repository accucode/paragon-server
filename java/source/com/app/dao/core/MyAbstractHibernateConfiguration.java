package com.app.dao.core;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.app.file.MyResourceFiles;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

import com.kodemore.file.KmFile;
import com.kodemore.utility.Kmu;

public abstract class MyAbstractHibernateConfiguration
{
    //##################################################
    //# variables
    //##################################################

    private Configuration  _configuration;
    private SessionFactory _sessionFactory;

    //##################################################
    //# constructor
    //##################################################

    protected MyAbstractHibernateConfiguration()
    {
        _configuration = new Configuration();
        addMappings();
        _configuration.configure(getConfigFile());
        addCustomConfigurations(_configuration);
        _sessionFactory = _configuration.buildSessionFactory();
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

    protected abstract void addMappings();

    protected abstract void addCustomConfigurations(Configuration configuration);

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
