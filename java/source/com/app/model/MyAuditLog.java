package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyAuditLogBase;

public class MyAuditLog
    extends MyAuditLogBase
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
            setUserName(getUser().getName());
        else
            clearUserName();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getModelName() + "." + getFieldName();
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
            getModelType(),
            getModelName(),
            getFieldName(),
            getNewValue());
    }

    private String formatUpdateMessage()
    {
        return Kmu.format(
            "%s updated %s %s; changed %s from [%s] to [%s].",
            formatMessageUserName(),
            getModelType(),
            getModelName(),
            getFieldName(),
            getOldValue(),
            getNewValue());
    }

    private String formatDeleteMessage()
    {
        return Kmu.format(
            "%s deleted %s %s; %s was [%s].",
            formatMessageUserName(),
            getModelType(),
            getModelName(),
            getFieldName(),
            getOldValue());
    }

    private String formatMessageUserName()
    {
        return hasUser()
            ? getUserName()
            : "System";
    }
}
