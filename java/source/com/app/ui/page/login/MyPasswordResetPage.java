package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyPasswordResetPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyPasswordResetPage _instance;

    public static void installInstance()
    {
        _instance = new MyPasswordResetPage();
    }

    public static MyPasswordResetPage getInstance()
    {
        return _instance;
    }

    private MyPasswordResetPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String PARAM_TOKEN = "token";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _token;

    private ScCardFrame _frame;

    private ScCard          _entryCard;
    private ScTextSpan      _emailText;
    private ScPasswordField _password1Field;
    private ScPasswordField _password2Field;

    private ScCard _successCard;

    private ScCard _errorCard;
    private ScText _errorMessage;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.none;
    }

    //##################################################
    //# url
    //##################################################

    public String formatEntryUrl(MyPasswordReset e)
    {
        setToken(e.getToken());

        return formatEntryUrl();
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        v.setValue(PARAM_TOKEN, getToken());
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        setToken(v.getValue(PARAM_TOKEN));
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _token = new ScLocalString();
        _token.setAutoSave();

        _frame = root.addFrame();
        _frame.style().width(300).marginTop(100).marginCenter();

        _entryCard = createEntryCard(_frame);
        _successCard = createSuccessCard(_frame);
        _errorCard = createErrorCard(_frame);
    }

    //==================================================
    //= install :: entry card
    //==================================================

    private ScCard createEntryCard(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addCard();

        initFields();
        installForm(card);

        return card;
    }

    private void initFields()
    {
        int width = 270;

        _emailText = new ScTextSpan();
        _emailText.css().displayBlock().fieldValue();

        _password1Field = new ScPasswordField();
        _password1Field.style().width(width);
        _password1Field.setRequired();
        _password1Field.disableChangeTracking();

        _password2Field = new ScPasswordField();
        _password2Field.style().width(width);
        _password2Field.disableChangeTracking();
    }

    private void installForm(ScContainer root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleResetPassword);

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Reset Password");

        ScBox body;
        body = group.getBody().addBox();
        body.css().pad();

        body.addLabel("Email");
        body.add(_emailText);

        ScBox label;
        label = body.addLabel("Choose a Password");
        label.css().padTop();
        body.addErrorBox().add(_password1Field);

        label = body.addLabel("Re-enter Password");
        label.css().padTop();
        body.addErrorBox().add(_password2Field);

        group.addBodyDivider();

        ScBox footer;
        footer = group.getBody().addButtonBox();
        footer.addSubmitButton("Reset Password");
    }

    //==================================================
    //= install :: success card
    //==================================================

    private ScCard createSuccessCard(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addCard();

        ScGroup group;
        group = card.addGroup();
        group.setTitle("Success");

        ScBox body;
        body = group.getBody().addBox();
        body.css().pad();
        body.addText(
            ""
                + "Success! Your password has been reset. "
                + "Please click the following link to sign in.");

        group.addBodyDivider();

        ScBox footer;
        footer = group.getBody().addButtonBox();
        footer.addButton("Sign In", MySignInPage.getInstance());

        return card;
    }

    //==================================================
    //= install :: error card
    //==================================================

    private ScCard createErrorCard(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addCard();

        ScGroup group;
        group = card.addGroup();
        group.setTitle("Error");

        ScBox body;
        body = group.getBody().addBox();
        body.css().pad();

        _errorMessage = body.addText();

        group.addBodyDivider();

        ScBox footer;
        footer = group.getBody().addButtonBox();
        footer.addButton("Sign In", MySignInPage.getInstance());

        return card;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        MyPasswordReset pr = getPasswordReset();
        if ( pr == null || pr.isExpired() )
        {
            _errorMessage.setValue("The requested password reset is invalid or has expired.");
            _errorCard.beDefault();
            return;
        }

        MyUser u = pr.findUser();
        if ( u == null )
        {
            _errorMessage.setValue("No such email exists.");
            _errorCard.beDefault();
            return;
        }

        _entryCard.beDefault();
        _emailText.setValue(getPasswordReset().getEmail());
        _password1Field.clearText();
        _password2Field.clearText();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleResetPassword()
    {
        MyPasswordReset pr = getPasswordReset();
        if ( pr == null || pr.isExpired() )
        {
            printError(
                ""
                    + "The requested password reset is invalid or has expired. "
                    + "Please return to the sign in page to try again.");
            return;
        }

        ajax().hideAllErrors();

        _password1Field.ajax().clearValue();
        _password2Field.ajax().clearValue();

        _entryCard.validate();

        String pw1 = _password1Field.getValue();
        String pw2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(pw1, pw2) )
            _password1Field.error("Passwords did not match.");

        MyUser user = pr.findUser();
        if ( user == null )
        {
            printError("The requested email is not valid.");
            return;

        }

        user.setPassword(pw1);
        setEmailCookie();
        deletePasswordReset();

        _successCard.ajaxPrint();
    }

    //##################################################
    //# token
    //##################################################

    private String getToken()
    {
        return _token.getValue();
    }

    private void setToken(String e)
    {
        _token.setValue(e);
    }

    //##################################################
    //# support
    //##################################################

    private MyPasswordReset getPasswordReset()
    {
        return getAccess().getPasswordResetDao().findToken(getToken());
    }

    private void deletePasswordReset()
    {
        MyPasswordReset ua = getPasswordReset();

        if ( ua != null )
            ua.deleteDao();
    }

    private void printError(String msg)
    {
        _errorMessage.setValue(msg);
        _errorCard.ajaxPrint();
    }

    private void setEmailCookie()
    {
        MyPasswordReset ua = getPasswordReset();
        if ( ua != null )
            MySignInUtility.setEmailCookie(ua.getEmail());
    }

}
