package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
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
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyUserCriteria;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.MyUserActivation;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyUserActivationPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyUserActivationPage _instance;

    public static void installInstance()
    {
        _instance = new MyUserActivationPage();
    }

    public static MyUserActivationPage getInstance()
    {
        return _instance;
    }

    private MyUserActivationPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString   _token;

    private ScCardFrame     _frame;

    private ScCard          _activationCard;
    private ScTextSpan      _emailText;
    private ScPasswordField _password1Field;
    private ScPasswordField _password2Field;

    private ScCard          _successCard;

    private ScCard          _errorCard;
    private ScText          _errorMessage;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.none;
    }

    //##################################################
    //# navigation
    //##################################################

    public void ajaxEnter(MyUserActivation e)
    {
        setToken(e.getToken());
        ajaxEnter();
    }

    public String formatEntryUrl(MyUserActivation e)
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
        v.setValue("token", getToken());
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        setToken(v.getValue("token"));
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

        _activationCard = createActivationCard(_frame);
        _successCard = createSuccessCard(_frame);
        _errorCard = createErrorCard(_frame);
    }

    //==================================================
    //= install :: activation card
    //==================================================

    private ScCard createActivationCard(ScCardFrame frame)
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

        _password2Field = new ScPasswordField();
        _password2Field.layoutInline(width);
    }

    private void installForm(ScContainer root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleActivate);

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Activate User");

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
        footer.addSubmitButton("Activate User");
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
        body.addText(""
            + "Success! Your email has been activated. "
            + "Please click the following link to sign in.");

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
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        if ( !hasValidUserActivation() )
        {
            _errorMessage.setValue("The requested activation is invalid or has expired.");
            _errorCard.beDefaultCard();
            return;
        }

        if ( userExists() )
        {
            _errorMessage.setValue("The requested email is already active.");
            _errorCard.beDefaultCard();
            return;
        }

        _activationCard.beDefaultCard();
        _emailText.setValue(getUserActivation().getEmail());
        _password1Field.clearText();
        _password2Field.clearText();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleActivate()
    {
        if ( !hasValidUserActivation() )
        {
            printError(""
                + "The requested activation is invalid or has expired. "
                + "Please return to the sign in page to try again.");
            return;
        }

        ajax().hideAllErrors();

        _password1Field.ajaxClearFieldValue();
        _password2Field.ajaxClearFieldValue();

        _activationCard.validate();

        String pw1 = _password1Field.getValue();
        String pw2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(pw1, pw2) )
            _password1Field.error("Passwords did not match.");

        upsertUser();
        setEmailCookie();
        deleteUserActivation();

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

    private MyUserActivation getUserActivation()
    {
        return getAccess().getUserActivationDao().findToken(getToken());
    }

    private boolean hasValidUserActivation()
    {
        MyUserActivation ua = getUserActivation();

        if ( ua == null )
            return false;

        if ( ua.isExpired() )
            return false;

        return true;
    }

    private boolean userExists()
    {
        MyUserActivation ua = getUserActivation();

        if ( ua == null )
            return false;

        MyTenant tenant = ua.getTenant();
        String email = ua.getEmail();
        MyUser user = getAccess().getUserDao().findEmail(tenant, email);

        return user != null;
    }

    private void upsertUser()
    {
        MyUserActivation ua = getUserActivation();
        MyTenant tenant = ua.getTenant();
        String email = ua.getEmail();

        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name = p.getName();
        String pwd = _password1Field.getValue();

        MyUserCriteria c;
        c = getAccess().getUserDao().createCriteria();
        c.whereTenantIs(tenant);
        c.whereEmail().is(email);

        MyUser u = c.findFirst();
        if ( u == null )
        {
            u = tenant.addUser();
            u.setNickname(name);
            u.setRoleOther();
        }

        u.setPassword(pwd);
        u.daoAttach();
    }

    private void deleteUserActivation()
    {
        MyUserActivation ua = getUserActivation();

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
        MyUserActivation ua = getUserActivation();
        if ( ua != null )
            MyLoginUtility.ajaxSetEmailCookie(ua.getEmail());
    }

}
