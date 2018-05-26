package com.app.ui.page.crud.abstractBase;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.ScBookmark;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.MyGlobalSession;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.MyPage;
import com.app.utility.MyAppNavigator;
import com.app.utility.MyGlobals;
import com.app.utility.MyUtility;

/**
 * I manage a page that shows a list of children, and coordinates
 * the ability to ADD, EDIT, and VIEW those children.
 *
 * I manage a bookmark based on the child's uid, allowing the
 * user to return to a previously selected child.
 *
 * @param <P> The domain PARENT.
 * @param <C> The domain CHILD.
 */
public abstract class MyCrudListPage<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends MyPage
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The builder used to coordinate the major crud views.
     */
    private MyCrudBuilder<P,C> _crudBuilder;

    /**
     * The crud's list view, that coordinates the list of children
     * as well as the frame for add, view, edit and delete.
     */
    private MyCrudListView<P,C> _view;

    /**
     * The uid of the domain child.
     */
    private ScLocalString _domainChildUid;

    /**
     * Should we view a list of children for the parent,
     * or attempt to view a single child. The default is to
     * show the list. Even when viewing a single child, the
     * list is merely collapsed, it can still be expanded
     * by the user upon
     */
    private ScLocalBoolean _listCollapsed;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudListPage(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;
    }

    protected MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# domain parent
    //##################################################

    /**
     * Return the domain parent.  This is used to find a list of children,
     * and also to add new children.
     */
    protected abstract P getDomainParent();

    //##################################################
    //# domain child
    //##################################################

    protected C getDomainChild()
    {
        String uid = getDomainChildUid();
        return getCrudBuilder().findChild(uid);
    }

    private String getDomainChildUid()
    {
        return _domainChildUid.getValue();
    }

    protected void setDomainChild(C child)
    {
        if ( child == null )
        {
            _domainChildUid.clearValue();
            return;
        }

        P newParent = getCrudBuilder().getParentFor(child);
        P oldParent = getDomainParent();

        if ( oldParent != null )
            if ( !Kmu.isEqual(newParent, oldParent) )
            {
                _domainChildUid.clearValue();
                return;
            }

        _domainChildUid.setValue(child.getUid());
    }

    protected boolean hasDomainChild()
    {
        return getDomainChild() != null;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public String getTitle()
    {
        return getCrudBuilder().getChildLabel() + " List";
    }

    @Override
    public String getHelpMessage()
    {
        return getCrudBuilder().getChildHelp();
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public MyCrudListBookmark newBookmark()
    {
        return new MyCrudListBookmark(this);
    }

    private MyCrudListBookmark castBookmark(ScBookmark e)
    {
        return (MyCrudListBookmark)e;
    }

    @Override
    protected void readStateFrom(ScBookmark o)
    {
        super.readStateFrom(o);

        MyCrudListBookmark e = castBookmark(o);
        C child = getChildFor(e);

        boolean single = child == null
            ? false
            : e.getSingle();

        checkCurrentProjectFor(child);
        setDomainChild(child);
        setListCollapsed(single);
    }

    @Override
    public void writeStateTo(ScBookmark o)
    {
        super.writeStateTo(o);

        MyCrudListBookmark e;
        e = castBookmark(o);
        e.setChildUid(getDomainChildUid());
        e.setSingle(isListCollapsed());
    }

    private C getChildFor(MyCrudListBookmark b)
    {
        String uid = b.getChildUid();
        if ( uid == null )
            return null;

        C child = getCrudBuilder().findChild(uid);
        if ( child == null )
            return null;

        MyTenant childTenant = MyUtility.getTenantFor(child);
        MyTenant currentTenant = getCurrentTenant();
        if ( !Kmu.isEqual(childTenant, currentTenant) )
            return null;

        return child;
    }

    protected boolean checksCurrentProject()
    {
        return true;
    }

    private void checkCurrentProjectFor(C child)
    {
        if ( !checksCurrentProject() )
            return;

        MyProject childProject = MyUtility.getProjectFor(child);
        MyProject currentProject = getCurrentProject();

        // Child has no project.
        if ( childProject == null )
            return;

        // Child's project is the current project.
        if ( childProject.equals(currentProject) )
            return;

        // User has access to child's project
        if ( childProject.hasMember(getCurrentUser()) )
        {
            selectProject(childProject);
            return;
        }

        // User doesn't have access to child's project, send to dashboard.
        MyAppNavigator.ajaxEnter();
    }

    private void selectProject(MyProject project)
    {
        MyGlobalSession gs;
        gs = MyGlobals.getGlobalSession();
        gs.setCurrentProject(project);

        MyUser user;
        user = getCurrentUser();
        user.selectProject(project);

        MyPageLayout layout;
        layout = MyPageLayout.getInstance();
        layout.ajaxRefreshHeader();
        layout.ajaxRefreshMenu();
    }

    public String formatEntryUrlFor(C child)
    {
        MyTenant tenant = MyUtility.getTenantFor(child);
        if ( tenant == null )
            throw Kmu.newFatal("Cannot determine tenant.");

        MyCrudListBookmark b;
        b = newBookmark();
        b.setChildUidFor(child);
        b.setSingle(true);
        return b.formatEntryUrlFor(tenant);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();

        _listCollapsed = new ScLocalBoolean(false);
        _listCollapsed.setAutoSave();

        _view = getCrudBuilder().getListView();
        _view.css().fill();
        _view.onSelected(this::handleSelected);
        _view.onExpanded(this::handleExpanded);

        root.css().fill();
        root.add(_view.asControl());
    }

    //##################################################
    //# enter
    //##################################################

    public void ajaxEnterChild(C child)
    {
        checkCurrentProjectFor(child);

        setDomainChild(child);
        setListCollapsed(true);
        ajaxEnter();
    }

    //##################################################
    //# single
    //##################################################

    public boolean isListCollapsed()
    {
        return _listCollapsed.isTrue();
    }

    public void setListCollapsed(boolean e)
    {
        _listCollapsed.setValue(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        P p = getDomainParent();
        C c = getCrudBuilder().findChild(_domainChildUid);

        if ( isListCollapsed() )
            _view.setSingleDomainChild(c);
        else
            _view.setDomain(p, c);
    }

    //##################################################
    //# callbacks
    //##################################################

    private void handleSelected(C child)
    {
        setDomainChild(child);
        ajax().replaceHistory(this);
    }

    private void handleExpanded(boolean expanded)
    {
        setListCollapsed(!expanded);
        ajax().replaceHistory(this);
    }
}
