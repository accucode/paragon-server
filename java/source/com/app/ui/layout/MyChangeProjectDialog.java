package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScSimpleModelList;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaProject;
import com.app.ui.control.MyFormDialog;
import com.app.utility.MyAppNavigator;
import com.app.utility.MyGlobals;

public class MyChangeProjectDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScNotebook _notebook;
    private ScGroup    _recentTab;
    private ScGroup    _allTab;

    private ScSimpleModelList<MyProject> _recentList;

    private ScTextField                  _filterAllField;
    private ScSimpleModelList<MyProject> _allList;

    //##################################################
    //# constructor
    //##################################################

    public MyChangeProjectDialog()
    {
        install();

        setHeight(500);
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setLabel("Change Project");

        installBody();
        installFooter();
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.add(createNotebook());

        _allList.installFilterOn(_filterAllField);
    }

    //==================================================
    //= install :: notebook
    //==================================================

    private ScControl createNotebook()
    {
        ScNotebook e;
        e = new ScNotebook();
        e.css().fillOffset10();
        e.onTabPreRender(this::onTabPreRender);
        e.add(createRecentTab());
        e.add(createAllTab());
        e.setAutoFocusOnTabChange();
        e.setFlavorWide();
        _notebook = e;
        return e;
    }

    //==================================================
    //= install :: recent
    //==================================================

    private ScControl createRecentTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setLabel("Recent");
        e.setTitle("Recent Projects");
        e.setFlavorList();
        e.css().flexChildFiller();

        ScDiv body;
        body = e.getBody();
        body.css().auto();
        body.add(createRecentList());

        _recentTab = e;
        return e;
    }

    //==================================================
    //= install :: all
    //==================================================

    private ScControl createAllTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setLabel("All");
        e.setTitle("All Projects");
        e.setFlavorList();
        e.css().flexChildFiller();

        ScDiv header;
        header = e.showHeader();
        header.css().pad10();

        ScFieldTable fields;
        fields = header.addFieldTable();
        fields.add(createFilterField());

        ScDiv body;
        body = e.getBody();
        body.css().auto();
        body.add(createAllList());

        _allTab = e;
        return e;
    }

    //==================================================
    //= install :: footer
    //==================================================

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter().addButtonBox();
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScSimpleModelList<MyProject> createRecentList()
    {
        MyMetaProject x = MyProject.Meta;

        ScSimpleModelList<MyProject> e;
        e = new ScSimpleModelList<>();
        e.css().flexChildFiller();
        e.setKeyFunction(x.Uid);
        e.setTitleFunction(x.Name);
        e.setItemAction(newCheckedAction(this::handleSelect));
        _recentList = e;
        return e;
    }

    private ScControl createFilterField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Find");
        e.disableChangeTracking();
        _filterAllField = e;
        return e;
    }

    private ScSimpleModelList<MyProject> createAllList()
    {
        MyMetaProject x = MyProject.Meta;

        ScSimpleModelList<MyProject> e;
        e = new ScSimpleModelList<>();
        e.css().flexChildFiller();
        e.setKeyFunction(x.Uid);
        e.setTitleFunction(x.Name);
        e.setItemAction(newCheckedAction(this::handleSelect));
        _allList = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderAllTab();
    }

    private void onTabPreRender(ScControl e)
    {
        if ( e == _recentTab )
        {
            preRenderRecentTab();
            return;
        }

        if ( e == _allTab )
        {
            preRenderAllTab();
            return;
        }
    }

    private void preRenderRecentTab()
    {
        KmList<MyProject> v;
        v = getCurrentUser().getRecentProjects();
        v.sortOn(e -> e.getName());
        _recentList.setValues(v);
    }

    private void preRenderAllTab()
    {
        _allList.setValues(getProjectList());
    }

    //##################################################
    //# open
    //##################################################

    @Override
    public void ajaxOpen()
    {
        _notebook.setSelectedTab(_recentTab);
        super.ajaxOpen();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSelect()
    {
        String uid = getData().getStringArgument();
        MyProject project = getAccess().findProjectUid(uid);

        MyAppNavigator.ajaxSelectProject(project);

        ajaxClose();
    }

    //##################################################
    //# support
    //##################################################

    private KmList<MyProject> getProjectList()
    {
        MyUser u = getCurrentUser();
        if ( u == null )
            return new KmList<>();

        MyTenant tenant = getCurrentTenant();

        KmList<MyProject> v;
        v = tenant.getProjects().toList();
        v.sortOn(e -> e.getName().toLowerCase());
        v.retainIf(e -> isAvailableProject(e));
        return v;
    }

    private boolean isAvailableProject(MyProject p)
    {
        MyUser u = getCurrentUser();

        if ( !u.isEnabled() )
            return false;

        if ( !p.isEnabled() )
            return false;

        if ( u.allowsTenantAdmin() )
            return true;

        return p.hasMember(u);
    }

    private MyTenant getCurrentTenant()
    {
        return MyGlobals.getCurrentTenant();
    }

    private MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }
}
