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
    //# labels
    //##################################################

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
    //# full name
    //##################################################

    public String getDomainFieldName()
    {
        return getDomainName() + "." + getFieldName();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getDomainFieldName();
    }

    @Override
    public String getDomainTitle()
    {
        return getDomainFieldName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return Kmu.format("%s, %s", formatUserName(), getCreatedLocalTs().formatLocal());
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
            formatUserName(),
            getDomainType(),
            getDomainName(),
            getFieldName(),
            formatLongNewValue());
    }

    private String formatUpdateMessage()
    {
        return Kmu.format(
            "%s updated %s %s; changed %s from [%s] to [%s].",
            formatUserName(),
            getDomainType(),
            getDomainName(),
            getFieldName(),
            getOldValue(),
            formatLongNewValue());
    }

    private String formatDeleteMessage()
    {
        return Kmu.format(
            "%s deleted %s %s; %s was [%s].",
            formatUserName(),
            getDomainType(),
            getDomainName(),
            getFieldName(),
            getOldValue());
    }

    public String formatUserName()
    {
        return hasUser()
            ? getUserName()
            : MyUser.SYSTEM_NAME;
    }

    public String formatLongNewValue()
    {
        return hasStringValue()
            ? getStringValue()
            : getNewValue();
    }

    //##################################################
    //# support
    //##################################################

}
