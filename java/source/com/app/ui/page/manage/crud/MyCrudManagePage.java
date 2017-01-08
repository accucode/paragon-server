package com.app.ui.page.manage.crud;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.core.MyUidDomainIF;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyAppNavigator;
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
public abstract class MyCrudManagePage<P extends MyUidDomainIF, C extends MyUidDomainIF>
    extends MyPage
{
    //##################################################
    //# constants
    //##################################################

    /**
     * If provided as a query parameter, attempt to select the
     * associated model upon page entry.
     */
    private static final String   PARAM_UID = "uid";

    //##################################################
    //# variables
    //##################################################

    /**
     * The builder used to coordinate the major crud views.
     */
    private MyCrudBuilder<P,C>    _crudBuilder;

    /**
     * The uid of the domain child.
     */
    private ScLocalString         _domainChildUid;

    /**
     * The crud's list view, that coordinates the list of children
     * as well as the frame for add, view, edit and delete.
     */
    private MyCrudManageView<P,C> _view;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudManagePage(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;
    }

    protected final MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# domain
    //##################################################

    /**
     * Return the domain parent.  This is used to find a list of children,
     * and also to add new children.
     */
    protected abstract P getDomainParent();

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
    }

    @Override
    public String getTitle()
    {
        return Kmu.pluralize(getCrudBuilder().getChildLabel());
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
    public void composeBookmarkOn(ScParameterList v)
    {
        if ( _domainChildUid.hasValue() )
            v.setValue(PARAM_UID, _domainChildUid.getValue());
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        if ( v.hasValue(PARAM_UID) )
        {
            String uid = v.getValue(PARAM_UID);
            C child = getCrudBuilder().findChild(uid);

            if ( child != null )
            {
                _domainChildUid.setValue(uid);
                checkCurrentProjectFor(child);
            }
        }
    }

    private void checkCurrentProjectFor(C child)
    {
        MyProject childProject = MyUtility.getProjectFor(child);
        MyProject currentProject = getCurrentProject();

        // Child has no project.
        if ( childProject == null )
            return;

        // Child's project is the current project.
        if ( childProject.isSame(currentProject) )
            return;

        // User doesn't have access to child's project, send to dashboard.
        MyAppNavigator.ajaxEnter();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _domainChildUid = new ScLocalString();

        _view = getCrudBuilder().getManageView();
        _view.css().fill();
        _view.onSelected(this::handleSelected);

        root.css().fill();
        root.add(_view.asControl());
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        P p = getDomainParent();
        C c = getCrudBuilder().findChild(_domainChildUid);
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

    //##################################################
    //# support
    //##################################################

    protected void setDomainChild(C child)
    {
        if ( child == null )
        {
            _domainChildUid.clearValue();
            return;
        }

        P parent1 = getCrudBuilder().getParentFor(child);
        P parent2 = getDomainParent();

        if ( !Kmu.isEqual(parent1, parent2) )
        {
            _domainChildUid.clearValue();
            return;
        }

        _domainChildUid.setValue(child.getUid());
    }

}
