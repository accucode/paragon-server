package com.app.utility;

import com.kodemore.log.KmLogPrinter;
import com.kodemore.log.KmLogger;

public class MyInstallerLog
    implements KmLogPrinter
{
    private KmLogger _logger;

    public MyInstallerLog(Class<?> c)
    {
        _logger = KmLogger.create(c);
    }

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
