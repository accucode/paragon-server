package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;

public class MyMacroFetcher
{
    //##################################################
    //# variables
    //##################################################

    private MyMacroContextType _contextType;

    private MyProject _project;

    //##################################################
    //# accessing
    //##################################################

    public MyMacroContextType getContextType()
    {
        return _contextType;
    }

    public void setContextType(MyMacroContextType e)
    {
        _contextType = e;
    }

    public MyProject getProject()
    {
        return _project;
    }

    public void setProject(MyProject e)
    {
        _project = e;
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    //##################################################
    //# macros
    //##################################################

    public KmList<MyMacro> findAll()
    {
        KmList<MyMacro> v;
        v = new KmList<>();
        v.addAll(MyMacros.getGlobalMacros());
        v.addAll(MyMacros.getUserMacros());
        collectAllOn(v);
        v.sort(MyMacro::getKey);
        return v;
    }

    private void collectAllOn(KmList<MyMacro> v)
    {
        MyMacroContextType type = getContextType();
        if ( type == null )
            return;

        switch ( type )
        {
            case Attachment:
                collectAttachmentMacrosOn(v);
                return;

            case Project:
                collectProjectMacrosOn(v);
                return;

            case Tenant:
                collectTenantMacrosOn(v);
                return;

            case Site:
                collectSiteMacrosOn(v);
                return;
        }
        throw Kmu.newEnumError(type);
    }

    private void collectAttachmentMacrosOn(KmList<MyMacro> v)
    {
        v.addAll(MyMacros.getAttachmentMacros());
        v.addAll(MyMacros.getCustomerMacros());
        v.addAll(MyMacros.getProjectMacros());
    }

    private void collectProjectMacrosOn(KmList<MyMacro> v)
    {
        v.addAll(MyMacros.getProjectMacros());
    }

    private void collectTenantMacrosOn(KmList<MyMacro> v)
    {
        v.addAll(MyMacros.getTenantMacros());
    }

    private void collectSiteMacrosOn(KmList<MyMacro> v)
    {
        v.addAll(MyMacros.getProjectMacros());
        v.addAll(MyMacros.getCustomerMacros());
        v.addAll(MyMacros.getSiteMacros());
    }

    //==================================================
    //= macros :: domain types
    //==================================================

    public KmList<MyMacroDomainType> getDomainTypesFor(MyMacroCategoryType category)
    {
        if ( category == null )
            return KmList.createEmpty();

        switch ( category )
        {
            case Current:
                return getDomainTypesFor();

            case Global:
                return getGlobalDomainTypes();
        }

        return KmList.createEmpty();
    }

    public KmList<MyMacroDomainType> getGlobalDomainTypes()
    {
        KmList<MyMacroDomainType> v;
        v = new KmList<>();
        v.add(MyMacroDomainType.Global);
        v.add(MyMacroDomainType.CurrentUser);
        return v;
    }

    public KmList<MyMacroDomainType> getDomainTypesFor()
    {
        MyMacroContextType type = getContextType();
        if ( type == null )
            return KmList.createEmpty();

        KmList<MyMacroDomainType> v = new KmList<>();

        switch ( type )
        {
            case Attachment:
                collectAttachmentDomainTypesOn(v);
                break;

            case Project:
                collectProjectDomainTypesOn(v);
                break;

            case Tenant:
                collectTenantDomainTypesOn(v);
                break;

            case Site:
                collectSiteDomainTypesOn(v);
                break;
        }

        v.sort(e -> e.getCode());
        return v;
    }

    private void collectAttachmentDomainTypesOn(KmList<MyMacroDomainType> v)
    {
        v.add(MyMacroDomainType.Attachment);
        v.add(MyMacroDomainType.Customer);
        v.add(MyMacroDomainType.Project);
    }

    private void collectProjectDomainTypesOn(KmList<MyMacroDomainType> v)
    {
        v.add(MyMacroDomainType.Project);
    }

    private void collectTenantDomainTypesOn(KmList<MyMacroDomainType> v)
    {
        v.add(MyMacroDomainType.Tenant);
    }

    private void collectSiteDomainTypesOn(KmList<MyMacroDomainType> v)
    {
        v.add(MyMacroDomainType.Site);
        v.add(MyMacroDomainType.Customer);
        v.add(MyMacroDomainType.Project);
    }
}
