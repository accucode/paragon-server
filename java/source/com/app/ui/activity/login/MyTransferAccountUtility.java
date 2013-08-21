package com.app.ui.activity.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyEmail;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public class MyTransferAccountUtility
{
    //##################################################
    //# variables
    //##################################################

    private MyUser _user;

    //##################################################
    //# start
    //##################################################

    public void start(MyAccount account, String email)
    {
        MyUser user = getAccess().getUserDao().findEmail(email);

        boolean isNewUser = user == null;

        if ( !isNewUser )
            _user = user;

        sendTransferInvitation(email, account, isNewUser);
    }

    private void sendTransferInvitation(String email, MyAccount account, boolean isNewUser)
    {
        MyPropertyRegistry p = getProperties();

        String accountName = account.getName();

        MyInvitation inv;
        inv = new MyInvitation();
        inv.setType(MyInvitationType.Transfer);
        inv.setAccount(account);
        inv.setEmail(email);
        inv.saveDao();

        KmHtmlBuilder msg;

        if ( isNewUser )
            msg = formatNewUserMsg(email, account, inv);
        else
            msg = formatExistingUserMsg(_user, account, inv);

        String subject = Kmu.format("%s Account Transfer Invitation", accountName);

        MyEmail e;
        e = new MyEmail();
        e.setSubject(subject);
        e.addToRecipient(email);
        e.setFromAddress(p.getSendEmailFromAddress());
        e.addHtmlPart(msg.toString());
        e.markReady();
        e.saveDao();
    }

    /**
     * review_wyatt (valerie) we have put in errors that should ensure that this
     * message never gets sent.  Should I pull it or leave it in for an edge case?
     */
    private KmHtmlBuilder formatNewUserMsg(String email, MyAccount account, MyInvitation i)
    {
        KmEmailParser parser;
        parser = new KmEmailParser();
        parser.setEmail(email);

        String name;
        name = parser.getName();

        String accountName = account.getName();
        String app = MyConstantsIF.APPLICATION_NAME;

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s", name);
        msg.printfln();
        msg.printf("Welcome to %s! ", app);
        msg.printf("You have been asked to acquire the account %s. ", accountName);
        msg.printfln();
        msg.printf("To take ownership of this account and to activate your new user account "
            + "click the following link.");
        msg.printfln();
        msg.printfln();
        msg.printLink("Set Up My Account and Take Ownership.", MyUrls.getInvitationUrl(i));
        msg.printfln();
        return msg;
    }

    private KmHtmlBuilder formatExistingUserMsg(MyUser user, MyAccount account, MyInvitation i)
    {
        String userName = user.getName();
        String accountName = account.getName();

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s", userName);
        msg.printfln();
        msg.printf("You have been asked to acquire the account %s. ", accountName);
        msg.printfln();
        msg.printf("To take ownership of this account click the following link.");
        msg.printfln();
        msg.printfln();
        msg.printLink("Take Ownership.", MyUrls.getInvitationUrl(i));
        msg.printfln();
        return msg;
    }

    //##################################################
    //# utility
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }
}
