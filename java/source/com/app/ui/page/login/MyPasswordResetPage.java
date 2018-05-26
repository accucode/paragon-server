package com.app.ui.page.login;

import com.kodemore.servlet.ScBookmark;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyPasswordReset;
import com.app.model.MyTenant;
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
    //# bookmark
    //##################################################

    @Override
    public MyPasswordResetBookmark newBookmark()
    {
        return new MyPasswordResetBookmark(this);
    }

    private MyPasswordResetBookmark castBookmark(ScBookmark e)
    {
        return (MyPasswordResetBookmark)e;
    }

    @Override
    protected void readStateFrom(ScBookmark o)
    {
        super.readStateFrom(o);

        MyPasswordResetBookmark e;
        e = castBookmark(o);
        setToken(e.getToken());
    }

    @Override
    protected void writeStateTo(ScBookmark o)
    {
        super.writeStateTo(o);

        MyPasswordResetBookmark e;
        e = castBookmark(o);
        e.setToken(getToken());
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _token = new ScLocalString();
        _token.setAutoSave();

        _frame = root.addCardFrame();
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
        _password1Field.layoutInline(width);
        _password1Field.setRequired();
        _password1Field.disableChangeTracking();

        _password2Field = new ScPasswordField();
        _password2Field.layoutInline(width);
        _password2Field.disableChangeTracking();
    }

    private void installForm(ScContainer root)
    {
        ScForm form;
        form = root.addForm();
        form.onSubmit(newUncheckedAction(this::handleResetPassword));

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Reset Password");

        ScDiv body;
        body = group.getBody().addDiv();
        body.css().pad();

        body.addLabel("Email");
        body.add(_emailText);

        ScDiv label;
        label = body.addLabel("Choose a Password");
        label.css().padTop();
        body.addErrorWrapperWith(_password1Field);

        label = body.addLabel("Re-enter Password");
        label.css().padTop();
        body.addErrorWrapperWith(_password2Field);

        group.addBodyDivider();

        ScDiv footer;
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

        ScDiv body;
        body = group.getBody().addDiv();
        body.css().pad();
        body.addText(
            ""
                + "Success! Your password has been reset. "
                + "Please click the button below to sign in.");

        group.addBodyDivider();

        ScDiv footer;
        footer = group.getBody().addButtonBox();
        footer.addButton("Sign In", MyLoginPage.getInstance());

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

        ScDiv body;
        body = group.getBody().addDiv();
        body.css().pad();

        _errorMessage = body.addText();

        group.addBodyDivider();

        ScDiv footer;
        footer = group.getBody().addButtonBox();
        footer.addButton("Sign In", MyLoginPage.getInstance());

        return card;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        MyPasswordReset pr = getPasswordReset();
        if ( pr == null || pr.isExpired() )
        {
            _errorMessage.setValue("The requested password reset is invalid or has expired.");
            _errorCard.beDefaultCard();
            return;
        }

        MyUser u = pr.findUser();
        if ( u == null )
        {
            _errorMessage.setValue("No such email exists.");
            _errorCard.beDefaultCard();
            return;
        }

        _entryCard.beDefaultCard();
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

        _password1Field.ajaxClearFieldValue();
        _password2Field.ajaxClearFieldValue();

        _entryCard.validateAndCheck();

        String pw1 = _password1Field.getValue();
        String pw2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(pw1, pw2) )
            _password1Field.addErrorAndCheck("Passwords did not match.");

        MyUser user = pr.findUser();
        if ( user == null )
        {
            printError("The requested email is not valid.");
            return;

        }

        user.setPassword(pw1);
        setEmailCookie();
        deletePasswordReset();

        _successCard.ajaxPrintCard();
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
        MyPasswordReset reset = getAccess().getPasswordResetDao().findToken(getToken());
        if ( reset == null )
            return null;

        MyTenant tenant = getCurrentTenant();
        if ( !reset.hasTenant(tenant) )
            return null;

        return reset;
    }

    private void deletePasswordReset()
    {
        MyPasswordReset ua = getPasswordReset();

        if ( ua != null )
            ua.daoDelete();
    }

    private void printError(String msg)
    {
        _errorMessage.setValue(msg);
        _errorCard.ajaxPrintCard();
    }

    private void setEmailCookie()
    {
        MyPasswordReset ua = getPasswordReset();
        if ( ua != null )
            MyLoginUtility.ajaxSetEmailCookie(ua.getEmail());
    }

}
