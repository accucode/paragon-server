package com.app.file;

import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileRoot;
import com.kodemore.utility.Kmu;

import com.app.utility.MyEnvironment;

public class MyResourceFiles
{
    //##################################################
    //# instance
    //##################################################

    private static MyResourceFiles _instance;

    public static void install()
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already Installed.");

        _instance = new MyResourceFiles();
    }

    public static MyResourceFiles getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not Installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private KmFileRoot _root;

    //##################################################
    //# constructor
    //##################################################

    private MyResourceFiles()
    {
        String webRoot = MyEnvironment.getWebRoot();
        String rootPath = Kmu.joinFilePath(webRoot, "WEB-INF", "resource");

        _root = new KmFileRoot(rootPath);

        KmFile root = getRoot();
        if ( !root.exists() )
            throw Kmu.newFatal("Resources not found at: %s.", root.getRealPath());
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFile getOverridesFile()
    {
        return getChild("property/overrides.txt");
    }

    public KmFile getPatchDirectory()
    {
        return getChild("db/patch");
    }

    public KmFile getPageLayout()
    {
        return getChild("html/pageLayout.html");
    }

    public KmFile getOneAllHead()
    {
        return getChild("html/oneAllHead.html");
    }

    public KmFile getOneAllBody()
    {
        return getChild("html/oneAllBody.html");
    }

    public KmFile getEmailStyle()
    {
        return getChild("html/emailStyle.html");
    }

    public KmFile getHibernateFolder()
    {
        return getChild("hibernate");
    }

    public KmFile getDatabaseBaseFolder()
    {
        return getChild("db/base");
    }

    public KmFile getDatabaseInstallFolder()
    {
        return getChild("db/install");
    }

    public KmFile getLog4jConfig()
    {
        return getChild("log4j/log4j.xml");
    }

    public KmFile getBeanShellScriptFolder()
    {
        return getChild("beanshell");
    }

    public KmFile getDataExportStyle()
    {
        return getChild("html/dataExportStyle.html");
    }

    //##################################################
    //# support
    //##################################################

    private KmFile getRoot()
    {
        return _root.getFolder();
    }

    private KmFile getChild(String path)
    {
        return getRoot().getChild(path);
    }

}
