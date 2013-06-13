package com.app.ui.monitor;

import org.apache.log4j.Logger;

public class MyMonitorServletLog
{
    private static final Logger LOGGER = Logger.getLogger(MyMonitorServletLog.class);

    public static void logError(String msg, Exception ex)
    {
        LOGGER.error(msg, ex);
    }

}
