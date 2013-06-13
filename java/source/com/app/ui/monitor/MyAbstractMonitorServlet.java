package com.app.ui.monitor;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.ui.monitor.command.MyMonitorServletCommandIF;

public abstract class MyAbstractMonitorServlet
    extends HttpServlet
{
    //##################################################
    //# commands (static)
    //##################################################

    private static List<MyMonitorServletCommandIF> _commands;

    public static void setCommands(List<MyMonitorServletCommandIF> v)
    {
        _commands = v;
    }

    public static List<MyMonitorServletCommandIF> getCommands()
    {
        return _commands;
    }

    private static MyMonitorServletCommandIF getCommand(MyMonitorServletData data)
    {
        String name = data.getCommand();
        if ( name == null )
        {
            data.writeError("Missing 'command' parameter.");
            return null;
        }

        List<MyMonitorServletCommandIF> v = getCommands();
        for ( MyMonitorServletCommandIF e : v )
            if ( e.getName().equals(name) )
                return e;

        data.writeError("Unknown command.");
        return null;
    }

    //##################################################
    //# get / post
    //##################################################

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        handle(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        handle(request, response);
    }

    private void handle(HttpServletRequest request, HttpServletResponse response)
    {
        MyMonitorServletData data;
        data = new MyMonitorServletData(request, response);

        if ( !authenticate(data) )
            return;

        MyMonitorServletCommandIF cmd = getCommand(data);
        if ( cmd == null )
            return;

        cmd.handle(data);
    }

    //##################################################
    //# authenticate
    //##################################################

    private boolean authenticate(MyMonitorServletData data)
    {
        if ( data.hasPassword(getPassword()) )
            return true;

        data.writeError("Authentication Failed");
        return false;
    }

    protected abstract String getPassword();
}
