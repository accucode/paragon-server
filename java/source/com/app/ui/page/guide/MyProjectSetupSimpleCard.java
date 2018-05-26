package com.app.ui.page.guide;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;

public class MyProjectSetupSimpleCard
    extends ScDiv
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectSetupSimpleCard()
    {
        ScDiv e;
        e = this;
        e.css().flexChildFiller().flexColumn().columnSpacer20().auto();

        installProjectSection(e);
        installElementsSection(e);
        installProcessSection(e);
    }

    //==================================================
    //= install :: project
    //==================================================

    private void installProjectSection(ScContainer root)
    {
        ScDiv e;
        e = addSectionTo(root, "Project");
        e.add(createProjectDetailsItem());
        e.add(createMembersItem());
    }

    private ScControl createProjectDetailsItem()
    {
        String label = "Project Details";
        String description = "Configure advanced project details.";
        ScAction action = newUncheckedAction(this::handleProjectDetails);

        return createProjectSectionItem(label, description, action);
    }

    private ScControl createMembersItem()
    {
        String label = "Members";
        String description = "Who has access to this project.";
        ScAction action = newUncheckedAction(this::handleMembers);

        return createProjectSectionItem(label, description, action);
    }

    //==================================================
    //= install :: elements
    //==================================================

    private void installElementsSection(ScContainer root)
    {
        ScDiv e;
        e = addSectionTo(root, "Elements");
        e.add(createCustomerItem());
        e.add(createSiteItem());
    }

    private ScControl createCustomerItem()
    {
        String label = "Customers";
        String description = "Who you are doing work for.";

        ScAction action = newUncheckedAction(this::handleCustomers);

        return createElementsSectionItem(label, description, action);
    }

    private ScControl createSiteItem()
    {
        String label = "Sites";
        String description = "Sites are you customers' locations";

        ScAction action = newUncheckedAction(this::handleSites);

        return createElementsSectionItem(label, description, action);
    }

    //==================================================
    //= install :: processes
    //==================================================

    private void installProcessSection(ScContainer root)
    {
        ScDiv e;
        e = addSectionTo(root, "Processes");
        e.add(createEmailTemplatesItem());
        e.add(createBlurbsItem());
    }

    private ScControl createEmailTemplatesItem()
    {
        String label = "Email Templates";
        String description = "Create templates for emails.";

        ScAction action = newUncheckedAction(this::handleEmailTemplates);

        return createProcessSectionItem(label, description, action);
    }

    private ScControl createBlurbsItem()
    {
        String label = "Blurbs";
        String description = "Create templates for documents.";

        ScAction action = newUncheckedAction(this::handleBlurbs);

        return createProcessSectionItem(label, description, action);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleProjectDetails()
    {
        MyProjectDetailsSetupGuidePage.getInstance().ajaxEnter();
    }

    private void handleMembers()
    {
        MyMemberSetupGuidePage.getInstance().ajaxEnter();
    }

    private void handleSites()
    {
        MySiteSetupGuidePage.getInstance().ajaxEnter();
    }

    private void handleCustomers()
    {
        MyCustomerSetupGuidePage.getInstance().ajaxEnter();
    }

    private void handleEmailTemplates()
    {
        MyEmailTemplateSetupGuidePage.getInstance().ajaxEnter();
    }

    private void handleBlurbs()
    {
        MyBlurbSetupGuidePage.getInstance().ajaxEnter();
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
        e.css().flexRow().flexCrossAlignStart().flexWrap().flexWrapAlignStart().postMargin20();
        return e;
    }

    private ScControl createProjectSectionItem(String label, String description, ScAction action)
    {
        ScDiv e;
        e = newItem(label, description, action);
        e.css().setupGuideProjectItem();
        return e;
    }

    private ScControl createElementsSectionItem(String label, String description, ScAction action)
    {
        ScDiv e;
        e = newItem(label, description, action);
        e.css().setupGuideElementItem();
        return e;
    }

    private ScControl createProcessSectionItem(String label, String description, ScAction action)
    {
        ScDiv e;
        e = newItem(label, description, action);
        e.css().setupGuideProcessItem();
        return e;
    }

    private ScDiv newItem(String label, String description, ScAction action)
    {
        ScDiv e;
        e = new ScDiv();
        e.css().setupGuideHomeItem().setupGuideItem().marginRight20().flexChildStatic();
        e.setOnClick(action);

        ScDiv labelDiv;
        labelDiv = e.addLabel(label);
        labelDiv.css().font24().marginBottom10();

        ScDiv descriptionDiv;
        descriptionDiv = e.addDiv();
        descriptionDiv.addText(description);
        descriptionDiv.css().textAlignCenter();

        return e;
    }
}
