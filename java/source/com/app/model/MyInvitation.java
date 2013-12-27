package com.app.model;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyInvitationBase;
import com.app.utility.MyUrls;

public class MyInvitation
    extends MyInvitationBase
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
    //# role
    //##################################################

    public MyUserAccountRole getRole()
    {
        return MyUserAccountRole.findCode(getRoleCode());
    }

    public void setRole(MyUserAccountRole e)
    {
        setRoleCode(getCodeFor(e));
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
            case TransferAccount:
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
        e.saveDao();
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

            case TransferAccount:
                return formatTransferSubject();
        }

        return "Unknown Invitation Type";
    }

    private String formatJoinSubject()
    {
        return Kmu.format("Invitation to join %s", formatAccountName());
    }

    private String formatTransferSubject()
    {
        return Kmu.format("Invitation to transfer %s", formatAccountName());
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

            case TransferAccount:
                return formatTransferAccountMessage().toString();
        }

        return formatUnknownTypeMessage().toString();
    }

    private KmHtmlBuilder formatJoinAccountMessage()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printf(
            "You have been invited to the %s account by %s.",
            formatAccountName(),
            formatSenderName());

        out.print(" To review the invitation please click ");
        out.printLink("here", MyUrls.getEntryUrl());
        out.print(".");
        return out;
    }

    private KmHtmlBuilder formatTransferAccountMessage()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printf(
            "You have been invited to take ownership of the %s account by %s.",
            formatAccountName(),
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
    //# support
    //##################################################

    private String formatAccountName()
    {
        return getAccountName();
    }

    private String formatSenderName()
    {
        return getFromUserName();
    }

    private String getDoNoReplyEmail()
    {
        return getProperties().getSendEmailFromAddress();
    }
}
