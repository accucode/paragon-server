package com.app.ui.dashboard.core;

import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

public abstract class MyDashboardPanelRegistry
{
    //##################################################
    //# variables
    //##################################################

    private static final KmMap<MyDashboardPanelType,MyDashboardPanel> _panels = new KmMap<>();

    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        MyDashboardPanelType[] arr = MyDashboardPanelType.values();
        for ( MyDashboardPanelType type : arr )
        {
            MyDashboardPanel panel = type.createPanel();
            if ( panel.hasType(type) )
            {
                _panels.put(type, panel);
                continue;
            }
            throw Kmu.newFatal("Type mismatch, expected(%s), found(%s).", type, panel.getType());
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public static MyDashboardPanel getPanel(MyDashboardPanelType e)
    {
        return _panels.get(e);
    }
}
