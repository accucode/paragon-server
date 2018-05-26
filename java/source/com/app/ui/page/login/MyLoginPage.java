package com.app.ui.page.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScBookmark;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScEnterPageScript;
import com.kodemore.utility.Kmu;

import com.app.file.MyResourceFiles;
import com.app.model.MyAutoLogin;
import com.app.model.MyEmail;
import com.app.model.MyPasswordReset;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.layout.MyPageLayoutType;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyAppNavigator;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyUrls;

public final class MyLoginPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyLoginPage _instance;

    public static void installInstance()
    {
        _instance = new MyLoginPage();
    }

    public static MyLoginPage getInstance()
    {
        return _instance;
    }

    private MyLoginPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The original target query that was requested before the
     * user was redirected to log in. Once the user logs in,
     * we redirect the user to the originally requested page.
     */
    private ScHiddenField<String> _targetQueryField;

    /**
     * The frame that shows the various options: login, forgot password,
     * message, error.
     */
    private ScCardFrame _frame;

    //==================================================
    //= variables :: login card
    //==================================================

    private ScCard          _loginCard;
    private ScTextField     _emailField;
    private ScTextField     _passwordField;
    private ScCheckboxField _stayLoggedInField;

    private ScGroup   _oneAllGroup;
    private ScLiteral _oneAllBody;

    //==================================================
    //= variables :: forgot password card
    //==================================================

    private ScCard      _forgotPasswordCard;
    private ScTextField _forgotPasswordEmailField;

    //==================================================
    //= variables :: message card
    //==================================================

    private ScCard _messageCard;
    private ScText _messageText;

    //==================================================
    //= variables :: error card
    //==================================================

    private ScCard _errorCard;
    private ScText _errorText;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.none;
    }

    @Override
    public MyPageLayoutType getLayoutType()
    {
        return MyPageLayoutType.basic;
    }

    //##################################################
    //# navigation
    //##################################################

    public void ajaxEnterForWindowQuery()
    {
        String q = getData().getWindowQuery();
        _targetQueryField.setValue(q);
        ajaxEnter();
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public MyLoginBookmark newBookmark()
    {
        return new MyLoginBookmark(this);
    }

    private MyLoginBookmark castBookmark(ScBookmark e)
    {
        return (MyLoginBookmark)e;
    }

    @Override
    protected void readStateFrom(ScBookmark o)
    {
        super.readStateFrom(o);

        MyLoginBookmark e;
        e = castBookmark(o);
        _targetQueryField.setValue(e.getQuery());

        if ( e.hasError() )
        {
            _errorText.setValue(e.getError());
            _frame.setDefaultCard(_errorCard);
        }

        // NON-STANDARD, clear the bookmark after applying it.
        // getData().ajax().replaceHistory(this);
    }

    @Override
    protected void writeStateTo(ScBookmark o)
    {
        super.writeStateTo(o);

        MyLoginBookmark e;
        e = castBookmark(o);
        e.setQuery(_targetQueryField.getValue());
        e.setError(null);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().flexColumn().flexCrossAlignCenter();
        root.addFlexGap(100);

        installContentOn(root);
    }

    private void installContentOn(ScDiv col)
    {
        ScDiv row;
        row = col.addDiv();
        row.css().flexRow();

        installFrameOn(row);
        installLogo(row);
    }

    private void installLogo(ScDiv root)
    {
        ScDiv col;
        col = root.addDiv();
        col.css().flexColumn();
        col.addFlexChildFiller();

        ScTextSpan span;
        span = col.addTextSpan();
        span.css().loginAppName();
        span.setValue(MyConstantsIF.APPLICATION_NAME);

        col.addFlexChildFiller();
    }

    //==================================================
    //= install :: frame
    //==================================================

    private void installFrameOn(ScContainer root)
    {
        ScCardFrame frame;
        frame = root.addCardFrame();
        frame.css().width350();
        _frame = frame;

        installLoginCardOn(frame);
        installForgotPasswordCardOn(frame);
        installMessageCardOn(frame);
        installErrorCardOn(frame);
    }

    //==================================================
    //= install :: login card
    //==================================================

    private void installLoginCardOn(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addDefaultCard();
        card.css().flexColumn().columnSpacer20();

        installLoginGroupOn(card);
        installOneAllGroupOn(card);

        _loginCard = card;
    }

    private void installLoginGroupOn(ScCard card)
    {
        ScForm form;
        form = card.addForm();
        form.onSubmit(newUncheckedAction(this::handleLogin));

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Log in");

        installFieldsOn(group);
        installLoginFormFooter(group);
    }

    private void installFieldsOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.css().pad10();
        body.add(createTargetQueryField());

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.add(createEmailField());
        fields.add(createPasswordField());

        ScLink link;
        link = fields.addLink("Forgot password?", newCheckedAction(this::handleForgotPassword));
        link.setNoFocus();
    }

    private ScControl createTargetQueryField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _targetQueryField = e;
        return e;
    }

    private ScTextField createEmailField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Email");
        e.setRequired();
        e.setWidthFull();
        e.disableChangeTracking();
        _emailField = e;
        return e;
    }

    private ScPasswordField createPasswordField()
    {
        ScPasswordField e;
        e = new ScPasswordField();
        e.setLabel("Password");
        e.setWidthFull();
        e.disableChangeTracking();
        _passwordField = e;
        return e;
    }

    private void installLoginFormFooter(ScGroup group)
    {
        ScDiv footer;
        footer = group.showFooter();
        footer.css().flexRow().flexCrossAlignCenter().pad();
        footer.addSubmitButton("Sign In");
        footer.addFlexChildFiller();
        footer.add(createStayLoggedInField());
        footer.addNonBreakingSpace();
        footer.addTextSpan("Stay Signed In");
    }

    private ScControl createStayLoggedInField()
    {
        ScCheckboxField e;
        e = new ScCheckboxField();
        e.disableChangeTracking();
        _stayLoggedInField = e;
        return e;
    }

    private void installOneAllGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Or, log in via...");
        group.hide();
        _oneAllGroup = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad();
        _oneAllBody = body.addLiteral();
    }

    //==================================================
    //= install :: forgot password card
    //==================================================

    private void installForgotPasswordCardOn(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addCard();

        ScForm form;
        form = card.addForm();
        form.onSubmit(newUncheckedAction(this::handleRequestResetPassword));
        form.onEscape().run(newUncheckedAction(this::handleReturnToLogin));

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Forgot Password");

        installForgotPasswordFieldsOn(group);
        installForgotPasswordFooterOn(group);

        _forgotPasswordCard = card;
    }

    private void installForgotPasswordFieldsOn(ScGroup group)
    {
        ScTextField field;
        field = new ScTextField();
        field.setLabel("Email");
        field.setWidthFull();
        field.setRequired();
        field.disableChangeTracking();

        ScFieldLayout fields;
        fields = group.getBody().addFieldLayout();
        fields.css().pad10();
        fields.add(field);

        _forgotPasswordEmailField = field;
    }

    private void installForgotPasswordFooterOn(ScGroup group)
    {
        ScDiv footer;
        footer = group.getFooter();
        footer.show();

        ScDiv row;
        row = footer.addDiv();
        row.css().flexRow().flexAlignSpaced().flexCrossAlignCenter().pad();
        row.addSubmitButton("Request Password Reset");
        row.addCancelButton(newUncheckedAction(this::handleReturnToLogin));
    }

    //==================================================
    //= install :: message card
    //==================================================

    private void installMessageCardOn(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addCard();

        ScGroup group;
        group = card.addGroup();
        group.setTitle("Request Sent");

        ScDiv footer;
        footer = group.showFooter();
        footer.css().pad();

        ScActionButton button;
        button = footer.addButton("Ok", newCheckedAction(this::handleReturnToLogin));
        button.setFlavorPositive();
        button.css().width50();

        ScDiv body;
        body = group.getBody();
        body.css().height50().pad10();

        _messageText = body.addText();
        _messageCard = card;
    }

    //==================================================
    //= install :: error card
    //==================================================

    private void installErrorCardOn(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addCard();

        ScGroup group;
        group = card.addGroup();
        group.setTitle("Error");
        group.setFlavorAlert();

        ScDiv footer;
        footer = group.showFooter();
        footer.css().pad();

        ScActionButton button;
        button = footer.addButton("Ok", newCheckedAction(this::handleReturnToLogin));
        button.setFlavorPositive();
        button.css().width50();

        ScDiv body;
        body = group.getBody();
        body.css().pad10();

        _errorText = body.addText();
        _errorCard = card;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        preRenderOneAll();

        _emailField.setValue(getEmailCookie());
        _passwordField.clearText();
    }

    private void preRenderOneAll()
    {
        if ( !getProperties().getOneAllEnabled() )
            return;

        String html;
        html = MyResourceFiles.getInstance().getOneAllBody().readString();
        html = Kmu.replaceAll(html, "${oneAllCallbackUrl}", MyUrls.getOneAllCallbackUrl());
        _oneAllBody.setValue(html);

        _oneAllGroup.show();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleForgotPassword()
    {
        String email = _emailField.getValue();
        ajax().hideAllErrors();

        _forgotPasswordEmailField.setValue(email);
        _forgotPasswordCard.ajaxPrintCard();
    }

    private void handleLogin()
    {
        MyLoginUtility.ajaxClearAutoLogin();
        _passwordField.ajaxClearFieldValue();

        ajaxHideAllErrors();
        validateLogin();
        checkErrors();
        ajaxSetEmailCookie();

        MyUser user = getUser();
        if ( user == null )
            return;

        String target = _targetQueryField.getValue();

        login(user);
        getLayout().ajaxRefreshHeader();
        startNextPage(target);
    }

    private void handleRequestResetPassword()
    {
        _forgotPasswordCard.ajaxHideAllErrors();
        _forgotPasswordCard.ajaxFocus();
        _forgotPasswordCard.validateAndCheck();

        MyTenant tenant = getCurrentTenant();
        String email = _forgotPasswordEmailField.getValue();

        MyUser user = getAccess().getUserDao().findEmail(tenant, email);
        if ( user == null )
            _forgotPasswordEmailField.addErrorAndCheck("No such user.");

        MyPasswordReset pr;
        pr = createPasswordReset(user);

        sendEmail(pr);
        ajaxShowSentMessage(pr);
        ajaxSetEmailCookie(email);
    }

    private void handleReturnToLogin()
    {
        preRenderOneAll();

        _forgotPasswordEmailField.ajaxClearFieldValue();
        _loginCard.ajaxPrintCard();
    }

    //##################################################
    //# validate
    //##################################################

    protected void validateLogin()
    {
        _loginCard.validate();
        if ( hasErrors() )
            return;

        String email = _emailField.getValue();
        String password = _passwordField.getValue();

        MyTenant tenant = getCurrentTenant();
        MyUser user = getAccess().getUserDao().findEmail(tenant, email);

        if ( user == null )
        {
            _emailField.addError("No such user.");
            return;
        }

        if ( !user.allowsLogin() )
        {
            _emailField.addError("Login is disabled.");
            return;
        }

        if ( !user.hasPassword(password) )
        {
            _passwordField.ajaxFocus();
            _passwordField.addError("Invalid.");
            return;
        }
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getUser()
    {
        MyTenant tenant = getCurrentTenant();
        String email = _emailField.getValue();

        return getAccess().getUserDao().findEmail(tenant, email);
    }

    private void login(MyUser user)
    {
        getAccess().getAutoLoginDao().deleteAllFor(user);

        boolean sticky = _stayLoggedInField.isChecked();
        if ( sticky )
            stickyLogin(user);
        else
            basicLogin(user);
    }

    private void stickyLogin(MyUser user)
    {
        MyAutoLogin auto;
        auto = new MyAutoLogin();
        auto.setUser(user);
        auto.daoAttach();

        MyLoginUtility.ajaxLogIn(auto);
    }

    private MyServerSession basicLogin(MyUser user)
    {
        return MyLoginUtility.ajaxLogIn(user);
    }

    private void startNextPage(String targetQuery)
    {
        ajax().updatePageSession();

        if ( Kmu.hasValue(targetQuery) )
        {
            ScEnterPageScript script;
            script = ajax().enterPage(targetQuery);
            script.setReplace();
            return;
        }

        MyPageLayout.getInstance().ajaxClearContent();
        MyAppNavigator.ajaxEnter();
    }

    private MyPasswordReset createPasswordReset(MyUser user)
    {
        MyPasswordReset e;
        e = new MyPasswordReset();
        e.setTenant(user.getTenant());
        e.setUser(user);
        e.daoAttach();
        return e;
    }

    private void sendEmail(MyPasswordReset pr)
    {
        String to = pr.getEmail();

        MyTenant tenant = getCurrentTenant();
        MyUser user = getAccess().getUserDao().findEmail(tenant, to);
        if ( user == null )
        {
            _emailField.addErrorAndCheck("We have no record of a user with that email.");
            return;
        }

        String app = MyConstantsIF.APPLICATION_NAME;
        String subject = Kmu.format("Password Reset Request");
        String url = pr.formatEntryUrl();

        KmHtmlBuilder msg;
        msg = new KmHtmlBuilder();
        msg.printfln("Hi %s,", user.getShortName());
        msg.printfln();
        msg.printfln("We received a request to reset your %s password. ", app);
        msg.printfln("If you did not send this request, simply ignore this email. ");
        msg.printfln("If you want to reset your password, click the link below.");
        msg.printfln();
        msg.printLink("Reset My Password", url);

        MyEmail e;
        e = new MyEmail();
        e.addToRecipient(to);
        e.setFromAddress(getFromAddress());
        e.setSubject(subject);
        e.addHtmlPart(msg.toString());
        e.markReady();
        e.daoAttach();
    }

    private void ajaxShowSentMessage(MyPasswordReset pr)
    {
        String email = pr.getEmail();
        String msg = Kmu.format("We have sent reset instructions to: %s.", email);

        _messageText.setValue(msg);
        _messageCard.ajaxPrintCard();
    }

    //##################################################
    //# email cookie
    //##################################################

    private String getEmailCookie()
    {
        return MyLoginUtility.getEmailCookie();
    }

    private void ajaxSetEmailCookie()
    {
        String email = _emailField.getValue();
        ajaxSetEmailCookie(email);
    }

    private void ajaxSetEmailCookie(String email)
    {
        MyLoginUtility.ajaxSetEmailCookie(email);
    }

    //##################################################
    //# support
    //##################################################

    private String getFromAddress()
    {
        return getProperties().getSendEmailFromAddress();
    }

}
