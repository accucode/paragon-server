package com.app.ui.monitor.command;

import com.app.ui.monitor.MyMonitorServletData;

import com.kodemore.servlet.ScAbstractServlet;

public class MyMonitorServletServletCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "servletSpeed";
    }

    @Override
    public String getDescription()
    {
        return "The average servlet speed (in seconds).";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        data.writeOk(ScAbstractServlet.resetAverageSeconds());
    }
}
