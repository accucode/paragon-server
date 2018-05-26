package com.app.ui.page.guide.base;

import com.kodemore.servlet.control.ScDiv;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.utility.MyButtonUrls;
import com.app.utility.MyGlobals;

public abstract class MyAbstractGuide
    extends ScDiv
{
    //##################################################
    //# groups
    //##################################################

    protected MyGuideGroup newSummaryGroup()
    {
        return newSummaryGroup("Summary");
    }

    protected MyGuideGroup newSummaryGroup(String title)
    {
        MyGuideGroup e;
        e = newGroup(title, MyButtonUrls.guideSummary());
        e.setFlavorNormal();
        return e;
    }

    protected MyGuideGroup newListGroup()
    {
        return newListGroup("List");
    }

    protected MyGuideGroup newListGroup(String title)
    {
        MyGuideGroup e;
        e = newGroup(title, MyButtonUrls.guideList());
        e.setFlavorAccent();
        return e;
    }

    protected MyGuideGroup newReportGroup()
    {
        return newReportGroup("Reports");
    }

    protected MyGuideGroup newReportGroup(String title)
    {
        MyGuideGroup e;
        e = newGroup(title, MyButtonUrls.guideChart());
        e.setFlavorDetail();
        return e;
    }

    protected MyGuideGroup newSetupGroup()
    {
        return newSetupGroup("Setup");
    }

    protected MyGuideGroup newSetupGroup(String title)
    {
        MyGuideGroup e;
        e = newGroup(title, MyButtonUrls.guideSetup());
        e.setFlavorSummary();
        return e;
    }

    private MyGuideGroup newGroup(String title, String iconUrl)
    {
        MyGuideGroup e;
        e = new MyGuideGroup();
        e.setTitle(title, iconUrl);
        e.css().flexChildFiller0();

        ScDiv body;
        body = e.getBody();
        body.css().flexColumn().gap20().auto();

        return e;
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected MyProject getCurrentProject()
    {
        return MyGlobals.getCurrentProject();
    }
}
