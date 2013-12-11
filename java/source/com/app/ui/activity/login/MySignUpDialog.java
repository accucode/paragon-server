package com.app.ui.activity.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

import com.app.model.MyEmail;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.control.MyDialog;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyUrls;

public class MySignUpDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScBox          _emailBox;
    private ScTextField    _emailField;
    private ScBox          _messageBox;

    private ScSubmitButton _sendButton;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setBodyWidth(300);
        setBodyHeight(150);

        setAction(newCreateUserAction());
        getHeaderBox().addText("Sign Up");

        ScBox body;
        body = getBodyBox();

        installEmailBox(body);
        installMessageBox(body);
        installButtons();
    }

    private void installEmailBox(ScBox root)
    {
        _emailField = new ScTextField();
        _emailField.setRequired();
        _emailField.setWidthFull();

        String msg = ""
            + "Sign up is easy! Just tell us your email address and we"
            + " will send you an invitation.";

        _emailBox = root.addBox();
        _emailBox.addText(msg);
        _emailBox.addLabel("Email");
        _emailBox.addErrorBox().add(_emailField);
    }

    private void installMessageBox(ScBox root)
    {
        _messageBox = root.addBox();
        _messageBox.hide();
    }

    private void installButtons()
    {
        ScBox buttons;
        buttons = getFooterBox().addButtonBoxRight();

        _sendButton = buttons.addSubmitButton("Send My Invitation");

        buttons.addButton("Close", getCloseDialogAction());
    }

    //##################################################
    //# start
    //##################################################

    public void start(String email)
    {
        _emailField.setValue(email);
        _emailField.ajaxUpdateValue();

        ajaxOpen();
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newCreateUserAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleCreateUser();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleCreateUser()
    {
        ajax().hideAllErrors();
        ajax().focus();

        validate();

        String email = _emailField.getValue();

        boolean isValid = KmEmailParser.validate(email);
        if ( !isValid )
            _emailField.error("Invalid");

        MyUser user = getAccess().getUserDao().findEmail(email);

        if ( user == null )
            sendNewUserInvitation(email);
        else
            sendResetPasswordInvitation(user);

        showSentMessage(email);
        setEmailCookie(email);
    }

    private void sendNewUserInvitation(String email)
    {
        MyPropertyRegistry p = getProperties();

        KmEmailParser parser;
        parser = new KmEmailParser();
        parser.setEmail(email);

        String name;
        name = parser.getName();

        String app = MyConstantsIF.APPLICATION_NAME;

        MyInvitation i;
        i = new MyInvitation();
        i.setEmail(email);
        i.setType(MyInvitationType.User);
        i.saveDao();

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s", name);
        msg.printfln();
        msg.printf("Welcome to %s! ", app);
        msg.printf("To set up your new account click the following link.");
        msg.printfln();
        msg.printfln();
        msg.printLink("Activate My Account", MyUrls.getInvitationUrl(i));
        msg.printfln();

        String subject = Kmu.format("%s Invitation", app);

        MyEmail e;
        e = new MyEmail();
        e.setSubject(subject);
        e.addToRecipient(email);
        e.setFromAddress(p.getSendEmailFromAddress());
        e.addHtmlPart(msg.toString());
        e.markReady();
        e.saveDao();
    }

    private void sendResetPasswordInvitation(MyUser user)
    {
        MyPropertyRegistry p = getProperties();
        String name = user.getName();
        String email = user.getEmail();
        String app = MyConstantsIF.APPLICATION_NAME;

        MyPasswordReset a;
        a = new MyPasswordReset();
        a.setUser(user);
        a.saveDao();

        String subject = Kmu.format("%s Password Reset", app);

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s", name);
        msg.printfln();
        msg.printf("A request was made to create a new %s user for the email %s. ", app, email);
        msg.printf("However, this email is already registered with our system. ");
        msg.printf("If you did not initiate this request, please ignore this email. ");
        msg.printf("If you are having difficulty accessing your account, you may use ");
        msg.printf("the link below to reset your password.");
        msg.printfln();
        msg.printfln();
        msg.printLink("Reset My Password", MyUrls.getPasswordResetUrl(a));
        msg.printfln();

        MyEmail e;
        e = new MyEmail();
        e.setSubject(subject);
        e.addToRecipient(email);
        e.setFromAddress(p.getSendEmailFromAddress());
        e.addHtmlPart(msg.toString());
        e.markReady();
        e.saveDao();
    }

    private void showSentMessage(String email)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        out.println("Your invitation has been sent to:");
        out.println();

        out.beginDivCss("indent");
        out.printBold(email);
        out.endDiv();

        _sendButton.ajax().hide();
        _emailBox.ajax().hide();

        _messageBox.ajaxSetHtml(out.toString());
        _messageBox.ajax().show().fade().defer();
    }

    private void setEmailCookie(String email)
    {
        MySignInUtility.setEmailCookie(email);
    }

}
