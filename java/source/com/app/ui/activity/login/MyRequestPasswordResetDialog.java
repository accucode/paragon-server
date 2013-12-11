package com.app.ui.activity.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyEmail;
import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.ui.control.MyDialog;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyUrls;

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

        setBodyWidth(300);
        setBodyHeight(150);

        setAction(newSendAction());
        getHeaderBox().addText("Reset Password");

        ScBox body;
        body = getBodyBox();

        installEmailBox(body);
        installMessageBox(body);

        ScBox buttons;
        buttons = getFooterBox().addButtonBoxRight();
        _sendButton = buttons.addSubmitButton("Email Password Reset");
        buttons.addButton("Close", getCloseDialogAction());
    }

    private void installEmailBox(ScBox root)
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
        box.addLabel("Email");
        box.addErrorBox().add(_emailField);

        _emailBox = box;
    }

    private void installMessageBox(ScBox root)
    {
        _messageBox = root.addBox();
        _messageBox.hide();
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

    private ScActionIF newSendAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSend();
            }
        };
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
            _emailField.error("No such user.");

        MyPasswordReset pr;
        pr = createPasswordReset(user);

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
        e.saveDao();

        return e;
    }

    private void sendEmail(MyPasswordReset pr)
    {
        MyUser user = pr.getUser();
        String app = MyConstantsIF.APPLICATION_NAME;
        String subject = Kmu.format("Password Reset Request");
        String to = pr.getUser().getEmail();
        String url = MyUrls.getPasswordResetUrl(pr);

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
        e.setSubject(subject);
        e.addHtmlPart(msg.toString());
        e.markReady();
        e.saveDao();
    }

    private void showSentMessage(MyPasswordReset pr)
    {
        String email = pr.getUser().getEmail();

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
        _messageBox.ajax().show().fade().defer();
    }

    private void setEmailCookie(String email)
    {
        MySignInActivity.instance.setEmailCookie(email);
    }

}
