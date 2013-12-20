package com.app.model;

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

    public MyAccountUserRole getRole()
    {
        return MyAccountUserRole.findCode(getRoleCode());
    }

    public void setRole(MyAccountUserRole e)
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
        e.addTextPart(formatMessage());
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

    public String formatMessage()
    {
        MyInvitationType type = getType();
        switch ( type )
        {
            case JoinAccount:
                return formatJoinAccountMessage();

            case TransferAccount:
                return formatTransferAccountMessage();
        }

        return "Unknown Invitation Type";
    }

    private String formatJoinAccountMessage()
    {
        return Kmu.format(
            "You have been invited to the %s account by %s.",
            formatAccountName(),
            formatSenderName());
    }

    private String formatTransferAccountMessage()
    {
        return Kmu.format(
            "You have been invited to take ownership of the %s account by %s.",
            formatAccountName(),
            formatSenderName());
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
