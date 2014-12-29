//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.hibernate.base;

import com.app.dao.core.*;

public abstract class MyHibernateConfigurationBase
    extends MyAbstractHibernateConfiguration
{
    //##################################################
    //# private
    //##################################################

    @Override
    protected void addCustomMappings()
    {
        addMapping("applicationLog");
        addMapping("applicationLogTrace");
        addMapping("autoSignIn");
        addMapping("category");
        addMapping("depot");
        addMapping("download");
        addMapping("email");
        addMapping("emailPart");
        addMapping("emailRecipient");
        addMapping("file");
        addMapping("hibernateCacheTest");
        addMapping("invitation");
        addMapping("member");
        addMapping("memberSkill");
        addMapping("passwordReset");
        addMapping("patch");
        addMapping("performanceLog");
        addMapping("powerType");
        addMapping("product");
        addMapping("project");
        addMapping("region");
        addMapping("serverSession");
        addMapping("settings");
        addMapping("shipCarrier");
        addMapping("shipMethod");
        addMapping("skill");
        addMapping("user");
        addMapping("userActivation");
        addMapping("vendor");
        addMapping("visitType");
    }

}
