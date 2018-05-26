//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.property.base;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.log.*;
import com.kodemore.property.*;
import com.kodemore.property.type.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.property.*;

public class MyPropertyDefinitions
{
    //##################################################
    //# group and keys
    //##################################################

    public static final String GROUP_BOOTSTRAP = "bootstrap";
    public static final String PROPERTY_BOOTSTRAP_SYSTEM_HOSTNAME = "bootstrapSystemHostname";

    public static final String GROUP_CHORES = "chores";
    public static final String PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_ACTIVE_SECONDS = "applicationLogFlusherChoreActiveSeconds";
    public static final String PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_ENABLED = "applicationLogFlusherChoreEnabled";
    public static final String PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_IDLE_SECONDS = "applicationLogFlusherChoreIdleSeconds";
    public static final String PROPERTY_CLEAR_THEME_CACHE_CHORE_ACTIVE_SECONDS = "clearThemeCacheChoreActiveSeconds";
    public static final String PROPERTY_CLEAR_THEME_CACHE_CHORE_ENABLED = "clearThemeCacheChoreEnabled";
    public static final String PROPERTY_CLEAR_THEME_CACHE_CHORE_IDLE_SECONDS = "clearThemeCacheChoreIdleSeconds";
    public static final String PROPERTY_LOGJ_RELOADER_CHORE_ACTIVE_SECONDS = "log4jReloaderChoreActiveSeconds";
    public static final String PROPERTY_LOGJ_RELOADER_CHORE_ENABLED = "log4jReloaderChoreEnabled";
    public static final String PROPERTY_LOGJ_RELOADER_CHORE_IDLE_SECONDS = "log4jReloaderChoreIdleSeconds";
    public static final String PROPERTY_MAINTENANCE_CHORE_ACTIVE_SECONDS = "maintenanceChoreActiveSeconds";
    public static final String PROPERTY_MAINTENANCE_CHORE_ENABLED = "maintenanceChoreEnabled";
    public static final String PROPERTY_MAINTENANCE_CHORE_IDLE_SECONDS = "maintenanceChoreIdleSeconds";
    public static final String PROPERTY_MONITOR_CHORE_ACTIVE_SECONDS = "monitorChoreActiveSeconds";
    public static final String PROPERTY_MONITOR_CHORE_ENABLED = "monitorChoreEnabled";
    public static final String PROPERTY_MONITOR_CHORE_IDLE_SECONDS = "monitorChoreIdleSeconds";
    public static final String PROPERTY_OVERRIDES_RELOADER_CHORE_ACTIVE_SECONDS = "overridesReloaderChoreActiveSeconds";
    public static final String PROPERTY_OVERRIDES_RELOADER_CHORE_ENABLED = "overridesReloaderChoreEnabled";
    public static final String PROPERTY_OVERRIDES_RELOADER_CHORE_IDLE_SECONDS = "overridesReloaderChoreIdleSeconds";
    public static final String PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_ACTIVE_SECONDS = "performanceLogFlusherChoreActiveSeconds";
    public static final String PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_ENABLED = "performanceLogFlusherChoreEnabled";
    public static final String PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_IDLE_SECONDS = "performanceLogFlusherChoreIdleSeconds";

    public static final String GROUP_DATABASE_CONNECTION = "databaseConnection";
    public static final String PROPERTY_DATABASE_DRIVER = "databaseDriver";
    public static final String PROPERTY_DATABASE_PASSWORD = "databasePassword";
    public static final String PROPERTY_DATABASE_SCHEMA = "databaseSchema";
    public static final String PROPERTY_DATABASE_URI = "databaseUri";
    public static final String PROPERTY_DATABASE_USER = "databaseUser";

    public static final String GROUP_DATABASE_PATCH = "databasePatch";
    public static final String PROPERTY_DATABASE_SYNC_ON_STARTUP = "databaseSyncOnStartup";

    public static final String GROUP_DEBUG = "debug";
    public static final String PROPERTY_AJAX_LOG_DELETE_ON_START = "ajaxLogDeleteOnStart";
    public static final String PROPERTY_AJAX_LOG_ENABLED = "ajaxLogEnabled";
    public static final String PROPERTY_AUTO_LOGIN_EMAIL = "autoLoginEmail";
    public static final String PROPERTY_CONTEXT_FORMATTER_ENABLED = "contextFormatterEnabled";
    public static final String PROPERTY_CONTEXT_FORMATTER_LINES = "contextFormatterLines";
    public static final String PROPERTY_DELETE_THREAD_TOPICS_ON_START = "deleteThreadTopicsOnStart";
    public static final String PROPERTY_PRINT_AJAX_TIME = "printAjaxTime";
    public static final String PROPERTY_PRINT_AUDIT_LOG = "printAuditLog";
    public static final String PROPERTY_PRINT_PERFORMANCE_LOG = "printPerformanceLog";
    public static final String PROPERTY_RENDER_DEBUG_DOM_COMMENTS = "renderDebugDomComments";
    public static final String PROPERTY_SHOW_HIBERNATE_SQL = "showHibernateSql";

    public static final String GROUP_EMAIL_CHORE = "emailChore";
    public static final String PROPERTY_SEND_EMAIL_BATCH = "sendEmailBatch";
    public static final String PROPERTY_SEND_EMAIL_CHORE_ACTIVE_SECONDS = "sendEmailChoreActiveSeconds";
    public static final String PROPERTY_SEND_EMAIL_CHORE_ENABLED = "sendEmailChoreEnabled";
    public static final String PROPERTY_SEND_EMAIL_CHORE_IDLE_SECONDS = "sendEmailChoreIdleSeconds";
    public static final String PROPERTY_SEND_EMAIL_ENABLED = "sendEmailEnabled";

    public static final String GROUP_EMAIL_GOOGLE_MAIL = "emailGoogleMail";
    public static final String PROPERTY_GMAIL_HOST = "gmailHost";
    public static final String PROPERTY_GMAIL_PASSWORD = "gmailPassword";
    public static final String PROPERTY_GMAIL_PORT = "gmailPort";
    public static final String PROPERTY_GMAIL_SCHEME = "gmailScheme";
    public static final String PROPERTY_GMAIL_USER = "gmailUser";

    public static final String GROUP_EMAIL_METHOD = "emailMethod";
    public static final String PROPERTY_SEND_EMAIL_FROM_ADDRESS = "sendEmailFromAddress";
    public static final String PROPERTY_SEND_EMAIL_METHOD = "sendEmailMethod";
    public static final String PROPERTY_SEND_EMAIL_OVERRIDE_TO = "sendEmailOverrideTo";

    public static final String GROUP_EMAIL_SMTP = "emailSmtp";
    public static final String PROPERTY_SMTP_HOST = "smtpHost";
    public static final String PROPERTY_SMTP_PASSWORD = "smtpPassword";
    public static final String PROPERTY_SMTP_PORT = "smtpPort";
    public static final String PROPERTY_SMTP_SCHEME = "smtpScheme";
    public static final String PROPERTY_SMTP_USE_SSL = "smtpUseSsl";
    public static final String PROPERTY_SMTP_USER = "smtpUser";

    public static final String GROUP_FTP = "ftp";
    public static final String PROPERTY_FTP_ENABLED = "ftpEnabled";
    public static final String PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_ACTIVE_SECONDS = "ftpSendToNotifierChoreActiveSeconds";
    public static final String PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_ENABLED = "ftpSendToNotifierChoreEnabled";
    public static final String PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_IDLE_SECONDS = "ftpSendToNotifierChoreIdleSeconds";

    public static final String GROUP_GOOGLE_CHART = "googleChart";
    public static final String PROPERTY_GOOGLE_CHART_HOST = "googleChartHost";
    public static final String PROPERTY_GOOGLE_CHART_PATH = "googleChartPath";
    public static final String PROPERTY_GOOGLE_CHART_PORT = "googleChartPort";
    public static final String PROPERTY_GOOGLE_CHART_SCHEME = "googleChartScheme";

    public static final String GROUP_GOOGLE_MAPS = "googleMaps";
    public static final String PROPERTY_GOOGLE_MAPS_API_KEY = "googleMapsApiKey";

    public static final String GROUP_HIBERNATE_SECOND_LEVEL_CACHE = "hibernateSecondLevelCache";
    public static final String PROPERTY_HIBERNATE_CACHE_PROVIDER = "hibernateCacheProvider";
    public static final String PROPERTY_HIBERNATE_CACHE_TIME_SECONDS = "hibernateCacheTimeSeconds";
    public static final String PROPERTY_HIBERNATE_MEMCACHED_SERVERS = "hibernateMemcachedServers";
    public static final String PROPERTY_HIBERNATE_USE_SECOND_LEVEL_CACHE = "hibernateUseSecondLevelCache";

    public static final String GROUP_MAINTENANCE = "maintenance";
    public static final String PROPERTY_MAINTENANCE_PERIOD_END_HOUR = "maintenancePeriodEndHour";
    public static final String PROPERTY_MAINTENANCE_PERIOD_START_HOUR = "maintenancePeriodStartHour";

    public static final String GROUP_MONITORING = "monitoring";
    public static final String PROPERTY_CHORE_PERFORMANCE_LOG_ENABLED = "chorePerformanceLogEnabled";
    public static final String PROPERTY_DAO_COMMAND_WARNING_THRESHOLD_MS = "daoCommandWarningThresholdMs";
    public static final String PROPERTY_SQL_WARNING_THRESHOLD_MS = "sqlWarningThresholdMs";

    public static final String GROUP_ONE_ALL = "oneAll";
    public static final String PROPERTY_ONE_ALL_ENABLED = "oneAllEnabled";
    public static final String PROPERTY_ONE_ALL_HOST = "oneAllHost";
    public static final String PROPERTY_ONE_ALL_PRIVATE_KEY = "oneAllPrivateKey";
    public static final String PROPERTY_ONE_ALL_PUBLIC_KEY = "oneAllPublicKey";

    public static final String GROUP_PATHS = "paths";
    public static final String PROPERTY_SHARED_PERSISTENT_PATH = "sharedPersistentPath";
    public static final String PROPERTY_SHARED_TRANSIENT_PATH = "sharedTransientPath";

    public static final String GROUP_PRODUCTION = "production";
    public static final String PROPERTY_DEVELOPER_EMAIL_CSV = "developerEmailCsv";
    public static final String PROPERTY_ENVIRONMENT = "environment";

    public static final String GROUP_SERVER_SESSION = "serverSession";
    public static final String PROPERTY_SERVER_SESSION_SECURE = "serverSessionSecure";
    public static final String PROPERTY_SERVER_SESSION_TIMEOUT_SECONDS = "serverSessionTimeoutSeconds";

    public static final String GROUP_SERVLET = "servlet";
    public static final String PROPERTY_SERVLET_SSL_REDIRECT = "servletSslRedirect";
    public static final String PROPERTY_WEB_RESOURCE_VERSIONING = "webResourceVersioning";
    public static final String PROPERTY_WRITE_LAST_SERVLET_RESULTS = "writeLastServletResults";
    public static final String PROPERTY_WRITE_LAST_SERVLET_RESULTS_COUNTER = "writeLastServletResultsCounter";

    public static final String GROUP_URLS = "urls";
    public static final String PROPERTY_MARKETING_URL = "marketingUrl";
    public static final String PROPERTY_SUPPORT_URL = "supportUrl";


    //##################################################
    //# install
    //##################################################

    private static KmMap<String,MyPropertyDefinition> installDefinitions()
    {
        KmMap<String,MyPropertyDefinition> m;
        m = new KmMap<>();

        // bootstrap
        install(m, newBootstrapSystemHostname());

        // chores
        install(m, newApplicationLogFlusherChoreActiveSeconds());
        install(m, newApplicationLogFlusherChoreEnabled());
        install(m, newApplicationLogFlusherChoreIdleSeconds());
        install(m, newClearThemeCacheChoreActiveSeconds());
        install(m, newClearThemeCacheChoreEnabled());
        install(m, newClearThemeCacheChoreIdleSeconds());
        install(m, newLog4jReloaderChoreActiveSeconds());
        install(m, newLog4jReloaderChoreEnabled());
        install(m, newLog4jReloaderChoreIdleSeconds());
        install(m, newMaintenanceChoreActiveSeconds());
        install(m, newMaintenanceChoreEnabled());
        install(m, newMaintenanceChoreIdleSeconds());
        install(m, newMonitorChoreActiveSeconds());
        install(m, newMonitorChoreEnabled());
        install(m, newMonitorChoreIdleSeconds());
        install(m, newOverridesReloaderChoreActiveSeconds());
        install(m, newOverridesReloaderChoreEnabled());
        install(m, newOverridesReloaderChoreIdleSeconds());
        install(m, newPerformanceLogFlusherChoreActiveSeconds());
        install(m, newPerformanceLogFlusherChoreEnabled());
        install(m, newPerformanceLogFlusherChoreIdleSeconds());

        // databaseConnection
        install(m, newDatabaseDriver());
        install(m, newDatabasePassword());
        install(m, newDatabaseSchema());
        install(m, newDatabaseUri());
        install(m, newDatabaseUser());

        // databasePatch
        install(m, newDatabaseSyncOnStartup());

        // debug
        install(m, newAjaxLogDeleteOnStart());
        install(m, newAjaxLogEnabled());
        install(m, newAutoLoginEmail());
        install(m, newContextFormatterEnabled());
        install(m, newContextFormatterLines());
        install(m, newDeleteThreadTopicsOnStart());
        install(m, newPrintAjaxTime());
        install(m, newPrintAuditLog());
        install(m, newPrintPerformanceLog());
        install(m, newRenderDebugDomComments());
        install(m, newShowHibernateSql());

        // emailChore
        install(m, newSendEmailBatch());
        install(m, newSendEmailChoreActiveSeconds());
        install(m, newSendEmailChoreEnabled());
        install(m, newSendEmailChoreIdleSeconds());
        install(m, newSendEmailEnabled());

        // emailGoogleMail
        install(m, newGmailHost());
        install(m, newGmailPassword());
        install(m, newGmailPort());
        install(m, newGmailScheme());
        install(m, newGmailUser());

        // emailMethod
        install(m, newSendEmailFromAddress());
        install(m, newSendEmailMethod());
        install(m, newSendEmailOverrideTo());

        // emailSmtp
        install(m, newSmtpHost());
        install(m, newSmtpPassword());
        install(m, newSmtpPort());
        install(m, newSmtpScheme());
        install(m, newSmtpUseSsl());
        install(m, newSmtpUser());

        // ftp
        install(m, newFtpEnabled());
        install(m, newFtpSendToNotifierChoreActiveSeconds());
        install(m, newFtpSendToNotifierChoreEnabled());
        install(m, newFtpSendToNotifierChoreIdleSeconds());

        // googleChart
        install(m, newGoogleChartHost());
        install(m, newGoogleChartPath());
        install(m, newGoogleChartPort());
        install(m, newGoogleChartScheme());

        // googleMaps
        install(m, newGoogleMapsApiKey());

        // hibernateSecondLevelCache
        install(m, newHibernateCacheProvider());
        install(m, newHibernateCacheTimeSeconds());
        install(m, newHibernateMemcachedServers());
        install(m, newHibernateUseSecondLevelCache());

        // maintenance
        install(m, newMaintenancePeriodEndHour());
        install(m, newMaintenancePeriodStartHour());

        // monitoring
        install(m, newChorePerformanceLogEnabled());
        install(m, newDaoCommandWarningThresholdMs());
        install(m, newSqlWarningThresholdMs());

        // oneAll
        install(m, newOneAllEnabled());
        install(m, newOneAllHost());
        install(m, newOneAllPrivateKey());
        install(m, newOneAllPublicKey());

        // paths
        install(m, newSharedPersistentPath());
        install(m, newSharedTransientPath());

        // production
        install(m, newDeveloperEmailCsv());
        install(m, newEnvironment());

        // serverSession
        install(m, newServerSessionSecure());
        install(m, newServerSessionTimeoutSeconds());

        // servlet
        install(m, newServletSslRedirect());
        install(m, newWebResourceVersioning());
        install(m, newWriteLastServletResults());
        install(m, newWriteLastServletResultsCounter());

        // urls
        install(m, newMarketingUrl());
        install(m, newSupportUrl());

        return m;
    }

    private static void install(KmMap<String,MyPropertyDefinition> m, MyPropertyDefinition p)
    {
        String key = p.getKey();
        if ( key == null )
        {
            KmLog.errorTrace("Attempting to install a property definition with a NULL key.");
            return;
        }
        if ( p.getType() == null )
        {
            KmLog.errorTrace("Attempt to install a property definition with no type(%s)", key);
            return;
        }
        if ( m.containsKey(key) )
        {
            KmLog.errorTrace("Attempting to install a duplicate property definition (%s).", key);
            return;
        }
        m.put(key, p);
    }

    //##################################################
    //# install (bootstrap)
    //##################################################

    private static MyPropertyDefinition newBootstrapSystemHostname()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_BOOTSTRAP);
        e.setKey(PROPERTY_BOOTSTRAP_SYSTEM_HOSTNAME);
        e.setComment("This is primarily used when bootstraping the initial 'system' tenant. After the initial bootstrap, the application should rely on the hostname configured in the tenant database and identified by the 'system' uid in case the hostname is reconfigured in the live system.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("system.localhost");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (chores)
    //##################################################

    private static MyPropertyDefinition newApplicationLogFlusherChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newApplicationLogFlusherChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_ENABLED);
        e.setComment("Indicates if the chore should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newApplicationLogFlusherChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newClearThemeCacheChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_CLEAR_THEME_CACHE_CHORE_ACTIVE_SECONDS);
        e.setComment("The active frequency of the chore.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("300");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newClearThemeCacheChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_CLEAR_THEME_CACHE_CHORE_ENABLED);
        e.setComment("Indicates if the chore should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newClearThemeCacheChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_CLEAR_THEME_CACHE_CHORE_IDLE_SECONDS);
        e.setComment("The idle frequency of the chore.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("300");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newLog4jReloaderChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_LOGJ_RELOADER_CHORE_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newLog4jReloaderChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_LOGJ_RELOADER_CHORE_ENABLED);
        e.setComment("Control whether the log4j config file is automatically reloaded during runtime.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newLog4jReloaderChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_LOGJ_RELOADER_CHORE_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMaintenanceChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_MAINTENANCE_CHORE_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMaintenanceChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_MAINTENANCE_CHORE_ENABLED);
        e.setComment("Indicates if the chore should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMaintenanceChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_MAINTENANCE_CHORE_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMonitorChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_MONITOR_CHORE_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("600");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMonitorChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_MONITOR_CHORE_ENABLED);
        e.setComment("Indicates if the chore should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMonitorChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_MONITOR_CHORE_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("600");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOverridesReloaderChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_OVERRIDES_RELOADER_CHORE_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOverridesReloaderChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_OVERRIDES_RELOADER_CHORE_ENABLED);
        e.setComment("Control whether the Overrides file is automatically reloaded during runtime.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOverridesReloaderChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_OVERRIDES_RELOADER_CHORE_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPerformanceLogFlusherChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPerformanceLogFlusherChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_ENABLED);
        e.setComment("Indicates if the chore should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPerformanceLogFlusherChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_CHORES);
        e.setKey(PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (databaseConnection)
    //##################################################

    private static MyPropertyDefinition newDatabaseDriver()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_CONNECTION);
        e.setKey(PROPERTY_DATABASE_DRIVER);
        e.setComment("Database connection.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabasePassword()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_CONNECTION);
        e.setKey(PROPERTY_DATABASE_PASSWORD);
        e.setComment("Database connection.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabaseSchema()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_CONNECTION);
        e.setKey(PROPERTY_DATABASE_SCHEMA);
        e.setComment("Database connection.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabaseUri()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_CONNECTION);
        e.setKey(PROPERTY_DATABASE_URI);
        e.setComment("Database connection.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabaseUser()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_CONNECTION);
        e.setKey(PROPERTY_DATABASE_USER);
        e.setComment("Database connection.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (databasePatch)
    //##################################################

    private static MyPropertyDefinition newDatabaseSyncOnStartup()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_PATCH);
        e.setKey(PROPERTY_DATABASE_SYNC_ON_STARTUP);
        e.setComment("The application normally synchronizes the database patches upon startup. The patch tool uses an a pessimistic database lock to ensure single threaded operation even across multiple concurrent JVMs. This is typically enabled in production and provides for the standard way to deploy database migration scripts.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (debug)
    //##################################################

    private static MyPropertyDefinition newAjaxLogDeleteOnStart()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_AJAX_LOG_DELETE_ON_START);
        e.setComment("If true, the ajax log file is deleted when tomcat starts.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newAjaxLogEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_AJAX_LOG_ENABLED);
        e.setComment("If true, all ScAjaxResults are logged in $webRoot/ajaxLog.txt.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newAutoLoginEmail()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_AUTO_LOGIN_EMAIL);
        e.setComment("Used in development to enable automatic login.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newContextFormatterEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_CONTEXT_FORMATTER_ENABLED);
        e.setComment("Determines if the context registry is enabled. If enabled, various instances such as KmCommand will store the additional details about the call stack that constructs the original instance. This can be fairly expensive, but is valuable in debugging the context of slow commands.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newContextFormatterLines()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_CONTEXT_FORMATTER_LINES);
        e.setComment("The number of lines to include in each context. If set to a value less than or equal to 0 (e.g.: -1), the full context will be stored.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("20");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteThreadTopicsOnStart()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_DELETE_THREAD_TOPICS_ON_START);
        e.setComment("If true, all thread topics are deleted upon application start up. This is useful for simpler testing in development when we are GUARANTEED that there will be only a single JVM running at a time. This should NOT be enabled in stage or prod.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPrintAjaxTime()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_PRINT_AJAX_TIME);
        e.setComment("If true, the time spent on each ajax call is logged.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPrintAuditLog()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_PRINT_AUDIT_LOG);
        e.setComment("If true, logs are echoed to the console (log4j).");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPrintPerformanceLog()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_PRINT_PERFORMANCE_LOG);
        e.setComment("If true, logs are echoed to the console (log4j).");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newRenderDebugDomComments()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_RENDER_DEBUG_DOM_COMMENTS);
        e.setComment("If true, render an html comment into the dom that identifies the class name of the page and various controls.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newShowHibernateSql()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_SHOW_HIBERNATE_SQL);
        e.setComment("Tell hibernate to show sql. Requires a restart to take effect.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (emailChore)
    //##################################################

    private static MyPropertyDefinition newSendEmailBatch()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_CHORE);
        e.setKey(PROPERTY_SEND_EMAIL_BATCH);
        e.setComment("The number of emails to send in each batch. Sending batches can be more effecient, but if one email fails it may cause the entire batch to fail.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_CHORE);
        e.setKey(PROPERTY_SEND_EMAIL_CHORE_ACTIVE_SECONDS);
        e.setComment("The active frequency of the chore.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("5");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_CHORE);
        e.setKey(PROPERTY_SEND_EMAIL_CHORE_ENABLED);
        e.setComment("Indicates if the chore should be run. Note even if the chore is run, that doesn't mean that emails will actually be sent. See also, the sendEmail* properties.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_CHORE);
        e.setKey(PROPERTY_SEND_EMAIL_CHORE_IDLE_SECONDS);
        e.setComment("The idle frequency of the chore.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_CHORE);
        e.setKey(PROPERTY_SEND_EMAIL_ENABLED);
        e.setComment("If false, email sending is completely disabled. The sendEmail chore may still run, no email will be sent, and no emails will be marked as sent.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (emailGoogleMail)
    //##################################################

    private static MyPropertyDefinition newGmailHost()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_GOOGLE_MAIL);
        e.setKey(PROPERTY_GMAIL_HOST);
        e.setComment("Connecting to gmail.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("smtp.gmail.com");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newGmailPassword()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_GOOGLE_MAIL);
        e.setKey(PROPERTY_GMAIL_PASSWORD);
        e.setComment("Connecting to gmail.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newGmailPort()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_GOOGLE_MAIL);
        e.setKey(PROPERTY_GMAIL_PORT);
        e.setComment("Connecting to gmail.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("465");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newGmailScheme()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_GOOGLE_MAIL);
        e.setKey(PROPERTY_GMAIL_SCHEME);
        e.setComment("Connecting to gmail.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("https");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newGmailUser()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_GOOGLE_MAIL);
        e.setKey(PROPERTY_GMAIL_USER);
        e.setComment("Connecting to gmail.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (emailMethod)
    //##################################################

    private static MyPropertyDefinition newSendEmailFromAddress()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_METHOD);
        e.setKey(PROPERTY_SEND_EMAIL_FROM_ADDRESS);
        e.setComment("The address that will be listed as the 'from' address.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("doNotReply@example.net");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailMethod()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_METHOD);
        e.setKey(PROPERTY_SEND_EMAIL_METHOD);
        e.setComment("The mechanism used to send emails. Options are: smtp, gmail, print, noop. The default is set to 'print', this must be changed in production.\n [gmail] : Send emails using the gmail passthrough. [print] : Use System.out.print to display the contents of the email. [noop] : No action is take (but the email will still be marked as sent.\n If you don't want the email to be marked as sent, then you must set sendEmailEnabled=false.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("print");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailOverrideTo()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_METHOD);
        e.setKey(PROPERTY_SEND_EMAIL_OVERRIDE_TO);
        e.setComment("If set, then force all emails to be sent to this email address rather than the requested recipients. This can be useful for testing.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (emailSmtp)
    //##################################################

    private static MyPropertyDefinition newSmtpHost()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_SMTP);
        e.setKey(PROPERTY_SMTP_HOST);
        e.setComment("Connecting to smtp.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("smtp");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSmtpPassword()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_SMTP);
        e.setKey(PROPERTY_SMTP_PASSWORD);
        e.setComment("Connecting to smtp.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSmtpPort()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_SMTP);
        e.setKey(PROPERTY_SMTP_PORT);
        e.setComment("Connecting to smtp.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("25");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSmtpScheme()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_SMTP);
        e.setKey(PROPERTY_SMTP_SCHEME);
        e.setComment("Connecting to smtp.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("smtp");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSmtpUseSsl()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_SMTP);
        e.setKey(PROPERTY_SMTP_USE_SSL);
        e.setComment("Use SSL when connecting to smtp.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSmtpUser()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL_SMTP);
        e.setKey(PROPERTY_SMTP_USER);
        e.setComment("Connecting to smtp.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (ftp)
    //##################################################

    private static MyPropertyDefinition newFtpEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_FTP);
        e.setKey(PROPERTY_FTP_ENABLED);
        e.setComment("When disabled, the details of the message will be logged instead of being sent.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFtpSendToNotifierChoreActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_FTP);
        e.setKey(PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFtpSendToNotifierChoreEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_FTP);
        e.setKey(PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_ENABLED);
        e.setComment("Notify (via ftp) other depots that a device has been 'sent' to them.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFtpSendToNotifierChoreIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_FTP);
        e.setKey(PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (googleChart)
    //##################################################

    private static MyPropertyDefinition newGoogleChartHost()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_GOOGLE_CHART);
        e.setKey(PROPERTY_GOOGLE_CHART_HOST);
        e.setComment("Configure the google chart url.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("chart.apis.google.com");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newGoogleChartPath()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_GOOGLE_CHART);
        e.setKey(PROPERTY_GOOGLE_CHART_PATH);
        e.setComment("Configure the google chart url.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("chart");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newGoogleChartPort()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_GOOGLE_CHART);
        e.setKey(PROPERTY_GOOGLE_CHART_PORT);
        e.setComment("Configure the google chart url.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("80");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newGoogleChartScheme()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_GOOGLE_CHART);
        e.setKey(PROPERTY_GOOGLE_CHART_SCHEME);
        e.setComment("Configure the google chart url.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("http");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (googleMaps)
    //##################################################

    private static MyPropertyDefinition newGoogleMapsApiKey()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_GOOGLE_MAPS);
        e.setKey(PROPERTY_GOOGLE_MAPS_API_KEY);
        e.setComment("The private/secret api key for google maps api. The default key can be used for lightweight development and testing, but a different key should be used for production due to volume and licensing restrictions.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("AIzaSyD_WTy8rgoCU_yoGesX86t7tfpDyGsQWjw");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (hibernateSecondLevelCache)
    //##################################################

    private static MyPropertyDefinition newHibernateCacheProvider()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_HIBERNATE_SECOND_LEVEL_CACHE);
        e.setKey(PROPERTY_HIBERNATE_CACHE_PROVIDER);
        e.setComment("Hibernate cache provider class.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newHibernateCacheTimeSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_HIBERNATE_SECOND_LEVEL_CACHE);
        e.setKey(PROPERTY_HIBERNATE_CACHE_TIME_SECONDS);
        e.setComment("How long items should remain in the second level cache.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("300");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newHibernateMemcachedServers()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_HIBERNATE_SECOND_LEVEL_CACHE);
        e.setKey(PROPERTY_HIBERNATE_MEMCACHED_SERVERS);
        e.setComment("Names of the Memcached Servers, format is <hostname>:<port>");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newHibernateUseSecondLevelCache()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_HIBERNATE_SECOND_LEVEL_CACHE);
        e.setKey(PROPERTY_HIBERNATE_USE_SECOND_LEVEL_CACHE);
        e.setComment("Use Hibernate second level caching.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (maintenance)
    //##################################################

    private static MyPropertyDefinition newMaintenancePeriodEndHour()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MAINTENANCE);
        e.setKey(PROPERTY_MAINTENANCE_PERIOD_END_HOUR);
        e.setComment("The end of the daily maintenance window. Value should be in the range [0..23] and corresponds to UTC.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("6");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMaintenancePeriodStartHour()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MAINTENANCE);
        e.setKey(PROPERTY_MAINTENANCE_PERIOD_START_HOUR);
        e.setComment("The start of the daily maintenance window. Value should be in the range [0..23] and corresponds to UTC.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("6");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (monitoring)
    //##################################################

    private static MyPropertyDefinition newChorePerformanceLogEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MONITORING);
        e.setKey(PROPERTY_CHORE_PERFORMANCE_LOG_ENABLED);
        e.setComment("When enabled each chore's performance (ms) is logged. This is enabled by default for production, but it is sometimes useful to temporarily disable this, especially in development. Each java chore class can override this to force enablement.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDaoCommandWarningThresholdMs()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MONITORING);
        e.setKey(PROPERTY_DAO_COMMAND_WARNING_THRESHOLD_MS);
        e.setComment("Dao commands requests that exceed this threshold will be logged as a warning. A value of 0 disables logging.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("2000");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSqlWarningThresholdMs()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MONITORING);
        e.setKey(PROPERTY_SQL_WARNING_THRESHOLD_MS);
        e.setComment("Sql statements that exceed this threshold will be logged as a warning. A value of 0 disables logging.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("1000");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (oneAll)
    //##################################################

    private static MyPropertyDefinition newOneAllEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_ONE_ALL);
        e.setKey(PROPERTY_ONE_ALL_ENABLED);
        e.setComment("Determine if the oneAll login is enabled. This is disabled by default, and can only be enabled in a hosting environment that has a routable domain name.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOneAllHost()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_ONE_ALL);
        e.setKey(PROPERTY_ONE_ALL_HOST);
        e.setComment("The oneAll uri used to host our authentication service. This is provided by oneAll. E.g.: ourApplication.api.oneall.com");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOneAllPrivateKey()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_ONE_ALL);
        e.setKey(PROPERTY_ONE_ALL_PRIVATE_KEY);
        e.setComment("The private key provided by OneAll.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOneAllPublicKey()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_ONE_ALL);
        e.setKey(PROPERTY_ONE_ALL_PUBLIC_KEY);
        e.setComment("The public key provided by OneAll.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (paths)
    //##################################################

    private static MyPropertyDefinition newSharedPersistentPath()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_PATHS);
        e.setKey(PROPERTY_SHARED_PERSISTENT_PATH);
        e.setComment("The path to work files that persist across deployment. Use this path for files like ftp uploads, email attachments, csv uploads and other dynamic content. The contents of this directory are shared across all JVMs so some care needs to be take to avoid collisions. In production, this should be set to an absolute path that is outside of the web root, so that it persists across deployments.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("/temp/shared/persistent");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSharedTransientPath()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_PATHS);
        e.setKey(PROPERTY_SHARED_TRANSIENT_PATH);
        e.setComment("The path to work files that persist across deployment. Use this path for files like ftp uploads, email attachments, csv uploads and other dynamic content. The contents of this directory are shared across all JVMs so some care needs to be take to avoid collisions. In production, this should be set to an absolute path that is outside of the web root, so that it persists across deployments.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("/temp/shared/transient");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (production)
    //##################################################

    private static MyPropertyDefinition newDeveloperEmailCsv()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_PRODUCTION);
        e.setKey(PROPERTY_DEVELOPER_EMAIL_CSV);
        e.setComment("The email address(es) used when the system needs to send a message to the development staff. This may be used for things like unhandled exceptions and feedback. The values should be a comma separated list of email addresses.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newEnvironment()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_PRODUCTION);
        e.setKey(PROPERTY_ENVIRONMENT);
        e.setComment("Indicates the deployment environment. Valid options are: development, stage, production.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("development");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (serverSession)
    //##################################################

    private static MyPropertyDefinition newServerSessionSecure()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVER_SESSION);
        e.setKey(PROPERTY_SERVER_SESSION_SECURE);
        e.setComment("Indicates if the cookie should be set to require secure transmission (https/ssl).");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newServerSessionTimeoutSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVER_SESSION);
        e.setKey(PROPERTY_SERVER_SESSION_TIMEOUT_SECONDS);
        e.setComment("The length of time that a session may be idle before it is considered to be automatically stale.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("3600");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (servlet)
    //##################################################

    private static MyPropertyDefinition newServletSslRedirect()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_SERVLET_SSL_REDIRECT);
        e.setComment("If true, requests to the main application servlet will be redirected as an SSL request.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newWebResourceVersioning()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_WEB_RESOURCE_VERSIONING);
        e.setComment("This is used to automatically version css and javascript files. none - the version is always set to 'version'. deploy - used in production to include the application version in the path. dev - used in development; changes the path when the app is started.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("static");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newWriteLastServletResults()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_WRITE_LAST_SERVLET_RESULTS);
        e.setComment("If true, the servlet results are written to the web root directory.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newWriteLastServletResultsCounter()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_WRITE_LAST_SERVLET_RESULTS_COUNTER);
        e.setComment("If true, a counter is appended to the file name so that the results are not overwritten each time.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (urls)
    //##################################################

    private static MyPropertyDefinition newMarketingUrl()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_URLS);
        e.setKey(PROPERTY_MARKETING_URL);
        e.setComment("The url used to redirect people to the marketing website.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("http://www.example.net");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSupportUrl()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_URLS);
        e.setKey(PROPERTY_SUPPORT_URL);
        e.setComment("The url used to redirect people to the general support team and/or help desk.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("http://www.example.net");
        e.postInstall();
        return e;
    }

    //##################################################
    //# accessing (utility)
    //##################################################

    public static KmList<MyPropertyDefinition> getAll()
    {
        return _definitions.getValues();
    }

    public static KmList<String> getAllKeys()
    {
        KmList<String> v = _definitions.getKeys();
        v.sort();
        return v;
    }

    public static MyPropertyDefinition get(String key)
    {
        MyPropertyDefinition e = _definitions.get(key);
        if ( e == null )
            KmLog.error("No property found for key: %s.", key);
        return e;
    }

    public static KmList<String> getAllGroups()
    {
        KmList<String> v = new KmList<>();
        for ( MyPropertyDefinition e : getAll() )
            v.addDistinct(e.getGroup());
        return v;
    }

    public static KmList<MyPropertyDefinition> getAllInGroup(String group)
    {
        KmList<MyPropertyDefinition> v = new KmList<>();
        for ( MyPropertyDefinition e : getAll() )
            if ( e.hasGroup(group) )
                v.add(e);
        return v;
    }


    //##################################################
    //# accessing
    //##################################################

    public static MyPropertyDefinition getBootstrapSystemHostname()
    {
        return get(PROPERTY_BOOTSTRAP_SYSTEM_HOSTNAME);
    }

    public static MyPropertyDefinition getApplicationLogFlusherChoreActiveSeconds()
    {
        return get(PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getApplicationLogFlusherChoreEnabled()
    {
        return get(PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getApplicationLogFlusherChoreIdleSeconds()
    {
        return get(PROPERTY_APPLICATION_LOG_FLUSHER_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getClearThemeCacheChoreActiveSeconds()
    {
        return get(PROPERTY_CLEAR_THEME_CACHE_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getClearThemeCacheChoreEnabled()
    {
        return get(PROPERTY_CLEAR_THEME_CACHE_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getClearThemeCacheChoreIdleSeconds()
    {
        return get(PROPERTY_CLEAR_THEME_CACHE_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getLog4jReloaderChoreActiveSeconds()
    {
        return get(PROPERTY_LOGJ_RELOADER_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getLog4jReloaderChoreEnabled()
    {
        return get(PROPERTY_LOGJ_RELOADER_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getLog4jReloaderChoreIdleSeconds()
    {
        return get(PROPERTY_LOGJ_RELOADER_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getMaintenanceChoreActiveSeconds()
    {
        return get(PROPERTY_MAINTENANCE_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getMaintenanceChoreEnabled()
    {
        return get(PROPERTY_MAINTENANCE_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getMaintenanceChoreIdleSeconds()
    {
        return get(PROPERTY_MAINTENANCE_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getMonitorChoreActiveSeconds()
    {
        return get(PROPERTY_MONITOR_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getMonitorChoreEnabled()
    {
        return get(PROPERTY_MONITOR_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getMonitorChoreIdleSeconds()
    {
        return get(PROPERTY_MONITOR_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getOverridesReloaderChoreActiveSeconds()
    {
        return get(PROPERTY_OVERRIDES_RELOADER_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getOverridesReloaderChoreEnabled()
    {
        return get(PROPERTY_OVERRIDES_RELOADER_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getOverridesReloaderChoreIdleSeconds()
    {
        return get(PROPERTY_OVERRIDES_RELOADER_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getPerformanceLogFlusherChoreActiveSeconds()
    {
        return get(PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getPerformanceLogFlusherChoreEnabled()
    {
        return get(PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getPerformanceLogFlusherChoreIdleSeconds()
    {
        return get(PROPERTY_PERFORMANCE_LOG_FLUSHER_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getDatabaseDriver()
    {
        return get(PROPERTY_DATABASE_DRIVER);
    }

    public static MyPropertyDefinition getDatabasePassword()
    {
        return get(PROPERTY_DATABASE_PASSWORD);
    }

    public static MyPropertyDefinition getDatabaseSchema()
    {
        return get(PROPERTY_DATABASE_SCHEMA);
    }

    public static MyPropertyDefinition getDatabaseUri()
    {
        return get(PROPERTY_DATABASE_URI);
    }

    public static MyPropertyDefinition getDatabaseUser()
    {
        return get(PROPERTY_DATABASE_USER);
    }

    public static MyPropertyDefinition getDatabaseSyncOnStartup()
    {
        return get(PROPERTY_DATABASE_SYNC_ON_STARTUP);
    }

    public static MyPropertyDefinition getAjaxLogDeleteOnStart()
    {
        return get(PROPERTY_AJAX_LOG_DELETE_ON_START);
    }

    public static MyPropertyDefinition getAjaxLogEnabled()
    {
        return get(PROPERTY_AJAX_LOG_ENABLED);
    }

    public static MyPropertyDefinition getAutoLoginEmail()
    {
        return get(PROPERTY_AUTO_LOGIN_EMAIL);
    }

    public static MyPropertyDefinition getContextFormatterEnabled()
    {
        return get(PROPERTY_CONTEXT_FORMATTER_ENABLED);
    }

    public static MyPropertyDefinition getContextFormatterLines()
    {
        return get(PROPERTY_CONTEXT_FORMATTER_LINES);
    }

    public static MyPropertyDefinition getDeleteThreadTopicsOnStart()
    {
        return get(PROPERTY_DELETE_THREAD_TOPICS_ON_START);
    }

    public static MyPropertyDefinition getPrintAjaxTime()
    {
        return get(PROPERTY_PRINT_AJAX_TIME);
    }

    public static MyPropertyDefinition getPrintAuditLog()
    {
        return get(PROPERTY_PRINT_AUDIT_LOG);
    }

    public static MyPropertyDefinition getPrintPerformanceLog()
    {
        return get(PROPERTY_PRINT_PERFORMANCE_LOG);
    }

    public static MyPropertyDefinition getRenderDebugDomComments()
    {
        return get(PROPERTY_RENDER_DEBUG_DOM_COMMENTS);
    }

    public static MyPropertyDefinition getShowHibernateSql()
    {
        return get(PROPERTY_SHOW_HIBERNATE_SQL);
    }

    public static MyPropertyDefinition getSendEmailBatch()
    {
        return get(PROPERTY_SEND_EMAIL_BATCH);
    }

    public static MyPropertyDefinition getSendEmailChoreActiveSeconds()
    {
        return get(PROPERTY_SEND_EMAIL_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getSendEmailChoreEnabled()
    {
        return get(PROPERTY_SEND_EMAIL_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getSendEmailChoreIdleSeconds()
    {
        return get(PROPERTY_SEND_EMAIL_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getSendEmailEnabled()
    {
        return get(PROPERTY_SEND_EMAIL_ENABLED);
    }

    public static MyPropertyDefinition getGmailHost()
    {
        return get(PROPERTY_GMAIL_HOST);
    }

    public static MyPropertyDefinition getGmailPassword()
    {
        return get(PROPERTY_GMAIL_PASSWORD);
    }

    public static MyPropertyDefinition getGmailPort()
    {
        return get(PROPERTY_GMAIL_PORT);
    }

    public static MyPropertyDefinition getGmailScheme()
    {
        return get(PROPERTY_GMAIL_SCHEME);
    }

    public static MyPropertyDefinition getGmailUser()
    {
        return get(PROPERTY_GMAIL_USER);
    }

    public static MyPropertyDefinition getSendEmailFromAddress()
    {
        return get(PROPERTY_SEND_EMAIL_FROM_ADDRESS);
    }

    public static MyPropertyDefinition getSendEmailMethod()
    {
        return get(PROPERTY_SEND_EMAIL_METHOD);
    }

    public static MyPropertyDefinition getSendEmailOverrideTo()
    {
        return get(PROPERTY_SEND_EMAIL_OVERRIDE_TO);
    }

    public static MyPropertyDefinition getSmtpHost()
    {
        return get(PROPERTY_SMTP_HOST);
    }

    public static MyPropertyDefinition getSmtpPassword()
    {
        return get(PROPERTY_SMTP_PASSWORD);
    }

    public static MyPropertyDefinition getSmtpPort()
    {
        return get(PROPERTY_SMTP_PORT);
    }

    public static MyPropertyDefinition getSmtpScheme()
    {
        return get(PROPERTY_SMTP_SCHEME);
    }

    public static MyPropertyDefinition getSmtpUseSsl()
    {
        return get(PROPERTY_SMTP_USE_SSL);
    }

    public static MyPropertyDefinition getSmtpUser()
    {
        return get(PROPERTY_SMTP_USER);
    }

    public static MyPropertyDefinition getFtpEnabled()
    {
        return get(PROPERTY_FTP_ENABLED);
    }

    public static MyPropertyDefinition getFtpSendToNotifierChoreActiveSeconds()
    {
        return get(PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getFtpSendToNotifierChoreEnabled()
    {
        return get(PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_ENABLED);
    }

    public static MyPropertyDefinition getFtpSendToNotifierChoreIdleSeconds()
    {
        return get(PROPERTY_FTP_SEND_TO_NOTIFIER_CHORE_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getGoogleChartHost()
    {
        return get(PROPERTY_GOOGLE_CHART_HOST);
    }

    public static MyPropertyDefinition getGoogleChartPath()
    {
        return get(PROPERTY_GOOGLE_CHART_PATH);
    }

    public static MyPropertyDefinition getGoogleChartPort()
    {
        return get(PROPERTY_GOOGLE_CHART_PORT);
    }

    public static MyPropertyDefinition getGoogleChartScheme()
    {
        return get(PROPERTY_GOOGLE_CHART_SCHEME);
    }

    public static MyPropertyDefinition getGoogleMapsApiKey()
    {
        return get(PROPERTY_GOOGLE_MAPS_API_KEY);
    }

    public static MyPropertyDefinition getHibernateCacheProvider()
    {
        return get(PROPERTY_HIBERNATE_CACHE_PROVIDER);
    }

    public static MyPropertyDefinition getHibernateCacheTimeSeconds()
    {
        return get(PROPERTY_HIBERNATE_CACHE_TIME_SECONDS);
    }

    public static MyPropertyDefinition getHibernateMemcachedServers()
    {
        return get(PROPERTY_HIBERNATE_MEMCACHED_SERVERS);
    }

    public static MyPropertyDefinition getHibernateUseSecondLevelCache()
    {
        return get(PROPERTY_HIBERNATE_USE_SECOND_LEVEL_CACHE);
    }

    public static MyPropertyDefinition getMaintenancePeriodEndHour()
    {
        return get(PROPERTY_MAINTENANCE_PERIOD_END_HOUR);
    }

    public static MyPropertyDefinition getMaintenancePeriodStartHour()
    {
        return get(PROPERTY_MAINTENANCE_PERIOD_START_HOUR);
    }

    public static MyPropertyDefinition getChorePerformanceLogEnabled()
    {
        return get(PROPERTY_CHORE_PERFORMANCE_LOG_ENABLED);
    }

    public static MyPropertyDefinition getDaoCommandWarningThresholdMs()
    {
        return get(PROPERTY_DAO_COMMAND_WARNING_THRESHOLD_MS);
    }

    public static MyPropertyDefinition getSqlWarningThresholdMs()
    {
        return get(PROPERTY_SQL_WARNING_THRESHOLD_MS);
    }

    public static MyPropertyDefinition getOneAllEnabled()
    {
        return get(PROPERTY_ONE_ALL_ENABLED);
    }

    public static MyPropertyDefinition getOneAllHost()
    {
        return get(PROPERTY_ONE_ALL_HOST);
    }

    public static MyPropertyDefinition getOneAllPrivateKey()
    {
        return get(PROPERTY_ONE_ALL_PRIVATE_KEY);
    }

    public static MyPropertyDefinition getOneAllPublicKey()
    {
        return get(PROPERTY_ONE_ALL_PUBLIC_KEY);
    }

    public static MyPropertyDefinition getSharedPersistentPath()
    {
        return get(PROPERTY_SHARED_PERSISTENT_PATH);
    }

    public static MyPropertyDefinition getSharedTransientPath()
    {
        return get(PROPERTY_SHARED_TRANSIENT_PATH);
    }

    public static MyPropertyDefinition getDeveloperEmailCsv()
    {
        return get(PROPERTY_DEVELOPER_EMAIL_CSV);
    }

    public static MyPropertyDefinition getEnvironment()
    {
        return get(PROPERTY_ENVIRONMENT);
    }

    public static MyPropertyDefinition getServerSessionSecure()
    {
        return get(PROPERTY_SERVER_SESSION_SECURE);
    }

    public static MyPropertyDefinition getServerSessionTimeoutSeconds()
    {
        return get(PROPERTY_SERVER_SESSION_TIMEOUT_SECONDS);
    }

    public static MyPropertyDefinition getServletSslRedirect()
    {
        return get(PROPERTY_SERVLET_SSL_REDIRECT);
    }

    public static MyPropertyDefinition getWebResourceVersioning()
    {
        return get(PROPERTY_WEB_RESOURCE_VERSIONING);
    }

    public static MyPropertyDefinition getWriteLastServletResults()
    {
        return get(PROPERTY_WRITE_LAST_SERVLET_RESULTS);
    }

    public static MyPropertyDefinition getWriteLastServletResultsCounter()
    {
        return get(PROPERTY_WRITE_LAST_SERVLET_RESULTS_COUNTER);
    }

    public static MyPropertyDefinition getMarketingUrl()
    {
        return get(PROPERTY_MARKETING_URL);
    }

    public static MyPropertyDefinition getSupportUrl()
    {
        return get(PROPERTY_SUPPORT_URL);
    }


    //##################################################
    //# private
    //##################################################

    private static MyPropertyDefinition newPropertyDefinition()
    {
        return new MyPropertyDefinition();
    }

    //##################################################
    //# install constants
    //##################################################

    private static final KmMap<String,MyPropertyDefinition> _definitions = installDefinitions();

}

