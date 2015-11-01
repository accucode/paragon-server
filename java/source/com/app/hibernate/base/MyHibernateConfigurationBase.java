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
        installMapping("autoSignIn");
        installMapping("depot");
        installMapping("download");
        installMapping("email");
        installMapping("emailPart");
        installMapping("emailRecipient");
        installMapping("fieldTest");
        installMapping("file");
        installMapping("hibernateCacheTest");
        installMapping("invitation");
        installMapping("member");
        installMapping("memberSkill");
        installMapping("passwordReset");
        installMapping("patch");
        installMapping("performanceLogDetail");
        installMapping("performanceLogSummary");
        installMapping("project");
        installMapping("region");
        installMapping("serverSession");
        installMapping("settings");
        installMapping("skill");
        installMapping("threadTopic");
        installMapping("user");
        installMapping("userActivation");
        installMapping("vendor");
    }

    protected abstract void installMapping(String clazz);
}
