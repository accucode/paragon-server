package com.app.ui.page.manage.project;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScNotebook;

import com.app.model.MyProject;
import com.app.model.meta.MyMetaProject;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.manage.crud.MyCrudLayout;
import com.app.ui.page.manage.crud.MyCrudViewCard;

public class MyProjectViewCard
    extends MyCrudViewCard<MyProject>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectViewCard()
    {
        super(new MyProjectBuilder());
    }

    public MyProjectViewCard(MyProjectBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.fill;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        ScNotebook book;
        book = root.addNotebook();
        book.flexFill();
        book.add(createDetailsTab());
    }

    //==================================================
    //= details tab
    //==================================================

    private ScDiv createDetailsTab()
    {
        ScDiv tab;
        tab = new ScDiv();
        tab.setLabel("Project");

        ScGroup group;
        group = tab.addGroup("Details");
        group.setFlavorSecondary();
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().gap20().auto();

        installGeneralOn(body);
        installBusinessHoursOn(body);
        installSupportOn(body);

        return tab;
    }

    private void installGeneralOn(ScDiv body)
    {
        MyMetaProject x = MyProject.Meta;

        ScDiv activeRow;
        activeRow = new ScDiv();
        activeRow.setLabel("Active");
        activeRow.addFieldText(x.Active);
        activeRow.addSpace();
        activeRow.addLink("toggle", this::handleToggleActive);

        ScFieldset set;
        set = body.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addFieldText(x.Name);
        fields.addFieldText(x.Code);
        fields.addSpace();
        fields.addFieldText(x.CompanyName);
        fields.add(activeRow);
    }

    private void installBusinessHoursOn(ScDiv body)
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldset set;
        set = body.addFieldset("Business Hours");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addFieldText(x.BusinessDays, "Days");
        fields.addFieldText(x.BusinessStartTime, "Start Time");
        fields.addFieldText(x.BusinessEndTime, "End Time");
    }

    private void installSupportOn(ScDiv body)
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldset set;
        set = body.addFieldset("Support");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addFieldText(x.SendEmailFrom);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyProject project)
    {
        super.preRenderDetails(project);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleActive()
    {
        MyProject e;
        e = getDomainChild();
        e.toggleActive();

        String name = e.getName();
        String active = e.isActive()
            ? "active"
            : "inactive";

        ajaxToast("%s in now %s.", name, active);
        ajaxRefresh();
        fireChildChanged(getDomainChild());

        MyPageLayout.getInstance().ajaxRefreshHeader();
    }
}
