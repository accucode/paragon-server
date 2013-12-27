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
    protected void addMappings()
    {
        addMapping("account");
        addMapping("accountUser");
        addMapping("autoSignIn");
        addMapping("download");
        addMapping("email");
        addMapping("emailPart");
        addMapping("emailRecipient");
        addMapping("file");
        addMapping("hibernateCacheTest");
        addMapping("invitation");
        addMapping("passwordReset");
        addMapping("patch");
        addMapping("performanceLog");
        addMapping("serverSession");
        addMapping("settings");
        addMapping("systemLog");
        addMapping("systemLogTrace");
        addMapping("user");
        addMapping("userActivation");
    }

}
