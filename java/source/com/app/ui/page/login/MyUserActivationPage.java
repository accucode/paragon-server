package com.app.ui.page.login;

import com.kodemore.collection.KmList;
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
import com.kodemore.utility.KmEmailAddress;
import com.kodemore.utility.KmEmailAddressParser;
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

    private ScLocalString _token;

    private ScCardFrame _frame;

    private ScCard          _activationCard;
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

    @Override
    public boolean allowsJumpTo()
    {
        return false;
    }

    //##################################################
    //# navigation
    //##################################################

    public void ajaxEnter(MyUserActivation e)
    {
        setToken(e.getToken());
        ajaxEnter();
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public MyUserActivationBookmark newBookmark()
    {
        return new MyUserActivationBookmark(this);
    }

    private MyUserActivationBookmark castBookmark(ScBookmark e)
    {
        return (MyUserActivationBookmark)e;
    }

    @Override
    protected void readStateFrom(ScBookmark o)
    {
        super.readStateFrom(o);

        MyUserActivationBookmark e;
        e = castBookmark(o);
        setToken(e.getToken());
    }

    @Override
    protected void writeStateTo(ScBookmark o)
    {
        super.writeStateTo(o);

        MyUserActivationBookmark e;
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
        form.onSubmit(newUncheckedAction(this::handleActivate));

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
        body.addText(
            ""
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
    //# render
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
            printError(
                ""
                    + "The requested activation is invalid or has expired. "
                    + "Please return to the sign in page to try again.");
            return;
        }

        ajaxHideAllErrors();

        _password1Field.ajaxClearFieldValue();
        _password2Field.ajaxClearFieldValue();

        _activationCard.validateAndCheck();

        String pw1 = _password1Field.getValue();
        String pw2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(pw1, pw2) )
            _password1Field.addErrorAndCheck("Passwords did not match.");

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

        KmEmailAddressParser p;
        p = new KmEmailAddressParser();
        p.parse(email);

        if ( p.hasErrors() )
            throw Kmu.newError("Cannot parse email address.");

        KmList<KmEmailAddress> v = p.getValidEmails();
        if ( v.isEmpty() )
            throw Kmu.newError("Cannot determine email address.");

        if ( v.isMultiple() )
            throw Kmu.newError("Cannot determine single email address.");

        KmEmailAddress addr = v.getFirst();
        String name = addr.getName();
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
            u.setRoleProjectMember();
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
