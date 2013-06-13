package com.app.ui.monitor.command;

import com.app.ui.monitor.MyMonitorServletData;

public class MyMonitorServletUsedMemoryCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "usedMemory";
    }

    @Override
    public String getDescription()
    {
        return "Return the amount of used memory (in bytes).";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        Runtime rt = Runtime.getRuntime();
        long value = rt.totalMemory() - rt.freeMemory();
        data.writeOk(value);
    }
}
