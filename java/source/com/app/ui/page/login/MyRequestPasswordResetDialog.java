package com.app.ui.page.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyEmail;
import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.ui.control.MyDialog;
import com.app.utility.MyConstantsIF;

public class MyRequestPasswordResetDialog
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

        setLabel("Reset Password");
        setWidth(400);
        setSubmitAction(this::handleSend);

        ScDiv body;
        body = getBody();
        body.css().pad();

        installEmailBoxOn(body);
        installMessageBoxOn(body);

        ScFlexbox footer;
        footer = showFooter();
        footer.alignEnd();
        footer.css().buttonBox();
        _sendButton = footer.addSubmitButton("Email Password Reset");
        footer.addButton("Close", this::ajaxClose);
    }

    private void installEmailBoxOn(ScContainer root)
    {
        _emailField = new ScTextField();
        _emailField.setRequired();
        _emailField.setWidthFull();

        String msg = ""
            + "To reset your password, we must send you an email. "
            + "Please enter your email address, the press 'Email Password Reset'.";

        ScBox box;
        box = root.addBox();
        box.addText(msg);
        box.addBreak();
        box.addBreak();
        box.addLabel("Email");
        box.addErrorBox().add(_emailField);

        _emailBox = box;
    }

    private void installMessageBoxOn(ScContainer root)
    {
        _messageBox = root.addBox();
        _messageBox.hide();
    }

    //##################################################
    //# start
    //##################################################

    public void ajaxOpen(String email)
    {
        _emailField.setValue(email);
        ajaxOpen();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSend()
    {
        ajax().hideAllErrors();
        ajax().focus();

        validate();

        String email = _emailField.getValue();

        MyUser user = getAccess().getUserDao().findEmail(email);
        if ( user == null )
        {
            _emailField.addError("No such user.");
            throw newRollback();
        }

        MyPasswordReset pr = createPasswordReset(user);

        sendEmail(pr);
        showSentMessage(pr);
        setEmailCookie(email);
    }

    //##################################################
    //# support
    //##################################################

    private MyPasswordReset createPasswordReset(MyUser user)
    {
        MyPasswordReset e;
        e = new MyPasswordReset();
        e.setUser(user);
        e.attachDao();
        return e;
    }

    private void sendEmail(MyPasswordReset pr)
    {
        String to = pr.getEmail();

        MyUser user = getAccess().getUserDao().findEmail(to);
        if ( user == null )
        {
            _emailField.addError("We have no record of a user with with that email.");
            throw newRollback();
        }

        String app = MyConstantsIF.APPLICATION_NAME;
        String subject = Kmu.format("Password Reset Request");
        String url = pr.formatEntryUrl();

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s,", user.getName());
        msg.printfln();
        msg.printfln("We received a request to reset your %s password. ", app);
        msg.printfln("If you did not request, simply ignore this email. ");
        msg.printfln("If you do want to reset your password click the link below.");
        msg.printfln();
        msg.printLink("Reset My Password", url);

        MyEmail e;
        e = new MyEmail();
        e.addToRecipient(to);
        e.setFromAddress(getFromAddress());
        e.setSubject(subject);
        e.addHtmlPart(msg.toString());
        e.markReady();
        e.attachDao();
    }

    private void showSentMessage(MyPasswordReset pr)
    {
        String email = pr.getEmail();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        out.println("We have sent reset instructions to:");
        out.println();

        out.beginDivCss("indent");
        out.printBold(email);
        out.endDiv();

        _sendButton.ajax().hide();
        _emailBox.ajax().hide();

        _messageBox.ajaxSetHtml(out.toString());
        _messageBox.ajax().show().fade();
    }

    private void setEmailCookie(String email)
    {
        MySignInUtility.setEmailCookie(email);
    }

    private String getFromAddress()
    {
        return getProperties().getSendEmailFromAddress();
    }

}
