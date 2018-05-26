package com.app.ui.page.guide;

import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.page.crud.blurb.MyBlurbListPage;
import com.app.ui.page.crud.customer.MyCustomerListPage;
import com.app.ui.page.crud.emailTemplate.MyEmailTemplateListPage;
import com.app.ui.page.crud.holiday.MyHolidayListPage;
import com.app.ui.page.crud.member.MyMemberListPage;
import com.app.ui.page.crud.priority.MyPriorityListPage;
import com.app.ui.page.crud.project.MyProjectListPage;
import com.app.ui.page.crud.projectOption.MySiteTypeListPage;
import com.app.ui.page.crud.projectVendor.MyVendorListPage;

public class MyProjectSetupAdvancedCard
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    private static final int GROUP_WIDTH = 215;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectSetupAdvancedCard()
    {
        ScDiv e;
        e = this;
        e.css().flexChildFiller().flexColumn().columnSpacer20().auto();

        installProjectSection(e);
        installElementsSection(e);
    }

    //##################################################
    //# install
    //##################################################

    private void installProjectSection(ScContainer root)
    {
        ScDiv e;
        e = addSectionTo(root, "Project");

        installProject(e);
        installMembers(e);
    }

    private void installElementsSection(ScContainer root)
    {
        ScDiv e;
        e = addSectionTo(root, "Elements");

        installCustomers(e);
        installSites(e);
        installMiscellaneous(e);
        installOther(e);
    }

    //==================================================
    //= install :: project
    //==================================================

    private void installProject(ScDiv root)
    {
        ScContainer box;
        box = addProjectGroupTo(root, "Project");
        box.addLink("Project List", MyProjectListPage.getInstance());
    }

    private void installMembers(ScDiv root)
    {
        ScContainer box;
        box = addProjectGroupTo(root, "Members");
        box.addLink("Members", MyMemberListPage.getInstance());
    }

    //==================================================
    //= install :: elements
    //==================================================

    private void installCustomers(ScDiv root)
    {
        ScContainer box;
        box = addElementGroupTo(root, "Customers");
        box.addLink("Customers", MyCustomerListPage.getInstance());
    }

    private void installSites(ScDiv root)
    {
        ScContainer box;
        box = addElementGroupTo(root, "Sites");
        box.addLink("Site Types", MySiteTypeListPage.getInstance());
        box.addLink("Site Group", MySiteTypeListPage.getInstance());
    }

    private void installMiscellaneous(ScDiv root)
    {
        ScContainer box;
        box = addElementGroupTo(root, "Miscellaneous");
        box.addLink("Vendors", MyVendorListPage.getInstance());
        box.addLink("Holidays", MyHolidayListPage.getInstance());
        box.addLink("Priorities", MyPriorityListPage.getInstance());
    }

    private void installOther(ScDiv root)
    {
        ScContainer box;
        box = addElementGroupTo(root, "Other");
        box.addLink("Blurbs", MyBlurbListPage.getInstance());
        box.addLink("Email Templates", MyEmailTemplateListPage.getInstance());
    }

    //##################################################
    //# support
    //##################################################

    private ScDiv addSectionTo(ScContainer root, String label)
    {
        ScDiv section;
        section = root.addDiv();
        section.css().flexColumn().gap10().setupGuideSection();

        section.addLabel(label).css().font24();

        ScDiv e;
        e = section.addDiv();
        e.css().flexRow().flexWrap().flexWrapAlignStart().postMargin20();
        return e;
    }

    private ScContainer addProjectGroupTo(ScDiv root, String title)
    {
        ScGroup group;
        group = root.addGroup(title);
        group.setFlavorSetupProject();
        group.css().flexChildStatic();

        group.style().width(GROUP_WIDTH);

        ScDiv body;
        body = group.getBody();
        body.css().pad().auto().noWrap();
        body.css().flexColumn().columnSpacer5();
        return body;
    }

    private ScContainer addElementGroupTo(ScDiv root, String title)
    {
        ScGroup group;
        group = root.addGroup(title);
        group.setFlavorSetupElement();
        group.css().flexChildStatic();

        group.style().width(GROUP_WIDTH);

        ScDiv body;
        body = group.getBody();
        body.css().pad().auto().noWrap();
        body.css().flexColumn().columnSpacer5();
        return body;
    }

}
