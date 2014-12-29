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

    public static final String GROUP_PRODUCTION = "production";
    public static final String PROPERTY_ENVIRONMENT = "environment";

    public static final String GROUP_ACCOUNT_SETUP = "accountSetup";
    public static final String PROPERTY_DEFAULT_ADMIN_PASSWORD = "defaultAdminPassword";
    public static final String PROPERTY_MINIMUM_PASSWORD_LENGTH = "minimumPasswordLength";

    public static final String GROUP_PATHS = "paths";
    public static final String PROPERTY_SHARED_PERSISTENT_PATH = "sharedPersistentPath";
    public static final String PROPERTY_SHARED_TRANSIENT_PATH = "sharedTransientPath";

    public static final String GROUP_MONITORING = "monitoring";
    public static final String PROPERTY_CONTEXT_FORMATTER_ENABLED = "contextFormatterEnabled";
    public static final String PROPERTY_CONTEXT_FORMATTER_LINES = "contextFormatterLines";
    public static final String PROPERTY_DAO_COMMAND_WARNING_THRESHOLD_MS = "daoCommandWarningThresholdMs";
    public static final String PROPERTY_SQL_WARNING_THRESHOLD_MS = "sqlWarningThresholdMs";

    public static final String GROUP_EMAIL = "email";
    public static final String PROPERTY_GMAIL_HOST = "gmailHost";
    public static final String PROPERTY_GMAIL_PASSWORD = "gmailPassword";
    public static final String PROPERTY_GMAIL_PORT = "gmailPort";
    public static final String PROPERTY_GMAIL_SCHEME = "gmailScheme";
    public static final String PROPERTY_GMAIL_USER = "gmailUser";
    public static final String PROPERTY_SEND_EMAIL_BATCH = "sendEmailBatch";
    public static final String PROPERTY_SEND_EMAIL_ENABLED = "sendEmailEnabled";
    public static final String PROPERTY_SEND_EMAIL_FROM_ADDRESS = "sendEmailFromAddress";
    public static final String PROPERTY_SEND_EMAIL_JOB_ACTIVE_SECONDS = "sendEmailJobActiveSeconds";
    public static final String PROPERTY_SEND_EMAIL_JOB_ENABLED = "sendEmailJobEnabled";
    public static final String PROPERTY_SEND_EMAIL_JOB_IDLE_SECONDS = "sendEmailJobIdleSeconds";
    public static final String PROPERTY_SEND_EMAIL_METHOD = "sendEmailMethod";
    public static final String PROPERTY_SEND_EMAIL_OVERRIDE_TO = "sendEmailOverrideTo";
    public static final String PROPERTY_SMTP_HOST = "smtpHost";
    public static final String PROPERTY_SMTP_PASSWORD = "smtpPassword";
    public static final String PROPERTY_SMTP_PORT = "smtpPort";
    public static final String PROPERTY_SMTP_SCHEME = "smtpScheme";
    public static final String PROPERTY_SMTP_USE_SSL = "smtpUseSsl";
    public static final String PROPERTY_SMTP_USER = "smtpUser";

    public static final String GROUP_SERVLET = "servlet";
    public static final String PROPERTY_SERVLET_HOST = "servletHost";
    public static final String PROPERTY_SERVLET_PORT = "servletPort";
    public static final String PROPERTY_SERVLET_REDIRECT = "servletRedirect";
    public static final String PROPERTY_SERVLET_SCHEME = "servletScheme";
    public static final String PROPERTY_WRITE_LAST_SERVLET_RESULTS = "writeLastServletResults";
    public static final String PROPERTY_WRITE_LAST_SERVLET_RESULTS_COUNTER = "writeLastServletResultsCounter";

    public static final String GROUP_SERVER_SESSION = "serverSession";
    public static final String PROPERTY_SERVER_SESSION_SECURE = "serverSessionSecure";
    public static final String PROPERTY_SERVER_SESSION_TIMEOUT_SECONDS = "serverSessionTimeoutSeconds";

    public static final String GROUP_DEBUG = "debug";
    public static final String PROPERTY_ALLOW_EMPTY_USER_PASSWORDS = "allowEmptyUserPasswords";
    public static final String PROPERTY_SERVLET_SHOW_STACK_TRACE = "servletShowStackTrace";

    public static final String GROUP_DATABASE_CONNECTION = "databaseConnection";
    public static final String PROPERTY_DATABASE_DRIVER = "databaseDriver";
    public static final String PROPERTY_DATABASE_PASSWORD = "databasePassword";
    public static final String PROPERTY_DATABASE_SCHEMA = "databaseSchema";
    public static final String PROPERTY_DATABASE_URI = "databaseUri";
    public static final String PROPERTY_DATABASE_USER = "databaseUser";

    public static final String GROUP_HIBERNATE_SECOND_LEVEL_CACHE = "hibernateSecondLevelCache";
    public static final String PROPERTY_HIBERNATE_CACHE_PROVIDER = "hibernateCacheProvider";
    public static final String PROPERTY_HIBERNATE_CACHE_TIME_SECONDS = "hibernateCacheTimeSeconds";
    public static final String PROPERTY_HIBERNATE_MEMCACHED_SERVERS = "hibernateMemcachedServers";
    public static final String PROPERTY_HIBERNATE_USE_SECOND_LEVEL_CACHE = "hibernateUseSecondLevelCache";

    public static final String GROUP_DATABASE_OTHER = "databaseOther";
    public static final String PROPERTY_DATABASE_AES_PASSWORD = "databaseAesPassword";
    public static final String PROPERTY_DATABASE_BATCH_INSERT_GROUP_SIZE = "databaseBatchInsertGroupSize";
    public static final String PROPERTY_DATABASE_POOLING_DELAY_MS = "databasePoolingDelayMs";
    public static final String PROPERTY_DATABASE_POOLING_ENABLED = "databasePoolingEnabled";
    public static final String PROPERTY_DATABASE_POOLING_RETRY_COUNT = "databasePoolingRetryCount";
    public static final String PROPERTY_DATABASE_ROW_LOCK_FAILURE_RETRY_COUNT = "databaseRowLockFailureRetryCount";
    public static final String PROPERTY_DATABASE_ROW_LOCK_FAILURE_RETRY_MS = "databaseRowLockFailureRetryMs";
    public static final String PROPERTY_DATABASE_SYNC_ON_STARTUP = "databaseSyncOnStartup";

    public static final String GROUP_JOBS = "jobs";
    public static final String PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_ACTIVE_SECONDS = "csvUploadProcessorJobActiveSeconds";
    public static final String PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_ENABLED = "csvUploadProcessorJobEnabled";
    public static final String PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_IDLE_SECONDS = "csvUploadProcessorJobIdleSeconds";
    public static final String PROPERTY_DATA_PROCESSOR_JOB_ACTIVE_SECONDS = "dataProcessorJobActiveSeconds";
    public static final String PROPERTY_DATA_PROCESSOR_JOB_ENABLED = "dataProcessorJobEnabled";
    public static final String PROPERTY_DATA_PROCESSOR_JOB_IDLE_SECONDS = "dataProcessorJobIdleSeconds";
    public static final String PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_ACTIVE_SECONDS = "deleteOldPerformanceLogsJobActiveSeconds";
    public static final String PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_ENABLED = "deleteOldPerformanceLogsJobEnabled";
    public static final String PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_IDLE_SECONDS = "deleteOldPerformanceLogsJobIdleSeconds";
    public static final String PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_ACTIVE_SECONDS = "deleteOldServerSessionsJobActiveSeconds";
    public static final String PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_ENABLED = "deleteOldServerSessionsJobEnabled";
    public static final String PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_IDLE_SECONDS = "deleteOldServerSessionsJobIdleSeconds";
    public static final String PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_ACTIVE_SECONDS = "deleteOldSystemLogsJobActiveSeconds";
    public static final String PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_ENABLED = "deleteOldSystemLogsJobEnabled";
    public static final String PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_IDLE_SECONDS = "deleteOldSystemLogsJobIdleSeconds";
    public static final String PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_ACTIVE_SECONDS = "ftpSendToNotifierJobActiveSeconds";
    public static final String PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_ENABLED = "ftpSendToNotifierJobEnabled";
    public static final String PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_IDLE_SECONDS = "ftpSendToNotifierJobIdleSeconds";
    public static final String PROPERTY_LOGJ_RELOADER_JOB_ACTIVE_SECONDS = "log4jReloaderJobActiveSeconds";
    public static final String PROPERTY_LOGJ_RELOADER_JOB_ENABLED = "log4jReloaderJobEnabled";
    public static final String PROPERTY_LOGJ_RELOADER_JOB_IDLE_SECONDS = "log4jReloaderJobIdleSeconds";
    public static final String PROPERTY_MONITOR_JOB_ACTIVE_SECONDS = "monitorJobActiveSeconds";
    public static final String PROPERTY_MONITOR_JOB_ENABLED = "monitorJobEnabled";
    public static final String PROPERTY_MONITOR_JOB_IDLE_SECONDS = "monitorJobIdleSeconds";
    public static final String PROPERTY_OVERRIDES_RELOADER_JOB_ACTIVE_SECONDS = "overridesReloaderJobActiveSeconds";
    public static final String PROPERTY_OVERRIDES_RELOADER_JOB_ENABLED = "overridesReloaderJobEnabled";
    public static final String PROPERTY_OVERRIDES_RELOADER_JOB_IDLE_SECONDS = "overridesReloaderJobIdleSeconds";
    public static final String PROPERTY_PERFORMANCE_LOG_JOB_ACTIVE_SECONDS = "performanceLogJobActiveSeconds";
    public static final String PROPERTY_PERFORMANCE_LOG_JOB_ENABLED = "performanceLogJobEnabled";
    public static final String PROPERTY_PERFORMANCE_LOG_JOB_IDLE_SECONDS = "performanceLogJobIdleSeconds";

    public static final String GROUP_MISCELLANEOUS = "miscellaneous";
    public static final String PROPERTY_AJAX_LOG_DELETE_ON_START = "ajaxLogDeleteOnStart";
    public static final String PROPERTY_AJAX_LOG_ENABLED = "ajaxLogEnabled";
    public static final String PROPERTY_AUTO_LOGIN_EMAIL = "autoLoginEmail";
    public static final String PROPERTY_CHECK_RECOMMENDED_BROWSER = "checkRecommendedBrowser";
    public static final String PROPERTY_DEFAULT_TIME_ZONE_CODE = "defaultTimeZoneCode";
    public static final String PROPERTY_FILE_UPLOAD_REFRESH_MS = "fileUploadRefreshMs";
    public static final String PROPERTY_FTP_ENABLED = "ftpEnabled";
    public static final String PROPERTY_MAINTENANCE_PERIOD_END_HOUR = "maintenancePeriodEndHour";
    public static final String PROPERTY_MAINTENANCE_PERIOD_START_HOUR = "maintenancePeriodStartHour";
    public static final String PROPERTY_MEMORY_LEAK_LOOP_ENABLED = "memoryLeakLoopEnabled";
    public static final String PROPERTY_MEMORY_LEAK_LOOP_SPEED_MS = "memoryLeakLoopSpeedMs";
    public static final String PROPERTY_SHOW_HIBERNATE_SQL = "showHibernateSql";
    public static final String PROPERTY_SYNCHRONIZE_SERVLETS_BY_SESSION = "synchronizeServletsBySession";
    public static final String PROPERTY_WEB_RESOURCE_VERSIONING = "webResourceVersioning";

    public static final String GROUP_GOOGLE_CHART = "googleChart";
    public static final String PROPERTY_GOOGLE_CHART_HOST = "googleChartHost";
    public static final String PROPERTY_GOOGLE_CHART_PATH = "googleChartPath";
    public static final String PROPERTY_GOOGLE_CHART_PORT = "googleChartPort";
    public static final String PROPERTY_GOOGLE_CHART_SCHEME = "googleChartScheme";

    public static final String GROUP_BOOTSTRAP = "bootstrap";
    public static final String PROPERTY_ROOT_USER_EMAIL = "rootUserEmail";


    //##################################################
    //# install
    //##################################################

    private static KmMap<String,MyPropertyDefinition> installDefinitions()
    {
        KmMap<String,MyPropertyDefinition> m;
        m = new KmMap<>();

        // production
        install(m, newEnvironment());

        // accountSetup
        install(m, newDefaultAdminPassword());
        install(m, newMinimumPasswordLength());

        // paths
        install(m, newSharedPersistentPath());
        install(m, newSharedTransientPath());

        // monitoring
        install(m, newContextFormatterEnabled());
        install(m, newContextFormatterLines());
        install(m, newDaoCommandWarningThresholdMs());
        install(m, newSqlWarningThresholdMs());

        // email
        install(m, newGmailHost());
        install(m, newGmailPassword());
        install(m, newGmailPort());
        install(m, newGmailScheme());
        install(m, newGmailUser());
        install(m, newSendEmailBatch());
        install(m, newSendEmailEnabled());
        install(m, newSendEmailFromAddress());
        install(m, newSendEmailJobActiveSeconds());
        install(m, newSendEmailJobEnabled());
        install(m, newSendEmailJobIdleSeconds());
        install(m, newSendEmailMethod());
        install(m, newSendEmailOverrideTo());
        install(m, newSmtpHost());
        install(m, newSmtpPassword());
        install(m, newSmtpPort());
        install(m, newSmtpScheme());
        install(m, newSmtpUseSsl());
        install(m, newSmtpUser());

        // servlet
        install(m, newServletHost());
        install(m, newServletPort());
        install(m, newServletRedirect());
        install(m, newServletScheme());
        install(m, newWriteLastServletResults());
        install(m, newWriteLastServletResultsCounter());

        // serverSession
        install(m, newServerSessionSecure());
        install(m, newServerSessionTimeoutSeconds());

        // debug
        install(m, newAllowEmptyUserPasswords());
        install(m, newServletShowStackTrace());

        // databaseConnection
        install(m, newDatabaseDriver());
        install(m, newDatabasePassword());
        install(m, newDatabaseSchema());
        install(m, newDatabaseUri());
        install(m, newDatabaseUser());

        // hibernateSecondLevelCache
        install(m, newHibernateCacheProvider());
        install(m, newHibernateCacheTimeSeconds());
        install(m, newHibernateMemcachedServers());
        install(m, newHibernateUseSecondLevelCache());

        // databaseOther
        install(m, newDatabaseAesPassword());
        install(m, newDatabaseBatchInsertGroupSize());
        install(m, newDatabasePoolingDelayMs());
        install(m, newDatabasePoolingEnabled());
        install(m, newDatabasePoolingRetryCount());
        install(m, newDatabaseRowLockFailureRetryCount());
        install(m, newDatabaseRowLockFailureRetryMs());
        install(m, newDatabaseSyncOnStartup());

        // jobs
        install(m, newCsvUploadProcessorJobActiveSeconds());
        install(m, newCsvUploadProcessorJobEnabled());
        install(m, newCsvUploadProcessorJobIdleSeconds());
        install(m, newDataProcessorJobActiveSeconds());
        install(m, newDataProcessorJobEnabled());
        install(m, newDataProcessorJobIdleSeconds());
        install(m, newDeleteOldPerformanceLogsJobActiveSeconds());
        install(m, newDeleteOldPerformanceLogsJobEnabled());
        install(m, newDeleteOldPerformanceLogsJobIdleSeconds());
        install(m, newDeleteOldServerSessionsJobActiveSeconds());
        install(m, newDeleteOldServerSessionsJobEnabled());
        install(m, newDeleteOldServerSessionsJobIdleSeconds());
        install(m, newDeleteOldSystemLogsJobActiveSeconds());
        install(m, newDeleteOldSystemLogsJobEnabled());
        install(m, newDeleteOldSystemLogsJobIdleSeconds());
        install(m, newFtpSendToNotifierJobActiveSeconds());
        install(m, newFtpSendToNotifierJobEnabled());
        install(m, newFtpSendToNotifierJobIdleSeconds());
        install(m, newLog4jReloaderJobActiveSeconds());
        install(m, newLog4jReloaderJobEnabled());
        install(m, newLog4jReloaderJobIdleSeconds());
        install(m, newMonitorJobActiveSeconds());
        install(m, newMonitorJobEnabled());
        install(m, newMonitorJobIdleSeconds());
        install(m, newOverridesReloaderJobActiveSeconds());
        install(m, newOverridesReloaderJobEnabled());
        install(m, newOverridesReloaderJobIdleSeconds());
        install(m, newPerformanceLogJobActiveSeconds());
        install(m, newPerformanceLogJobEnabled());
        install(m, newPerformanceLogJobIdleSeconds());

        // miscellaneous
        install(m, newAjaxLogDeleteOnStart());
        install(m, newAjaxLogEnabled());
        install(m, newAutoLoginEmail());
        install(m, newCheckRecommendedBrowser());
        install(m, newDefaultTimeZoneCode());
        install(m, newFileUploadRefreshMs());
        install(m, newFtpEnabled());
        install(m, newMaintenancePeriodEndHour());
        install(m, newMaintenancePeriodStartHour());
        install(m, newMemoryLeakLoopEnabled());
        install(m, newMemoryLeakLoopSpeedMs());
        install(m, newShowHibernateSql());
        install(m, newSynchronizeServletsBySession());
        install(m, newWebResourceVersioning());

        // googleChart
        install(m, newGoogleChartHost());
        install(m, newGoogleChartPath());
        install(m, newGoogleChartPort());
        install(m, newGoogleChartScheme());

        // bootstrap
        install(m, newRootUserEmail());

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
    //# install (production)
    //##################################################

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
    //# install (accountSetup)
    //##################################################

    private static MyPropertyDefinition newDefaultAdminPassword()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_ACCOUNT_SETUP);
        e.setKey(PROPERTY_DEFAULT_ADMIN_PASSWORD);
        e.setComment("The password to be used for the initial admin user on all new accounts.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("admin123");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMinimumPasswordLength()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_ACCOUNT_SETUP);
        e.setKey(PROPERTY_MINIMUM_PASSWORD_LENGTH);
        e.setComment("The minimum number of characters required for a valid password.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("5");
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
        e.setComment("The path to work files that persist across deployment. Use this path for files like; ftp uploads, email attachments, csv uploads and other dynamic content. The contents of this directory are shared across all JVMs so some care needs to be take to avoid collisions. In production, this should be set to an absolute path that is outside of the web root, so that it persists across deployments.");
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
        e.setComment("The path to work files that persist across deployment. Use this path for files like; ftp uploads, email attachments, csv uploads and other dynamic content. The contents of this directory are shared across all JVMs so some care needs to be take to avoid collisions. In production, this should be set to an absolute path that is outside of the web root, so that it persists across deployments.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("/temp/shared/transient");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (monitoring)
    //##################################################

    private static MyPropertyDefinition newContextFormatterEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MONITORING);
        e.setKey(PROPERTY_CONTEXT_FORMATTER_ENABLED);
        e.setComment("Determines if the context registry is enabled. If enabled various instances, e.g.: KmCommand, ScAction will store the context (call stack) that the constructs each instance. This can be fairly expensive, but is extremely valuable in debugging the context of slow commands.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newContextFormatterLines()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MONITORING);
        e.setKey(PROPERTY_CONTEXT_FORMATTER_LINES);
        e.setComment("The number of lines to include in each context. If set to a value less than or equal to 0 (e.g.: -1), the full context will be stored.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("20");
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
    //# install (email)
    //##################################################

    private static MyPropertyDefinition newGmailHost()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_GMAIL_USER);
        e.setComment("Connecting to gmail.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailBatch()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_BATCH);
        e.setComment("The number of emails to send in each batch. Sending batches can be more effecient, but if one email fails it may cause the entire batch fail.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_ENABLED);
        e.setComment("If false, email sending is completely disabled. The sendEmail job may still run, no email will be sent, and no emails will be marked as sent.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailFromAddress()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_FROM_ADDRESS);
        e.setComment("The address that will be listed as the 'from' address.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("DoNotReply@accucode.com");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_JOB_ACTIVE_SECONDS);
        e.setComment("The active frquency of the job.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("5");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_JOB_ENABLED);
        e.setComment("Indicates if the job should be run. Note even if the job is run, that doesn't mean that emails will actually be sent. See also, the sendEmail* properties.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_JOB_IDLE_SECONDS);
        e.setComment("The idle frquency of the job.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailMethod()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_METHOD);
        e.setComment("The mechanism used to send emails. Options are: smtp, gmail, print, noop. The default is set to 'print', this must be changed in production. [gmail]: send emails using the gmail passthrough. [print] Use System.out.print to display the contents of the email. [noop]: no action is take (but the email will still be maked as sent; if you don't want the email to be marked as sent, then you must set sendEmailEnabled=false.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("print");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSendEmailOverrideTo()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SEND_EMAIL_OVERRIDE_TO);
        e.setComment("If set, then force all emails to be sent to this email address rather than the requested recipients. This can be useful for testing.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSmtpHost()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
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
        e.setGroup(GROUP_EMAIL);
        e.setKey(PROPERTY_SMTP_USER);
        e.setComment("Connecting to smtp.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (servlet)
    //##################################################

    private static MyPropertyDefinition newServletHost()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_SERVLET_HOST);
        e.setComment("This should be set to the appropriate host name. For simple development 'localhost' can typically be used. However, some development and local debugging may need a static IP address.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newServletPort()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_SERVLET_PORT);
        e.setComment("The port number used to serve the servlet requests. Normally left blank, so that it defaults based on the scheme.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newServletRedirect()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_SERVLET_REDIRECT);
        e.setComment("If true, then attempt to redirect users to the appropriate scheme.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newServletScheme()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_SERVLET);
        e.setKey(PROPERTY_SERVLET_SCHEME);
        e.setComment("The scheme used. Typically http, though this may also be set to https.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("http");
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
    //# install (debug)
    //##################################################

    private static MyPropertyDefinition newAllowEmptyUserPasswords()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_ALLOW_EMPTY_USER_PASSWORDS);
        e.setComment("Determines if empty/blank passwords should be allowed.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newServletShowStackTrace()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DEBUG);
        e.setKey(PROPERTY_SERVLET_SHOW_STACK_TRACE);
        e.setComment("Determines if the stack trace should be displayed upon errors. Normally, this is 'false' and the trace is hidden in a comment. For debugging this is usually enabled.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
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
    //# install (databaseOther)
    //##################################################

    private static MyPropertyDefinition newDatabaseAesPassword()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_AES_PASSWORD);
        e.setComment("The password used for aes encryption. The password must be exactly 16 characters long. This should be overriden in production.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("databasePassword");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabaseBatchInsertGroupSize()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_BATCH_INSERT_GROUP_SIZE);
        e.setComment("The number of records that should be inserted at a time when performing batch inserts. The framework provides convenience methods for inserting a list of models. However there are certain database limits on the maximum size of a statement. This parameter automatically takes a batch of arbitrary size and splits it into chunks that the database can handle.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("100");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabasePoolingDelayMs()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_POOLING_DELAY_MS);
        e.setComment("The number of milliseconds between retries when attempting to create a new pooled connection.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("100");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabasePoolingEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_POOLING_ENABLED);
        e.setComment("Determines if local database pooling is enabled. When available, it is better to disable this pooling and use more robust pooling provided by an application server. However, this pooling should still be robust enough for production use.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabasePoolingRetryCount()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_POOLING_RETRY_COUNT);
        e.setComment("This is the number of times that the pooling manager will attempt to create a new connection before throwing an exception.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("5");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabaseRowLockFailureRetryCount()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_ROW_LOCK_FAILURE_RETRY_COUNT);
        e.setComment("The maximum number of times that the system should retry to get a lock.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("0");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabaseRowLockFailureRetryMs()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_ROW_LOCK_FAILURE_RETRY_MS);
        e.setComment("The amount of time to wait between retries.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("50");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDatabaseSyncOnStartup()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_DATABASE_OTHER);
        e.setKey(PROPERTY_DATABASE_SYNC_ON_STARTUP);
        e.setComment("Normally the application will sync the database patches upon startup. Set this to false to disable.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (jobs)
    //##################################################

    private static MyPropertyDefinition newCsvUploadProcessorJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newCsvUploadProcessorJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_ENABLED);
        e.setComment("Indicates if the job should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newCsvUploadProcessorJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDataProcessorJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DATA_PROCESSOR_JOB_ACTIVE_SECONDS);
        e.setComment("The active frquency of the job.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("5");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDataProcessorJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DATA_PROCESSOR_JOB_ENABLED);
        e.setComment("Indicates if the job should be run. Note even if the job is run, that doesn't mean that emails will actually be sent. See also, the sendEmail* properties.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDataProcessorJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DATA_PROCESSOR_JOB_IDLE_SECONDS);
        e.setComment("The idle frquency of the job.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldPerformanceLogsJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldPerformanceLogsJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_ENABLED);
        e.setComment("Indicates if the job should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldPerformanceLogsJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("600");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldServerSessionsJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldServerSessionsJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_ENABLED);
        e.setComment("Indicates if the job should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldServerSessionsJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("600");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldSystemLogsJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldSystemLogsJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_ENABLED);
        e.setComment("Indicates if the job should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDeleteOldSystemLogsJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("600");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFtpSendToNotifierJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFtpSendToNotifierJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_ENABLED);
        e.setComment("Notify (via ftp) other depots that a device has been 'sent' to them.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFtpSendToNotifierJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("60");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newLog4jReloaderJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_LOGJ_RELOADER_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newLog4jReloaderJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_LOGJ_RELOADER_JOB_ENABLED);
        e.setComment("Control whether the log4j config file is automatically reloaded during runtime.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newLog4jReloaderJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_LOGJ_RELOADER_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMonitorJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_MONITOR_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("600");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMonitorJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_MONITOR_JOB_ENABLED);
        e.setComment("Indicates if the job should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMonitorJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_MONITOR_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("600");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOverridesReloaderJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_OVERRIDES_RELOADER_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOverridesReloaderJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_OVERRIDES_RELOADER_JOB_ENABLED);
        e.setComment("Control whether the Overrides file is automatically reloaded during runtime.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newOverridesReloaderJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_OVERRIDES_RELOADER_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPerformanceLogJobActiveSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_PERFORMANCE_LOG_JOB_ACTIVE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPerformanceLogJobEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_PERFORMANCE_LOG_JOB_ENABLED);
        e.setComment("Indicates if the job should be run.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newPerformanceLogJobIdleSeconds()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_JOBS);
        e.setKey(PROPERTY_PERFORMANCE_LOG_JOB_IDLE_SECONDS);
        e.setComment("x");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("10");
        e.postInstall();
        return e;
    }

    //##################################################
    //# install (miscellaneous)
    //##################################################

    private static MyPropertyDefinition newAjaxLogDeleteOnStart()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
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
        e.setGroup(GROUP_MISCELLANEOUS);
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
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_AUTO_LOGIN_EMAIL);
        e.setComment("If not blank, automatically login as this user. Useful for development.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newCheckRecommendedBrowser()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_CHECK_RECOMMENDED_BROWSER);
        e.setComment("If true, a warning will be display on login if the user is NOT using the recommended browser (firefox).");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newDefaultTimeZoneCode()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_DEFAULT_TIME_ZONE_CODE);
        e.setComment("The default time zone used for new users.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("EST-D");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFileUploadRefreshMs()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_FILE_UPLOAD_REFRESH_MS);
        e.setComment("Determines how often the progress bar should update when uploading files.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("1000");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newFtpEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_FTP_ENABLED);
        e.setComment("When disabled, the details of the message will be logged instead of being sent.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMaintenancePeriodEndHour()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
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
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_MAINTENANCE_PERIOD_START_HOUR);
        e.setComment("The start of the daily maintenance window. Value should be in the range [0..23] and corresponds to UTC.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("6");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMemoryLeakLoopEnabled()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_MEMORY_LEAK_LOOP_ENABLED);
        e.setComment("Allows you to turn the looping on and off without leaving the page.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newMemoryLeakLoopSpeedMs()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_MEMORY_LEAK_LOOP_SPEED_MS);
        e.setComment("The speed of the memory leak test page.");
        e.setType(KmPropertyTypes.TYPE_INTEGER);
        e.setDefaultValue("0");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newShowHibernateSql()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_SHOW_HIBERNATE_SQL);
        e.setComment("Tell hibernate to show sql. Requires a restart to take effect.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("false");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newSynchronizeServletsBySession()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_SYNCHRONIZE_SERVLETS_BY_SESSION);
        e.setComment("This is used to synchronize servlet threads by session.");
        e.setType(KmPropertyTypes.TYPE_BOOLEAN);
        e.setDefaultValue("true");
        e.postInstall();
        return e;
    }

    private static MyPropertyDefinition newWebResourceVersioning()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_MISCELLANEOUS);
        e.setKey(PROPERTY_WEB_RESOURCE_VERSIONING);
        e.setComment("This is used to automatically version css and javascript files.\nnone - the version is always set to 'version'.\ndeploy - used in production to include the application version in the path.\ndev - used in development to change the path each time the app is restarted.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("static");
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
    //# install (bootstrap)
    //##################################################

    private static MyPropertyDefinition newRootUserEmail()
    {
        MyPropertyDefinition e;
        e = newPropertyDefinition();
        e.setGroup(GROUP_BOOTSTRAP);
        e.setKey(PROPERTY_ROOT_USER_EMAIL);
        e.setComment("If set, the system will create a default user when bootstrapping the initial database installation.");
        e.setType(KmPropertyTypes.TYPE_STRING);
        e.setDefaultValue("");
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

    public static MyPropertyDefinition getEnvironment()
    {
        return get(PROPERTY_ENVIRONMENT);
    }

    public static MyPropertyDefinition getDefaultAdminPassword()
    {
        return get(PROPERTY_DEFAULT_ADMIN_PASSWORD);
    }

    public static MyPropertyDefinition getMinimumPasswordLength()
    {
        return get(PROPERTY_MINIMUM_PASSWORD_LENGTH);
    }

    public static MyPropertyDefinition getSharedPersistentPath()
    {
        return get(PROPERTY_SHARED_PERSISTENT_PATH);
    }

    public static MyPropertyDefinition getSharedTransientPath()
    {
        return get(PROPERTY_SHARED_TRANSIENT_PATH);
    }

    public static MyPropertyDefinition getContextFormatterEnabled()
    {
        return get(PROPERTY_CONTEXT_FORMATTER_ENABLED);
    }

    public static MyPropertyDefinition getContextFormatterLines()
    {
        return get(PROPERTY_CONTEXT_FORMATTER_LINES);
    }

    public static MyPropertyDefinition getDaoCommandWarningThresholdMs()
    {
        return get(PROPERTY_DAO_COMMAND_WARNING_THRESHOLD_MS);
    }

    public static MyPropertyDefinition getSqlWarningThresholdMs()
    {
        return get(PROPERTY_SQL_WARNING_THRESHOLD_MS);
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

    public static MyPropertyDefinition getSendEmailBatch()
    {
        return get(PROPERTY_SEND_EMAIL_BATCH);
    }

    public static MyPropertyDefinition getSendEmailEnabled()
    {
        return get(PROPERTY_SEND_EMAIL_ENABLED);
    }

    public static MyPropertyDefinition getSendEmailFromAddress()
    {
        return get(PROPERTY_SEND_EMAIL_FROM_ADDRESS);
    }

    public static MyPropertyDefinition getSendEmailJobActiveSeconds()
    {
        return get(PROPERTY_SEND_EMAIL_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getSendEmailJobEnabled()
    {
        return get(PROPERTY_SEND_EMAIL_JOB_ENABLED);
    }

    public static MyPropertyDefinition getSendEmailJobIdleSeconds()
    {
        return get(PROPERTY_SEND_EMAIL_JOB_IDLE_SECONDS);
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

    public static MyPropertyDefinition getServletHost()
    {
        return get(PROPERTY_SERVLET_HOST);
    }

    public static MyPropertyDefinition getServletPort()
    {
        return get(PROPERTY_SERVLET_PORT);
    }

    public static MyPropertyDefinition getServletRedirect()
    {
        return get(PROPERTY_SERVLET_REDIRECT);
    }

    public static MyPropertyDefinition getServletScheme()
    {
        return get(PROPERTY_SERVLET_SCHEME);
    }

    public static MyPropertyDefinition getWriteLastServletResults()
    {
        return get(PROPERTY_WRITE_LAST_SERVLET_RESULTS);
    }

    public static MyPropertyDefinition getWriteLastServletResultsCounter()
    {
        return get(PROPERTY_WRITE_LAST_SERVLET_RESULTS_COUNTER);
    }

    public static MyPropertyDefinition getServerSessionSecure()
    {
        return get(PROPERTY_SERVER_SESSION_SECURE);
    }

    public static MyPropertyDefinition getServerSessionTimeoutSeconds()
    {
        return get(PROPERTY_SERVER_SESSION_TIMEOUT_SECONDS);
    }

    public static MyPropertyDefinition getAllowEmptyUserPasswords()
    {
        return get(PROPERTY_ALLOW_EMPTY_USER_PASSWORDS);
    }

    public static MyPropertyDefinition getServletShowStackTrace()
    {
        return get(PROPERTY_SERVLET_SHOW_STACK_TRACE);
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

    public static MyPropertyDefinition getDatabaseAesPassword()
    {
        return get(PROPERTY_DATABASE_AES_PASSWORD);
    }

    public static MyPropertyDefinition getDatabaseBatchInsertGroupSize()
    {
        return get(PROPERTY_DATABASE_BATCH_INSERT_GROUP_SIZE);
    }

    public static MyPropertyDefinition getDatabasePoolingDelayMs()
    {
        return get(PROPERTY_DATABASE_POOLING_DELAY_MS);
    }

    public static MyPropertyDefinition getDatabasePoolingEnabled()
    {
        return get(PROPERTY_DATABASE_POOLING_ENABLED);
    }

    public static MyPropertyDefinition getDatabasePoolingRetryCount()
    {
        return get(PROPERTY_DATABASE_POOLING_RETRY_COUNT);
    }

    public static MyPropertyDefinition getDatabaseRowLockFailureRetryCount()
    {
        return get(PROPERTY_DATABASE_ROW_LOCK_FAILURE_RETRY_COUNT);
    }

    public static MyPropertyDefinition getDatabaseRowLockFailureRetryMs()
    {
        return get(PROPERTY_DATABASE_ROW_LOCK_FAILURE_RETRY_MS);
    }

    public static MyPropertyDefinition getDatabaseSyncOnStartup()
    {
        return get(PROPERTY_DATABASE_SYNC_ON_STARTUP);
    }

    public static MyPropertyDefinition getCsvUploadProcessorJobActiveSeconds()
    {
        return get(PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getCsvUploadProcessorJobEnabled()
    {
        return get(PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_ENABLED);
    }

    public static MyPropertyDefinition getCsvUploadProcessorJobIdleSeconds()
    {
        return get(PROPERTY_CSV_UPLOAD_PROCESSOR_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getDataProcessorJobActiveSeconds()
    {
        return get(PROPERTY_DATA_PROCESSOR_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getDataProcessorJobEnabled()
    {
        return get(PROPERTY_DATA_PROCESSOR_JOB_ENABLED);
    }

    public static MyPropertyDefinition getDataProcessorJobIdleSeconds()
    {
        return get(PROPERTY_DATA_PROCESSOR_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getDeleteOldPerformanceLogsJobActiveSeconds()
    {
        return get(PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getDeleteOldPerformanceLogsJobEnabled()
    {
        return get(PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_ENABLED);
    }

    public static MyPropertyDefinition getDeleteOldPerformanceLogsJobIdleSeconds()
    {
        return get(PROPERTY_DELETE_OLD_PERFORMANCE_LOGS_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getDeleteOldServerSessionsJobActiveSeconds()
    {
        return get(PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getDeleteOldServerSessionsJobEnabled()
    {
        return get(PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_ENABLED);
    }

    public static MyPropertyDefinition getDeleteOldServerSessionsJobIdleSeconds()
    {
        return get(PROPERTY_DELETE_OLD_SERVER_SESSIONS_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getDeleteOldSystemLogsJobActiveSeconds()
    {
        return get(PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getDeleteOldSystemLogsJobEnabled()
    {
        return get(PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_ENABLED);
    }

    public static MyPropertyDefinition getDeleteOldSystemLogsJobIdleSeconds()
    {
        return get(PROPERTY_DELETE_OLD_SYSTEM_LOGS_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getFtpSendToNotifierJobActiveSeconds()
    {
        return get(PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getFtpSendToNotifierJobEnabled()
    {
        return get(PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_ENABLED);
    }

    public static MyPropertyDefinition getFtpSendToNotifierJobIdleSeconds()
    {
        return get(PROPERTY_FTP_SEND_TO_NOTIFIER_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getLog4jReloaderJobActiveSeconds()
    {
        return get(PROPERTY_LOGJ_RELOADER_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getLog4jReloaderJobEnabled()
    {
        return get(PROPERTY_LOGJ_RELOADER_JOB_ENABLED);
    }

    public static MyPropertyDefinition getLog4jReloaderJobIdleSeconds()
    {
        return get(PROPERTY_LOGJ_RELOADER_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getMonitorJobActiveSeconds()
    {
        return get(PROPERTY_MONITOR_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getMonitorJobEnabled()
    {
        return get(PROPERTY_MONITOR_JOB_ENABLED);
    }

    public static MyPropertyDefinition getMonitorJobIdleSeconds()
    {
        return get(PROPERTY_MONITOR_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getOverridesReloaderJobActiveSeconds()
    {
        return get(PROPERTY_OVERRIDES_RELOADER_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getOverridesReloaderJobEnabled()
    {
        return get(PROPERTY_OVERRIDES_RELOADER_JOB_ENABLED);
    }

    public static MyPropertyDefinition getOverridesReloaderJobIdleSeconds()
    {
        return get(PROPERTY_OVERRIDES_RELOADER_JOB_IDLE_SECONDS);
    }

    public static MyPropertyDefinition getPerformanceLogJobActiveSeconds()
    {
        return get(PROPERTY_PERFORMANCE_LOG_JOB_ACTIVE_SECONDS);
    }

    public static MyPropertyDefinition getPerformanceLogJobEnabled()
    {
        return get(PROPERTY_PERFORMANCE_LOG_JOB_ENABLED);
    }

    public static MyPropertyDefinition getPerformanceLogJobIdleSeconds()
    {
        return get(PROPERTY_PERFORMANCE_LOG_JOB_IDLE_SECONDS);
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

    public static MyPropertyDefinition getCheckRecommendedBrowser()
    {
        return get(PROPERTY_CHECK_RECOMMENDED_BROWSER);
    }

    public static MyPropertyDefinition getDefaultTimeZoneCode()
    {
        return get(PROPERTY_DEFAULT_TIME_ZONE_CODE);
    }

    public static MyPropertyDefinition getFileUploadRefreshMs()
    {
        return get(PROPERTY_FILE_UPLOAD_REFRESH_MS);
    }

    public static MyPropertyDefinition getFtpEnabled()
    {
        return get(PROPERTY_FTP_ENABLED);
    }

    public static MyPropertyDefinition getMaintenancePeriodEndHour()
    {
        return get(PROPERTY_MAINTENANCE_PERIOD_END_HOUR);
    }

    public static MyPropertyDefinition getMaintenancePeriodStartHour()
    {
        return get(PROPERTY_MAINTENANCE_PERIOD_START_HOUR);
    }

    public static MyPropertyDefinition getMemoryLeakLoopEnabled()
    {
        return get(PROPERTY_MEMORY_LEAK_LOOP_ENABLED);
    }

    public static MyPropertyDefinition getMemoryLeakLoopSpeedMs()
    {
        return get(PROPERTY_MEMORY_LEAK_LOOP_SPEED_MS);
    }

    public static MyPropertyDefinition getShowHibernateSql()
    {
        return get(PROPERTY_SHOW_HIBERNATE_SQL);
    }

    public static MyPropertyDefinition getSynchronizeServletsBySession()
    {
        return get(PROPERTY_SYNCHRONIZE_SERVLETS_BY_SESSION);
    }

    public static MyPropertyDefinition getWebResourceVersioning()
    {
        return get(PROPERTY_WEB_RESOURCE_VERSIONING);
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

    public static MyPropertyDefinition getRootUserEmail()
    {
        return get(PROPERTY_ROOT_USER_EMAIL);
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

