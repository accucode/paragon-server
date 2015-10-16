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
            return "No Audit Type.";

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
            "AUDIT... %s added %s.%s; %s.",
            formatMessageUserName(),
            getModelName(),
            getFieldName(),
            getNewValue());
    }

    private String formatUpdateMessage()
    {
        return Kmu.format(
            "AUDIT... %s updated %s.%s; %s => %s.",
            formatMessageUserName(),
            getModelName(),
            getFieldName(),
            getOldValue(),
            getNewValue());
    }

    private String formatDeleteMessage()
    {
        return Kmu.format(
            "AUDIT... %s deleted %s.%s; %s.",
            formatMessageUserName(),
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
