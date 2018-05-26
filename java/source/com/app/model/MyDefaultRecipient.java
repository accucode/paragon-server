package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyDefaultRecipientBase;
import com.app.model.base.MyDefaultRecipientContactType;
import com.app.model.core.MyProjectDomainIF;

public class MyDefaultRecipient
    extends MyDefaultRecipientBase
    implements MyProjectDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDefaultRecipient()
    {
        super();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    @Override
    public MyProject getProject()
    {
        return getEmailTemplate().getProject();
    }

    //##################################################
    //# format
    //##################################################

    public String formatEmail()
    {
        MyDefaultRecipientContactType type = getContactType();
        switch ( type )
        {
            case Custom:
                return getCustomEmail();

            case CustomerApproval:
            case CustomerBilling:
            case CustomerNotifications:
            case Install:
            case Main:
            case JobNotifications:
            case ProjectNotifications:
            case ProjectSupport:
            case Requester:
            case Sales:
            case Scheduling:
            case Technical:
                return Kmu.formatMetaValue(type.getLabel());
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return formatTypeAndEmail();
    }

    @Override
    public String getDomainTitle()
    {
        return formatTypeAndEmail();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }

    //##################################################
    //# support
    //##################################################

    private String formatTypeAndEmail()
    {
        return Kmu.format("%s %s", getTypeName(), formatEmail());
    }

}
