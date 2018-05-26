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
import com.kodemore.time.*;
import com.kodemore.utility.*;

import com.app.model.*;

public class MyPropertiesBase
    extends KmPropertyRegistry
{
    //##################################################
    //# bootstrap
    //##################################################

    public String getBootstrapSystemHostname()
    {
       return MyPropertyDefinitions.getBootstrapSystemHostname().getStringFor(this);
    }

    //##################################################
    //# chores
    //##################################################

    public Integer getApplicationLogFlusherChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getApplicationLogFlusherChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getApplicationLogFlusherChoreEnabled()
    {
       return MyPropertyDefinitions.getApplicationLogFlusherChoreEnabled().getBooleanFor(this);
    }

    public Integer getApplicationLogFlusherChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getApplicationLogFlusherChoreIdleSeconds().getIntegerFor(this);
    }

    public Integer getClearThemeCacheChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getClearThemeCacheChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getClearThemeCacheChoreEnabled()
    {
       return MyPropertyDefinitions.getClearThemeCacheChoreEnabled().getBooleanFor(this);
    }

    public Integer getClearThemeCacheChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getClearThemeCacheChoreIdleSeconds().getIntegerFor(this);
    }

    public Integer getLog4jReloaderChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getLog4jReloaderChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getLog4jReloaderChoreEnabled()
    {
       return MyPropertyDefinitions.getLog4jReloaderChoreEnabled().getBooleanFor(this);
    }

    public Integer getLog4jReloaderChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getLog4jReloaderChoreIdleSeconds().getIntegerFor(this);
    }

    public Integer getMaintenanceChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getMaintenanceChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getMaintenanceChoreEnabled()
    {
       return MyPropertyDefinitions.getMaintenanceChoreEnabled().getBooleanFor(this);
    }

    public Integer getMaintenanceChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getMaintenanceChoreIdleSeconds().getIntegerFor(this);
    }

    public Integer getMonitorChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getMonitorChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getMonitorChoreEnabled()
    {
       return MyPropertyDefinitions.getMonitorChoreEnabled().getBooleanFor(this);
    }

    public Integer getMonitorChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getMonitorChoreIdleSeconds().getIntegerFor(this);
    }

    public Integer getOverridesReloaderChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getOverridesReloaderChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getOverridesReloaderChoreEnabled()
    {
       return MyPropertyDefinitions.getOverridesReloaderChoreEnabled().getBooleanFor(this);
    }

    public Integer getOverridesReloaderChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getOverridesReloaderChoreIdleSeconds().getIntegerFor(this);
    }

    public Integer getPerformanceLogFlusherChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getPerformanceLogFlusherChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getPerformanceLogFlusherChoreEnabled()
    {
       return MyPropertyDefinitions.getPerformanceLogFlusherChoreEnabled().getBooleanFor(this);
    }

    public Integer getPerformanceLogFlusherChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getPerformanceLogFlusherChoreIdleSeconds().getIntegerFor(this);
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
    //# databasePatch
    //##################################################

    public Boolean getDatabaseSyncOnStartup()
    {
       return MyPropertyDefinitions.getDatabaseSyncOnStartup().getBooleanFor(this);
    }

    //##################################################
    //# debug
    //##################################################

    public Boolean getAjaxLogDeleteOnStart()
    {
       return MyPropertyDefinitions.getAjaxLogDeleteOnStart().getBooleanFor(this);
    }

    public Boolean getAjaxLogEnabled()
    {
       return MyPropertyDefinitions.getAjaxLogEnabled().getBooleanFor(this);
    }

    public String getAutoLoginEmail()
    {
       return MyPropertyDefinitions.getAutoLoginEmail().getStringFor(this);
    }

    public Boolean getContextFormatterEnabled()
    {
       return MyPropertyDefinitions.getContextFormatterEnabled().getBooleanFor(this);
    }

    public Integer getContextFormatterLines()
    {
       return MyPropertyDefinitions.getContextFormatterLines().getIntegerFor(this);
    }

    public Boolean getDeleteThreadTopicsOnStart()
    {
       return MyPropertyDefinitions.getDeleteThreadTopicsOnStart().getBooleanFor(this);
    }

    public Boolean getPrintAjaxTime()
    {
       return MyPropertyDefinitions.getPrintAjaxTime().getBooleanFor(this);
    }

    public Boolean getPrintAuditLog()
    {
       return MyPropertyDefinitions.getPrintAuditLog().getBooleanFor(this);
    }

    public Boolean getPrintPerformanceLog()
    {
       return MyPropertyDefinitions.getPrintPerformanceLog().getBooleanFor(this);
    }

    public Boolean getRenderDebugDomComments()
    {
       return MyPropertyDefinitions.getRenderDebugDomComments().getBooleanFor(this);
    }

    public Boolean getShowHibernateSql()
    {
       return MyPropertyDefinitions.getShowHibernateSql().getBooleanFor(this);
    }

    //##################################################
    //# emailChore
    //##################################################

    public Integer getSendEmailBatch()
    {
       return MyPropertyDefinitions.getSendEmailBatch().getIntegerFor(this);
    }

    public Integer getSendEmailChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getSendEmailChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getSendEmailChoreEnabled()
    {
       return MyPropertyDefinitions.getSendEmailChoreEnabled().getBooleanFor(this);
    }

    public Integer getSendEmailChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getSendEmailChoreIdleSeconds().getIntegerFor(this);
    }

    public Boolean getSendEmailEnabled()
    {
       return MyPropertyDefinitions.getSendEmailEnabled().getBooleanFor(this);
    }

    //##################################################
    //# emailGoogleMail
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

    //##################################################
    //# emailMethod
    //##################################################

    public String getSendEmailFromAddress()
    {
       return MyPropertyDefinitions.getSendEmailFromAddress().getStringFor(this);
    }

    public String getSendEmailMethod()
    {
       return MyPropertyDefinitions.getSendEmailMethod().getStringFor(this);
    }

    public String getSendEmailOverrideTo()
    {
       return MyPropertyDefinitions.getSendEmailOverrideTo().getStringFor(this);
    }

    //##################################################
    //# emailSmtp
    //##################################################

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

    public Boolean getSmtpUseSsl()
    {
       return MyPropertyDefinitions.getSmtpUseSsl().getBooleanFor(this);
    }

    public String getSmtpUser()
    {
       return MyPropertyDefinitions.getSmtpUser().getStringFor(this);
    }

    //##################################################
    //# ftp
    //##################################################

    public Boolean getFtpEnabled()
    {
       return MyPropertyDefinitions.getFtpEnabled().getBooleanFor(this);
    }

    public Integer getFtpSendToNotifierChoreActiveSeconds()
    {
       return MyPropertyDefinitions.getFtpSendToNotifierChoreActiveSeconds().getIntegerFor(this);
    }

    public Boolean getFtpSendToNotifierChoreEnabled()
    {
       return MyPropertyDefinitions.getFtpSendToNotifierChoreEnabled().getBooleanFor(this);
    }

    public Integer getFtpSendToNotifierChoreIdleSeconds()
    {
       return MyPropertyDefinitions.getFtpSendToNotifierChoreIdleSeconds().getIntegerFor(this);
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
    //# googleMaps
    //##################################################

    public String getGoogleMapsApiKey()
    {
       return MyPropertyDefinitions.getGoogleMapsApiKey().getStringFor(this);
    }

    //##################################################
    //# hibernateSecondLevelCache
    //##################################################

    public String getHibernateCacheProvider()
    {
       return MyPropertyDefinitions.getHibernateCacheProvider().getStringFor(this);
    }

    public Integer getHibernateCacheTimeSeconds()
    {
       return MyPropertyDefinitions.getHibernateCacheTimeSeconds().getIntegerFor(this);
    }

    public String getHibernateMemcachedServers()
    {
       return MyPropertyDefinitions.getHibernateMemcachedServers().getStringFor(this);
    }

    public Boolean getHibernateUseSecondLevelCache()
    {
       return MyPropertyDefinitions.getHibernateUseSecondLevelCache().getBooleanFor(this);
    }

    //##################################################
    //# maintenance
    //##################################################

    public Integer getMaintenancePeriodEndHour()
    {
       return MyPropertyDefinitions.getMaintenancePeriodEndHour().getIntegerFor(this);
    }

    public Integer getMaintenancePeriodStartHour()
    {
       return MyPropertyDefinitions.getMaintenancePeriodStartHour().getIntegerFor(this);
    }

    //##################################################
    //# monitoring
    //##################################################

    public Boolean getChorePerformanceLogEnabled()
    {
       return MyPropertyDefinitions.getChorePerformanceLogEnabled().getBooleanFor(this);
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
    //# oneAll
    //##################################################

    public Boolean getOneAllEnabled()
    {
       return MyPropertyDefinitions.getOneAllEnabled().getBooleanFor(this);
    }

    public String getOneAllHost()
    {
       return MyPropertyDefinitions.getOneAllHost().getStringFor(this);
    }

    public String getOneAllPrivateKey()
    {
       return MyPropertyDefinitions.getOneAllPrivateKey().getStringFor(this);
    }

    public String getOneAllPublicKey()
    {
       return MyPropertyDefinitions.getOneAllPublicKey().getStringFor(this);
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
    //# production
    //##################################################

    public String getDeveloperEmailCsv()
    {
       return MyPropertyDefinitions.getDeveloperEmailCsv().getStringFor(this);
    }

    public String getEnvironment()
    {
       return MyPropertyDefinitions.getEnvironment().getStringFor(this);
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
    //# servlet
    //##################################################

    public Boolean getServletSslRedirect()
    {
       return MyPropertyDefinitions.getServletSslRedirect().getBooleanFor(this);
    }

    public String getWebResourceVersioning()
    {
       return MyPropertyDefinitions.getWebResourceVersioning().getStringFor(this);
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
    //# urls
    //##################################################

    public String getMarketingUrl()
    {
       return MyPropertyDefinitions.getMarketingUrl().getStringFor(this);
    }

    public String getSupportUrl()
    {
       return MyPropertyDefinitions.getSupportUrl().getStringFor(this);
    }

}

