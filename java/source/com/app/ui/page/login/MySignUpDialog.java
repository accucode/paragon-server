package com.app.ui.page.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

import com.app.model.MyEmail;
import com.app.model.MyUserActivation;
import com.app.ui.control.MyDialog;
import com.app.utility.MyConstantsIF;

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
        _emailBox.addBreak();
        _emailBox.addBreak();
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

    public void open(String email)
    {
        _emailBox.show();

        _emailField.setValue(email);
        _emailField.show();

        _messageBox.show();

        _sendButton.show();

        ajaxReplace();
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

        MyUserActivation ua = createUserActivation(email);

        sendEmail(ua);
        showSentMessage(email);
        setEmailCookie(email);
    }

    //==================================================
    //= handle :: activation
    //==================================================

    private MyUserActivation createUserActivation(String email)
    {
        MyUserActivation e;
        e = new MyUserActivation();
        e.setEmail(email);
        e.saveDao();
        return e;
    }

    //==================================================
    //= handle :: email
    //==================================================

    private void sendEmail(MyUserActivation ua)
    {
        String subject = formatSubject();
        String msg = formatMessage(ua);

        MyEmail e;
        e = new MyEmail();
        e.setSubject(subject);
        e.addToRecipient(ua.getEmail());
        e.setFromAddress(getFromAddress());
        e.addHtmlPart(msg.toString());
        e.markReady();
        e.saveDao();
    }

    private String getFromAddress()
    {
        return getProperties().getSendEmailFromAddress();
    }

    private String formatSubject()
    {
        return Kmu.format("%s Invitation", MyConstantsIF.APPLICATION_NAME);
    }

    private String formatMessage(MyUserActivation ua)
    {
        KmEmailParser parser;
        parser = new KmEmailParser();
        parser.setEmail(ua.getEmail());

        String name;
        name = parser.getName();

        String linkText = "Activate My Account";
        String linkUrl = ua.formatEntryUrl();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printfln("Hi %s", name);
        out.printfln();
        out.printf("Welcome to %s! ", MyConstantsIF.APPLICATION_NAME);
        out.printfln("To set up your new account click the following link.");
        out.printfln();
        out.printLink(linkText, linkUrl);
        out.printfln();

        return out.toString();
    }

    //##################################################
    //# support
    //##################################################

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
