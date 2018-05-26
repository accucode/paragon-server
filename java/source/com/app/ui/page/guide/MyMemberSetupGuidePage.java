package com.app.ui.page.guide;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.page.crud.member.MyMemberListView;

public class MyMemberSetupGuidePage
    extends MyAbstractSetupGuidePage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyMemberSetupGuidePage _instance;

    public static void installInstance()
    {
        _instance = new MyMemberSetupGuidePage();
    }

    public static MyMemberSetupGuidePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "Member";
    }

    @Override
    protected ScPage getPreviousPage()
    {
        return MyProjectDetailsSetupGuidePage.getInstance();
    }

    @Override
    protected ScPage getNextPage()
    {
        return MyCustomerSetupGuidePage.getInstance();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installInstructionsOn(ScDiv body)
    {
        body.add(newInfoSection());
        body.add(newListSection(true));
    }

    @Override
    protected ScControl createInfoCard()
    {
        ScGroup e;
        e = new ScGroup();
        e.css().flexChildFiller();
        e.setFlavorSummary();
        e.setTitle("Info");

        ScDiv body;
        body = e.getBody();
        body.css().gap20().auto();

        body.add(
            new MySetupInfoItem(
                "Member",
                "Members are the people who have access to your project.",
                ""
                    + "You can choose which users have access to this project. You also define the "
                    + "role that member will have whithin the project. Members can be Managers, "
                    + "Workers, or Customers."));
        body.add(
            new MySetupInfoItem(
                "Managers",
                "These are the privileged members that manage the project.",
                ""
                    + "Managers have highest level of access to the project. Managers can "
                    + "configure project level elements like depots and customers."));
        body.add(
            new MySetupInfoItem(
                "Workers",
                "These are the standard members that will do work in the project.",
                ""
                    + "Workers have permission to view and edit the data elements of the project. "
                    + "Workers do not have access to the project setup menu, but can create and "
                    + "edit things like jobs and charges."));
        body.add(
            new MySetupInfoItem(
                "Customers",
                "Allow your customers to view information in your project.",
                ""
                    + "You can give certain users access to your project as customers. Customer "
                    + "members must be linked to a customer in your project.  These members "
                    + "will be able to view certain elements that are specific to that customer. "
                    + "Customer members can not create or manage any elements in the project."));

        return e;
    }

    @Override
    protected ScControl createListCard()
    {
        MyMemberListView e;
        e = new MyMemberListView();
        e.css().flexChildFiller();
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        getListCard().applyFromModel(getCurrentProject());
    }
}
