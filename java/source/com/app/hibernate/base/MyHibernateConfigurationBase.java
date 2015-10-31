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
        installMapping("attentionGroup");
        installMapping("auditLog");
        installMapping("autoSignIn");
        installMapping("customer");
        installMapping("customerContact");
        installMapping("customerSite");
        installMapping("customerTier");
        installMapping("depot");
        installMapping("download");
        installMapping("email");
        installMapping("emailPart");
        installMapping("emailRecipient");
        installMapping("endUser");
        installMapping("endUserSite");
        installMapping("fieldTest");
        installMapping("file");
        installMapping("hibernateCacheTest");
        installMapping("invitation");
        installMapping("masterProduct");
        installMapping("member");
        installMapping("memberSkill");
        installMapping("passwordReset");
        installMapping("patch");
        installMapping("performanceLogDetail");
        installMapping("performanceLogSummary");
        installMapping("powerType");
        installMapping("product");
        installMapping("productCategory");
        installMapping("project");
        installMapping("region");
        installMapping("serverSession");
        installMapping("settings");
        installMapping("shipAccount");
        installMapping("shipCarrier");
        installMapping("shipMethod");
        installMapping("skill");
        installMapping("threadTopic");
        installMapping("user");
        installMapping("userActivation");
        installMapping("vendor");
        installMapping("visitType");
    }

    protected abstract void installMapping(String clazz);
}
