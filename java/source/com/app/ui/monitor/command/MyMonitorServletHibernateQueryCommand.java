package com.app.ui.monitor.command;

import com.app.filter.MyUserFilter;
import com.app.model.MyUser;
import com.app.ui.monitor.MyMonitorServletData;

public class MyMonitorServletHibernateQueryCommand
    implements MyMonitorServletCommandIF
{
    @Override
    public String getName()
    {
        return "hibernateQuery";
    }

    @Override
    public String getDescription()
    {
        return "Return the time is takes to run a simple Hibernate query (in seconds).";
    }

    @Override
    public void handle(MyMonitorServletData data)
    {
        try
        {
            MyUser u = new MyUserFilter().toDaoFilter().findFirst();

            if ( u == null )
                data.writeError("Cannot find user");
            else
                data.writeOkSeconds();
        }
        catch ( Exception ex )
        {
            if ( data.isOpen() )
                data.writeError(ex.getMessage());
        }
    }

}
