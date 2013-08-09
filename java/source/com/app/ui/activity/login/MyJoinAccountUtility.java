package com.app.ui.activity.login;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
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

public class MyJoinAccountUtility
{
    //##################################################
    //# start
    //##################################################

    public void start(MyAccount account, String email, String roleCode)
    {
        MyUser user = getAccess().getUserDao().findEmail(email);
        MyAccountUser accountUser;
        accountUser = getAccess().getAccountUserDao().findAccountUserFor(user, account);

        boolean isNewUser = user == null;

        if ( isNewUser )
            user = createUser(email, account, roleCode);

        accountUser = createAccountUser(user, account, roleCode);
        sendTransferInvitation(user, account, accountUser, true, roleCode);
    }

    private MyUser createUser(String email, MyAccount account, String roleCode)
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

    private MyAccountUser createAccountUser(MyUser user, MyAccount account, String roleCode)
    {
        MyAccountUser accountUser;
        accountUser = new MyAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);
        accountUser.setRoleCode(roleCode);
        accountUser.saveDao();

        return accountUser;
    }

    private void sendTransferInvitation(
        MyUser user,
        MyAccount account,
        MyAccountUser accountUser,
        boolean isNewUser,
        String roleCode)
    {
        MyPropertyRegistry p = getProperties();

        String email = user.getEmail();
        String accountName = account.getName();

        MyInvitation inv;
        inv = new MyInvitation();
        inv.setType(MyInvitationType.Join);
        inv.setAccount(account);
        inv.setUser(user);
        inv.setAccountUser(accountUser);
        inv.setAccountUserRoleCode(roleCode);
        inv.saveDao();

        // remove_valerie: print
        System.out.println("MyJoinAccountUtility.sendTransferInvitation --- invitation saved");

        KmHtmlBuilder msg;

        if ( isNewUser )
            msg = formatNewUserMsg(user, account, inv);
        else
            msg = formatExistingUserMsg(user, account, inv);

        String subject = Kmu.format("%s Join Account Invitation", accountName);

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
        msg.printf("You have been asked to join the account %s. ", accountName);
        msg.printfln();
        msg.printf("To join %s and to activate your new user account "
            + "click the following link.", accountName);
        msg.printfln();
        msg.printfln();
        msg.printLink(
            "Activate My Account and Join " + accountName + ".",
            MyUrls.getInvitationUrl(i));
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
        msg.printf("You have been asked to join the account %s. ", accountName);
        msg.printfln();
        msg.printf("To join this account click the following link.");
        msg.printfln();
        msg.printfln();
        msg.printLink("Join " + accountName + ".", MyUrls.getInvitationUrl(i));
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
