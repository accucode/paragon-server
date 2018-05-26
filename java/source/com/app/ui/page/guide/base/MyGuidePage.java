package com.app.ui.page.guide.base;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.utility.MyButtonUrls;

public abstract class MyGuidePage
    extends MyPage
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().flexColumn().columnSpacer20().auto();
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
    //# groups
    //##################################################

    protected ScDiv newGroupRow()
    {
        ScDiv row;
        row = getRoot().addDiv();
        row.css().flexChildFiller0().flexRow().rowSpacer20();
        return row;
    }

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

}
