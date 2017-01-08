package com.app.ui.page.login;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScEnterPageScript;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.file.MyResourceFiles;
import com.app.model.MyAutoLogin;
import com.app.model.MyEmail;
import com.app.model.MyPasswordReset;
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
    //# constants
    //##################################################

    private static final String PARAM_QUERY = "q";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString       _targetQuery;

    private ScCard              _loginCard;
    private ScCard              _forgotPasswordCard;
    private ScCard              _messageCard;

    private ScTextField         _emailField;
    private ScTextField         _passwordField;
    private ScCheckboxField     _stayLoggedInField;

    private ScTextField         _forgotPasswordEmailField;
    private ScText              _messageBox;

    private ScGroup             _oneAllGroup;
    private ScLiteral           _oneAllBody;

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
        _targetQuery.setValue(q);

        ajaxEnter();
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        if ( _targetQuery.hasValue() )
            v.setValue(PARAM_QUERY, _targetQuery.getValue());
    }

    @Override
    public void applyBookmark(ScParameterList params)
    {
        String query = params.getValue(PARAM_QUERY);
        if ( Kmu.hasValue(query) )
            _targetQuery.setValue(query);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _targetQuery = new ScLocalString();
        _targetQuery.setAutoSave();

        root.css().fill().flexColumn().flexCrossAlignCenter();
        root.addFlexGap(100);

        installContentOn(root);
    }

    private void installContentOn(ScDiv col)
    {
        ScDiv row = col.addFlexRow();

        installFrameOn(row);
        installLogo(row);
    }

    private void installLogo(ScDiv root)
    {
        ScImage e;
        e = root.addImage();
        e.setSource(getThemeImageUrl("logo300.png"));
        e.style().size(300).marginLeft(50);
        e.css().backgroundBlack();
    }

    //==================================================
    //= frame
    //==================================================

    private void installFrameOn(ScContainer root)
    {
        ScCardFrame frame;
        frame = root.addCardFrame();
        frame.css().width350();

        installLoginCardOn(frame);
        installForgotPasswordCardOn(frame);
        installMessageCardOn(frame);
    }

    //==================================================
    //= frame :: login
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
        form.setSubmitAction(this::handleLogin);

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Log in");

        installLoginFormFields(group);
        installLoginFormFooter(group);
    }

    private void installLoginFormFields(ScGroup group)
    {
        _emailField = new ScTextField();
        _emailField.setLabel("Email");
        _emailField.setRequired();
        _emailField.setWidthFull();
        _emailField.disableChangeTracking();

        _passwordField = new ScPasswordField();
        _passwordField.setLabel("Password");
        _passwordField.setWidthFull();
        _passwordField.disableChangeTracking();

        ScFieldLayout fields;
        fields = group.getBody().addFieldLayout();
        fields.css().pad10();
        fields.add(_emailField);
        fields.add(_passwordField);

        ScLink link;
        link = fields.addLink("Forgot password?", this::handleForgotPassword);
        link.setNoFocus();
    }

    private void installLoginFormFooter(ScGroup group)
    {
        _stayLoggedInField = new ScCheckboxField();
        _stayLoggedInField.disableChangeTracking();

        ScDiv footer;
        footer = group.getFooter();
        footer.show();

        ScDiv row;
        row = footer.addFlexRow();
        row.css().flexAlignSpaced().flexCrossAlignCenter();
        row.css().pad();

        row.addSubmitButton("Sign In");
        row.addFlexChildFiller();
        row.add(_stayLoggedInField);
        row.addNonBreakingSpace();
        row.addTextSpan("Stay Signed In");
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
    //= frame :: forgot password
    //==================================================

    private void installForgotPasswordCardOn(ScCardFrame frame)
    {
        ScCard card;
        card = frame.addCard();

        ScForm form;
        form = card.addForm();
        form.setSubmitAction(this::handleRequestResetPassword);
        form.onEscape().run(newUncheckedAction(this::handleCancel));

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
        row = footer.addFlexRow();
        row.css().flexAlignSpaced().flexCrossAlignCenter().pad();
        row.addSubmitButton("Request Password Reset");
        row.addCancelButton(this::handleCancel);
    }

    //==================================================
    //= frame :: message
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
        button = footer.addButton("Ok", this::handleCancel);
        button.setFlavorPositive();
        button.css().width50();

        ScDiv body;
        body = group.getBody();
        body.css().height50().pad10();

        _messageBox = body.addText();
        _messageCard = card;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
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
        _passwordField.ajaxClearFieldValue();

        MyLoginUtility.ajaxClearAutoLogin();

        ajax().hideAllErrors();
        ajax().focusPage();

        _loginCard.validate();

        MyTenant tenant = getCurrentTenant();
        String email = _emailField.getValue();
        MyUser user = getAccess().getUserDao().findEmail(tenant, email);

        setEmailCookie(email);

        if ( user == null )
        {
            _emailField.error("No such user.");
            return;
        }

        if ( !user.allowsLogin() )
        {
            _emailField.error("Login is disabled.");
            return;
        }

        String pwd = _passwordField.getValue();

        if ( !user.hasPassword(pwd) )
        {
            _passwordField.ajaxFocus();
            _passwordField.error("Invalid.");
            return;
        }

        getAccess().getAutoLoginDao().deleteAllFor(user);

        boolean staySignedIn = _stayLoggedInField.isChecked();

        if ( staySignedIn )
        {
            MyAutoLogin auto;
            auto = new MyAutoLogin();
            auto.setUser(user);
            auto.daoAttach();

            MyLoginUtility.logIn(auto);
        }
        else
            MyLoginUtility.ajaxLogIn(user);

        getLayout().ajaxRefreshHeader();
        startNextPage();
    }

    private void handleRequestResetPassword()
    {
        _forgotPasswordCard.ajaxHideAllErrors();
        _forgotPasswordCard.ajaxFocus();
        _forgotPasswordCard.validate();

        MyTenant tenant = getCurrentTenant();
        String email = _forgotPasswordEmailField.getValue();

        MyUser user = getAccess().getUserDao().findEmail(tenant, email);
        if ( user == null )
            _forgotPasswordEmailField.error("No such user.");

        MyPasswordReset pr;
        pr = createPasswordReset(user);

        sendEmail(pr);
        showSentMessage(pr);
        setEmailCookie(email);
    }

    private void handleCancel()
    {
        preRenderOneAll();

        _forgotPasswordEmailField.ajaxClearFieldValue();
        _loginCard.ajaxPrintCard();
    }

    //##################################################
    //# support
    //##################################################

    private void startNextPage()
    {
        if ( _targetQuery.hasValue() )
        {
            ScEnterPageScript script;
            script = ajax().enterPage(_targetQuery.getValue());
            script.setReplace();

            _targetQuery.clearValue();
            return;
        }

        MyPageLayout.getInstance().ajaxClearContent();
        MyAppNavigator.ajaxEnter();
    }

    private String getEmailCookie()
    {
        return MyLoginUtility.getEmailCookie();
    }

    private void setEmailCookie(String email)
    {
        MyLoginUtility.ajaxSetEmailCookie(email);
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
            _emailField.error("We have no record of a user with that email.");
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

    private void showSentMessage(MyPasswordReset pr)
    {
        String email = pr.getEmail();

        _messageBox.setValue("We have sent reset instructions to: " + email);
        _messageBox.ajaxUpdateFieldValues();

        _messageCard.ajaxPrintCard();
    }

    private String getFromAddress()
    {
        return getProperties().getSendEmailFromAddress();
    }

}
