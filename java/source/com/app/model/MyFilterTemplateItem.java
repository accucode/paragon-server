package com.app.model;

import com.app.model.base.MyFilterTemplateItemBase;
import com.app.model.core.MyProjectDomainIF;

public class MyFilterTemplateItem
    extends MyFilterTemplateItemBase
    implements MyProjectDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplateItem()
    {
        super();
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    @Override
    public MyProject getProject()
    {
        return getTemplate().getProject();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getTemplate().getContextTypeName() + ", " + getAttributeCode();
    }

    @Override
    public String getDomainTitle()
    {
        return getTemplate().getContextTypeName() + ", " + getAttributeCode();
    }

    @Override
    public String getDomainSubtitle()
    {
        return getTemplate().getName();
    }

    //##################################################
    //# value
    //##################################################

    public void resetValue()
    {
        setUsed(false);
        clearValue();
    }
}
