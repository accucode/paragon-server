package com.app.ui.monitor.command;

import com.app.ui.monitor.MyMonitorServletData;

public class MyMonitorServletTotalMemoryCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "totalMemory";
    }

    @Override
    public String getDescription()
    {
        return "Return the amount of total memory (in bytes).";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        long value = Runtime.getRuntime().totalMemory();
        data.writeOk(value);
    }
}
