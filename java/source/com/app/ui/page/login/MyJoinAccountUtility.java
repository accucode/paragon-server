package com.app.ui.page.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyEmail;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public class MyJoinAccountUtility
{
    //##################################################
    //# start
    //##################################################

    /**
     * Send an email invitation to join the specified account, with the given role.
     * 
     * The invitation will be sent to the email address provided.
     * The email may already be associated with a user, or not.
     */
    public void sendInvitationTo(String email, MyAccount account, String roleCode)
    {
        MyUser user = getAccess().getUserDao().findEmail(email);

        MyInvitation inv;
        inv = new MyInvitation();
        inv.setType(MyInvitationType.JoinAccount);
        inv.setUser(user);
        inv.setAccount(account);
        inv.setEmail(email);
        inv.setRoleCode(roleCode);
        inv.saveDao();

        sendEmail(inv);
    }

    //##################################################
    //# private
    //##################################################

    private void sendEmail(MyInvitation inv)
    {
        MyPropertyRegistry p = getProperties();

        String to = inv.getEmail();
        String from = p.getSendEmailFromAddress();
        String subject = formatSubject(inv);
        String msg = formatMessage(inv);

        MyEmail e;
        e = new MyEmail();
        e.setSubject(subject);
        e.addToRecipient(to);
        e.setFromAddress(from);
        e.addHtmlPart(msg);
        e.markReady();
        e.saveDao();
    }

    private String formatSubject(MyInvitation inv)
    {
        return Kmu.format("%s Join Account Invitation", inv.getAccountName());
    }

    private String formatMessage(MyInvitation inv)
    {
        MyUser user = inv.getUser();
        MyAccount acct = inv.getAccount();

        if ( user == null )
            return formatNewUserMessage(inv);

        if ( !user.isMemberOf(acct) )
            return formatNewMemberMessage(inv);

        return formatExistingMemberMessage(inv);
    }

    private String formatNewUserMessage(MyInvitation i)
    {
        KmEmailParser parser;
        parser = new KmEmailParser();
        parser.setEmail(i.getEmail());

        String userName = parser.getName();
        String accountName = i.getAccountName();
        String appName = MyConstantsIF.APPLICATION_NAME;

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printfln("Hi %s", userName);
        out.printfln();
        out.printf("Welcome to %s! ", appName);
        out.printf("You have been asked to join %s. ", accountName);
        out.printfln();
        out.printf(""
            + "To join %s and to activate your new user account "
            + "click the following link.", accountName);
        out.printfln();
        out.printfln();
        out.printLink(
            "Activate my account and join " + accountName + ".",
            MyUrls.getInvitationUrl(i));
        out.printfln();

        return out.toString();
    }

    private String formatNewMemberMessage(MyInvitation i)
    {
        String userName = i.getUserName();
        String accountName = i.getAccountName();

        String linkMsg = "Join " + accountName + ".";
        String linkUrl = MyUrls.getInvitationUrl(i);

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printfln("Hi %s", userName);
        out.printfln();
        out.printfln("You have been asked to join %s! ", accountName);
        out.printfln("To join this account click the following link.");
        out.printfln();
        out.printLink(linkMsg, linkUrl);
        out.printfln();

        return out.toString();
    }

    private String formatExistingMemberMessage(MyInvitation i)
    {
        MyUser user = i.getUser();
        MyAccount account = i.getAccount();

        MyPasswordReset pr;
        pr = new MyPasswordReset();
        pr.setUser(user);
        pr.saveDao();

        String linkMsg = "Reset My Password";
        String linkUrl = MyUrls.getPasswordResetUrl(pr);

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printfln("Hi %s", user.getName());
        out.printfln();
        out.printf(
            "A request was made to join the email %s to the account %s. ",
            user.getEmail(),
            account.getName());
        out.printf("However, this email is already joined to the account. ");
        out.printf("If you did not initiate this request, please ignore this email. ");
        out.printf("If you are having difficulty accessing your account, you may use ");
        out.printf("the link below to reset your password.");
        out.printfln();
        out.printfln();
        out.printLink(linkMsg, linkUrl);
        out.printfln();

        return out.toString();
    }

    //##################################################
    //# utility
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }
}
