//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.hibernate.base;

public abstract class MyHibernateConfigurationBase
{
    protected void installMappings()
    {
        installMapping("applicationLog");
        installMapping("auditLog");
        installMapping("autoLogin");
        installMapping("download");
        installMapping("email");
        installMapping("emailPart");
        installMapping("emailRecipient");
        installMapping("fieldTest");
        installMapping("file");
        installMapping("hibernateCacheTest");
        installMapping("invitation");
        installMapping("optimisticLock");
        installMapping("passwordReset");
        installMapping("patch");
        installMapping("performanceLogDetail");
        installMapping("performanceLogSummary");
        installMapping("project");
        installMapping("serverSession");
        installMapping("settings");
        installMapping("tenant");
        installMapping("threadTopic");
        installMapping("user");
        installMapping("userActivation");
    }

    protected abstract void installMapping(String clazz);
}
