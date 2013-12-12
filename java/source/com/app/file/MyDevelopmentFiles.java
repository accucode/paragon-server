package com.app.file;

import com.kodemore.utility.Kmu;

import com.app.utility.MyEnvironment;

/**
 * These files are ONLY available in Development.
 * These files are specifically NOT available in a production environment.
 *
 * These paths are typically used for things like code generation
 * and other tools that can only be run in a development environment.
 * 
 * It is important that there are no dependencies on any auto-generated code.
 * In particular, be sure to avoid any dependencies on MyPropertyRegistry.
 * 
 * To use, you must first call MyEnvironment.install().
 */
public class MyDevelopmentFiles
{
    //##################################################
    //# public
    //##################################################

    public static String getProjectRoot()
    {
        return MyEnvironment.getProjectRoot();
    }

    public static String getJavaSourcePath()
    {
        return join(getProjectRoot(), "java", "source");
    }

    public static String getJavaSourcePath(String... path)
    {
        return join(getJavaSourcePath(), join(path));
    }

    //##################################################
    //# private
    //##################################################

    private static String join(String... arr)
    {
        return Kmu.joinFilePath(arr);
    }
}
