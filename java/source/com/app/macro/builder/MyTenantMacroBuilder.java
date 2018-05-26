package com.app.macro.builder;

import com.app.macro.MyMacroDomainType;
import com.app.model.MyTenant;
import com.app.model.meta.MyMetaTenant;

/**
 * I build the macros for a specific domain type.
 */
public class MyTenantMacroBuilder
    extends MyAbstractMacroBuilder
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyMacroDomainType getDomainType()
    {
        return MyMacroDomainType.Tenant;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void addAll()
    {
        MyMetaTenant x = MyTenant.Meta;

        addText("Name", "Acme Inc.", x.Name);
    }

}
