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
        installMapping("attachment");
        installMapping("auditBundle");
        installMapping("auditLog");
        installMapping("autoLogin");
        installMapping("blurb");
        installMapping("choice");
        installMapping("customer");
        installMapping("customerContact");
        installMapping("defaultRecipient");
        installMapping("download");
        installMapping("email");
        installMapping("emailPart");
        installMapping("emailRecipient");
        installMapping("emailTemplate");
        installMapping("feedback");
        installMapping("fieldTest");
        installMapping("filterTemplate");
        installMapping("filterTemplateItem");
        installMapping("hibernateCacheTest");
        installMapping("holiday");
        installMapping("member");
        installMapping("note");
        installMapping("optimisticLock");
        installMapping("passwordReset");
        installMapping("patch");
        installMapping("performanceLogDetail");
        installMapping("performanceLogSummary");
        installMapping("priority");
        installMapping("project");
        installMapping("projectContact");
        installMapping("serverSession");
        installMapping("settings");
        installMapping("site");
        installMapping("siteContact");
        installMapping("tenant");
        installMapping("threadTopic");
        installMapping("user");
        installMapping("userActivation");
        installMapping("userRecentProject");
        installMapping("vendor");
    }

    protected abstract void installMapping(String clazz);
}
