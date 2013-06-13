package com.app.ui.monitor.command;

import com.app.ui.monitor.MyMonitorServletData;

public class MyMonitorServletPingCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "ping";
    }

    @Override
    public String getDescription()
    {
        return "Return an OK response.";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        data.writeOk();
    }
}
