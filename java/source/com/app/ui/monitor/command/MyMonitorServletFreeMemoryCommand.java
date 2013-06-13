package com.app.ui.monitor.command;

import com.app.ui.monitor.MyMonitorServletData;

public class MyMonitorServletFreeMemoryCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "freeMemory";
    }

    @Override
    public String getDescription()
    {
        return "Return the amount of free memory (in bytes).";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        long value = Runtime.getRuntime().freeMemory();
        data.writeOk(value);
    }
}
