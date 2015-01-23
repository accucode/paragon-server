package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScPushPageScript;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyAutoSignIn;
import com.app.model.MyUser;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyNavigator;

public class MySignInPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySignInPage instance = new MySignInPage();

    private MySignInPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString                _targetQuery;

    private ScForm                       _form;
    private ScTextField                  _emailField;
    private ScTextField                  _passwordField;
    private ScCheckboxField              _staySignedInField;

    private MyRequestPasswordResetDialog _resetDialog;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.any;
    }

    //##################################################
    //# navigation
    //##################################################

    public void pushForWindowQuery()
    {
        String q = getData().getWindowQuery();
        ajaxPushForQuery(q);
    }

    public void ajaxPushForQuery(String e)
    {
        _targetQuery.setValue(e);
        _ajaxPush();
    }

    @Override
    public ScParameterList composeQueryParameters()
    {
        ScParameterList v;
        v = new ScParameterList();

        if ( _targetQuery.hasValue() )
            v.setValue("q", _targetQuery.getValue());

        return v;
    }

    @Override
    public void applyQueryParameters(ScParameterList params)
    {
        String query = params.getValue("q");
        if ( Kmu.hasValue(query) )
            _targetQuery.setValue(query);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill();

        _targetQuery = new ScLocalString();
        _targetQuery.setAutoSave();

        ScFlexbox col;
        col = root.addColumn();
        col.crossAlignCenter();
        col.css().fill();
        col.addFiller();

        installContentOn(col);

        col.addFiller(2);

        installPasswordResetDialog();
    }

    private void installContentOn(ScFlexbox col)
    {
        ScFlexbox row;
        row = col.addRow();
        installForm(row);
        installLogo(row);
    }

    private void installForm(ScContainer root)
    {
        _staySignedInField = new ScCheckboxField();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSignIn);
        form.style().width(300);
        _form = form;

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Sign In");

        installFormFields(group);
        installFormFooter(group);
    }

    private void installLogo(ScFlexbox root)
    {
        ScImage e;
        e = root.addImage();
        e.setSource(getThemeImageUrl("logo300.png"));
        e.style().size(300).marginLeft(50);
    }

    private void installFormFields(ScGroup group)
    {
        _emailField = new ScTextField();
        _emailField.setRequired();
        _emailField.setWidthFull();

        _passwordField = new ScPasswordField();
        _passwordField.setWidthFull();

        ScBox box;
        box = group.getBody().addBox();
        box.css().gap10x2();
        box.addLabel("Email");
        box.addErrorBox().add(_emailField);

        ScDiv right;
        right = box.addBox().addFloatRight();

        box.addBreak();
        box.addLabel("Password");
        box.addErrorBox().add(_passwordField);

        right = box.addBox().addFloatRight();

        ScLink link;
        link = right.addLink("Forgot password?", this::handleForgotPassword);
        link.setNoFocus();

        box.addBreak();
    }

    private void installFormFooter(ScGroup group)
    {
        ScDiv footer;
        footer = group.getFooter();
        footer.show();

        ScFlexbox flex;
        flex = footer.addRow();
        flex.alignSpaced();
        flex.crossAlignCenter();
        flex.css().pad();

        flex.addSubmitButton("Sign In");
        flex.addFiller();
        flex.add(_staySignedInField);
        flex.addNonBreakingSpace();
        flex.addTextSpan("Stay Signed In");
    }

    private void installPasswordResetDialog()
    {
        _resetDialog = new MyRequestPasswordResetDialog();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        _emailField.setValue(getEmailCookie());
        _passwordField.clearText();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleForgotPassword()
    {
        String email = _emailField.getValue();
        ajax().hideAllErrors();

        _resetDialog.ajaxOpen(email);
    }

    private void handleSignIn()
    {
        _passwordField.ajax().clearValue();

        MySignInUtility.clearAutoSignIn();

        ajax().hideAllErrors();
        ajax().focusPage();

        _form.validate();

        String email = _emailField.getValue();
        MyUser user = getAccess().getUserDao().findEmail(email);

        setEmailCookie(email);

        if ( user == null )
        {
            _emailField.addError("No such user.");
            throw newCancel();
        }

        if ( !user.isVerified() )
        {
            _emailField.addError("Not yet activated.");
            throw newCancel();
        }

        String pwd = _passwordField.getValue();

        if ( !user.hasPassword(pwd) )
        {
            _passwordField.ajax().focus();
            _passwordField.addError("Invalid.");
            throw newCancel();
        }

        getAccess().getAutoSignInDao().deleteAllFor(user);

        boolean staySignedIn = _staySignedInField.isTrue();

        if ( staySignedIn )
        {
            MyAutoSignIn auto;
            auto = new MyAutoSignIn();
            auto.setUser(user);
            auto.saveDao();

            MySignInUtility.signIn(auto);
        }
        else
            MySignInUtility.signIn(user);

        getLayout().ajaxRefreshHeaderContent();

        startNextPage();
    }

    //##################################################
    //# support
    //##################################################

    private void startNextPage()
    {
        if ( _targetQuery.hasValue() )
        {
            ScPushPageScript script;
            script = ajax().pushPage(_targetQuery.getValue());
            script.setReplace();

            _targetQuery.clearValue();
            return;
        }

        MyPageLayout.getInstance().ajaxClearContent();
        MyNavigator.pushDefaultPage();
    }

    private String getEmailCookie()
    {
        return MySignInUtility.getEmailCookie();
    }

    private void setEmailCookie(String email)
    {
        MySignInUtility.setEmailCookie(email);
    }
}
