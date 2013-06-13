package com.app.ui.monitor.command;

import com.app.ui.monitor.MyMonitorServletData;

public class MyMonitorServletEchoCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "echo";
    }

    @Override
    public String getDescription()
    {
        return "Return the 'value' parameter.";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        String s = data.getParameter("value");
        if ( s == null )
        {
            data.writeError("Missing parameter: 'value'.");
            return;
        }
        data.writeOk(s);
    }
}
