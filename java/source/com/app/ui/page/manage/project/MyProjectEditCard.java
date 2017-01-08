package com.app.ui.page.manage.project;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyProjectCriteria;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.meta.MyMetaProject;
import com.app.ui.page.manage.crud.MyCrudEditCard;
import com.app.ui.page.manage.crud.MyCrudLayout;
import com.app.utility.MyGlobals;

public class MyProjectEditCard
    extends MyCrudEditCard<MyProject>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectEditCard()
    {
        super(new MyProjectBuilder());
    }

    public MyProjectEditCard(MyProjectBuilder e)
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
        root.css().flexColumn().columnSpacer10();

        installGeneralOn(root);
        installBusinessHoursOn(root);
        installSupportOn(root);
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
    }

    private void installSupportOn(ScDiv root)
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldset set;
        set = root.addFieldset("Support");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addField(x.SendEmailFrom);
    }

    private void installBusinessHoursOn(ScDiv root)
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldset set;
        set = root.addFieldset("Business Hours");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addField(x.BusinessDays, "Days");
        fields.addField(x.BusinessStartTime, "Start Time");
        fields.addField(x.BusinessEndTime, "End Time");
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

    //##################################################
    //# validate
    //##################################################

    @Override
    protected void validateDetails()
    {
        validateQuietly();
        validateNameQuietly();
        checkErrors();
    }

    private void validateNameQuietly()
    {
        ScTextField field = _nameField;

        String name = field.getValue();
        if ( field.hasErrors() )
            return;

        MyTenant tenant = MyGlobals.getCurrentTenant();

        MyProjectCriteria c;
        c = getAccess().getProjectDao().createCriteria();
        c.whereTenantIs(tenant);
        c.whereName().is(name);
        c.whereUid().isNot(getDomainChild().getUid());

        if ( c.exists() )
            field.addError("Duplicate.");
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected void updateDomainChild(MyProject e)
    {
        e.applyFrom(this);
    }

}
