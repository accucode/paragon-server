package com.app.file;

import com.app.utility.MyEnvironment;
import com.app.utility.MyGlobals;

import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * These files are ALL available in BOTH Production and Development.
 * 
 * Nearly all of these files are located under web, many are
 * more specifically under web/WEB-INF to ensure they are NOT
 * directly visible to the customer.  
 * 
 * A few paths, like getSharedPath(), are specifically NOT under
 * the production web directory, but should still be valid in
 * production.
 * 
 * To use, first call MyInstaller.install() (or installCore)
 */
public class MyFilePaths
{
    //##################################################
    //# web files (runtime)
    //##################################################

    public static String getWebRoot()
    {
        return MyEnvironment.getWebRoot();
    }

    public static String getWebPath(String... path)
    {
        return join(getWebRoot(), join(path));
    }

    public static String getWebStaticPath()
    {
        return join(getWebRoot(), ScConstantsIF.WEB_STATIC_PATH);
    }

    public static String getWebCommonPath()
    {
        return join(getWebStaticPath(), "common");
    }

    //##################################################
    //# other
    //##################################################

    public static String getAjaxLogFile()
    {
        return join(getWebRoot(), "ajaxLog.txt");
    }

    //##################################################
    //# external paths
    //##################################################

    public static String getSharedPersistentPath()
    {
        return MyGlobals.getProperties().getSharedPersistentPath();
    }

    public static String getSharedTransientPath()
    {
        return MyGlobals.getProperties().getSharedTransientPath();
    }

    //##################################################
    //# private
    //##################################################

    private static String join(String... arr)
    {
        return Kmu.joinFilePath(arr);
    }

}
