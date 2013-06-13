package com.app.ui.activity.login;

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
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyAutoSignIn;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.activity.MyActivity;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletUtility;
import com.app.ui.layout.MyLeftMenu;
import com.app.ui.layout.MyPageLayout;

public class MySignInActivity
    extends MyActivity
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySignInActivity instance = new MySignInActivity();

    private MySignInActivity()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String          COOKIE_EMAIL = "email";

    //##################################################
    //# variables
    //##################################################

    private ScContainer                  _root;

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
    protected boolean requiresUser()
    {
        return false;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        ScContainer root;
        root = new ScSimpleContainer();

        ScArray row;
        row = root.addRow();
        row.setGap(50);
        row.style().marginCenter().marginTop(50);

        installForm(row);
        installLogo(row);

        installSignUpDialog(root);
        installPasswordResetDialog(root);

        _root = root;
    }

    private void installLogo(ScArray root)
    {
        ScImage e;
        e = root.addImage();
        e.setSource(getThemeImageUrl("logo300.png"));
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

    private void installFormFields(ScGroup group)
    {
        _emailField = new ScTextField();
        _emailField.setRequired();
        _emailField.setWidthFull();

        _passwordField = new ScPasswordField();
        _passwordField.setWidthFull();

        ScBox box;
        box = group.addBox();
        box.css().padSpaced10x2();
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

    @Override
    public void start()
    {
        if ( startAuto() )
            return;

        String email = getEmailCookie();
        _emailField.setValue(email);

        ajax().printMain(_root);
        ajax().focus();
    }

    private boolean startAuto()
    {
        MyAutoSignIn auto = MyServletUtility.getAutoSignIn();
        if ( auto == null )
            return false;

        MyUser user = auto.getUser();
        if ( !user.allowsLogin() )
            return false;

        signIn(user, auto);

        return true;
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

        MyServletUtility.ajaxClearAutoSignIn();

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

        signIn(user, auto);
    }

    //##################################################
    //# support
    //##################################################

    private void signIn(MyUser user, MyAutoSignIn auto)
    {
        MyServerSession ss;
        ss = MyServerSessionManager.login(user);
        ss.setAutoSignIn(auto);

        MyServletUtility.ajaxSetAutoSignIn(auto);

        MyPageLayout layout;
        layout = MyPageLayout.getInstance();
        layout.ajaxClearCenter();
        layout.ajaxRefreshHeader();

        MyLeftMenu menu;
        menu = MyLeftMenu.getInstance();
        menu.ajaxRefreshMenu();
        menu.gotoWindowLocation();
    }

    private String getEmailCookie()
    {
        return getData().getCookie(COOKIE_EMAIL);
    }

    public void setEmailCookie(String email)
    {
        ajax().setCookie(COOKIE_EMAIL, email);
    }

}
