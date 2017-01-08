package com.app.ui.dashboard;

import com.kodemore.servlet.control.ScDiv;

import com.app.ui.dashboard.core.MyDashboardPanel;
import com.app.ui.dashboard.core.MyDashboardPanelType;

public class MyEmptyPanel
    extends MyDashboardPanel
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyDashboardPanelType getType()
    {
        return MyDashboardPanelType.Empty;
    }

    @Override
    protected void installPanelOn(ScDiv root)
    {
        root.css().pad20();
        root.addTextSpan("Click the edit icon to configure the dashbaord.").css().italic();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderPanel()
    {
        // none
    }

}
