package com.app.ui.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.MyGlobalSession;
import com.kodemore.servlet.control.ScClockField;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScContainerLink;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public class MyPageHeader
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    //==================================================
    //= left
    //==================================================

    /**
     * This is the box we put the logo and app title in.
     */
    private ScLiteral              _leftDiv;

    //==================================================
    //= middle
    //==================================================

    private ScLink                 _projectLink;

    private ScContainerLink        _clockContainer;
    private ScClockField           _clockField;
    private ScTextSpan             _timeZoneText;

    private ScLink                 _userLink;

    //==================================================
    //= right
    //==================================================

    private MyProjectDialog        _projectDialog;
    private MyTimeZoneDialog       _timeZoneDialog;
    private MyChangePasswordDialog _changePasswordDialog;

    private MyUserDialog           _userDialog;

    //##################################################
    //# constructor
    //##################################################

    public MyPageHeader()
    {
        setHtmlId(KmCssDefaultConstantsIF.ID_header);

        installLayout();
        installDialogs();
    }

    //##################################################
    //# install
    //##################################################

    private void installLayout()
    {
        ScDiv root = this;

        installLeftOn(root);
        installMiddleOn(root);
        installRightOn(root);
    }

    private void installLeftOn(ScDiv root)
    {
        _leftDiv = root.addLiteral();
    }

    //==================================================
    //= install :: middle
    //==================================================

    private void installMiddleOn(ScDiv root)
    {
        ScDiv box;
        box = root.addDiv();
        box.css().header_middle();

        box.add(createProjectLink());
        box.add(createClockLink());
    }

    private ScLink createProjectLink()
    {
        ScLink link;
        link = new ScLink();
        link.setAction(this::handleChangeProject);
        link.css().header_project();
        link.hide();
        _projectLink = link;
        return link;
    }

    private ScContainerLink createClockLink()
    {
        ScContainerLink link;
        link = new ScContainerLink();
        link.setAction(this::handleChangeClock);
        link.css().header_clock();
        link.hide();
        _clockContainer = link;

        ScContainer box;
        box = link.getContainer();
        box.add(createClockField());
        box.addNonBreakingSpace();
        box.add(createTimeZoneText());

        return link;
    }

    private ScClockField createClockField()
    {
        ScClockField e;
        e = new ScClockField();
        e.css().header_time();
        _clockField = e;
        return e;
    }

    private ScTextSpan createTimeZoneText()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().header_timeZone();
        _timeZoneText = e;
        return e;
    }

    //==================================================
    //= install :: right
    //==================================================

    private void installRightOn(ScDiv root)
    {
        ScDiv div;
        div = root.addDiv();
        div.css().header_right();

        div.add(createUserLink());
    }

    private ScLink createUserLink()
    {
        ScLink link;
        link = new ScLink();
        link.setAction(this::handleUserActions);
        link.css().header_user();
        link.hide();
        _userLink = link;
        return link;
    }

    //==================================================
    //= install :: dialogs
    //==================================================

    private void installDialogs()
    {
        _projectDialog = new MyProjectDialog();
        _timeZoneDialog = new MyTimeZoneDialog();
        _changePasswordDialog = new MyChangePasswordDialog();

        _userDialog = new MyUserDialog();
        _userDialog.onChangePassword(this::handleChangePassword);
    }

    //##################################################
    //# ajax refresh
    //##################################################

    public void ajaxRefresh(boolean show)
    {
        if ( show )
            ajaxShowHeader();
        else
            ajaxHideHeader();
    }

    private void ajaxShowHeader()
    {
        ajaxRefreshContent();
        ajaxShow();
    }

    private void ajaxHideHeader()
    {
        ajaxHide();
    }

    public void ajaxRefreshContent(boolean show)
    {
        ajaxShow(show);
        ajaxRefreshContent();
    }

    public void ajaxRefreshContent()
    {
        updateContents();
        ajaxReplaceContents();
    }

    //##################################################
    //# update
    //##################################################

    private void updateContents()
    {
        updateLogo();
        updateProject();
        updateClock();
        updateTimeZone();
        updateUser();
    }

    //==================================================
    //= update :: logo
    //==================================================

    private void updateLogo()
    {
        KmHtmlBuilder out = new KmHtmlBuilder();

        String tenantName = getCurrentTenant().getName();
        String appName = MyConstantsIF.APPLICATION_NAME;

        out.open("div");
        out.printAttribute("class", "header-left");
        out.close();

        out.open("a");
        out.printAttribute("class", KmCssDefaultConstantsIF.header_logoImage);
        out.printAttribute("href", MyUrls.getEntryUrl());
        out.close();

        out.open("img");
        out.printAttribute("class", KmCssDefaultConstantsIF.header_logoImage);
        out.printAttribute("src", ScUrls.getThemeImage("logo35.png"));
        out.printAttribute("width", 35);
        out.printAttribute("height", 35);
        out.close();

        out.beginSpanCss(KmCssDefaultConstantsIF.header_logoText);
        out.printf("%s - %s", appName, tenantName);
        out.endSpan();

        out.end("a");
        out.end("div");

        _leftDiv.setValue(out);
    }

    //==================================================
    //= update :: project
    //==================================================

    private void updateProject()
    {
        _projectLink.show(showsProject());
        _projectLink.setText(formatProjectName());
    }

    private boolean showsProject()
    {
        return hasCurrentUser() && hasCurrentTenant() && getCurrentTenant().hasProjects();
    }

    private String formatProjectName()
    {
        MyProject e = getCurrentProject();
        return e == null
            ? "<none>"
            : e.getName();
    }

    //==================================================
    //= update :: clock
    //==================================================

    private void updateClock()
    {
        _clockContainer.hide();
        _clockField.hide();

        if ( !hasCurrentUser() )
            return;

        _clockContainer.show();
        _clockField.show();
        _clockField.setTimeZone(getCurrentUser().getTimeZone());
    }

    //==================================================
    //= update :: time zone
    //==================================================

    private void updateTimeZone()
    {
        _timeZoneText.hide();

        if ( !showsTimeZone() )
            return;

        _timeZoneText.setValue(formatTimeZone());
        _timeZoneText.show();
    }

    private boolean showsTimeZone()
    {
        return hasCurrentUser();
    }

    private String formatTimeZone()
    {
        return Kmu.format("(%s)", getCurrentUser().getTimeZone().getName());
    }

    //==================================================
    //= update :: user
    //==================================================

    private void updateUser()
    {
        _userLink.setText(formatUserName());
        _userLink.show(getCurrentUser() != null);
    }

    private String formatUserName()
    {
        return hasCurrentUser()
            ? getCurrentUser().getShortName()
            : "<none>";
    }

    //##################################################
    //# handle
    //##################################################

    private void handleChangeProject()
    {
        _projectDialog.ajaxOpen();
    }

    private void handleChangeClock()
    {
        _timeZoneDialog.ajaxOpen();
    }

    private void handleUserActions()
    {
        _userDialog.ajaxOpen();
    }

    private void handleChangePassword()
    {
        _changePasswordDialog.ajaxOpen();
    }

    //##################################################
    //# support
    //##################################################

    private MyProject getCurrentProject()
    {
        return getPageSession().getCurrentProject();
    }

    private MyUser getCurrentUser()
    {
        return getServerSession().getUser();
    }

    private boolean hasCurrentUser()
    {
        return getCurrentUser() != null;
    }

    private MyTenant getCurrentTenant()
    {
        return getServerSession().getTenant();
    }

    public boolean hasCurrentTenant()
    {
        return getCurrentTenant() != null;
    }

    private MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }

    private MyGlobalSession getPageSession()
    {
        return MyGlobals.getGlobalSession();
    }
}
