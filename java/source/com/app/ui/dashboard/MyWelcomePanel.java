package com.app.ui.dashboard;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.utility.Kmu;

import com.app.ui.dashboard.core.MyDashboardPanel;
import com.app.ui.dashboard.core.MyDashboardPanelType;
import com.app.utility.MyConstantsIF;

public class MyWelcomePanel
    extends MyDashboardPanel
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyDashboardPanelType getType()
    {
        return MyDashboardPanelType.Welcome;
    }

    @Override
    protected void installPanelOn(ScDiv root)
    {
        String app = MyConstantsIF.APPLICATION_NAME;
        String msg = Kmu.format("Welcome to %s!", app);

        root.css().pad20();
        root.addText(msg);
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
