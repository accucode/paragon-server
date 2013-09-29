package com.app.ui.monitor.command;

import com.app.property.MyPropertyRegistry;
import com.app.ui.monitor.MyMonitorServletData;
import com.app.utility.MyGlobals;

import com.kodemore.database.KmDatabaseTool;

public class MyMonitorServletJdbcQueryCommand
    implements MyMonitorServletCommandIF
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "jdbcQuery";
    }

    @Override
    public String getDescription()
    {
        return "Return the time is takes to run a simple Jdbc query (in seconds).";
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    public void handle(MyMonitorServletData data)
    {
        KmDatabaseTool tool = null;
        try
        {
            String schema;
            schema = getProperties().getDatabaseSchema();

            tool = new KmDatabaseTool();
            tool.open();
            tool.useSchema(schema);
            tool.getSingleInteger("select uid from user limit 1");

            data.writeOkSeconds();
        }
        catch ( Exception ex )
        {
            if ( data.isOpen() )
                data.writeError(ex.getMessage());
        }
        finally
        {
            if ( tool != null )
                tool.closeSafely();
        }
    }

    //##################################################
    //# support
    //##################################################

    private MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }
}
