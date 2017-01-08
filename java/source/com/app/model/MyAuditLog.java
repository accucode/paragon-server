package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyAuditLogBase;
import com.app.model.base.MyAuditLogType;
import com.app.model.core.MySystemDomainIF;

public class MyAuditLog
    extends MyAuditLogBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditLog()
    {
        super();
    }

    //##################################################
    //# on change
    //##################################################

    @Override
    protected void updateUserName()
    {
        if ( hasUser() )
            setUserName(getUser().getFullName());
        else
            clearUserName();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getDomainName() + "." + getFieldName();
    }

    @Override
    public String getDomainTypeLabel()
    {
        return Kmu.formatAsCapitalizedNames(getDomainType());
    }

    @Override
    public String getFieldNameLabel()
    {
        return Kmu.formatAsCapitalizedNames(getFieldName());
    }

    //##################################################
    //# message
    //##################################################

    public String formatMessage()
    {
        MyAuditLogType type = getType();

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
        return Kmu.format(
            "%s added %s %s; set %s = [%s].",
            formatMessageUserName(),
            getDomainType(),
            getDomainName(),
            getFieldName(),
            getNewValue());
    }

    private String formatUpdateMessage()
    {
        return Kmu.format(
            "%s updated %s %s; changed %s from [%s] to [%s].",
            formatMessageUserName(),
            getDomainType(),
            getDomainName(),
            getFieldName(),
            getOldValue(),
            getNewValue());
    }

    private String formatDeleteMessage()
    {
        return Kmu.format(
            "%s deleted %s %s; %s was [%s].",
            formatMessageUserName(),
            getDomainType(),
            getDomainName(),
            getFieldName(),
            getOldValue());
    }

    public String formatMessageUserName()
    {
        return hasUser()
            ? getUserName()
            : MyUser.SYSTEM_NAME;
    }
}
