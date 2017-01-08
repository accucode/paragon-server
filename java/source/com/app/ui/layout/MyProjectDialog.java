package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScSimpleModelList;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaProject;
import com.app.ui.control.MyDialog;
import com.app.utility.MyAppNavigator;
import com.app.utility.MyGlobals;

public class MyProjectDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField                  _filterField;
    private ScSimpleModelList<MyProject> _projectList;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectDialog()
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
        body.css().flexColumn();

        installListHeaderOn(body);
        installListBodyOn(body);

        _projectList.installFilterOn(_filterField);
    }

    private void installListHeaderOn(ScDiv body)
    {
        ScDiv header;
        header = body.addDiv();
        header.css().flexRow().flexAlignSpaced().flexCrossAlignCenter();
        header.css().pad10().backgroundGrayEEE();

        ScDiv left;
        left = header.addDiv();
        left.addBold("Find: ");
        left.add(createFilterField());
    }

    private void installListBodyOn(ScDiv body)
    {
        body.addFlexGap(5);
        body.add(createList());
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter().addButtonBox();
        footer.addCancelButton(this::ajaxClose);
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createFilterField()
    {
        ScTextField e;
        e = new ScTextField();
        e.disableChangeTracking();
        _filterField = e;
        return e;
    }

    private ScSimpleModelList<MyProject> createList()
    {
        MyMetaProject x = MyProject.Meta;

        ScSimpleModelList<MyProject> e;
        e = new ScSimpleModelList<>();
        e.css().flexChildFiller();
        e.setKeyFunction(x.Uid);
        e.setTitleFunction(x.Name);
        e.setItemAction(this::handleSelect);
        _projectList = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        _projectList.setValues(getProjectList());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSelect()
    {
        getAccess().flush();

        String uid = getData().getStringArgument();
        MyAppNavigator.selectProject(uid);

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
        v.retainIf(e -> isProjectAvailable(e));
        return v;
    }

    private boolean isProjectAvailable(MyProject p)
    {
        MyUser u = getCurrentUser();

        if ( !u.isActive() )
            return false;

        if ( !p.isActive() )
            return false;

        return true;
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
