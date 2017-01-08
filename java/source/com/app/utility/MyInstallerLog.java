package com.app.utility;

import com.kodemore.log.KmLogPrinter;
import com.kodemore.log.KmLogger;

public class MyInstallerLog
    implements KmLogPrinter
{
    //##################################################
    //# variables
    //##################################################

    private KmLogger _logger;

    //##################################################
    //# constructor
    //##################################################

    public MyInstallerLog(Class<?> c)
    {
        _logger = KmLogger.create(c);
    }

    //##################################################
    //# enabled
    //##################################################

    public void enable()
    {
        _logger.enableThread();
    }

    public void disable()
    {
        _logger.disableThread();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void println(String s)
    {
        _logger.info(s);
    }

    @Override
    public void printfln(String s, Object... args)
    {
        _logger.info(s, args);
    }

}
