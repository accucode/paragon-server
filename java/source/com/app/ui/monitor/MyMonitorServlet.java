package com.app.ui.monitor;

import java.util.ArrayList;
import java.util.List;

import com.app.ui.monitor.command.MyMonitorServletCommandIF;
import com.app.ui.monitor.command.MyMonitorServletEchoCommand;
import com.app.ui.monitor.command.MyMonitorServletFreeMemoryCommand;
import com.app.ui.monitor.command.MyMonitorServletHelpCommand;
import com.app.ui.monitor.command.MyMonitorServletHibernateQueryCommand;
import com.app.ui.monitor.command.MyMonitorServletJdbcQueryCommand;
import com.app.ui.monitor.command.MyMonitorServletPingCommand;
import com.app.ui.monitor.command.MyMonitorServletServletCommand;
import com.app.ui.monitor.command.MyMonitorServletTotalMemoryCommand;
import com.app.ui.monitor.command.MyMonitorServletUsedMemoryCommand;

/**
 * A simple servlet that supports various hooks for external monitoring.  E.g.:
 *
 * http://host/app/monitor?password=12345&command=ping
 * http://host/app/monitor?password=12345&command=help
 */
public class MyMonitorServlet
    extends MyAbstractMonitorServlet
{
    static
    {
        List<MyMonitorServletCommandIF> v = new ArrayList<>();

        v.add(new MyMonitorServletPingCommand());
        v.add(new MyMonitorServletEchoCommand());
        v.add(new MyMonitorServletHelpCommand());

        v.add(new MyMonitorServletFreeMemoryCommand());
        v.add(new MyMonitorServletUsedMemoryCommand());
        v.add(new MyMonitorServletTotalMemoryCommand());

        v.add(new MyMonitorServletServletCommand());
        v.add(new MyMonitorServletJdbcQueryCommand());
        v.add(new MyMonitorServletHibernateQueryCommand());

        setCommands(v);
    }

    @Override
    protected String getPassword()
    {
        return "12345";
    }

}
