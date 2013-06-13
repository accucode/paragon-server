package com.app.ui.monitor.command;

import com.app.ui.monitor.MyMonitorServletData;

public interface MyMonitorServletCommandIF
{
    String getName();

    String getDescription();

    void handle(MyMonitorServletData data);
}
