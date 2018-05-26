package com.app.ui.page.guide;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.project.MyProjectBuilder;

public class MyProjectDetailsSetupGuidePage
    extends MyAbstractSetupGuidePage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectDetailsSetupGuidePage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectDetailsSetupGuidePage();
    }

    public static MyProjectDetailsSetupGuidePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private MyCrudFrame<MyTenant,MyProject> _view;

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "Project";
    }

    @Override
    protected ScPage getPreviousPage()
    {
        return null;
    }

    @Override
    protected ScPage getNextPage()
    {
        return MyMemberSetupGuidePage.getInstance();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installInstructionsOn(ScDiv body)
    {
        body.add(newInfoSection());
        body.add(
            newDetailsSection("View and configure additional details for your project.", true));
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
                "Project Details",
                "Setup additional details about your project.",
                "Now that the project has been created, you can optionally configure additional "
                    + "details like your business hours, project contacts, and shipping details. "
                    + "view the sections below for additional information."));
        body.add(
            new MySetupInfoItem(
                "Business Hours",
                "Configure customer business hours for your project.",
                "You have the option to specify custom business hours for your project. By "
                    + "default, business hours are Monday through Friday, 9:00 am to 5:00 pm. "
                    + "Your business hours will be displayed on your project calendar."));
        body.add(
            new MySetupInfoItem(
                "Images",
                "Upload your company's logos for use in various documents.",
                "You can add your company's logo to your project. Once attached to the project, "
                    + "these images will be available for use in any email templates or blurbs "
                    + "(document templates). You can upload separate header and footer images."));
        body.add(
            new MySetupInfoItem(
                "Contacts",
                "These are the people who you want contacted about your project.",
                "Your project contacts are those people who you want informed about things "
                    + "happening in your project.  Each project contact has the option to be sent "
                    + "notifications about jobs in the system, and may be CC'ed on emails sent. "
                    + "You may also specify a single Support Contact for your project who will "
                    + "be the contacted if anyone encounters any issues using your project."));

        return e;
    }

    @Override
    protected ScControl createDetailsCard()
    {
        MyProjectBuilder b;
        b = new MyProjectBuilder();

        _view = b.getFrame();
        _view.css().flexChildFiller();
        return _view;
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

    @Override
    protected void ajaxPrintDetailsCard()
    {
        MyProject e = getCurrentProject();
        _view.setDefaultViewCard(e);

        super.ajaxPrintDetailsCard();
    }
}
