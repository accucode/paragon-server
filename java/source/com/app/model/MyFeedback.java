package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDate;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyFeedbackBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.model.support.MyPageDomainIF;
import com.app.ui.page.crud.appFeedback.MyFeedbackListPage;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;

public class MyFeedback
    extends MyFeedbackBase
    implements MyTenantDomainIF, MyPageDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFeedback()
    {
        super();
    }

    //##################################################
    //# open
    //##################################################

    @Override
    protected void updateOpen()
    {
        setOpen(getStatus().isOpen());
    }

    @Override
    public String getOpenDays()
    {
        if ( isOpen() )
            return null;

        KmDate opened = getCreatedUtcTs().getDate();
        KmDate closed = getClosedDate();

        return Kmu.format("%s days", opened.getDaysUntil(closed));
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getDomainTitle();
    }

    @Override
    public String getDomainTitle()
    {
        return Kmu.format("%s - %s", getCreatedByFullName(), getPageName());
    }

    @Override
    public String getDomainSubtitle()
    {
        String s;
        s = Kmu.format("%s - %s", getStatusName(), getDescription());
        s = Kmu.truncate(s, 70, true);
        return s;
    }

    @Override
    public String getPageName()
    {
        return Kmu.formatCamelCaseAsCapitalizedWords(getPageKey());
    }

    @Override
    public String getTruncatedDescription()
    {
        return Kmu.truncate(getDescription(), 100);
    }

    //##################################################
    //# email
    //##################################################

    public void sendEmail()
    {
        KmList<String> tos = getProperties().getDeveloperEmails();
        if ( tos.isEmpty() )
            return;

        String from = MyGlobals.getProperties().getSendEmailFromAddress();
        String subject = Kmu.format("%s - New Feedback", MyConstantsIF.APPLICATION_NAME);

        MyEmail e;
        e = new MyEmail();
        e.setFromAddress(from);
        e.addToRecipients(tos);
        e.setSubject(subject);
        e.addTextPart(formatEmailBody());
        e.setStatusReady();
        e.daoAttach();
    }

    private String formatEmailBody()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("New feedback submitted by %s.", getCreatedByFullName());
        out.printfln();
        out.printfln("Tenant: %s", getTenantName());
        out.printfln("Project: %s", getProjectName());
        out.printfln("Page: %s", getPageName());
        out.println();
        out.printfln("Description:");
        out.printfln(getDescription());
        out.printfln();
        out.printfln("For more info, go to... ");
        out.printfln(formatEntryUrl());
        return out.toString();
    }

    //###########################################
    //# page
    //###########################################

    @Override
    public void ajaxEnterPage()
    {
        MyFeedbackListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyFeedbackListPage.getInstance().formatEntryUrlFor(this);
    }

}
