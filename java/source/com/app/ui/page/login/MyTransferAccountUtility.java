package com.app.ui.page.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyEmail;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public class MyTransferAccountUtility
{
    //##################################################
    //# start
    //##################################################

    public void start(MyAccount account, String email)
    {
        MyUser user = getAccess().getUserDao().findEmail(email);

        sendTransferInvitation(user, email, account);
    }

    private void sendTransferInvitation(MyUser user, String email, MyAccount account)
    {
        MyPropertyRegistry p = getProperties();

        String userName = user.getName();
        String accountName = account.getName();

        MyInvitation inv;
        inv = new MyInvitation();
        inv.setType(MyInvitationType.Transfer);
        inv.setAccount(account);
        inv.setEmail(email);
        inv.saveDao();

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s", userName);
        msg.printfln();
        msg.printf("You have been asked to acquire the account %s. ", accountName);
        msg.printfln();
        msg.printf("To take ownership of this account click the following link.");
        msg.printfln();
        msg.printfln();
        msg.printLink("Take Ownership.", MyUrls.getInvitationUrl(inv));
        msg.printfln();

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
