package com.app.ui.page.manage.project;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyProjectCriteria;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaProject;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.manage.crud.MyCrudAddCard;
import com.app.ui.page.manage.crud.MyCrudLayout;
import com.app.utility.MyGlobals;

public class MyProjectAddCard
    extends MyCrudAddCard<MyTenant,MyProject>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScTextField _emailField;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectAddCard()
    {
        super(new MyProjectBuilder());
    }

    public MyProjectAddCard(MyProjectBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        installGeneralOn(root);
    }

    private void installGeneralOn(ScDiv root)
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.css().widthFull();
        fields.add(createNameField());
        fields.addFieldFull(x.Code);
        fields.addSpace();
        fields.addFieldFull(x.CompanyName);
        fields.add(createEmailField());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScTextField createNameField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.Name.newField();
        e.setWidthFull();
        _nameField = e;
        return e;
    }

    private ScTextField createEmailField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.SendEmailFrom.newField();
        e.setWidthFull();
        _emailField = e;
        return e;
    }

    //##################################################
    //# pre render
    //##################################################

    @Override
    protected void preRenderDetails(MyTenant parent)
    {
        super.preRenderDetails(parent);

        String email = MyGlobals.getProperties().getSendEmailFromAddress();
        _emailField.setValue(email);
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyProject saveNewChildOn(MyTenant nullParent)
    {
        String name = _nameField.getValue();
        MyTenant tenant = MyGlobals.getCurrentTenant();

        MyProjectCriteria c;
        c = getAccess().getProjectDao().createCriteria();
        c.whereTenantIs(tenant);
        c.whereName().is(name);

        if ( c.exists() )
            _nameField.error("Project with that name already exists.");

        MyProject e;
        e = tenant.addProject();
        e.applyFrom(this);
        e.daoAttach();

        MyUser user = MyGlobals.getCurrentUser();
        if ( !user.hasLastProject() )
            user.setLastProject(e);

        MyPageLayout.getInstance().ajaxRefreshHeader();

        return e;
    }
}
