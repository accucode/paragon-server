package com.app.macro.builder;

import com.app.macro.MyMacroDomainType;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaProject;

/**
 * I build the macros for a specific domain type.
 */
public class MyProjectMacroBuilder
    extends MyAbstractMacroBuilder
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyMacroDomainType getDomainType()
    {
        return MyMacroDomainType.Project;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void addAll()
    {
        addName();
        addSupportContact();
    }

    private void addName()
    {
        MyMetaProject x = MyProject.Meta;

        addText("Name", "Example Project", x.Name);
        addText("CompanyName", "Example Inc.", x.CompanyName);
    }

    private void addSupportContact()
    {
        MyMetaProject x = MyProject.Meta;

        String assoc = "SupportContact";
        addText(assoc, "Email", "support@example.net", x.SupportContactEmail);
        addText(assoc, "Phone", "303.555.1234", x.SupportContactPhone);
    }
}
