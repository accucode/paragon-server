package com.app.property;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.log.KmLogger;
import com.kodemore.servlet.control.ScGoogleChart;
import com.kodemore.sql.KmSqlStatementWrapper;
import com.kodemore.utility.KmContextFormatter;
import com.kodemore.utility.Kmu;

import com.app.file.MyResourceFiles;
import com.app.property.base.MyPropertyDefinitions;
import com.app.utility.MyInstaller;

public class MyPropertyManager
{
    //##################################################
    //# log
    //##################################################

    private static final KmLogger logger = KmLogger.create(MyPropertyManager.class);

    //##################################################
    //# install
    //##################################################

    public static synchronized void install()
    {
        if ( isInstalled() )
            Kmu.fatal("Already installed.");

        installDefaults();
        installOverrides();
        postInstall();
    }

    public static synchronized boolean isInstalled()
    {
        return _defaults != null;
    }

    //##################################################
    //# variables
    //##################################################

    private static MyPropertyRegistry _defaults;
    private static MyPropertyRegistry _overrides;

    private static long               _lastModified;
    private static KmFile             _file;

    //##################################################
    //# accessing
    //##################################################

    private static MyPropertyRegistry getDefault()
    {
        return _defaults;
    }

    public static MyPropertyRegistry getProperties()
    {
        return _overrides;
    }

    //##################################################
    //# reset
    //##################################################

    public static boolean reloadOverrides()
    {
        if ( !hasOverridesFileChanged() )
            return false;

        loadOverrides();
        postInstall();
        logger.info("Overrides reloaded.");
        return true;
    }

    //##################################################
    //# install
    //##################################################

    private static void installDefaults()
    {
        MyPropertyRegistry r;
        r = new MyPropertyRegistry();
        r.setParent(null);
        r.setOverrides(null);
        r.loadDefaults(MyPropertyDefinitions.getAll());
        _defaults = r;
    }

    private static void installOverrides()
    {
        _lastModified = 0;
        _file = getOverridesFile();

        KmFile file = getOverridesFile();
        MyInstaller.printfln("overrides file = %s", file);

        if ( !file.exists() )
            Kmu.fatal("OVERRIDES FILE DOES NOT EXIST!  file(%s).", file);

        MyPropertyRegistry r;
        r = new MyPropertyRegistry();
        r.setParent(getDefault());
        r.loadFile(file);
        _overrides = r;

        loadOverrides();
    }

    private static void postInstall()
    {
        validate();

        MyPropertyRegistry p = getProperties();

        KmSqlStatementWrapper.defaultSlowSqlThresholdMs = p.getSqlWarningThresholdMs();

        // KmDaoCommand.defaultWarningThresholdMs = p.getDaoCommandWarningThresholdMs();

        ScGoogleChart.scheme = p.getGoogleChartScheme();
        ScGoogleChart.host = p.getGoogleChartHost();
        ScGoogleChart.port = p.getGoogleChartPort();
        ScGoogleChart.path = p.getGoogleChartPath();

        KmContextFormatter.enabled = p.getContextFormatterEnabled();
        KmContextFormatter.lines = p.getContextFormatterLines();
    }

    private static void validate()
    {
        KmList<String> allKeys = MyPropertyDefinitions.getAllKeys();
        KmList<String> unknownKeys = getProperties().getUnknownKeys(allKeys);
        if ( unknownKeys.isNotEmpty() )
        {
            String s = Kmu.format("Unknown properties: %s.", unknownKeys.format());
            logger.warnTrace(s);
        }
    }

    //##################################################
    //# load overrides
    //##################################################

    private static void loadOverrides()
    {
        if ( overridesFileExists() )
        {
            _lastModified = _file.getLastModifiedOrdinal();
            _overrides.loadFile(_file);
        }
        else
        {
            _lastModified = 0;
            _overrides.clearValues();
        }
    }

    private static boolean hasOverridesFileChanged()
    {
        if ( overridesFileExists() )
            return _file.getLastModifiedOrdinal() != _lastModified;

        return _lastModified != 0;
    }

    private static boolean overridesFileExists()
    {
        return _file.exists();
    }

    //##################################################
    //# paths
    //##################################################

    private static KmFile getOverridesFile()
    {
        return MyResourceFiles.getInstance().getOverridesFile();
    }
}
