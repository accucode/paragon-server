package com.app.ui.monitor.command;

import java.util.List;

import com.app.ui.monitor.MyMonitorServlet;
import com.app.ui.monitor.MyMonitorServletData;

public class MyMonitorServletHelpCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "help";
    }

    @Override
    public String getDescription()
    {
        return "Print the available commands.";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        List<MyMonitorServletCommandIF> commands = MyMonitorServlet.getCommands();

        int max = 0;
        for ( MyMonitorServletCommandIF e : commands )
        {
            String s = e.getName();
            int n = s.length();
            if ( n > max )
                max = n;
        }

        String eol = "\r\n";

        StringBuilder out;
        out = new StringBuilder();
        out.append(eol);

        for ( MyMonitorServletCommandIF e : commands )
        {
            out.append(e.getName());

            int n = max - e.getName().length();
            for ( int i = 0; i < n; i++ )
                out.append(" ");

            out.append(" : ");
            out.append(e.getDescription());
            out.append(eol);
        }

        data.writeOk(out.toString());
    }
}
