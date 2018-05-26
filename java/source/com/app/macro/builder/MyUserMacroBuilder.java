package com.app.macro.builder;

import com.app.macro.MyMacroDomainType;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;

/**
 * I build the macros for a specific domain type.
 */
public class MyUserMacroBuilder
    extends MyAbstractMacroBuilder
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyMacroDomainType getDomainType()
    {
        return MyMacroDomainType.CurrentUser;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void addAll()
    {
        MyMetaUser x = MyUser.Meta;

        addText("ShortName", "John", x.ShortName);
        addText("FullName", "John Doe", x.FullName);
        addText("FormatName", "Doe, John", x.FormalName);
        addText("Email", "jdoe@company.com", x.Email);
    }
}
