package com.app.utility;

import java.io.PrintWriter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.xml.DOMConfigurator;

import com.kodemore.file.KmFile;
import com.kodemore.log.KmLog;
import com.kodemore.log.KmLogger;

import com.app.file.MyResourceFiles;

public class MyLog4jManager
{
    //##################################################
    //# variables
    //##################################################

    private static long   _lastModified;
    private static KmFile _file;

    //##################################################
    //# public
    //##################################################

    public static void install()
    {
        _file = MyResourceFiles.getInstance().getLog4jConfig();
        _lastModified = 0;

        load();
    }

    public static void installConsole()
    {
        resetToConsole();
    }

    public static boolean reload()
    {
        if ( !hasChanged() )
            return false;

        load();
        return true;
    }

    //##################################################
    //# private
    //##################################################

    private static void load()
    {
        if ( exists() )
        {
            _lastModified = getLastModified();
            DOMConfigurator.configure(_file.getRealPath());
        }
        else
        {
            _lastModified = 0;
            resetToConsole();
        }
        KmLog.info("Log4j configuration loaded.");
    }

    private static void resetToConsole()
    {
        PrintWriter writer;
        writer = new PrintWriter(System.out);

        Layout layout;
        layout = new PatternLayout("%d %-5p %c - %m %n");

        ConsoleAppender e;
        e = new ConsoleAppender();
        e.setName("Console");
        e.setThreshold(Level.INFO);
        e.setWriter(writer);
        e.setLayout(layout);

        LogManager.shutdown();
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure(e);
        KmLogger.resetAll();
    }

    private static boolean hasChanged()
    {
        if ( exists() )
            return getLastModified() != _lastModified;

        return _lastModified != 0;
    }

    private static boolean exists()
    {
        return _file.exists();
    }

    private static long getLastModified()
    {
        return _file.getLastModifiedOrdinal();
    }

}
