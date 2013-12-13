package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
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
import com.app.ui.page.MyPage;
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

    private ScLocalString                _queryTarget;

    private ScForm                       _form;
    private ScTextField                  _emailField;
    private ScTextField                  _passwordField;
    private ScCheckboxField              _staySignedInField;

    private MySignUpDialog               _signUpDialog;
    private MyRequestPasswordResetDialog _resetDialog;

    //##################################################
    //# setup
    //##################################################

    @Override
    public boolean requiresUser()
    {
        return false;
    }

    @Override
    protected boolean showsLeftMenu()
    {
        return false;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _queryTarget = new ScLocalString();
        _queryTarget.setAutoSave();

        ScArray row;
        row = root.addRow();
        row.setGap(50);
        row.style().marginCenter().marginTop(50);

        installForm(row);
        installLogo(row);
        installSignUpDialog(root);
        installPasswordResetDialog(root);
    }

    private void installForm(ScArray root)
    {
        _staySignedInField = new ScCheckboxField();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSignInAction());
        form.style().width(300).padTop(50);
        _form = form;

        ScGroup group;
        group = form.addGroup("Sign In");

        installFormFields(group);

        group.addDivider();

        installFormFooter(group);
    }

    private void installLogo(ScArray root)
    {
        ScBox box;
        box = root.addBox();
        box.style().width(300).padTop(75);
        box.css().middle();

        ScImage e;
        e = box.addImage();
        e.setSource(getThemeImageUrl("logo300.png"));
        e.style().width(300).height(300);
    }

    private void installFormFields(ScGroup group)
    {
        _emailField = new ScTextField();
        _emailField.setRequired();
        _emailField.setWidthFull();

        _passwordField = new ScPasswordField();
        _passwordField.setWidthFull();

        ScBox box;
        box = group.addBox();
        box.css().gap10x2();
        box.addLabel("Email");
        box.addErrorBox().add(_emailField);

        ScDiv right;
        right = box.addBox().addFloatRight();

        ScLink link;
        link = right.addLink("New user?", newUserDialogAction());
        link.setNoFocus();

        box.addLabel("Password");
        box.addErrorBox().add(_passwordField);

        right = box.addBox().addFloatRight();

        link = right.addLink("Forgot password?", newForgotPasswordAction());
        link.setNoFocus();

        box.addBreak();
    }

    private void installFormFooter(ScGroup group)
    {
        ScBox footer;
        footer = group.addBox();
        footer.css().pad();
        footer.addSubmitButton("Sign In");

        ScDiv right;
        right = footer.addFloatRight();
        right.add(_staySignedInField);
        right.addSpace();
        right.addText("Stay Signed In");
    }

    private void installSignUpDialog(ScContainer root)
    {
        _signUpDialog = new MySignUpDialog();

        root.add(_signUpDialog);
    }

    private void installPasswordResetDialog(ScContainer root)
    {
        _resetDialog = new MyRequestPasswordResetDialog();

        root.add(_resetDialog);
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSignInAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSignIn();
            }
        };
    }

    private ScActionIF newUserDialogAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleUserDialog();
            }
        };
    }

    private ScActionIF newForgotPasswordAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleForgotPassword();
            }
        };
    }

    //##################################################
    //# start
    //##################################################

    public void startForTarget(String e)
    {
        _queryTarget.setValue(e);
        start();
    }

    @Override
    protected void encodeParameters(ScParameterList params)
    {
        super.encodeParameters(params);

        if ( _queryTarget.hasValue() )
            params.setValue("q", _queryTarget.getValue());
    }

    @Override
    public void decodeParameters(ScParameterList params)
    {
        _queryTarget.clearValue();

        String s = params.getValue("q");
        if ( Kmu.isEmpty(s) )
            return;

        _queryTarget.setValue(s);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        _emailField.setValue(getEmailCookie());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleUserDialog()
    {
        String email = _emailField.getValue();

        ajax().hideAllErrors();

        _signUpDialog.start(email);
    }

    private void handleForgotPassword()
    {
        ajax().hideAllErrors();

        String email = _emailField.getValue();

        _resetDialog.start(email);
    }

    private void handleSignIn()
    {
        _passwordField.ajax().clearValue();

        MySignInUtility.clearAutoSignIn();

        ajax().hideAllErrors();
        ajax().focus();

        _form.validate();

        String email = _emailField.getValue();
        MyUser user = getAccess().getUserDao().findEmail(email);

        setEmailCookie(email);

        if ( user == null )
            _emailField.error("No such user.");

        if ( !user.isVerified() )
            _emailField.error("Not yet activated.");

        String pwd = _passwordField.getValue();

        if ( !user.hasPassword(pwd) )
        {
            _passwordField.ajax().focus();
            _passwordField.error("Invalid.");
        }

        MyAutoSignIn auto = null;
        boolean staySignedIn = _staySignedInField.isTrue();

        if ( staySignedIn )
        {
            auto = new MyAutoSignIn();
            auto.setUser(user);
            auto.saveDao();
        }

        MySignInUtility.signIn(user, auto);
        getPageLayout().ajaxRefresh();

        startNextPage();
    }

    //##################################################
    //# support
    //##################################################

    private void startNextPage()
    {
        if ( _queryTarget.hasValue() )
        {
            ScPushPageScript script;
            script = ajax().pushPage(_queryTarget.getValue());
            script.setReplace();
            return;
        }

        MyNavigator.startDefaultPage();
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