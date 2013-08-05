package com.kodemore.servlet.action;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * The single global context.  This is primarily used by a few
 * actions that can safely assume an non-secure context that
 * doesn't display errors to the user.
 */
public class ScGlobalContext
    implements ScActionContextIF
{
    //##################################################
    //# instance
    //##################################################

    public static void install()
    {
        _instance = new ScGlobalContext();
    }

    public static ScActionContextIF getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not installed.");

        return _instance;
    }

    private static ScActionContextIF _instance;

    //##################################################
    //# constructor
    //##################################################

    private ScGlobalContext()
    {
        // private
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public void checkSecurity()
    {
        // no security check
    }

    @Override
    public void handleError(KmApplicationException ex)
    {
        KmLog.error(ex, "Application error in global context.");
    }

    @Override
    public void handleFatal(RuntimeException ex)
    {
        KmLog.fatal(ex, "Fatal error in global context.");
    }
}
