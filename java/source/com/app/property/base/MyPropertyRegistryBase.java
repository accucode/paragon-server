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
import com.kodemore.policy.date.*;
import com.kodemore.policy.time.*;
import com.kodemore.policy.weight.*;
import com.kodemore.property.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;

import com.app.model.*;

public class MyPropertyRegistryBase
    extends KmPropertyRegistry
{
    //##################################################
    //# production
    //##################################################

    public Boolean getProduction()
    {
       return MyPropertyDefinitions.getProduction().getBooleanFor(this);
    }

    //##################################################
    //# accountSetup
    //##################################################

    public String getDefaultAdminPassword()
    {
       return MyPropertyDefinitions.getDefaultAdminPassword().getStringFor(this);
    }

    public Integer getMinimumPasswordLength()
    {
       return MyPropertyDefinitions.getMinimumPasswordLength().getIntegerFor(this);
    }

    //##################################################
    //# paths
    //##################################################

    public String getSharedPersistentPath()
    {
       return MyPropertyDefinitions.getSharedPersistentPath().getStringFor(this);
    }

    public String getSharedTransientPath()
    {
       return MyPropertyDefinitions.getSharedTransientPath().getStringFor(this);
    }

    //##################################################
    //# monitoring
    //##################################################

    public Boolean getContextFormatterEnabled()
    {
       return MyPropertyDefinitions.getContextFormatterEnabled().getBooleanFor(this);
    }

    public Integer getContextFormatterLines()
    {
       return MyPropertyDefinitions.getContextFormatterLines().getIntegerFor(this);
    }

    public Integer getDaoCommandWarningThresholdMs()
    {
       return MyPropertyDefinitions.getDaoCommandWarningThresholdMs().getIntegerFor(this);
    }

    public Integer getSqlWarningThresholdMs()
    {
       return MyPropertyDefinitions.getSqlWarningThresholdMs().getIntegerFor(this);
    }

    //##################################################
    //# email
    //##################################################

    public String getGmailHost()
    {
       return MyPropertyDefinitions.getGmailHost().getStringFor(this);
    }

    public String getGmailPassword()
    {
       return MyPropertyDefinitions.getGmailPassword().getStringFor(this);
    }

    public Integer getGmailPort()
    {
       return MyPropertyDefinitions.getGmailPort().getIntegerFor(this);
    }

    public String getGmailScheme()
    {
       return MyPropertyDefinitions.getGmailScheme().getStringFor(this);
    }

    public String getGmailUser()
    {
       return MyPropertyDefinitions.getGmailUser().getStringFor(this);
    }

    public Integer getSendEmailBatch()
    {
       return MyPropertyDefinitions.getSendEmailBatch().getIntegerFor(this);
    }

    public Boolean getSendEmailEnabled()
    {
       return MyPropertyDefinitions.getSendEmailEnabled().getBooleanFor(this);
    }

    public String getSendEmailFromAddress()
    {
       return MyPropertyDefinitions.getSendEmailFromAddress().getStringFor(this);
    }

    public Integer getSendEmailJobActiveSeconds()
    {
       return MyPropertyDefinitions.getSendEmailJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getSendEmailJobEnabled()
    {
       return MyPropertyDefinitions.getSendEmailJobEnabled().getBooleanFor(this);
    }

    public Integer getSendEmailJobIdleSeconds()
    {
       return MyPropertyDefinitions.getSendEmailJobIdleSeconds().getIntegerFor(this);
    }

    public String getSendEmailMethod()
    {
       return MyPropertyDefinitions.getSendEmailMethod().getStringFor(this);
    }

    public String getSendEmailOverrideTo()
    {
       return MyPropertyDefinitions.getSendEmailOverrideTo().getStringFor(this);
    }

    public String getSmtpHost()
    {
       return MyPropertyDefinitions.getSmtpHost().getStringFor(this);
    }

    public String getSmtpPassword()
    {
       return MyPropertyDefinitions.getSmtpPassword().getStringFor(this);
    }

    public Integer getSmtpPort()
    {
       return MyPropertyDefinitions.getSmtpPort().getIntegerFor(this);
    }

    public String getSmtpScheme()
    {
       return MyPropertyDefinitions.getSmtpScheme().getStringFor(this);
    }

    public String getSmtpUser()
    {
       return MyPropertyDefinitions.getSmtpUser().getStringFor(this);
    }

    //##################################################
    //# servlet
    //##################################################

    public String getServletHost()
    {
       return MyPropertyDefinitions.getServletHost().getStringFor(this);
    }

    public String getServletPort()
    {
       return MyPropertyDefinitions.getServletPort().getStringFor(this);
    }

    public Boolean getServletRedirect()
    {
       return MyPropertyDefinitions.getServletRedirect().getBooleanFor(this);
    }

    public String getServletScheme()
    {
       return MyPropertyDefinitions.getServletScheme().getStringFor(this);
    }

    public Boolean getWriteLastServletResults()
    {
       return MyPropertyDefinitions.getWriteLastServletResults().getBooleanFor(this);
    }

    public Boolean getWriteLastServletResultsCounter()
    {
       return MyPropertyDefinitions.getWriteLastServletResultsCounter().getBooleanFor(this);
    }

    //##################################################
    //# serverSession
    //##################################################

    public Boolean getServerSessionSecure()
    {
       return MyPropertyDefinitions.getServerSessionSecure().getBooleanFor(this);
    }

    public Integer getServerSessionTimeoutSeconds()
    {
       return MyPropertyDefinitions.getServerSessionTimeoutSeconds().getIntegerFor(this);
    }

    //##################################################
    //# debug
    //##################################################

    public Boolean getAllowEmptyUserPasswords()
    {
       return MyPropertyDefinitions.getAllowEmptyUserPasswords().getBooleanFor(this);
    }

    public Boolean getServletShowStackTrace()
    {
       return MyPropertyDefinitions.getServletShowStackTrace().getBooleanFor(this);
    }

    //##################################################
    //# databaseConnection
    //##################################################

    public String getDatabaseDriver()
    {
       return MyPropertyDefinitions.getDatabaseDriver().getStringFor(this);
    }

    public String getDatabasePassword()
    {
       return MyPropertyDefinitions.getDatabasePassword().getStringFor(this);
    }

    public String getDatabaseSchema()
    {
       return MyPropertyDefinitions.getDatabaseSchema().getStringFor(this);
    }

    public String getDatabaseUri()
    {
       return MyPropertyDefinitions.getDatabaseUri().getStringFor(this);
    }

    public String getDatabaseUser()
    {
       return MyPropertyDefinitions.getDatabaseUser().getStringFor(this);
    }

    //##################################################
    //# databaseOther
    //##################################################

    public String getDatabaseAesPassword()
    {
       return MyPropertyDefinitions.getDatabaseAesPassword().getStringFor(this);
    }

    public Integer getDatabaseBatchInsertGroupSize()
    {
       return MyPropertyDefinitions.getDatabaseBatchInsertGroupSize().getIntegerFor(this);
    }

    public Integer getDatabasePoolingDelayMs()
    {
       return MyPropertyDefinitions.getDatabasePoolingDelayMs().getIntegerFor(this);
    }

    public Boolean getDatabasePoolingEnabled()
    {
       return MyPropertyDefinitions.getDatabasePoolingEnabled().getBooleanFor(this);
    }

    public Integer getDatabasePoolingRetryCount()
    {
       return MyPropertyDefinitions.getDatabasePoolingRetryCount().getIntegerFor(this);
    }

    public Integer getDatabaseRowLockFailureRetryCount()
    {
       return MyPropertyDefinitions.getDatabaseRowLockFailureRetryCount().getIntegerFor(this);
    }

    public Integer getDatabaseRowLockFailureRetryMs()
    {
       return MyPropertyDefinitions.getDatabaseRowLockFailureRetryMs().getIntegerFor(this);
    }

    //##################################################
    //# jobs
    //##################################################

    public Integer getCsvUploadProcessorJobActiveSeconds()
    {
       return MyPropertyDefinitions.getCsvUploadProcessorJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getCsvUploadProcessorJobEnabled()
    {
       return MyPropertyDefinitions.getCsvUploadProcessorJobEnabled().getBooleanFor(this);
    }

    public Integer getCsvUploadProcessorJobIdleSeconds()
    {
       return MyPropertyDefinitions.getCsvUploadProcessorJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getDataProcessorJobActiveSeconds()
    {
       return MyPropertyDefinitions.getDataProcessorJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getDataProcessorJobEnabled()
    {
       return MyPropertyDefinitions.getDataProcessorJobEnabled().getBooleanFor(this);
    }

    public Integer getDataProcessorJobIdleSeconds()
    {
       return MyPropertyDefinitions.getDataProcessorJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getDeleteOldPerformanceLogsJobActiveSeconds()
    {
       return MyPropertyDefinitions.getDeleteOldPerformanceLogsJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getDeleteOldPerformanceLogsJobEnabled()
    {
       return MyPropertyDefinitions.getDeleteOldPerformanceLogsJobEnabled().getBooleanFor(this);
    }

    public Integer getDeleteOldPerformanceLogsJobIdleSeconds()
    {
       return MyPropertyDefinitions.getDeleteOldPerformanceLogsJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getDeleteOldServerSessionsJobActiveSeconds()
    {
       return MyPropertyDefinitions.getDeleteOldServerSessionsJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getDeleteOldServerSessionsJobEnabled()
    {
       return MyPropertyDefinitions.getDeleteOldServerSessionsJobEnabled().getBooleanFor(this);
    }

    public Integer getDeleteOldServerSessionsJobIdleSeconds()
    {
       return MyPropertyDefinitions.getDeleteOldServerSessionsJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getDeleteOldSystemLogsJobActiveSeconds()
    {
       return MyPropertyDefinitions.getDeleteOldSystemLogsJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getDeleteOldSystemLogsJobEnabled()
    {
       return MyPropertyDefinitions.getDeleteOldSystemLogsJobEnabled().getBooleanFor(this);
    }

    public Integer getDeleteOldSystemLogsJobIdleSeconds()
    {
       return MyPropertyDefinitions.getDeleteOldSystemLogsJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getFtpSendToNotifierJobActiveSeconds()
    {
       return MyPropertyDefinitions.getFtpSendToNotifierJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getFtpSendToNotifierJobEnabled()
    {
       return MyPropertyDefinitions.getFtpSendToNotifierJobEnabled().getBooleanFor(this);
    }

    public Integer getFtpSendToNotifierJobIdleSeconds()
    {
       return MyPropertyDefinitions.getFtpSendToNotifierJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getLog4jReloaderJobActiveSeconds()
    {
       return MyPropertyDefinitions.getLog4jReloaderJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getLog4jReloaderJobEnabled()
    {
       return MyPropertyDefinitions.getLog4jReloaderJobEnabled().getBooleanFor(this);
    }

    public Integer getLog4jReloaderJobIdleSeconds()
    {
       return MyPropertyDefinitions.getLog4jReloaderJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getMonitorJobActiveSeconds()
    {
       return MyPropertyDefinitions.getMonitorJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getMonitorJobEnabled()
    {
       return MyPropertyDefinitions.getMonitorJobEnabled().getBooleanFor(this);
    }

    public Integer getMonitorJobIdleSeconds()
    {
       return MyPropertyDefinitions.getMonitorJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getOverridesReloaderJobActiveSeconds()
    {
       return MyPropertyDefinitions.getOverridesReloaderJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getOverridesReloaderJobEnabled()
    {
       return MyPropertyDefinitions.getOverridesReloaderJobEnabled().getBooleanFor(this);
    }

    public Integer getOverridesReloaderJobIdleSeconds()
    {
       return MyPropertyDefinitions.getOverridesReloaderJobIdleSeconds().getIntegerFor(this);
    }

    public Integer getPerformanceLogJobActiveSeconds()
    {
       return MyPropertyDefinitions.getPerformanceLogJobActiveSeconds().getIntegerFor(this);
    }

    public Boolean getPerformanceLogJobEnabled()
    {
       return MyPropertyDefinitions.getPerformanceLogJobEnabled().getBooleanFor(this);
    }

    public Integer getPerformanceLogJobIdleSeconds()
    {
       return MyPropertyDefinitions.getPerformanceLogJobIdleSeconds().getIntegerFor(this);
    }

    //##################################################
    //# miscellaneous
    //##################################################

    public Boolean getAjaxLogDeleteOnStart()
    {
       return MyPropertyDefinitions.getAjaxLogDeleteOnStart().getBooleanFor(this);
    }

    public Boolean getAjaxLogEnabled()
    {
       return MyPropertyDefinitions.getAjaxLogEnabled().getBooleanFor(this);
    }

    public Boolean getCheckRecommendedBrowser()
    {
       return MyPropertyDefinitions.getCheckRecommendedBrowser().getBooleanFor(this);
    }

    public String getDefaultTimeZoneCode()
    {
       return MyPropertyDefinitions.getDefaultTimeZoneCode().getStringFor(this);
    }

    public Integer getFileUploadRefreshMs()
    {
       return MyPropertyDefinitions.getFileUploadRefreshMs().getIntegerFor(this);
    }

    public Boolean getFtpEnabled()
    {
       return MyPropertyDefinitions.getFtpEnabled().getBooleanFor(this);
    }

    public Integer getMaintenancePeriodEndHour()
    {
       return MyPropertyDefinitions.getMaintenancePeriodEndHour().getIntegerFor(this);
    }

    public Integer getMaintenancePeriodStartHour()
    {
       return MyPropertyDefinitions.getMaintenancePeriodStartHour().getIntegerFor(this);
    }

    public Boolean getMemoryLeakLoopEnabled()
    {
       return MyPropertyDefinitions.getMemoryLeakLoopEnabled().getBooleanFor(this);
    }

    public Integer getMemoryLeakLoopSpeedMs()
    {
       return MyPropertyDefinitions.getMemoryLeakLoopSpeedMs().getIntegerFor(this);
    }

    public Boolean getShowHibernateSql()
    {
       return MyPropertyDefinitions.getShowHibernateSql().getBooleanFor(this);
    }

    public Boolean getSynchronizeServletsBySession()
    {
       return MyPropertyDefinitions.getSynchronizeServletsBySession().getBooleanFor(this);
    }

    public String getWebResourceVersioning()
    {
       return MyPropertyDefinitions.getWebResourceVersioning().getStringFor(this);
    }

    //##################################################
    //# googleChart
    //##################################################

    public String getGoogleChartHost()
    {
       return MyPropertyDefinitions.getGoogleChartHost().getStringFor(this);
    }

    public String getGoogleChartPath()
    {
       return MyPropertyDefinitions.getGoogleChartPath().getStringFor(this);
    }

    public Integer getGoogleChartPort()
    {
       return MyPropertyDefinitions.getGoogleChartPort().getIntegerFor(this);
    }

    public String getGoogleChartScheme()
    {
       return MyPropertyDefinitions.getGoogleChartScheme().getStringFor(this);
    }

    //##################################################
    //# bootstrap
    //##################################################

    public String getRootUserEmail()
    {
       return MyPropertyDefinitions.getRootUserEmail().getStringFor(this);
    }

}

