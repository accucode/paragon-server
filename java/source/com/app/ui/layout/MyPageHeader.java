package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScDropdownMenu;
import com.kodemore.servlet.utility.ScUrls;

import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.page.general.MySignOutPage;
import com.app.ui.page.login.MySignInUtility;
import com.app.ui.page.userProfile.MyUserProfilePage;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyNavigator;
import com.app.utility.MyUrls;

public class MyPageHeader
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    /**
     * This is the box we put the logo and app title in.
     */
    private ScDiv          _leftDiv;

    /**
     * This is the box we put the project and user dropdowns in.
     */
    private ScDiv          _rightDiv;

    private ScDropdownMenu _userDropdown;
    private ScDropdownMenu _projectDropdown;
    private ScAction       _selectProjectAction;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setHtmlId("pageHeader");

        installLayout();
        installUserDropdown();
        installProjectDropdown();
    }

    private void installLayout()
    {
        _leftDiv = addDiv();
        _leftDiv.css().pageHeader_left();

        _rightDiv = addDiv();
        _rightDiv.css().pageHeader_right();
    }

    //==================================================
    //= install :: user dropdown
    //==================================================

    private void installUserDropdown()
    {
        _userDropdown = new ScDropdownMenu();
        _userDropdown.setTitle("User");
        _userDropdown.addItem("Profile", this::handleEditUserProfile);
        _userDropdown.addItem("Log out", this::handleLogout);
    }

    private void handleEditUserProfile()
    {
        MyUserProfilePage.instance.ajaxPush();
    }

    private void handleLogout()
    {
        MySignInUtility.signOut();
        MyPageLayout.getInstance().ajaxRefreshHeaderContent();
        MyPageLayout.getInstance().ajaxClearContent();
        MySignOutPage.instance.ajaxPush();
    }

    //==================================================
    //= install :: project dropdown
    //==================================================

    private void installProjectDropdown()
    {
        _selectProjectAction = createAction(this::handleSelectProject);

        _projectDropdown = new ScDropdownMenu();
        _projectDropdown.setTitle("Project");
    }

    //==================================================
    //= install :: select project
    //==================================================

    private ScAction getSelectProjectAction()
    {
        return _selectProjectAction;
    }

    private void handleSelectProject()
    {
        String uid = getData().getStringArgument();
        MyNavigator.selectProject(uid);
    }

    //==================================================
    //= refresh :: header
    //==================================================

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
        ajax().show();
    }

    private void ajaxHideHeader()
    {
        ajax().hide();
    }

    public void ajaxRefreshContent()
    {
        ajaxRefreshLeft();
        ajaxRefreshRight();
    }

    private void ajaxRefreshLeft()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderLogoOn(out);

        _leftDiv.ajax().setContents(out);
    }

    private void ajaxRefreshRight()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderProjectDropdownOn(out);
        renderUserDropdownOn(out);

        _rightDiv.ajax().setContents(out);
    }

    private void renderLogoOn(KmHtmlBuilder out)
    {
        out.open("a");
        out.printAttribute("id", "pageHeaderLink");
        out.printAttribute("href", MyUrls.getEntryUrl());
        out.close();

        out.open("img");
        out.printAttribute("id", "pageHeaderLogoImage");
        out.printAttribute("src", ScUrls.getThemeImage("logo35.png"));
        out.printAttribute("width", 35);
        out.printAttribute("height", 35);
        out.close();

        out.beginSpanId("pageHeaderLogoText");
        out.print(MyConstantsIF.APPLICATION_NAME);
        out.endSpan();

        out.end("a");
    }

    private void renderUserDropdownOn(KmHtmlBuilder out)
    {
        MyUser u = getCurrentUser();
        if ( u == null )
            return;

        _userDropdown.setTitle(u.getName());
        _userDropdown.renderOn(out);
    }

    private void renderProjectDropdownOn(KmHtmlBuilder out)
    {
        MyProject a = getCurrentProject();
        if ( a == null )
            return;

        _projectDropdown.setTitle(a.getName());
        _projectDropdown.clearItems();

        KmList<MyProject> v = getProjectOptions();
        for ( MyProject e : v )
            _projectDropdown.addItem(e.getName(), getSelectProjectAction(), e.getUid());

        _projectDropdown.renderOn(out);
    }

    private KmList<MyProject> getProjectOptions()
    {
        MyUser u = getCurrentUser();
        if ( u == null )
            return new KmList<>();

        KmList<MyProject> v;
        v = u.getProjects();
        v.sortOn(MyProject.Meta.Name);
        return v;
    }

    //##################################################
    //# support
    //##################################################

    private MyProject getCurrentProject()
    {
        return getServerSession().getCurrentProject();
    }

    private MyUser getCurrentUser()
    {
        return getServerSession().getUser();
    }

    private MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }
}
