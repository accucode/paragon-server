package com.app.utility;

import com.kodemore.utility.Kmu;

public class MyEnvironment
{
    //##################################################
    //# variables
    //##################################################

    private static String _webRoot;
    private static String _projectPath;

    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        String working = Kmu.getWorkingFolder();
        String web = Kmu.joinFilePath(working, "web");
        install(web);

        _projectPath = working;
    }

    public static void install(String webRoot)
    {
        String path = Kmu.getCanonicalPath(webRoot);
        String webInf = Kmu.joinFilePath(path, "WEB-INF");
        if ( !Kmu.fileExists(webInf) )
            throw Kmu.newFatal(
                "Attempt to install web path failed (%s).  Cannot find (%s).",
                webRoot,
                webInf);

        _webRoot = path;
    }

    //##################################################
    //# accessing
    //##################################################

    public static String getWebRoot()
    {
        return _webRoot;
    }

    public static String getProjectRoot()
    {
        return _projectPath;
    }

    //##################################################
    //# testing
    //##################################################

    public static boolean isInstalled()
    {
        return _webRoot != null;
    }
}
