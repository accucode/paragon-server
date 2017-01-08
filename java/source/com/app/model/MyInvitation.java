package com.app.model;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyInvitationBase;
import com.app.model.base.MyInvitationType;
import com.app.model.core.MySystemDomainIF;
import com.app.utility.MyUrls;

// todo_wyatt: review, move to tenant or project?
public class MyInvitation
    extends MyInvitationBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyInvitation()
    {
        super();

        setStatusPending();
    }

    //##################################################
    //# url
    //##################################################

    public String getEntryUrl()
    {
        MyInvitationType type = getType();
        switch ( type )
        {
            case JoinAccount:
                return MyUrls.getEntryUrl();
        }
        return null;
    }

    //##################################################
    //# email
    //##################################################

    /**
     * Send an email to the invitations recipient.
     */
    public void sendEmail()
    {
        MyEmail e;
        e = new MyEmail();
        e.setFromAddress(getDoNoReplyEmail());
        e.addToRecipient(getToEmail());
        e.setSubject(formatSubject());
        e.addHtmlPart(formatHtmlMessage());
        e.setStatusReady();
        e.daoAttach();
    }

    //##################################################
    //# format subject
    //##################################################

    public String formatSubject()
    {
        MyInvitationType type = getType();
        switch ( type )
        {
            case JoinAccount:
                return formatJoinSubject();
        }

        return "Unknown Invitation Type";
    }

    private String formatJoinSubject()
    {
        return Kmu.format("Invitation to join %s", formatProjectName());
    }

    //##################################################
    //# format message
    //##################################################

    private String formatHtmlMessage()
    {
        MyInvitationType type = getType();
        switch ( type )
        {
            case JoinAccount:
                return formatJoinAccountMessage().toString();
        }

        return formatUnknownTypeMessage().toString();
    }

    private KmHtmlBuilder formatJoinAccountMessage()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printf(
            "You have been invited to the %s project by %s.",
            formatProjectName(),
            formatSenderName());

        out.print(" To review the invitation please click ");
        out.printLink("here", MyUrls.getEntryUrl());
        out.print(".");
        return out;
    }

    private KmHtmlBuilder formatUnknownTypeMessage()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.println("Unknown Invitation Type");
        return out;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getToEmail() + " " + getTypeName();
    }

    //##################################################
    //# support
    //##################################################

    private String formatProjectName()
    {
        return getProjectName();
    }

    private String formatSenderName()
    {
        return getFromUserFullName();
    }

    private String getDoNoReplyEmail()
    {
        return getProperties().getSendEmailFromAddress();
    }

}
