package com.app.ui.activity.login;

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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

public class MyTransferAccountUtility
{
    //##################################################
    //# start
    //##################################################

    public void start(MyAccount account, String email)
    {
        MyUser user = getAccess().getUserDao().findEmail(email);

        boolean isNewUser = user == null;

        if ( isNewUser )
        {
            createUser(email);
            sendTransferInvitation(user, account, true);
        }
        sendTransferInvitation(user, account, false);
    }

    private MyUser createUser(String email)
    {
        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = new MyUser();
        u.setName(name);
        u.setEmail(email);
        u.setRandomPassword();
        u.saveDao();

        return u;
    }

    private void sendTransferInvitation(MyUser user, MyAccount account, boolean isNewUser)
    {
        MyPropertyRegistry p = getProperties();

        String email = user.getEmail();
        String accountName = account.getName();

        MyInvitation inv;
        inv = new MyInvitation();
        inv.setType(MyInvitationType.Transfer);
        inv.setAccount(account);
        inv.setUser(user);
        inv.saveDao();

        KmHtmlBuilder msg;

        if ( isNewUser )
            msg = formatNewUserMsg(user, account, inv);
        else
            msg = formatExistingUserMsg(user, account, inv);

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

    private KmHtmlBuilder formatNewUserMsg(MyUser user, MyAccount account, MyInvitation i)
    {
        String userName = user.getName();
        String email = user.getEmail();
        String accountName = account.getName();
        String app = MyConstantsIF.APPLICATION_NAME;

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s", userName);
        msg.printfln();
        msg.printf("Welcome to %s! ", app);
        msg.printf("A new user account has been created for the email %s. ", email);
        msg.printf("You have been asked to acquire the account %s. ", accountName);
        msg.printfln();
        msg.printf("To take ownership of this account and to activate your new user account "
            + "click the following link.");
        msg.printfln();
        msg.printfln();
        msg.printLink("Activate My Account and Take Ownership.", MyUrls.getInvitationUrl(i));
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
