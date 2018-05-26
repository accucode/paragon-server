package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyAuditBundleBase;
import com.app.model.base.MyAuditBundleChangeType;
import com.app.model.core.MySystemDomainIF;

public class MyAuditBundle
    extends MyAuditBundleBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditBundle()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    protected void updateUserName()
    {
        if ( hasUser() )
            setUserName(getUser().getFullName());
        else
            clearUserName();
    }

    @Override
    public String getDomainTypeLabel()
    {
        return Kmu.formatAsCapitalizedNames(getDomainType());
    }

    //##################################################
    //# message
    //##################################################

    public String getMessage()
    {
        MyAuditBundleChangeType type = getChangeType();

        if ( type == null )
            return "No Type.";

        switch ( type )
        {
            case Add:
                return formatAddMessage();

            case Update:
                return formatUpdateMessage();

            case Delete:
                return formatDeleteMessage();
        }

        return "Unknown Audit Type.";
    }

    private String formatAddMessage()
    {
        return Kmu.format("%s added %s %s.", formatUserName(), getDomainType(), getDomainName());
    }

    private String formatUpdateMessage()
    {
        return Kmu.format("%s updated %s %s", formatUserName(), getDomainType(), getDomainName());
    }

    private String formatDeleteMessage()
    {
        return Kmu.format("%s deleted %s %s.", formatUserName(), getDomainType(), getDomainName());
    }

    public String formatUserName()
    {
        return hasUser()
            ? getUserName()
            : MyUser.SYSTEM_NAME;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getDomainName();
    }

    @Override
    public String getDomainTitle()
    {
        return getDomainName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return Kmu.format("%s, %s", formatUserName(), getCreatedLocalTs().formatLocal());
    }
}
